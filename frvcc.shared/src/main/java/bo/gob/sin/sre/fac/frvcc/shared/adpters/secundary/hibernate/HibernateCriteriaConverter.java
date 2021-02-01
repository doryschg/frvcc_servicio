package bo.gob.sin.sre.fac.frvcc.shared.adpters.secundary.hibernate;

import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Criteria;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.Filter;
import bo.gob.sin.sre.fac.frvcc.shared.model.criteria.FilterOperator;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public final class HibernateCriteriaConverter<T> {
    private final CriteriaBuilder                                                 builder;
    private final HashMap<FilterOperator, BiFunction<Expression, Object, Predicate>> predicateTransformers = new HashMap<FilterOperator, BiFunction<Expression , Object , Predicate>>() {{

        put(FilterOperator.EQUAL, HibernateCriteriaConverter.this::equalsPredicateTransformer);
        put(FilterOperator.NOT_EQUAL, HibernateCriteriaConverter.this::notEqualsPredicateTransformer);
        put(FilterOperator.GT, HibernateCriteriaConverter.this::greaterThanPredicateTransformer);
        put(FilterOperator.LT, HibernateCriteriaConverter.this::lowerThanPredicateTransformer);
        put(FilterOperator.GT_EQUAL, HibernateCriteriaConverter.this::greaterThanOrEqualToPredicateTransformer);
        put(FilterOperator.LT_ECUAL, HibernateCriteriaConverter.this::lessThanOrEqualToPredicateTransformer);
        put(FilterOperator.CONTAINS, HibernateCriteriaConverter.this::containsPredicateTransformer);
        put(FilterOperator.NOT_CONTAINS, HibernateCriteriaConverter.this::notContainsPredicateTransformer);
        put(FilterOperator.IN, HibernateCriteriaConverter.this::iNPredicateTransformer);
        put(FilterOperator.NOT_IN, HibernateCriteriaConverter.this::notInPredicateTransformer);
        put(FilterOperator.IS_NULL, HibernateCriteriaConverter.this::isNullPredicateTransformer);
        put(FilterOperator.IS_NOT_NULL, HibernateCriteriaConverter.this::isNotNullPredicateTransformer);
    }};

    private Predicate notInPredicateTransformer(Expression expression, Object object) {
        return  builder.not(expression.in(object.toString().split(",")));
    }

    public HibernateCriteriaConverter(CriteriaBuilder builder) {
        this.builder = builder;
    }

    public CriteriaQuery<T> convert(Criteria criteria, Class<T> aggregateClass) {
        CriteriaQuery<T> hibernateCriteria = builder.createQuery(aggregateClass);
        Root<T>          root              = hibernateCriteria.from(aggregateClass);

        hibernateCriteria.where(formatPredicates(criteria.filters().filters(), root));

        if (criteria.order().hasOrder()) {
            Path<Object> orderBy = root.get(criteria.order().orderBy().value());
            Order        order   = criteria.order().orderType().isAsc() ? builder.asc(orderBy) : builder.desc(orderBy);

            hibernateCriteria.orderBy(order);
        }

        return hibernateCriteria;
    }



    public Predicate[] formatPredicates(List<Filter> filters, Root<T> root) {
        List<Predicate> predicates = filters.stream().map(filter -> formatPredicate(
                filter,
                root
        )).collect(Collectors.toList());

        Predicate[] predicatesArray = new Predicate[predicates.size()];
        return predicates.toArray(predicatesArray);
    }

    private Predicate formatPredicate(Filter filter, Root<T> root) {
        BiFunction<Expression, Object, Predicate> transformer = predicateTransformers.get(filter.operator());


        Expression expression = root.get(filter.field().value()).get("value");
   Object object = filter.value().value();
        return transformer.apply(expression, object);
    }

    private Predicate equalsPredicateTransformer(Expression expression, Object object) {

        if(expression.getJavaType() == LocalDate.class){
          return   builder.equal(expression,LocalDate.parse(object.toString()));
        }

        if(expression.getJavaType() == LocalDateTime.class){
            return   builder.equal(expression,LocalDate.parse(object.toString()));
        }
        return builder.equal(expression,object);


    }

    private Predicate iNPredicateTransformer(Expression expression, Object object) {
              return expression.in(object.toString().split(","));

    }
    
    private Predicate isNullPredicateTransformer(Expression expression, Object object) {
        return expression.isNull();
    }


    private Predicate isNotNullPredicateTransformer(Expression expression, Object object) {
        return expression.isNotNull();
    }


    private Predicate notEqualsPredicateTransformer(Expression expression, Object object) {
        return builder.notEqual(expression,object);
    }

    private Predicate greaterThanPredicateTransformer(Expression expression, Object object)  {

        if(expression.getJavaType() == LocalDate.class){
            return   builder.greaterThan(expression,LocalDate.parse(object.toString()));
        }

        if(expression.getJavaType() == LocalDateTime.class){
            return   builder.greaterThan(expression,LocalDateTime.parse(object.toString()));
        }
        return builder.greaterThan(expression.as(expression.getJavaType()),object.toString());
    }


    private Predicate lowerThanPredicateTransformer(Expression expression, Object object) {

        if(expression.getJavaType() == LocalDate.class){
            return   builder.lessThan(expression,LocalDate.parse(object.toString()));
        }

        if(expression.getJavaType() == LocalDateTime.class){
            return   builder.lessThan(expression,LocalDateTime.parse(object.toString()));
        }

        return builder.lessThan(expression,object.toString());
    }

    private Predicate greaterThanOrEqualToPredicateTransformer(Expression expression, Object object) {

        if(expression.getJavaType() == LocalDate.class){
            return   builder.greaterThanOrEqualTo(expression,LocalDate.parse(object.toString()));
        }

        if(expression.getJavaType() == LocalDateTime.class){
            return   builder.greaterThanOrEqualTo(expression,LocalDateTime.parse(object.toString()));
        }

        return builder.lessThan(expression,object.toString());
    }

    private Predicate lessThanOrEqualToPredicateTransformer(Expression expression, Object object) {

        if(expression.getJavaType() == LocalDate.class){
            return   builder.lessThanOrEqualTo(expression,LocalDate.parse(object.toString()));
        }

        if(expression.getJavaType() == LocalDateTime.class){
            return   builder.lessThanOrEqualTo(expression,LocalDateTime.parse(object.toString()));
        }

        return builder.lessThan(expression,object.toString());
    }

    private Predicate containsPredicateTransformer(Expression expression, Object object) {
        return builder.like(expression, String.format("%%%s%%", object));
    }

    private Predicate notContainsPredicateTransformer(Expression expression, Object object) {
        return builder.notLike(expression, String.format("%%%s%%", object));
    }


}
