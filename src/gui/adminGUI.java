package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogic.BLFacadeImplementation;
import domain.Enkante;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class adminGUI extends JFrame {

	private JPanel contentPane;
	private adminGUI frame;
	private static String ID;
	private JPanel panel;
	private List<JButton> botoiak = new ArrayList<>();
	private List<Enkante> enk= new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminGUI frame = new adminGUI(ID);
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
	public adminGUI(String ID) {
		this.ID=ID;
		frame=this;
		System.out.println(this.ID);
		setTitle("ADMIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnEnkanteakBistaratu = new JButton("ENKANTEAK BISTARATU");
		btnEnkanteakBistaratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.updateUI();
				botoiak.clear();
				
				BLFacadeImplementation BL = new BLFacadeImplementation();
				List<Enkante> enkante = BL.getEnkanteak();
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
					            pujaAdminItxiGUI puja = new pujaAdminItxiGUI(ID, enk.get(i));
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
		btnEnkanteakBistaratu.setBounds(68, 45, 181, 23);
		contentPane.setLayout(null);
		contentPane.add(btnEnkanteakBistaratu);
		
		JButton btnItxiEnkantea = new JButton("AKTUALIZATU!");
		btnItxiEnkantea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminGUI u = new adminGUI(ID);
				frame.setVisible(false);
				u.setVisible(true);
			}
		});
		btnItxiEnkantea.setBounds(158, 295, 223, 23);
		contentPane.add(btnItxiEnkantea);
		
		JButton btnNewButton = new JButton("LANGILE BERRIA SORTU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				langileBerriSortuGUI langileGUI = new langileBerriSortuGUI(ID);
				langileGUI.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(293, 45, 181, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSaioaItxi = new JButton("SAIOA ITXI");
		btnSaioaItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginGUI login = new loginGUI();
				login.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnSaioaItxi.setBounds(424, 11, 113, 23);
		contentPane.add(btnSaioaItxi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(68, 79, 406, 205);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
	}
}