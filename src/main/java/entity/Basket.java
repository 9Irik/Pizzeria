package entity;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_baskets")
public class Basket implements java.io.Serializable {
    private Integer idBasket;
    private Client client;
    private Catalog catalog;
    private String status;
    private Date statusDate;

    public Basket() {

    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(Integer idBasket) {
        this.idBasket = idBasket;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdClient", nullable = false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCatalog", nullable = false)
    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Column(name = "Status", nullable = false, length = 30)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "StatusDate", length = 10)
    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }
}
