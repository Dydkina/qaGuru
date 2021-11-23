package guru.qa.lesson7;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZIPFileTests {

    @Test
    @Owner("Julia")
    @DisplayName("Parsing ZIP")
    void parseZipFileTest() throws IOException {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("zip_2MB.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                System.out.printf("File name: %s \t File size: %d \n", entry.getName(), entry.getSize());
            }
        }
    }
}