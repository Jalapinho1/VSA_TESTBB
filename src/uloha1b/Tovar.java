/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uloha1b;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eduardo Martinez
 */
@Entity
@Table(name = "TOVAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tovar.findAll", query = "SELECT t FROM Tovar t"),
    @NamedQuery(name = "Tovar.findByNazov", query = "SELECT t FROM Tovar t WHERE t.nazov = :nazov"),
    @NamedQuery(name = "Tovar.findByMnozstvo", query = "SELECT t FROM Tovar t WHERE t.mnozstvo = :mnozstvo"),
    @NamedQuery(name = "Tovar.findByCena", query = "SELECT t FROM Tovar t WHERE t.cena = :cena")})
public class Tovar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NAZOV")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String nazov;
    @Basic(optional = false)
    @Column(name = "MNOZSTVO")
    private int mnozstvo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CENA")
    private Double cena;

    public Tovar() {
    }

    public Tovar(String nazov) {
        this.nazov = nazov;
    }

    public Tovar(String nazov, int mnozstvo) {
        this.nazov = nazov;
        this.mnozstvo = mnozstvo;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public int getMnozstvo() {
        return mnozstvo;
    }

    public void setMnozstvo(int mnozstvo) {
        this.mnozstvo = mnozstvo;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nazov != null ? nazov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tovar)) {
            return false;
        }
        Tovar other = (Tovar) object;
        if ((this.nazov == null && other.nazov != null) || (this.nazov != null && !this.nazov.equals(other.nazov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uloha1b.Tovar[ nazov=" + nazov + " ]";
    }
    
}
