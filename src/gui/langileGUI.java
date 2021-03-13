package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import businessLogic.BLFacadeImplementation;
import domain.Enkante;

import java.awt.Color;
import java.awt.GridLayout;

public class langileGUI extends JFrame {

	private JPanel contentPane;
	private langileGUI frame;
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
					langileGUI frame = new langileGUI(ID);
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
	public langileGUI(String ID) {
		this.ID=ID;
		System.out.println(this.ID);
		frame=this;
		setTitle("LANGILE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
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
					catch(Exception e1) {
						e1.getMessage();
					}
				}
				MouseListener boton =new MouseListener(){

				    public void mouseClicked(MouseEvent event) {
				    	for (int i=0; i<botoiak.size();i++) {
					        if(event.getSource()==botoiak.get(i)){
					            pujaLangileItxiGUI puja = new pujaLangileItxiGUI(ID, enk.get(i));
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
		btnEnkanteakBistaratu.setBounds(176, 11, 181, 23);
		contentPane.setLayout(null);
		contentPane.add(btnEnkanteakBistaratu);
		
		JButton btnItxiEnkantea = new JButton("AKTUALIZATU!");
		btnItxiEnkantea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				langileGUI u = new langileGUI(ID);
				frame.setVisible(false);
				u.setVisible(true);
			}
		});
		btnItxiEnkantea.setBounds(158, 295, 223, 23);
		contentPane.add(btnItxiEnkantea);
		
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
		scrollPane.setBounds(68, 45, 406, 239);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
	}
}
