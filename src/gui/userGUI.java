package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacadeImplementation;
import domain.Enkante;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.Box;
import java.awt.Choice;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class userGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private userGUI frame;
	private static String ID;
	private JLabel label_2;
	private JPanel panel;
	private List<JButton> botoiak = new ArrayList<>();
	private List<Enkante> enkante;
	private List<Enkante> enk=new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userGUI frame = new userGUI(ID);
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
	public userGUI(String ID) {
		this.ID=ID;
		System.out.println(this.ID);		
		frame=this;
		setTitle("ERABILTZAILE ERREGISTRATUA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label_2 = new JLabel("");
		label_2.setBounds(75, 14, 118, 14);
		contentPane.add(label_2); 	
		BLFacadeImplementation BL = new BLFacadeImplementation();
		label_2.setText(Double.toString(BL.diruaLortu(ID)));
		
		
		JButton btnDiruaSartu = new JButton("DIRUA SARTU");
		btnDiruaSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double sartuBeharrekoDirua=Double.parseDouble(textField.getText());
				BLFacadeImplementation BL = new BLFacadeImplementation();
				BL.diruaSartu(ID, sartuBeharrekoDirua);
				label_2.setText(Double.toString(BL.diruaLortu(ID))+" €");
			}
		});
		btnDiruaSartu.setBounds(10, 39, 118, 23);
		contentPane.add(btnDiruaSartu);
		
		textField = new JTextField();
		textField.setBounds(138, 39, 86, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u20AC");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(227, 37, 18, 23);
		contentPane.add(label);
		
		JLabel lblBankua = new JLabel("Bankua:");
		lblBankua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBankua.setBounds(10, 12, 55, 14);
		contentPane.add(lblBankua);
		
		JButton btnEnkanteakBistaratu = new JButton("ENKANTEAK BISTARATU");
		btnEnkanteakBistaratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.updateUI();
				botoiak.clear();
				
				BLFacadeImplementation BL = new BLFacadeImplementation();
				enkante = BL.getEnkanteak();
				for( int i=0; i<enkante.size(); i++) {
					System.out.println("i: "+i);
					try {
						if(enkante.get(i).getIrabazle()==null) {
							enk.add(enkante.get(i));
							String dirua=Double.toString(enkante.get(i).getPrezioa());
							JButton button = new JButton("<html>"+enkante.get(i).getIzena()+"<br/>"+enkante.get(i).getDeskribapena()+"<pre>"+dirua+"€     buk data: "+enkante.get(i).getData()+"  "+enkante.get(i).getOrdua()+"</pre>"+"</html>");
							botoiak.add(button);
							panel.add(button);
							panel.updateUI();	
						}
					}
					catch(Exception e1) {
						e1.getMessage();
					}
				}
				
				MouseListener boton =new MouseListener(){

				    public void mouseClicked(MouseEvent event) {
				    	for (int i=0; i<botoiak.size();i++) {
					        if(event.getSource()==botoiak.get(i)){
					            pujaGUI puja = new pujaGUI(ID, enk.get(i));
								puja.setVisible(true);
								frame.setVisible(false);
					        }
				    	}
				    }

				    public void mouseEntered(MouseEvent event) {

				    }

				    public void mouseExited(MouseEvent event) {

				    }

				    public void mousePressed(MouseEvent event) {

				    }

				    public void mouseReleased(MouseEvent event) {

				    }

				};
				for (int i=0; i<botoiak.size();i++) {
					botoiak.get(i).addMouseListener(boton);
				}				
			}
		});
		btnEnkanteakBistaratu.setBounds(67, 76, 188, 23);
		contentPane.add(btnEnkanteakBistaratu);	
		
		JButton btnNewButton = new JButton("IRABAZITAKO ENKANTEAK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.removeAll();
				panel.updateUI();
				botoiak.clear();
				
				BLFacadeImplementation BL = new BLFacadeImplementation();
				enkante = BL.getUserEnkanteak(ID);
				for( int i=0; i<enkante.size(); i++) {
					String dirua=Double.toString(enkante.get(i).getPrezioa());
					JButton button = new JButton("<html>"+enkante.get(i).getIzena()+"<br/>"+enkante.get(i).getDeskribapena()+"<pre>"+dirua+"€     buk data: "+enkante.get(i).getData()+"  "+enkante.get(i).getOrdua()+"</pre>"+"</html>");
					botoiak.add(button);
					panel.add(button);
					panel.updateUI();	
				}
				
				MouseListener boton =new MouseListener(){

				    public void mouseClicked(MouseEvent event) {
				    	for (int i=0; i<botoiak.size();i++) {
					        if(event.getSource()==botoiak.get(i)){
					            System.out.println(enkante.get(i).getIzena());
					            pujaUserIkusiGUI puja = new pujaUserIkusiGUI(ID, enkante.get(i));
								puja.setVisible(true);
								frame.setVisible(false);
					        }
				    	}
				    }

				    public void mouseEntered(MouseEvent event) {

				    }

				    public void mouseExited(MouseEvent event) {

				    }

				    public void mousePressed(MouseEvent event) {

				    }

				    public void mouseReleased(MouseEvent event) {

				    }

				};
				for (int i=0; i<botoiak.size();i++) {
					botoiak.get(i).addMouseListener(boton);
				}	
			}
		});
		btnNewButton.setBounds(285, 76, 188, 23);
		contentPane.add(btnNewButton);
		
		JButton btnHautatutakoEnkanteanSartu = new JButton("AKTUALIZATU");
		btnHautatutakoEnkanteanSartu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userGUI u = new userGUI(ID);
				frame.setVisible(false);
				u.setVisible(true);
			}
		});
		btnHautatutakoEnkanteanSartu.setBounds(138, 303, 251, 23);
		contentPane.add(btnHautatutakoEnkanteanSartu);
		
		JButton btnSaioaItxi = new JButton("SAIOA ITXI");
		btnSaioaItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginGUI login = new loginGUI();
				login.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnSaioaItxi.setBounds(424, 12, 113, 23);
		contentPane.add(btnSaioaItxi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(57, 110, 419, 173);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
	}
}
