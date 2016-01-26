/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Оксана
 */
@Entity
@Table(name = "users2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users2.findAll", query = "SELECT u FROM Users2 u"),
    @NamedQuery(name = "Users2.findById", query = "SELECT u FROM Users2 u WHERE u.id = :id"),
    @NamedQuery(name = "Users2.findByName", query = "SELECT u FROM Users2 u WHERE u.name = :name"),
    @NamedQuery(name = "Users2.findBySurname", query = "SELECT u FROM Users2 u WHERE u.surname = :surname"),
    @NamedQuery(name = "Users2.findByNamepersonage", query = "SELECT u FROM Users2 u WHERE u.namepersonage = :namepersonage"),
    @NamedQuery(name = "Users2.findByAdress", query = "SELECT u FROM Users2 u WHERE u.adress = :adress"),
    @NamedQuery(name = "Users2.findByEmail", query = "SELECT u FROM Users2 u WHERE u.email = :email"),
    @NamedQuery(name = "Users2.findByLogin", query = "SELECT u FROM Users2 u WHERE u.login = :login"),
    @NamedQuery(name = "Users2.findByPassword", query = "SELECT u FROM Users2 u WHERE u.password = :password"),
    @NamedQuery(name = "Users2.findByType", query = "SELECT u FROM Users2 u WHERE u.type = :type"),
    @NamedQuery(name = "Users2.findByLoginPassword", query = "SELECT u FROM Users2 u WHERE u.login = :login and u.password = :password")})
public class Users2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 45)
    @Column(name = "NAME")
    private String name;
    @Size(max = 45)
    @Column(name = "SURNAME")
    private String surname;
    @Size(max = 45)
    @Column(name = "NAMEPERSONAGE")
    private String namepersonage;
    @Size(max = 45)
    @Column(name = "ADRESS")
    private String adress;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 45)
    @Column(name = "LOGIN")
    private String login;
    @Size(max = 45)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "TYPE")
    private Integer type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersonage")
    private List<Orders2> orders2List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcustomer")
    private List<Orders2> orders2List1;

    public Users2() {
    }

    public Users2(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNamepersonage() {
        return namepersonage;
    }

    public void setNamepersonage(String namepersonage) {
        this.namepersonage = namepersonage;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @XmlTransient
    public List<Orders2> getOrders2List() {
        return orders2List;
    }

    public void setOrders2List(List<Orders2> orders2List) {
        this.orders2List = orders2List;
    }

    @XmlTransient
    public List<Orders2> getOrders2List1() {
        return orders2List1;
    }

    public void setOrders2List1(List<Orders2> orders2List1) {
        this.orders2List1 = orders2List1;
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
        if (!(object instanceof Users2)) {
            return false;
        }
        Users2 other = (Users2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Users2[ id=" + id + " ]";
    }
    
}
