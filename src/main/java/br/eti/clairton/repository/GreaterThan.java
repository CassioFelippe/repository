package br.eti.clairton.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

public class GreaterThan implements Comparator {
	private static final long serialVersionUID = 1L;
    @Override
    public Predicate build(final CriteriaBuilder cb, final Expression<?> x, final Object y) {
        @SuppressWarnings("rawtypes")
        final Expression w = x;
        @SuppressWarnings("rawtypes")
        final Comparable k = ( Comparable ) y;
        @SuppressWarnings("unchecked")
        final Predicate p = cb.greaterThan(w, k);
        return p;
    }

    @Override
    public String toString() {
        return ">";
    }
}
