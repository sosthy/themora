package com.starstel.telcopro.stocks.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starstel.telcopro.rh.repositories.EmployeeRepository;
import com.starstel.telcopro.stocks.entities.ProductCategory;
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
import com.starstel.telcopro.stocks.entities.Product;
import com.starstel.telcopro.stocks.repositories.CategoryRepository;
import com.starstel.telcopro.stocks.repositories.EmplacementRepository;
import com.starstel.telcopro.stocks.repositories.EntrepotRepository;
import com.starstel.telcopro.stocks.repositories.MeasureUnitRepository;
import com.starstel.telcopro.stocks.repositories.MouvmentLineRepository;
import com.starstel.telcopro.stocks.repositories.MouvmentRepository;
import com.starstel.telcopro.stocks.repositories.MouvmentTypeRepository;
import com.starstel.telcopro.stocks.repositories.ProductRepository;
import com.starstel.telcopro.stocks.repositories.RecipientGroupeRepository;
import com.starstel.telcopro.stocks.repositories.RecipientRepository;
import com.starstel.telcopro.stocks.repositories.StateRepository;
import com.starstel.telcopro.stocks.repositories.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService 
{
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private EmplacementRepository emplacementRepository;
	@Autowired
	private MeasureUnitRepository measureUnitRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<Product> listProducts() {
		return productRepository.findAll();
	}
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	@Override
	public Boolean deleteProduct(Long id) {
		productRepository.deleteById(id);
		return true;
	}
	@Override
	public List<Mouvment> getAllMouvmentOfProduct(Long id) {
		return productRepository.getAllMouvmentOfProduct(id);
	}
	@Override
	public List<Mouvment> getAllMouvmentOfEmployee(Long id) {
		return productRepository.getAllMouvmentOfEmployee(id);
	}
	@Override
	public Product getProduct(Long id) {
		return productRepository.findById(id).get();
	}
	

	
	
	
	/* @Override
	public List<Product> listProducts() 
	{
		return productRepository.findAll();
	}

	@Override
	public Product createProduct(Product product) 
	{
		return productRepository.save(product);
	}

	@Override
	public Product editProduct(Product product) 
	{
		return null;
	}

	@Override
	public Boolean deleteProduct(Long id) 
	{
		productRepository.deleteById(id);
		return true;
	}

	@Override
	public List<ProductCategory> listCategories() 
	{
		return categoryRepository.findAll();
	}

	@Override
	public ProductCategory createCategory(ProductCategory category) 
	{
		return categoryRepository.save(category);
	}

	@Override
	public ProductCategory editCategory(ProductCategory category)
	{
		return null;
	}

	@Override
	public Boolean deleteCategory(Long id)
	{
		categoryRepository.deleteById(id);
		return true;
	}

	@Override
	public List<State> listState() 
	{
		return stateRepository.findAll();
	}

	@Override
	public State createState(State state) 
	{
		return stateRepository.save(state);
	}

	@Override
	public State editState(State state) 
	{
		return null;
	}

	@Override
	public Boolean deleteState(Long id) 
	{
		stateRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Emplacement> listEmplacements() 
	{
		return emplacementRepository.findAll();
	}

	@Override
	public Emplacement createEmplacement(Emplacement emplacement) 
	{
		return emplacementRepository.save(emplacement);
	}

	@Override
	public Emplacement editEmplacement(Emplacement emplacement) 
	{
		return null;
	}

	@Override
	public Boolean deleteEmplacement(Long id) 
	{
		emplacementRepository.deleteById(id);
		return true;
	}

	@Override
	public List<MeasureUnit> listMeasureUnit()
	{
		return measureUnitRepository.findAll();
	}

	@Override
	public MeasureUnit createMeasureUnit(MeasureUnit measureUnit) 
	{
		return measureUnitRepository.save(measureUnit);
	}

	@Override
	public MeasureUnit editMeasureUnit(MeasureUnit measureUnit) 
	{
		return null;
	}

	@Override
	public Boolean deleteMeasureUnit(Long id) 
	{
		measureUnitRepository.deleteById(id);
		return true;
	}

	@Override
	public List<MouvmentLine> listMouvmentLine()
	{
		return mouvmentLineRepository.findAll();
	}

	@Override
	public MouvmentLine createMouvmentLine(MouvmentLine mouvmentLine)
	{
		return mouvmentLineRepository.save(mouvmentLine);
	}

	@Override
	public MouvmentLine editMouvmentLine(MouvmentLine mouvmentLine) 
	{
		return null;
	}

	@Override
	public Boolean deleteMouvmentLine(Long id) 
	{
		mouvmentLineRepository.deleteById(id);
		return true;
	}

	@Override
	public Set<Product> getProductsOfEmplacement(Long id) 
	{
		return emplacementRepository.getOne(id).getProducts();
	}

	@Override
	public Set<Product> getProductsOfEntrepot(Long id) 
	{
		return entrepotRepository.getOne(id).getProducts();
	}

	@Override
	public Set<Product> getProductsOfCategory(Long id) 
	{
		return categoryRepository.getOne(id).getProducts();
	}

	@Override
	public Set<MouvmentLine> getMouvmentLinesOfProduct(Long id) 
	{
		return productRepository.getOne(id).getMouvmentLines();
	}

	@Override
	public Set<MouvmentLine> getMouvmentLinesOfMouvment(Long id) 
	{
		return mouvmentRepository.getOne(id).getMouvmentLines();
	}

	@Override
	public Set<Mouvment> getMouvmentsOfEntrepot(Long id) 
	{
		return entrepotRepository.getOne(id).getMouvments();
	}

	@Override
	public Set<Mouvment> getMouvmentsOfEmployee(Long id)
	{
		return employeeRepository.getOne(id).getMouvments();
	}

	@Override
	public Set<Mouvment> getMouvmentsOfMouvmentType(Long id) 
	{
		return mouvmentTypeRepository.getOne(id).getMouvments();
	}

	@Override
	public Set<Mouvment> getMouvmentsOfRecipient(Long id) 
	{
		return recipientRepository.getOne(id).getMouvments();
	}

	@Override
	public Set<Recipient> getRecipientsOfRecipientGroupe(Long id)
	{
		return recipientGroupeRepository.getOne(id).getRecipients();
	}*/

}
