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

public class pujaJabeIkusiGUI extends JFrame {

	private JPanel contentPane;
	private pujaJabeIkusiGUI frame;
	private static String ID;
	private static Enkante enk;
	private double prezioMax;
	private JPanel panel;
	private List<JLabel> labelak = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pujaJabeIkusiGUI frame = new pujaJabeIkusiGUI(ID, enk);
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
	public pujaJabeIkusiGUI(String ID, Enkante enk) {
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
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jabeGUI user = new jabeGUI(ID);
				user.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnAtzera.setBounds(538, 571, 104, 23);
		contentPane.add(btnAtzera);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(463, 344, 179, 77);
		contentPane.add(lblNewLabel_1);
		if(enk.getIrabazle()==null) lblNewLabel_1.setText("SALMENTAN!");
		else lblNewLabel_1.setText("SALDUTA!");

		
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
