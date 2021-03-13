package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JTree;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JSpinField;

import businessLogic.BLFacadeImplementation;
import domain.Enkante;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class jabeGUI extends JFrame {

	private JPanel contentPane;
	private jabeGUI frame;
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
					jabeGUI frame = new jabeGUI(ID);
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
	public jabeGUI(String ID) {
		this.ID=ID;
		System.out.println(this.ID);
		frame=this;
		setTitle("JABEA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSalmentanJarri = new JButton("SALMENTAN JARRI");
		btnSalmentanJarri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jabeSalmentaGUI jS = new jabeSalmentaGUI(ID);
				jS.setVisible(true);
			}
		});
		btnSalmentanJarri.setBounds(21, 22, 167, 23);
		
		JButton btnEnkanteakBistaratu = new JButton("ENKANTEAK BISTARATU");
		btnEnkanteakBistaratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				panel.removeAll();
				panel.updateUI();
				botoiak.clear();
				
				BLFacadeImplementation BL = new BLFacadeImplementation();
				List<Enkante> enkante = BL.getEnkanteak();
				for( int i=0; i<enkante.size(); i++) {
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
					catch(Exception e) {
						e.getMessage();
					}
				}	
				
				MouseListener boton =new MouseListener(){

				    public void mouseClicked(MouseEvent event) {
				    	for (int i=0; i<botoiak.size();i++) {
					        if(event.getSource()==botoiak.get(i)){
					            pujaJabeIkusiGUI puja = new pujaJabeIkusiGUI(ID, enk.get(i));
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
		btnEnkanteakBistaratu.setBounds(68, 56, 181, 23);
		
		JButton btnArtikuluakBistaratu = new JButton("NIRE ENKANTEAK BISTARATU");
		btnArtikuluakBistaratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				panel.removeAll();
				panel.updateUI();
				botoiak.clear();
				
				BLFacadeImplementation BL = new BLFacadeImplementation();
				List<Enkante> enkante = BL.getJabeEnkanteak(ID);
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
					            pujaJabeIkusiGUI puja = new pujaJabeIkusiGUI(ID, enkante.get(i));
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
		btnArtikuluakBistaratu.setBounds(259, 56, 215, 23);
		contentPane.setLayout(null);
		contentPane.add(btnSalmentanJarri);
		contentPane.add(btnEnkanteakBistaratu);
		contentPane.add(btnArtikuluakBistaratu);
		
		JButton btnSaioaItxi = new JButton("SAIOA ITXI");
		btnSaioaItxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginGUI login = new loginGUI();
				login.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnSaioaItxi.setBounds(424, 22, 113, 23);
		contentPane.add(btnSaioaItxi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(68, 90, 406, 217);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 10, 0));
		
		JButton btnNewButton = new JButton("AKTUALIZATU!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jabeGUI u = new jabeGUI(ID);
				frame.setVisible(false);
				u.setVisible(true);
			}
		});
		btnNewButton.setBounds(185, 318, 167, 23);
		contentPane.add(btnNewButton);
	}
}
