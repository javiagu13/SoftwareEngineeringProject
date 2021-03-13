package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacadeImplementation;
import domain.Erabiltzaile;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.adminGUI;
import gui.jabeGUI;
import gui.langileGUI;
import gui.userGUI;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
public class loginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private loginGUI frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginGUI frame = new loginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loginGUI() {
		setTitle("LOGIN");
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(131, 59, 46, 24);
		contentPane.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(131, 110, 70, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(220, 63, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 109, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnSartu = new JButton("SARTU!");
		btnSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BLFacadeImplementation BL = new BLFacadeImplementation();
				//try {
					String log = textField.getText();
					String pass = passwordField.getText();
					Erabiltzaile E=BL.Login(log, pass);
					if (!E.equals(null)) {
						String mota=E.getMota();
						String ID=E.getIzena();
						System.out.println(ID);
						System.out.println(mota);
						if (mota.equals("User")) {
							userGUI user= new userGUI(ID);
							user.setVisible(true);
							frame.setVisible(false);
						}
						if (mota.equals("Jabe")) {
							jabeGUI jabe = new jabeGUI(ID);
							jabe.setVisible(true);
							frame.setVisible(false);
						}
						if (mota.equals("Langile")) {
							langileGUI langile = new langileGUI(ID);
							langile.setVisible(true);
							frame.setVisible(false);
						}
						if (mota.equals("Admin")) {
							adminGUI admin = new adminGUI(ID);
							admin.setVisible(true);
							frame.setVisible(false);
						}
					}
				//}
				//catch(Exception e) {
				//	gaizkiLoginGUI gaizki = new gaizkiLoginGUI();
				//	gaizki.setVisible(true);
				//}		
			}
		});
		btnSartu.setBounds(157, 165, 115, 30);
		contentPane.add(btnSartu);
		
		JLabel lblEzZaudeErregistratuta = new JLabel("Ez zaude erregistratuta?");
		lblEzZaudeErregistratuta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				erregGUI erreg = new erregGUI();
				erreg.setVisible(true);
				frame.setVisible(false);
			}
		});
		lblEzZaudeErregistratuta.setForeground(new Color(0, 0, 255));
		lblEzZaudeErregistratuta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEzZaudeErregistratuta.setBounds(131, 219, 175, 24);
		contentPane.add(lblEzZaudeErregistratuta);
	}
}
