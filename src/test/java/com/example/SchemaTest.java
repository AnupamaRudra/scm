package com.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SchemaTest {
    List<String> lines = Collections.emptyList();

    @Test
    public void testChanges() {
        try {
            lines =
                    Files.readAllLines(Paths.get("target/changes.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int z=8;
    }
}
