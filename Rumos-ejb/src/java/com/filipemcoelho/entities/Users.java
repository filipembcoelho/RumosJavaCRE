package com.filipemcoelho.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUName", query = "SELECT u FROM Users u WHERE u.uName = :uName")
    , @NamedQuery(name = "Users.findByUPassword", query = "SELECT u FROM Users u WHERE u.uPassword = :uPassword")
    , @NamedQuery(name = "Users.findByUDescription", query = "SELECT u FROM Users u WHERE u.uDescription = :uDescription")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "U_NAME")
    private String uName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "U_PASSWORD")
    private String uPassword;

    @Size(max = 1000)
    @Column(name = "U_DESCRIPTION")
    private String uDescription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "credential")
    private List<Person> personList;

    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private Person userId;

    public Users() {
    }

    public Users(String uName) {
        this.uName = uName;
    }

    public Users(String uName, String uPassword) {
        this.uName = uName;
        this.uPassword = uPassword;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getUDescription() {
        return uDescription;
    }

    public void setUDescription(String uDescription) {
        this.uDescription = uDescription;
    }

    @XmlTransient
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Person getUserId() {
        return userId;
    }

    public void setUserId(Person userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uName != null ? uName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.uName == null && other.uName != null) || (this.uName != null && !this.uName.equals(other.uName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.filipemcoelho.entities.Users[ uName=" + uName + " ]";
    }

}
