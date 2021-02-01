package bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.sucursal_usuario;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.Compra;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.hformularios.HFormulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface ISucursalUsuarioRepository {
    void save(SucursalUsuario course);

    Optional<SucursalUsuario> search(SucursalUsuarioId id);
    Optional<SucursalUsuario> BuscarSucursalUsuarioExistente(SucursalUsuario vSucursalUsuario);
    Pagina<SucursalUsuario> BuscarPorCriteria(Criteria criteria);
    Long countByCriteria(Criteria criteria);
    Optional<SucursalUsuario> findById(SucursalUsuarioId id) ;
}
