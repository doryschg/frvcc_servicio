package bo.gob.sin.sre.fac.frvcc.shared.model;

import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;

import java.util.HashMap;
import java.util.List;

public abstract class DomainError extends RuntimeException {

    private final String errorCode;
    private final String id;
    private final String errorMessage;
    private final ValidationResponse hashMapErrorCodigo;
    private final HashMap<String, ValidationResponse> listaErrores;



    public DomainError(String errorCode, String id, String errorMessage,ValidationResponse hashMapErrorCodigo) {
        super(errorMessage);

        this.errorCode    = errorCode;
        this.id = id;
        this.errorMessage = errorMessage;
        this.hashMapErrorCodigo = hashMapErrorCodigo;
        this.listaErrores = null;
    }

    public DomainError(String errorCode, String errorMessage) {
        super(errorMessage);
        this.id = null;
        this.errorCode    = errorCode;
        this.errorMessage = errorMessage;
        this.hashMapErrorCodigo = null;
        this.listaErrores = null;
    }



    public DomainError(String id, ValidationResponse hashMapErrorCodigo) {
        super("");
        this.hashMapErrorCodigo = hashMapErrorCodigo;
        this.id = id;
        this.errorCode    = null;
        this.errorMessage = null;
        this.listaErrores = null;
    }

    public DomainError(HashMap<String, ValidationResponse> listaErrores) {
        super("");
        this.errorCode    = null;
        this.id = null;
        this.errorMessage = null;
        this.hashMapErrorCodigo = null;
        this.listaErrores = listaErrores;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ValidationResponse getHashMapErrorCodigo() {
        return hashMapErrorCodigo;
    }

    public String getId() {
        return id;
    }

    public HashMap<String, ValidationResponse> getListaErrores() {
        return listaErrores;
    }
}
