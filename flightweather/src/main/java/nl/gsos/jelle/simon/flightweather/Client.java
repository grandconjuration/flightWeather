package nl.gsos.jelle.simon.flightweather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.Service;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

import org.json.JSONObject;
import org.json.JSONString;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Client {

    public static void main(String[] args) throws Exception {

        String countryCode = "de";

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
                if (nNode.getNodeName().trim().equals("Wind") && nNode.getNodeName().trim().equals("Temperature") && nNode.getNodeName().trim().equals("RelativeHumidity") && nNode.getNodeName().trim().equals("Visibility") && nNode.getNodeName().trim().equals("DewPoint") && nNode.getNodeName().trim().equals("Pressure")) {
                    obj.put(nNode.getNodeName().trim(),eElement.getTextContent());
                }
            }
        }
        obj.put("capital",capital);
        obj.put("country",country);
        obj.put("code",countryCode);
        System.out.println(obj);

    }
}
