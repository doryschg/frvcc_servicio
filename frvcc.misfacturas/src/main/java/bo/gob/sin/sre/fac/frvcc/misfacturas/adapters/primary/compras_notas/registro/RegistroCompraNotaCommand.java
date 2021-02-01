package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.registro;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

import java.math.BigDecimal;
import java.time.LocalDate;


public class RegistroCompraNotaCommand implements Command {

    private final String id;
    private final Long nitProveedor;
    private final Long numeroNota;
    private final String codigoAutorizacion;
    private final LocalDate fechaNota;
    private final BigDecimal importeTotalNota;
    private final String codigoControlNota;
    private final String compraId;
    private final String tipoDocumentoCliente;
    private final String numeroDocumentoCliente;
    private final String complementoDocumentoCliente;
    private final String nombreCliente;
    private final String origenId;
    private final Long usuarioRegistro;

    private RegistroCompraNotaCommand(Builder builder) {
        this.id = builder.id;
        this.nitProveedor = builder.nitProveedor;
        this.numeroNota = builder.numeroNota;
        this.codigoAutorizacion = builder.codigoAutorizacion;
        this.fechaNota = builder.fechaNota;
        this.importeTotalNota = builder.importeTotalNota;
        this.codigoControlNota = builder.codigoControlNota;
        this.compraId=builder.compraId;
        this.tipoDocumentoCliente = builder.tipoDocumentoCliente;
        this.numeroDocumentoCliente = builder.numeroDocumentoCliente;
        this.complementoDocumentoCliente = builder.complementoDocumentoCliente;
        this.nombreCliente = builder.nombreCliente;
        this.origenId = builder.origenId;
        this.usuarioRegistro = builder.usuarioRegistro;
    }



	public String id() {
		return id;
	}

	public Long nitProveedor() {
		return nitProveedor;
	}

	public Long numeroNota() {
		return numeroNota;
	}

	public String codigoAutorizacion() {
		return codigoAutorizacion;
	}

	public LocalDate fechaNota() {
		return fechaNota;
	}

	public BigDecimal importeTotalNota() {
		return importeTotalNota;
	}

	public String codigoControlNota() {
		return codigoControlNota;
	}
	
	public String compraId() {
		return compraId;
	}

	public String tipoDocumentoCliente() {
		return tipoDocumentoCliente;
	}

	public String numeroDocumentoCliente() {
		return numeroDocumentoCliente;
	}

	public String complementoDocumentoCliente() {
		return complementoDocumentoCliente;
	}

	public String nombreCliente() {
		return nombreCliente;
	}

	public String origenId() {
		return origenId;
	}

	public Long usuarioRegistro() {
		return usuarioRegistro;
	}



	public static Builder newRegistroCompraNotaCommand() {
        return new Builder();
    }


    public static final class Builder {
        private String id;
        private Long nitProveedor;
        private Long numeroNota;
        private String codigoAutorizacion;
        private LocalDate fechaNota;
        private BigDecimal importeTotalNota;
        private String codigoControlNota;
        private String compraId;
        private String tipoDocumentoCliente;
        private String numeroDocumentoCliente;
        private String complementoDocumentoCliente;
        private String nombreCliente;
        private String origenId;
        private Long usuarioRegistro;

        private Builder() {
        }

        public RegistroCompraNotaCommand build() {
            return new RegistroCompraNotaCommand(this);
        }

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder nitProveedor(Long nitProveedor) {
			this.nitProveedor = nitProveedor;
			return this;
		}

		public Builder numeroNota(Long numeroNota) {
			this.numeroNota = numeroNota;
			return this;
		}

		public Builder codigoAutorizacion(String codigoAutorizacion) {
			this.codigoAutorizacion = codigoAutorizacion;
			return this;
		}

		public Builder fechaNota(LocalDate fechaNota) {
			this.fechaNota = fechaNota;
			return this;
		}

		public Builder importeTotalNota(BigDecimal importeTotalNota) {
			this.importeTotalNota = importeTotalNota;
			return this;
		}

		public Builder codigoControlNota(String codigoControlNota) {
			this.codigoControlNota = codigoControlNota;
			return this;
		}

		public Builder compraId(String compraId) {
			this.compraId = compraId;
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