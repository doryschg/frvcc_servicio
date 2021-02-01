package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.*;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.Command;

import java.math.BigDecimal;
import java.math.BigInteger;


public class RegistroConsolidacionCommand implements Command {
    private final String id;
    private final Long ifcAgente;
    private final Long nitAgente;
    private final String razonSocialAgente;
    private final Integer sucursal;
    private final String direccionSucursal;
    private final String departamentoSucursal;
    private final Long administracion;
    private final Integer gestion;
    private final Integer periodo;
    private final Long cantidadFormularios;
    private final Integer totalCantidadFacturas;
    private final Integer totalCantidadOtrasFacturas;
    private final Integer totalCantidad7rgFacturas;
    private final BigInteger totalImporteFacturas;
    private final BigInteger totalImporteOtrasFacturas;
    private final BigInteger totalImporte7rgFacturas;
    private final BigInteger totalDeterminacionPagoCuenta;
    private final BigInteger totalPagoCuenta;
    private final Long usuarioConsolidador;
    private final String loginUsuarioConsolidador;
    private final String nombreConsolidador;
    private final Long usuarioRegistro;



    private RegistroConsolidacionCommand(Builder builder) {
        this.id = builder.id;
        this.ifcAgente = builder.ifcAgente;
        this.nitAgente = builder.nitAgente;
        this.razonSocialAgente = builder.razonSocialAgente;
        this.sucursal = builder.sucursal;
        this.direccionSucursal = builder.direccionSucursal;
        this.departamentoSucursal = builder.departamentoSucursal;
        this.administracion = builder.administracion;
        this.gestion = builder.gestion;
        this.periodo = builder.periodo;
        this.cantidadFormularios = builder.cantidadFormularios;
        this.totalCantidadFacturas = builder.totalCantidadFacturas;
        this.totalCantidadOtrasFacturas = builder.totalCantidadOtrasFacturas;
        this.totalCantidad7rgFacturas = builder.totalCantidad7rgFacturas;
        this.totalImporteFacturas = builder.totalImporteFacturas;
        this.totalImporteOtrasFacturas = builder.totalImporteOtrasFacturas;
        this.totalImporte7rgFacturas = builder.totalImporte7rgFacturas;
        this.totalDeterminacionPagoCuenta = builder.totalDeterminacionPagoCuenta;
        this.totalPagoCuenta = builder.totalPagoCuenta;
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

    public Integer getSucursal() {
        return sucursal;
    }

    public String getDireccionSucursal() {
        return direccionSucursal;
    }

    public String getDepartamentoSucursal() {
        return departamentoSucursal;
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

    public Long getCantidadFormularios() {
        return cantidadFormularios;
    }

    public Integer getTotalCantidadFacturas() {
        return totalCantidadFacturas;
    }

    public Integer getTotalCantidadOtrasFacturas() {
        return totalCantidadOtrasFacturas;
    }

    public Integer getTotalCantidad7rgFacturas() {
        return totalCantidad7rgFacturas;
    }

    public BigInteger getTotalImporteFacturas() {
        return totalImporteFacturas;
    }

    public BigInteger getTotalImporteOtrasFacturas() {
        return totalImporteOtrasFacturas;
    }

    public BigInteger getTotalImporte7rgFacturas() {
        return totalImporte7rgFacturas;
    }

    public BigInteger getTotalDeterminacionPagoCuenta() {
        return totalDeterminacionPagoCuenta;
    }

    public BigInteger getTotalPagoCuenta() {
        return totalPagoCuenta;
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

    public static Builder newRegistroConsolidacionCommand() {
        return new Builder();
    }


    public static final class Builder {
        private  String id;
        private  Long ifcAgente;
        private  Long nitAgente;
        private  String razonSocialAgente;
        private  Integer sucursal;
        private  String direccionSucursal;
        private  String departamentoSucursal;
        private  Long administracion;
        private  Integer gestion;
        private  Integer periodo;
        private  Long cantidadFormularios;
        private  Integer totalCantidadFacturas;
        private  Integer totalCantidadOtrasFacturas;
        private  Integer totalCantidad7rgFacturas;
        private  BigInteger totalImporteFacturas;
        private  BigInteger totalImporteOtrasFacturas;
        private  BigInteger totalImporte7rgFacturas;
        private  BigInteger totalDeterminacionPagoCuenta;
        private  BigInteger totalPagoCuenta;
        private  Long usuarioConsolidador;
        private  String loginUsuarioConsolidador;
        private  String nombreConsolidador;
        private  Long usuarioRegistro;

        private Builder() {
        }

        public RegistroConsolidacionCommand build() {
            return new RegistroConsolidacionCommand(this);
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

        public Builder sucursal(Integer sucursal) {
            this.sucursal = sucursal;
            return this;
        }

        public Builder direccionSucursal(String direccionSucursal) {
            this.direccionSucursal = direccionSucursal;
            return this;
        }

        public Builder departamentoSucursal(String departamentoSucursal) {
            this.departamentoSucursal = departamentoSucursal;
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

        public Builder cantidadFormularios(Long cantidadFormularios) {
            this.cantidadFormularios = cantidadFormularios;
            return this;
        }

        public Builder totalCantidadFacturas(Integer totalCantidadFacturas) {
            this.totalCantidadFacturas = totalCantidadFacturas;
            return this;
        }

        public Builder totalCantidadOtrasFacturas(Integer totalCantidadOtrasFacturas) {
            this.totalCantidadOtrasFacturas = totalCantidadOtrasFacturas;
            return this;
        }

        public Builder totalCantidad7rgFacturas(Integer totalCantidad7rgFacturas) {
            this.totalCantidad7rgFacturas = totalCantidad7rgFacturas;
            return this;
        }

        public Builder totalImporteFacturas(BigInteger totalImporteFacturas) {
            this.totalImporteFacturas = totalImporteFacturas;
            return this;
        }

        public Builder totalImporteOtrasFacturas(BigInteger totalImporteOtrasFacturas) {
            this.totalImporteOtrasFacturas = totalImporteOtrasFacturas;
            return this;
        }

        public Builder totalImporte7rgFacturas(BigInteger totalImporte7rgFacturas) {
            this.totalImporte7rgFacturas = totalImporte7rgFacturas;
            return this;
        }

        public Builder totalDeterminacionPagoCuenta(BigInteger totalDeterminacionPagoCuenta) {
            this.totalDeterminacionPagoCuenta = totalDeterminacionPagoCuenta;
            return this;
        }

        public Builder totalPagoCuenta(BigInteger totalPagoCuenta) {
            this.totalPagoCuenta = totalPagoCuenta;
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
