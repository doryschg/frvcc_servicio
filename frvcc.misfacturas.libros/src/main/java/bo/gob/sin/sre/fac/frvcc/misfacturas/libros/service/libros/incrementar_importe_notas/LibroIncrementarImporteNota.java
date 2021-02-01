package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.incrementar_importe_notas;


import java.math.BigDecimal;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.use.ports.secundary.libros.LibroRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public class LibroIncrementarImporteNota {
	private static final Logger LOG= LoggerFactory.getLogger(LibroIncrementarImporteNota.class);
    private final LibroRepository repository;
    private final EventBus eventBus;

    public LibroIncrementarImporteNota(LibroRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }


    public void incremento(LibroId pLibroId,
                           BigDecimal pImporteTotalNota, BigDecimal pCreditoFiscalNota,
                           LibroUsuarioUltimaModificacion pUsuarioUltimaModificacion,
                           CompraNotaId pCompraNotaId) {

        repository.search(pLibroId).ifPresent(
                libro ->
                        libro.comprasNotas()
                                .stream()
                                .filter(compraNotaId -> compraNotaId.value().equals(pCompraNotaId.value()))
                                .findFirst()
                                .ifPresentOrElse(compraNotaId -> Function.identity(),
                                        () -> {
                                        	try {
//                                        		LOG.info("determinacion {}", formulario.determinacionPago().value());
                                        		LOG.info("credito fiscal a añadir {}", pCreditoFiscalNota);
                                            libro.incrementoImporteNotas(pImporteTotalNota, pCreditoFiscalNota, pUsuarioUltimaModificacion, pCompraNotaId);
//                                        	LOG.info("credito fiscal sumado{}", libro.determinacionPago().value());

                                            repository.save(libro);
                                        	} catch (Exception excepcion) {
                                    	  		LOG.error(excepcion.getCause().toString(), excepcion);
											}
                                            eventBus.publish(libro.pullDomainEvents());
                                        }));
    }
}
