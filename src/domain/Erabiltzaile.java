package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.persistence.GeneratedValue;

@Entity
@XmlSeeAlso({Admin.class,Jabe.class,Langile.class,User.class})
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Erabiltzaile implements Serializable{
	@Id
	@XmlID
	private String izena;
	private String pasahitza;
	private String email;
	private String NAN;
	private int telefono;
	private String Mota;

	public String getIzena() {
		return izena;
	}



	public void setIzena(String izena) {
		this.izena = izena;
	}



	public String getPasahitza() {
		return pasahitza;
	}

	
	
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getNAN() {
		return NAN;
	}



	public void setNAN(String nAN) {
		NAN = nAN;
	}



	public int getTelefono() {
		return telefono;
	}



	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}



	public String getMota() {
		return Mota;
	}



	public void setMota(String mota) {
		Mota = mota;
	}


	public Erabiltzaile() {}
	public Erabiltzaile(String izena, String pass, String email, String NAN, int tel, String mota) {
		this.izena = izena;
		this.pasahitza = pass;
		this.email=email;
		this.NAN=NAN;
		this.telefono=tel;
		this.Mota=mota;
	}

}
