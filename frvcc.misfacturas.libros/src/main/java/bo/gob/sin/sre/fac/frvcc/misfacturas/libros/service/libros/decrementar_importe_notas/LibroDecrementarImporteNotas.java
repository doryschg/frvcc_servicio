package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.decrementar_importe_notas;


import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.secundary.libros.LibroRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;


@Service
public class LibroDecrementarImporteNotas {
	private static final Logger LOG= LoggerFactory.getLogger(LibroDecrementarImporteNotas.class);
    private final LibroRepository repository;
    private final EventBus eventBus;
    private final QueryBus queryBus;

    public LibroDecrementarImporteNotas(LibroRepository repository, EventBus eventBus, QueryBus queryBus) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.queryBus = queryBus;
    }

    public void decrementar(LibroId pLibroId,
                            BigDecimal pImporteTotalNota,
                            BigDecimal pCreditoFiscalNota,
                            CompraNotaId pCompraNotaId,
                            LibroUsuarioUltimaModificacion pUsuarioUltimaModificacion) {
        repository.search(pLibroId).ifPresent(
                libro ->
                        libro.comprasNotas()
                                .stream()
                                .filter(compraNotaId -> compraNotaId.value().equals(pCompraNotaId.value()))
                                .findFirst()
                                .ifPresent(compraNotaId -> {
                                    try {
									LOG.info("credito fiscal a decrementar {}", pCreditoFiscalNota);
                                	libro.decrementoImporteNotas(pImporteTotalNota, pCreditoFiscalNota, pUsuarioUltimaModificacion, pCompraNotaId);
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
