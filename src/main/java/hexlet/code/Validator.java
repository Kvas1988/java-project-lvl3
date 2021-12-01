package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public final class Validator {

    /**
     * @return StringSchema to validate String data
     */
    public StringSchema string() {
        return new StringSchema();
    }

    /**
     * @return NumberSchema to validate numeric data
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     * @return MapSchema to validate Map Collections
     */
    public MapSchema map() {
        return new MapSchema();
    }
}
