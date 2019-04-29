package typingGame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
	int speed = 400;
	int character = 0;
	
	public void init(){
		this.setSize(1050,750);
		this.textArea = new JTextArea(1,10);
		this.add(textArea,SOUTH);
		this.textField = new JTextArea(3,50);
		
		switch(new Random().nextInt(3)){
			case 2:this.textField.setText("Do not go gentle into that good night. Old age should burn and rave at close of day;\n"
	                + "Rage, rage against the dying of the light. Though wise men at their end know dark is right.\n" + 
	                "Because their words had forked no lightning they. Good men, the last wave by, crying how bright.");break;
			case 1:this.textField.setText("A faint wind moaned through the trees, and Tom feared it might be the spirits of the dead,\n"+
	              "complaining at being disturbed. The boys talked little, and only under their breath,\n" +
					"for the time and the place and the pervading solemnity and silence oppressed their spirits.");break;
			case 0:this.textField.setText("Wild men who caught and sang the sun in flight, And learn, too late, they grieved it on its way.\n"+
					"Do not go gentle into that good night. Grave men, near death, who see with blinding sight.\n" +
					"Blind eyes could blaze like meteors and be gay. Rage, rage against the dying of the light.");
		}
		
		this.add(textField,NORTH);
		this.getRegionPanel(SOUTH).setBackground(Color.DARK_GRAY);;
		this.getRegionPanel(NORTH).setBackground(Color.DARK_GRAY);
		
		this.button1 = new JButton("START");
		this.add(button1,SOUTH);
		this.button2 = new JButton("EASY");
		this.add(button2,SOUTH);
		this.button3 = new JButton("HARD");
		this.add(button3,SOUTH);
		/*this.button4 = new JButton("BE A BURGLAR");
		this.add(button4,SOUTH);*/
		
		this.button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				speed = 400;
			}
		});
		
		this.button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				speed = 200;
			}
		});
		
		/*this.button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				character = 1;
			}
		});*/
		
		this.button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				timer = new Timer(speed, new ActionListener() {
					public void actionPerformed(ActionEvent e) {						
						if(character == 0)
							burglar.move();
						else
							police.move();
						
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
					if(character ==0)
						police.move();
					else
						burglar.move();
					Testing.this.textField.setText(text.substring(1));
					Testing.this.textArea.setText(typed.substring(1));
				}
	
			}});
		timer1.start();
	}
	
}

