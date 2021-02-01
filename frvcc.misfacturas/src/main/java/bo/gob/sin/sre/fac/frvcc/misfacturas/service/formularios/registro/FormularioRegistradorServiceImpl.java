package bo.gob.sin.sre.fac.frvcc.misfacturas.service.formularios.registro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.BeneficiarioPersonaRivDto;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.IBeneficiarioPersonaRivService;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.model.EnumEstadoId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.formularios.validadores.FormularioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.formularios.registro.IFormularioRegistrador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;

@Service
public final class FormularioRegistradorServiceImpl implements IFormularioRegistrador {
	private static final Logger LOG = LoggerFactory.getLogger(FormularioRegistradorServiceImpl.class);
	private final FormularioRepository repository;
	private final EventBus eventBus;
	private final FormularioValidador validador;
	private final IBeneficiarioPersonaRivService beneficiarioPersonaRivService;

	public FormularioRegistradorServiceImpl(FormularioRepository pRepository, EventBus pEventBus,
											FormularioValidador pValidador, IBeneficiarioPersonaRivService beneficiarioPersonaRivService) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
		this.validador = pValidador;
		this.beneficiarioPersonaRivService = beneficiarioPersonaRivService;
	}

	public void registro(FormularioId pId, FormularioTipoFormularioId pTipoFormularioId,
						 FormularioNombreFormulario pNombreFormulario, FormularioMesPeriodo pMesPeriodo,
						 FormularioAnioPeriodo pAnioPeriodo, FormularioFechaPresentacion pFechaPresentacion,
						 FormularioPeriodicidadId pPeriodicidadId, FormularioCantidadPeriodicidad pCantidadPeriodicidad,
						 FormularioTipoPresentacionId pTipoPresentacionId, FormularioLugarDepartamento pLugarDepartamento,
						 FormularioNitCi pNitCi, FormularioExpedicionCi pExpedicionCi, FormularioIfc pIfc,
						 FormularioRazonSocial pRazonSocial, FormularioDireccion pDireccion,
						 FormularioCodigoDependiente pCodigoDependiente, FormularioNitEmpleador pNitEmpleador,
						 FormularioNombreEmpleador pNombreEmpleador, FormularioDireccionEmpleador pDireccionEmpleador,
						 FormularioUsuarioRegistro pUsuarioRegistro, FormularioNumeroSucursal numeroSucursal,DatosEspecificos pDatosEspecificos,
						 FormularioTipoUsoId tipoUsoId) {
		
		ValidationResponse vResultadoValidacion = validador.validarFormulario(new HashMap<>() {
			{
				put("id", pId.value() != null ? pId.value() : "");
				put("tipoFormularioId",
						pTipoFormularioId.value() != null ? pTipoFormularioId.value().toString() : "");
				put("nitCi", pNitCi.value() != null ? pNitCi.value().toString() : "");
				put("razonSocial", pRazonSocial.value() != null ? pRazonSocial.value().toString() : "");
				put("anioPeriodo", pAnioPeriodo.value() != null ? pAnioPeriodo.value() : "");
				put("nombreFormulario",
						pNombreFormulario.value() != null ? pNombreFormulario.value().toString() : "");
				put("lugarDepartamento", pLugarDepartamento.value() != null ? pLugarDepartamento.value() : "");
				put("tipoPresentacion", pTipoPresentacionId.value() != null ? pTipoPresentacionId.value() : "");
				put("direccion", pDireccion.value() != null ? pDireccion.value() : "");
				put("periodicidadId", pPeriodicidadId.value() != null ? pPeriodicidadId.value() : "");
				put("cantidadPeriodicidad",
						pCantidadPeriodicidad.value() != null ? pCantidadPeriodicidad.value().toString() : "");

			}
		});


		
		if (vResultadoValidacion.hasErrors()) {
			throw new FormularioListaErrores(pId, vResultadoValidacion);
		}
		
		if(validador.validarRazonSocialEmpleador(pNombreEmpleador, pTipoFormularioId.value()))
		{
			throw new FormularioListaErrores(pId, validador.crearValidacionNombreEmpleador());
		}
		
		List<Filter> vFiltros=new ArrayList<>();
		vFiltros.add(Filter.create("mesPeriodo", "=",pMesPeriodo.value()+""));
		vFiltros.add(Filter.create("anioPeriodo", "=", pAnioPeriodo.value()+""));
		vFiltros.add(Filter.create("nitCi", "=", pNitCi.value()+""));
		vFiltros.add(Filter.create("estadoId", "=", EnumEstadoId.ACTIVO.value()));
		vFiltros.add(Filter.create("tipoFormularioId","=",pTipoFormularioId.value()));
		if(pTipoFormularioId.value().equals(EnumTipoFormularioId.FORMULARIO_110.value()) ||
				pTipoFormularioId.value().equals(EnumTipoFormularioId.FORMULARIO_110_AF610.value()))
		{
			vFiltros.add(Filter.create("nitEmpleador", "=",pNitEmpleador.value()+""));
		}
		boolean vFechaValida=true;
		if(pTipoFormularioId.value().equals(EnumTipoFormularioId.FORMULARIO_110.value()))
		{
			vFechaValida=((pFechaPresentacion.value().getMonthValue()>=pMesPeriodo.value())&&
					(pFechaPresentacion.value().getYear()>=pAnioPeriodo.value()))||
					((pFechaPresentacion.value().getMonthValue()<pMesPeriodo.value())&&
							(pFechaPresentacion.value().getYear()>pAnioPeriodo.value()));
		}
		Criteria criteria = new Criteria (
                new Filters(vFiltros), Order.none()
                
        );

		if(pTipoFormularioId.value().equals(EnumTipoFormularioId.FORMULARIO_111.value())) {
			BeneficiarioPersonaRivDto beneficiario = beneficiarioPersonaRivService.getBeneficiarioPersona(pIfc.value()).orElseThrow(
					() -> new FormularioListaErrores(pId, validador.crearValidacionFormularioNoExistente()));

			pDatosEspecificos.setTipoDocumento(String.valueOf(beneficiario.getPersonaBeneficiario().getTipoDocumentoIdentidadId()));
			pDatosEspecificos.setDescripcionTipoDocumento(beneficiario.getPersonaBeneficiario().getTipoDocumentoIdentidadDescripcion());
			pDatosEspecificos.setNumeroDocumento(beneficiario.getPersonaBeneficiario().getNumeroDocumento());
			pDatosEspecificos.setComplementoDocumento(beneficiario.getPersonaBeneficiario().getCodigoComplementario());
			pDatosEspecificos.setLugarExpedicion(beneficiario.getPersonaBeneficiario().getLugarExpedicionId().toString());
			pDatosEspecificos.setDescripcionLugarExpedicion(beneficiario.getPersonaBeneficiario().getLugarExpedicionDescripcion().toString());


			pDatosEspecificos.setBancoId(beneficiario.getEntidadFinancieraId());
			pDatosEspecificos.setDescripcionBanco(beneficiario.getEntidadFinancieraDescripcion());
			pDatosEspecificos.setTipoCuentaBancariaId(beneficiario.getTipoCuentaBancariaId());
			pDatosEspecificos.setTipoCuentaBancariaDescripcion(beneficiario.getTipoCuentaBancariaId().equals("A") ?  "Caja de Ahorros" : "Cuenta Corriente");
			pDatosEspecificos.setNumeroCuenta(beneficiario.getCuentaBanco());
			pDatosEspecificos.setPromedioIngreso(beneficiario.getTotalSalario());
			

		}
		if (repository.BuscarPorCriteria(criteria).getTotalElementos()==0) {
			if(vFechaValida)
			{

				Formulario vFormulario = Formulario.registro(pId, pTipoFormularioId, pNombreFormulario, pMesPeriodo, pAnioPeriodo,
						pFechaPresentacion, pPeriodicidadId, pCantidadPeriodicidad, pTipoPresentacionId, pLugarDepartamento,
						pNitCi, pExpedicionCi, pIfc, pRazonSocial, pDireccion, pCodigoDependiente, pNitEmpleador,
						pNombreEmpleador, pDireccionEmpleador, pUsuarioRegistro,pDatosEspecificos,numeroSucursal,tipoUsoId);
				try {
					repository.save(vFormulario);
					eventBus.publish(vFormulario.pullDomainEvents());
				} catch (Exception excepcion) {
					LOG.error(excepcion.getCause().toString(), excepcion);
					throw new FormularioListaErrores(pId, crearValidacionException());
				}
			}
			else
			{
				throw new FormularioListaErrores(pId, crearValidacionFechaPresentacion());
			}

			

		}
		else
		{
			
		    throw new FormularioListaErrores(pId, crearValidacionExistencia());
		       
		}
		
		
	}

	private ValidationResponse crearValidacionException() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("id", Arrays.asList(EnumFacFrvccMensajesShared.ERROR_REGISTRO_FORMULARIO.getId()));
			}
		});
	}
	 private ValidationResponse crearValidacionExistencia(){
	        return  new ValidationResponse(new HashMap<>() {{
	            put("id", Arrays.asList(EnumFacFrvccMensajesShared.FORMULARIO_EXISTE_PERIODO.getId()));
	        }});
	 }
	 private ValidationResponse crearValidacionFechaPresentacion(){
	        return  new ValidationResponse(new HashMap<>() {{
	            put("id", Arrays.asList(EnumFacFrvccMensajesShared.FORMULARIO_FECHA_PRESENTACION.getId()));
	        }});
	 }
}
