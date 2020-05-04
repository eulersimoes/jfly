/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esg.jfly.infrastructure.repository;

import com.esg.jfly.domain.entity.Airplane;
import java.util.List;
/**
 *
 * @author euler
 */
public interface IAirPlaneRepository {
    void save(Airplane airplane);
    void delete(Airplane airplane);
    List<Airplane> listAllAirplanes();
    
}
