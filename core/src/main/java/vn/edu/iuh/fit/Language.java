package vn.edu.iuh.fit;

import java.io.FileNotFoundException;
import java.util.Map;

public interface Language extends Plugin {
    Map<String, String> lookup(String word);
    void readData() throws FileNotFoundException;
}
