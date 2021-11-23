package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {

    public final NumberSchema required() {
        addPredicate(obj -> obj instanceof Number);
        return this;
    }

    public final NumberSchema positive() {
        addPredicate(obj -> obj == null
                || obj instanceof Number
                && (int) obj > 0
        );

        return this;
    }

    public final NumberSchema range(int startRange, int endRange) {
        addPredicate(obj -> obj == null
                || obj instanceof Number
                && (int) obj >= startRange
                && (int) obj <= endRange
        );

        return this;
    }

}
