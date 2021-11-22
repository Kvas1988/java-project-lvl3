package hexlet.code.schemas.map;

import hexlet.code.schemas.BaseSchema;

import java.util.Map;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        setSchema(new BaseSchema());
    }

    // ======================SETUP======================

    /**
     * @return MapRequiredScheme to validate Map Collection's objects
     */
    public final MapSchema required() {
        setSchema(new MapRequiredSchema());
        return new MapRequiredSchema();
    }

    /**
     * @param size param to validate on the size of a Map
     * @return MapSizeOfSchema
     */
    public final MapSchema sizeof(int size) {
        setSchema(new MapSizeOfSchema(size));
        return new MapSizeOfSchema(size);
    }

    /**
     * @param schemas map with schemas to validate on Object by its keys
     * @return true if all values of object is valid
     */
    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        setSchema(new MapShapeSchema(schemas));
        return new MapShapeSchema(schemas);
    }
    // =================================================

    /**
     * @param obj Object to validate
     * @return true if a Map is valid
     */
    @Override
    public boolean isValid(Object obj) {
        return getSchema().isValid(obj);
    }

}
