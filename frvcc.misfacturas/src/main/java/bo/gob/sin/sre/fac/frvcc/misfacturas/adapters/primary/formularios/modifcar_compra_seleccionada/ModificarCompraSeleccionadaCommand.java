package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.modifcar_compra_seleccionada;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class ModificarCompraSeleccionadaCommand implements Command {
    private String id;
    private LocalDate fechaFactura;
    private BigDecimal importeTotalCompra;
    private String codigoControl;
    private Long usuarioId;
    private String origenId;


    public ModificarCompraSeleccionadaCommand(String id,  LocalDate fechaFactura, BigDecimal importeTotalCompra, String codigoControl, Long usuarioId, String origenId) {
        this.id = id;
        this.fechaFactura = fechaFactura;
        this.importeTotalCompra = importeTotalCompra;
        this.codigoControl = codigoControl;
        this.usuarioId = usuarioId;
        this.origenId = origenId;
    }

    public String getId() {
        return id;
    }



    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public BigDecimal getImporteTotalCompra() {
        return importeTotalCompra;
    }

    public String getCodigoControl() {
        return codigoControl;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public String getOrigenId() {
        return origenId;
    }
}
