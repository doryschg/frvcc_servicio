package bo.gob.sin.sre.fac.frvcc.misfacturas.service.compras_notas.registro;

import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras_notas.validadores.CompraNotaValidador;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.primary.compras_notas.registro.ICompraNotaRegistro;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras_notas.CompraNotaRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.EnumFacFrvccMensajesShared;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.validacion.ValidationResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.primary.contribuyentes.ContribuyenteResponse;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.contribuyentes.BuscarContribuyentePorNitQueryDto;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.event.EventBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryBus;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryHandlerExecutionError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.secundary.bus.query.QueryNotRegisteredError;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CompraNotaRegistradorServiceImpl implements ICompraNotaRegistro {
	private static final Logger LOG = LoggerFactory.getLogger(CompraNotaRegistradorServiceImpl.class);
	private final CompraNotaRepository repository;
	private final EventBus eventBus;
	private final QueryBus queryBus;
	private final CompraNotaValidador validador;

	public CompraNotaRegistradorServiceImpl(CompraNotaRepository pRepository, EventBus pEventBus, QueryBus pQueryBus,
			CompraNotaValidador pValidador) {
		this.repository = pRepository;
		this.eventBus = pEventBus;
		this.queryBus = pQueryBus;
		this.validador = pValidador;
	}

	@Override
	public void registrar(CompraNotaId pId, CompraNotaNitProveedor pNitProveedor, CompraNotaNumeroNota pNumeroNota,
			CompraNotaCodigoAutorizacion pCodigoAutorizacion, CompraNotaFechaNota pFechaNota,
			CompraNotaImporteTotalNota pImporteTotalNota, CompraNotaCodigoControlNota pCodigoControlNota,
			CompraNotaCompraId pCompraId, CompraNotaTipoDocumentoCliente pTipoDocumentoCliente,
			CompraNotaNumeroDocumentoCliente pNumeroDocumentoCliente,
			CompraNotaComplementoDocumentoCliente pComplementoDocumentoCliente, CompraNotaNombreCliente pNombreCliente,
			CompraNotaOrigenId pOrigenId, CompraNotaUsuarioRegistro pUsuarioRegistro)
			throws QueryNotRegisteredError, QueryHandlerExecutionError {

//TODO VALORES NULOS
		ValidationResponse vResultadoValidacion = validador.validarCompraNota(new HashMap<>() {
			{
				put("id", pId.value() != null ? pId.value() : "");
				put("nitProveedor", pNitProveedor.value() != null ? pNitProveedor.value().toString() : "");
				put("numeroNota", pNumeroNota.value() != null ? pNumeroNota.value().toString() : "");
				put("codigoAutorizacion", pCodigoAutorizacion.value() != null ? pCodigoAutorizacion.value() : "");
				put("fechaNota", pFechaNota.value() != null ? pFechaNota.value().toString() : "");
				put("importeTotalNota", pImporteTotalNota.value() != null ? pImporteTotalNota.value().toString() : "");
				put("compraId", pCompraId.value() != null ? pCompraId.value() : "");
				put("tipoDocumentoCliente", pTipoDocumentoCliente.value() != null ? pTipoDocumentoCliente.value() : "");
				put("numeroDocumentoCliente",
						pNumeroDocumentoCliente.value() != null ? pNumeroDocumentoCliente.value() : "");
				put("nombreCliente", pNombreCliente.value() != null ? pNombreCliente.value() : "");
				put("origenId", pOrigenId.value() != null ? pOrigenId.value() : "");
				put("usuarioRegistro", pUsuarioRegistro.value() != null ? pUsuarioRegistro.value().toString() : "");
			}
		});

		if (vResultadoValidacion.hasErrors()) {
			throw new CompraNotaListaErrores(pId, vResultadoValidacion);
		}

		ContribuyenteResponse contribuyenteResponse = pNitProveedor.value() == null ? null
				: queryBus.ask(new BuscarContribuyentePorNitQueryDto(pNitProveedor.value()));
		CompraNotaIfcProveedor ifcProveedor = new CompraNotaIfcProveedor(contribuyenteResponse.ifc());
		CompraNotaRazonSocialProveedor razonSocialProveedor = new CompraNotaRazonSocialProveedor(
				contribuyenteResponse.razonSocial());

		CompraNota vCompraNota = CompraNota.registro(pId, ifcProveedor, pNitProveedor, razonSocialProveedor,
				pNumeroNota, pCodigoAutorizacion, pFechaNota, pImporteTotalNota, pCodigoControlNota, pCompraId,
				pTipoDocumentoCliente, pNumeroDocumentoCliente, pComplementoDocumentoCliente, pNombreCliente, pOrigenId,
				pUsuarioRegistro);

		// verificaCodigoAutorizacionRepository.verificaCodigoAutorizacion(vCompra).ifPresent(
		// System.out::println);

		repository.BuscarCompraNotaExistente(vCompraNota).ifPresentOrElse(compra -> {
			throw new CompraNotaListaErrores(compra.id(), crearValidacionCompraNotaExistente());
		}, () -> {
			try {
				repository.guardar(vCompraNota);
				eventBus.publish(vCompraNota.pullDomainEvents());
			} catch (Exception excepcion) {
				System.out.println(excepcion);
				LOG.error(excepcion.getCause().toString(), excepcion);
			}
		});

	}

	private ValidationResponse crearValidacionCompraNotaExistente() {
		return new ValidationResponse(new HashMap<>() {
			{
				put("nitProveedor", Arrays.asList(EnumFacFrvccMensajesShared.COMPRA_YA_EXISTE.getId()));
			}
		});
	}

}