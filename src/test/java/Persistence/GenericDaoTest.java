package persistence;

import entity.Money;
import entity.Review;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GenericDaoTest {

    @Test
    void getPropertyByLike() {
            GenericDao dao = new GenericDao(Money.class);
            assertEquals(dao.getByPropertyLike("zip", "90210").size(), 1);

    }


    @Test
    void getByID() {
        GenericDao dao = new GenericDao(Review.class);
        assertEquals(dao.getByID("business", 3).size(), 2);
    }
}
