package vn.edu.iuh.fit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

@SpringBootApplication
public class Kt1004Application {

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            String path = new File("src/main/resources/application.properties").getAbsolutePath();
            properties.load(new FileReader(path));
            properties.forEach((key, value) -> {
                System.out.println(key);
                System.out.println(value);

                PluginManager.loadPlugin(value.toString());
                try {
                    PluginManager.get(Language.class).readData();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });

            /*PluginManager.loadPlugin(DEFAULT_LANGUAGE_PLUGIN_FILE_PATH);
            sayHello("nguyen van teo");

            PluginManager.loadPlugin(JAPANESE_LANGUAGE_PLUGIN_FILE_PATH);
            sayHello("than thi det");*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SpringApplication.run(Kt1004Application.class, args);
    }

}
