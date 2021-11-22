package hexlet.code.schemas.map;

import hexlet.code.schemas.MapSchema;

import java.util.Map;

public final class MapSizeOfSchema extends MapSchema {
    private int sizeOfaMap;

    public MapSizeOfSchema(int size) {
        this.sizeOfaMap = size;
    }

    @Override
    public boolean isValid(Object obj) {
        if (obj instanceof Map) {
            return  ((Map)  obj).size() == sizeOfaMap;
        }

        return false;
    }
}
