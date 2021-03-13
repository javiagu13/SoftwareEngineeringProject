package businessLogic;

import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.jws.WebMethod;
import javax.jws.WebService;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Admin;
import domain.Enkante;
import domain.Erabiltzaile;
import domain.Jabe;
import domain.Langile;
import domain.Puja;
import domain.User;

/**
 * It implements the business logic as a web service.
 */
@WebService(endpointInterface = "businessLogic.BLFacade")
public class BLFacadeImplementation  implements BLFacade {

	public BLFacadeImplementation()  {		
		System.out.println("Creating BLFacadeImplementation instance");
		ConfigXML c=ConfigXML.getInstance();
		
		if (c.getDataBaseOpenMode().equals("initialize")) {
			DataAccess dbManager=new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
			dbManager.initializeDB();
			dbManager.close();
			}
		
	}

	/**
	 * This method invokes the data access to initialize the database with some events and questions.
	 * It is invoked only when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
    @WebMethod	
	 public void initializeBD(){
		DataAccess dBManager=new DataAccess();
		dBManager.initializeDB();
		dBManager.close();
	}

	
	@WebMethod
	public Erabiltzaile Login(String log, String pass) {
		DataAccess dbManager = new DataAccess();
		Erabiltzaile E=dbManager.Login(log, pass);
		dbManager.close();
		return E;
	}
	
	@WebMethod
	public void createUser(String izena, String pass, String email, String NAN, int tel) {
		DataAccess dbManager = new DataAccess();
	    dbManager.createUser(izena,pass,email,NAN,tel);
	    dbManager.close();
	}
	
	@WebMethod
	public void createJabe(String izena, String pass, String email, String NAN, int tel) {
		DataAccess dbManager = new DataAccess();
	    dbManager.createJabe(izena,pass,email,NAN,tel);
	    dbManager.close();
	}
	
	@WebMethod
	public void createAdmin(String izena, String pass, String email, String NAN, int tel) {
		DataAccess dbManager = new DataAccess();
	    dbManager.createAdmin(izena,pass,email,NAN,tel);
	    dbManager.close();
	}
	
	@WebMethod
	public void createLangile(String izena, String pass, String email, String NAN, int tel) {
		DataAccess dbManager = new DataAccess();
	    dbManager.createLangile(izena,pass,email,NAN,tel);
	    dbManager.close();
	}
	
	@WebMethod
	public void createEnkante(String izen, String deskrib, int Prezioa, String Data, String ordua, User irabazle, String Saltzaile, String dagoenekoUserIzena) {
		DataAccess dbManager = new DataAccess();
	    dbManager.createEnkante(izen,deskrib,Prezioa,Data,ordua,irabazle,Saltzaile,dagoenekoUserIzena);
	    dbManager.close();
	}
	
	@WebMethod
	public void createPuja(int PujatutakoPrezioa, String EnkanteIzena, String UserIzena) {
		DataAccess dbManager = new DataAccess();
	    dbManager.createPuja(PujatutakoPrezioa,EnkanteIzena,UserIzena);
	    dbManager.close();
	}
	
	@WebMethod
	public List<Enkante> getJabeEnkanteak(String izena) {
		DataAccess dbManager = new DataAccess();
	    List<Enkante> LE =dbManager.getJabeEnkanteak(izena);
	    dbManager.close();
	    return LE;
	}
	
	@WebMethod
	public List<Enkante> getUserEnkanteak(String izena) {
		DataAccess dbManager = new DataAccess();
	    List<Enkante> LE =dbManager.getUserEnkanteak(izena);
	    dbManager.close();
	    return LE;
	}
	
	@WebMethod
	public double diruaLortu(String ID) {
		DataAccess dbManager = new DataAccess();
		double dirua =dbManager.diruaLortu(ID);
		dbManager.close();
		return dirua;
	}
	
	@WebMethod
	public void diruaSartu(String ID, double diruKop) {
		DataAccess dbManager = new DataAccess();
		dbManager.diruaSartu(ID, diruKop);
		dbManager.close();
	}
	@WebMethod	
	public void diruaKendu(String ID, double diruKop) {
		DataAccess dbManager = new DataAccess();
		dbManager.diruaKendu(ID, diruKop);
		dbManager.close();
	}
	 @WebMethod	
	public void diruaBueltatu(String enkanteIzena) {
		DataAccess dbManager = new DataAccess();
		dbManager.diruaBueltatu(enkanteIzena);
		dbManager.close();
	}
	 @WebMethod	
	 public double pujaMax(String enkanteIzena) {
		DataAccess dbManager = new DataAccess();
		double p=dbManager.pujaMax(enkanteIzena);
		dbManager.close();
		return p;
	 }
	 
	 @WebMethod	
		public List<Enkante> getEnkanteak()  {
			DataAccess dbManager=new DataAccess();
			List<Enkante>  events=dbManager.getEnkanteak();
			dbManager.close();
			return events;
		}
	 
	 @WebMethod	
		public List<Puja> getPujak(String EnkanteIzena)  {
			DataAccess dbManager=new DataAccess();
			List<Puja> pujBek=dbManager.getPujak(EnkanteIzena);
			dbManager.close();
			return pujBek;
		}

	 @WebMethod
	 public void setIrabazle(String enkanteIzena) {
		 DataAccess dbManager = new DataAccess();
			dbManager.setIrabazle(enkanteIzena);
			dbManager.close();
	 }
}

