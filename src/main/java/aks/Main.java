package aks;

import java.util.ArrayList;
import java.util.List;

import aks.constants.Links;
import aks.gemini.Gemini;

public class Main {
    public static void main(String[] args) {
        test();
    }


    public static void test(){

        List<String> links = new ArrayList<>();
        links.add("src\\main\\java\\aks\\res\\cee.jpg");
        links.add("src\\main\\java\\aks\\res\\dave.jpg");

        Gemini gemini = new Gemini.Builder(Links.GEMINI_1dot5_FLASH, System.getenv("GEMINI-KEY-2"))
        .prompt("do you remember what I just asked yo ua minute ago?")
        .build();
        gemini.requestGemini();
        
   
    }
}