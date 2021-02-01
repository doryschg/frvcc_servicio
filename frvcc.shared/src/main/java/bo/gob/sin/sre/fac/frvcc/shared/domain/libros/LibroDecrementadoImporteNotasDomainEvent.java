package bo.gob.sin.sre.fac.frvcc.shared.domain.libros;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.DomainEvent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;

public final class LibroDecrementadoImporteNotasDomainEvent extends DomainEvent {
    private final BigDecimal totalComprasNotas;
    private final Integer cantidadComprasNotas;
    private final Long usuarioUltimaModificacion;
    private final Integer periodoMes;
    private final Integer periodoAnio;
    private final String nombreLibro;
    private final String compraNotaId;


    public LibroDecrementadoImporteNotasDomainEvent(){
        this.totalComprasNotas = null;
        this.cantidadComprasNotas = null;
        this.usuarioUltimaModificacion = null;
        this.periodoMes=null;
        this.periodoAnio=null;
        this.nombreLibro=null;
        this.compraNotaId=null;
    }
    public LibroDecrementadoImporteNotasDomainEvent(String aggregateId, BigDecimal totalCompras, Integer cantidadCompras, Long usuarioUltimaModificacion
    		,Integer periodoMes,Integer periodoAnio,String nombreLibro
            ,String compraNotaId) {
        super(aggregateId);
        this.totalComprasNotas = totalCompras;
        this.cantidadComprasNotas = cantidadCompras;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.periodoMes=periodoMes;
        this.periodoAnio=periodoAnio;
        this.nombreLibro=nombreLibro;
        this.compraNotaId=compraNotaId;
    }

    public BigDecimal totalComprasNotas() {
        return totalComprasNotas;
    }

    public Integer cantidadComprasNotas() {
        return cantidadComprasNotas;
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
    public String compraNotaId()
    {
    	return compraNotaId;
    }
    public LibroDecrementadoImporteNotasDomainEvent(String aggregateId, String eventId,
                                                    String occurredOn, BigDecimal totalCompras,
                                                    Integer cantidadCompras, Long usuarioUltimaModificacion
                                                    ,Integer periodoMes,Integer periodoAnio,String nombreLibro
                                                    ,String compraNotaId) {
        super(aggregateId, eventId, occurredOn);
        this.totalComprasNotas = totalCompras;
        this.cantidadComprasNotas = cantidadCompras;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.periodoMes=periodoMes;
        this.periodoAnio=periodoAnio;
        this.nombreLibro=nombreLibro;
        this.compraNotaId=compraNotaId;
    }

    @Override
    public String eventName() {
        return "libro.decrementado_importe_notas";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>(){{
            put("totalComprasNotas",totalComprasNotas());
            put("cantidadComprasNotas",cantidadComprasNotas());
            put("usuarioUltimaModificacion",usuarioUltimaModificacion());
            put("periodoMes", periodoMes());
            put("periodoAnio", periodoAnio());
            put("nombreLibro", nombreLibro());
            put("compraNotaId", compraNotaId());

        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new LibroDecrementadoImporteNotasDomainEvent(aggregateId, eventId, occurredOn,
                new BigDecimal(body.get("totalComprasNotas").toString()),
                (Integer) body.get("cantidadComprasNotas"),
                Long.parseLong(body.get("usuarioUltimaModificacion").toString()),
                (Integer) body.get("periodoMes"),
                (Integer) body.get("periodoAnio"),
                (String) body.get("nombreLibro"),
                (String) body.get("compraNotaId"));
    }
}
