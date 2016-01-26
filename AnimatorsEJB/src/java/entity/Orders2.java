/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Оксана
 */
@Entity
@Table(name = "orders2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders2.findAll", query = "SELECT o FROM Orders2 o"),
    @NamedQuery(name = "Orders2.findById", query = "SELECT o FROM Orders2 o WHERE o.id = :id"),
    @NamedQuery(name = "Orders2.findByAdress", query = "SELECT o FROM Orders2 o WHERE o.adress = :adress"),
    @NamedQuery(name = "Orders2.findByMinut", query = "SELECT o FROM Orders2 o WHERE o.minut = :minut"),
    @NamedQuery(name = "Orders2.findBySumma", query = "SELECT o FROM Orders2 o WHERE o.summa = :summa"),
    @NamedQuery(name = "Orders2.findByStatus", query = "SELECT o FROM Orders2 o WHERE o.status = :status"),
    @NamedQuery(name = "Orders2.findByDate", query = "SELECT o FROM Orders2 o WHERE o.date = :date"),
    @NamedQuery(name = "Orders2.findByTime", query = "SELECT o FROM Orders2 o WHERE o.time = :time"),
    @NamedQuery(name = "Orders2.findByIdPersonage", query = "SELECT o FROM Orders2 o WHERE o.idpersonage = :idpersonage"),
    @NamedQuery(name = "Orders2.findByDel", query = "SELECT o FROM Orders2 o WHERE o.del = :del")})
public class Orders2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 45)
    @Column(name = "ADRESS")
    private String adress;
    @Size(max = 45)
    @Column(name = "MINUT")
    private String minut;
    @Size(max = 45)
    @Column(name = "SUMMA")
    private String summa;
    @Size(max = 45)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "TIME")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Column(name = "del")
    private Integer del;
    @JoinColumn(name = "IDPERSONAGE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users2 idpersonage;
    @JoinColumn(name = "IDCUSTOMER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Users2 idcustomer;

    public Orders2() {
    }

    public Orders2(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMinut() {
        return minut;
    }

    public void setMinut(String minut) {
        this.minut = minut;
    }

    public String getSumma() {
        return summa;
    }

    public void setSumma(String summa) {
        this.summa = summa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Users2 getIdpersonage() {
        return idpersonage;
    }

    public void setIdpersonage(Users2 idpersonage) {
        this.idpersonage = idpersonage;
    }

    public Users2 getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(Users2 idcustomer) {
        this.idcustomer = idcustomer;
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
        if (!(object instanceof Orders2)) {
            return false;
        }
        Orders2 other = (Orders2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orders2[ id=" + id + " ]";
    }
    
}
