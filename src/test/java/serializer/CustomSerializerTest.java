package serializer;

import classes.Cat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CustomSerializerTest {
    private Cat cat;
    private String testJsonString;

    @BeforeEach
    void setUp() {
        cat = new Cat();
        cat.setName("Ologbo");
        cat.setAge(10);
        cat.setColor("black");
        testJsonString = "{\"name\":\"Ologbo\",\"age\":10,\"color\":\"black\",\"dateOfBirth\":null}";
    }

    @Test
    void testWriteCatToJson(){
        String catAsJson = CustomSerializer.catToJson(cat);
        assertEquals(testJsonString, catAsJson);
    }

    @Test
    void testReadFromJasonToCat(){
        Cat catDeserializedFromJsonString = CustomSerializer.jsonToCat(testJsonString);
        assertNotNull(catDeserializedFromJsonString);
        assertEquals(cat, catDeserializedFromJsonString);
        assertEquals("Ologbo", catDeserializedFromJsonString.getName());
    }

    @Test
    void testSerializeCatWithADateOfBirth(){
        cat.setDateOfBirth(LocalDate.now());
        String catInJson = CustomSerializer.catToJson(cat);
        System.out.println("hi -> " + catInJson);
        assertNotNull(catInJson);
    }
}