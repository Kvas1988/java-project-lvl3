package hexlet.code.schemas.number;

public final class NumberRequiredSchema extends NumberSchema {

    @Override
    public boolean isValid(Object obj) {
        return obj instanceof Number;
    }
}
