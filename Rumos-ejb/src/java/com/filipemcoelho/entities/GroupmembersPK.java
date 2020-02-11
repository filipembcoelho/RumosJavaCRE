package com.filipemcoelho.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class GroupmembersPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "G_NAME")
    private String gName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "G_MEMBER")
    private String gMember;

    public GroupmembersPK() {
    }

    public GroupmembersPK(String gName, String gMember) {
        this.gName = gName;
        this.gMember = gMember;
    }

    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    public String getGMember() {
        return gMember;
    }

    public void setGMember(String gMember) {
        this.gMember = gMember;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gName != null ? gName.hashCode() : 0);
        hash += (gMember != null ? gMember.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupmembersPK)) {
            return false;
        }
        GroupmembersPK other = (GroupmembersPK) object;
        if ((this.gName == null && other.gName != null) || (this.gName != null && !this.gName.equals(other.gName))) {
            return false;
        }
        if ((this.gMember == null && other.gMember != null) || (this.gMember != null && !this.gMember.equals(other.gMember))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.filipemcoelho.entities.GroupmembersPK[ gName=" + gName + ", gMember=" + gMember + " ]";
    }

}
