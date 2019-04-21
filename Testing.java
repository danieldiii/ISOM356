package typingGame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;
import test3.Button1ActionListener;

public class Testing extends GraphicsProgram{
	JLabel jLabel;
	JTextArea textArea;
	JTextArea textField;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	Police police;
    Map map;
    Burglar burglar;
    Timer timer;
    Timer timer1;
    String text;
    String typed;
	int road[][];
	
	public void init(){
		this.setSize(1050,750);
		this.textArea = new JTextArea(1,10);
		this.add(textArea,SOUTH);
		this.textField = new JTextArea(4,10);
		this.textField.setText("Do not go gentle into that good night. Old age should burn and rave at close of day; Rage\n"
                + ", rage against the dying of the light. Though wise men at their end know dark is right,\n" + 
                "Because their words had forked no lightning they. Do not go gentle into that good night.\n"
              + "Good men, the last wave by, crying how bright.");
		this.add(textField,NORTH);
		this.getRegionPanel(SOUTH).setBackground(Color.DARK_GRAY);;
		this.getRegionPanel(NORTH).setBackground(Color.DARK_GRAY);
		
		this.button1 = new JButton("START");
		this.add(button1,SOUTH);
		this.button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				timer = new Timer(400, new ActionListener() {
					public void actionPerformed(ActionEvent e) {						
						burglar.move();
						if(burglar.getX()==0){
							timer.stop();
						}
					}});
				timer.start();
			}		
		});	
		
		this.setBackground(Color.LIGHT_GRAY);
		
        map = new Map();
        this.add(map);
        police = new Police(map);
        this.add(police);
        burglar = new Burglar(map);
        this.add(burglar);
        
   	}
	
	public void run(){	
		
		timer1 = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text = Testing.this.textField.getText();
				typed = Testing.this.textArea.getText();
			
				if ((typed.length()>0)&&(typed.charAt(0)==text.charAt(0))) {
					police.move();
					Testing.this.textField.setText(text.substring(1));
					Testing.this.textArea.setText(typed.substring(1));
				}
				if ((typed.length()>0)&&(typed.charAt(0)!=text.charAt(0))){
					police.backword();
				}
				
			}});
		timer1.start();
	}
	
}

