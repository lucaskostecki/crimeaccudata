package persistence;

import entity.Money;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * The type Generic dao test.
 */
public class GenericDaoTest {

    /**
     * Gets property by like.
     */
    @Test
    void getPropertyByLike() {
            GenericDao dao = new GenericDao(Money.class);
            assertEquals(dao.getByPropertyLike("zip", "90210").size(), 1);

    }


}
