/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author koran
 */
@Entity
@Table(name = "machines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Machines.findAll", query = "SELECT m FROM Machines m")
    , @NamedQuery(name = "Machines.findByMachineID", query = "SELECT m FROM Machines m WHERE m.machineID = :machineID")
    , @NamedQuery(name = "Machines.findByProductionDate", query = "SELECT m FROM Machines m WHERE m.productionDate = :productionDate")
    , @NamedQuery(name = "Machines.findByLastWarrantyDate", query = "SELECT m FROM Machines m WHERE m.lastWarrantyDate = :lastWarrantyDate")
    , @NamedQuery(name = "Machines.findByFloor", query = "SELECT m FROM Machines m WHERE m.floor = :floor")
    , @NamedQuery(name = "Machines.findByRoom", query = "SELECT m FROM Machines m WHERE m.room = :room")})
public class Machines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "machineID")
    private Integer machineID;
    @Column(name = "productionDate")
    @Temporal(TemporalType.DATE)
    private Date productionDate;
    @Column(name = "lastWarrantyDate")
    @Temporal(TemporalType.DATE)
    private Date lastWarrantyDate;
    @Column(name = "floor")
    private Integer floor;
    @Column(name = "room")
    private String room;
    @JoinColumn(name = "typeID", referencedColumnName = "typeID")
    @ManyToOne
    private Machinetypes typeID;

    public Machines() {
    }

    public Machines(Integer machineID) {
        this.machineID = machineID;
    }

    public Integer getMachineID() {
        return machineID;
    }

    public void setMachineID(Integer machineID) {
        this.machineID = machineID;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getLastWarrantyDate() {
        return lastWarrantyDate;
    }

    public void setLastWarrantyDate(Date lastWarrantyDate) {
        this.lastWarrantyDate = lastWarrantyDate;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Machinetypes getTypeID() {
        return typeID;
    }

    public void setTypeID(Machinetypes typeID) {
        this.typeID = typeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (machineID != null ? machineID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Machines)) {
            return false;
        }
        Machines other = (Machines) object;
        if ((this.machineID == null && other.machineID != null) || (this.machineID != null && !this.machineID.equals(other.machineID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication5.Machines[ machineID=" + machineID + " ]";
    }
    
}
