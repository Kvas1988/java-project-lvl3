package hexlet.code.schemas.number;

import hexlet.code.schemas.BaseSchema;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        // this.schema = new BaseSchema();
        setSchema(new BaseSchema());
    }

    // ======================SETUP======================

    /**
     * @return NumberRequiredSchema
     */
    public NumberSchema required() {
        setSchema(new NumberRequiredSchema());
        return new NumberRequiredSchema();
    }

    /**
     * @return NumberPositiveSchema
     */
    public NumberSchema positive() {
        setSchema(new NumberPositiveSchema());
        return new NumberPositiveSchema();
    }

    /**
     * @param startRange lower band of a range
     * @param endRange upper band of a range
     * @return NumberRangeSchema
     */
    public NumberSchema range(int startRange, int endRange) {
        setSchema(new NumberRangeSchema(startRange, endRange));
        return new NumberRangeSchema(startRange, endRange);
    }

    /**
     * @param obj Object to validate
     * @return true if Number is valid
     */
    // =================================================
    @Override
    public boolean isValid(Object obj) {
        return getSchema().isValid(obj);
    }
}