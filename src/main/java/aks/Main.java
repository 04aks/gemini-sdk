package aks;


import aks.auth.GeminiClient;

public class Main {
    public static void main(String[] args) {

        test();
        
    }


    public static void test(){
        GeminiClient geminiClient = new GeminiClient();
        geminiClient.authenticate(System.getenv("GEMINI-KEY"));
        geminiClient.requestGemini("what makes poker an entertaining game even tho it hass the most basic consept");
        
        
        System.out.println(geminiClient.responseGemini());
    }
}