package bo.gob.sin.sre.fac.frvcc.misfacturas.service.hformularios.registro_formulario_historico;

import java.util.List;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.CompraId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.hformularios.HFormularioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public final class Registro_formulario_historico {
	private static final Logger LOG= LoggerFactory.getLogger(Registro_formulario_historico.class);
    private final HFormularioRepository repository;

    public Registro_formulario_historico(HFormularioRepository repository) {
        this.repository = repository;
    }


    public  void registrar(HFormularioHistoricoId id,
                           HFormularioId formularioId,
                           HFormularioNumeroOrden numeroOrden,
                           HFormularioEstadoFormularioId estadoFormularioId,
                           HFormularioUsuarioRegistro usuarioRegistro,
                           HFormularioTotalComprasCfIpn totalComprasCfIpn,
                           HFormularioTotalComprasCfOtras totalComprasCfOtras,
                           HFormularioTotalComprasSdCf totalComprasSdCf,
                           HFormularioTotalComprasCfRed totalComprasCfRed,
                           HFormularioTotalComprasCfIpnRed totalComprasCfIpnRed,
                           HFormularioTotalComprasCfOtrasRed totalComprasCfOtrasRed,
                           HFormularioTotalComprasSdCfRed totalComprasSdCfRed,
                           HFormularioDeterminacionPagoCfRed determinacionPagoCfRed,
                           HFormularioDeterminacionPagoCfIpnRed determinacionPagoCfIpnRed,
                           HFormularioDeterminacionPagoCfOtrasRed determinacionPagoCfOtrasRed,
                           HFormularioDeterminacionPagoSdCfRed determinacionPagoSdCfRed, List<CompraId> compraIds) {
        if(!repository.search(id).isPresent()){
            HFormulario hFormulario= HFormulario.registro(id,formularioId,
                    estadoFormularioId,numeroOrden,usuarioRegistro, 
                    totalComprasCfIpn, totalComprasCfOtras,
                    totalComprasSdCf,compraIds,
                    totalComprasCfRed,
                    totalComprasCfIpnRed,
                    totalComprasCfOtrasRed,
                    totalComprasSdCfRed,
                    determinacionPagoCfRed,
                    determinacionPagoCfIpnRed,
                    determinacionPagoCfOtrasRed,
                    determinacionPagoSdCfRed);
            try {
            repository.save(hFormulario);
        	
			} catch (Exception excepcion) {
    	  		LOG.error(excepcion.getCause().toString(), excepcion);
			}
        }
    }
}
