package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios;




import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Response;
import bo.gob.sin.str.cmsj.mapl.dto.ListaMensajesAplicacion;

public final class FormularioResponse extends ListaMensajesAplicacion implements Response {
   private final FormularioResponseGenerico formularioResponse;

    public FormularioResponse(FormularioResponseGenerico formularioResponse) {
        this.formularioResponse = formularioResponse;
    }

    public FormularioResponseGenerico getFormularioResponse() {
        return formularioResponse;
    }
}
