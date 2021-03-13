package businessLogic;

import java.util.Vector;
import java.util.Date;
import java.util.List;

import domain.Enkante;
import domain.Erabiltzaile;
import domain.Puja;
import domain.User;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Interface that specifies the business logic.
 */
@WebService
public interface BLFacade  {
	
	@WebMethod
	public Erabiltzaile Login(String log, String pass);
	
	@WebMethod
	public void createUser(String izena, String pass, String email, String NAN, int tel);
	
	@WebMethod
	public void createJabe(String izena, String pass, String email, String NAN, int tel);
	
	@WebMethod
	public void createAdmin(String izena, String pass, String email, String NAN, int tel);
	
	@WebMethod
	public void createLangile(String izena, String pass, String email, String NAN, int tel);
	
	@WebMethod
	public void createEnkante(String izen, String deskrib, int Prezioa,String Data, String ordua, User irabazle, String Saltzaile, String dagoenekoUserIzena);
	
	@WebMethod
	public void createPuja(int PujatutakoPrezioa, String EnkanteIzena,String UserIzena);
	
	@WebMethod
	public List<Enkante> getJabeEnkanteak(String izena);
	
	@WebMethod
	public List<Enkante> getUserEnkanteak(String izena);
	
	@WebMethod
	public double diruaLortu(String ID);
	
	@WebMethod
	public void diruaSartu(String ID, double diruKop);
	
	@WebMethod
	public void diruaKendu(String ID, double diruKop);
	
	@WebMethod
	public void diruaBueltatu(String enkanteIzena);
	
	@WebMethod
	public double pujaMax(String enkanteIzena);
	
	@WebMethod
	public List<Enkante> getEnkanteak();
	
	@WebMethod
	public List<Puja> getPujak(String EnkanteIzena);
	
	@WebMethod
	public void setIrabazle(String enkanteIzena);
}
