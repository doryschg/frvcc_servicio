package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.rest.backend.controller.libros;


import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.registro.RegistroLibroCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
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
public final class LibroRegistroPostContoller extends ApiController {

	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
	
    public LibroRegistroPostContoller(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/libro")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError, ValidatorNotExist {

        dispatch(
                RegistroLibroCommand.newRegistroLibroCommand()
                        .id(request.id())
                        .nombreLibro(request.nombreLibro())
                        .mesPeriodo(request.mesPeriodo())
                        .anioPeriodo(request.anioPeriodo())
                        .fechaPresentacion(request.fechaPresentacion())
                        .periodicidadId(request.periodicidadId())
                        .cantidadPeriodicidad(request.cantidadPeriodicidad())
                        .tipoPresentacionId(request.tipoPresentacionId())
                        .nit(request.nit())
                        .ifc(request.ifc())
                        .razonSocial(request.razonSocial())
                        .codAdministracion(request.codAdministracion())
                        .administracion(request.administracion())
                        .usuarioRegistro(usuarioId()).build()
        );
        ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(request.id());
		resultadoGenericoDto.setOk(Boolean.TRUE);
		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.REGISTRO_LIBRO_CORRECTO));
		return ResponseEntity.ok(resultadoGenericoDto);   
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<>(){{
            put(CompraListaErrores.class,HttpStatus.OK);
        }};
    }
    static final class Request {
        private String id;
        private String nombreLibro;
        private Integer mesPeriodo;
        private Integer anioPeriodo;
        private LocalDate fechaPresentacion;
        private String periodicidadId;
        private String cantidadPeriodicidad;
        private String tipoPresentacionId;
        private Long nit;
        private Long ifc;
        private String razonSocial;
        private Long codAdministracion;
        private String administracion;

        public Request() {
        }


        public Request(String id,
                       String nombreLibro,
                       Integer mesPeriodo,
                       Integer anioPeriodo,
                       LocalDate fechaPresentacion,
                       String periodicidadId,
                       String cantidadPeriodicidad,
                       String tipoPresentacionId,
                       Long nit,
                       Integer expedicion,
                       Long ifc,
                       String razonSocial,
                       Long codAdministracion,
                       String administracion
        ) {
            this.id = id;
            this.nombreLibro = nombreLibro;
            this.mesPeriodo = mesPeriodo;
            this.anioPeriodo = anioPeriodo;
            this.fechaPresentacion = fechaPresentacion;
            this.periodicidadId = periodicidadId;
            this.cantidadPeriodicidad = cantidadPeriodicidad;
            this.tipoPresentacionId = tipoPresentacionId;
            this.nit = nit;
            this.ifc = ifc;
            this.razonSocial = razonSocial;
            this.codAdministracion=codAdministracion;
            this.administracion=administracion;
        }

        public String id() {
            return id;
        }

        public String nombreLibro() {
            return nombreLibro;
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

        public Long nit() {
            return nit;
        }

        public Long ifc() {
            return ifc;
        }

        public String razonSocial() {
            return razonSocial;
        }
        
        public Long codAdministracion()
        {
        	return codAdministracion;
        }
        public String administracion()
        {
        	return administracion;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setNombreLibro(String nombreLibro) {
            this.nombreLibro = nombreLibro;
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

        public void setNit(Long nit) {
            this.nit = nit;
        }

        public void setIfc(Long ifc) {
            this.ifc = ifc;
        }

        public void setRazonSocial(String razonSocial) {
            this.razonSocial = razonSocial;
        }


		public void setCodAdministracion(Long codAdministracion) {
			this.codAdministracion = codAdministracion;
		}


		public void setAdministracion(String administracion) {
			this.administracion = administracion;
		}
        

    }

}
