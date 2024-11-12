package aks.gemini;


public interface GeminiClientInterface {

    // GeminiClient geminiAiClient();
    void authenticate(String apiKey);
    String setTextPrompt(String prompt);
    void requestGemini();
    void requestGemini(String prompt);
    String responseGemini();
    String responseJsonGemini();
    void geminiBehavior(String behavior);
}