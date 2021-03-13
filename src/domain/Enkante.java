package domain;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.persistence.GeneratedValue;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Enkante implements Serializable{
@Id
@XmlID 
private String enkIzena;
private String deskribapena;
private int Prezioa;
private String Data;
private String Ordua;
private User Irabazle;
private Jabe Saltzaile;
private String dagoenekoUserIzena;
@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
private List<Puja> enkPuja = new ArrayList<Puja>();


	public Enkante() {}
	
	public Enkante(String izen, String deskrib, int Prezioa, String Data, String ordua, User irabazle, Jabe Saltzaile, String dagoenekoUserIzena) {
		this.enkIzena=izen;
		this.deskribapena=deskrib;
		this.Prezioa=Prezioa;
		this.Data=Data;
		this.Ordua=ordua;
		this.Irabazle=irabazle;
		this.Saltzaile=Saltzaile;
		this.dagoenekoUserIzena=dagoenekoUserIzena;
	}

	public String getDagoenekoUserIzena() {
		return dagoenekoUserIzena;
	}
	
	public void setDagoenekoUserIzena(String dagoenekoUserIzena) {
		this.dagoenekoUserIzena = dagoenekoUserIzena;
	}
	
	public String getIzena() {
		return enkIzena;
	}
	
	public void setIzena(String izena) {
		this.enkIzena = izena;
	}
	
	public String getDeskribapena() {
		return deskribapena;
	}
	
	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}
	
	public double getPrezioa() {
		return Prezioa;
	}
	
	public void setPrezioa(int Prezioa) {
		this.Prezioa = Prezioa;
	}
	
	public String getData() {
		return Data;
	}
	
	public void setData(String data) {
		Data = data;
	}
	
	public String getOrdua() {
		return Ordua;
	}
	
	public void setOrdua(String ordua) {
		Ordua = ordua;
	}
	
	public User getIrabazle() {
		return Irabazle;
	}
	
	public void setIrabazle(User irab) {
		System.out.println("irabazle: "+irab);
		this.Irabazle = irab;
	}
	
	public Jabe getSaltzaile() {
		return Saltzaile;
	}
	
	public void setSaltzaile(Jabe saltzaile) {
		Saltzaile = saltzaile;
	}
		
	public void addPuja(Puja puj) {
		this.enkPuja.add(puj);
	}

	public List<Puja> getPujak() {
		System.out.println(enkPuja.toString());
		return this.enkPuja;
	}
	
	public Puja getPujaMax() {
		try{
		double pujMax=0;
		double dagoenekoPuj=0;
		Puja dagoenekoIrabazle;
		
		pujMax=enkPuja.get(0).getPujatutakoPrezioa();
		dagoenekoIrabazle=enkPuja.get(0);
		
		for(int i=1; i<enkPuja.size(); i++) {
			dagoenekoPuj=enkPuja.get(i).getPujatutakoPrezioa();
			if(dagoenekoPuj>pujMax) {
				pujMax=dagoenekoPuj;
				dagoenekoIrabazle=enkPuja.get(i);
			}
		}
		return dagoenekoIrabazle;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
