package bo.gob.sin.sre.fac.frvcc.misfacturas.service.sucursal_usuario.find;


import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.SucursalUsuarioResponse;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.primary.sucursal_usuario.SucursalUsuarioResponseGenerico;
import bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.sucursal_usuario.validadores.SucursalUsuarioValidador;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioNoExist;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.sucursal_usuario.ISucursalUsuarioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;

@Service
public class SucursalUsuarioBuscadorService {
    private final ISucursalUsuarioRepository repository;
    private final SucursalUsuarioValidador validador;
    public SucursalUsuarioBuscadorService(ISucursalUsuarioRepository pRepository, SucursalUsuarioValidador pValidador) {
        this.repository = pRepository;
        this.validador=pValidador;
        
    }

    public SucursalUsuarioResponse find(SucursalUsuarioId pId) {
    	SucursalUsuario vSucursalUsuario =repository.search(pId).orElseThrow(()-> new SucursalUsuarioNoExist(pId));
        return  new SucursalUsuarioResponse(SucursalUsuarioResponseGenerico.fromAggregate(vSucursalUsuario));
    }
}
