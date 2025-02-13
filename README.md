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
            <artifactId>gemini-sdk</artifactId>
            <version>RELEASE VERSION</version>
        </dependency>
    </dependencies>
```

## How to Use
```java
    List<String> imgs = new ArrayList<>();
    imgs.add("src\\main\\java\\aks\\res\\cee.jpg");
    imgs.add("src\\main\\java\\aks\\res\\dave.jpg");

    Gemini gemini = new Gemini.Builder(Links.GEMINI_1dot5_FLASH, System.getenv("GEMINI-KEY-2"))
    .prompt("what gender are these people?", imgs);
    .build();
    gemini.requestGemini(); // returns the json response
```

### The Main class is for testing purposes only, it has no significant role in the SDK's functionality.

