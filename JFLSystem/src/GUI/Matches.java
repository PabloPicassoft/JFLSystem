/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Paul
 */
@Entity
@Table(name = "MATCHES", catalog = "", schema = "JFLADMIN")
@NamedQueries({
    @NamedQuery(name = "Matches.findAll", query = "SELECT m FROM Matches m")
    , @NamedQuery(name = "Matches.findByMatchid", query = "SELECT m FROM Matches m WHERE m.matchid = :matchid")
    , @NamedQuery(name = "Matches.findByMatchdate", query = "SELECT m FROM Matches m WHERE m.matchdate = :matchdate")
    , @NamedQuery(name = "Matches.findByHometeam", query = "SELECT m FROM Matches m WHERE m.hometeam = :hometeam")
    , @NamedQuery(name = "Matches.findByHomescore", query = "SELECT m FROM Matches m WHERE m.homescore = :homescore")
    , @NamedQuery(name = "Matches.findByAwayteam", query = "SELECT m FROM Matches m WHERE m.awayteam = :awayteam")
    , @NamedQuery(name = "Matches.findByAwayscore", query = "SELECT m FROM Matches m WHERE m.awayscore = :awayscore")
    , @NamedQuery(name = "Matches.findByReferee", query = "SELECT m FROM Matches m WHERE m.referee = :referee")})
public class Matches implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MATCHID")
    private Integer matchid;
    @Basic(optional = false)
    @Column(name = "MATCHDATE")
    @Temporal(TemporalType.DATE)
    private Date matchdate;
    @Basic(optional = false)
    @Column(name = "HOMETEAM")
    private String hometeam;
    @Basic(optional = false)
    @Column(name = "HOMESCORE")
    private String homescore;
    @Basic(optional = false)
    @Column(name = "AWAYTEAM")
    private String awayteam;
    @Basic(optional = false)
    @Column(name = "AWAYSCORE")
    private String awayscore;
    @Basic(optional = false)
    @Column(name = "REFEREE")
    private int referee;

    public Matches() {
    }

    public Matches(Integer matchid) {
        this.matchid = matchid;
    }

    public Matches(Integer matchid, Date matchdate, String hometeam, String homescore, String awayteam, String awayscore, int referee) {
        this.matchid = matchid;
        this.matchdate = matchdate;
        this.hometeam = hometeam;
        this.homescore = homescore;
        this.awayteam = awayteam;
        this.awayscore = awayscore;
        this.referee = referee;
    }

    public Integer getMatchid() {
        return matchid;
    }

    public void setMatchid(Integer matchid) {
        Integer oldMatchid = this.matchid;
        this.matchid = matchid;
        changeSupport.firePropertyChange("matchid", oldMatchid, matchid);
    }

    public Date getMatchdate() {
        return matchdate;
    }

    public void setMatchdate(Date matchdate) {
        Date oldMatchdate = this.matchdate;
        this.matchdate = matchdate;
        changeSupport.firePropertyChange("matchdate", oldMatchdate, matchdate);
    }

    public String getHometeam() {
        return hometeam;
    }

    public void setHometeam(String hometeam) {
        String oldHometeam = this.hometeam;
        this.hometeam = hometeam;
        changeSupport.firePropertyChange("hometeam", oldHometeam, hometeam);
    }

    public String getHomescore() {
        return homescore;
    }

    public void setHomescore(String homescore) {
        String oldHomescore = this.homescore;
        this.homescore = homescore;
        changeSupport.firePropertyChange("homescore", oldHomescore, homescore);
    }

    public String getAwayteam() {
        return awayteam;
    }

    public void setAwayteam(String awayteam) {
        String oldAwayteam = this.awayteam;
        this.awayteam = awayteam;
        changeSupport.firePropertyChange("awayteam", oldAwayteam, awayteam);
    }

    public String getAwayscore() {
        return awayscore;
    }

    public void setAwayscore(String awayscore) {
        String oldAwayscore = this.awayscore;
        this.awayscore = awayscore;
        changeSupport.firePropertyChange("awayscore", oldAwayscore, awayscore);
    }

    public int getReferee() {
        return referee;
    }

    public void setReferee(int referee) {
        int oldReferee = this.referee;
        this.referee = referee;
        changeSupport.firePropertyChange("referee", oldReferee, referee);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matchid != null ? matchid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matches)) {
            return false;
        }
        Matches other = (Matches) object;
        if ((this.matchid == null && other.matchid != null) || (this.matchid != null && !this.matchid.equals(other.matchid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GUI.Matches[ matchid=" + matchid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
