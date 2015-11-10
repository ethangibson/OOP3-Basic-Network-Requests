package com.impression11.networkReq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Ethan on 09/11/15.
 */
public class main {

    public static void main (String[] args) throws Exception{

        sendGet();

    }


    public static void sendGet() throws Exception {

        String url = "http://impresserve.co.uk/android/json.php";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result

        System.out.println(response.toString());
        parseJson(response.toString());

    }

    public static void parseJson(String rawjson)throws JSONException {


        JSONObject obj = new JSONObject(rawjson);

        System.out.println(obj.getString("name"));
        System.out.println(obj.getInt("age"));

    }


}
