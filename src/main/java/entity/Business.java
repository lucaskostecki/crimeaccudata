package entity;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Business.
 */
@Entity(name = "entity.Business")
@Table(name = "Businesses")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Expose()
    private int businessID;

    @Column(name = "Address")
    @Expose()
    private String address;

    @Column(name = "Name")
    @Expose()
    private String name;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Expose(serialize = false, deserialize = false)
    private Set<Review> reviews = new HashSet<>();

    /**
     * Instantiates a new Business.
     */
    public Business() {}

    /**
     * Instantiates a new Business.
     *
     * @param address the address
     * @param name    the name
     * @param reviews the reviews
     */
    public Business(String address, String name, Set<Review> reviews) {
        this.address = address;
        this.name = name;
        this.reviews = reviews;
    }

    /**
     * Gets business id.
     *
     * @return the business id
     */
    public int getBusinessID() {
        return businessID;
    }

    /**
     * Sets business id.
     *
     * @param businessID the business id
     */
    public void setBusinessID(int businessID) {
        this.businessID = businessID;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessID=" + businessID +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
