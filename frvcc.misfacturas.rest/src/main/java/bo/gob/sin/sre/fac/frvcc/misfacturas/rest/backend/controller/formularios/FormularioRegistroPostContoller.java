package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.formularios;


import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.registro.RegistroFormularioCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.DatosEspecificos;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiController;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidatorNotExist;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.str.cmsj.mapl.domain.IMensajeAplicacionDomain;
import bo.gob.sin.str.enumeradores.entorno.EnumSubsistema;

@RestController
@RequestMapping("/rest/misfacturas")
public final class FormularioRegistroPostContoller extends ApiController {

	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
    public FormularioRegistroPostContoller(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/formulario")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError, ValidatorNotExist {

        dispatch(
                RegistroFormularioCommand.newRegistroFormularioCommand()
                        .id(request.id())
                        .tipoFormularioId(request.tipoFormularioId())
                        .nombreFormulario(request.nombreFormulario())
                        .mesPeriodo(request.mesPeriodo())
                        .anioPeriodo(request.anioPeriodo())
                        .fechaPresentacion(request.fechaPresentacion())
                        .periodicidadId(request.periodicidadId())
                        .cantidadPeriodicidad(request.cantidadPeriodicidad())
                        .tipoPresentacionId(request.tipoPresentacionId())
                        .lugarDepartamento(request.lugarDepartamento())
                        .nitCi(request.nitCi())
                        .expedicionCi(request.expedicionCi())
                        .ifc(request.ifc())
                        .razonSocial(request.razonSocial())
                        .direccion(request.direccion())
                        .codigoDependiente(request.codigoDependiente())
                        .nitEmpleador(request.nitEmpleador())
                        .nombreEmpleador(request.nombreEmpleador())
                        .direccionEmpleador(request.direccionEmpleador())
                        .usuarioRegistro(usuarioId())
                        .numeroSucursal(request.numeroSucursal())
                        .datosEspecificos(request.datosEspecificos())
                        .tipoUsoId(request.tipoUsoId()).build()
        );
		ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(request.id());
		resultadoGenericoDto.setOk(Boolean.TRUE);
		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.REGISTRO_CORRECTO_FORMULARIO));
		return ResponseEntity.ok(resultadoGenericoDto);   
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	 return new HashMap<>(){{
             put(FormularioListaErrores.class,HttpStatus.OK);
         }};
    }
    static final class Request {
        private String id;

        private String tipoFormularioId;
        private String nombreFormulario;
        private Integer mesPeriodo;
        private Integer anioPeriodo;
        private LocalDate fechaPresentacion;
        private String periodicidadId;
        private String cantidadPeriodicidad;
        private String tipoPresentacionId;

        private Integer lugarDepartamento;

        private Long nitCi;
        private Integer expedicionCi;
        private Long ifc;
        private String razonSocial;
        private String direccion;
        private Long codigoDependiente;

        private Long nitEmpleador;
        private String nombreEmpleador;
        private String direccionEmpleador;
        private Integer numeroSucursal;
        private DatosEspecificos datosEspecificos;
        private String tipoUsoId;

        public Request() {
        }


        public Request(String id,
                       String tipoFormularioId,
                       String nombreFormulario,
                       Integer mesPeriodo,
                       Integer anioPeriodo,
                       LocalDate fechaPresentacion,
                       String periodicidadId,
                       String cantidadPeriodicidad,
                       String tipoPresentacionId,
                       Integer lugarDepartamento,
                       Long nitCi,
                       Integer expedicionCi,
                       Long ifc,
                       String razonSocial,
                       String direccion,
                       Long codigoDependiente,
                       Long nitEmpleador,
                       String nombreEmpleador,
                       String direccionEmpleador,
                       Integer numeroSucursal,
                       DatosEspecificos datosEspecificos,String tipoUsoId
        ) {
            this.id = id;
            this.tipoFormularioId = tipoFormularioId;
            this.nombreFormulario = nombreFormulario;
            this.mesPeriodo = mesPeriodo;
            this.anioPeriodo = anioPeriodo;
            this.fechaPresentacion = fechaPresentacion;
            this.periodicidadId = periodicidadId;
            this.cantidadPeriodicidad = cantidadPeriodicidad;
            this.tipoPresentacionId = tipoPresentacionId;
            this.lugarDepartamento = lugarDepartamento;
            this.nitCi = nitCi;
            this.expedicionCi = expedicionCi;
            this.ifc = ifc;
            this.razonSocial = razonSocial;
            this.direccion = direccion;
            this.codigoDependiente = codigoDependiente;
            this.nitEmpleador = nitEmpleador;
            this.direccionEmpleador = direccionEmpleador;
            this.nombreEmpleador = nombreEmpleador;
            this.numeroSucursal=numeroSucursal;
            this.datosEspecificos=datosEspecificos;
            this.tipoUsoId =tipoUsoId;
        }

        public String id() {
            return id;
        }

        public String tipoFormularioId() {
            return tipoFormularioId;
        }

        public String nombreFormulario() {
            return nombreFormulario;
        }

        public Integer mesPeriodo() {
            return mesPeriodo;
        }

        public Integer anioPeriodo() {
            return anioPeriodo;
        }

        public LocalDate fechaPresentacion() {
            return fechaPresentacion;
        }

        public String periodicidadId() {
            return periodicidadId;
        }

        public String cantidadPeriodicidad() {
            return cantidadPeriodicidad;
        }

        public String tipoPresentacionId() {
            return tipoPresentacionId;
        }

        public Integer lugarDepartamento() {
            return lugarDepartamento;
        }

        public Long nitCi() {
            return nitCi;
        }

        public Integer expedicionCi() {
            return expedicionCi;
        }

        public Long ifc() {
            return ifc;
        }

        public String razonSocial() {
            return razonSocial;
        }

        public String direccion() {
            return direccion;
        }

        public Long codigoDependiente() {
            return codigoDependiente;
        }

        public Long nitEmpleador() {
            return nitEmpleador;
        }

        public String direccionEmpleador() {
            return direccionEmpleador;
        }

        public String nombreEmpleador() {
            return nombreEmpleador;
        }
        public Integer numeroSucursal() {
            return numeroSucursal;
        }

		public DatosEspecificos datosEspecificos() {
			return datosEspecificos;
		}

        public void setId(String id) {
            this.id = id;
        }

        public void setTipoFormularioId(String tipoFormularioId) {
            this.tipoFormularioId = tipoFormularioId;
        }

        public void setNombreFormulario(String nombreFormulario) {
            this.nombreFormulario = nombreFormulario;
        }

        public void setMesPeriodo(Integer mesPeriodo) {
            this.mesPeriodo = mesPeriodo;
        }

        public void setAnioPeriodo(Integer anioPeriodo) {
            this.anioPeriodo = anioPeriodo;
        }

        public void setFechaPresentacion(LocalDate fechaPresentacion) {
            this.fechaPresentacion = fechaPresentacion;
        }

        public void setPeriodicidadId(String periodicidadId) {
            this.periodicidadId = periodicidadId;
        }

        public void setCantidadPeriodicidad(String cantidadPeriodicidad) {
            this.cantidadPeriodicidad = cantidadPeriodicidad;
        }

        public void setTipoPresentacionId(String tipoPresentacionId) {
            this.tipoPresentacionId = tipoPresentacionId;
        }

        public void setLugarDepartamento(Integer lugarDepartamento) {
            this.lugarDepartamento = lugarDepartamento;
        }

        public void setNitCi(Long nitCi) {
            this.nitCi = nitCi;
        }

        public void setExpedicionCi(Integer expedicionCi) {
            this.expedicionCi = expedicionCi;
        }

        public void setIfc(Long ifc) {
            this.ifc = ifc;
        }

        public void setRazonSocial(String razonSocial) {
            this.razonSocial = razonSocial;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public void setCodigoDependiente(Long codigoDependiente) {
            this.codigoDependiente = codigoDependiente;
        }

        public void setNitEmpleador(Long nitEmpleador) {
            this.nitEmpleador = nitEmpleador;
        }

        public void setNombreEmpleador(String nombreEmpleador) {
            this.nombreEmpleador = nombreEmpleador;
        }

        public void setDireccionEmpleador(String direccionEmpleador) {
            this.direccionEmpleador = direccionEmpleador;
        }

        public void setNumeroSucursal(Integer numeroSucursal) {
            this.numeroSucursal = numeroSucursal;
        }

        public void setDatosEspecificos(DatosEspecificos datosEspecificos) {
			this.datosEspecificos = datosEspecificos;
		}

        public String tipoUsoId() {
            return tipoUsoId;
        }

        public void setTipoUsoId(String tipoUsoId) {
            this.tipoUsoId = tipoUsoId;
        }
    }

}
