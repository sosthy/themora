package com.starstel.telcopro.stocks.restcontrollers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starstel.telcopro.stocks.entities.ProductCategory;
import com.starstel.telcopro.stocks.entities.SystemOS;
import com.starstel.telcopro.rh.services.EmployeeService;
import com.starstel.telcopro.stocks.entities.AppColor;
import com.starstel.telcopro.stocks.entities.Camera;
import com.starstel.telcopro.stocks.entities.Emplacement;
import com.starstel.telcopro.stocks.entities.Entrepot;
import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.MouvmentLine;
import com.starstel.telcopro.stocks.entities.MouvmentType;
import com.starstel.telcopro.stocks.entities.Portable;
import com.starstel.telcopro.stocks.entities.PortableCategory;
import com.starstel.telcopro.stocks.entities.PortableUnit;
import com.starstel.telcopro.stocks.entities.Product;
import com.starstel.telcopro.stocks.entities.Recipient;
import com.starstel.telcopro.stocks.entities.RecipientGroupe;
import com.starstel.telcopro.stocks.entities.State;
import com.starstel.telcopro.stocks.entities.Product;
import com.starstel.telcopro.stocks.services.AppColorService;
import com.starstel.telcopro.stocks.services.EntrepotService;
import com.starstel.telcopro.stocks.services.PortableService;
import com.starstel.telcopro.stocks.services.ProductService;
import com.starstel.telcopro.stocks.services.RecipientService;

@CrossOrigin("*")
@RestController
@RequestMapping("/stocks")
public class StockRestController 
{
	@Autowired
	private ProductService productService;
	@Autowired
	private AppColorService appColorService;

	@RequestMapping(value="",method=RequestMethod.GET)
	public List<Product> listProducts() {
		return productService.listProducts();
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Product getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
	}


	@RequestMapping(value="",method=RequestMethod.POST)
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public Boolean deleteProduct(@PathVariable Long id) {
		return productService.deleteProduct(id);
	}

	@RequestMapping(value="/mouvments-of-product/{id}",method=RequestMethod.GET)
	public List<Mouvment> getAllMouvmentOfProduct(@PathVariable Long id) {
		return productService.getAllMouvmentOfProduct(id);
	}

	@RequestMapping(value="/mouvment-of-employee/{id}",method=RequestMethod.GET)
	public List<Mouvment> getAllMouvmentOfEmployee(@PathVariable Long id) {
		return productService.getAllMouvmentOfEmployee(id);
	}

	@RequestMapping(value="/colors",method=RequestMethod.POST)
	public AppColor saveAppColor(@RequestBody AppColor appColor) {
		return appColorService.saveAppColor(appColor);
	}

	@RequestMapping(value="/colors/{id}",method=RequestMethod.DELETE)
	public Boolean deleteAppColor(@PathVariable Long id) {
		return appColorService.deleteAppColor(id);
	}

	@RequestMapping(value="/app-colors",method=RequestMethod.GET)
	public List<AppColor> getAppColors() {
		return appColorService.getAppColors();
	}

	@RequestMapping(value="/app-colors/{id}",method=RequestMethod.GET)
	public AppColor getAppColor(@PathVariable Long id) {
		return appColorService.getAppColor(id);
	}

	@RequestMapping(value="/colors",method=RequestMethod.GET)
	public List<String> getColors() {
		return appColorService.getColors();
	}

	@RequestMapping(value="/poducts-color/{color}",method=RequestMethod.GET)
	public List<Product> getProductByColor(@PathVariable String color) {
		return appColorService.getProductByColor(color);
	}
}
