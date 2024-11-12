package aks.gemini;


public interface GeminiClientInterface {

    // GeminiClient geminiAiClient();
    void authenticate(String apiKey);
    String setTextPrompt(String prompt);
    String setTextPromptWithImage(String prompt, String image);
    void requestGemini();
    void requestGemini(String prompt);
    void requestGemini(String prompt, String image);
    String responseGemini();
    String responseJsonGemini();
    void geminiBehavior(String behavior);
    String addImage(String path);
}