package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RegistroCompraCommand   implements Command {
    private final String id;
    private final LocalDate fechaFactura;
    private final Long nitProveedor;

    private final Long numeroFactura;
    private final String codigoAutorizacion;
    private final BigDecimal importeTotalCompra;
    private final BigDecimal importeBaseCf;
    private final String codigoControl;
    private final Long usuarioRegistro;
    private final String nombreCliente;
    private final String tipoDocumentoCliente;
    private final String numeroDocumentoCliente;
    private final String complementoDocumentoCliente;
    private final String origenId;

    private RegistroCompraCommand(Builder builder) {
        this.id = builder.id;
        this.fechaFactura = builder.fechaFactura;
        this.nitProveedor = builder.nitProveedor;
        this.numeroFactura = builder.numeroFactura;
        this.codigoAutorizacion = builder.codigoAutorizacion;
        this.importeTotalCompra = builder.importeTotalCompra;
        this.importeBaseCf = builder.importeBaseCf;
        this.codigoControl = builder.codigoControl;
        this.usuarioRegistro = builder.usuarioRegistro;
        this.nombreCliente = builder.nombreCliente;
        this.tipoDocumentoCliente = builder.tipoDocumentoCliente;
        this.numeroDocumentoCliente = builder.numeroDocumentoCliente;
        this.complementoDocumentoCliente = builder.complementoDocumentoCliente;
        this.origenId = builder.origenId;
    }

    public BigDecimal getImporteTotalCompra() {
        return importeTotalCompra;
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

    public Long getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getTipoDocumentoCliente() {
        return tipoDocumentoCliente;
    }

    public String getNumeroDocumentoCliente() {
        return numeroDocumentoCliente;
    }

    public String getComplementoDocumentoCliente() {
        return complementoDocumentoCliente;
    }

    public String getOrigenId() {
        return origenId;
    }

	public static Builder newRegistroCompraCommand() {
        return new Builder();
    }


    public static final class Builder {
        private String id;
        private LocalDate fechaFactura;
        private Long nitProveedor;
        private Long numeroFactura;
        private String codigoAutorizacion;
        private BigDecimal importeBaseCf;
        private String codigoControl;
        private Long usuarioRegistro;
        private String nombreCliente;
        private String tipoDocumentoCliente;
        private String numeroDocumentoCliente;
        private String complementoDocumentoCliente;
        private String origenId;
        private BigDecimal importeTotalCompra;

        private Builder() {
        }

        public RegistroCompraCommand build() {
            return new RegistroCompraCommand(this);
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

        public Builder importeTotalCompra(BigDecimal importeTotalCompra) {
            this.importeTotalCompra = importeTotalCompra;
            return this;
        }
        public Builder importeBaseCf(BigDecimal importeBaseCf) {
            this.importeBaseCf = importeBaseCf;
            return this;
        }
        public Builder codigoControl(String codigoControl) {
            this.codigoControl = codigoControl;
            return this;
        }

        public Builder usuarioRegistro(Long usuarioRegistro) {
            this.usuarioRegistro = usuarioRegistro;
            return this;
        }

        public Builder nombreCliente(String nombreCliente) {
            this.nombreCliente = nombreCliente;
            return this;
        }

        public Builder tipoDocumentoCliente(String tipoDocumentoCliente) {
            this.tipoDocumentoCliente = tipoDocumentoCliente;
            return this;
        }

        public Builder numeroDocumentoCliente(String numeroDocumentoCliente) {
            this.numeroDocumentoCliente = numeroDocumentoCliente;
            return this;
        }

        public Builder complementoDocumentoCliente(String complementoDocumentoCliente) {
            this.complementoDocumentoCliente = complementoDocumentoCliente;
            return this;
        }

        public Builder origenId(String origenId) {
            this.origenId = origenId;
            return this;
        }
    }
}
