package hexlet.code.schemas.string;

public final class StringMinLengthSchema extends StringSchema {

    private int minLength;

    public StringMinLengthSchema(int minLengthOfString) {
        this.minLength = minLengthOfString;
    }

    @Override
    public boolean isValid(Object obj) {
        if (obj instanceof String) {
            return ((String) obj).length() >= minLength;
        }

        return false;
    }
}
