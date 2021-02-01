package bo.gob.sin.sre.fac.frvcc.shared.domain.libros;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

public class LibroRectificadoDeclaradoCompraDomainEvent extends DomainEvent {

    private final Long usuarioUltimaModificacion;
    private final List<String> comprasId;
    private final String idLibroRectificado;

    public LibroRectificadoDeclaradoCompraDomainEvent() {
        this.comprasId = null;
        this.usuarioUltimaModificacion = null;
        this.idLibroRectificado=null;
    }

    public LibroRectificadoDeclaradoCompraDomainEvent(String aggregateId,
                                          Long usuarioUltimaModificacion,   
                                          List<String> comprasId,
                                          String idLibroRectificado) {
        super(aggregateId);
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.comprasId = comprasId;
        this.idLibroRectificado=idLibroRectificado;
    }

    public LibroRectificadoDeclaradoCompraDomainEvent(String aggregateId, String eventId, String occurredOn,
                                          Long usuarioUltimaModificacion,  
                                          List<String> comprasId,
                                          String idFormularioRectificado) {
        super(aggregateId, eventId, occurredOn);
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.comprasId = comprasId;
        this.idLibroRectificado=idFormularioRectificado;
    }

    @Override
    public String eventName() {
        return "habilitacion.rectificacion.libro.compra";
    }

    @SuppressWarnings("serial")
	@Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            
            put("usuarioUltimaModificacion", usuarioUltimaModificacion());
            put("comprasId", comprasId().toArray());
            put("idLibroRectificado", idLibroRectificado());
        }};
    }

    @SuppressWarnings("unchecked")
	@Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new LibroRectificadoDeclaradoCompraDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()), 
                (List<String>) body.get("comprasId"),
                (String)body.get("idLibroRectificado")
                );
    }

    public List<String> comprasId() {
        return comprasId;
    }

	public Long usuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public String idLibroRectificado() {
		return idLibroRectificado;
	}
    
}