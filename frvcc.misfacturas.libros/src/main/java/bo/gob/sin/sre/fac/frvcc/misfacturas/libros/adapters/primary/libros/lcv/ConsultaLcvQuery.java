package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.lcv;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.Query;

public final class ConsultaLcvQuery implements Query{
	
    private final Long nit;
    private final Integer gestion;

    public ConsultaLcvQuery(Long nit, Integer gestion) {
		this.nit = nit;
		this.gestion = gestion;
	}

	public Long getNit() {
		return nit;
	}

	public Integer getGestion() {
		return gestion;
	}

    
    

}
