package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.incrementar_importe;


import java.math.BigDecimal;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.secundary.libros.LibroRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class LibroIncrementarImporte {
	private static final Logger LOG= LoggerFactory.getLogger(LibroIncrementarImporte.class);
    private final LibroRepository repository;
    private final EventBus eventBus;

    public LibroIncrementarImporte(LibroRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }


    public void incremento(LibroId pLibroId,
                           BigDecimal pImporteBaseCf, BigDecimal pCreditoFiscal,
                           LibroUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                           CompraId pCompraId,BigDecimal importeTotalCompra,
                           CompraMarcaEspecialId marcaEspecialId,String modalidadId) {

        repository.search(pLibroId).ifPresent(
                libro ->
                        libro.compras()
                                .stream()
                                .filter(compraId -> compraId.value().equals(pCompraId.value()))
                                .findFirst()
                                .ifPresentOrElse(compraId -> Function.identity(),
                                        () -> {
                                        	try {
//                                        		LOG.info("determinacion {}", formulario.determinacionPago().value());
                                        		LOG.info("credito fiscal a añadir {}", pCreditoFiscal);
                                            libro.incrementoImporte(pImporteBaseCf, pCreditoFiscal, pUsuarioUltimaModificacion,
                                            		pCompraId,importeTotalCompra,marcaEspecialId,modalidadId);
//                                        	LOG.info("credito fiscal sumado{}", libro.determinacionPago().value());

                                            repository.save(libro);
                                        	} catch (Exception excepcion) {
                                    	  		LOG.error(excepcion.getCause().toString(), excepcion);
											}
                                            eventBus.publish(libro.pullDomainEvents());
                                        }));
    }
}
