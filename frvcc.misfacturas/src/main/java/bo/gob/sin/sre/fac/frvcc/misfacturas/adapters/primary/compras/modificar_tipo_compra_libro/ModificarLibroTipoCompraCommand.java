package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.compras.modificar_tipo_compra_libro;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;


public class ModificarLibroTipoCompraCommand implements Command {
    private final String id;
    private final String tipoCompraId;
    private final Long usuarioUltimaModificacion;

    public ModificarLibroTipoCompraCommand(String id,
    		
    		String tipoCompraId,
            Long usuarioUltimaModificacion
            ) {
        this.id = id;
        this.tipoCompraId=tipoCompraId;
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
        
    }

    private ModificarLibroTipoCompraCommand(Builder builder) {
        this.id = builder.id;
        this.tipoCompraId=builder.tipoCompraId;
        this.usuarioUltimaModificacion = builder.usuarioUltimaModificacion;
    }

    public static Builder newModificarCompraCommand() {
        return new Builder();
    }

    public String getId() {
		return id;
	}

	public String gettipoCompraId() {
		return tipoCompraId;
	}

	public Long getUsuarioUltimaModificacion() {
		return usuarioUltimaModificacion;
	}

	public static final class Builder { 
        private String id;
        private String tipoCompraId;
        private Long usuarioUltimaModificacion;

        private Builder() {
        }

        public ModificarLibroTipoCompraCommand build() {
            return new ModificarLibroTipoCompraCommand(this);
        }

		public Builder id(String id) {
			this.id = id;
			return this;
		}
		
		public Builder tipoCompraId(String tipoCompraId) {
			this.tipoCompraId = tipoCompraId;
			return this;
		}

		public Builder usuarioUltimaModificacion(Long usuarioUltimaModificacion) {
			this.usuarioUltimaModificacion = usuarioUltimaModificacion;
			return this;
		}
    
    }
}
