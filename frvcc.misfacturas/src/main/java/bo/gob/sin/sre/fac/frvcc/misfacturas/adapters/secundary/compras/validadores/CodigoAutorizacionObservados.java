package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras.validadores;

import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.VerificaCodigoAutorizacionRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.validadores.FieldValidator;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.io.Serializable;
import java.util.HashMap;
@Service
public final class CodigoAutorizacionObservados implements FieldValidator {
    private final VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository;

    public CodigoAutorizacionObservados(VerificaCodigoAutorizacionRepository verificaCodigoAutorizacionRepository) {
        this.verificaCodigoAutorizacionRepository = verificaCodigoAutorizacionRepository;
    }

    @Override
    public Boolean isValid(String fieldName, HashMap<String, Serializable> fields) {

        return null;
    }

    @Override
    public Integer errorMessage(String fieldName) {
        return null;
    }
}
