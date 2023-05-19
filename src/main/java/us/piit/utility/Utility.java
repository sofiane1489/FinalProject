package us.piit.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class Utility {

    public static String currentDir = System.getProperty("user.dir");

    public static Properties loadProperties() {
        Properties properties = new Properties();
        try {
            //creation of the virtual file
            FileInputStream fis = new FileInputStream(currentDir + File.separator + "config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String decode(String key) {
        byte[] decodedBytes = Base64.getDecoder().decode(key);
        return new String(decodedBytes);
    }

//    public static void main(String[] args) {
//        String originalInput = "I have a trouble login, so please be in touch with asap.";
//        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
//        System.out.println(encodedString);
//
//        byte[] decodedBytes = Base64.getDecoder().decode("MTIzNEFiY2Qk");
//        String decodedString = new String(decodedBytes);
//        System.out.println(decodedString);
   }

