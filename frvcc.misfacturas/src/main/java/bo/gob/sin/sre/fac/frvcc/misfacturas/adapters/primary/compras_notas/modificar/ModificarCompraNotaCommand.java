package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras_notas.modificar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ModificarCompraNotaCommand implements Command {
    private final String id;
    private final Long nitProveedor;
    private final Long numeroNota;
    private final String codigoAutorizacion;
    private final LocalDate fechaNota;
    private final BigDecimal importeTotalNota;
    private final String codigoControlNota;
    private final String origenId;
    private final Long usuarioUltimaModificacion;
   

	public ModificarCompraNotaCommand(String id, 
			Long nitProveedor, 
			Long numeroNota,
			String codigoAutorizacion,
			LocalDate fechaNota, 
			BigDecimal importeTotalNota, 
			String codigoControlNota, 
			String origenId,
			Long usuarioUltimaModificacion) {
		this.id = id;
		this.nitProveedor = nitProveedor;
		this.numeroNota = numeroNota;
		this.codigoAutorizacion = codigoAutorizacion;
		this.fechaNota = fechaNota;
		this.importeTotalNota = importeTotalNota;
		this.codigoControlNota = codigoControlNota;
		this.origenId = origenId;
		this.usuarioUltimaModificacion = usuarioUltimaModificacion;

	}

    private ModificarCompraNotaCommand(Builder builder) {
        this.id = builder.id;
        this.nitProveedor = builder.nitProveedor;
        this.numeroNota = builder.numeroNota;
        this.codigoAutorizacion = builder.codigoAutorizacion;
        this.fechaNota = builder.fechaNota;
        this.importeTotalNota = builder.importeTotalNota;
        this.codigoControlNota = builder.codigoControlNota;
        this.origenId = builder.origenId;
        this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion; 
    }

    public static Builder newModificarCompraNotaCommand() {
        return new Builder();
    }

 

    public String getId() {
		return id;
	}

	public Long getNitProveedor() {
		return nitProveedor;
	}

	public Long getNumeroNota() {
		return numeroNota;
	}

	public String getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	public LocalDate getFechaNota() {
		return fechaNota;
	}

	public BigDecimal getImporteTotalNota() {
		return importeTotalNota;
	}

	public String getCodigoControlNota() {
		return codigoControlNota;
	}

	public String getOrigenId() {
		return origenId;
	}

	public Long getUsuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	
	public static final class Builder {
               
        private String id;
        private Long nitProveedor;
        private Long numeroNota;
        private String codigoAutorizacion;
        private LocalDate fechaNota;
        private BigDecimal importeTotalNota;
        private String codigoControlNota;
        private String origenId;
        private Long usuarioUltimaModificacion;

        private Builder() {
        }

        public ModificarCompraNotaCommand build() {
            return new ModificarCompraNotaCommand(this);
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

		public Builder origenId(String origenId) {
			this.origenId = origenId;
			return this;
		}

		public Builder usuarioUltimaModificacion(Long usuarioUltimaModificacion) {
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			return this;
		}

    }
}
