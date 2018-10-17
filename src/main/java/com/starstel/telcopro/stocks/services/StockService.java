package com.starstel.telcopro.stocks.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.starstel.telcopro.stocks.entities.StockCategory;
import com.starstel.telcopro.stocks.entities.Emplacement;
import com.starstel.telcopro.stocks.entities.Entrepot;
import com.starstel.telcopro.stocks.entities.MeasureUnit;
import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.MouvmentLine;
import com.starstel.telcopro.stocks.entities.MouvmentType;
import com.starstel.telcopro.stocks.entities.Product;
import com.starstel.telcopro.stocks.entities.Recipient;
import com.starstel.telcopro.stocks.entities.RecipientGroupe;
import com.starstel.telcopro.stocks.entities.State;
import com.starstel.telcopro.stocks.entities.Stock;

@Service
public interface StockService 
{	
	public List<Stock> listStock();
	public Stock saveStock(Stock stock);
	public Boolean deleteStock(Long id);
	
	/*public List<Product> listProducts();
	public Product createProduct(Product product);
	public Product editProduct(Product product);
	public Boolean deleteProduct(Long id);
	
	public List<StockCategory> listCategories();
	public StockCategory createCategory(StockCategory category);
	public StockCategory editCategory(StockCategory category);
	public Boolean deleteCategory(Long id);
	
	public List<State> listState();
	public State createState(State state);
	public State editState(State state);
	public Boolean deleteState(Long id);
	
	public List<Emplacement> listEmplacements();
	public Emplacement createEmplacement(Emplacement emplacement);
	public Emplacement editEmplacement(Emplacement emplacement);
	public Boolean deleteEmplacement(Long id);
	
	public List<MeasureUnit> listMeasureUnit();
	public MeasureUnit createMeasureUnit(MeasureUnit measureUnit);
	public MeasureUnit editMeasureUnit(MeasureUnit measureUnit);
	public Boolean deleteMeasureUnit(Long id);
	
	public List<MouvmentLine> listMouvmentLine();
	public MouvmentLine createMouvmentLine(MouvmentLine mouvmentLine);
	public MouvmentLine editMouvmentLine(MouvmentLine mouvmentLine);
	public Boolean deleteMouvmentLine(Long id);
	
	public Set<Product> getProductsOfEmplacement(Long id);
	public Set<Product> getProductsOfEntrepot(Long id);
	public Set<Product> getProductsOfCategory(Long id);
	
	public Set<MouvmentLine> getMouvmentLinesOfProduct(Long id);
	public Set<MouvmentLine> getMouvmentLinesOfMouvment(Long id);
	
	public Set<Mouvment> getMouvmentsOfEntrepot(Long id);
	public Set<Mouvment> getMouvmentsOfEmployee(Long id);
	public Set<Mouvment> getMouvmentsOfMouvmentType(Long id);
	public Set<Mouvment> getMouvmentsOfRecipient(Long id);
	
	public Set<Recipient> getRecipientsOfRecipientGroupe(Long id);*/

}
