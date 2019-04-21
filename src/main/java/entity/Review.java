package entity;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "entity.Review")
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Expose()
    private int reviewID;

    @ManyToOne
    @JoinColumn(name = "BusinessID")
    @Expose(serialize = false, deserialize = false)
    private Business business;

    @Column(name = "Review")
    @Expose()
    private String review;

    @Column(name = "Rating")
    @Expose()
    private int rating;

    public Review() {}

    public Review(Business business, String review, int rating) {
        this.business = business;
        this.review = review;
        this.rating = rating;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewID=" + reviewID +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                '}';
    }
}
