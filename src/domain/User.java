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
import javax.persistence.GeneratedValue;
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class User extends Erabiltzaile implements Serializable {

	private double diruKop;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private List<Enkante> nireEnkanteak= new ArrayList<Enkante>();
	
	public User() {}
	
	public User(String izena, String pass, String email, String NAN, int tel, String mota, double prezio) {
		super(izena, pass, email, NAN, tel, mota);
		this.diruKop=prezio;
	}

	public double getDirua() {
		return diruKop;
	}

	public void setDirua(double diruKop) {
		this.diruKop = diruKop;
	}

	public List<Enkante> getNireEnkanteak() {
		System.out.println("size: "+this.nireEnkanteak.size());
		return this.nireEnkanteak;
	}

	public void addEnkante(Enkante e) {
		this.nireEnkanteak.add(e);
	}
}
