package com.example.demo.api;

import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class Apiegrn {

     List<Double> size;
     List<String> cudnums;
     List<String> addresses;
     public List<String> getCudnums(){
         return cudnums;
     }
    public List<Double> getSize() {return size;}
    public List<String> getAddresses(){return addresses;}
    static String url_cq="https://apiegrn.ru/api/cadaster/search";
    static String url_size="https://apiegrn.ru/api/cadaster/objectInfoFull";
   @SneakyThrows
   private String connection(String _url, String data){
       URL url = null;
       {
           url = new URL(_url);
           HttpURLConnection http = (HttpURLConnection) url.openConnection();
           http.setRequestMethod("POST");
           http.setDoOutput(true);
           http.setRequestProperty("Host", "http://apiegrn.ru");
           http.setRequestProperty("Token", "3QB3-5RPX-O4ZW-SM1M");
           http.setRequestProperty("Content-Type", "application/json;charset=utf-8");
           /*http.setRequestProperty("charset", "utf-8");*/
           byte[] out = data.getBytes(StandardCharsets.UTF_8);
           OutputStream stream = http.getOutputStream();
           stream.write(out);
           String msg = "";
           if (http.getResponseCode() == HttpURLConnection.HTTP_OK) {
               try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream(),"UTF-8"))) {
                   String line;
                   while ((line = bufferedReader.readLine()) != null) {
                       msg += line;
                   }
               }
           } else {
               System.out.println("Failed to connect to website.");
           }
           return msg;
       }
   }
    public void run(String location){
                String data = "{\n \"query\": \"" + location + "\",\n \"mode\": \"normal\",\n \"grouped\": 0\n}";
                String msg;
                cudnums=new ArrayList<>();
                addresses=new ArrayList<>();
                msg=connection(url_cq,data);
                JSONObject obj = new JSONObject(msg);
                JSONArray arr = obj.getJSONArray("objects");
                for (int i = 0; i < arr.length(); i++) {

                    String cad = arr.getJSONObject(i).getString("CADNOMER");
                    String adr=arr.getJSONObject(i).getString("ADDRESS");
                    cudnums.add(cad);
                    addresses.add(adr);

                }
                size=new ArrayList<>();
                if(cudnums.size()>=3){
                    for(int i=0;i<3;i++) {
                        String data_2 = "{\n  \"query\": \"" + cudnums.get(i) + "\"\n}";
                        msg = connection(url_size, data_2);
                        String area = "";
                        area = msg.substring(msg.indexOf("AREA"), msg.indexOf("CATEGORY"));
                        System.out.println();
                        Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
                        Matcher matcher = pat.matcher(area);
                        area = "";
                        while (matcher.find()) {
                            area += matcher.group();
                        }
                        ;
                        size.add(Double.parseDouble(area));
                    }
                }
                else if(cudnums.size()<3){
                    for(int i=0;i<cudnums.size();i++){
                        String data_2 = "{\n  \"query\": \"" + cudnums.get(i) + "\"\n}";
                        msg = connection(url_size, data_2);
                        String area = "";
                        area = msg.substring(msg.indexOf("AREA"), msg.indexOf("CATEGORY"));
                        System.out.println();
                        Pattern pat = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
                        Matcher matcher = pat.matcher(area);
                        area = "";
                        while (matcher.find()) {
                            area += matcher.group();
                        }
                        ;
                        size.add(Double.parseDouble(area));
                    }
                }
}}

