package bo.gob.sin.sre.fac.frvcc.misfacturas.compras.application.asignar;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.asignar.AsignarCompraCommandImpl;
import bo.gob.sin.sre.fac.frvcc.misfacturas.compras.domain.*;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraUsuarioUltimaModificacion;

public class AsignarBeneficiarioFacturaCommandMother {
    public static AsignarCompraCommandImpl create(CompraId id,
                                              CompraFormularioId formularioId, CompraUsuarioUltimaModificacion usuarioUltimaModificacion){
        return new AsignarCompraCommandImpl(id.value(),formularioId.value(),usuarioUltimaModificacion.value());
    }

    public static AsignarCompraCommandImpl random(){
        return create(CompraIdMother.random(),CompraFormularioIdMother.random(), CompraUsuarioUltimaModificacionMother.random());
    }


}
