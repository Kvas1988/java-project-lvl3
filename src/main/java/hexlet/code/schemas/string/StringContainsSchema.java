package hexlet.code.schemas.string;

import hexlet.code.schemas.StringSchema;

public final class StringContainsSchema extends StringSchema {

    private String pattern;

    public StringContainsSchema(String containsPattern) {
        this.pattern = containsPattern;
    }

    @Override
    public boolean isValid(Object obj) {
        if (obj instanceof String) {
            return ((String) obj).contains(this.pattern);
        }

        return  false;
    }
}
