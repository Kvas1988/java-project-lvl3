package hexlet.code.schemas;

import hexlet.code.schemas.string.StringContainsSchema;
import hexlet.code.schemas.string.StringMinLengthSchema;
import hexlet.code.schemas.string.StringRequiredSchema;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        // this.schema = new BaseSchema();
        setSchema(new BaseSchema());
    }

    // ======================SETUP======================

    /**
     * @return StringRequiredSchema
     */
    public final StringSchema required() {
        setSchema(new StringRequiredSchema());
        return new StringRequiredSchema();
    }

    /**
     * @param contains set a value to validate on if object contains it
     * @return StringContainsSchema
     */
    public final StringSchema contains(String contains) {
        setSchema(new StringContainsSchema(contains));
        return new StringContainsSchema(contains);
    }

    /**
     * @param minLength set a value to validate if a String size more or equal to it
     * @return StringMinLengthSchema
     */
    public final StringSchema minLength(int minLength) {
        setSchema(new StringMinLengthSchema(minLength));
        return new StringMinLengthSchema(minLength);
    }

    // =================================================

    /**
     * @param obj Object to validate
     * @return true if String is valid
     */
    @Override
    public boolean isValid(Object obj) {
        return getSchema().isValid(obj);
    }
}
