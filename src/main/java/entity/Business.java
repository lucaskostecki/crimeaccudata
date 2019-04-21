package entity;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    public Business() {}

    public Business(String address, String name, Set<Review> reviews) {
        this.address = address;
        this.name = name;
        this.reviews = reviews;
    }

    public int getBusinessID() {
        return businessID;
    }

    public void setBusinessID(int businessID) {
        this.businessID = businessID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

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
