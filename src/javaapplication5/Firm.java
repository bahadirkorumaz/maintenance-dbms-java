/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author koran
 */
@Entity
@Table(name = "firm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Firm.findAll", query = "SELECT f FROM Firm f")
    , @NamedQuery(name = "Firm.findByFirmID", query = "SELECT f FROM Firm f WHERE f.firmID = :firmID")
    , @NamedQuery(name = "Firm.findByFirmName", query = "SELECT f FROM Firm f WHERE f.firmName = :firmName")
    , @NamedQuery(name = "Firm.findByFirmPhone", query = "SELECT f FROM Firm f WHERE f.firmPhone = :firmPhone")
    , @NamedQuery(name = "Firm.findByFirmMail", query = "SELECT f FROM Firm f WHERE f.firmMail = :firmMail")})
public class Firm implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "firmID")
    private Integer firmID;
    @Basic(optional = false)
    @Column(name = "firmName")
    private String firmName;
    @Column(name = "firmPhone")
    private String firmPhone;
    @Column(name = "firmMail")
    private String firmMail;
    @OneToMany(mappedBy = "maintenanceFirmID")
    private Collection<Maintenance> maintenanceCollection;
    @OneToMany(mappedBy = "maintenanceFirmID")
    private Collection<Machinetypes> machinetypesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "firmID")
    private Collection<Users> usersCollection;

    public Firm() {
    }

    public Firm(Integer firmID) {
        this.firmID = firmID;
    }

    public Firm(Integer firmID, String firmName) {
        this.firmID = firmID;
        this.firmName = firmName;
    }

    public Integer getFirmID() {
        return firmID;
    }

    public void setFirmID(Integer firmID) {
        Integer oldFirmID = this.firmID;
        this.firmID = firmID;
        changeSupport.firePropertyChange("firmID", oldFirmID, firmID);
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        String oldFirmName = this.firmName;
        this.firmName = firmName;
        changeSupport.firePropertyChange("firmName", oldFirmName, firmName);
    }

    public String getFirmPhone() {
        return firmPhone;
    }

    public void setFirmPhone(String firmPhone) {
        String oldFirmPhone = this.firmPhone;
        this.firmPhone = firmPhone;
        changeSupport.firePropertyChange("firmPhone", oldFirmPhone, firmPhone);
    }

    public String getFirmMail() {
        return firmMail;
    }

    public void setFirmMail(String firmMail) {
        String oldFirmMail = this.firmMail;
        this.firmMail = firmMail;
        changeSupport.firePropertyChange("firmMail", oldFirmMail, firmMail);
    }

    @XmlTransient
    public Collection<Maintenance> getMaintenanceCollection() {
        return maintenanceCollection;
    }

    public void setMaintenanceCollection(Collection<Maintenance> maintenanceCollection) {
        this.maintenanceCollection = maintenanceCollection;
    }

    @XmlTransient
    public Collection<Machinetypes> getMachinetypesCollection() {
        return machinetypesCollection;
    }

    public void setMachinetypesCollection(Collection<Machinetypes> machinetypesCollection) {
        this.machinetypesCollection = machinetypesCollection;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (firmID != null ? firmID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Firm)) {
            return false;
        }
        Firm other = (Firm) object;
        if ((this.firmID == null && other.firmID != null) || (this.firmID != null && !this.firmID.equals(other.firmID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication5.Firm[ firmID=" + firmID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
