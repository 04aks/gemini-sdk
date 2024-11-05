package aks.auth;

import java.io.IOException;

public interface GeminiClinetInterface {

    // GeminiClient geminiAiClient();
    void authenticate(String apiKey);
    String setTextPrompt(String prompt);
    void setGeminiRequest();
    void setGeminiRequest(String prompt);
    void getGeminiResponse() throws IOException;
    
}