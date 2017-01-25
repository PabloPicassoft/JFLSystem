/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "COACHES", catalog = "", schema = "JFLADMIN")
@NamedQueries({
    @NamedQuery(name = "Coaches.findAll", query = "SELECT c FROM Coaches c")
    , @NamedQuery(name = "Coaches.findByCoachid", query = "SELECT c FROM Coaches c WHERE c.coachid = :coachid")
    , @NamedQuery(name = "Coaches.findByCoachname", query = "SELECT c FROM Coaches c WHERE c.coachname = :coachname")})
public class Coaches implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COACHID")
    private Integer coachid;
    @Column(name = "COACHNAME")
    private String coachname;

    public Coaches() {
    }

    public Coaches(Integer coachid) {
        this.coachid = coachid;
    }

    public Integer getCoachid() {
        return coachid;
    }

    public void setCoachid(Integer coachid) {
        Integer oldCoachid = this.coachid;
        this.coachid = coachid;
        changeSupport.firePropertyChange("coachid", oldCoachid, coachid);
    }

    public String getCoachname() {
        return coachname;
    }

    public void setCoachname(String coachname) {
        String oldCoachname = this.coachname;
        this.coachname = coachname;
        changeSupport.firePropertyChange("coachname", oldCoachname, coachname);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coachid != null ? coachid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coaches)) {
            return false;
        }
        Coaches other = (Coaches) object;
        if ((this.coachid == null && other.coachid != null) || (this.coachid != null && !this.coachid.equals(other.coachid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GUI.Coaches[ coachid=" + coachid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
