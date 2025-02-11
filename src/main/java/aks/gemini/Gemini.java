package aks.gemini;

import org.json.JSONArray;
import org.json.JSONObject;
import aks.util.Utils;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Gemini implements GeminiClientInterface{
    private String url;
    private String key;
    private String prompt;
    private Utils utils = new Utils();
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
    private String buildPrompt(String text, String imagePath){

        String image = utils.encodeImageToBase64(imagePath);
        JSONObject inlinePart = new JSONObject()
        .put("mime_type", "image/jpeg")
        .put("data", image);

        JSONObject textObject = new JSONObject()
        .put("text", text);

        JSONObject part = new JSONObject()
        .put("parts", new JSONArray().put(textObject).put(new JSONObject().put("inline_data", inlinePart)));

        JSONObject root = new JSONObject()
        .put("contents", new JSONArray().put(part));

        return root.toString();
    }


    public static class Builder{
        private String url;
        private String key;
        private String prompt;
        // private String imagePath;

        public Builder url(String url){
            this.url = url;
            return this;
        }

        public Builder authenticate(String key){
            this.key = key;
            return this;
        }

        public Builder prompt(String prompt){
            this.prompt = prompt;
            return this;
        }

        public Gemini build(){
            if(url.isEmpty() || url == null || key.isEmpty() || key == null){
                return null;
            }

            return new Gemini(this);
        }
    }



    @Override
    public void requestGemini(String prompt) {
    }

    @Override
    public void requestGemini(String prompt, String imagePath) {
        try{
            RequestBody requestBody = RequestBody.create(buildPrompt(prompt, imagePath), MediaType.parse("application/json"));
            Request request = new Request.Builder()
                .url(link())
                .post(requestBody)
                .build();
            try(Response response = client.newCall(request).execute()){
                System.out.println(response.body().string());
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // @Override
    // public String responseGemini() {
    // }

    // @Override
    // public String responseJsonGemini() {
    // }

    @Override
    public void geminiBehavior(String behavior) {
    }

    // @Override
    // public String addImage(String path) {
    // }
}
