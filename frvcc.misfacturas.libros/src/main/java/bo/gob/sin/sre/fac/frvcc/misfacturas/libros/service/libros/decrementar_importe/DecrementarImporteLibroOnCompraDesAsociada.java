package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.decrementar_importe;


import java.math.BigDecimal;

import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraDesAsignadaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraDesAsociadaLibroDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({CompraDesAsociadaLibroDomainEvent.class})
public class DecrementarImporteLibroOnCompraDesAsociada {

    public final LibroDecrementarImporte decrementarImporte;

    public DecrementarImporteLibroOnCompraDesAsociada(LibroDecrementarImporte decrementarImporte) {
        this.decrementarImporte = decrementarImporte;
    }

    @EventListener
    public void on(CompraDesAsociadaLibroDomainEvent event){
//        LibroId libroId = new LibroId(event.getLibroId());
//        BigDecimal importeBaseCf = event.getImporteBaseCf();
//        CompraId compraId = new CompraId(event.aggregateId());
//        BigDecimal creditoFiscal=event.getCreditoFiscal();
//        CompraMarcaEspecialId marcaEspecialId=new CompraMarcaEspecialId(event.getMarcaEspecialId());
//        LibroUsuarioUltimaModificacion usuarioUltimaModificacion = new LibroUsuarioUltimaModificacion(event.getUsuarioUltimaModificacion());
//        decrementarImporte.decrementar(libroId, importeBaseCf, creditoFiscal,compraId,usuarioUltimaModificacion
//        		,event.getImporteTotalCompra(),marcaEspecialId,event.getModalidadId());

    }
  }
