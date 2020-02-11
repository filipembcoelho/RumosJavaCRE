/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipemcoelho.model;

import com.filipemcoelho.entities.InvoiceLines;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author filip
 */
@Stateless
public class InvoiceLinesFacade extends AbstractFacade<InvoiceLines> {

    @PersistenceContext(unitName = "RumosProject-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvoiceLinesFacade() {
        super(InvoiceLines.class);
    }
    
    public List<InvoiceLines> findById(String invoiceId){
        return em.createNamedQuery("Client.InvoiceLines.findByInvoiceId", InvoiceLines.class).setParameter("invoiceId", invoiceId).getResultList();
    }
}
