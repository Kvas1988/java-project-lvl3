package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.map.MapSchema;
import hexlet.code.schemas.number.NumberSchema;
import hexlet.code.schemas.string.StringSchema;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidateTest {

    private static Validator v;

    // checkStyle Magic number kek cheburek
    private static final int MINUS_TEN = -10;
    private static final int FIVE = 5;
    private static final int EIGHT = 8;
    private static final int TEN = 10;
    private static final int ELEVEN = 11;

    @BeforeAll
    static void beforeAll() {
        v = new Validator();
    }

    // ======================STRING======================

    @Test
    void stringSchemaRequiredTest() {
        StringSchema schema = v.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();

        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.isValid("hexlet"));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));

    }

    @Test
    void stringSchemaContainsTest() {
        StringSchema schema = v.string();

        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
    }

    @Test
    void stringSchemaMinLengthTest() {
        StringSchema schema = v.string();

        assertTrue(schema.minLength(FIVE).isValid("Hexlet"));
        assertFalse(schema.minLength(EIGHT).isValid("Hexlet"));
    }

    // ======================NUMBER======================
    @Test
    void numberSchemaRequiredTest() {
        NumberSchema schema = v.number();

        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(TEN));
        assertFalse(schema.isValid("5"));
    }

    @Test
    void numberSchemaPositiveTest() {
        NumberSchema schema = v.number();

        assertTrue(schema.positive().isValid(TEN));
        assertFalse(schema.isValid(MINUS_TEN));
    }

    @Test
    void numberSchemaRangeTest() {
        NumberSchema schema = v.number();

        schema.range(FIVE, TEN);

        assertTrue(schema.isValid(FIVE));
        assertTrue(schema.isValid(TEN));
        assertFalse(schema.isValid(1));
        assertFalse(schema.isValid(ELEVEN));
    }

    // ======================MAP======================
    @Test
    void mapSchemaRequiredTest() {
        MapSchema schema = v.map();

        assertTrue(schema.isValid(null)); // true

        schema.required();

        assertFalse(schema.isValid(null)); // false
        assertTrue(schema.isValid(new HashMap())); // true

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        assertTrue(schema.isValid(data)); // true
    }

    @Test
    void mapSchemaSizeOfTest() {
        MapSchema schema = v.map();

        schema.sizeof(2);

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        assertFalse(schema.isValid(data));  // false

        data.put("key2", "value2");
        assertTrue(schema.isValid(data)); // true
    }

    // ======================SHAPE======================
    @Test
    void shapeTest() {
        MapSchema schema = v.map();

        // shape - позволяет описывать валидацию для значений объекта Map по ключам.
        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", TEN);
        boolean actual1 = schema.isValid(human1);
        assertTrue(actual1); // true

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        boolean actual2 = schema.isValid(human2);
        assertFalse(actual2);

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        boolean actual3 = schema.isValid(human3); // false
        assertFalse(actual3); // false

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", MINUS_TEN);
        boolean actual4 = schema.isValid(human4);
        assertFalse(actual4); // false
    }
}
