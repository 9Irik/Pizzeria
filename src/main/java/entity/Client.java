package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_clients")
public class Client implements java.io.Serializable {
    private Integer idClient;
    private String surname;
    private String name;
    private String phone;
    private String address;
    private List<Basket> basket;
    private Date statusDate;

    public Client() {

    }

    public Client(String surname, String name, String phone, String address, Date statusDate) {
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.statusDate = statusDate;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IdClient", unique = true, nullable = false)
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    @Column(name = "Surname", nullable = false, length = 30)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "Name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Phone", nullable = false, length = 30)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "Address", nullable = false, length = 100)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
    public List<Basket> getBasket() {
        return basket;
    }

    public void setBasket(List<Basket> basket) {
        this.basket = basket;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "StatusDate", length = 10)
    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @Override
    public String toString() {
        return "Клиент: " + this.getSurname() + " " + this.getName();
    }
}
