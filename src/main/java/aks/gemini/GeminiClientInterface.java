package aks.gemini;


public interface GeminiClientInterface {

    // GeminiClient geminiAiClient();
    // String setPrompt(String prompt);
    // String setPrompt(String prompt, String image);
    // void requestGemini();
    void requestGemini(String prompt);
    void requestGemini(String prompt, String imagePath);
    // String responseGemini();
    // String responseJsonGemini();
    void geminiBehavior(String behavior);
    // String addImage(String path);
}