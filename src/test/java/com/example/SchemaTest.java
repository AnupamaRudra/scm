package com.example;

import org.junit.jupiter.api.Assertions;
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
        Assertions.assertTrue(verifyChanges());
    }

    private boolean verifyChanges() {
        try {
            lines =
                    Files.readAllLines(Paths.get("target/changes.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : lines) {
            String current = line.replaceAll("\\s", "");
            if (current.length() > 1 && current.charAt(0) == '-' && current.charAt(1) != '-') {
                if (current.lastIndexOf("title") == 2) {
                    continue;
                }
                if (current.lastIndexOf("description") == 2) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
