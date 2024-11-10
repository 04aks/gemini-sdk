# Gemini SDK
  A Java SDK for Gemini, to easily integrate the AI model into your java project.
  
  Note: Contextual AI is not available at this time, so each request to Gemini requires calling the methods below individually without retaining context between requests.

## Integration
To include the Gemini SDK in your Maven project, add the following to your `pom.xml` file:
```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>


    <dependencies>
      <dependency>
            <groupId>com.github.04aks</groupId>
            <artifactId>gemini-javasdk</artifactId>
            <version>1.0</version>
        </dependency>
    </dependencies>
```

## How to Use
```java
        // Create a GeminiClient instance
        GeminiClient geminiClient = new GeminiClient();

        // Set your Gemini API key securely (e.g., using environment variables)
        String apiKey = System.getenv("GEMINI_API_KEY");
        geminiClient.authenticate(apiKey);

        // Set the desired AI behavior (e.g., creative, informative)
        geminiClient.geminiBehaviour("creative");

        // Make a request to the Gemini API
        String prompt = "Write a poem about a lonely robot";
        geminiClient.requestGemini(prompt);

        // Print the response
        System.out.println(geminiClient.responseGemini());

```



