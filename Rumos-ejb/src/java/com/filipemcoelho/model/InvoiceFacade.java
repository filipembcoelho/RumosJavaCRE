/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipemcoelho.model;

import com.filipemcoelho.entities.Invoice;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author filip
 */
@Stateless
public class InvoiceFacade extends AbstractFacade<Invoice> {

    @PersistenceContext(unitName = "RumosProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvoiceFacade() {
        super(Invoice.class);
    }
    
}
