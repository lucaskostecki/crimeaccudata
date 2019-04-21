package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "entity.Review")
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int reviewID;

    @ManyToOne
    @JoinColumn(name = "BusinessID")
    private transient Business business;

    @Column(name = "Review")
    private String review;

    @Column(name = "Rating")
    private int rating;

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
