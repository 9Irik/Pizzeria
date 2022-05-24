package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_kitchens")
public class Kitchen implements java.io.Serializable {
    private Integer idKitchen;
    private String name;
    private String info;
    private String timeCook;
    private List<Catalog> catalog;
    private Date statusDate;

    public Kitchen(String name, String info, String timeCook, Date statusDate) {
        this.name = name;
        this.info = info;
        this.timeCook = timeCook;
        this.statusDate = statusDate;
    }

    public Kitchen() {

    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IdKitchen", unique = true, nullable = false)
    public Integer getIdKitchen() {
        return idKitchen;
    }

    public void setIdKitchen(Integer idKitchen) {
        this.idKitchen = idKitchen;
    }

    @Column(name = "Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Info", nullable = false, length = 100)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Column(name = "TimeCook", nullable = false, length = 50)
    public String getTimeCook() {
        return timeCook;
    }

    public void setTimeCook(String timeCook) {
        this.timeCook = timeCook;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "kitchen")
    public List<Catalog> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<Catalog> catalog) {
        this.catalog = catalog;
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
        return "Пицца " + this.getName() + ".\n" +
                "Состав: " + this.getInfo() + "\n" +
                "Время готовки: " + this.getTimeCook();
    }
}
