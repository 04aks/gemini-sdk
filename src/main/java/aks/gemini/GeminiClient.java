package aks.gemini;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import aks.util.Utils;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GeminiClient implements GeminiClientInterface{


    OkHttpClient client;
    Request request;
    Response response;
    String jsonBody;
    String testBehavior;
    String base64Image;
    String base_url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=";
    

    private Utils util = new Utils();
    public GeminiClient(){
        client = new OkHttpClient();
    }
    


    

    @Override
    public void authenticate(String apiKey) {
        base_url += apiKey;
    }

    @Override
    public String setTextPrompt(String prompt) {
        String body = "{\"contents\":[{\"parts\":[{\"text\":\""+ prompt + testBehavior + "\"}]}]}";
        setJsonBody(body);
        return body;
    }

    @Override
    public String setTextPromptWithImage(String prompt, String image) {
        return "{\"contents\":[{\"parts\":[{\"text\":\""+ prompt + testBehavior + "\"},{\"inline_data\": {\"mime_type\":\"image/jpeg\",\"data\":" + "\"" + image + "\"" + "}}]}]}";
    }

    @Override
    public String addImage(String path) {
        return util.encodeImageToBase64(path);
    }

    @Override
    public void requestGemini() {
        try{
            RequestBody requestBody = RequestBody.create(getJsonBody(), MediaType.get("application/json"));
            request = new Request.Builder()
                .url(getBase_url())
                .post(requestBody)
                .build();
        }catch(Exception e){
            System.out.println("A prompt wasn't specified.");
        }
    }
    @Override
    public void requestGemini(String prompt) {
        RequestBody requestBody = RequestBody.create(setTextPrompt(prompt), MediaType.get("application/json"));
        request = new Request.Builder()
            .url(getBase_url())
            .post(requestBody)
            .build();
    }

    @Override
    public void requestGemini(String prompt, String image_path) {
        String imageInBase64 = util.encodeImageToBase64(image_path);
        RequestBody requestBody = RequestBody.create(setTextPromptWithImage(prompt, imageInBase64), MediaType.get("application/json"));
        request = new Request.Builder()
            .url(getBase_url())
            .post(requestBody)
            .build();
    }

    @Override
    public String responseGemini(){
        try(Response response = client.newCall(request).execute()){

            if(response.isSuccessful()){
                String result = filterJsonText(response.body().string());
                return result;
            }else{
                return "Might be missing the API key";
            }
        }catch(Exception e){
            System.out.println("gemini failed Response: ");
            e.printStackTrace();
        } 

        return null;
    }
    @Override
    public String responseJsonGemini() {
        try(Response response = client.newCall(request).execute()){

            if(response.isSuccessful()){
                return response.body().string();
            }else{
                return "Might be missing the API key: " + response;
            }
        }catch(Exception e){
            System.out.println("exception " + e);
        } 

        return null;
    }

    public String filterJsonText(String info){
        ObjectMapper om = new ObjectMapper();
        try{
            JsonNode jsonNode = om.readTree(info);
            if(jsonNode.has("candidates")){
                JsonNode candidatesJsonNode = jsonNode.get("candidates");
                if(candidatesJsonNode.isArray()){
                    JsonNode partsNode = candidatesJsonNode.get(0).get("content").get("parts");
                    if (partsNode.isArray()) {
                        return partsNode.get(0).get("text").asText();
                    }
                }
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void geminiBehavior(String behavior) {
        testBehavior = behavior;
    }






    private void setJsonBody(String jsonBody) {
        this.jsonBody = jsonBody;
    }
    private String getJsonBody() {
        return jsonBody;
    }

    private String getBase_url() {
        return base_url;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}