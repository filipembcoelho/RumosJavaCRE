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
@Table(name = "category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
    , @NamedQuery(name = "Category.findByCategoryId", query = "SELECT c FROM Category c WHERE c.categoryId = :categoryId")
    , @NamedQuery(name = "Category.findByName", query = "SELECT c FROM Category c WHERE c.name = :name")
    , @NamedQuery(name = "Category.findByLastUpdatedBy", query = "SELECT c FROM Category c WHERE c.lastUpdatedBy = :lastUpdatedBy")
    , @NamedQuery(name = "Category.findByLastUpdatedDate", query = "SELECT c FROM Category c WHERE c.lastUpdatedDate = :lastUpdatedDate")
    , @NamedQuery(name = "Category.findByCreatedBy", query = "SELECT c FROM Category c WHERE c.createdBy = :createdBy")
    , @NamedQuery(name = "Category.findByCreatedDate", query = "SELECT c FROM Category c WHERE c.createdDate = :createdDate")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private List<Product> productList;

    public Category() {
    }

    public Category(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Category(Integer categoryId, String name, String lastUpdatedBy, Date lastUpdatedDate, String createdBy, Date createdDate) {
        this.categoryId = categoryId;
        this.name = name;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedDate = lastUpdatedDate;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.filipemcoelho.entities.Category[ categoryId=" + categoryId + " ]";
    }

}
