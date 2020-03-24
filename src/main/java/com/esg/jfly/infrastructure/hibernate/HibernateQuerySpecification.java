/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esg.jfly.infrastructure.hibernate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author euler
 * @param <T>
 */
@SuppressWarnings("squid:S2326")
public abstract class HibernateQuerySpecification<T extends Serializable>  {
    protected final StringBuilder text = new StringBuilder();
    protected final Map<String, Object> params = new HashMap<>();

    public String getText() {
        return text.toString();
    }

    public Map<String, Object> getParams() {
        return params;
    }
    
    public void configurar() {
    }
    
}