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
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author koran
 */
@Entity
@Table(name = "machinetypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Machinetypes.findAll", query = "SELECT m FROM Machinetypes m")
    , @NamedQuery(name = "Machinetypes.findByTypeID", query = "SELECT m FROM Machinetypes m WHERE m.typeID = :typeID")
    , @NamedQuery(name = "Machinetypes.findByModelName", query = "SELECT m FROM Machinetypes m WHERE m.modelName = :modelName")
    , @NamedQuery(name = "Machinetypes.findByMaintenancePeriod", query = "SELECT m FROM Machinetypes m WHERE m.maintenancePeriod = :maintenancePeriod")
    , @NamedQuery(name = "Machinetypes.findByLastMaintenanceDate", query = "SELECT m FROM Machinetypes m WHERE m.lastMaintenanceDate = :lastMaintenanceDate")})
public class Machinetypes implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "typeID")
    private Integer typeID;
    @Basic(optional = false)
    @Column(name = "modelName")
    private String modelName;
    @Basic(optional = false)
    @Column(name = "maintenancePeriod")
    private int maintenancePeriod;
    @Column(name = "lastMaintenanceDate")
    @Temporal(TemporalType.DATE)
    private Date lastMaintenanceDate;
    @OneToMany(mappedBy = "typeID")
    private Collection<Machines> machinesCollection;
    @OneToMany(mappedBy = "machinetypeID")
    private Collection<Maintenance> maintenanceCollection;
    @JoinColumn(name = "maintenanceFirmID", referencedColumnName = "firmID")
    @ManyToOne
    private Firm maintenanceFirmID;

    public Machinetypes() {
    }

    public Machinetypes(Integer typeID) {
        this.typeID = typeID;
    }

    public Machinetypes(Integer typeID, String modelName, int maintenancePeriod) {
        this.typeID = typeID;
        this.modelName = modelName;
        this.maintenancePeriod = maintenancePeriod;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        Integer oldTypeID = this.typeID;
        this.typeID = typeID;
        changeSupport.firePropertyChange("typeID", oldTypeID, typeID);
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        String oldModelName = this.modelName;
        this.modelName = modelName;
        changeSupport.firePropertyChange("modelName", oldModelName, modelName);
    }

    public int getMaintenancePeriod() {
        return maintenancePeriod;
    }

    public void setMaintenancePeriod(int maintenancePeriod) {
        int oldMaintenancePeriod = this.maintenancePeriod;
        this.maintenancePeriod = maintenancePeriod;
        changeSupport.firePropertyChange("maintenancePeriod", oldMaintenancePeriod, maintenancePeriod);
    }

    public Date getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(Date lastMaintenanceDate) {
        Date oldLastMaintenanceDate = this.lastMaintenanceDate;
        this.lastMaintenanceDate = lastMaintenanceDate;
        changeSupport.firePropertyChange("lastMaintenanceDate", oldLastMaintenanceDate, lastMaintenanceDate);
    }

    @XmlTransient
    public Collection<Machines> getMachinesCollection() {
        return machinesCollection;
    }

    public void setMachinesCollection(Collection<Machines> machinesCollection) {
        this.machinesCollection = machinesCollection;
    }

    @XmlTransient
    public Collection<Maintenance> getMaintenanceCollection() {
        return maintenanceCollection;
    }

    public void setMaintenanceCollection(Collection<Maintenance> maintenanceCollection) {
        this.maintenanceCollection = maintenanceCollection;
    }

    public Firm getMaintenanceFirmID() {
        return maintenanceFirmID;
    }

    public void setMaintenanceFirmID(Firm maintenanceFirmID) {
        Firm oldMaintenanceFirmID = this.maintenanceFirmID;
        this.maintenanceFirmID = maintenanceFirmID;
        changeSupport.firePropertyChange("maintenanceFirmID", oldMaintenanceFirmID, maintenanceFirmID);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeID != null ? typeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Machinetypes)) {
            return false;
        }
        Machinetypes other = (Machinetypes) object;
        if ((this.typeID == null && other.typeID != null) || (this.typeID != null && !this.typeID.equals(other.typeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication5.Machinetypes[ typeID=" + typeID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
