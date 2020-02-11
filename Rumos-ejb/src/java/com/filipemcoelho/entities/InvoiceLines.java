package com.filipemcoelho.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "invoice_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceLines.findAll", query = "SELECT i FROM InvoiceLines i")
    , @NamedQuery(name = "InvoiceLines.findByInvoiceId", query = "SELECT i FROM InvoiceLines i WHERE i.invoiceLinesPK.invoiceId = :invoiceId")
    , @NamedQuery(name = "InvoiceLines.findByProductId", query = "SELECT i FROM InvoiceLines i WHERE i.invoiceLinesPK.productId = :productId")
    , @NamedQuery(name = "InvoiceLines.findByQuantity", query = "SELECT i FROM InvoiceLines i WHERE i.quantity = :quantity")
    , @NamedQuery(name = "InvoiceLines.findByPrice", query = "SELECT i FROM InvoiceLines i WHERE i.price = :price")})
public class InvoiceLines implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected InvoiceLinesPK invoiceLinesPK;

    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;

    @JoinColumn(name = "INVOICE_ID", referencedColumnName = "INVOICE_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Invoice invoice;

    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public InvoiceLines() {
    }

    public InvoiceLines(InvoiceLinesPK invoiceLinesPK) {
        this.invoiceLinesPK = invoiceLinesPK;
    }

    public InvoiceLines(InvoiceLinesPK invoiceLinesPK, int quantity, double price) {
        this.invoiceLinesPK = invoiceLinesPK;
        this.quantity = quantity;
        this.price = price;
    }

    public InvoiceLines(int invoiceId, int productId) {
        this.invoiceLinesPK = new InvoiceLinesPK(invoiceId, productId);
    }

    public InvoiceLinesPK getInvoiceLinesPK() {
        return invoiceLinesPK;
    }

    public void setInvoiceLinesPK(InvoiceLinesPK invoiceLinesPK) {
        this.invoiceLinesPK = invoiceLinesPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceLinesPK != null ? invoiceLinesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceLines)) {
            return false;
        }
        InvoiceLines other = (InvoiceLines) object;
        if ((this.invoiceLinesPK == null && other.invoiceLinesPK != null) || (this.invoiceLinesPK != null && !this.invoiceLinesPK.equals(other.invoiceLinesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.filipemcoelho.entities.InvoiceLines[ invoiceLinesPK=" + invoiceLinesPK + " ]";
    }

}
