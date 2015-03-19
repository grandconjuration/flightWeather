package com.mycompany.client;


import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jelle
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Console cnsl = null;
        String code = null;

        try {
            // creates a console object
            //cnsl = System.console();

            // if console is not null
            //if (cnsl != null) {

                // read line from the user input
                //code = cnsl.readLine("Code: ");
                code = "nl";
            
                URL url;
                InputStream is = null;
                BufferedReader br;
                String line;
                String JSONString = "";
                try {
                    url = new URL("http://tomcat.jelleluteijn.com/flightweather/rest/service/weatherbycode/"
                            + code);
                    is = url.openStream(); // throws an IOException
                    br = new BufferedReader(new InputStreamReader(is));

                    while ((line = br.readLine()) != null) {
                        JSONString = JSONString + line;
                    }
                } catch (MalformedURLException mue) {
                    mue.printStackTrace();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                } finally {
                    try {
                        if (is != null) {
                            is.close();
                        }
                    } catch (IOException ioe) {
                        // nothing to see here
                    }
                }

                JSONObject rootOfPage = new JSONObject(JSONString);
                System.out.println(rootOfPage.get("RelativeHumidity").toString());
                System.out.println(rootOfPage.get("Temperature").toString());
                System.out.println(rootOfPage.get("DewPoint").toString());
                System.out.println(rootOfPage.get("Visibility").toString());
                System.out.println(rootOfPage.get("code").toString());
                System.out.println(rootOfPage.get("Pressure").toString());
                System.out.println(rootOfPage.get("capital").toString());
                System.out.println(rootOfPage.get("Wind").toString());
                System.out.println(rootOfPage.get("country").toString());
            //}
        } catch (Exception ex) {

            // if any error occurs
            ex.printStackTrace();
        }
    }
}
