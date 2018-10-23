package com.starstel.telcopro.stocks.restcontrollers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starstel.telcopro.stocks.entities.Emplacement;
import com.starstel.telcopro.stocks.entities.Entrepot;
import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.Product;
import com.starstel.telcopro.stocks.services.EntrepotService;

@CrossOrigin("*")
@RestController
@RequestMapping("stocks/entrepots")
public class EntrepotRestController {

	@Autowired
	private EntrepotService entrepotService;

	@RequestMapping(value="",method=RequestMethod.GET)
	public List<Entrepot> listEntrepot() {
		return entrepotService.listEntrepot();
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Entrepot getEntrepot(@PathVariable Long id) {
		return entrepotService.getEntrepot(id);
	}

	@RequestMapping(value="",method=RequestMethod.POST)
	public Entrepot saveEntrepot(@RequestBody Entrepot entrepot) {
		return entrepotService.saveEntrepot(entrepot);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public Boolean deleteEntrepot(@PathVariable Long id) {
		return entrepotService.deleteEntrepot(id);
	}

	@RequestMapping(value="/emplacements",method=RequestMethod.GET)
	public List<Emplacement> listEmplacement() {
		return entrepotService.listEmplacement();
	}

	@RequestMapping(value="/emplacement/{id}",method=RequestMethod.GET)
	public Emplacement getEmplacement(@PathVariable Long id) {
		return entrepotService.getEmplacement(id);
	}

	@RequestMapping(value="/emplacements",method=RequestMethod.POST)
	public Emplacement saveEmplacement(@RequestBody Emplacement emplacement) {
		return entrepotService.saveEmplacement(emplacement);
	}

	@RequestMapping(value="/emplacements/{id}",method=RequestMethod.DELETE)
	public Boolean deleteEmplacement(@PathVariable Long id) {
		return entrepotService.deleteEmplacement(id);
	}

	@RequestMapping(value="/mouvments-of-entrepot/{id}",method=RequestMethod.GET)
	public Set<Mouvment> getAllMouvmentOfEntrepot(@PathVariable Long id) {
		return entrepotService.getAllMouvmentOfEntrepot(id);
	}

	@RequestMapping(value="/products-of-entrepot/{id}",method=RequestMethod.GET)
	public List<Product> getAllStockOfEntrepot(@PathVariable Long id) {
		return entrepotService.getAllStockOfEntrepot(id);
	}

	@RequestMapping(value="/count-product-of-entrepot/{id}",method=RequestMethod.GET)
	public Long getStockCountOfEntrepot(@PathVariable Long id) {
		return entrepotService.getStockCountOfEntrepot(id);
	}

	@RequestMapping(value="/count-portable-items-of-entrepot/{id}",method=RequestMethod.GET)
	public Long getPortableItemCountOfEntrepot(@PathVariable Long id) {
		return entrepotService.getPortableItemCountOfEntrepot(id);
	}

	@RequestMapping(value="/emplacements-of-entrepot/{id}",method=RequestMethod.GET)
	public Set<Emplacement> getAllEmplacementOfEntrepot(@PathVariable Long id) {
		return entrepotService.getAllEmplacementOfEntrepot(id);
	}

	@RequestMapping(value="/emplacements/products-of-emplacement/{id}",method=RequestMethod.GET)
	public Set<Product> getAllStockOfEmplacement(@PathVariable Long id) {
		return entrepotService.getAllStockOfEmplacement(id);
	}

	@RequestMapping(value="/emplacements/count-product-of-emplacement/{id}",method=RequestMethod.GET)
	public Long getStockCountOfEmplacement(@PathVariable Long id) {
		return entrepotService.getStockCountOfEmplacement(id);
	}

	@RequestMapping(value="/emplacements/count-portable-items-of-emplacement/{id}",method=RequestMethod.GET)
	public Long getProductItemCountOfEmplacement(@PathVariable Long id) {
		return entrepotService.getProductItemCountOfEmplacement(id);
	}

	@RequestMapping(value="/is-spaced",method=RequestMethod.POST)
	public Boolean isSpaced(@RequestBody Entrepot entrepot) {
		return entrepotService.isSpaced(entrepot);
	}

	@RequestMapping(value="/add-product-possible/{id}",method=RequestMethod.POST)
	public Boolean isAddPossible(@PathVariable Long id, @RequestBody Product product) {
		Entrepot entrepot=entrepotService.getEntrepot(id);
		return entrepotService.isAddPossible(entrepot, product);
	}

	@RequestMapping(value="/add-many-products-possible/{id}",method=RequestMethod.POST)
	public Boolean isAddPossible(@PathVariable Long id, @RequestBody Set<Product> product) {
		Entrepot entrepot=entrepotService.getEntrepot(id);
		return entrepotService.isAddPossible(entrepot, product);
	}
}
