package ua.kharkov.komunalka;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameView extends JFrame {
	public JLabel priceTariffElectricityLabel1, priceTariffElectricityLabel2, spentElectricityLabel, electricitBillLabel;
	public static JTextField priceTariffElectricityTextField1;
	public JTextField priceTariffElectricityTextField2, electricitBillTextField;
	public static JTextField spentElectricityTextField;
	
	public JLabel priceTariffGasLabel, gasBillLabel;
	public JLabel spentGasLabel;	
	public static JTextField priceTariffGasTextField, spentGasTextField;
	public JTextField gasBillTextField;
	
	public JLabel priceTariffWaterLabel, waterBillLabel;
	public JLabel spentWaterLabel;
	public static JTextField priceTariffWaterTextField, spentWaterTextField;
	public JTextField waterBillTextField;
	
	public JLabel priceTariffSewerageLabel, sewerageBillLabel;
	public JLabel spentSewerageLabel;
	public static JTextField priceTariffSewerageTextField, spentSewerageTextField;
	public JTextField sewerageBillTextField;
	
	
	public FrameView() {		
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		priceTariffElectricityLabel1 = new JLabel("тариф <= 100 кв");		
		priceTariffElectricityLabel2 = new JLabel("      тариф > 100 кв");		
		spentElectricityLabel = new JLabel("      истрачено кв");	
		electricitBillLabel = new JLabel("      заплатить нужно");		
		priceTariffElectricityTextField1 = new JTextField(5);
		priceTariffElectricityTextField2 = new JTextField(5);
		spentElectricityTextField = new JTextField(5);
		electricitBillTextField = new JTextField(5);
		electricitBillTextField.setEditable(false);		
		
		
		priceTariffGasLabel = new JLabel("    тариф");	
		spentGasLabel = new JLabel("          истрачено м\u00B3");	
		gasBillLabel = new JLabel("      заплатить нужно");		
		priceTariffGasTextField = new JTextField(10);
		spentGasTextField = new JTextField(10);
		gasBillTextField = new JTextField(10);
		gasBillTextField.setEditable(false);
		
		priceTariffWaterLabel = new JLabel("    тариф");	
		spentWaterLabel = new JLabel("          истрачено м\u00B3");	
		waterBillLabel = new JLabel("      заплатить нужно");
		priceTariffWaterTextField = new JTextField(10);
		spentWaterTextField = new JTextField(10);
		waterBillTextField = new JTextField(10);
		waterBillTextField.setEditable(false);
		
		priceTariffSewerageLabel = new JLabel("    тариф");
		spentSewerageLabel = new JLabel("          истрачено м\u00B3");
		sewerageBillLabel = new JLabel("      заплатить нужно");		
		priceTariffSewerageTextField = new JTextField(10);
		spentSewerageTextField = new JTextField(10);
		sewerageBillTextField = new JTextField(10);
		sewerageBillTextField.setEditable(false);
		
		
		JPanel subpanel = new JPanel();
        subpanel.setBorder(BorderFactory.createTitledBorder("электричество"));        
        add(subpanel);        
        subpanel.add(priceTariffElectricityLabel1);
        subpanel.add(priceTariffElectricityTextField1);//textbox		
        subpanel.add(priceTariffElectricityLabel2);
        subpanel.add(priceTariffElectricityTextField2);			
        subpanel.add(spentElectricityLabel);
        subpanel.add(spentElectricityTextField);		
        subpanel.add(electricitBillLabel);
        subpanel.add(electricitBillTextField);
        
        
        JPanel subpanel2 = new JPanel();
        subpanel2.setBorder(BorderFactory.createTitledBorder("газ"));        
        add(subpanel2);        
        subpanel2.add(priceTariffGasLabel);
        subpanel2.add(priceTariffGasTextField);
        subpanel2.add(spentGasLabel);
        subpanel2.add(spentGasTextField);
        subpanel2.add(gasBillLabel);
        subpanel2.add(gasBillTextField);
        
        JPanel subpanel3 = new JPanel();
        subpanel3.setBorder(BorderFactory.createTitledBorder("вода"));        
        add(subpanel3);    
        subpanel3.add(priceTariffWaterLabel);
        subpanel3.add(priceTariffWaterTextField);
        subpanel3.add(spentWaterLabel);
        subpanel3.add(spentWaterTextField);
        subpanel3.add(waterBillLabel);
        subpanel3.add(waterBillTextField);
        
        JPanel subpanel4 = new JPanel();
        subpanel4.setBorder(BorderFactory.createTitledBorder("канализация"));        
        add(subpanel4);    
        subpanel4.add(priceTariffSewerageLabel);
        subpanel4.add(priceTariffSewerageTextField);
        subpanel4.add(spentSewerageLabel);
        subpanel4.add(spentSewerageTextField);
        subpanel4.add(sewerageBillLabel);
        subpanel4.add(sewerageBillTextField);
    
        
		JButton button1 = new JButton("посчитать"); 		
        container.add(button1);
        
        button1.addActionListener(new ActionListener(){
        	   public void actionPerformed(ActionEvent ae){ 		   
        		   electricitBillTextField.setText(Bill.ElectricityBill().toString());   
        		   gasBillTextField.setText(Bill.GasBill().toString());
        		   waterBillTextField.setText(Bill.WaterBill().toString());
        		   sewerageBillTextField.setText(Bill.SewerageBill().toString());
        	   }
        	});
        
        
        System.out.println("tmp "+TariffElectricity.tariffElectricity.toString());
        //получаю тариф по электричеству
		priceTariffElectricityTextField1.setText(TariffElectricity.tariffElectricity.toString());	
		priceTariffElectricityTextField2.setText(TariffElectricity.tariffElectricity2.toString());
		priceTariffGasTextField.setText(TariffGas.tariffGas.toString());
		priceTariffWaterTextField.setText(TariffWater.tariffWater.toString());
		priceTariffSewerageTextField.setText(TariffSewerage.tariffSewerage.toString());
		button1.setBounds(95, 40, 85, 30);
		setVisible(true);
	}  
	


	



}


