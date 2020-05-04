/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esg.jfly.infrastructure.hibernate.repository;

import com.esg.jfly.infrastructure.hibernate.HibernateQuerySpecification;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.Collection;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import com.esg.jfly.domain.entity.IEntity;

/**
 *
 * @author euler
 * @param <E>
 * @param <I>
 */
@SuppressWarnings("findsecbugs:SQL_INJECTION_HIBERNATE")
public class HibernateRepository<E extends IEntity, I extends Serializable> {
    @Autowired
    private SessionFactory sessionFactory;
    private final Class<E> clazz;

    public HibernateRepository(Class<E> clazz) {
        this.clazz = clazz;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Query createHibernateQuery(HibernateQuerySpecification query) {
        query.configurar();
        Query q = getSession().createQuery(query.getText());
        adicionarParametros(q, query);
        return q;
    }

    protected Query createSQLHibernateQuery(HibernateQuerySpecification query, Map<String, Type> scalars) {
        query.configurar();
        SQLQuery q = getSession().createSQLQuery(query.getText());
        adicionarParametros(q, query);
        for (Map.Entry<String, Type> en : scalars.entrySet()) {
            String key = en.getKey();
            Type value = en.getValue();
            q.addScalar(key, value);
        }
        return q;
    }

    private Query adicionarParametros(Query q, HibernateQuerySpecification query) {
        query.getParams().keySet().forEach(param -> {
            Object paramValue = query.getParams().get(param);
            if (paramValue instanceof Collection) {
                q.setParameterList((String) param, (Collection) query.getParams().get(param));
            } else {
                q.setParameter((String) param, paramValue);
            }
        });

        return q;
    }

    public List<E> buscar(Order... orders) {
        Criteria criteria = getSession().createCriteria(clazz);
        for (Order order : orders) {
            criteria.addOrder(order);
        }
        return criteria.list();
    }
    
    public List<E> buscar() {
        return getSession().createCriteria(clazz).list();
    }

    public E obter(I id) {
        return (E) getSession().get(clazz, id);
    }

    public void remover(E e) {
        getSession().delete(e);
    }

    public void armazenar(E e) {
        getSession().persist(e);
    }

    public void mesclar(E e) {
        getSession().merge(e);
    }

    public List list(HibernateQuerySpecification query) {
        return list(query, null, null);
    }

    public List listSQL(HibernateQuerySpecification query, Map<String, Type> scalars) {
        Query q = createSQLHibernateQuery(query, scalars);
        return q.list();
    }

    public List list(HibernateQuerySpecification query, Integer max, Integer pagina) {
        Query q = createHibernateQuery(query);
        if (max != null) {
            q.setMaxResults(max);
            if (pagina != null) {
                q.setFirstResult(max * pagina);
            }
        }
        return q.list();
    }

    public Object uniqueResult(HibernateQuerySpecification query) {
        Query q = createHibernateQuery(query);
        return q.uniqueResult();
    }

}
