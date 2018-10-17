package com.starstel.telcopro.stocks.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starstel.telcopro.stocks.entities.Recipient;
import com.starstel.telcopro.stocks.entities.RecipientGroupe;
import com.starstel.telcopro.stocks.repositories.RecipientGroupeRepository;
import com.starstel.telcopro.stocks.repositories.RecipientRepository;

@Service
public class RecipientServiceImpl implements RecipientService
{
	@Autowired
	private RecipientRepository recipientRepository;
	@Autowired
	private RecipientGroupeRepository recipientGroupeRepository;
	
	@Override
	public List<RecipientGroupe> listRecipientGroupe() 
	{
		return recipientGroupeRepository.findAll();
	}

	@Override
	public RecipientGroupe createRecipientGroupe(RecipientGroupe recipientGroupe)
	{
		return recipientGroupeRepository.save(recipientGroupe);
	}

	@Override
	public RecipientGroupe editRecipientGroupe(RecipientGroupe recipientGroupe) 
	{
		return null;
	}

	@Override
	public Boolean deleteRecipientGroupe(Long id) 
	{
		recipientGroupeRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Recipient> listRecipient() 
	{
		return recipientRepository.findAll();
	}

	@Override
	public Set<Recipient> listRecipientOfGroupe(Long id) 
	{
		RecipientGroupe groupe = recipientGroupeRepository.findById(id).get();
		if(groupe != null)
			return groupe.getRecipients();
		else
			return null;
	}

	@Override
	public Recipient createRecipient(Recipient recipient) 
	{
		return recipientRepository.save(recipient);
	}

	@Override
	public Recipient editRecipient(Recipient recipient) 
	{
		return null;
	}

	@Override
	public Boolean deleteRecipient(Long id) 
	{
		recipientRepository.deleteById(id);
		return true;
	}
	
}
