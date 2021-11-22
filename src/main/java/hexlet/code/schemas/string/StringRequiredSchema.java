package hexlet.code.schemas.string;

public final class StringRequiredSchema extends StringSchema {
    @Override
    public boolean isValid(Object obj) {
        if (obj instanceof String) {
            return !((String) obj).isEmpty();
        }
        return false;
    }
}
