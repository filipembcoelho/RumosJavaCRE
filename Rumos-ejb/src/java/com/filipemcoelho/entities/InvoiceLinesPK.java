package com.filipemcoelho.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class InvoiceLinesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "INVOICE_ID")
    private int invoiceId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCT_ID")
    private int productId;

    public InvoiceLinesPK() {
    }

    public InvoiceLinesPK(int invoiceId, int productId) {
        this.invoiceId = invoiceId;
        this.productId = productId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) invoiceId;
        hash += (int) productId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceLinesPK)) {
            return false;
        }
        InvoiceLinesPK other = (InvoiceLinesPK) object;
        if (this.invoiceId != other.invoiceId) {
            return false;
        }
        if (this.productId != other.productId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.filipemcoelho.entities.InvoiceLinesPK[ invoiceId=" + invoiceId + ", productId=" + productId + " ]";
    }

}
