package aks;

import java.io.IOException;

import aks.auth.GeminiClient;

public class Main {
    public static void main(String[] args) {

        test();
        
    }


    public static void test(){
        GeminiClient geminiClient = new GeminiClient();
        // geminiClient.authenticate("AIzaSyAyNyXGFkFc9pI2MOBtKF0PJTitQYmnWbg");
        geminiClient.setGeminiRequest("how do I get rich");
        try {
            geminiClient.getGeminiResponse();
            System.out.println(geminiClient.getResponse().body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}