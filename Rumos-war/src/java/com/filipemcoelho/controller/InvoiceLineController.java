/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipemcoelho.controller;

import com.filipemcoelho.entities.Invoice;
import com.filipemcoelho.entities.InvoiceLines;
import com.filipemcoelho.model.InvoiceLinesFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author filip
 */
@Named(value = "invoiceLineController")
@SessionScoped
public class InvoiceLineController implements Serializable {

    @EJB
    private InvoiceLinesFacade invoiceLinesFacade;

    private Invoice selectedInvoice;

    private InvoiceLines invoiceLines;

    public InvoiceLineController() {
    }

    public Invoice getSelectedInvoice() {
        return selectedInvoice;
    }

    public void setSelectedInvoice(Invoice selectedInvoice) {
        this.selectedInvoice = selectedInvoice;
    }

    public InvoiceLines getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(InvoiceLines invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

}
