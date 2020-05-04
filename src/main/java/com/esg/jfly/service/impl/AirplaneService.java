/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esg.jfly.service.impl;

import com.esg.jfly.domain.entity.Airplane;
import com.esg.jfly.infrastructure.hibernate.repository.impl.AirplaneHibernateRepository;
import com.esg.jfly.service.IAirplaneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author euler
 */
@Service("AirplaneService")
public class AirplaneService implements IAirplaneService{
    
    @Autowired
    AirplaneHibernateRepository airplaneHibernateRepository;

    @Override
    public List<Airplane> findAllAirplanes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
