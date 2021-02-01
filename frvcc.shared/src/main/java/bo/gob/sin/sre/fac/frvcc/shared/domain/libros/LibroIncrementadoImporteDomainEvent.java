package bo.gob.sin.sre.fac.frvcc.shared.domain.libros;


import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;

public final class LibroIncrementadoImporteDomainEvent extends DomainEvent {
    private final BigDecimal totalCompras;
    private final Integer cantidadCompras;
    private final Long usuarioUltimaModificacion;
    private final Integer periodoMes;
    private final Integer periodoAnio;
    private final String nombreLibro;
    private final String compraId;
    
    
    
    public LibroIncrementadoImporteDomainEvent(){
        this.cantidadCompras = null;
        this.totalCompras = null;
        this.usuarioUltimaModificacion = null;
        this.periodoMes=null;
        this.periodoAnio=null;
        this.nombreLibro=null;
        this.compraId=null;
        
    }

    public LibroIncrementadoImporteDomainEvent(String aggregateId, BigDecimal totalCompras,
                                                    Integer cantidadCompras,Long usuarioUltimaModificacion
                                                    ,Integer periodoMes,Integer periodoAnio,String nombreLibro
                                                    ,String compraId) {
        super(aggregateId);
        this.totalCompras = totalCompras;
        this.cantidadCompras = cantidadCompras;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.periodoMes=periodoMes;
        this.periodoAnio=periodoAnio;
        this.nombreLibro=nombreLibro;
        this.compraId=compraId;
    }

    public BigDecimal totalCompras() {
        return totalCompras;
    }

    public Integer cantidadCompras() {
        return cantidadCompras;
    }

    public Long usuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }
    public Integer periodoMes()
    {
    	return periodoMes;
    }
    public Integer periodoAnio()
    {
    	return periodoAnio;
    }
    public String nombreLibro()
    {
    	return nombreLibro;
    }
    public String compraId()
    {
    	return compraId;
    }

    public LibroIncrementadoImporteDomainEvent(String aggregateId, String eventId,
                                                    String occurredOn, BigDecimal totalCompras,
                                                    Integer cantidadCompras, Long usuarioUltimaModificacion
                                                    ,Integer periodoMes,Integer periodoAnio,String nombreLibro
                                                    ,String compraId) {
        super(aggregateId, eventId, occurredOn);
        this.totalCompras = totalCompras;
        this.cantidadCompras = cantidadCompras;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.periodoMes=periodoMes;
        this.periodoAnio=periodoAnio;
        this.nombreLibro=nombreLibro;
        this.compraId=compraId;
    }

    @Override
    public String eventName() {
        return "libro.incrementar_importe";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>(){{
            put("totalCompras",totalCompras());
            put("cantidadCompras",cantidadCompras());
            put("usuarioUltimaModificacion",usuarioUltimaModificacion());
            put("periodoMes", periodoMes());
            put("periodoAnio", periodoAnio());
            put("nombreLibro", nombreLibro());
            put("compraId", compraId());

        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new LibroIncrementadoImporteDomainEvent(aggregateId, eventId, occurredOn,
                new BigDecimal(body.get("totalCompras").toString()),
                (Integer) body.get("cantidadCompras"),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                (Integer) body.get("periodoMes"),
                (Integer) body.get("periodoAnio"),
                (String) body.get("nombreLibro"),
                (String) body.get("compraId"));
        	

    }
}
