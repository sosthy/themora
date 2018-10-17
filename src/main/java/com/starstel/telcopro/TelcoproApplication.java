package com.starstel.telcopro;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.starstel.telcopro.accounts.entities.AppRole;
import com.starstel.telcopro.accounts.entities.AppUser;
import com.starstel.telcopro.accounts.services.AccountService;
import com.starstel.telcopro.rh.entities.Employee;
import com.starstel.telcopro.stocks.entities.Emplacement;
import com.starstel.telcopro.stocks.entities.Entrepot;
import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.MouvmentType;
import com.starstel.telcopro.stocks.entities.Recipient;
import com.starstel.telcopro.stocks.entities.RecipientGroupe;
import com.starstel.telcopro.stocks.entities.Stock;
import com.starstel.telcopro.stocks.services.EntrepotService;
import com.starstel.telcopro.stocks.services.MouvmentService;
import com.starstel.telcopro.stocks.services.RecipientService;
import com.starstel.telcopro.stocks.services.StockService;

@SpringBootApplication
public class TelcoproApplication implements CommandLineRunner
{
	@Autowired
	private AccountService accountService;
	@Autowired
	private StockService stockService;
	@Autowired
	private RecipientService recipientService;
	@Autowired
	private MouvmentService mouvmentService;
	@Autowired
	private EntrepotService entrepotService;
	
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
		
		AppRole admin = new AppRole();
		admin.setRoleName("ADMIN");
		admin.setDescription("No Description");
		admin = accountService.createRole(admin);
		
		AppRole simple = new AppRole();
		simple.setRoleName("SIMPLE");
		simple.setDescription("No Description");
		simple = accountService.createRole(simple);
		
		AppUser user = new AppUser();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setLockStatus(false);
		user.setEmail("sosthenegolden@gmail.com");
		user.getRoles().add(admin);
		user.getRoles().add(simple);
		
		Employee employee = new Employee();
		employee.setName("NOUEBISSI NGHEMNIN");
		employee.setSurname("Sosthene");
		employee.setBirthday(new Date());
		employee.setHiring_date(new Date());
		employee.setPhone("655321007");
		employee.setSex("M");
		employee.setAnciennete(4);
		employee.setPhoto("XXXX");
		employee.setCni("KIT272");
		employee.setAppUser(user);
		accountService.createEmployee(employee);
		
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
		Stock stock2 = new Stock(null, 0.0, new Date(), "ALCATEL Z", null, 0.0, 0.0, 0.0, 100.0, 20.0, 2000.0, "No", null, emplacement1, null, null, null);
		Stock stock3 = new Stock(null, 0.0, new Date(), "SAMSUNG S2", null, 0.0, 0.0, 0.0, 100.0, 20.0, 2000.0, "No", null, emplacement1, null, null, null);
		Stock stock4 = new Stock(null, 0.0, new Date(), "INFINIX", null, 0.0, 0.0, 0.0, 100.0, 20.0, 2000.0, "No", null, emplacement1, null, null, null);
		stockService.saveStock(stock1);
		stockService.saveStock(stock2);
		stockService.saveStock(stock3);
		stockService.saveStock(stock4);
		
	}
}
