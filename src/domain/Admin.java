package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Admin extends Erabiltzaile implements Serializable{
	
	public Admin() {}
	public Admin(String izena, String pass, String email, String NAN, int tel, String mota) {
		super(izena, pass, email, NAN, tel, mota);
		// TODO Auto-generated constructor stub
	}
}
