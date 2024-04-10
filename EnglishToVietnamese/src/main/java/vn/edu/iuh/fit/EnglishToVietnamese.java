package vn.edu.iuh.fit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EnglishToVietnamese implements Language {
    private Map<String, String> map = new HashMap<>();

    @Override
    public Map<String, String> lookup(String word) {
        return null;
    }

    @Override
    public void readData() throws FileNotFoundException {
        File myObj = new File("dictionary/anhviet109K.dict");
        Scanner myReader = new Scanner(myObj);
        Pattern pattern = Pattern.compile("^@(.*) /.*/$");
        String key = "", value;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            Matcher matcher = pattern.matcher(data);

            if (matcher.find()) {
                System.out.println("Key: " + data);
                key = matcher.group(0);
            }
            else if (!key.isEmpty() && data.startsWith("- ")) {
                value = data.substring(1);

                map.put(key, value);

                key = "";
                System.out.println(key + ": " + value);
            }
        }
    }

    @Override
    public String name() {
        return "English to Vietnamese";
    }
}
