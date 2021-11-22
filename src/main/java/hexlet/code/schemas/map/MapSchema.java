package hexlet.code.schemas.map;

import hexlet.code.schemas.BaseSchema;

public class MapSchema extends BaseSchema {
    public MapSchema() {
        // this.schema = new BaseSchema();
        setSchema(new BaseSchema());
    }

    // ======================SETUP======================

    /**
     * @return MapRequiredScheme to validate Map Collection's objects
     */
    public MapSchema required() {
        setSchema(new MapRequiredSchema());
        return new MapRequiredSchema();
    }

    /**
     * @param size param to validate on the size of a Map
     * @return MapSizeOfSchema
     */
    public MapSchema sizeof(int size) {
        setSchema(new MapSizeOfSchema(size));
        return new MapSizeOfSchema(size);
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
