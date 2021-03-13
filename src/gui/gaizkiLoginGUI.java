package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class gaizkiLoginGUI extends JFrame {

	private JPanel contentPane;
	private gaizkiLoginGUI frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gaizkiLoginGUI frame = new gaizkiLoginGUI();
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
	public gaizkiLoginGUI() {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDaturenBatGaizki = new JLabel("Erabiltzailea edo pasahitza gaizki sartuta");
		lblDaturenBatGaizki.setBounds(42, 71, 232, 14);
		lblDaturenBatGaizki.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblDaturenBatGaizki);
		
		JLabel lblerrorea = new JLabel("\u00A1\u00A1\u00A1ERROREA!!!");
		lblerrorea.setBounds(97, 30, 110, 30);
		lblerrorea.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblerrorea);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setBounds(209, 132, 89, 23);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		contentPane.add(btnAtzera);
		
		JLabel lblNewLabel = new JLabel("edo izena hartuta dago!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(42, 86, 232, 23);
		contentPane.add(lblNewLabel);
	}
}