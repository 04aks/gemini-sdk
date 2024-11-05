package aks;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main {
    public static void main(String[] args) {

        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=AIzaSyAyNyXGFkFc9pI2MOBtKF0PJTitQYmnWbg";
        OkHttpClient client = new OkHttpClient();

        String prompt = "where is Andrew tate from?";
        String jsonBody = "{\"contents\":[{\"parts\":[{\"text\":\""+ prompt + "\"}]}]}";
        System.out.println(jsonBody);
        RequestBody requestBody = RequestBody.create(jsonBody, MediaType.get("application/json"));
        Request request = new Request.Builder()
            .url(url)
            .post(requestBody)
            .build();


        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful()){
                System.out.println(response.body().string());
            }else{
                System.out.println("error");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}