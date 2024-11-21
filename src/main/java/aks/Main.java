package aks;

import aks.gemini.GeminiClient;
import aks.util.Utils;

public class Main {
    public static void main(String[] args) {

        Utils utils = new Utils();
        // System.out.println(utils.encodeImageToBase64("src\\main\\java\\aks\\res\\bigger.jpg"));
        test(utils);
        
    }


    public static void test(Utils utils){
        GeminiClient geminiClient = new GeminiClient();
        geminiClient.authenticate(System.getenv("GEMINI-KEY")); // [String] Put your Gemini API key here
        geminiClient.geminiBehavior(""); // [String] Set the AI's behavior here
        // geminiClient.setBase64Image(utils.encodeImageToBase64("src\\main\\java\\aks\\res\\bigger.jpg"));
        // geminiClient.requestGemini("make a UK roadman kind of humorous sarcastic short twitter post on why the code in the image failed do not include tags (hashtags), use the I pronoun", geminiClient.addImage("C:\\Users\\abdel\\Downloads\\attempt.png")); // [String] Write what you are asking the AI here
        geminiClient.requestGemini("describe the pciture", "C:\\Users\\abdel\\Downloads\\horrible.jpg");

        System.out.println(geminiClient.responseGemini()); // This types the result.
    }
}