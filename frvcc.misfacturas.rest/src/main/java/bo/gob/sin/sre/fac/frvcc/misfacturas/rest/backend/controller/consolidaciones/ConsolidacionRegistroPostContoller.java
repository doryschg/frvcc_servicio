package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.consolidaciones;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.registro.RegistroConsolidacionCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.registro.RegistroSucursalUsuarioCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.consolidaciones.ConsolidadorListaErrores;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;

@RestController
@RequestMapping("/rest/misfacturas")
public final class ConsolidacionRegistroPostContoller extends ApiController {

	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
    public ConsolidacionRegistroPostContoller(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/consolidacion")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {

        dispatch(
                RegistroConsolidacionCommand.newRegistroConsolidacionCommand()
                        .id(request.id())
                        .ifcAgente(request.ifcAgente())
                        .nitAgente(request.nitAgente())
                        .razonSocialAgente(request.razonSocialAgente())
                        .sucursal(request.sucursal())
                        .direccionSucursal(request.direccionSucursal())
                        .departamentoSucursal(request.departamentoSucursal())
                        .administracion(request.administracion())
                        .gestion(request.gestion())
                        .periodo(request.periodo())
                        .cantidadFormularios(request.cantidadFormularios())
                        .totalCantidadFacturas(request.totalCantidadFacturas())
                        .totalCantidadOtrasFacturas(request.totalCantidadOtrasFacturas())
                        .totalCantidad7rgFacturas(request.totalCantidad7rgFacturas())
                        .totalImporteFacturas(request.totalImporteFacturas())
                        .totalImporteOtrasFacturas(request.totalImporteOtrasFacturas())
                        .totalImporte7rgFacturas(request.totalImporte7rgFacturas())
                        .totalDeterminacionPagoCuenta(request.totalDeterminacionPagoCuenta())
                        .totalPagoCuenta(request.totalPagoCuenta())
                        .usuarioConsolidador(request.usuarioConsolidador())
                        .loginUsuarioConsolidador(request.loginUsuarioConsolidador())
                        .nombreConsolidador(request.nombreConsolidador())
                        .usuarioRegistro(usuarioId())
                        .build()
        );
		ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(request.id());
		resultadoGenericoDto.setOk(Boolean.TRUE);
		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.REGISTRO_CORRECTO_CONSOLIDACION));
		return ResponseEntity.ok(resultadoGenericoDto);   
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	 return new HashMap<>(){{
             put(ConsolidadorListaErrores.class,HttpStatus.OK);
         }};
    }
    static final class Request {
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
        private BigInteger totalImporteFacturas;
        private  BigInteger totalImporteOtrasFacturas;
        private  BigInteger totalImporte7rgFacturas;
        private  BigInteger totalDeterminacionPagoCuenta;
        private  BigInteger totalPagoCuenta;
        private  Long usuarioConsolidador;
        private  String loginUsuarioConsolidador;
        private  String nombreConsolidador;


        public Request() {
        }

        public String id() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Long ifcAgente() {
            return ifcAgente;
        }

        public void setIfcAgente(Long ifcAgente) {
            this.ifcAgente = ifcAgente;
        }

        public Long nitAgente() {
            return nitAgente;
        }

        public void setNitAgente(Long nitAgente) {
            this.nitAgente = nitAgente;
        }

        public String razonSocialAgente() {
            return razonSocialAgente;
        }

        public void setRazonSocialAgente(String razonSocialAgente) {
            this.razonSocialAgente = razonSocialAgente;
        }

        public Integer sucursal() {
            return sucursal;
        }

        public void setSucursal(Integer sucursal) {
            this.sucursal = sucursal;
        }

        public String direccionSucursal() {
            return direccionSucursal;
        }

        public void setDireccionSucursal(String direccionSucursal) {
            this.direccionSucursal = direccionSucursal;
        }

        public String departamentoSucursal() {
            return departamentoSucursal;
        }

        public void setDepartamentoSucursal(String departamentoSucursal) {
            this.departamentoSucursal = departamentoSucursal;
        }

        public Long administracion() {
            return administracion;
        }

        public void setAdministracion(Long administracion) {
            this.administracion = administracion;
        }

        public Integer gestion() {
            return gestion;
        }

        public void setGestion(Integer gestion) {
            this.gestion = gestion;
        }

        public Integer periodo() {
            return periodo;
        }

        public void setPeriodo(Integer periodo) {
            this.periodo = periodo;
        }

        public Long cantidadFormularios() {
            return cantidadFormularios;
        }

        public void setCantidadFormularios(Long cantidadFormularios) {
            this.cantidadFormularios = cantidadFormularios;
        }

        public Integer totalCantidadFacturas() {
            return totalCantidadFacturas;
        }

        public void setTotalCantidadFacturas(Integer totalCantidadFacturas) {
            this.totalCantidadFacturas = totalCantidadFacturas;
        }

        public Integer totalCantidadOtrasFacturas() {
            return totalCantidadOtrasFacturas;
        }

        public void setTotalCantidadOtrasFacturas(Integer totalCantidadOtrasFacturas) {
            this.totalCantidadOtrasFacturas = totalCantidadOtrasFacturas;
        }

        public Integer totalCantidad7rgFacturas() {
            return totalCantidad7rgFacturas;
        }

        public void setTotalCantidad7rgFacturas(Integer totalCantidad7rgFacturas) {
            this.totalCantidad7rgFacturas = totalCantidad7rgFacturas;
        }

        public BigInteger totalImporteFacturas() {
            return totalImporteFacturas;
        }

        public void setTotalImporteFacturas(BigInteger totalImporteFacturas) {
            this.totalImporteFacturas = totalImporteFacturas;
        }

        public BigInteger totalImporteOtrasFacturas() {
            return totalImporteOtrasFacturas;
        }

        public void setTotalImporteOtrasFacturas(BigInteger totalImporteOtrasFacturas) {
            this.totalImporteOtrasFacturas = totalImporteOtrasFacturas;
        }

        public BigInteger totalImporte7rgFacturas() {
            return totalImporte7rgFacturas;
        }

        public void setTotalImporte7rgFacturas(BigInteger totalImporte7rgFacturas) {
            this.totalImporte7rgFacturas = totalImporte7rgFacturas;
        }

        public BigInteger totalDeterminacionPagoCuenta() {
            return totalDeterminacionPagoCuenta;
        }

        public void setTotalDeterminacionPagoCuenta(BigInteger totalDeterminacionPagoCuenta) {
            this.totalDeterminacionPagoCuenta = totalDeterminacionPagoCuenta;
        }

        public BigInteger totalPagoCuenta() {
            return totalPagoCuenta;
        }

        public void setTotalPagoCuenta(BigInteger totalPagoCuenta) {
            this.totalPagoCuenta = totalPagoCuenta;
        }

        public Long usuarioConsolidador() {
            return usuarioConsolidador;
        }

        public void setUsuarioConsolidador(Long usuarioConsolidador) {
            this.usuarioConsolidador = usuarioConsolidador;
        }

        public String loginUsuarioConsolidador() {
            return loginUsuarioConsolidador;
        }

        public void setLoginUsuarioConsolidador(String loginUsuarioConsolidador) {
            this.loginUsuarioConsolidador = loginUsuarioConsolidador;
        }

        public String nombreConsolidador() {
            return nombreConsolidador;
        }

        public void setNombreConsolidador(String nombreConsolidador) {
            this.nombreConsolidador = nombreConsolidador;
        }

    }

}
