package aks;

import aks.constants.Links;
import aks.gemini.Gemini;
import aks.util.Utils;

public class Main {
    public static void main(String[] args) {

        Utils utils = new Utils();
        // System.out.println(utils.encodeImageToBase64("src\\main\\java\\aks\\res\\bigger.jpg"));
        test(utils);
        
    }


    public static void test(Utils utils){
        // GeminiClient geminiClient = new GeminiClient();
        // geminiClient.authenticate(System.getenv("GEMINI-KEY")); // [String] Put your Gemini API key here
        // geminiClient.geminiBehavior(""); // [String] Set the AI's behavior here
        // geminiClient.setBase64Image(utils.encodeImageToBase64("src\\main\\java\\aks\\res\\bigger.jpg"));
        // geminiClient.requestGemini("make a UK roadman kind of humorous sarcastic short twitter post on why the code in the image failed do not include tags (hashtags), use the I pronoun", geminiClient.addImage("C:\\Users\\abdel\\Downloads\\attempt.png")); // [String] Write what you are asking the AI here
        // geminiClient.requestGemini("");

        // System.out.println(geminiClient.responseGemini()); // This types the result.

        Gemini gemini = new Gemini.Builder()
        .url(Links.GEMINI_1dot5_FLASH)
        .authenticate(System.getenv("GEMINI-KEY-2"))
        .build();

        gemini.requestGemini("Generate bounding boxes for each of the objects in this image in [y_min, x_min, y_max, x_max] format", "src\\main\\java\\aks\\res\\bigger - Copy.jpg");
        
   
    }
}