package ua.kharkov.komunalka;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.swing.JFrame;



public class Demo {
	
	public static Float tariff2;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	

	public static void main(String[] args) {
		
		System.out.println("TariffElectricity"+TariffElectricity.GetTariffElectricityFromSite());		
		System.out.println("TariffElectricity"+TariffElectricity.GetTariffElectricityFromSite2());	
            
            FrameView frame = new FrameView();
            frame.setSize(700, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setResizable(false); //запрет кнопки увеличения окна

            frame.setTitle("utility bills");
            frame.setLocationRelativeTo(null);//по центру экрана     
        
		
	
	}

}
