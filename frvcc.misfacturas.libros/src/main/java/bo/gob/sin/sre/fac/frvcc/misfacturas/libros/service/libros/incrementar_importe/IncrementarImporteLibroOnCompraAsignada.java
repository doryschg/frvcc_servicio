package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.service.libros.incrementar_importe;



import org.springframework.context.event.EventListener;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.model.libros.LibroUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraMarcaEspecialId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioUsuarioUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraAsignadaDomainEvent;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraAsociadaLibroDomainEvent;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({CompraAsociadaLibroDomainEvent.class})
public class IncrementarImporteLibroOnCompraAsignada {
    public final LibroIncrementarImporte incrementarImporte;

    public IncrementarImporteLibroOnCompraAsignada(LibroIncrementarImporte incrementarImporte) {
        this.incrementarImporte = incrementarImporte;
    }

    @EventListener
    public void on(CompraAsociadaLibroDomainEvent event){
//        LibroId libroId = new LibroId(event.getLibroId());
//        CompraMarcaEspecialId marcaEspecialId=new CompraMarcaEspecialId(event.getMarcaEspecialId());
//        LibroUsuarioUltimaModificacion usuarioUltimaModificacion = new LibroUsuarioUltimaModificacion(event.getUsuarioUltimaModificacion());
//        incrementarImporte.incremento(libroId, event.getImporteBaseCf(), event.getCreditoFiscal(), usuarioUltimaModificacion,
//                new CompraId(event.aggregateId()),event.getImporteTotalCompra(),marcaEspecialId,event.getModalidadId());

    }
}

