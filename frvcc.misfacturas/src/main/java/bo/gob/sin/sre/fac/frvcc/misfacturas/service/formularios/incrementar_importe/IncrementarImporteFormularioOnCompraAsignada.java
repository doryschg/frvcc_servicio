package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.incrementar_importe;



import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraAsignadaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;


public class IncrementarImporteFormularioOnCompraAsignada {
    public final FormularioIncrementarImporteServiceImpl incrementarImporte;

    public IncrementarImporteFormularioOnCompraAsignada(FormularioIncrementarImporteServiceImpl incrementarImporte) {
        this.incrementarImporte = incrementarImporte;
    }

    public void on(CompraAsignadaDomainEvent event){
       FormularioId formularioId = new FormularioId(event.getFormularioId());
       CompraMarcaEspecialId marcaEspecialId=new CompraMarcaEspecialId(event.getMarcaEspecialId());
       FormularioUsuarioUltimaModificacion usuarioUltimaModificacion = new FormularioUsuarioUltimaModificacion(event.getUsuarioUltimaModificacion());
        incrementarImporte.incremento(formularioId, event.getImporteBaseCf(), event.getCreditoFiscal(), usuarioUltimaModificacion,
               new CompraId(event.aggregateId()),event.getImporteTotalCompra(),marcaEspecialId,event.getModalidadId());

    }
}

