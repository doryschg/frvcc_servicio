package bo.gob.sin.sre.fac.frvcc.misfacturas.adapters.secundary.compras_notas;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNota;
import bo.gob.sin.sre.fac.frvcc.misfacturas.model.compras_notas.CompraNotaId;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.compras_notas.CompraNotaRepository;
import bo.gob.sin.sre.fac.frvcc.misfacturas.use.ports.secundary.shared.Pagina;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring.SpringDataRepository;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filters;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Order;
import bo.gob.sin.sre.fac.frvcc.shared.use.ports.primary.Service;
import bo.gob.sin.str.constantes.estado.ConstEstado;

@Service
@Transactional("misfacturas-transaction_manager")
public class PostgreSqlCompraNotaRepository extends SpringDataRepository<CompraNota> implements CompraNotaRepository {

	public PostgreSqlCompraNotaRepository(@Qualifier("misfacturas-session-factory") SessionFactory sessionFactory) {
		super(sessionFactory, CompraNota.class);
	}

	@Override
	public void guardar(CompraNota pCompraNota) {
		super.save(pCompraNota);
	}
	
	@Override
    public void guardarTodo(List<CompraNota> pComprasNotas) {
        persisteAll(pComprasNotas);
    }
	
	@Override
	public Optional<CompraNota> findById(CompraNotaId id) {
		return byId(id);

	}
	
	@Override
	public Optional<CompraNota> BuscarCompraNotaExistente(CompraNota pCompra) {

//	    Optional<CompraNota> vCompra = findById(pCompra.id());
//	    if (!vCompra.isEmpty()){
//             return vCompra;
//        }
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
				Filter.create("compraId","=",pCompra.compraId().value()),
				complemento.strip().length() > 0 ? Filter.create("complementoDocumentoCliente","=",complemento) : null,
				Filter.create("nitProveedor","=",pCompra.nitProveedor().value().toString()),
				Filter.create("codigoAutorizacion","=",pCompra.codigoAutorizacion().value()),
				Filter.create("numeroNota","=",pCompra.numeroNota().value().toString()),
				Filter.create("importeTotalNota","=",pCompra.importeTotalNota().value().toString()),
				Filter.create("fechaNota","=",pCompra.fechaNota().value().toString()),
				pCompra.codigoControlNota().value() != null ? 
						Filter.create("codigoControlNota","=",pCompra.codigoControlNota().value()) : null,
                Filter.create("estadoId","=", ConstEstado.ESTADO_ACTIVO)


		).stream().filter(filter -> filter !=null).collect(Collectors.toList()));
		Criteria criteria = new Criteria(filters, Order.none(), Optional.of(Integer.valueOf(1)), Optional.empty());
		return  this.findAll(criteria).get().findFirst();
	}
	
	@Override
	public Pagina<CompraNota> matching(Criteria criteria) {

		Page<CompraNota> vResult = this.findAll(criteria);

		return new Pagina<>(vResult.getTotalPages(),vResult.getTotalElements(),vResult.getContent());
	}

	@Override
	public Long countByCriteria(Criteria criteria) {
		return byCriteriaCount(criteria);
	}


}
