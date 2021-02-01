package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.incrementar_importe_notas;



import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraAsignadaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraAsociadaLibroDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra_nota.CompraNotaAsociadaLibroDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({CompraNotaAsociadaLibroDomainEvent.class})
public class IncrementarImporteLibroOnCompraNotaAsignada {
    public final LibroIncrementarImporteNota incrementarImporte;

    public IncrementarImporteLibroOnCompraNotaAsignada(LibroIncrementarImporteNota incrementarImporte) {
        this.incrementarImporte = incrementarImporte;
    }

    @EventListener
    public void on(CompraNotaAsociadaLibroDomainEvent event){
        LibroId libroId = new LibroId(event.getLibroId());

        LibroUsuarioUltimaModificacion usuarioUltimaModificacion = new LibroUsuarioUltimaModificacion(event.getUsuarioUltimaModificacion());
        incrementarImporte.incremento(libroId, event.getImporteTotalNota(), event.getCreditoFiscalNota(), usuarioUltimaModificacion,
                new CompraNotaId(event.aggregateId()));

    }
}

