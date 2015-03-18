using ConsoleApplication1.GlobalWeather;
using ConsoleApplication1.RouteSoapApiService;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            GlobalWeatherSoapClient weatherSoapClient = new GlobalWeatherSoapClient();
            //weatherSoapClient.

            routeServiceClient flightSoapClient = new routeServiceClient();
            //flightSoapClient.
        }
    }
}
