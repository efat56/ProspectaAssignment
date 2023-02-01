package com.prospecta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prospecta.exception.InvalidEntryException;
import com.prospecta.model.Entries;
import com.prospecta.repository.EntriesRepo;

@Service
public class EntriesServiceImpl implements EntriesService {
	
	@Autowired
	private EntriesRepo EntriesRepo;

	@Override
	public String saveEntry(Entries entries) throws InvalidEntryException {
      Entries en =   EntriesRepo.findByApi(entries.getApi());
		
		if(en!=null) {
			 throw new InvalidEntryException("Invalid Entry") ;
		}else {
			EntriesRepo.save(entries);
			return "success";
		}
	}

	@Override
	public List<Entries> getAllEntries() {
		return EntriesRepo.findAll();
	}
	
	

}
