package com.google.guava;

import com.google.common.io.Files;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Main {
    private static File createdTempDir;

    static {
        createdTempDir = Files.createTempDir();
        createTestFile();
    }

    public static void main(String[] args) {
        System.out.printf("createdTempDir is located at \"%s\"%n", createdTempDir.getAbsolutePath());
        System.out.printf("Content: %s%n", (Object[]) createdTempDir.list());
    }

    private static void createTestFile() {
        URL testFileUrl = Thread.currentThread().getContextClassLoader().getResource("test.file");
        if (testFileUrl == null) {
            throw new RuntimeException("Not able to find test.file");
        } else {


            try {
                InputStream is = testFileUrl.openStream();

                try {
                    File testFileFile = new File(createdTempDir, "test.file");
                    FileOutputStream os = new FileOutputStream(testFileFile);

                    try {
                        IOUtils.copy(is, os);
                    } catch (Throwable var9) {
                        try {
                            os.close();
                        } catch (Throwable var8) {
                            var9.addSuppressed(var8);
                        }

                        throw var9;
                    }

                    os.close();
                    testFileFile.setExecutable(true);
                } catch (Throwable var10) {
                    if (is != null) {
                        try {
                            is.close();
                        } catch (Throwable var7) {
                            var10.addSuppressed(var7);
                        }
                    }

                    throw var10;
                }

                if (is != null) {
                    is.close();
                }
            } catch (IOException var11) {
                throw new RuntimeException(var11);
            }
        }
    }
}
