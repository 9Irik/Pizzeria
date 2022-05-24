package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_catalogs")
public class Catalog implements java.io.Serializable {
    private Integer idCatalog;
    private String name;
    private String size;
    private double price;
    private List<Basket> basket;
    private Kitchen kitchen;
    private Date statusDate;

    public Catalog() {

    }

    public Catalog(String name, String size, double price, Kitchen kitchen, Date statusDate) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.kitchen = kitchen;
        this.statusDate = statusDate;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IdCatalog", unique = true, nullable = false)
    public Integer getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(Integer idCatalog) {
        this.idCatalog = idCatalog;
    }

    @Column(name = "Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Size", nullable = false, length = 15)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Column(name = "Price", nullable = false, length = 20)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "catalog")
    public List<Basket> getBasket() {
        return basket;
    }

    public void setBasket(List<Basket> basket) {
        this.basket = basket;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKitchen", nullable = false)
    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
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
        return "Пицца " + this.getName() + ", " + this.getSize();
    }
}
