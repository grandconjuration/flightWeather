/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icdata;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Jelle
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String JSONString = "{" +
"  \"Koper\": {" +
"    \"Naam\": \"Sligro Food Groep\"," +
"    \"GLN\": 8710401000005," +
"    \"Adres\": {" +
"      \"Naam\": \"Sligro Food Groep\"," +
"      \"Straatnaam\": \"Corridor\"," +
"      \"Huisnr\": \"11\"," +
"      \"Plaats\": \"Veghel\"," +
"      \"Postcode\": \"5466 RB\"" +
"    }" +
"  }," +
"  \"Afleveradres\": {" +
"    \"Naam\": \"DC Putten\"," +
"    \"GLN\": 8710401000005," +
"    \"Adres\": {" +
"      \"Postcode\": \"3881 SC\"," +
"      \"Plaats\": \"Putten\"," +
"      \"Huisnr\": \"69\"," +
"      \"Straatnaam\": \"Voorthuizerstraat\"," +
"      \"Naam\": \"Sligro Food Group DC Putten\"" +
"    }" +
"  }," +
"  \"Leverancier\": {" +
"    \"Naam\": \"Superunie\"," +
"    \"GLN\": \"8710624000004\"," +
"    \"Adres\": {" +
"      \"Naam\": \"C.I.V. Superunie B.A.\"," +
"      \"Postcode\": \"4153 BW\"," +
"      \"Plaats\": \"Beesd\"," +
"      \"Straatnaam\": \"Industrieweg\"," +
"      \"Huisnr\": \"22 -B\"" +
"    }" +
"  }," +
"  \"OrdernummerKoper\": \"1500560\"," +
"  \"Orderdatum\": \"2015-02-02T00:00:00.000Z\"," +
"  \"Leverdatum\": \"2015-02-04T00:00:00.000Z\"," +
"  \"Factuurdatum\": \"2015-02-04T00:00:00.000Z\"," +
"  \"Artikelen\": [" +
"    {" +
"      \"Aantal\": 200," +
"      \"Naam\": \"halfvolle melk\"," +
"      \"HoeveelheidLiters\": 1.5," +
"      \"Barcode\": 8710624290092," +
"      \"AantalDozen\": \"6\"," +
"      \"PrijsPerDoos\": \"1.20\"," +
"      \"BtwProcent\": 6" +
"    }," +
"    {" +
"      \"Aantal\": 250," +
"      \"Naam\": \"volle melk\"," +
"      \"HoeveelheidLiters\": 1," +
"      \"Barcode\": 8710624290009," +
"      \"AantalDozen\": 6," +
"      \"PrijsPerDoos\": 0.9," +
"      \"BtwProcent\": 6" +
"    }" +
"  ]" +
"}";
        
        JSONObject rootOfPage = new JSONObject(JSONString);
        JSONObject Koper = rootOfPage.getJSONObject("Koper");
        System.out.println("Koper:");
        System.out.println("- GLN: "+Koper.get("GLN").toString());
        System.out.println("- Naam: "+Koper.get("Naam").toString());
        JSONObject adresKoper = Koper.getJSONObject("Adres");
        System.out.println("- Adres:");
        System.out.println("- - Straatnaam: "+adresKoper.get("Straatnaam").toString());
        System.out.println("- - Huisnr: "+adresKoper.get("Huisnr").toString());
        System.out.println("- - Plaats: "+adresKoper.get("Plaats").toString());
        System.out.println("- - Naam: "+adresKoper.get("Naam").toString());
        System.out.println("- - Postcode: "+adresKoper.get("Postcode").toString());
        JSONObject Afleveradres = rootOfPage.getJSONObject("Afleveradres");
        System.out.println("Afleveradres:");
        System.out.println("- GLN: "+Afleveradres.get("GLN").toString());
        System.out.println("- Naam: "+Afleveradres.get("Naam").toString());
        JSONObject adresAfleveradres = Afleveradres.getJSONObject("Adres");
        System.out.println("- Adres:");
        System.out.println("- - Straatnaam: "+adresAfleveradres.get("Straatnaam").toString());
        System.out.println("- - Huisnr: "+adresAfleveradres.get("Huisnr").toString());
        System.out.println("- - Plaats: "+adresAfleveradres.get("Plaats").toString());
        System.out.println("- - Naam: "+adresAfleveradres.get("Naam").toString());
        System.out.println("- - Postcode: "+adresAfleveradres.get("Postcode").toString());
        JSONObject Leverancier = rootOfPage.getJSONObject("Leverancier");
        System.out.println("Leverancier:");
        System.out.println("- GLN: "+Leverancier.get("GLN").toString());
        System.out.println("- Naam: "+Leverancier.get("Naam").toString());
        JSONObject adresLeverancier = Leverancier.getJSONObject("Adres");
        System.out.println("- Adres:");
        System.out.println("- - Straatnaam: "+adresLeverancier.get("Straatnaam").toString());
        System.out.println("- - Huisnr: "+adresLeverancier.get("Huisnr").toString());
        System.out.println("- - Plaats: "+adresLeverancier.get("Plaats").toString());
        System.out.println("- - Naam: "+adresLeverancier.get("Naam").toString());
        System.out.println("- - Postcode: "+adresLeverancier.get("Postcode").toString());
        System.out.println("OrdernummerKoper: "+rootOfPage.get("OrdernummerKoper").toString());
        System.out.println("Orderdatum: "+rootOfPage.get("Orderdatum").toString());
        System.out.println("Leverdatum: "+rootOfPage.get("Leverdatum").toString());
        System.out.println("Factuurdatum: "+rootOfPage.get("Factuurdatum").toString());
        System.out.println("Artikelen:");
        JSONArray Artikelen = rootOfPage.getJSONArray("Artikelen");
        for (int i = 0; i < Artikelen.length(); i++) {
            System.out.println("- "+i+":");
            JSONObject Artikel = Artikelen.getJSONObject(i);
            System.out.println("- - Aantal: "+Artikel.get("Aantal").toString());
            System.out.println("- - Naam: "+Artikel.get("Naam").toString());
            System.out.println("- - HoeveelheidLiters: "+Artikel.get("HoeveelheidLiters").toString());
            System.out.println("- - Barcode: "+Artikel.get("Barcode").toString());
            System.out.println("- - AantalDozen: "+Artikel.get("AantalDozen").toString());
            System.out.println("- - PrijsPerDoos: "+Artikel.get("PrijsPerDoos").toString());
            System.out.println("- - BtwProcent: "+Artikel.get("BtwProcent").toString());
        }
    }
}
