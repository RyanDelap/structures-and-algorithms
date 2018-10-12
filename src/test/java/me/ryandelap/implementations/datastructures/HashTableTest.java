package me.ryandelap.implementations.datastructures;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void testHashTable() {
        HashTable<String, String> names = new HashTable<>();
        names.put("Ryan", "Delap");
        names.put("Jarrett", "Stiles");
        names.put("Chesley", "McDonald");
        names.put("Britain", "Hood");

        assertEquals(4, names.size());

        assertEquals("Delap", names.get("Ryan"));

        names.remove("Chesley");

        assertEquals(3, names.size());

        //Test for scale.
        for(int i = 0; i < 100; i++) {
            names.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        }

        assertEquals(103, names.size());

    }
}



