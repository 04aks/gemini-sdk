# Gemini SDK
  A Java SDK for Gemini, to easily integrate the AI model into your java project.
  
  Contextual AI not available right now, meaning you have to call all methods provided below 
  each time you ask the AI something.

## How to Use
```
        GeminiClient geminiClient = new GeminiClient();
        geminiClient.authenticate(System.getenv("GEMINI-KEY")); // [String] Put your Gemini API key here
        geminiClient.geminiBehaviour("");                       // [String] Set the AI's beahaviour here
        geminiClient.requestGemini("");                         // [String] Write what you are asking the AI here
        
        
        System.out.println(geminiClient.responseGemini());      // This types the result.

