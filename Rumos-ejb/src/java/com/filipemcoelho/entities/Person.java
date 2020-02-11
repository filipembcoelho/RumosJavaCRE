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
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
    , @NamedQuery(name = "Person.findByUserId", query = "SELECT p FROM Person p WHERE p.userId = :userId")
    , @NamedQuery(name = "Person.findByFirstName", query = "SELECT p FROM Person p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "Person.findByLastName", query = "SELECT p FROM Person p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "Person.findByBirthDate", query = "SELECT p FROM Person p WHERE p.birthDate = :birthDate")
    , @NamedQuery(name = "Person.findByTin", query = "SELECT p FROM Person p WHERE p.tin = :tin")
    , @NamedQuery(name = "Person.findByLastUpdatedBy", query = "SELECT p FROM Person p WHERE p.lastUpdatedBy = :lastUpdatedBy")
    , @NamedQuery(name = "Person.findByLastUpdatedDate", query = "SELECT p FROM Person p WHERE p.lastUpdatedDate = :lastUpdatedDate")
    , @NamedQuery(name = "Person.findByCreatedBy", query = "SELECT p FROM Person p WHERE p.createdBy = :createdBy")
    , @NamedQuery(name = "Person.findByCreatedDate", query = "SELECT p FROM Person p WHERE p.createdDate = :createdDate")})
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private Integer userId;

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

    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TIN")
    private String tin;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administratorId")
    private List<Product> productList;
    @JoinColumn(name = "CREDENTIAL", referencedColumnName = "U_NAME")
    @ManyToOne(optional = false)
    private Users credential;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Invoice> invoiceList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Users> usersList;

    public Person() {
    }

    public Person(Integer userId) {
        this.userId = userId;
    }

    public Person(Integer userId, String firstName, String lastName, String tin, String lastUpdatedBy, Date lastUpdatedDate, String createdBy, Date createdDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tin = tin;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedDate = lastUpdatedDate;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
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

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Users getCredential() {
        return credential;
    }

    public void setCredential(Users credential) {
        this.credential = credential;
    }

    @XmlTransient
    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @XmlTransient
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.filipemcoelho.entities.Person[ userId=" + userId + " ]";
    }

}
