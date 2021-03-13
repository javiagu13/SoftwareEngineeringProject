package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import businessLogic.BLFacadeImplementation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	public class langileBerriSortuGUI extends JFrame {

		private JPanel contentPane;
		private JTextField textField;
		private JPasswordField passwordField;
		private JPasswordField passwordField_1;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private final ButtonGroup buttonGroup = new ButtonGroup();
		private JCalendar calendar;
		private langileBerriSortuGUI frame;
		private JLabel lblNewLabel_1;
		private static String ID;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						langileBerriSortuGUI frame = new langileBerriSortuGUI(ID);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	//log pass passcompr email data nan tel TYPE
		/**
		 * Create the frame.
		 */
		public void gaizkiSartuta() {
			 gaizkiSartutaGUI gaizkiSart = new gaizkiSartutaGUI();
			 gaizkiSart.setVisible(true);
		}
		
		public langileBerriSortuGUI(String ID) {
			this.ID=ID;
			frame = this;
			setTitle("LANGILE BERRI BAT SORTU");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 348, 495);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblIzena = new JLabel("Erabiltzaile Izena:");
			lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIzena.setBounds(97, 27, 116, 14);
			contentPane.add(lblIzena);
			
			JLabel lblPass = new JLabel("Password:");
			lblPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPass.setBounds(97, 79, 80, 14);
			contentPane.add(lblPass);
			
			JLabel lblPasserrep = new JLabel("Password Errepikatu:");
			lblPasserrep.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPasserrep.setBounds(97, 135, 142, 14);
			contentPane.add(lblPasserrep);
			
			JLabel lblMail = new JLabel("Email:");
			lblMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMail.setBounds(98, 195, 59, 14);
			contentPane.add(lblMail);
			
			JLabel lblNan = new JLabel("NAN:");
			lblNan.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNan.setBounds(98, 251, 46, 14);
			contentPane.add(lblNan);
			
			JLabel lblTel = new JLabel("Telefonoa:");
			lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTel.setBounds(98, 311, 81, 14);
			contentPane.add(lblTel);
			
			textField = new JTextField();
			textField.setBounds(96, 48, 142, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(96, 102, 142, 20);
			contentPane.add(passwordField);
			
			passwordField_1 = new JPasswordField();
			passwordField_1.setBounds(98, 162, 141, 20);
			contentPane.add(passwordField_1);
			
			textField_1 = new JTextField();
			textField_1.setBounds(98, 220, 141, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(98, 276, 142, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setBounds(98, 336, 141, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
			
			JButton btnErregistratu = new JButton("ERREGISTRATU LANGILE BERRI BAT!");
			btnErregistratu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						//DATUAK LORTZEN
						String izena = textField.getText(); //izena
						String pasahitza = passwordField.getText(); //password
						String pasahitzaErrep = passwordField_1.getText();
						String email = textField_1.getText(); //email
						String NAN = textField_2.getText(); //NAN
						int tel = Integer.parseInt(textField_3.getText()); //telefono
						String mota="Langile"; //mota
					
					   
						//DATU GAIZKI SARTUEN KONTROLA
						if (tel<=600000000||tel>=999999999) {System.out.println("telefono zenb ERROR"); throw new Exception();} //telefonoaren errore kasuak
						if (NAN.length()!=9) {System.out.println("NAN error"); throw new Exception();} //NAN-aren errore kasuak
						if (!pasahitza.equals(pasahitzaErrep)) {System.out.println("pasahitzaErrep ERROR"); throw new Exception();}
						
						BLFacadeImplementation BL = new BLFacadeImplementation();
						
						BL.createLangile(izena, pasahitza, email, NAN, tel);
						lblNewLabel_1.setText("LANGILEA ONDO SORTU DA!");
					}
					catch(Exception e) {
						gaizkiSartuta();
					}
				}
			});
			JButton btnAtzera = new JButton("Atzera");
			btnAtzera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					adminGUI langileGUI = new adminGUI(ID);
					langileGUI.setVisible(true);
					frame.setVisible(false);
				}
			});
			btnAtzera.setBounds(224, 418, 98, 26);
			contentPane.add(btnAtzera);
			
			btnErregistratu.setBounds(30, 381, 274, 26);
			contentPane.add(btnErregistratu);
			
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(23, 416, 190, 27);
			contentPane.add(lblNewLabel_1);
		}	
	}

