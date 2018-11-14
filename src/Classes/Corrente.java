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
 * @author 16010
 */
@Entity
@Table(name = "corrente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Corrente.findAll", query = "SELECT c FROM Corrente c")
    , @NamedQuery(name = "Corrente.findById", query = "SELECT c FROM Corrente c WHERE c.id = :id")
    , @NamedQuery(name = "Corrente.findByIdUsuario", query = "SELECT c FROM Corrente c WHERE c.idUsuario = :idUsuario")
    , @NamedQuery(name = "Corrente.findBySaldo", query = "SELECT c FROM Corrente c WHERE c.saldo = :saldo")
    , @NamedQuery(name = "Corrente.findByUltimaAlteracao", query = "SELECT c FROM Corrente c WHERE c.ultimaAlteracao = :ultimaAlteracao")})
public class Corrente implements Serializable {

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

    public Corrente() {
    }

    public Corrente(Integer id) {
        this.id = id;
    }

    public Corrente(Integer id, int idUsuario, double saldo, Date ultimaAlteracao) {
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
        if (!(object instanceof Corrente)) {
            return false;
        }
        Corrente other = (Corrente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Corrente[ id=" + id + " ]";
    }

}
