/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esg.jfly.domain.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import com.esg.jfly.domain.entity.IEntity;

/**
 *
 * @author euler
 */
@javax.persistence.Entity
@Table(name = "AIRPLANE", schema = "jfly")
public class Airplane implements IEntity<Long> {
    @Id
    private Long id;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
}
