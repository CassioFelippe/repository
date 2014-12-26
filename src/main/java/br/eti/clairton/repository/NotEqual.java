package br.eti.clairton.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

public class NotEqual implements Comparator {
	private static final long serialVersionUID = 1L;
    @Override
    public Predicate build(CriteriaBuilder cb, Expression<?> x, Object y) {
        return cb.notEqual(x, y);
    }
    
    @Override
    public String toString() {
    	return "<>";
    }
}
