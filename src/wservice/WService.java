package wservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WService {

    
    public static void main(String[] args) throws MalformedURLException {
       try{
          
           URL url = new URL("http://api.chartlyrics.com/apiv1.asmx/SearchLyricDirect?artist=michael%20jackson&song=bad");
           HttpURLConnection conn=(HttpURLConnection)url.openConnection();
           conn.setRequestMethod("GET");
           conn.setRequestProperty("Accept","application/json");
           if(conn.getResponseCode()!=200){
               throw new RuntimeException("Failed:Http error code:"+conn.getResponseCode());
               
           } 
           else{
               BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
               String line=null;
               while((line = br.readLine() ) != null){
                   
               System.out.println(line);
               }
                   
           }
       }
       catch(Exception ex){
       }
    }
    
}
