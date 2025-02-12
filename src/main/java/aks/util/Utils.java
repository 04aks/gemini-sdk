package aks.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Utils {
    
    public static String encodeImageToBase64(String path){

        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
