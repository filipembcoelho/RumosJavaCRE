package com.filipemcoelho.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByClientId", query = "SELECT c FROM Client c WHERE c.clientId = :clientId")
    , @NamedQuery(name = "Client.findByFirstName", query = "SELECT c FROM Client c WHERE c.firstName = :firstName")
    , @NamedQuery(name = "Client.findByLastName", query = "SELECT c FROM Client c WHERE c.lastName = :lastName")
    , @NamedQuery(name = "Client.findByTin", query = "SELECT c FROM Client c WHERE c.tin = :tin")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CLIENT_ID")
    private Integer clientId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LAST_NAME")
    private String lastName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TIN")
    private String tin;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Invoice> invoiceList;

    public Client() {
    }

    public Client(Integer clientId) {
        this.clientId = clientId;
    }

    public Client(Integer clientId, String firstName, String lastName, String tin) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tin = tin;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    @XmlTransient
    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.filipemcoelho.entities.Client[ clientId=" + clientId + " ]";
    }

}
