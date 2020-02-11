package com.filipemcoelho.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "groupmembers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupmembers.findAll", query = "SELECT g FROM Groupmembers g")
    , @NamedQuery(name = "Groupmembers.findByGName", query = "SELECT g FROM Groupmembers g WHERE g.groupmembersPK.gName = :gName")
    , @NamedQuery(name = "Groupmembers.findByGMember", query = "SELECT g FROM Groupmembers g WHERE g.groupmembersPK.gMember = :gMember")})
public class Groupmembers implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected GroupmembersPK groupmembersPK;

    @JoinColumn(name = "G_NAME", referencedColumnName = "G_NAME", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Groups groups;

    public Groupmembers() {
    }

    public Groupmembers(GroupmembersPK groupmembersPK) {
        this.groupmembersPK = groupmembersPK;
    }

    public Groupmembers(String gName, String gMember) {
        this.groupmembersPK = new GroupmembersPK(gName, gMember);
    }

    public GroupmembersPK getGroupmembersPK() {
        return groupmembersPK;
    }

    public void setGroupmembersPK(GroupmembersPK groupmembersPK) {
        this.groupmembersPK = groupmembersPK;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupmembersPK != null ? groupmembersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupmembers)) {
            return false;
        }
        Groupmembers other = (Groupmembers) object;
        if ((this.groupmembersPK == null && other.groupmembersPK != null) || (this.groupmembersPK != null && !this.groupmembersPK.equals(other.groupmembersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.filipemcoelho.entities.Groupmembers[ groupmembersPK=" + groupmembersPK + " ]";
    }

}
