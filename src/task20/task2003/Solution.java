package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try {
            properties.put("website", "https://ru.wikipedia.org/");
            properties.put("language", "Russian");
            BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
            
            FileInputStream inputStream= new FileInputStream(readerConsole.readLine());
            readerConsole.close();

            load(inputStream);
            inputStream.close();

            /*System.out.println(properties);*/

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод

        Properties props = new Properties();
        props.putAll(properties);
        props.store(outputStream, null);

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties props = new Properties();
        props.load(inputStream);
        for (String name :
                props.stringPropertyNames()) {
            properties.put(name, props.getProperty(name));
        }
    }

    public static void main(String[] args) {
        new Solution().fillInPropertiesMap();
    }
}
