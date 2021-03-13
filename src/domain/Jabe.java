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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Jabe extends Erabiltzaile implements Serializable{

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private List<Enkante> nireEnkanteak= new ArrayList<Enkante>();
	
	public Jabe() {}
	
	public Jabe(String izena, String pass, String email, String NAN, int tel, String mota) {
		super(izena, pass, email, NAN, tel, mota);
		// TODO Auto-generated constructor stub
	}
	
	public List<Enkante> getNireEnkanteak() {
		System.out.println(nireEnkanteak.size() +" tamaño del vector desde domain");
		return this.nireEnkanteak;
	}

	public void addEnkante(Enkante nireEnkanteak) {
		this.nireEnkanteak.add(nireEnkanteak);
	}

}
