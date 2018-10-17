package com.starstel.telcopro.stocks.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.starstel.telcopro.stocks.entities.Emplacement;
import com.starstel.telcopro.stocks.entities.Mouvment;
import com.starstel.telcopro.stocks.entities.Portable;
import com.starstel.telcopro.stocks.repositories.PortableRepository;


@Service
public class PortableServiceImpl implements PortableService {

	@Autowired
	private PortableRepository portableRepository;

	@Override
	public Portable save(Portable portable) {
		return portableRepository.save(portable);
	}
	
	@Override
	public Boolean delete(Long id) {
		portableRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Portable> getPortables() {
		return portableRepository.findAll();
	}

	@Override
	public Portable getPortable(Long id) {
		return portableRepository.findById(id).get();
	}

	@Override
	public Emplacement getEmplacement(Long id) {
		return portableRepository.getEmplacement(id);
	}

	@Override
	public Mouvment getAllMouvment(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
