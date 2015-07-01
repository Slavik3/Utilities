package ua.kharkov.komunalka;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class TariffElectricity {
	public static Float tariffElectricity;
	public static Float tariffElectricity2;
	
	/**
	 * 
	 * @return tariffElectricity from site
	 */
	public static Float GetTariffElectricityFromSite() {
        URLConnection conn = null;
        String str = null;
        String priceTariffFromSite = null;
        String tag1 = "за обс€г,спожитий до 100 к¬т*год електроенерг≥њ на м≥с€ць (включно)";
        String tag2 = "за обс€г,спожитий понад 100 к¬т*год до 600 к¬т*год електроенерг≥њ на м≥с€ць (включно)";  
        
		try {
			conn = new URL("http://www.oblenergo.kharkov.ua/2_potreb.htm").openConnection();
			str = new Scanner(conn.getInputStream()).useDelimiter("\\Z").next();            
			priceTariffFromSite = str.substring(str.indexOf(tag1) + 158, str.indexOf(tag2)-32);
        } catch (MalformedURLException e) {				
			e.printStackTrace();
			System.out.println("Ex1");
		} catch (IOException e) {				
			e.printStackTrace();
			System.out.println("no internet");
			str="";
		}  
        
        //result ="qqq";
        System.out.println(priceTariffFromSite);
        String priceTariffFromSiteReplaceComma = priceTariffFromSite.replace(",", ".");   
        
        
    	try {
        tariffElectricity = (Float.parseFloat(priceTariffFromSiteReplaceComma))/100;
    	} catch (NumberFormatException e) {	
    		//если произошла исключительна€ ситуаци€, например помен€лс€ сайт и в переменную записываютьс€ символы			
			e.printStackTrace();
			tariffElectricity = 0.0f;
		}       
		return tariffElectricity;		
	}
	
	
	/**
	 * 
	 * @return tariffElectricity2 from site
	 */
	public static Float GetTariffElectricityFromSite2() {
        URLConnection conn = null;
        String str = null;
        String priceTariffFromSite2 = null;
        String tag1 = "за обс€г,спожитий понад 100 к¬т*год до 600 к¬т*год електроенерг≥њ на м≥с€ць (включно)";
        String tag2 = "за обс€г,спожитий понад 600 к¬т*год електроенерг≥њ на м≥с€ць";  
        
		try {
			conn = new URL("http://www.oblenergo.kharkov.ua/2_potreb.htm").openConnection();
			str = new Scanner(conn.getInputStream()).useDelimiter("\\Z").next();      
			
			priceTariffFromSite2 = str.substring(str.indexOf(tag1)+177, str.indexOf(tag2)-31);
	
        } catch (MalformedURLException e) {				
			e.printStackTrace();
			System.out.println("Ex1");
		} catch (IOException e) {				
			e.printStackTrace();
			System.out.println("no internet");
			str="";
		}          
           
        String priceTariffFromSiteReplaceComma = priceTariffFromSite2.replace(",", ".");           
        
    	try {
        tariffElectricity2 = (Float.parseFloat(priceTariffFromSiteReplaceComma))/100;
       
    	} catch (NumberFormatException e) {	
    		//если произошла исключительна€ ситуаци€, например помен€лс€ сайт и в переменную записываютьс€ символы			
			e.printStackTrace();
			tariffElectricity2 = 0.0f;
		}
    	
        System.out.println("tarif " + tariffElectricity2);
		
		return tariffElectricity2;		
	}
	
	

}
