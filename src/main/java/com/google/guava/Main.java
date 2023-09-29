package com.google.guava;

import com.google.common.io.Files;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Main {


    public static void main(String[] args) {
        final var configFactory = new ConfigFactory();
        final var configTempDir = configFactory.tempDir();
        System.out.printf("createdTempDir is located at \"%s\"%n", configTempDir.getAbsolutePath());
        System.out.printf("Content: %s%n", (Object[]) configTempDir.list());
    }


}
