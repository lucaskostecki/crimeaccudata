import controller.CanISteal;
import persistence.MoneyQuery;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")

public class CrimeAccuDataApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();

        h.add(CanISteal.class);
        h.add(MoneyQuery.class);
        h.add(Safe.class);
        return h;
    }
}