package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.decrementar_importe;


import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.secundary.libros.LibroRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;


@Service
public class LibroDecrementarImporte {
	private static final Logger LOG= LoggerFactory.getLogger(LibroDecrementarImporte.class);
    private final LibroRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;

    public LibroDecrementarImporte(LibroRepository repository, EventBus eventBus, QueryBus queryBus) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.queryBus = queryBus;
    }

    public void decrementar(LibroId pLibroId,
                            BigDecimal pImporteBaseCf,
                            BigDecimal pCreditoFiscal,
                            CompraId pCompraId,
                            LibroUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                            BigDecimal importeTotalCompra,
                            CompraMarcaEspecialId marcaEspecialId,String modalidadId) {
        repository.search(pLibroId).ifPresent(
                libro ->
                        libro.compras()
                                .stream()
                                .filter(compraId -> compraId.value().equals(pCompraId.value()))
                                .findFirst()
                                .ifPresent(compraId -> {
                                    try {
									LOG.info("credito fiscal a decrementar {}", pCreditoFiscal);
                                	libro.decrementoImporte(pImporteBaseCf, pCreditoFiscal, pUsuarioUltimaModificacion, pCompraId
                                			,importeTotalCompra,marcaEspecialId,modalidadId);
                                    LOG.info("importe despues de decrementas{}", libro.totalCompras().value());
                                    repository.save(libro);
                                    } catch (Exception excepcion) {
                            	  		LOG.error(excepcion.getCause().toString(), excepcion);
									}
                                    eventBus.publish(libro.pullDomainEvents());
                                })
        );
    }
}
