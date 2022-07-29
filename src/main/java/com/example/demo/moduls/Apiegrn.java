package com.example.demo.moduls;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Apiegrn {
    static String json;
    static String cq;
    public String getCq(){
        return cq;
    }
    String location;
   public void setLocation(String loc){
       location=loc;
   }

    public void run() throws IOException {

        String json;
        URL url = null;
        try {
            url = new URL("https://apiegrn.ru/api/cadaster/search");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setRequestProperty("Host", "http://apiegrn.ru");
            http.setRequestProperty("Token", "3QB3-5RPX-O4ZW-SM1M");
            http.setRequestProperty("Content-Type", "application/json");

            String data = "{\n \"query\": \"" + location + "\",\n \"mode\": \"normal\",\n \"grouped\": 0\n}";

            byte[] out = data.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = http.getOutputStream();
            stream.write(out);
            String msg = "";
            if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()))) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        msg += line;
                    }
                }
            } else {
                System.out.println("Failed to connect to website.");
            }

            JSONObject obj = new JSONObject(msg);
            JSONArray arr = obj.getJSONArray("objects");
            for (int i = 0; i < arr.length(); i++) {
                String cad = arr.getJSONObject(i).getString("CADNOMER");
                System.out.println("CADNOMER:" + cad);
                cq=cad;
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*		http.disconnect();*/
    }
    
}

