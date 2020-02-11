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
import javax.persistence.Lob;
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
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId")
    , @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name")
    , @NamedQuery(name = "Product.findByBrand", query = "SELECT p FROM Product p WHERE p.brand = :brand")
    , @NamedQuery(name = "Product.findByModel", query = "SELECT p FROM Product p WHERE p.model = :model")
    , @NamedQuery(name = "Product.findByYear", query = "SELECT p FROM Product p WHERE p.year = :year")
    , @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price")
    , @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity")
    , @NamedQuery(name = "Product.findByLastUpdatedBy", query = "SELECT p FROM Product p WHERE p.lastUpdatedBy = :lastUpdatedBy")
    , @NamedQuery(name = "Product.findByLastUpdatedDate", query = "SELECT p FROM Product p WHERE p.lastUpdatedDate = :lastUpdatedDate")
    , @NamedQuery(name = "Product.findByCreatedBy", query = "SELECT p FROM Product p WHERE p.createdBy = :createdBy")
    , @NamedQuery(name = "Product.findByCreatedDate", query = "SELECT p FROM Product p WHERE p.createdDate = :createdDate")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Size(max = 100)
    @Column(name = "NAME")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BRAND")
    private String brand;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MODEL")
    private String model;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Lob
    @Column(name = "IMAGE")
    private byte[] image;

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

    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID")
    @ManyToOne(optional = false)
    private Category categoryId;

    @JoinColumn(name = "ADMINISTRATOR_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private Person administratorId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<InvoiceLines> invoiceLinesList;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, String brand, String model, String lastUpdatedBy, Date lastUpdatedDate, String createdBy, Date createdDate) {
        this.productId = productId;
        this.brand = brand;
        this.model = model;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdatedDate = lastUpdatedDate;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Person getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Person administratorId) {
        this.administratorId = administratorId;
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
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.filipemcoelho.entities.Product[ productId=" + productId + " ]";
    }

}
