package aks;

import aks.constants.Links;
import aks.gemini.Gemini;

public class Main {
    public static void main(String[] args) {
        test();
    }


    public static void test(){

        Gemini gemini = new Gemini.Builder(Links.GEMINI_1dot5_FLASH, System.getenv("GEMINI-KEY-2"))
        .prompt("wuts good Gem Gem")
        .build();
        gemini.requestGemini();
        
   
    }
}