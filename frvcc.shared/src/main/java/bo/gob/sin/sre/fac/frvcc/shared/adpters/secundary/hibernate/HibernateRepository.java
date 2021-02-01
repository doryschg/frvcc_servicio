package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.hibernate;

import bo.gob.sin.sre.fac.frvcc.shared.model.Identifier;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import org.hibernate.Cache;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public abstract class HibernateRepository<T> {
	protected final SessionFactory sessionFactory;
	protected final Class<T> aggregateClass;
	protected final HibernateCriteriaConverter criteriaConverter;

	public HibernateRepository(SessionFactory sessionFactory, Class<T> aggregateClass) {
		this.sessionFactory = sessionFactory;
		this.aggregateClass = aggregateClass;
		this.criteriaConverter = new HibernateCriteriaConverter<T>(sessionFactory.getCriteriaBuilder());
	}

	protected void persist(T entity) {
		sessionFactory.getCurrentSession().persist(entity);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
		clearCacheMemory();
	}

	protected void save(T entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
		clearCacheMemory();
	}

	protected void persisteAll(List<T> entities) {
		entities.forEach(x -> sessionFactory.getCurrentSession().saveOrUpdate(x));
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
		clearCacheMemory();
	}
	private void clearCacheMemory(){
		Cache cache = sessionFactory.getCache();
		if (cache != null) {
			cache.evictAllRegions();
			cache.evictDefaultQueryRegion();

		}
		//System.gc();
	}


	protected void persisteAllInsertOnly(List<T> entities) {
		long batchSize = sessionFactory.getProperties().get("hibernate.jdbc.batch_size") != null
				? Long.parseLong(sessionFactory.getProperties().get("hibernate.jdbc.batch_size").toString())
				: 1;

		for (T entity : entities) {
			int i = 0;
			sessionFactory.getCurrentSession().save(entity);
			if (i % batchSize == 0) {
				sessionFactory.getCurrentSession().flush();
				sessionFactory.getCurrentSession().clear();
			}
			i++;
		}
	}

	protected Optional<T> byId(Identifier id) {
		return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
	}

	protected List<T> byCriteria(Criteria criteria) {
		CriteriaQuery<T> hibernateCriteria = criteriaConverter.convert(criteria, aggregateClass);

		Query vQuery = sessionFactory.getCurrentSession().createQuery(hibernateCriteria);
		if (criteria.offset().isPresent()) {
			vQuery.setFirstResult(criteria.offset().get());
		}
		if (criteria.limit().isPresent()) {
			vQuery.setMaxResults(criteria.limit().get());
		}

		return vQuery.getResultList();
	}

	protected Long byCriteriaCount(Criteria criteria) {
		CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		criteriaQuery.select(criteriaBuilder.count(criteriaQuery.from(aggregateClass)));

		sessionFactory.getCurrentSession().createQuery(criteriaQuery);
		criteriaQuery.where(criteriaConverter.formatPredicates(criteria.filters().filters(),
				criteriaBuilder.createQuery(aggregateClass).from(aggregateClass)));

		Long countResult = sessionFactory.getCurrentSession().createQuery(criteriaQuery).getSingleResult();
		return countResult;
	}

	protected List<T> all() {
		CriteriaQuery<T> criteria = sessionFactory.getCriteriaBuilder().createQuery(aggregateClass);

		criteria.from(aggregateClass);

		return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
	}


}
