package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.sucursal_usuario;


import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.Formulario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.formularios.FormularioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuario;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.sucursal_usuario.SucursalUsuarioId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.formularios.FormularioRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.sucursal_usuario.ISucursalUsuarioRepository;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.SpringDataRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.str.constantes.estado.ConstEstado;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional("misfacturas-transaction_manager")
public class PostgreSqlSucursalUsuarioRepository extends SpringDataRepository<SucursalUsuario> implements ISucursalUsuarioRepository {
    public PostgreSqlSucursalUsuarioRepository(@Qualifier("misfacturas-session-factory")
                                                  SessionFactory sessionFactory) {

        super(sessionFactory, SucursalUsuario.class);
    }

    @Override
    public void save(SucursalUsuario formulario) {
        super.save(formulario);

    }
    @Override
    public Optional<SucursalUsuario> search(SucursalUsuarioId id) {
        return byId(id);
    }

    @Override
    public Optional<SucursalUsuario> BuscarSucursalUsuarioExistente(SucursalUsuario pSucursalUsuario) {
        Filters filters = new Filters(Arrays.asList(
                Filter.create("nitAgente","=",pSucursalUsuario.nitAgente().value().toString()),
                Filter.create("nroSucursal","=",pSucursalUsuario.nroSucursal().value().toString()),
                Filter.create("usuarioReceptor","=",pSucursalUsuario.usuarioReceptor().value().toString()),
                Filter.create("estadoAsignacionId","=",ConstEstado.ESTADO_ACTIVO),
                Filter.create("estadoId","=", ConstEstado.ESTADO_ACTIVO)
        ).stream().filter(filter -> filter !=null).collect(Collectors.toList()));
        Criteria criteria = new Criteria(filters, Order.none(), Optional.of(Integer.valueOf(1)), Optional.empty());
        return  this.findAll(criteria).get().findFirst();
    }

    @Override
    public Optional<SucursalUsuario> findById(SucursalUsuarioId id) {
        return byId(id);
    }



    @Override
    public Pagina<SucursalUsuario> BuscarPorCriteria(Criteria criteria) {
        Page<SucursalUsuario> vResult = this.findAll(criteria);

        return new Pagina<>(vResult.getTotalPages(),vResult.getTotalElements(),vResult.getContent());
    }

    @Override
    public Long countByCriteria(Criteria criteria) {
        return byCriteriaCount(criteria);
    }
}
