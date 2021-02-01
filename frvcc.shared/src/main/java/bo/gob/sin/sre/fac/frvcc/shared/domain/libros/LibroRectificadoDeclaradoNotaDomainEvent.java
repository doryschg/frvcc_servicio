package bo.gob.sin.sre.fac.frvcc.shared.domain.libros;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

public class LibroRectificadoDeclaradoNotaDomainEvent extends DomainEvent {

    private final Long usuarioUltimaModificacion;
    private final List<String> notasId;
    private final String idLibroRectificado;

    public LibroRectificadoDeclaradoNotaDomainEvent() {
        this.notasId = null;
        this.usuarioUltimaModificacion = null;
        this.idLibroRectificado=null;
    }

    public LibroRectificadoDeclaradoNotaDomainEvent(String aggregateId,
                                          Long usuarioUltimaModificacion,   
                                          List<String> notasId,
                                          String idLibroRectificado) {
        super(aggregateId);
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.notasId = notasId;
        this.idLibroRectificado=idLibroRectificado;
    }

    public LibroRectificadoDeclaradoNotaDomainEvent(String aggregateId, String eventId, String occurredOn,
                                          Long usuarioUltimaModificacion,  
                                          List<String> notasId,
                                          String idFormularioRectificado) {
        super(aggregateId, eventId, occurredOn);
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.notasId = notasId;
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
            put("notasId", notasId().toArray());
            put("idLibroRectificado", idLibroRectificado());
        }};
    }

    @SuppressWarnings("unchecked")
	@Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new LibroRectificadoDeclaradoNotaDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()), 
                (List<String>) body.get("notasId"),
                (String)body.get("idLibroRectificado")
                );
    }

    public List<String> notasId() {
        return notasId;
    }

	public Long usuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public String idLibroRectificado() {
		return idLibroRectificado;
	}
    
}