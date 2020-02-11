package com.filipemcoelho.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i")
    , @NamedQuery(name = "Invoice.findByInvoiceId", query = "SELECT i FROM Invoice i WHERE i.invoiceId = :invoiceId")
    , @NamedQuery(name = "Invoice.findByInvoiceDate", query = "SELECT i FROM Invoice i WHERE i.invoiceDate = :invoiceDate")
    , @NamedQuery(name = "Invoice.findByActive", query = "SELECT i FROM Invoice i WHERE i.active = :active")
    , @NamedQuery(name = "Invoice.findByLastUpdatedBy", query = "SELECT i FROM Invoice i WHERE i.lastUpdatedBy = :lastUpdatedBy")
    , @NamedQuery(name = "Invoice.findByLastUpdatedDate", query = "SELECT i FROM Invoice i WHERE i.lastUpdatedDate = :lastUpdatedDate")
    , @NamedQuery(name = "Invoice.findByCreatedBy", query = "SELECT i FROM Invoice i WHERE i.createdBy = :createdBy")
    , @NamedQuery(name = "Invoice.findByCreatedDate", query = "SELECT i FROM Invoice i WHERE i.createdDate = :createdDate")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "INVOICE_ID")
    private Integer invoiceId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INVOICE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceDate;
    @Size(max = 100)
    @Column(name = "ACTIVE")
    private String active;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LAST_UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumns({
        @JoinColumn(name = "CLIENT_ID", referencedColumnName = "CLIENT_ID")
        , @JoinColumn(name = "CLIENT_ID", referencedColumnName = "CLIENT_ID")})
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumns({
        @JoinColumn(name = "SELLER_ID", referencedColumnName = "USER_ID")
        , @JoinColumn(name = "SELLER_ID", referencedColumnName = "USER_ID")})
    @ManyToOne(optional = false)
    private Person person;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
    private List<InvoiceLines> invoiceLinesList;

    public Invoice() {
    }

    public Invoice(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Invoice(Integer invoiceId, Date invoiceDate, String lastUpdatedBy, Date lastUpdatedDate, String createdBy, Date createdDate) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedDate = lastUpdatedDate;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @XmlTransient
    public List<InvoiceLines> getInvoiceLinesList() {
        return invoiceLinesList;
    }

    public void setInvoiceLinesList(List<InvoiceLines> invoiceLinesList) {
        this.invoiceLinesList = invoiceLinesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoiceId == null && other.invoiceId != null) || (this.invoiceId != null && !this.invoiceId.equals(other.invoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.filipemcoelho.entities.Invoice[ invoiceId=" + invoiceId + " ]";
    }

}
