package dataAccess;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import configuration.ConfigXML;
import domain.Admin;
import domain.Enkante;
import domain.Erabiltzaile;
import domain.Jabe;
import domain.Langile;
import domain.Puja;
import domain.User;
/**
 * It implements the data access to the objectDb database
 */
public class DataAccess  {
	protected static EntityManager  db;
	protected static EntityManagerFactory emf;


	ConfigXML c;

	public DataAccess(boolean initializeMode)  {
		
		c=ConfigXML.getInstance();
		
		System.out.println("Creating DataAccess instance => isDatabaseLocal: "+c.isDatabaseLocal()+" getDatabBaseOpenMode: "+c.getDataBaseOpenMode());

		String fileName=c.getDbFilename();
		if (initializeMode)
			fileName=fileName+";drop";
		
		if (c.isDatabaseLocal()) {
			  emf = Persistence.createEntityManagerFactory("objectdb:"+fileName);
			  db = emf.createEntityManager();
		} else {
			Map<String, String> properties = new HashMap<String, String>();
			  properties.put("javax.persistence.jdbc.user", c.getUser());
			  properties.put("javax.persistence.jdbc.password", c.getPassword());

			  emf = Persistence.createEntityManagerFactory("objectdb://"+c.getDatabaseNode()+":"+c.getDatabasePort()+"/"+fileName, properties);

			  db = emf.createEntityManager();
    	   }
	}

	public DataAccess()  {	
		 new DataAccess(false);
	}
	
	/**
	 * This is the data access method that initializes the database with some events and questions.
	 * This method is invoked by the business logic (constructor of BLFacadeImplementation) when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
	public void initializeDB(){//izena,pass,email,nan,tel,mota
		System.out.println("DB is being initialized.");
		db.getTransaction().begin();
		User e1 = new User("javiArrunta","1234","javiagu13@gmail.com","49581086D",685211806,"User",0); 
		Jabe e2 = new Jabe("javiJabea","1234","javiagu13@gmail.com","49581086D",685211806,"Jabe"); 
		Langile e3 = new Langile("javiLangile","1234","javiagu13@gmail.com","49581086D",685211806,"Langile"); 
		Admin e4 = new Admin("javiAdmin","1234","javiagu13@gmail.com","49581086D",685211806,"Admin"); 
		Admin e5 = new Admin("javiAdmin2","1234","javiagu13@gmail.com","49581086D",685211806,"Admin"); 
		db.persist(e1);
		db.persist(e2);
		db.persist(e3);
		db.persist(e4);
		db.persist(e5);
		db.getTransaction().commit();
		System.out.println("DB is finished initializing.");
	}
	

	public void close(){
		db.close();
		System.out.println("DataBase closed");
	}
	
	private Date newDate(int year,int month,int day) {

	     Calendar calendar = Calendar.getInstance();
	     calendar.set(year, month, day,0,0,0);
	     calendar.set(Calendar.MILLISECOND, 0);

	     return calendar.getTime();
	}
	
	public Erabiltzaile Login(String log, String pass) {
		Erabiltzaile E = db.find(Erabiltzaile.class, log);
		System.out.println(E);
		System.out.println("Sartutako User:"+log+" DBko user:"+E.getIzena()+" Sartutako pasahitza: "+pass+" DBko pasahitza: "+E.getPasahitza());
		if(E.getPasahitza().equals(pass)) return E;
		else return null;
	}
	
	public User createUser(String izena, String pass, String email, String NAN, int tel) {
		db.getTransaction().begin();
		User E = new User(izena,pass,email,NAN,tel,"User",0);
		db.persist(E);
		db.getTransaction().commit();
		return E;
	}
	
	public Jabe createJabe(String izena, String pass, String email, String NAN, int tel) {
		db.getTransaction().begin();
		Jabe E = new Jabe(izena,pass,email,NAN,tel,"Jabe");
		db.persist(E);
		db.getTransaction().commit();
		return E;
	}
	
	public Admin createAdmin(String izena, String pass, String email, String NAN, int tel) {
		db.getTransaction().begin();
		Admin E = new Admin(izena,pass,email,NAN,tel,"Admin");
		db.persist(E);
		db.getTransaction().commit();
		return E;
	}
	
	public Langile createLangile(String izena, String pass, String email, String NAN, int tel) {
		db.getTransaction().begin();
		Langile E = new Langile(izena,pass,email,NAN,tel,"Langile");
		db.persist(E);
		db.getTransaction().commit();
		return E;
	}
	
	public Enkante createEnkante(String izen, String deskrib, int Prezioa, String Data, String ordua, User irabazle, String Saltzaile, String dagoenekoUserIzena) {
		db.getTransaction().begin();
		Jabe J=db.find(Jabe.class, Saltzaile);
		Enkante E = new Enkante(izen,deskrib,Prezioa,Data,ordua,irabazle,J,dagoenekoUserIzena);
		db.persist(E);
		J.addEnkante(E);
		db.getTransaction().commit();
		return E;
	}

	public Puja createPuja(int PujatutakoPrezioa, String EnkanteIzena, String UserIzena) {
		db.getTransaction().begin();
		Puja P = new Puja(PujatutakoPrezioa,EnkanteIzena,UserIzena);
		db.persist(P);
		Enkante E = db.find(Enkante.class, EnkanteIzena);
		E.addPuja(P);
		db.getTransaction().commit();
		return P;
	}
	
	public double diruaLortu(String ID) {
		User U = db.find(User.class, ID);
		return U.getDirua();
	}
	
	public void diruaSartu(String ID, double diruKop) {
		db.getTransaction().begin();
		User U = db.find(User.class, ID);
		double zegoenDirua=U.getDirua();
		zegoenDirua+=diruKop;
		U.setDirua(zegoenDirua);
		db.persist(U);
		db.getTransaction().commit();
	}
	
	public void diruaKendu (String ID, double diruKop) {
		db.getTransaction().begin();
		User U = db.find(User.class, ID);
		double zegoenDirua=U.getDirua();
		zegoenDirua-=diruKop;
		U.setDirua(zegoenDirua);
		db.persist(U);
		db.getTransaction().commit();
	}
	
	public void diruaBueltatu(String enkanteIzena) {
		try {
		db.getTransaction().begin();
		Enkante E = db.find(Enkante.class, enkanteIzena);
		Puja P =E.getPujaMax();
		String izen=P.getUserIzena();
		double diru=P.getPujatutakoPrezioa();
		User U = db.find(User.class, izen);
		double zegoenDirua=U.getDirua();
		U.setDirua(diru+zegoenDirua);
		db.persist(U);
		db.getTransaction().commit();
		}
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public double pujaMax(String enkanteIzena) {
		try {
		Enkante E = db.find(Enkante.class, enkanteIzena);
		Puja P =E.getPujaMax();
		return P.getPujatutakoPrezioa();
		}
		catch(Exception e){
			return -1;
		}
	}
	
	public List<Enkante> getEnkanteak() {
		System.out.println(">> DataAccess: getEvents");
		List<Enkante> res = new ArrayList<Enkante>();	
		TypedQuery<Enkante> query = db.createQuery("SELECT izena FROM Enkante izena",Enkante.class);   
		List<Enkante> enk = query.getResultList();
	 	 for (Enkante izena:enk){
	 	   System.out.println(izena.toString());		 
		   res.add(izena);
		  }
	 	return res;
	}
	
	public List<Enkante> getJabeEnkanteak(String izena) {
		Jabe J = db.find(Jabe.class, izena);
		return J.getNireEnkanteak();
	}
	
	public List<Enkante> getUserEnkanteak(String izena) {
		User U = db.find(User.class, izena);
		return U.getNireEnkanteak();
	}
	
	public List<Puja> getPujak(String EnkanteIzena) {
		Enkante E = db.find(Enkante.class, EnkanteIzena);
		return E.getPujak();
	}
	
	public void setIrabazle(String enkanteIzena) {
		db.getTransaction().begin();
			Enkante E = db.find(Enkante.class, enkanteIzena);
			Puja P = E.getPujaMax();
			User U = db.find(User.class, P.getUserIzena());
			E.setIrabazle(U);
			U.addEnkante(E);
			db.persist(E);
			db.persist(U);
			System.out.println("dataAccess user: "+P.getUserIzena());
			System.out.println("dataAccess enkante: "+P.getEnkanteIzena());
		db.getTransaction().commit();
	}
}
