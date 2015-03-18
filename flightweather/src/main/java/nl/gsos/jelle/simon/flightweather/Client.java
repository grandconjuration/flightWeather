package nl.gsos.jelle.simon.flightweather;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import net.webservicex.GetWeather;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;
public class Client {
	
	public static void main(String[] args) throws Exception {
		 
		URL url = new URL("http://www.webservicex.com/globalweather.asmx?WSDL");
 
        //1st argument service URI, refer to wsdl document above
	//2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://www.webserviceX.NET", "GlobalWeather");

		Service service = GlobalWeather.create(url, qname);
        GlobalWeatherSoap hello = service.getPort(GlobalWeatherSoap.class);
 
        System.out.println(hello.getWeather("Amsterdam", "Netherlands"));
 
    }
	
}
