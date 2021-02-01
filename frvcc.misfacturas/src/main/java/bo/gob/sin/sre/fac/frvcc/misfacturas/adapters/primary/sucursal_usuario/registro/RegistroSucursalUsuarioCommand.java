package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.registro;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;


public class RegistroSucursalUsuarioCommand implements Command {
    private final String id;
    private final Long ifcAgente;
    private final Long nitAgente;
    private final Integer nroSucursal;
    private final Long usuarioReceptor;
    private final String loginUsuarioReceptor;
    private final String nombreUsuarioReceptor;
    private final Long usuarioRegistro;

    private RegistroSucursalUsuarioCommand(Builder builder) {
        this.id = builder.id;
        this.ifcAgente=builder.ifcAgente;
        this.nitAgente = builder.nitAgente;
        this.nroSucursal = builder.nroSucursal;
        this.usuarioReceptor= builder.usuarioReceptor;
        this.loginUsuarioReceptor=builder.loginUsuarioReceptor;
        this.nombreUsuarioReceptor = builder.nombreUsuarioReceptor;
        this.usuarioRegistro = builder.usuarioRegistro;

    }

    public String getId() {
        return id;
    }

    public Long getIfcAgente() {
        return ifcAgente;
    }

    public Long getNitAgente() {
        return nitAgente;
    }

    public Integer getNroSucursal() {
        return nroSucursal;
    }

    public Long getUsuarioReceptor() {
        return usuarioReceptor;
    }

    public String getLoginUsuarioReceptor() {
        return loginUsuarioReceptor;
    }

    public String getNombreUsuarioReceptor() {
        return nombreUsuarioReceptor;
    }

    public Long getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public static Builder newRegistrosucursalUsuarioCommand() {
        return new Builder();
    }


    public static final class Builder {
        private String id;
        private  Long ifcAgente;
        private  Long nitAgente;
        private  Integer nroSucursal;
        private  Long usuarioReceptor;
        private  String loginUsuarioReceptor;
        private  String nombreUsuarioReceptor;
        private  Long usuarioRegistro;

        private Builder() {
        }

        public RegistroSucursalUsuarioCommand build() {
            return new RegistroSucursalUsuarioCommand(this);
        }

        
      
        public Builder id(String id) {
            this.id = id;
            return this;
        }



        public Builder ifcAgente(Long ifcAgente) {
            this.ifcAgente = ifcAgente;
            return this;
        }

        public Builder nitAgente(Long nitAgente) {
            this.nitAgente = nitAgente;
            return this;
        }

        public Builder nroSucursal(Integer nroSucursal) {
            this.nroSucursal = nroSucursal;
            return this;
        }

        public Builder usuarioReceptor(Long usuarioReceptor) {
            this.usuarioReceptor = usuarioReceptor;
            return this;
        }

        public Builder loginUsuarioReceptor(String loginUsuarioReceptor) {
            this.loginUsuarioReceptor = loginUsuarioReceptor;
            return this;
        }

        public Builder nombreUsuarioReceptor(String nombreUsuarioReceptor) {
            this.nombreUsuarioReceptor = nombreUsuarioReceptor;
            return this;
        }

        public Builder usuarioRegistro(Long usuarioRegistro) {
            this.usuarioRegistro = usuarioRegistro;
            return this;
        }
    }
}
