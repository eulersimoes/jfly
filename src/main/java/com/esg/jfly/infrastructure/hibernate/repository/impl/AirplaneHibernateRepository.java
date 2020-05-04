/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esg.jfly.infrastructure.hibernate.repository.impl;

import com.esg.jfly.infrastructure.repository.IAirPlaneRepository;
import com.esg.jfly.domain.entity.Airplane;
import com.esg.jfly.infrastructure.hibernate.repository.HibernateRepository;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author euler
 */
public class AirplaneHibernateRepository extends HibernateRepository<Airplane, Long> implements IAirPlaneRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public AirplaneHibernateRepository() {
        super(Airplane.class);
    }

    @Override
    public void save(Airplane airplane) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Airplane airplane) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Airplane> listAllAirplanes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
