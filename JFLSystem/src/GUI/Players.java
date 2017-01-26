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
@Table(name = "PLAYERS", catalog = "", schema = "JFLADMIN")
@NamedQueries({
    @NamedQuery(name = "Players.findAll", query = "SELECT p FROM Players p")
    , @NamedQuery(name = "Players.findByPlayerid", query = "SELECT p FROM Players p WHERE p.playerid = :playerid")
    , @NamedQuery(name = "Players.findByPlayername", query = "SELECT p FROM Players p WHERE p.playername = :playername")
    , @NamedQuery(name = "Players.findByAge", query = "SELECT p FROM Players p WHERE p.age = :age")
    , @NamedQuery(name = "Players.findByTeamid", query = "SELECT p FROM Players p WHERE p.teamid = :teamid")
    , @NamedQuery(name = "Players.findByCaptain", query = "SELECT p FROM Players p WHERE p.captain = :captain")
    , @NamedQuery(name = "Players.findByPosition", query = "SELECT p FROM Players p WHERE p.position = :position")})
public class Players implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PLAYERID")
    private Integer playerid;
    @Basic(optional = false)
    @Column(name = "PLAYERNAME")
    private String playername;
    @Basic(optional = false)
    @Column(name = "AGE")
    private int age;
    @Basic(optional = false)
    @Column(name = "TEAMID")
    private int teamid;
    @Basic(optional = false)
    @Column(name = "CAPTAIN")
    private Boolean captain;
    @Column(name = "POSITION")
    private String position;

    public Players() {
    }

    public Players(Integer playerid) {
        this.playerid = playerid;
    }

    public Players(Integer playerid, String playername, int age, int teamid, Boolean captain) {
        this.playerid = playerid;
        this.playername = playername;
        this.age = age;
        this.teamid = teamid;
        this.captain = captain;
    }

    public Integer getPlayerid() {
        return playerid;
    }

    public void setPlayerid(Integer playerid) {
        Integer oldPlayerid = this.playerid;
        this.playerid = playerid;
        changeSupport.firePropertyChange("playerid", oldPlayerid, playerid);
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        String oldPlayername = this.playername;
        this.playername = playername;
        changeSupport.firePropertyChange("playername", oldPlayername, playername);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        int oldAge = this.age;
        this.age = age;
        changeSupport.firePropertyChange("age", oldAge, age);
    }

    public int getTeamid() {
        return teamid;
    }

    public void setTeamid(int teamid) {
        int oldTeamid = this.teamid;
        this.teamid = teamid;
        changeSupport.firePropertyChange("teamid", oldTeamid, teamid);
    }

    public Boolean getCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        Boolean oldCaptain = this.captain;
        this.captain = captain;
        changeSupport.firePropertyChange("captain", oldCaptain, captain);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        String oldPosition = this.position;
        this.position = position;
        changeSupport.firePropertyChange("position", oldPosition, position);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playerid != null ? playerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Players)) {
            return false;
        }
        Players other = (Players) object;
        if ((this.playerid == null && other.playerid != null) || (this.playerid != null && !this.playerid.equals(other.playerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GUI.Players[ playerid=" + playerid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
