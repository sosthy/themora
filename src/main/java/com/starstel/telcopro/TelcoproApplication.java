package com.starstel.telcopro;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.starstel.telcopro.accounts.entities.AppMenu;
import com.starstel.telcopro.accounts.entities.AppRole;
import com.starstel.telcopro.accounts.entities.AppUser;
import com.starstel.telcopro.accounts.repositories.AppMenuRepository;
import com.starstel.telcopro.accounts.services.AccountService;
import com.starstel.telcopro.rh.entities.Employee;
import com.starstel.telcopro.rh.services.EmployeeService;
import com.starstel.telcopro.stocks.entities.Emplacement;
import com.starstel.telcopro.stocks.entities.Entrepot;
import com.starstel.telcopro.stocks.entities.MeasureUnit;
import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.MouvmentType;
import com.starstel.telcopro.stocks.entities.Portable;
import com.starstel.telcopro.stocks.entities.Product;
import com.starstel.telcopro.stocks.entities.Recipient;
import com.starstel.telcopro.stocks.entities.RecipientGroupe;
import com.starstel.telcopro.stocks.entities.State;
import com.starstel.telcopro.stocks.entities.Stock;
import com.starstel.telcopro.stocks.entities.StockCategory;
import com.starstel.telcopro.stocks.services.EntrepotService;
import com.starstel.telcopro.stocks.services.MouvmentService;
import com.starstel.telcopro.stocks.services.PortableService;
import com.starstel.telcopro.stocks.services.ProductService;
import com.starstel.telcopro.stocks.services.RecipientService;
import com.starstel.telcopro.stocks.services.StockService;

@SpringBootApplication
public class TelcoproApplication implements CommandLineRunner
{
	@Autowired
	private AccountService accountService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private StockService stockService;
	@Autowired
	private RecipientService recipientService;
	@Autowired
	private MouvmentService mouvmentService;
	@Autowired
	private EntrepotService entrepotService;
	@Autowired
	private PortableService portableService;
	@Autowired
	private ProductService productService;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(TelcoproApplication.class, args);
	}
	
	@Bean // Instanciation de BCryptPasswordEncoder
	public BCryptPasswordEncoder getBCPE() 
	{	
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception 
	{	
		AppMenu menuStock= new AppMenu("Gestion des stocks","USER");
		AppMenu menuRh= new AppMenu("Gestion des ressources humaines","RH");

		
		AppRole admin = new AppRole();
		admin.setRoleName("ADMIN");
		admin.setDescription("No Description");

		AppRole magasinier = new AppRole();
		magasinier.setRoleName("MAGASINIER");
		magasinier.setDescription("employé s'occupant d'un magasin de l'entreprise");
		
		AppRole humanRessource = new AppRole();
		humanRessource.setRoleName("RH");
		humanRessource.setDescription("employé travaillant aux ressources humaines de l'entreprise");
		
		AppRole simple = new AppRole();
		simple.setRoleName("SIMPLE");
		simple.setDescription("No Description");
		
		
		admin = accountService.createRole(admin);
		magasinier = accountService.createRole(magasinier);
		humanRessource = accountService.createRole(humanRessource);
		simple = accountService.createRole(simple);


		menuStock.getRoles().add(magasinier);
		menuRh.getRoles().add(humanRessource);
		
		menuRh=accountService.createAppMenu(menuRh);
		menuStock=accountService.createAppMenu(menuStock);
		
		
		
		AppUser user = new AppUser("admin","admin","sosthenegolden@gmail.com",Boolean.FALSE);
		user.getRoles().add(admin);
		user.getRoles().add(simple);
		
		AppUser user2 = new AppUser("admin2","admin2","romeo@gmail.com",Boolean.FALSE);
		user.getRoles().add(magasinier);
		
		AppUser user3 = new AppUser("admin3","admin3","fabien@gmail.com",Boolean.FALSE);
		user.getRoles().add(humanRessource);
		
		Employee employee = new Employee(null,"NOUEBISSI NGHEMNIN","Sosthene","693936236","rsosthenegolden@gmail.com",
				"M","KIT272","655321007","XXXX",new Date(),new Date(),Integer.valueOf(4));
		
		Employee employee2 = new Employee(null,"TCHECHE","Romeo","693936236","romeo.@gmail.com","M","475JHk5","78221242",
				"romeo.png",new Date(),new Date(),Integer.valueOf(1));
		
		Employee employee3 = new Employee(null,"Fabien","DUBUISSON","52481234","fabien.@gmail.com","M","475JHk5","78221242",
				"romeo.png",new Date(),new Date(),Integer.valueOf(1));
		
		user.setEmployee(employee);
		user2.setEmployee(employee2);
		user3.setEmployee(employee3);
		
		user=accountService.saveUser(user);
		user2=accountService.saveUser(user2);
		user3=accountService.saveUser(user3);


		employee.setAppUser(user);
		employee.setAppUser(user2);
		employee.setAppUser(user3);
		
		employee=employeeService.createEmployee(employee);
		employee2=employeeService.createEmployee(employee2);
		employee3=employeeService.createEmployee(employee3);
		
		RecipientGroupe groupe1 = new RecipientGroupe(null, "FOURNISSEURS", null);
		RecipientGroupe groupe2 = new RecipientGroupe(null, "CLIENTS", null);
		groupe1 = recipientService.createRecipientGroupe(groupe1);
		groupe2 = recipientService.createRecipientGroupe(groupe2);
		
		Recipient recipient1 = new Recipient("Citoyen", "SOREPCO", "Maintenance", "Surveillant", null, null);
		recipient1.setGroupe(groupe1);
		recipient1 = recipientService.createRecipient(recipient1);
		
		Recipient recipient2 = new Recipient("Etranger", "Orange", "Reseau", "Adminitrateur", null, null);
		recipient2.setGroupe(groupe2);
		recipient2 = recipientService.createRecipient(recipient2);
		
		Recipient recipient3 = new Recipient("Etranger", "Nokia", "Telecom", "Technicien", null, null);
		recipient3.setGroupe(groupe2);
		recipient3 = recipientService.createRecipient(recipient3);
		
		MouvmentType mouvmentType1 = new MouvmentType(null, "APPROVISIONNEMENT", null, "No Description");
		MouvmentType mouvmentType2 = new MouvmentType(null, "RETOUR", null, "No Description");
		MouvmentType mouvmentType3 = new MouvmentType(null, "LIVRAISON", null, "No Description");
		MouvmentType mouvmentType4 = new MouvmentType(null, "TRANSFERT", null, "No Description");
		
		mouvmentType1 = mouvmentService.saveMouvmentType(mouvmentType1);
		mouvmentType2 = mouvmentService.saveMouvmentType(mouvmentType2);
		mouvmentType3 = mouvmentService.saveMouvmentType(mouvmentType3);
		mouvmentType4 = mouvmentService.saveMouvmentType(mouvmentType4);
		
		Entrepot entrepot1 = new Entrepot(null, "Deido Plage", 0.0, 0.0, 100.0, 70.0, null, null);
		Entrepot entrepot2 = new Entrepot(null, "Akwa", 0.0, 0.0, 170.0, 100.0, null, null);
		entrepot1 = entrepotService.saveEntrepot(entrepot1);
		entrepot2 = entrepotService.saveEntrepot(entrepot2);
		
		Mouvment mouvment1 = new Mouvment(null, "ML752P", new Date(), 0.0, 0.0, entrepot1, null, null, mouvmentType1, employee, recipient1);
		Mouvment mouvment2 = new Mouvment(null, "OZ986E", new Date(), 0.0, 0.0, entrepot1, null, null, mouvmentType1, employee, recipient1);
		mouvment1 = mouvmentService.saveMouvment(mouvment1);
		mouvment2 = mouvmentService.saveMouvment(mouvment2);
		
		Emplacement emplacement1 = new Emplacement(null, "Magasin Sabba", entrepot1, null);
		Emplacement emplacement2 = new Emplacement(null, "Etage", entrepot1, null);
		emplacement1 = entrepotService.saveEmplacement(emplacement1);
		emplacement2 = entrepotService.saveEmplacement(emplacement2);
		
		Stock stock1 = new Stock(null, 0.0, new Date(), "TECHNO Y2", null, 0.0, 0.0, 0.0, 100.0, 20.0, 2000.0, "No", null, emplacement1, null, null, null);
		Stock stock2 = new Stock(null, 0.0, new Date(), "ALCATEL Z3", null, 0.0, 0.0, 0.0, 100.0, 20.0, 2000.0, "No", null, emplacement1, null, null, null);
		Stock stock3 = new Stock(null, 0.0, new Date(), "SAMSUNG S2", null, 0.0, 0.0, 0.0, 100.0, 20.0, 2000.0, "No", null, emplacement1, null, null, null);
		Stock stock4 = new Stock(null, 0.0, new Date(), "INFINIX", null, 0.0, 0.0, 0.0, 100.0, 20.0, 2000.0, "No", null, emplacement1, null, null, null);
		Stock stock5 = new Stock(null, 2.0, Date.from(Instant.now()), "SP4 Senior Phone", "images/SP4_Senior_Phone.PNG", 
				80000.0, 60000.0, 70000.0, 100.0, 20.0, 2000.0, "No", null, emplacement1, 
				null, null, null);
		

		Portable portable= new Portable("C",2D,"B","Sim",2D,2D,"Ip",Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,null
				,null,null,null,null,null,null);
		Portable portable1= new Portable("C",2D,"B","Sim",2D,2D,"Ip",Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,null
				,null,null,null,null,null,null);
		Portable portable2= new Portable("C",2D,"B","Sim",2D,2D,"Ip",Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,null
				,null,null,null,null,null,null);
		Portable portable3= new Portable("C",2D,"B","Sim",2D,2D,"Ip",Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,null
				,null,null,null,null,null,null);
		Portable portable4= new Portable("C",2D,"B","Sim",2D,2D,"Ip",Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,null
				,null,null,null,null,null,null);
		
		portable.setStock(stock1);
		portable1.setStock(stock2);
		portable2.setStock(stock3);
		portable3.setStock(stock4);
		portable4.setStock(stock5);
		
		stock1.setProduct(portable);
		stock2.setProduct(portable1);
		stock3.setProduct(portable2);
		stock4.setProduct(portable3);
		stock5.setProduct(portable4);
		
		stockService.saveStock(stock1);
		stockService.saveStock(stock2);
		stockService.saveStock(stock3);
		stockService.saveStock(stock4);
		stockService.saveStock(stock5);
		
		portableService.save(portable);
		portableService.save(portable1);
		portableService.save(portable2);
		portableService.save(portable3);
		portableService.save(portable4);
		
		
		
	}
}
