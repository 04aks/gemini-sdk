package aks.gemini;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import aks.util.Utils;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Gemini implements GeminiClientInterface{
    public static class Builder{
        private String url;
        private String key;
        private String prompt;
        public Builder(String url, String key){
            this.url = url;
            this.key = key;
        }

        public Builder prompt(String text, List<String> imagePath){
            
            List<JSONObject> inlineParts = new ArrayList<>();
            for(String img : imagePath){

                String image = Utils.encodeImageToBase64(img);

                JSONObject object = new JSONObject()
                .put("mime_type", "image/jpeg")
                .put("data", image);

                inlineParts.add(object);
            }

            JSONObject textObject = new JSONObject()
            .put("text", text);


            JSONArray array = new JSONArray();
            array.put(textObject);
            for(JSONObject obj : inlineParts){
                array.put(new JSONObject().put("inline_data", obj));
            }
            JSONObject part = new JSONObject()
            .put("parts", array);


            JSONObject root = new JSONObject()
            .put("contents", new JSONArray().put(part));

            this.prompt = root.toString();
            return this;
        }
        public Builder prompt(String text){

            JSONObject textObject = new JSONObject()
            .put("text", text);

            JSONObject part = new JSONObject()
            .put("parts", new JSONArray().put(textObject));

            JSONObject root = new JSONObject()
            .put("contents", new JSONArray().put(part));

            this.prompt = root.toString();
            return this;
        }

        public Gemini build()
            { return new Gemini(this);}
    }

    private String url;
    private String key;
    private String prompt;
    private OkHttpClient client = new OkHttpClient();

    private Gemini(Builder builder){
        
        this.key = builder.key;
        this.url = builder.url;
        this.prompt = builder.prompt;
    }

    public String getKey() {
        return key;
    }
    public String getUrl() {
        return url;
    }
    public String getPrompt() {
        return prompt;
    }
    private String link(){
        return getUrl() + getKey();
    }

    @Override
    public void requestGemini(String prompt) {
    }

    @Override
    public void requestGemini() {
        try{
            RequestBody requestBody = RequestBody.create(prompt, MediaType.parse("application/json"));
            Request request = new Request.Builder()
                .url(link())
                .post(requestBody)
                .build();
            try(Response response = client.newCall(request).execute()){
                System.out.println(response.body().string());
                
            }catch(Exception e){
                System.out.println("Something went wrong while making the call");
            }
        }catch(Exception e){
            System.out.println("Gotta add a prompt Broski!");
        }
    }

    @Override
    public void geminiBehavior(String behavior) {
    }

}
