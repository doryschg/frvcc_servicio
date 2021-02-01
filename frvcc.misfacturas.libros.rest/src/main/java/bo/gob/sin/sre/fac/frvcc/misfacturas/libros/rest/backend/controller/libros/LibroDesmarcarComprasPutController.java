package bo.gob.sin.sre.fac.frvcc.misfacturas.libros.rest.backend.controller.libros;

import java.util.HashMap;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.formularios.declarar.DeclararFormularioCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.declarar.DeclararLibroCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.desmarcar_compras.DesmarcarComprasLibroCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.libros.adapters.primary.libros.seleccionar_compras.SeleccionarComprasLibroCommand;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraListaErrores;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.str.cmsj.mapl.domain.IMensajeAplicacionDomain;
import bo.gob.sin.str.enumeradores.entorno.EnumSubsistema;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.ResultadoGenericoDto;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiController;

@RestController
@RequestMapping("/rest/misfacturas")
public class LibroDesmarcarComprasPutController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;
    public LibroDesmarcarComprasPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
        // TODO Auto-generated constructor stub
    }

    @PutMapping(value = "/libro/desmarcarCompras/{id}")
    public ResponseEntity<ResultadoGenericoDto<String>> index(@PathVariable String id,
                                        @RequestBody Request request) throws CommandNotRegisteredError, CommandHandlerExecutionError {
        dispatch(new DesmarcarComprasLibroCommand(id,usuarioId(),request.listaIdsCompras()));

        ResultadoGenericoDto<String> resultadoGenericoDto = new ResultadoGenericoDto<>(id);
 		resultadoGenericoDto.setOk(Boolean.TRUE);
 		resultadoGenericoDto.getMensajes().add(mensajesDomain.getMensaje(EnumSubsistema.RECAUDACIONES,EnumFacFrvccMensajesShared.DESASOCIACION_COMPRAS_CORRECTO));
 		return ResponseEntity.ok(resultadoGenericoDto);}

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	 return new HashMap<>(){{
             put(FormularioListaErrores.class,HttpStatus.OK);
         }};
    }

    static final class Request {
        private List<String> listaIdsCompras;

        public Request(Integer codAdmin,List<String> listaIdsCompras) {
            this.listaIdsCompras=listaIdsCompras;
        }

        public Request() {
        }

		public List<String> listaIdsCompras() {
			return listaIdsCompras;
		}

		public void setListaIdsCompras(List<String> listaIdsCompras) {
			this.listaIdsCompras = listaIdsCompras;
		}
        
    }

    }
