package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "entity.Money")
@Table(name="money")
public class Money {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;

    @Column(name = "zip")
    private String zip;

    @Column(name = "average")
    private String average;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public Money() {

    }

    public Money(String zip, String average) {
        this.zip = zip;
        this.average = average;
    }

    @Override
    public String toString() {
        return "entity.Money{" +
                "id=" + id +
                ", zip=" + zip +
                ", average=" + average +
                '}';
    }
}
