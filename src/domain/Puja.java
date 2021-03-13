package domain;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.persistence.GeneratedValue;
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Puja implements Serializable {
	private int PujatutakoPrezioa;
	private String EnkanteIzena;
	private String UserIzena;
	
	public Puja() {}
	public Puja(int pujatutakoPrezioa, String EnkanteIzena, String UserIzena) {
		this.PujatutakoPrezioa=pujatutakoPrezioa;		
		this.EnkanteIzena=EnkanteIzena;
		this.UserIzena=UserIzena;
	}
	
	public String getUserIzena() {
		return UserIzena;
	}

	public void setUserIzena(String userIzena) {
		UserIzena = userIzena;
	}

	public String getEnkanteIzena() {
		return EnkanteIzena;
	}

	public void setEnkanteIzena(String enkanteIzena) {
		EnkanteIzena = enkanteIzena;
	}
	
	public double getPujatutakoPrezioa() {
		return PujatutakoPrezioa;
	}
	
	public void setPujatutakoPrezioa(int pujatutakoPrezioa) {
		PujatutakoPrezioa = pujatutakoPrezioa;
	}


}
