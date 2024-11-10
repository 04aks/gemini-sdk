# Gemini SDK
  A Java SDK for Gemini, to easily integrate the AI model into your java project.
  
  Contextual AI not available right now, meaning you have to call all methods provided below 
  each time you ask the AI something.

## How to Use
```
        // Create a GeminiClient instance
        GeminiClient geminiClient = new GeminiClient();

        // Set your Gemini API key securely (e.g., using environment variables)
        String apiKey = System.getenv("GEMINI_API_KEY");
        geminiClient.authenticate(apiKey);

        // Set the desired AI behavior (e.g., creative, informative)
        geminiClient.geminiBehaviour("creative");

        // Make a request to the Gemini API
        String prompt = "Write a poem about a lonely robot";
        String response = geminiClient.requestGemini(prompt);

        // Print the response
        System.out.println(response);

