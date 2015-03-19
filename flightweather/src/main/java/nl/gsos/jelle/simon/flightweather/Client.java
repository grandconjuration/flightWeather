package nl.gsos.jelle.simon.flightweather;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


import org.json.JSONObject;

public class Client {

    public static void main(String[] args) throws Exception {

        Console cnsl = null;
        String code = null;

        try {
            // creates a console object
            cnsl = System.console();

            // if console is not null
            if (cnsl != null) {

                // read line from the user input
                code = cnsl.readLine("Code: ");
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
            }
        } catch (Exception ex) {

            // if any error occurs
            ex.printStackTrace();
        }

        /*String countryCode = "de";

        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        String JSONString = "";

        try {
            url = new URL("http://restcountries.eu/rest/v1/alpha/"
                    + countryCode);
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
        String capital = rootOfPage.get("capital").toString();
        String country = rootOfPage.get("name").toString();

        url = new URL("http://www.webservicex.com/globalweather.asmx?WSDL");

        // 1st argument service URI, refer to wsdl document above
        // 2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://www.webserviceX.NET", "GlobalWeather");

        Service service = GlobalWeather.create(url, qname);
        GlobalWeatherSoap hello = service.getPort(GlobalWeatherSoap.class);

        String response = hello.getWeather(capital, country);
        //System.out.println(response);

        DocumentBuilder db = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder();
        InputSource inputS = new InputSource();
        inputS.setCharacterStream(new StringReader(response));

        Document doc = db.parse(inputS);

        doc.getDocumentElement().normalize();

        NodeList l = doc.getElementsByTagName("*");

        JSONObject obj = new JSONObject();

        for (int temp = 0; temp < l.getLength(); temp++) {

            Node nNode = l.item(temp);

            //	System.out.println("\nCurrent Element :" + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                if (nNode.getNodeName().trim().equals("Wind") || nNode.getNodeName().trim().equals("Temperature") || nNode.getNodeName().trim().equals("RelativeHumidity") || nNode.getNodeName().trim().equals("Visibility") || nNode.getNodeName().trim().equals("DewPoint") || nNode.getNodeName().trim().equals("Pressure")) {
                    obj.put(nNode.getNodeName().trim(), eElement.getTextContent());
                }
            }
        }
        obj.put("capital", capital);
        obj.put("country", country);
        obj.put("code", countryCode);
        System.out.println(obj);*/

    }
}
