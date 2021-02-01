package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.spring;

import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class SpringDataRepository<T> extends HibernateRepository<T> {
	protected final SessionFactory sessionFactory;
	protected final Class<T> aggregateClass;
	static final Pageable DEFAULT_PAGE_REQUEST = PageRequest.of(0, Integer.MAX_VALUE);

	public SpringDataRepository(SessionFactory sessionFactory, Class<T> aggregateClass) {
		super(sessionFactory, aggregateClass);
		this.sessionFactory = sessionFactory;
		this.aggregateClass = aggregateClass;
	}

	protected Page<T> findAll(Criteria criteria) {
		Pageable pageable;
		pageable = criteria.offset().isPresent() && criteria.limit().isPresent()
				? PageRequest.of(criteria.offset().get(), criteria.limit().get())
				: DEFAULT_PAGE_REQUEST;

		CriteriaQuery<T> hibernateCriteria = criteriaConverter.convert(criteria, aggregateClass);
		return this.readPage(this.sessionFactory.getCurrentSession().createQuery(hibernateCriteria), aggregateClass,
				pageable, criteria);
	}

	private <S extends T> Page<S> readPage(TypedQuery<S> query, Class<S> domainClass, Pageable pageable,
			@Nullable Criteria criteria) {
		if (pageable.isPaged()) {
			query.setFirstResult((int) pageable.getOffset());
			query.setMaxResults(pageable.getPageSize());
		}

        Page<S> resultado = (Page<S>) PageableExecutionUtils.
				getPage((List<T>) query.getResultList(),
						pageable, () ->   executeCountQuery(this.getCountQuery(criteria, domainClass))
        );

        return resultado;
	}

	private <S extends T> TypedQuery<Long> getCountQuery(@Nullable Criteria criteria, Class<S> domainClass) {
		CriteriaBuilder builder = this.sessionFactory.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<S> root = this.applySpecificationToCriteria(criteria, domainClass, query);
		if (query.isDistinct()) {
			query.select(builder.countDistinct(root));
		} else {
			query.select(builder.count(root));
		}

		query.orderBy(Collections.emptyList());
		return this.sessionFactory.getCurrentSession().createQuery(query);
	}

	private <S, U extends T> Root<U> applySpecificationToCriteria(@Nullable Criteria criteria, Class<U> domainClass,
			CriteriaQuery<S> query) {
		Assert.notNull(domainClass, "Domain class must not be null!");
		Assert.notNull(query, "CriteriaQuery must not be null!");
		Root<U> root = query.from(domainClass);
		if (criteria == null) {
			return root;
		} else {
			CriteriaBuilder builder = this.sessionFactory.getCriteriaBuilder();
			Predicate[] predicates = this.criteriaConverter.formatPredicates(criteria.filters().filters(), root);
			if (predicates != null) {
				query.where(predicates);
			}

			return root;
		}
	}

	private static long executeCountQuery(TypedQuery<Long> query) {
		Assert.notNull(query, "TypedQuery must not be null!");
		List<Long> totals = query.getResultList();
		long total = 0L;

		Long element;
		for (Iterator var4 = totals.iterator(); var4.hasNext(); total += element == null ? 0L : element) {
			element = (Long) var4.next();
		}

		return total;
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
}
