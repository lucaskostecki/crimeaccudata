package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Money.
 */
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets zip.
     *
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets zip.
     *
     * @param zip the zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Gets average.
     *
     * @return the average
     */
    public String getAverage() {
        return average;
    }

    /**
     * Sets average.
     *
     * @param average the average
     */
    public void setAverage(String average) {
        this.average = average;
    }

    /**
     * Instantiates a new Money.
     */
    public Money() {

    }

    /**
     * Instantiates a new Money.
     *
     * @param zip     the zip
     * @param average the average
     */
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
