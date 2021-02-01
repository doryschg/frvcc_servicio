package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.decrementar_importe;


import java.math.BigDecimal;

import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraDesAsignadaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;


public class DecrementarImporteFormularioOnCompraAsignada {

    public final FormularioDecrementarImporteServiceImpl decrementarImporte;

    public DecrementarImporteFormularioOnCompraAsignada(FormularioDecrementarImporteServiceImpl decrementarImporte) {
        this.decrementarImporte = decrementarImporte;
    }

    public void on(CompraDesAsignadaDomainEvent event){
        FormularioId formularioId = new FormularioId(event.getFormularioId());
       BigDecimal importeBaseCf = event.getImporteBaseCf();
       CompraId compraId = new CompraId(event.aggregateId());
      BigDecimal creditoFiscal=event.getCreditoFiscal();
      CompraMarcaEspecialId marcaEspecialId=new CompraMarcaEspecialId(event.getMarcaEspecialId());
        FormularioUsuarioUltimaModificacion usuarioUltimaModificacion = new FormularioUsuarioUltimaModificacion(event.getUsuarioUltimaModificacion());
       decrementarImporte.decrementar(formularioId, importeBaseCf, creditoFiscal,compraId,usuarioUltimaModificacion,
       		event.getImporteTotalCompra(),marcaEspecialId,event.getModalidadId());

    }
  }
