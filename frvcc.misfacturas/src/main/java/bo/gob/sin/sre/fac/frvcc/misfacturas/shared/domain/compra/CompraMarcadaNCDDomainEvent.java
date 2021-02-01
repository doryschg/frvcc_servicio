package bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraEstadoCompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraFechaUltimaModificacion;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraTipoObservacionId;
import bo.gob.sin.sre.fac.frvcc.shared.model.Utils;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;

public final class CompraMarcadaNCDDomainEvent extends DomainEvent {
    
	private final String estadoCompraId;
	private final String tipoObservacionId;
    private final Long usuarioUltimaModificacion;
    private final LocalDateTime fechaUltimaModificacion;
   
	public CompraMarcadaNCDDomainEvent(String aggregateId, String estadoCompraId,String tipoObservacionId,
			Long usuarioUltimaModificacion,LocalDateTime fechaUltimaModificacion) {
		super(aggregateId);
		this.estadoCompraId = estadoCompraId;
		this.tipoObservacionId = tipoObservacionId;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;

	}

	public CompraMarcadaNCDDomainEvent(String aggregateId, String eventId, String occurredOn, 
			String estadoCompraId,String tipoObservacionId,
			Long usuarioUltimaModificacion,LocalDateTime fechaUltimaModificacion) {
		super(aggregateId, eventId, occurredOn);
		this.estadoCompraId = estadoCompraId;
		this.tipoObservacionId = tipoObservacionId;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;
		this.fechaUltimaModificacion = fechaUltimaModificacion;
		
	}

    public CompraMarcadaNCDDomainEvent() {
    	this.estadoCompraId = null;
		this.tipoObservacionId = null;
		this.usuarioUltimaModificacion = null;
		this.fechaUltimaModificacion = null;
    }

   

	@Override
    public String eventName() {
        return "compra.marcada_ncd";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>(){{
        	put("estadoCompraId", estadoCompraId);
            put("tipoObservacionId", tipoObservacionId);
            put("usuarioUltimaModificacion", usuarioUltimaModificacion);
            put("fechaUltimaModificacion",  Utils.localDateTimeToString(fechaUltimaModificacion));
        }} ;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new CompraMarcadaNCDDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String)body.get("estadoCompraId"),
                (String)body.get("tipoObservacionId"),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()), 
                Utils.stringToLocalDateTime(body.get("fechaUltimaModificacion").toString())
        		);

    }

	public String getEstadoCompraId() {
		return estadoCompraId;
	}

	public String getTipoObservacionId() {
		return tipoObservacionId;
	}

	public Long getUsuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public LocalDateTime getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}
    
}
