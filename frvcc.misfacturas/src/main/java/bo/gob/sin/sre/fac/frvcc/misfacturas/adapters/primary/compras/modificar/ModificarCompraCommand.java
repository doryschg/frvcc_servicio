package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.modificar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ModificarCompraCommand implements Command {
    private final String id;
    private final LocalDate fechaFactura;
    private final Long nitProveedor;
    private final Long numeroFactura;
    private final String codigoAutorizacion;
    private final BigDecimal importeTotalCompra;
    private final BigDecimal importeBaseCf;
    private final String codigoControl;
    private final Long usuarioUltimaModificacion;
    private final String origenId;

    public ModificarCompraCommand(String id,
                                  LocalDate fechaFactura,
                                  Long nitProveedor,
                                  Long numeroFactura,
                                  String codigoAutorizacion,
                                  BigDecimal importeTotalCompra, BigDecimal importeBaseCf,
                                  String codigoControl,
                                  Long usuarioUltimaModificacion,
                                  String origenId) {
        this.id = id;
        this.fechaFactura = fechaFactura;
        this.nitProveedor = nitProveedor;
        this.numeroFactura = numeroFactura;
        this.codigoAutorizacion = codigoAutorizacion;
        this.importeTotalCompra = importeTotalCompra;
        this.importeBaseCf = importeBaseCf;
        this.codigoControl = codigoControl;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        this.origenId = origenId;
    }

    private ModificarCompraCommand(Builder builder) {
        this.id = builder.id;
        this.fechaFactura = builder.fechaFactura;
        this.nitProveedor = builder.nitProveedor;
        this.numeroFactura = builder.numeroFactura;
        this.codigoAutorizacion = builder.codigoAutorizacion;
        this.importeTotalCompra = builder.importeTotalCompra;
        this.importeBaseCf = builder.importeBaseCf;
        this.codigoControl = builder.codigoControl;
        this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
        this.origenId = builder.origenId;
    }

    public BigDecimal getImporteTotalCompra() {
        return importeTotalCompra;
    }

    public static Builder newModificarCompraCommand() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public Long getNitProveedor() {
        return nitProveedor;
    }

    public Long getNumeroFactura() {
        return numeroFactura;
    }

    public String getCodigoAutorizacion() {
        return codigoAutorizacion;
    }

    public BigDecimal getImporteBaseCf() {
		return importeBaseCf;
	}

	public String getCodigoControl() {
        return codigoControl;
    }

    public Long getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public String getOrigenId() {
        return origenId;
    }


    public static final class Builder {
        private String id;
        private LocalDate fechaFactura;
        private Long nitProveedor;
        private Long numeroFactura;
        private String codigoAutorizacion;
        private BigDecimal importeBaseCf;
        private BigDecimal importeTotalCompra;
        private String codigoControl;
        private Long usuarioUltimaModificacion;
        private String origenId;

        private Builder() {
        }

        public ModificarCompraCommand build() {
            return new ModificarCompraCommand(this);
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder fechaFactura(LocalDate fechaFactura) {
            this.fechaFactura = fechaFactura;
            return this;
        }

        public Builder nitProveedor(Long nitProveedor) {
            this.nitProveedor = nitProveedor;
            return this;
        }

        public Builder numeroFactura(Long numeroFactura) {
            this.numeroFactura = numeroFactura;
            return this;
        }

        public Builder codigoAutorizacion(String codigoAutorizacion) {
            this.codigoAutorizacion = codigoAutorizacion;
            return this;
        }

        public Builder importeBaseCf(BigDecimal importeBaseCf) {
            this.importeBaseCf = importeBaseCf;
            return this;
        }

        public Builder importeTotalCompra(BigDecimal importeTotalCompra) {
            this.importeTotalCompra = importeTotalCompra;
            return this;
        }

        public Builder codigoControl(String codigoControl) {
            this.codigoControl = codigoControl;
            return this;
        }

        public Builder usuarioUltimaModificacion(Long usuarioUltimaModificacion) {
            this.usuarioUltimaModificacion = usuarioUltimaModificacion;
            return this;
        }

        public Builder origenId(String origenId) {
            this.origenId = origenId;
            return this;
        }
    }
}
