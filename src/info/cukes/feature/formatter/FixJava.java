package info.cukes.feature.formatter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class FixJava {
    public static String join(List<String> strings, String separator) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String s : strings) {
            if (i != 0) sb.append(separator);
            sb.append(s);
            i++;
        }
        return sb.toString();
    }

    public static String readResource(String filePath) throws IOException {
        Reader reader = new InputStreamReader(FixJava.class.getResourceAsStream(filePath));
        return readReader(reader);
    }

    public static String readReader(Reader reader) throws IOException {
        final char[] buffer = new char[0x10000];
        StringBuilder sb = new StringBuilder();
        int read;
        do {
            read = reader.read(buffer, 0, buffer.length);
            if (read > 0) {
                sb.append(buffer, 0, read);
            }
        } while (read >= 0);
        return sb.toString();
    }
}