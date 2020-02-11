/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipemcoelho.model;

import com.filipemcoelho.entities.Groupmembers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author filip
 */
@Stateless
public class GroupmembersFacade extends AbstractFacade<Groupmembers> {

    @PersistenceContext(unitName = "RumosProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupmembersFacade() {
        super(Groupmembers.class);
    }
    
}
