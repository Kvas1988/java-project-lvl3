package hexlet.code.schemas.map;

import hexlet.code.schemas.BaseSchema;

import java.util.Map;

public final class MapShapeSchema extends MapSchema {

    private Map<String, BaseSchema> shape;

    public MapShapeSchema(Map<String, BaseSchema> shapes) {
        this.shape = shapes;
    }

    @Override
    public boolean isValid(Object obj) {
        if (!(obj instanceof Map)) {
            // throw new InvalidObjectException("invalid object type. Map needed");
            return false;
        }

        Map values = (Map) obj;
        for (Map.Entry<String, BaseSchema> entry : shape.entrySet()) {
            BaseSchema schema = entry.getValue();
            Object data = values.get(entry.getKey());
            if (!schema.isValid(data)) {
                return false;
            }
        }

        return true;
    }
}
