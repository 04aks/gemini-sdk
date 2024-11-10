package aks.auth;


public interface GeminiClinetInterface {

    // GeminiClient geminiAiClient();
    void authenticate(String apiKey);
    String setTextPrompt(String prompt);
    void requestGemini();
    void requestGemini(String prompt);
    String responseGemini();
    String responseJsonGemini();
    void geminiBehaviour(String behaviour);
}