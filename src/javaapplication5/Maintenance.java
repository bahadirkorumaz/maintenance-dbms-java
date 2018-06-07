/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author koran
 */
@Entity
@Table(name = "maintenance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maintenance.findAll", query = "SELECT m FROM Maintenance m")
    , @NamedQuery(name = "Maintenance.findByMaintenanceID", query = "SELECT m FROM Maintenance m WHERE m.maintenanceID = :maintenanceID")
    , @NamedQuery(name = "Maintenance.findByPlannedDate", query = "SELECT m FROM Maintenance m WHERE m.plannedDate = :plannedDate")})
public class Maintenance implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maintenanceID")
    private Integer maintenanceID;
    @Column(name = "plannedDate")
    private String plannedDate;
    @JoinColumn(name = "maintenanceFirmID", referencedColumnName = "firmID")
    @ManyToOne
    private Firm maintenanceFirmID;
    @JoinColumn(name = "machinetypeID", referencedColumnName = "typeID")
    @ManyToOne
    private Machinetypes machinetypeID;

    public Maintenance() {
    }

    public Maintenance(Integer maintenanceID) {
        this.maintenanceID = maintenanceID;
    }

    public Integer getMaintenanceID() {
        return maintenanceID;
    }

    public void setMaintenanceID(Integer maintenanceID) {
        Integer oldMaintenanceID = this.maintenanceID;
        this.maintenanceID = maintenanceID;
        changeSupport.firePropertyChange("maintenanceID", oldMaintenanceID, maintenanceID);
    }

    public String getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(String plannedDate) {
        String oldPlannedDate = this.plannedDate;
        this.plannedDate = plannedDate;
        changeSupport.firePropertyChange("plannedDate", oldPlannedDate, plannedDate);
    }

    public Firm getMaintenanceFirmID() {
        return maintenanceFirmID;
    }

    public void setMaintenanceFirmID(Firm maintenanceFirmID) {
        Firm oldMaintenanceFirmID = this.maintenanceFirmID;
        this.maintenanceFirmID = maintenanceFirmID;
        changeSupport.firePropertyChange("maintenanceFirmID", oldMaintenanceFirmID, maintenanceFirmID);
    }

    public Machinetypes getMachinetypeID() {
        return machinetypeID;
    }

    public void setMachinetypeID(Machinetypes machinetypeID) {
        Machinetypes oldMachinetypeID = this.machinetypeID;
        this.machinetypeID = machinetypeID;
        changeSupport.firePropertyChange("machinetypeID", oldMachinetypeID, machinetypeID);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maintenanceID != null ? maintenanceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maintenance)) {
            return false;
        }
        Maintenance other = (Maintenance) object;
        if ((this.maintenanceID == null && other.maintenanceID != null) || (this.maintenanceID != null && !this.maintenanceID.equals(other.maintenanceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication5.Maintenance[ maintenanceID=" + maintenanceID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
