package hexlet.code.schemas.map;

import java.util.Map;

public final class MapRequiredSchema extends MapSchema {

    @Override
    public boolean isValid(Object obj) {
        return obj instanceof Map;
    }
}
