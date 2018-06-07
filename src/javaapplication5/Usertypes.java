/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author koran
 */
@Entity
@Table(name = "usertypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usertypes.findAll", query = "SELECT u FROM Usertypes u")
    , @NamedQuery(name = "Usertypes.findByTypeID", query = "SELECT u FROM Usertypes u WHERE u.typeID = :typeID")
    , @NamedQuery(name = "Usertypes.findByTypeName", query = "SELECT u FROM Usertypes u WHERE u.typeName = :typeName")})
public class Usertypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "typeID")
    private Integer typeID;
    @Basic(optional = false)
    @Column(name = "typeName")
    private String typeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeID")
    private Collection<Users> usersCollection;

    public Usertypes() {
    }

    public Usertypes(Integer typeID) {
        this.typeID = typeID;
    }

    public Usertypes(Integer typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
        hash += (typeID != null ? typeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertypes)) {
            return false;
        }
        Usertypes other = (Usertypes) object;
        if ((this.typeID == null && other.typeID != null) || (this.typeID != null && !this.typeID.equals(other.typeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication5.Usertypes[ typeID=" + typeID + " ]";
    }
    
}
