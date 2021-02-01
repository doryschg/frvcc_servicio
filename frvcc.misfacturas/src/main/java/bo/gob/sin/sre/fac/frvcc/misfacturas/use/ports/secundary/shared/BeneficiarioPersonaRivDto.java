package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BeneficiarioPersonaRivDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private long beneficiarioId;
    private long personaId;
    private long codigoPersona;
    private String formatoNombreId;
    private String paisId;
    private Integer departamentoId;
    private String departamentoDescripcion;
    private String localidadDescripcion;
    private Integer alcaldiaId;
    private String direccion;
    private String tipoBeneficiarioId;
    private String nuaCua;
    private BigDecimal totalSalario;
    private String entidadFinancieraId;
    private String entidadFinancieraDescripcion;
    private String tipoCuentaBancariaId;
    private String cuentaBanco;
    private String monedaId;
    private int distritoCuentaId;
    private String estadoCuentaBancariaId;
    private String pagoAutomaticoId;
    private String estadoBeneficiarioId;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private Long idBeneficiarioSigep;
    private int gestionRegistro;
    private BigDecimal salarioUno;
    private BigDecimal salarioDos;
    private BigDecimal salarioTres;
    private PersonaBeneficiarioDto personaBeneficiario;

    public BeneficiarioPersonaRivDto(long beneficiarioId, long personaId, long codigoPersona, String formatoNombreId, String paisId, Integer departamentoId, String departamentoDescripcion, String localidadDescripcion, Integer alcaldiaId, String direccion, String tipoBeneficiarioId, String nuaCua, BigDecimal totalSalario, String entidadFinancieraId, String tipoCuentaBancariaId, String cuentaBanco, String monedaId, int distritoCuentaId, String estadoCuentaBancariaId, String pagoAutomaticoId, String estadoBeneficiarioId, LocalDate fechaDesde, LocalDate fechaHasta, Long idBeneficiarioSigep, int gestionRegistro, BigDecimal salarioUno, BigDecimal salarioDos, BigDecimal salarioTres, PersonaBeneficiarioDto personaBeneficiario) {
        this.beneficiarioId = beneficiarioId;
        this.personaId = personaId;
        this.codigoPersona = codigoPersona;
        this.formatoNombreId = formatoNombreId;
        this.paisId = paisId;
        this.departamentoId = departamentoId;
        this.departamentoDescripcion = departamentoDescripcion;
        this.localidadDescripcion = localidadDescripcion;
        this.alcaldiaId = alcaldiaId;
        this.direccion = direccion;
        this.tipoBeneficiarioId = tipoBeneficiarioId;
        this.nuaCua = nuaCua;
        this.totalSalario = totalSalario;
        this.entidadFinancieraId = entidadFinancieraId;
        this.tipoCuentaBancariaId = tipoCuentaBancariaId;
        this.cuentaBanco = cuentaBanco;
        this.monedaId = monedaId;
        this.distritoCuentaId = distritoCuentaId;
        this.estadoCuentaBancariaId = estadoCuentaBancariaId;
        this.pagoAutomaticoId = pagoAutomaticoId;
        this.estadoBeneficiarioId = estadoBeneficiarioId;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.idBeneficiarioSigep = idBeneficiarioSigep;
        this.gestionRegistro = gestionRegistro;
        this.salarioUno = salarioUno;
        this.salarioDos = salarioDos;
        this.salarioTres = salarioTres;
        this.personaBeneficiario = personaBeneficiario;
    }

    public BeneficiarioPersonaRivDto() {
        super();
    }

    public long getBeneficiarioId() {
        return beneficiarioId;
    }

    public void setBeneficiarioId(long beneficiarioId) {
        this.beneficiarioId = beneficiarioId;
    }

    public long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(long personaId) {
        this.personaId = personaId;
    }

    public String getFormatoNombreId() {
        return formatoNombreId;
    }

    public void setFormatoNombreId(String formatoNombreId) {
        this.formatoNombreId = formatoNombreId;
    }

    public String getPaisId() {
        return paisId;
    }

    public void setPaisId(String paisId) {
        this.paisId = paisId;
    }

    public Integer getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

    public Integer getAlcaldiaId() {
        return alcaldiaId;
    }

    public void setAlcaldiaId(Integer alcaldiaId) {
        this.alcaldiaId = alcaldiaId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoBeneficiarioId() {
        return tipoBeneficiarioId;
    }

    public void setTipoBeneficiarioId(String tipoBeneficiarioId) {
        this.tipoBeneficiarioId = tipoBeneficiarioId;
    }

    public String getNuaCua() {
        return nuaCua;
    }

    public void setNuaCua(String nuaCua) {
        this.nuaCua = nuaCua;
    }

    public BigDecimal getTotalSalario() {
        return totalSalario;
    }

    public void setTotalSalario(BigDecimal totalSalario) {
        this.totalSalario = totalSalario;
    }

    public String getEntidadFinancieraId() {
        return entidadFinancieraId;
    }

    public void setEntidadFinancieraId(String entidadFinancieraId) {
        this.entidadFinancieraId = entidadFinancieraId;
    }

    public String getTipoCuentaBancariaId() {
        return tipoCuentaBancariaId;
    }

    public void setTipoCuentaBancariaId(String tipoCuentaBancariaId) {
        this.tipoCuentaBancariaId = tipoCuentaBancariaId;
    }

    public String getCuentaBanco() {
        return cuentaBanco;
    }

    public void setCuentaBanco(String cuentaBanco) {
        this.cuentaBanco = cuentaBanco;
    }

    public String getMonedaId() {
        return monedaId;
    }

    public void setMonedaId(String monedaId) {
        this.monedaId = monedaId;
    }

    public int getDistritoCuentaId() {
        return distritoCuentaId;
    }

    public void setDistritoCuentaId(int distritoCuentaId) {
        this.distritoCuentaId = distritoCuentaId;
    }

    public String getEstadoCuentaBancariaId() {
        return estadoCuentaBancariaId;
    }

    public void setEstadoCuentaBancariaId(String estadoCuentaBancariaId) {
        this.estadoCuentaBancariaId = estadoCuentaBancariaId;
    }

    public String getPagoAutomaticoId() {
        return pagoAutomaticoId;
    }

    public void setPagoAutomaticoId(String pagoAutomaticoId) {
        this.pagoAutomaticoId = pagoAutomaticoId;
    }

    public String getEstadoBeneficiarioId() {
        return estadoBeneficiarioId;
    }

    public void setEstadoBeneficiarioId(String estadoBeneficiarioId) {
        this.estadoBeneficiarioId = estadoBeneficiarioId;
    }

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Long getIdBeneficiarioSigep() {
        return idBeneficiarioSigep;
    }

    public void setIdBeneficiarioSigep(Long idBeneficiarioSigep) {
        this.idBeneficiarioSigep = idBeneficiarioSigep;
    }


    public PersonaBeneficiarioDto getPersonaBeneficiario() {
        return personaBeneficiario;
    }

    public void setPersonaBeneficiario(PersonaBeneficiarioDto personaBeneficiario) {
        this.personaBeneficiario = personaBeneficiario;
    }

    public long getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(long codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public BigDecimal getSalarioUno() {
        return salarioUno;
    }

    public void setSalarioUno(BigDecimal salarioUno) {
        this.salarioUno = salarioUno;
    }

    public BigDecimal getSalarioDos() {
        return salarioDos;
    }

    public void setSalarioDos(BigDecimal salarioDos) {
        this.salarioDos = salarioDos;
    }

    public BigDecimal getSalarioTres() {
        return salarioTres;
    }

    public void setSalarioTres(BigDecimal salarioTres) {
        this.salarioTres = salarioTres;
    }

    public int getGestionRegistro() {
        return gestionRegistro;
    }

    public void setGestionRegistro(int gestionRegistro) {
        this.gestionRegistro = gestionRegistro;
    }

    public String getDepartamentoDescripcion() {
        return departamentoDescripcion;
    }

    public void setDepartamentoDescripcion(String departamentoDescripcion) {
        this.departamentoDescripcion = departamentoDescripcion;
    }

    public String getLocalidadDescripcion() {
        return localidadDescripcion;
    }

    public void setLocalidadDescripcion(String localidadDescripcion) {
        this.localidadDescripcion = localidadDescripcion;
    }

    public String getEntidadFinancieraDescripcion() {
        return entidadFinancieraDescripcion;
    }

    public void setEntidadFinancieraDescripcion(String entidadFinancieraDescripcion) {
        this.entidadFinancieraDescripcion = entidadFinancieraDescripcion;
    }

    public class PersonaBeneficiarioDto extends AuditoriaDto {

        private long perBeneficiarioId;
        private long personaId;
        private int tipoDocumentoIdentidadId;
        private String tipoDocumentoIdentidadDescripcion;
        private Integer lugarExpedicionId;
        private String lugarExpedicionDescripcion;
        private Integer tipoPersonaId;
        private String correoElectronico;
        private String numeroDocumento;
        private String codigoComplementario;
        private String celular;
        private String telefonoReferencia1;
        private String telefonoReferencia2;
        private int paisOrigenId;
        private String paisOrigenDescripcion;
        private int estadoCivilId;
        private String estadoCivilDescripcion;
        private int generoId;
        private String generoDescripcion;
        private String nombres;
        private String primerApellido;
        private String segundoApellido;
        private String apellidoCasada;
        private LocalDateTime fechaNacimiento;
        private LocalDate fechaDesde;
        private LocalDate fechaHasta;
        private String modificadoId;
        private String origenId;
        private String estadoPerBeneficiarioId;

        public PersonaBeneficiarioDto() {
        }

        public long getPerBeneficiarioId() {
            return perBeneficiarioId;
        }

        public void setPerBeneficiarioId(long perBeneficiarioId) {
            this.perBeneficiarioId = perBeneficiarioId;
        }

        public long getPersonaId() {
            return personaId;
        }

        public void setPersonaId(long personaId) {
            this.personaId = personaId;
        }

        public int getTipoDocumentoIdentidadId() {
            return tipoDocumentoIdentidadId;
        }

        public void setTipoDocumentoIdentidadId(int tipoDocumentoIdentidadId) {
            this.tipoDocumentoIdentidadId = tipoDocumentoIdentidadId;
        }

        public Integer getLugarExpedicionId() {
            return lugarExpedicionId;
        }

        public void setLugarExpedicionId(Integer lugarExpedicionId) {
            this.lugarExpedicionId = lugarExpedicionId;
        }

        public Integer getTipoPersonaId() {
            return tipoPersonaId;
        }

        public void setTipoPersonaId(Integer tipoPersonaId) {
            this.tipoPersonaId = tipoPersonaId;
        }

        public String getCorreoElectronico() {
            return correoElectronico;
        }

        public void setCorreoElectronico(String correoElectronico) {
            this.correoElectronico = correoElectronico;
        }

        public String getNumeroDocumento() {
            return numeroDocumento;
        }

        public void setNumeroDocumento(String numeroDocumento) {
            this.numeroDocumento = numeroDocumento;
        }

        public String getCodigoComplementario() {
            return codigoComplementario;
        }

        public void setCodigoComplementario(String codigoComplementario) {
            this.codigoComplementario = codigoComplementario;
        }

        public String getCelular() {
            return celular;
        }

        public void setCelular(String celular) {
            this.celular = celular;
        }

        public String getTelefonoReferencia1() {
            return telefonoReferencia1;
        }

        public void setTelefonoReferencia1(String telefonoReferencia1) {
            this.telefonoReferencia1 = telefonoReferencia1;
        }

        public String getTelefonoReferencia2() {
            return telefonoReferencia2;
        }

        public void setTelefonoReferencia2(String telefonoReferencia2) {
            this.telefonoReferencia2 = telefonoReferencia2;
        }

        public int getPaisOrigenId() {
            return paisOrigenId;
        }

        public void setPaisOrigenId(int paisOrigenId) {
            this.paisOrigenId = paisOrigenId;
        }

        public int getEstadoCivilId() {
            return estadoCivilId;
        }

        public void setEstadoCivilId(int estadoCivilId) {
            this.estadoCivilId = estadoCivilId;
        }

        public int getGeneroId() {
            return generoId;
        }

        public void setGeneroId(int generoId) {
            this.generoId = generoId;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getPrimerApellido() {
            return primerApellido;
        }

        public void setPrimerApellido(String primerApellido) {
            this.primerApellido = primerApellido;
        }

        public String getSegundoApellido() {
            return segundoApellido;
        }

        public void setSegundoApellido(String segundoApellido) {
            this.segundoApellido = segundoApellido;
        }

        public String getApellidoCasada() {
            return apellidoCasada;
        }

        public void setApellidoCasada(String apellidoCasada) {
            this.apellidoCasada = apellidoCasada;
        }

        public LocalDateTime getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public LocalDate getFechaDesde() {
            return fechaDesde;
        }

        public void setFechaDesde(LocalDate fechaDesde) {
            this.fechaDesde = fechaDesde;
        }

        public LocalDate getFechaHasta() {
            return fechaHasta;
        }

        public void setFechaHasta(LocalDate fechaHasta) {
            this.fechaHasta = fechaHasta;
        }

        public String getEstadoPerBeneficiarioId() {
            return estadoPerBeneficiarioId;
        }

        public void setEstadoPerBeneficiarioId(String estadoPerBeneficiarioId) {
            this.estadoPerBeneficiarioId = estadoPerBeneficiarioId;
        }

        public String getTipoDocumentoIdentidadDescripcion() {
            return tipoDocumentoIdentidadDescripcion;
        }

        public void setTipoDocumentoIdentidadDescripcion(String tipoDocumentoIdentidadDescripcion) {
            this.tipoDocumentoIdentidadDescripcion = tipoDocumentoIdentidadDescripcion;
        }

        public String getLugarExpedicionDescripcion() {
            return lugarExpedicionDescripcion;
        }

        public void setLugarExpedicionDescripcion(String lugarExpedicionDescripcion) {
            this.lugarExpedicionDescripcion = lugarExpedicionDescripcion;
        }

        public String getPaisOrigenDescripcion() {
            return paisOrigenDescripcion;
        }

        public void setPaisOrigenDescripcion(String paisOrigenDescripcion) {
            this.paisOrigenDescripcion = paisOrigenDescripcion;
        }

        public String getEstadoCivilDescripcion() {
            return estadoCivilDescripcion;
        }

        public void setEstadoCivilDescripcion(String estadoCivilDescripcion) {
            this.estadoCivilDescripcion = estadoCivilDescripcion;
        }

        public String getGeneroDescripcion() {
            return generoDescripcion;
        }

        public void setGeneroDescripcion(String generoDescripcion) {
            this.generoDescripcion = generoDescripcion;
        }

        public String getModificadoId() {
            return modificadoId;
        }

        public void setModificadoId(String modificadoId) {
            this.modificadoId = modificadoId;
        }

        public String getOrigenId() {
            return origenId;
        }

        public void setOrigenId(String origenId) {
            this.origenId = origenId;
        }


    }

    public class AuditoriaDto implements Serializable {
        private static final long serialVersionUID = 1L;

        private Long usuarioRegistroId = null;

        private Long usuarioUltimaModificacionId = null;

        private LocalDateTime fechaRegistro = null;

        private LocalDateTime fechaUltimaModificacion = null;

        private String estadoId = null;

        public AuditoriaDto() {
        }

        public Long getUsuarioRegistroId() {
            return this.usuarioRegistroId;
        }

        public void setUsuarioRegistroId(Long usuarioRegistroId) {
            this.usuarioRegistroId = usuarioRegistroId;
        }

        public Long getUsuarioUltimaModificacionId() {
            return this.usuarioUltimaModificacionId;
        }

        public void setUsuarioUltimaModificacionId(Long usuarioUltimaModificacionId) {
            this.usuarioUltimaModificacionId = usuarioUltimaModificacionId;
        }

        public LocalDateTime getFechaRegistro() {
            return this.fechaRegistro;
        }

        public void setFechaRegistro(LocalDateTime fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
        }

        public LocalDateTime getFechaUltimaModificacion() {
            return this.fechaUltimaModificacion;
        }

        public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
            this.fechaUltimaModificacion = fechaUltimaModificacion;
        }

        public String getEstadoId() {
            return this.estadoId;
        }

        public void setEstadoId(String estadoId) {
            this.estadoId = estadoId;
        }
    }


}

