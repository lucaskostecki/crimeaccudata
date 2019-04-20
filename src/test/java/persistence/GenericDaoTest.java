package persistence;

import entity.Money;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GenericDaoTest {

    @Test
    void getPropertyByLike() {
            GenericDao dao = new GenericDao(Money.class);
            assertEquals(dao.getByPropertyLike("zip", "90210").size(), 1);

    }


}
