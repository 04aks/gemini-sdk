package aks;

import aks.gemini.GeminiClient;

public class Main {
    public static void main(String[] args) {

        test();
        
    }


    public static void test(){
        GeminiClient geminiClient = new GeminiClient();
        geminiClient.authenticate(System.getenv("GEMINI-KEY")); // [String] Put your Gemini API key here
        geminiClient.geminiBehavior("sarcastic"); // [String] Set the AI's behavior here
        geminiClient.requestGemini("should I blow all my money on real estate and keep one source of income to fund my lifestyle"); // [String] Write what you are asking the AI here
        
        
        System.out.println(geminiClient.responseGemini()); // This types the result.
    }
}