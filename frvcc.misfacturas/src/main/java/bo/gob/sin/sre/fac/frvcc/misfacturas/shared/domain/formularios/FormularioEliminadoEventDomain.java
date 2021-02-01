package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.formularios;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

public class FormularioEliminadoEventDomain extends DomainEvent {

    private final LocalDateTime fechaUltimaModificacion;
    private final Long usuarioUltimaModificacion;
    private final BigDecimal totalComprasCfIpn;
    private final BigDecimal totalComprasCfOtras;
    private final BigDecimal totalComprasSdCf;
    private final List<String> comprasId;

    public FormularioEliminadoEventDomain() {
        this.comprasId = null;
        this.fechaUltimaModificacion = null;
        this.usuarioUltimaModificacion = null;
        this.totalComprasCfIpn= null;
        this.totalComprasCfOtras=null;
        this.totalComprasSdCf=null;
    }

    public FormularioEliminadoEventDomain(String aggregateId,
                                         LocalDateTime fechaUltimaModificacion,
                                         Long usuarioUltimaModificacion,
                                         BigDecimal totalComprasCfIpn,
                                         BigDecimal totalComprasCfOtras,
                                         BigDecimal totalComprasSdCf,
                                          List<String> comprasId) {
        super(aggregateId);
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.totalComprasCfIpn= totalComprasCfIpn;
        this.totalComprasCfOtras=totalComprasCfOtras;
        this.totalComprasSdCf= totalComprasSdCf;
        this.comprasId = comprasId;
    }

    public FormularioEliminadoEventDomain(String aggregateId, String eventId, String occurredOn,
                                         LocalDateTime fechaUltimaModificacion,
                                         Long usuarioUltimaModificacion, 
                                         BigDecimal totalComprasCfIpn,
                                         BigDecimal totalComprasCfOtras,
                                         BigDecimal totalComprasSdCf,
                                         List<String> comprasId) {
        super(aggregateId, eventId, occurredOn);
        this.fechaUltimaModificacion = fechaUltimaModificacion;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.totalComprasCfIpn= totalComprasCfIpn;
        this.totalComprasCfOtras=totalComprasCfOtras;
        this.totalComprasSdCf= totalComprasSdCf;
        this.comprasId = comprasId;
    }
	
	
	@Override
	public String eventName() {
		return "formularios.eliminado";
	}

	@Override
	public HashMap<String, Serializable> toPrimitives() {
		 return new HashMap<String, Serializable>() {{
	            put("fechaUltimaModificacion", Utils.localDateTimeToString(fechaUltimaModificacion()));
	            put("usuarioUltimaModificacion", usuarioUltimaModificacion());
	            put("totalComprasCfIpn", totalComprasCfIpn());
	            put("totalComprasCfOtras", totalComprasCfOtras());
	            put("totalComprasSdCf", totalComprasSdCf());            
	            put("comprasId", comprasId().toArray());
	        }};
	}

	@Override
	public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId,
			String occurredOn) {
		return new FormularioEliminadoEventDomain(
                aggregateId,
                eventId,
                occurredOn,
                Utils.stringToLocalDateTime((String)(body.get("fechaUltimaModificacion"))),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                (BigDecimal) body.get("totalComprasCfIpn"),
                (BigDecimal) body.get("totalComprasCfOtras"),
                (BigDecimal) body.get("totalComprasSdCf"),     
                (List<String>) body.get("comprasId")
                );
	}
	
	
    public List<String> comprasId() {
        return comprasId;
    }

    public LocalDateTime fechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public Long usuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }
    
    public BigDecimal totalComprasCfIpn() {
    	return totalComprasCfIpn;
    }
    
    
    public BigDecimal totalComprasCfOtras() {
    	return totalComprasCfOtras;
    }
    
    
    public BigDecimal totalComprasSdCf() {
    	return totalComprasSdCf;
    }
}
