package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import com.toedter.calendar.JCalendar;

import businessLogic.BLFacadeImplementation;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import domain.Erabiltzaile;;

public class erregGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JCalendar calendar;
	private boolean JabeaSelected=false;
	private boolean ArruntaSelected=false;
	private JLabel lblNewLabel_1;
	private erregGUI frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					erregGUI frame = new erregGUI();
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
	
	public erregGUI() {
		frame = this;
		setTitle("ERREGISTRATU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIzena = new JLabel("Erabiltzaile Izena:");
		lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIzena.setBounds(73, 12, 116, 14);
		contentPane.add(lblIzena);
		
		JLabel lblPass = new JLabel("Password:");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPass.setBounds(73, 64, 80, 14);
		contentPane.add(lblPass);
		
		JLabel lblPasserrep = new JLabel("Password Errepikatu:");
		lblPasserrep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPasserrep.setBounds(73, 120, 142, 14);
		contentPane.add(lblPasserrep);
		
		JLabel lblMail = new JLabel("Email:");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMail.setBounds(74, 180, 59, 14);
		contentPane.add(lblMail);
		
		JLabel lblNan = new JLabel("NAN:");
		lblNan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNan.setBounds(74, 236, 46, 14);
		contentPane.add(lblNan);
		
		JLabel lblTel = new JLabel("Telefonoa:");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTel.setBounds(74, 296, 81, 14);
		contentPane.add(lblTel);
		
		textField = new JTextField();
		textField.setBounds(72, 33, 142, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(72, 87, 142, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(74, 147, 141, 20);
		contentPane.add(passwordField_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(74, 205, 141, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(74, 261, 142, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(74, 321, 141, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JRadioButton rdbtnJabea = new JRadioButton("Jabea");
		rdbtnJabea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JabeaSelected==false) {
					JabeaSelected=true;
					ArruntaSelected=false;
				}
			}
		});
		buttonGroup.add(rdbtnJabea);
		rdbtnJabea.setBounds(73, 377, 80, 24);
		contentPane.add(rdbtnJabea);
		
		JRadioButton rdbtnArrunta = new JRadioButton("Arrunta");
		rdbtnArrunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ArruntaSelected==false) { 
					ArruntaSelected=true;
					JabeaSelected=false;
					}
			}
		});
		buttonGroup.add(rdbtnArrunta);
		rdbtnArrunta.setBounds(157, 377, 81, 24);
		contentPane.add(rdbtnArrunta);
		
		JLabel lblNewLabel = new JLabel("Erabiltzaile Mota:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(73, 353, 142, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnErregistratu = new JButton("ERREGISTRATU!");
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
					String mota; //mota

					if (JabeaSelected==true&&ArruntaSelected==false) mota="Jabe"; //mota
					else if (JabeaSelected==false&&ArruntaSelected==true) mota="User"; //mota
				   
					//DATU GAIZKI SARTUEN KONTROLA
					else {System.out.println("Arrunta/Jabe ERROR"); throw new Exception();} //Mota-ren errore kausak
					if (tel<=600000000||tel>=999999999) {System.out.println("telefono zenb ERROR"); throw new Exception();} //telefonoaren errore kasuak
					if (NAN.length()!=9) {System.out.println("NAN error"); throw new Exception();} //NAN-aren errore kasuak
					if (!pasahitza.equals(pasahitzaErrep)) {System.out.println("pasahitzaErrep ERROR"); throw new Exception();}
					
					BLFacadeImplementation BL = new BLFacadeImplementation();
					if(mota.equals("Jabe")) {BL.createJabe(izena,pasahitza,email,NAN,tel);}
					else if(mota.equals("User")) {BL.createUser(izena,pasahitza,email,NAN,tel);}
					lblNewLabel_1.setText("Ondo Erregistratu Zara!");
				}
				catch(Exception e) {
					gaizkiSartuta();
				}
			}
		});
		btnErregistratu.setBounds(12, 418, 142, 26);
		contentPane.add(btnErregistratu);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginGUI erreg = new loginGUI();
				erreg.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnAtzera.setBounds(184, 418, 98, 26);
		contentPane.add(btnAtzera);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(59, 455, 179, 26);
		contentPane.add(lblNewLabel_1);
	}
}
