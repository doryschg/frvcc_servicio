package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.consolidar;

import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

import java.math.BigDecimal;


public class ConsolidarConsolidacionCommand implements Command {
    private final String id;
    private final Long ifcAgente;
    private final Long nitAgente;
    private final String razonSocialAgente;
    private final Long administracion;
    private final Integer gestion;
    private final Integer periodo;
    private final Long usuarioConsolidador;
    private final String loginUsuarioConsolidador;
    private final String nombreConsolidador;
    private final Long usuarioRegistro;



    private ConsolidarConsolidacionCommand(Builder builder) {
        this.id = builder.id;
        this.ifcAgente = builder.ifcAgente;
        this.nitAgente = builder.nitAgente;
        this.razonSocialAgente = builder.razonSocialAgente;
        this.administracion = builder.administracion;
        this.gestion = builder.gestion;
        this.periodo = builder.periodo;
        this.usuarioConsolidador = builder.usuarioConsolidador;
        this.loginUsuarioConsolidador = builder.loginUsuarioConsolidador;
        this.nombreConsolidador = builder.nombreConsolidador;
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

    public String getRazonSocialAgente() {
        return razonSocialAgente;
    }

    public Long getAdministracion() {
        return administracion;
    }

    public Integer getGestion() {
        return gestion;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public Long getUsuarioConsolidador() {
        return usuarioConsolidador;
    }

    public String getLoginUsuarioConsolidador() {
        return loginUsuarioConsolidador;
    }

    public String getNombreConsolidador() {
        return nombreConsolidador;
    }

    public Long getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public static Builder newConsolidarConsolidacionCommand() {
        return new Builder();
    }


    public static final class Builder {
        private  String id;
        private  Long ifcAgente;
        private  Long nitAgente;
        private  String razonSocialAgente;
        private  Long administracion;
        private  Integer gestion;
        private  Integer periodo;
        private  Long usuarioConsolidador;
        private  String loginUsuarioConsolidador;
        private  String nombreConsolidador;
        private  Long usuarioRegistro;

        private Builder() {
        }

        public ConsolidarConsolidacionCommand build() {
            return new ConsolidarConsolidacionCommand(this);
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


        public Builder razonSocialAgente(String razonSocialAgente) {
            this.razonSocialAgente = razonSocialAgente;
            return this;
        }


        public Builder administracion(Long administracion) {
            this.administracion = administracion;
            return this;
        }

        public Builder gestion(Integer gestion) {
            this.gestion = gestion;
            return this;
        }

        public Builder periodo(Integer periodo) {
            this.periodo = periodo;
            return this;
        }

        public Builder usuarioConsolidador(Long usuarioConsolidador) {
            this.usuarioConsolidador = usuarioConsolidador;
            return this;
        }

        public Builder loginUsuarioConsolidador(String loginUsuarioConsolidador) {
            this.loginUsuarioConsolidador = loginUsuarioConsolidador;
            return this;
        }

        public Builder nombreConsolidador(String nombreConsolidador) {
            this.nombreConsolidador = nombreConsolidador;
            return this;
        }

        public Builder usuarioRegistro(Long usuarioRegistro) {
            this.usuarioRegistro = usuarioRegistro;
            return this;
        }
    }
}
