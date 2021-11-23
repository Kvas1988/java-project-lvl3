package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema {


    public final MapSchema required() {
        addPredicate(obj -> obj instanceof Map);
        return this;
    }

    public final MapSchema sizeof(int size) {
        addPredicate(obj -> obj instanceof Map
                && ((Map) obj).size() == size
        );
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        for (Map.Entry<String, BaseSchema> entry : schemas.entrySet()) {
            String key = entry.getKey();
            BaseSchema schema = entry.getValue();

            addPredicate(obj -> obj instanceof Map
                    && schema.isValid(((Map) obj).get(key))
            );
        }

        return this;
    }
}
