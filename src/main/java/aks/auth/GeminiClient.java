package aks.auth;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GeminiClient implements GeminiClinetInterface{


    OkHttpClient client;
    Request request;
    Response response;
    String jsonBody;
    String base_url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=";
    
    public GeminiClient(){
        client = new OkHttpClient();
    }
    


    

    @Override
    public void authenticate(String apiKey) {
        base_url += apiKey;
    }

    @Override
    public String setTextPrompt(String prompt) {
        String testBehaviour = " you are an AI chat bot you use humour you are extremely sarcastic but you provide an hobest real response first, you keep answers short";
        String body = "{\"contents\":[{\"parts\":[{\"text\":\""+ prompt + testBehaviour + "\"}]}]}";
        setJsonBody(body);
        return body;
    }

    @Override
    public void setGeminiRequest() {
        RequestBody requestBody = RequestBody.create(getJsonBody(), MediaType.get("application/json"));
        request = new Request.Builder()
            .url(getBase_url())
            .post(requestBody)
            .build();
    }
    @Override
    public void setGeminiRequest(String prompt) {
        RequestBody requestBody = RequestBody.create(setTextPrompt(prompt), MediaType.get("application/json"));
        request = new Request.Builder()
            .url(getBase_url())
            .post(requestBody)
            .build();
    }

    @Override
    public void getGeminiResponse(){
        try(Response response = client.newCall(request).execute()){

            if(response.isSuccessful()){
                setResponse(response);
            }else{
                System.out.println("Might be missing the API key: " + response);
            }
        }catch(Exception e){
            System.out.println("exception " + e);
        } 
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


    public Response getResponse() {
        return response;
    }
    private void setResponse(Response response) {
        this.response = response;
    }
}