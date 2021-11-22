package hexlet.code.schemas;

import hexlet.code.schemas.number.NumberPositiveSchema;
import hexlet.code.schemas.number.NumberRangeSchema;
import hexlet.code.schemas.number.NumberRequiredSchema;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        // this.schema = new BaseSchema();
        setSchema(new BaseSchema());
    }

    // ======================SETUP======================

    /**
     * @return NumberRequiredSchema
     */
    public final NumberSchema required() {
        setSchema(new NumberRequiredSchema());
        return new NumberRequiredSchema();
    }

    /**
     * @return NumberPositiveSchema
     */
    public final NumberSchema positive() {
        setSchema(new NumberPositiveSchema());
        return new NumberPositiveSchema();
    }

    /**
     * @param startRange lower band of a range
     * @param endRange upper band of a range
     * @return NumberRangeSchema
     */
    public final NumberSchema range(int startRange, int endRange) {
        setSchema(new NumberRangeSchema(startRange, endRange));
        return new NumberRangeSchema(startRange, endRange);
    }

    // =================================================

    /**
     * @param obj Object to validate
     * @return true if Number is valid
     */
    @Override
    public boolean isValid(Object obj) {
        return getSchema().isValid(obj);
    }
}
