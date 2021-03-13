package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pujaGaizki2GUI extends JFrame {

	private JPanel contentPane;
	private pujaGaizki2GUI frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pujaGaizki2GUI frame = new pujaGaizki2GUI();
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
	public pujaGaizki2GUI() {
		frame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDaturenBatGaizki = new JLabel("Ez daukazu behar den dirua!!!");
		lblDaturenBatGaizki.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDaturenBatGaizki.setBounds(79, 93, 185, 14);
		contentPane.add(lblDaturenBatGaizki);
		
		JLabel lblerrorea = new JLabel("\u00A1\u00A1\u00A1ERROREA!!!");
		lblerrorea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblerrorea.setBounds(97, 40, 110, 30);
		contentPane.add(lblerrorea);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnAtzera.setBounds(209, 132, 89, 23);
		contentPane.add(btnAtzera);
	}
}
