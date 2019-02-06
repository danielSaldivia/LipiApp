/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

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
 * @author Theking
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id")
    , @NamedQuery(name = "Cliente.findByFecha", query = "SELECT c FROM Cliente c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Cliente.findByFactura", query = "SELECT c FROM Cliente c WHERE c.factura = :factura")
    , @NamedQuery(name = "Cliente.findByRut", query = "SELECT c FROM Cliente c WHERE c.rut LIKE :rut")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByDomicilio", query = "SELECT c FROM Cliente c WHERE c.domicilio = :domicilio")
    , @NamedQuery(name = "Cliente.findByValorFactura", query = "SELECT c FROM Cliente c WHERE c.valorFactura = :valorFactura")
    , @NamedQuery(name = "Cliente.findByK", query = "SELECT c FROM Cliente c WHERE c.k = :k")
    , @NamedQuery(name = "Cliente.findByK1", query = "SELECT c FROM Cliente c WHERE c.k1 = :k1")
    , @NamedQuery(name = "Cliente.findByK2", query = "SELECT c FROM Cliente c WHERE c.k2 = :k2")
    , @NamedQuery(name = "Cliente.findByK3", query = "SELECT c FROM Cliente c WHERE c.k3 = :k3")
    , @NamedQuery(name = "Cliente.findByKAl", query = "SELECT c FROM Cliente c WHERE c.kAl = :kAl")
    , @NamedQuery(name = "Cliente.findByKFe", query = "SELECT c FROM Cliente c WHERE c.kFe = :kFe")
    , @NamedQuery(name = "Cliente.findByKCat", query = "SELECT c FROM Cliente c WHERE c.kCat = :kCat")
    , @NamedQuery(name = "Cliente.findByKCat1", query = "SELECT c FROM Cliente c WHERE c.kCat1 = :kCat1")
    , @NamedQuery(name = "Cliente.findByKCat2", query = "SELECT c FROM Cliente c WHERE c.kCat2 = :kCat2")
    , @NamedQuery(name = "Cliente.findByKCat3", query = "SELECT c FROM Cliente c WHERE c.kCat3 = :kCat3")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Fecha")
    private String fecha;
    @Column(name = "Factura")
    private String factura;
    @Column(name = "Rut")
    private String rut;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Domicilio")
    private String domicilio;
    @Column(name = "Valor_Factura")
    private Integer valorFactura;
    @Column(name = "5k")
    private String k;
    @Column(name = "11k")
    private String k1;
    @Column(name = "15k")
    private String k2;
    @Column(name = "45k")
    private String k3;
    @Column(name = "15kAl")
    private String kAl;
    @Column(name = "15kFe")
    private String kFe;
    @Column(name = "5kCat")
    private String kCat;
    @Column(name = "11kCat")
    private String kCat1;
    @Column(name = "15kCat")
    private String kCat2;
    @Column(name = "45kCat")
    private String kCat3;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(Integer valorFactura) {
        this.valorFactura = valorFactura;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getK1() {
        return k1;
    }

    public void setK1(String k1) {
        this.k1 = k1;
    }

    public String getK2() {
        return k2;
    }

    public void setK2(String k2) {
        this.k2 = k2;
    }

    public String getK3() {
        return k3;
    }

    public void setK3(String k3) {
        this.k3 = k3;
    }

    public String getKAl() {
        return kAl;
    }

    public void setKAl(String kAl) {
        this.kAl = kAl;
    }

    public String getKFe() {
        return kFe;
    }

    public void setKFe(String kFe) {
        this.kFe = kFe;
    }

    public String getKCat() {
        return kCat;
    }

    public void setKCat(String kCat) {
        this.kCat = kCat;
    }

    public String getKCat1() {
        return kCat1;
    }

    public void setKCat1(String kCat1) {
        this.kCat1 = kCat1;
    }

    public String getKCat2() {
        return kCat2;
    }

    public void setKCat2(String kCat2) {
        this.kCat2 = kCat2;
    }

    public String getKCat3() {
        return kCat3;
    }

    public void setKCat3(String kCat3) {
        this.kCat3 = kCat3;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Data.Cliente[ id=" + id + " ]";
    }
    
}
