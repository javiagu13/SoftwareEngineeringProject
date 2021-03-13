package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JMonthChooser;

import businessLogic.BLFacadeImplementation;
import domain.Enkante;
import domain.Jabe;
import domain.User;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.JSpinner;
import java.awt.ComponentOrientation;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

public class jabeSalmentaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JLabel lblIzena;
	private JLabel lblDeskribapena;
	private JLabel lblHasierakoPrezioa;
	private static String ID;
	private JTextField textField_1;
	private jabeSalmentaGUI frame;
	private List<JButton> botoiak = new ArrayList<>();
	private JPanel panel;
	private List<Enkante> enkante;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jabeSalmentaGUI frame = new jabeSalmentaGUI(ID);
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
	public jabeSalmentaGUI(String ID) {
		this.ID=ID;
		frame=this;
		setTitle("SALMENTAN JARRI");
		
		botoiak = new ArrayList<JButton>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 442);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		System.out.println(ID);
		lblIzena = new JLabel("Izena:");
		lblIzena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIzena.setBounds(10, 11, 63, 14);
		contentPane.add(lblIzena);
		
		lblDeskribapena = new JLabel("Deskribapena:");
		lblDeskribapena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeskribapena.setBounds(10, 67, 99, 14);
		contentPane.add(lblDeskribapena);
		
		lblHasierakoPrezioa = new JLabel("Hasierako Prezioa:");
		lblHasierakoPrezioa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHasierakoPrezioa.setBounds(10, 171, 130, 14);
		contentPane.add(lblHasierakoPrezioa);
		
		JLabel lblBukaerakoDataEta = new JLabel("Bukaerako Data eta Ordua:");
		lblBukaerakoDataEta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBukaerakoDataEta.setBounds(10, 227, 199, 14);
		contentPane.add(lblBukaerakoDataEta);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 252, 46, 14);
		contentPane.add(lblData);
		
		JLabel lblOrdua = new JLabel("Ordua: ");
		lblOrdua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrdua.setBounds(127, 252, 62, 14);
		contentPane.add(lblOrdua);
		
		textField = new JTextField();
		textField.setBounds(10, 35, 179, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 196, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(106, 196, 46, 14);
		contentPane.add(label);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 276, 95, 20);
		contentPane.add(dateChooser);
		
		JLabel lblhhmm = new JLabel("(hh:mm)");
		lblhhmm.setBounds(148, 308, 93, 14);
		contentPane.add(lblhhmm);
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textPane.setBounds(10, 92, 301, 68);
		contentPane.add(textPane);
		
		JButton btnSalmentanJarri = new JButton("SALMENTAN JARRI!");
		btnSalmentanJarri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String izen=textField.getText();
				String deskrib=textPane.getText();
				int Prezioa=Integer.parseInt(textField_2.getText());
				String ordua= textField_1.getText();
				User irabazle = null;
				String Saltzaile = ID;
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				String Data = df.format(dateChooser.getDate());
				
				BLFacadeImplementation BL = new BLFacadeImplementation();
				BL.createEnkante(izen, deskrib, Prezioa, Data, ordua, irabazle, Saltzaile, null);
				JButton b = new JButton("<html>"+izen+"<br/>"+deskrib+"<pre>"+Prezioa+"€     buk data: "+Data+"  "+ordua+"</pre>"+"</html>");
				panel.add(b);
				botoiak.add(b);
				panel.updateUI();
			}
		});
		btnSalmentanJarri.setBounds(10, 348, 179, 23);
		contentPane.add(btnSalmentanJarri);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 276, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnAtzera.setBounds(615, 9, 89, 23);
		contentPane.add(btnAtzera);
		
		JLabel lblDagoenekoSaldutakoEdo = new JLabel("Dagoeneko Saldutako edo Salmentan Jarritako Produktuak:");
		lblDagoenekoSaldutakoEdo.setBounds(342, 69, 349, 14);
		contentPane.add(lblDagoenekoSaldutakoEdo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(342, 92, 349, 279);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
				
		//Hasieratu scrollpane
		BLFacadeImplementation BL = new BLFacadeImplementation();
		enkante = BL.getJabeEnkanteak(ID);
		System.out.println(enkante.size());
		for( int i=0; i<enkante.size(); i++) {
			String dirua=Double.toString(enkante.get(i).getPrezioa());
			JButton button = new JButton("<html>"+enkante.get(i).getIzena()+"<br/>"+enkante.get(i).getDeskribapena()+"<pre>"+dirua+"€     buk data: "+enkante.get(i).getData()+"  "+enkante.get(i).getOrdua()+"</pre>"+"</html>");
			botoiak.add(button);
			panel.add(button);
			panel.updateUI();	
		}
		//Bukatu scrollpane
	}
}
