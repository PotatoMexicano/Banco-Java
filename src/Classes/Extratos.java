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
import javax.persistence.Lob;
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
@Table(name = "extratos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extratos.findAll", query = "SELECT e FROM Extratos e")
    , @NamedQuery(name = "Extratos.findById", query = "SELECT e FROM Extratos e WHERE e.id = :id")
    , @NamedQuery(name = "Extratos.findByIdUsuario", query = "SELECT e FROM Extratos e WHERE e.idUsuario = :idUsuario")
    , @NamedQuery(name = "Extratos.findByNumeroConta", query = "SELECT e FROM Extratos e WHERE e.numeroConta = :numeroConta")
    , @NamedQuery(name = "Extratos.findByValor", query = "SELECT e FROM Extratos e WHERE e.valor = :valor")
    , @NamedQuery(name = "Extratos.findByUltimoAcesso", query = "SELECT e FROM Extratos e WHERE e.ultimoAcesso = :ultimoAcesso")})
public class Extratos implements Serializable {

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
    @Column(name = "numero_conta")
    private int numeroConta;
    @Basic(optional = false)
    @Lob
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "ultimo_acesso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoAcesso;

    public Extratos() {
    }

    public Extratos(Integer id) {
        this.id = id;
    }

    public Extratos(Integer id, int idUsuario, int numeroConta, String tipo, double valor, Date ultimoAcesso) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.numeroConta = numeroConta;
        this.tipo = tipo;
        this.valor = valor;
        this.ultimoAcesso = ultimoAcesso;
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

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
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
        if (!(object instanceof Extratos)) {
            return false;
        }
        Extratos other = (Extratos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Classes.Extratos[ id=" + id + " ]";
    }

}
