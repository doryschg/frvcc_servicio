package bo.gob.sin.sre.fac.frvcc.misfacturas.rest.backend.controller.consolidaciones;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.ConsolidacionResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.consolidaciones.criterio_busqueda.SearchConsolidacionByCriteriaQuery;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioListaErrores;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.ApiController;
import bo.gob.sin.sre.fac.frvcc.shared.model.DomainError;
import bo.gob.sin.sre.fac.frvcc.shared.model.EnumEstadoId;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.command.CommandBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.str.cmsj.mapl.domain.IMensajeAplicacionDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/rest/misfacturas")
public class ConsolidacionesNitGestionPeriodoGetController extends ApiController {
	@Autowired
	private IMensajeAplicacionDomain mensajesDomain;

    public ConsolidacionesNitGestionPeriodoGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/consolidaciones/{nit}/{gestion}/{periodo}")
    public ResponseEntity<HashMap<String,Serializable>> index(@PathVariable Long nit, @PathVariable Integer gestion, @PathVariable Integer periodo) throws QueryNotRegisteredError, QueryHandlerExecutionError {

        List<HashMap<String, String>> filters = new ArrayList<>();

        filters.add(new HashMap<>(){{
            put("field", "nitAgente");
            put("operator", "=");
            put("value", nit.toString());
        }});

        filters.add(new HashMap<>(){{
            put("field", "gestion");
            put("operator", "=");
            put("value", gestion.toString());
        }});

        filters.add(new HashMap<>(){{
            put("field", "periodo");
            put("operator", "=");
            put("value", periodo.toString());
        }});
        filters.add(
        new HashMap<>() {
          {
            put("field", "estadoId");
            put("operator", "=");
            put("value", EnumEstadoId.ACTIVO.value());
          }
        });
        filters.add(
                new HashMap<>() {
                    {
                        put("field", "tipoId");
                        put("operator", "=");
                        put("value", "P");
                    }
                });

        SearchConsolidacionByCriteriaQuery searchFormulariosByCriteriaQuery = new SearchConsolidacionByCriteriaQuery(filters, Optional.ofNullable(null),Optional.ofNullable(null),Optional.ofNullable(null),Optional.ofNullable(null));

        ConsolidacionResponse vConsolidacionResponse = ask(searchFormulariosByCriteriaQuery);


        if(vConsolidacionResponse.getTotalElementos()>0)
        {
            return ResponseEntity.ok(

                    new HashMap() {{
                        put("cantidad_de _formularios_110_v4_aceptados",vConsolidacionResponse.getConsolidacionesResponse().get(0)!=null?vConsolidacionResponse.getConsolidacionesResponse().get(0).getCantidadFormularios():0);
                        put("total_credito_fiscal_casilla_693", vConsolidacionResponse.getConsolidacionesResponse().get(0)!=null?vConsolidacionResponse.getConsolidacionesResponse().get(0).getTotalDeterminacionPagoCuenta():0);
                        put("total_pago_a_cuenta_siete_rg_casilla_465", vConsolidacionResponse.getConsolidacionesResponse().get(0)!=null?vConsolidacionResponse.getConsolidacionesResponse().get(0).getTotalPagoCuenta():0);
                    }}
            );
        }
        return ResponseEntity.ok(

                new HashMap() {{
                    put("cantidad_de _formularios_110_v4_aceptados",0);
                    put("total_credito_fiscal_casilla_693",0);
                    put("total_pago_a_cuenta_siete_rg_casilla_465", 0);
                }}
        );

    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
    	 return new HashMap<>(){{
             put(FormularioListaErrores.class,HttpStatus.OK);
         }};    }



}

