package aks;

import aks.auth.GeminiClient;

public class Main {
    public static void main(String[] args) {

        test();
        
    }


    public static void test(){
        GeminiClient geminiClient = new GeminiClient();
        geminiClient.authenticate(System.getenv("GEMINI-KEY"));
        // geminiClient.geminiBehaviour("You are a sarcastic chatbot AI, you give a real helpful resust but mix humour");
        geminiClient.requestGemini("Explain poker in a 3 lines");
        
        
        System.out.println(geminiClient.responseGemini());
    }
}