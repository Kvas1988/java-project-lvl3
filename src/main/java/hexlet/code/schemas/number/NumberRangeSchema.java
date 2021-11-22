package hexlet.code.schemas.number;

public final class NumberRangeSchema extends NumberSchema {

    private int startRange;
    private int endRange;

    public NumberRangeSchema(int startRangeToValidate, int endRangeToValidate) {
        this.startRange = startRangeToValidate;
        this.endRange = endRangeToValidate;
    }

    public void setStartRange(int startRangeToValidate) {
        this.startRange = startRangeToValidate;
    }

    public void setEndRange(int endRangeToValidate) {
        this.endRange = endRangeToValidate;
    }

    @Override
    public boolean isValid(Object obj) {
        if (obj instanceof Number) {
            int num = (int) obj;
            return num >= startRange && num <= endRange;
        }

        return false;
    }
}
