package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras.*;
import bo.gob.sin.sre.fac.frvcc.misfacturas.shared.domain.compra.CompraContribuyente;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras.CompraRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.SpringDataRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.OrderBy;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.OrderType;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.str.constantes.estado.ConstEstado;

import javax.persistence.Query;

@Service
@Transactional("misfacturas-transaction_manager")
public class PostgreSqlCompraRepository extends SpringDataRepository<Compra> implements CompraRepository {

	public PostgreSqlCompraRepository(@Qualifier("misfacturas-session-factory") SessionFactory sessionFactory) {
		super(sessionFactory, Compra.class);
	}

	@Override
	public void guardar(Compra pCompra) {
		super.save(pCompra);
	}

	@Override
	public void persist(Compra pCompra) {
		super.persist(pCompra);
	}

    @Override
    public void guardarTodo(List<Compra> pCompras) {
        super.persisteAll(pCompras);
    }

    @Override
	public Optional<Compra> findById(CompraId id) {
		return byId(id);

	}

	@Override
	public Optional<Compra> BuscarCompraExistente(Compra pCompra) {
        String complemento ="";

        
        if(pCompra.complementoDocumentoCliente() != null)
        {
        	if(pCompra.complementoDocumentoCliente().value()!=null)
        	{
        		 complemento=pCompra.complementoDocumentoCliente().value();
        	
        	}
        	 
        }
       

		Filters filters = new Filters(Arrays.asList(
				Filter.create("numeroDocumentoCliente","=",pCompra.numeroDocumentoCliente().value()),
				Filter.create("tipoDocumentoCliente","=",pCompra.tipoDocumentoCliente().value()),
				complemento.strip().length() > 0 ? Filter.create("complementoDocumentoCliente","=",complemento) : null,
				Filter.create("nitProveedor","=",pCompra.nitProveedor().value().toString()),
				Filter.create("codigoAutorizacion","=",pCompra.codigoAutorizacion().value()),
				Filter.create("numeroFactura","=",pCompra.numeroFactura().value().toString()),
                Filter.create("estadoId","=", ConstEstado.ESTADO_ACTIVO)


		).stream().filter(filter -> filter !=null).collect(Collectors.toList()));
		Criteria criteria = new Criteria(filters, Order.none(), Optional.of(Integer.valueOf(1)), Optional.empty());
		return  this.findAll(criteria).get().findFirst();
	}
	
	
	@Override
	public Optional<Compra> BuscarCompraEstandarExistente(Compra pCompra) {
		String complemento = "";

		if (pCompra.complementoDocumentoCliente() != null) {
			if (pCompra.complementoDocumentoCliente().value() != null) {
				complemento = pCompra.complementoDocumentoCliente().value();
			}

		}
		Filters filters = new Filters(Arrays.asList(
				Filter.create("numeroDocumentoCliente","=",pCompra.numeroDocumentoCliente().value()),
				Filter.create("tipoDocumentoCliente","=",pCompra.tipoDocumentoCliente().value()),
				complemento.strip().length() > 0 ? Filter.create("complementoDocumentoCliente","=",complemento) : null,
				Filter.create("nitProveedor","=",pCompra.nitProveedor().value().toString()),
				Filter.create("codigoAutorizacion","=",pCompra.codigoAutorizacion().value()),
				Filter.create("numeroFactura","=",pCompra.numeroFactura().value().toString()),
				Filter.create("numeroDui","=",pCompra.numeroDui().value().toString()),
                Filter.create("estadoId","=", ConstEstado.ESTADO_ACTIVO)


		).stream().filter(filter -> filter !=null).collect(Collectors.toList()));
		Criteria criteria = new Criteria(filters, Order.none(), Optional.of(Integer.valueOf(1)), Optional.empty());
		return  this.findAll(criteria).get().findFirst();
	}

	@Override
	public Pagina<Compra> matching(Criteria criteria) {

		Page<Compra> vResult = this.findAll(criteria);

		return new Pagina<>(vResult.getTotalPages(),vResult.getTotalElements(),vResult.getContent());
	}

	@Override
	public Long countByCriteria(Criteria criteria) {
		return byCriteriaCount(criteria);
	}

    @Override
    public List<Compra> ListaDeComprasPorIds(List<String> PListaIdsCompras) {


		String listaInIdsCompras = PListaIdsCompras.stream().collect(Collectors.joining(","));
		Criteria criteria = new Criteria (
				new Filters(Arrays.asList(
						Filter.create("id", "IN",listaInIdsCompras),
						Filter.create("estadoId","=", ConstEstado.ESTADO_ACTIVO)
				)), new Order(new OrderBy("fechaFactura"), OrderType.ASC)
		);

		return  this.byCriteria(criteria);
    }

	@Override
	public HashMap<Long, CompraContribuyente> proveedoresRecurrentes() {
		HashMap<Long,CompraContribuyente> contribuyentes = new HashMap<>();
		String stringQuery = "SELECT count(c.nitProveedor) as cantidad,  c.nitProveedor, c.ifcProveedorNb, c.razonSocialProveedor FROM Compra c GROUP BY c.nitProveedor, c.ifcProveedorNb, c.razonSocialProveedor ORDER BY cantidad DESC";
		Query query = sessionFactory.getCurrentSession().createQuery(stringQuery);
		List<Object[]> resultList = query.getResultList();
		for (Object[] compra: resultList) {
			contribuyentes.put(Long.parseLong(compra[0].toString()),new CompraContribuyente(
					((CompraNitProveedor) compra[1]).value(),
					((CompraIfcProveedorNb) compra[2]).value(),
					((CompraRazonSocialProveedor)compra[3]).value()));
		}

		return contribuyentes;
	}


}
