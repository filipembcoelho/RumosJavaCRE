package com.filipemcoelho.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g")
    , @NamedQuery(name = "Groups.findByGName", query = "SELECT g FROM Groups g WHERE g.gName = :gName")
    , @NamedQuery(name = "Groups.findByGDescription", query = "SELECT g FROM Groups g WHERE g.gDescription = :gDescription")})
public class Groups implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "G_NAME")
    private String gName;

    @Size(max = 1000)
    @Column(name = "G_DESCRIPTION")
    private String gDescription;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groups")
    private List<Groupmembers> groupmembersList;

    public Groups() {
    }

    public Groups(String gName) {
        this.gName = gName;
    }

    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    public String getGDescription() {
        return gDescription;
    }

    public void setGDescription(String gDescription) {
        this.gDescription = gDescription;
    }

    @XmlTransient
    public List<Groupmembers> getGroupmembersList() {
        return groupmembersList;
    }

    public void setGroupmembersList(List<Groupmembers> groupmembersList) {
        this.groupmembersList = groupmembersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gName != null ? gName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.gName == null && other.gName != null) || (this.gName != null && !this.gName.equals(other.gName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.filipemcoelho.entities.Groups[ gName=" + gName + " ]";
    }

}
