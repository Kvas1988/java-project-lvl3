package hexlet.code.schemas;

public class BaseSchema {

    private BaseSchema schema;

    protected final BaseSchema getSchema() {
        return schema;
    }

    protected final void setSchema(BaseSchema schemaToSet) {
        this.schema = schemaToSet;
    }

    /**
     * @param obj Object to validate
     * @return true if data is valid
     */
    public boolean isValid(Object obj) {
        return true;
    }
}
