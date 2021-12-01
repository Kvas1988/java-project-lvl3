package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private List<Predicate<Object>>  predicates = new ArrayList<>();

    protected final void addPredicate(Predicate<Object> predicate) {
        predicates.add(predicate);
    }

    /**
     * @param obj Object to validate
     * @return true if data is valid
     */
    public boolean isValid(Object obj) {
        for (Predicate<Object> pr : predicates) {
            if (!pr.test(obj)) {
                return false;
            }
        }
        return true;
    }
}
