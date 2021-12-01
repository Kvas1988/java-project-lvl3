### Hexlet tests and linter status:
[![Actions Status](https://github.com/Kvas1988/java-project-lvl3/workflows/hexlet-check/badge.svg)](https://github.com/Kvas1988/java-project-lvl3/actions)  
[![Maintainability](https://api.codeclimate.com/v1/badges/57ad22657cce63690089/maintainability)](https://codeclimate.com/github/Kvas1988/java-project-lvl3/maintainability)  
[![Test Coverage](https://api.codeclimate.com/v1/badges/57ad22657cce63690089/test_coverage)](https://codeclimate.com/github/Kvas1988/java-project-lvl3/test_coverage)  

# Validate project

This repo represents Validate project for hexlet Java course.

With this library you can validate such data-types as:
- Strings
- Numeric
- Maps

## Quick Start

The entry-point for this library is `Validator v = new Validator();`

Data validation starts with Schema classes:

### String
```java
// creating StringSchema instance
StringSchema schema = v.string();

// set validation to check if string is not empty
schema.required(); 

// method isValid starts validation 
schema.isValid("hexlet"); // true
schema.isValid(""); // false
```

`minLength(int minLength)` sets validation to check if string is less than a num given

```java
schema.minLength(5).isValid("Hexlet"); // true
schema.minLength(8).isValid("Hexlet"); // false
```

`contains(String pattern)`:
```java
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say") // false
```

### Numeric
```java
NumberSchema schema = v.number();

// checks if a numeric data-type given
schema.required(); 
schema.isValid(null); // false
schema.isValid(10); // true

// checks if number is positive
schema.positive().isValid(10);

// checks if a number is in range (included)
schema.range(5, 10);
schema.isValid(5); // true 
schema.isValid(11); // false
```

### Maps
```java
MapSchema schema = v.map();

// checks if a Map collection given
schema.required();

// sets validation to check the size of a Map
schema.sizeof(2);
schema.isValid(yourMap);
```

Also there is a `MapSchema shape(Map<String, BaseSchema> schemas)` method which allows to validate data over all schemas given. Validation goes through the same keys in map with data and a map with schemas.
```java

Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().range(8, 14));
schema.shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 10);
boolean isKolyaValid = schema.isValid(human1); // true
```