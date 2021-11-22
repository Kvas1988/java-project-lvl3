package hexlet.code.schemas.number;

import hexlet.code.schemas.NumberSchema;

public final class NumberRequiredSchema extends NumberSchema {

    @Override
    public boolean isValid(Object obj) {
        return obj instanceof Number;
    }
}
