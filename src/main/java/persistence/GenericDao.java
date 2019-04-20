package persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * The type Generic dao.
 *
 * @param <T> the type parameter
 */
public class GenericDao<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Instantiates a new Generic dao.
     *
     * @param type the type
     */
    public GenericDao(Class<T> type) {
        this.type = type;

    }

    private Session getSession() {
        return persistence.SessionFactoryProvider.getSessionFactory().openSession();
    }


    /**
     * Get entity by property (like)
     *
     * @param propertyName entity property to search by
     * @param value        value of the property to search for
     * @return list of entities meeting the criteria search
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for ** with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> entities = session.createQuery( query ).getResultList();
        session.close();
        return entities;
    }

    public List<T> getByProperty(String propertyName, String value) {
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.equal(propertyPath, value));

        List<T> entities = session.createQuery( query ).getResultList();
        session.close();
        return entities;
    }

/*
    public List<T> getByPropertLikeOnJoin(Class<T> class1, Class<T> class2, T comparable) {
        Session session = getSession();

        CriteriaQuery<T> query = builder.createQuery( type );

        CriteriaBuilder builder = session.getCriteriaBuilder();
        Root<T> root = query.from( type );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.equal(propertyPath, id));

        List<T> entities = session.createQuery(query).getResultList();

        session.close();
        return entities;
    }
 */


}
