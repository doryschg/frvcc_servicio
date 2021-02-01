package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.registro_libro_compras;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CompraRegistroLibroCommand implements Command {
    private final String id;
    private final Long nitProveedor;
    private final Long numeroFactura;
    private final String numeroDui;
    private final String codigoAutorizacion;
    private final LocalDate fechaFactura;
    private final BigDecimal importeTotalCompra;
    private final BigDecimal importeNoSujetoCf;
    private final BigDecimal descuento;
    private final BigDecimal importeBaseCf;
    private final String codigoControl;
    private final String tipoDocumentoCliente;
    private final String numeroDocumentoCliente;
    private final String complementoDocumentoCliente;
    private final String nombreCliente;
    private final String origenId;
    private final Long usuarioRegistro;

    private CompraRegistroLibroCommand(Builder builder) {
        this.id = builder.id;
        this.nitProveedor = builder.nitProveedor;
        this.numeroFactura = builder.numeroFactura;
        this.numeroDui = builder.numeroDui;
        this.codigoAutorizacion = builder.codigoAutorizacion;
        this.fechaFactura = builder.fechaFactura;
        this.importeTotalCompra = builder.importeTotalCompra;
        this.importeNoSujetoCf = builder.importeNoSujetoCf;
        this.descuento= builder.descuento;
        this.importeBaseCf = builder.importeBaseCf;
        this.codigoControl = builder.codigoControl;
        this.tipoDocumentoCliente = builder.tipoDocumentoCliente;
        this.numeroDocumentoCliente = builder.numeroDocumentoCliente;
        this.complementoDocumentoCliente = builder.complementoDocumentoCliente;
        this.nombreCliente = builder.nombreCliente;
        this.origenId = builder.origenId;
        this.usuarioRegistro = builder.usuarioRegistro;
        
    }

	public String getId() {
		return id;
	}

	public Long getNitProveedor() {
		return nitProveedor;
	}

	public Long getNumeroFactura() {
		return numeroFactura;
	}
	
	public String getNumeroDui() {
		return numeroDui;
	}

	public String getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	public LocalDate getFechaFactura() {
		return fechaFactura;
	}

	public BigDecimal getImporteTotalCompra() {
		return importeTotalCompra;
	}

	public BigDecimal getimporteNoSujetoCf() {
		return importeNoSujetoCf;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public BigDecimal getImporteBaseCf() {
		return importeBaseCf;
	}

	public String getCodigoControl() {
		return codigoControl;
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

	public String getNombreCliente() {
		return nombreCliente;
	}

	public String getOrigenId() {
		return origenId;
	}

	public Long getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public static Builder newCompraRegistroLibroCommand() {
		return new Builder();
	}


    public static final class Builder {
        private String id;
        private Long nitProveedor;
        private Long numeroFactura;
        private String numeroDui;
        private String codigoAutorizacion;
        private LocalDate fechaFactura;
        private  BigDecimal importeTotalCompra;
        private BigDecimal importeNoSujetoCf;
        private BigDecimal descuento;
        private BigDecimal importeBaseCf;
        private String codigoControl;
        private String tipoDocumentoCliente;
        private String numeroDocumentoCliente;
        private String complementoDocumentoCliente;
        private String nombreCliente;
        private String origenId;
        private Long usuarioRegistro;
             
        private Builder() {
        }

        public CompraRegistroLibroCommand build() {
            return new CompraRegistroLibroCommand(this);
        }

		public Builder id(String id) {
			this.id = id;
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
		
		public Builder numeroDui(String numeroDui) {
			this.numeroDui = numeroDui;
			 return this;
		}

		public Builder codigoAutorizacion(String codigoAutorizacion) {
			this.codigoAutorizacion = codigoAutorizacion;
			 return this;
		}

		public Builder fechaFactura(LocalDate fechaFactura) {
			this.fechaFactura = fechaFactura;
			 return this;
		}

		public Builder importeTotalCompra(BigDecimal importeTotalCompra) {
			this.importeTotalCompra = importeTotalCompra;
			 return this;
		}

		public Builder importeNoSujetoCf(BigDecimal importeNoSujetoCf) {
			this.importeNoSujetoCf = importeNoSujetoCf;
			 return this;
		}

		public Builder descuento(BigDecimal descuento) {
			this.descuento = descuento;
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

		public Builder nombreCliente(String nombreCliente) {
			this.nombreCliente = nombreCliente;
			 return this;
		}

		public Builder origenId(String origenId) {
			this.origenId = origenId;
			 return this;
		}

		public Builder usuarioRegistro(Long usuarioRegistro) {
			this.usuarioRegistro = usuarioRegistro;
			 return this;
		}    
    }
}
