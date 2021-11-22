package hexlet.code.schemas.map;

import hexlet.code.schemas.MapSchema;

import java.util.Map;

public final class MapRequiredSchema extends MapSchema {

    @Override
    public boolean isValid(Object obj) {
        return obj instanceof Map;
    }
}
