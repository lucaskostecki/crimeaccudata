package entity;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Review.
 */
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

    /**
     * Instantiates a new Review.
     */
    public Review() {}

    /**
     * Instantiates a new Review.
     *
     * @param business the business
     * @param review   the review
     * @param rating   the rating
     */
    public Review(Business business, String review, int rating) {
        this.business = business;
        this.review = review;
        this.rating = rating;
    }

    /**
     * Gets review id.
     *
     * @return the review id
     */
    public int getReviewID() {
        return reviewID;
    }

    /**
     * Sets review id.
     *
     * @param reviewID the review id
     */
    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    /**
     * Gets business.
     *
     * @return the business
     */
    public Business getBusiness() {
        return business;
    }

    /**
     * Sets business.
     *
     * @param business the business
     */
    public void setBusiness(Business business) {
        this.business = business;
    }

    /**
     * Gets review.
     *
     * @return the review
     */
    public String getReview() {
        return review;
    }

    /**
     * Sets review.
     *
     * @param review the review
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
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
