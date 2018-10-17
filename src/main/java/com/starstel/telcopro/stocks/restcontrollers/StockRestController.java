package com.starstel.telcopro.stocks.restcontrollers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starstel.telcopro.stocks.entities.StockCategory;
import com.starstel.telcopro.rh.services.EmployeeService;
import com.starstel.telcopro.stocks.entities.Emplacement;
import com.starstel.telcopro.stocks.entities.Entrepot;
import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.MouvmentLine;
import com.starstel.telcopro.stocks.entities.MouvmentType;
import com.starstel.telcopro.stocks.entities.Product;
import com.starstel.telcopro.stocks.entities.Recipient;
import com.starstel.telcopro.stocks.entities.RecipientGroupe;
import com.starstel.telcopro.stocks.entities.State;
import com.starstel.telcopro.stocks.entities.Stock;
import com.starstel.telcopro.stocks.services.EntrepotService;
import com.starstel.telcopro.stocks.services.RecipientService;
import com.starstel.telcopro.stocks.services.StockService;

@CrossOrigin("*")
@RestController
@RequestMapping("/stocks")
public class StockRestController 
{
	@Autowired
	private StockService stockService;
	@Autowired
	private EntrepotService entrepotService;
	@Autowired
	private RecipientService recipientService;
	@Autowired
	private EmployeeService employeeService;
	
	
	/*@RequestMapping(value="/products", method = RequestMethod.GET)
	public List<Product> getAllProducts()
	{
		return stockService.listProducts();
	}
	
	@RequestMapping(value="/categories", method = RequestMethod.GET)
	public List<StockCategory> getAllCategory()
	{
		return stockService.listCategories();
	}
	
	@RequestMapping(value="/mouvments", method = RequestMethod.GET)
	public List<Mouvment> getAllMouvments()
	{
		return stockService.listMouvment();
	}
	
	@RequestMapping(value="/states", method = RequestMethod.GET)
	public List<State> getAllState()
	{
		return stockService.listState();
	}
	
	@RequestMapping(value="/emplacements", method = RequestMethod.GET)
	public List<Emplacement> getAllEmplacement()
	{
		return stockService.listEmplacements();
	}
	
	@RequestMapping(value="/mouvment-types", method = RequestMethod.GET)
	public List<MouvmentType> getAllMouvmentType()
	{
		return stockService.listMouvmentType();
	}
	
	@RequestMapping(value="/mouvment-of-line", method = RequestMethod.GET)
	public Mouvment getMouvmentOfLine(Long id)
	{
		return stockService.getMouvmentOfLine(id);
	}
	
	@RequestMapping(value="/mouvment-of-product", method = RequestMethod.GET)
	public Mouvment getMouvmentOfProduct(Long id)
	{
		return stockService.getMouvmentOfProduct(id);
	}
	
	@RequestMapping(value="/mouvment-lines-of-product", method = RequestMethod.GET)
	public List<MouvmentLine> getMouvmentLineOfProduct(Long id)
	{
		return stockService.getMouvmentLineOfProduct(id);
	}*/
	
	/*@RequestMapping(value="/recipients", method = RequestMethod.GET)
	public List<Recipient> getAllRecipient()
	{
		return stockService.listRecipient();
	}
	
	@RequestMapping(value="/recipients-of-groupe/{id}", method = RequestMethod.GET)
	public Set<Recipient> getAllRecipientOfGroupe(@PathVariable Long id)
	{
		return stockService.listRecipientOfGroupe(id);
	}
	
	@RequestMapping(value="/recipients-group", method = RequestMethod.GET)
	public List<RecipientGroupe> getAllRecipientGroup()
	{
		return stockService.listRecipientGroupe();
	}
	
	@RequestMapping(value="/entrepots", method = RequestMethod.GET)
	public List<Entrepot> getAllEntrepot()
	{
		return stockService.listEntrepots();
	}
	
	@RequestMapping(value="/mouvments-of-entrepot/{id}", method = RequestMethod.GET)
	public Set<Mouvment> getAllMouvmentOfEntrepot(@PathVariable Long id)
	{
		return stockService.getAllMouvmentOfEntrepot(id);
	}
	
	@RequestMapping(value="/mouvments-type", method = RequestMethod.GET)
	public List<MouvmentType> getAllMouvmentType()
	{
		return stockService.listMouvmentType();
	}
	
	@RequestMapping(value="/mouvments-of-mouvments-type/{id}", method = RequestMethod.GET)
	public Set<Mouvment> getAllMouvmentOfMouvmentType(@PathVariable Long id)
	{
		return stockService.getAllMouvmentOfMouvmentType(id);
	}
	
	@RequestMapping(value="/mouvments", method = RequestMethod.GET)
	public List<Mouvment> getAllMouvment()
	{
		return stockService.listMouvment();
	}
	
	@RequestMapping(value="/mouvment-of-employee/{id}", method = RequestMethod.GET)
	public Set<Mouvment> getAllMouvmentOfEmployee(@PathVariable Long id)
	{
		return employeeService.listMouvmentOfEmployee(id);
	}*/
	
	@RequestMapping(value="/recipients-of-groupe/{id}", method = RequestMethod.GET)
	public Set<Recipient> getAllRecipientOfGroupe(@PathVariable Long id)
	{
		return recipientService.listRecipientOfGroupe(id);
	}
	
	@RequestMapping(value="/stocks-of-entrepot/{id}", method = RequestMethod.GET)
	public List<Stock> getAllStockOfEntrepot(@PathVariable Long id)
	{
		return entrepotService.getAllStockOfEntrepot(id);
	}
}
