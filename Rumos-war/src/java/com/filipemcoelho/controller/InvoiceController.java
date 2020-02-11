package com.filipemcoelho.controller;

import com.filipemcoelho.entities.Client;
import com.filipemcoelho.entities.Invoice;
import com.filipemcoelho.entities.InvoiceLines;
import com.filipemcoelho.entities.Person;
import com.filipemcoelho.model.ClientFacade;
import com.filipemcoelho.model.PersonFacade;
import com.filipemcoelho.model.InvoiceFacade;
import com.filipemcoelho.model.InvoiceLinesFacade;
import com.filipemcoelho.model.ProductFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named(value = "invoiceController")
@SessionScoped
public class InvoiceController implements Serializable {

    @EJB
    private ProductFacade productFacade;

    @EJB
    private InvoiceLinesFacade invoiceLinesFacade;

    @EJB
    private ClientFacade clientFacade;

    @EJB
    private InvoiceFacade invoiceFacade;

    @EJB
    private PersonFacade personFacade;

    private String clientId;

    private String sellerId;

    private Invoice invoice = new Invoice();

    private List<Invoice> invoices;

    private Invoice selectedInvoice;

    private List<Invoice> selectedInvoices;

    private List<Invoice> filteredInvoices;

    private InvoiceLines invoiceLine = new InvoiceLines();

    private String productId;

    public InvoiceController() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<Invoice> getInvoices() {
        if (invoices == null) {
            this.invoices = findAllInvoices();
        }
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Invoice getSelectedInvoice() {
        return selectedInvoice;
    }

    public void setSelectedInvoice(Invoice selectedInvoice) {
        System.out.println(selectedInvoice);
        this.selectedInvoice = selectedInvoice;
    }

    public List<Invoice> getSelectedInvoices() {
        return selectedInvoices;
    }

    public void setSelectedInvoices(List<Invoice> selectedInvoices) {
        this.selectedInvoices = selectedInvoices;
    }

    public List<Invoice> getFilteredInvoices() {
        return filteredInvoices;
    }

    public void setFilteredInvoices(List<Invoice> filteredInvoices) {
        this.filteredInvoices = filteredInvoices;
    }

    public InvoiceLines getInvoiceLine() {
        return invoiceLine;
    }

    public void setInvoiceLine(InvoiceLines invoiceLine) {
        this.invoiceLine = invoiceLine;
    }

    public void addInvoice() {

        invoice.setClient(clientFacade.find(Integer.parseInt(clientId)));
        invoice.setPerson(personFacade.find(Integer.parseInt(sellerId)));
        invoice.setInvoiceDate(new Date());

        invoice.setCreatedBy("FC");
        invoice.setLastUpdatedBy("FMBRC");
        invoice.setCreatedDate(new Date());
        invoice.setLastUpdatedDate(new Date());
        invoiceFacade.create(this.invoice);

        System.out.println(invoice);

        invoice = new Invoice();

    }

    private List<InvoiceLines> lines;

    public List<InvoiceLines> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLines> lines) {
        this.lines = lines;
    }

    public void addInvoiceLine() {
        if(lines == null)
            lines = new ArrayList<>();
        // Get product from selectonemenu
        invoiceLine.setProduct(productFacade.find(Integer.parseInt(productId)));
        // Add product price to the price of the invoice line
        invoiceLine.setPrice(invoiceLine.getProduct().getPrice());
        //add invoice line to invoicelinelist
        lines.add(invoiceLine);
        // reset
//        invoiceLine = new InvoiceLines();
    }

    public void editInvoice() {
        invoiceFacade.edit(selectedInvoice);
        selectedInvoice = new Invoice();
    }

    public void deleteInvoice() {
        invoiceFacade.remove(invoice);
    }

    public List<Invoice> findAllInvoices() {
        return invoiceFacade.findAll();
    }

    public List<Person> findAllEmployees() {
        return personFacade.findAll();
    }

    public List<Client> findAllClients() {
        return clientFacade.findAll();
    }

    public String calculateTotal(int qty, double pri) {
//        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
//        System.out.println("com.filipemcoelho.controller.InvoiceController.calculateTotal() " + params.get("quantity") + " " + params.get("price"));
//        int quantity = Integer.parseInt(params.get("quantity"));
//        double price = Double.parseDouble(params.get("price"));
//        int quantity = Integer.parseInt(qty);
//        double price = Double.parseDouble(pri);
        int quantity = qty;
        double price = pri;
        System.out.println("Total is: " + (quantity * price));

        return String.valueOf(quantity * price);
    }

}
