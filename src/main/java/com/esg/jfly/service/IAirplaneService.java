/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esg.jfly.service;

import com.esg.jfly.domain.entity.Airplane;
import java.util.List;

/**
 *
 * @author euler
 */
public interface IAirplaneService {
    List<Airplane> findAllAirplanes();
    
}
