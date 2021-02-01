package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.decrementar_importe_notas;


import java.math.BigDecimal;

import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraDesAsignadaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraDesAsociadaLibroDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra_nota.CompraNotaDesAsociadaLibroDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({CompraNotaDesAsociadaLibroDomainEvent.class})
public class DecrementarImporteLibroOnCompraNotaDesAsociada {

    public final LibroDecrementarImporteNotas decrementarImporte;

    public DecrementarImporteLibroOnCompraNotaDesAsociada(LibroDecrementarImporteNotas decrementarImporte) {
        this.decrementarImporte = decrementarImporte;
    }

    @EventListener
    public void on(CompraNotaDesAsociadaLibroDomainEvent event){
        LibroId libroId = new LibroId(event.getLibroId());
        BigDecimal importeTotalNota = event.getImporteTotalNota();
        CompraNotaId compraNotaId = new CompraNotaId(event.aggregateId());
        BigDecimal creditoFiscalNota=event.getCreditoFiscalNota();
        LibroUsuarioUltimaModificacion usuarioUltimaModificacion = new LibroUsuarioUltimaModificacion(event.getUsuarioUltimaModificacion());
        decrementarImporte.decrementar(libroId, importeTotalNota, creditoFiscalNota,compraNotaId,usuarioUltimaModificacion);

    }
  }
