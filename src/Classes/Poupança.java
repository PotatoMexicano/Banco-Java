/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oihi
 */
@Entity
@Table(name = "poupan\u00e7a")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poupan\u00e7a.findAll", query = "SELECT p FROM Poupan\u00e7a p")
    , @NamedQuery(name = "Poupan\u00e7a.findById", query = "SELECT p FROM Poupan\u00e7a p WHERE p.id = :id")
    , @NamedQuery(name = "Poupan\u00e7a.findByIdUsuario", query = "SELECT p FROM Poupan\u00e7a p WHERE p.idUsuario = :idUsuario")
    , @NamedQuery(name = "Poupan\u00e7a.findBySaldo", query = "SELECT p FROM Poupan\u00e7a p WHERE p.saldo = :saldo")
    , @NamedQuery(name = "Poupan\u00e7a.findByUltimaAlteracao", query = "SELECT p FROM Poupan\u00e7a p WHERE p.ultimaAlteracao = :ultimaAlteracao")})
public class Poupança implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic(optional = false)
    @Column(name = "saldo")
    private double saldo;
    @Basic(optional = false)
    @Column(name = "ultima_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;

    public Poupança() {
    }

    public Poupança(Integer id) {
        this.id = id;
    }

    public Poupança(Integer id, int idUsuario, double saldo, Date ultimaAlteracao) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.saldo = saldo;
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(Date ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poupança)) {
            return false;
        }
        Poupança other = (Poupança) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Poupan\u00e7a[ id=" + id + " ]";
    }
    
}
