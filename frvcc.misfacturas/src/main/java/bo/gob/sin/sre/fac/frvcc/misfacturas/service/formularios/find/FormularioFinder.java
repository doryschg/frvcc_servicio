package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.find;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.FormularioResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioNotExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;




@Service
public final class FormularioFinder {
    private final FormularioRepository repository;

    public FormularioFinder(FormularioRepository repository) {
        this.repository = repository;
    }

    public FormularioResponse find(FormularioId id) {
        Formulario formulario = repository.search(id).orElseThrow(() -> new FormularioNotExist(id));
        return new FormularioResponse(FormularioResponseGenerico.fromAggregate(formulario));
    }

}
