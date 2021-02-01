package bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios;

public enum EstadoformularioId {
	  	REGISTRADO("REG"),
	    DECLARADO("DEC"),
	    ACEPTADO("ACP"),
	CONSOLIDADO("ACP"),
	RECTIFICADO("REC"),
	    RECHAZADO("RECH");
	    
	    private final String value;


	   private EstadoformularioId(String value) {
	        this.value = value;
	    }
	    public  String value(){
	        return value;
	    }
}


