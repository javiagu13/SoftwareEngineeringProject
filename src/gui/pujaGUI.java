package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacadeImplementation;
import domain.Enkante;
import domain.Puja;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

public class pujaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private pujaGUI frame;
	private static String ID;
	private static Enkante enk;
	private double prezioMax;
	private JPanel panel;
	private JLabel lblOharraZurePuja;
	private List<JLabel> labelak = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pujaGUI frame = new pujaGUI(ID, enk);
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
	public pujaGUI(String ID, Enkante enk) {
		this.ID=ID;
		this.enk=enk;
		frame=this;
		
		BLFacadeImplementation BL = new BLFacadeImplementation();
		this.prezioMax =BL.pujaMax(enk.getIzena());
		if(prezioMax==-1) prezioMax=enk.getPrezioa();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Saltzailea:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(32, 30, 94, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblHasierakoPrezioa = new JLabel("Hasierako Prezioa:");
		lblHasierakoPrezioa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHasierakoPrezioa.setBounds(235, 30, 133, 24);
		contentPane.add(lblHasierakoPrezioa);
		
		JLabel lblArtikulua = new JLabel("Artikulua:");
		lblArtikulua.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArtikulua.setBounds(32, 65, 94, 24);
		contentPane.add(lblArtikulua);
		
		JLabel lblDeskripzioa = new JLabel("Deskripzioa:");
		lblDeskripzioa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDeskripzioa.setBounds(32, 100, 94, 24);
		contentPane.add(lblDeskripzioa);
		
		JLabel lblBukaerakoDataEta = new JLabel("Bukaerako Data eta Ordua:");
		lblBukaerakoDataEta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBukaerakoDataEta.setBounds(235, 65, 193, 24);
		contentPane.add(lblBukaerakoDataEta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 214, 380, 353);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblPujak = new JLabel("Pujak:");
		lblPujak.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPujak.setBounds(32, 181, 94, 24);
		contentPane.add(lblPujak);
		
		JButton btnSartuEnkantera = new JButton("SARTU ENKANTERA!");
		btnSartuEnkantera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int puja1=Integer.parseInt(textField.getText());
				if(puja1>prezioMax&&BL.diruaLortu(ID)>=puja1) {
					
					BL.diruaBueltatu(enk.getIzena());
					BL.createPuja(puja1, enk.getIzena(), ID);
				
					JLabel lab = new JLabel("  "+ID+" "+puja1+" €");
					labelak.add(lab);
					panel.add(lab);
					panel.updateUI();
					
					BL.diruaKendu(ID, puja1);
				}
				else {
					if(puja1>prezioMax) {
					pujaGaizkiGUI gaizki = new pujaGaizkiGUI();
					gaizki.setVisible(true);
					}
					else {
						pujaGaizki2GUI gaizki = new pujaGaizki2GUI();
						gaizki.setVisible(true);
					}
				}
			}
		});
		btnSartuEnkantera.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSartuEnkantera.setBounds(441, 427, 185, 25);
		contentPane.add(btnSartuEnkantera);
		
		textField = new JTextField();
		textField.setBounds(484, 396, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(580, 396, 46, 17);
		contentPane.add(label);
		
		JLabel lblZenbatEurorekinSartuko = new JLabel("Zenbat eurorekin sartuko");
		lblZenbatEurorekinSartuko.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblZenbatEurorekinSartuko.setBounds(455, 322, 175, 37);
		contentPane.add(lblZenbatEurorekinSartuko);
		
		JLabel lblZaraEnkantera = new JLabel("zara enkantera?");
		lblZaraEnkantera.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblZaraEnkantera.setBounds(482, 347, 185, 37);
		contentPane.add(lblZaraEnkantera);
		
		lblOharraZurePuja = new JLabel("Oharra: zure puja prezio hau baino handiagoa izan behar da: "+this.prezioMax+" €");
		lblOharraZurePuja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOharraZurePuja.setBounds(32, 571, 455, 24);
		contentPane.add(lblOharraZurePuja);
		
		JLabel Saltzailea = new JLabel("");
		Saltzailea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Saltzailea.setBounds(109, 30, 94, 24);
		contentPane.add(Saltzailea);
		Saltzailea.setText(enk.getSaltzaile().getIzena());
		
		JLabel HasPrezioa = new JLabel("");
		HasPrezioa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		HasPrezioa.setBounds(369, 30, 94, 24);
		contentPane.add(HasPrezioa);
		HasPrezioa.setText(Double.toString(enk.getPrezioa()));
		
		JLabel Artikulua = new JLabel("");
		Artikulua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Artikulua.setBounds(109, 65, 94, 24);
		contentPane.add(Artikulua);
		Artikulua.setText(enk.getIzena());
		
		JLabel bukDataetaOrdu = new JLabel("");
		bukDataetaOrdu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bukDataetaOrdu.setBounds(433, 65, 209, 24);
		contentPane.add(bukDataetaOrdu);
		bukDataetaOrdu.setText(enk.getData()+"  "+enk.getOrdua());
		
		JLabel Deskrip = new JLabel("");
		Deskrip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Deskrip.setBounds(32, 123, 594, 58);
		contentPane.add(Deskrip);
		Deskrip.setText(enk.getDeskribapena());
		
		JLabel prezioMax = new JLabel("");
		prezioMax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prezioMax.setBounds(406, 571, 94, 24);
		contentPane.add(prezioMax);
		prezioMax.setText(this.prezioMax+" €");
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userGUI user = new userGUI(ID);
				user.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnAtzera.setBounds(538, 571, 104, 23);
		contentPane.add(btnAtzera);
	
		List<Puja> pujBek=BL.getPujak(enk.getIzena());
		System.out.println(pujBek.size());
		for( int i=0; i<pujBek.size(); i++) {
				JLabel lab = new JLabel("  "+pujBek.get(i).getUserIzena()+" "+pujBek.get(i).getPujatutakoPrezioa()+" €");
				labelak.add(lab);
				panel.add(lab);
				panel.updateUI();	
		}
		
	}
}
