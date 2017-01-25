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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "TEAMS", catalog = "", schema = "JFLADMIN")
@NamedQueries({
    @NamedQuery(name = "Teams.findAll", query = "SELECT t FROM Teams t")
    , @NamedQuery(name = "Teams.findByTeamid", query = "SELECT t FROM Teams t WHERE t.teamid = :teamid")
    , @NamedQuery(name = "Teams.findByTeamname", query = "SELECT t FROM Teams t WHERE t.teamname = :teamname")
    , @NamedQuery(name = "Teams.findByCoachid", query = "SELECT t FROM Teams t WHERE t.coachid = :coachid")
    , @NamedQuery(name = "Teams.findByTeammanager", query = "SELECT t FROM Teams t WHERE t.teammanager = :teammanager")})
public class Teams implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TEAMID")
    private Integer teamid;
    @Basic(optional = false)
    @Column(name = "TEAMNAME")
    private String teamname;
    @Basic(optional = false)
    @Column(name = "COACHID")
    private int coachid;
    @Basic(optional = false)
    @Column(name = "TEAMMANAGER")
    private int teammanager;

    public Teams() {
    }

    public Teams(Integer teamid) {
        this.teamid = teamid;
    }

    public Teams(Integer teamid, String teamname, int coachid, int teammanager) {
        this.teamid = teamid;
        this.teamname = teamname;
        this.coachid = coachid;
        this.teammanager = teammanager;
    }

    public Integer getTeamid() {
        return teamid;
    }

    public void setTeamid(Integer teamid) {
        Integer oldTeamid = this.teamid;
        this.teamid = teamid;
        changeSupport.firePropertyChange("teamid", oldTeamid, teamid);
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        String oldTeamname = this.teamname;
        this.teamname = teamname;
        changeSupport.firePropertyChange("teamname", oldTeamname, teamname);
    }

    public int getCoachid() {
        return coachid;
    }

    public void setCoachid(int coachid) {
        int oldCoachid = this.coachid;
        this.coachid = coachid;
        changeSupport.firePropertyChange("coachid", oldCoachid, coachid);
    }

    public int getTeammanager() {
        return teammanager;
    }

    public void setTeammanager(int teammanager) {
        int oldTeammanager = this.teammanager;
        this.teammanager = teammanager;
        changeSupport.firePropertyChange("teammanager", oldTeammanager, teammanager);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamid != null ? teamid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teams)) {
            return false;
        }
        Teams other = (Teams) object;
        if ((this.teamid == null && other.teamid != null) || (this.teamid != null && !this.teamid.equals(other.teamid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GUI.Teams[ teamid=" + teamid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
