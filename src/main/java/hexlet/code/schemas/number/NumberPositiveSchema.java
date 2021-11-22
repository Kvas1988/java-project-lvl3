package hexlet.code.schemas.number;

import hexlet.code.schemas.NumberSchema;

public final class NumberPositiveSchema extends NumberSchema {

    @Override
    public boolean isValid(Object obj) {
        if (obj instanceof Number) {
            int num = (int) obj;
            return num > 0;
        }

        return false;
    }
}
