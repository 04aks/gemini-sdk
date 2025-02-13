package aks.gemini;


public interface GeminiClientInterface {

    void requestGemini(String prompt);
    String requestGemini();
    void geminiBehavior(String behavior);
}