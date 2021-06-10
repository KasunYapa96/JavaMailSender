package com.java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {

	
	public static JFrame jf;
	public static JLabel jl;
	public static JButton jb;
	
	
	public static void main(String[] args) throws MessagingException, IOException {
		
		

		
		jb=new JButton("Send Mail");
		jb.setBounds(90, 80, 150, 24);
//		jb.setBounds(120, 120, 60, 24);
		
		jf=new JFrame("Send Mail");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300,200);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setLayout(null);
		
		
		jl=new JLabel("");
		jl.setBounds(90, 80, 150, 24);

		jf.add(jb);
		jf.add(jl);
		
		
	jb.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				jl.setText("Your E-mail with attachment has been sentsent succesfully!!");
				JavaMailUtil j=new JavaMailUtil();
				j.sendMail();
				
				
				
				
			} catch (Exception e2) {
				jl.setText("***Email sending failed***");
			}
			
		}
	});
		
		
	}
	
	
}
