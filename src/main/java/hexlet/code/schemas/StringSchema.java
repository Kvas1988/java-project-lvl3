package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        addPredicate(obj -> obj instanceof String
                        && !((String) obj).isEmpty()
        );
        return this;
    }

    public final StringSchema contains(String pattern) {
        addPredicate(obj -> obj instanceof String
                && ((String) obj).contains(pattern)
        );

        return this;
    }

    public final StringSchema minLength(int minLength) {
        addPredicate(obj -> obj instanceof String
                && ((String) obj).length() >= minLength
        );

        return this;
    }

}
