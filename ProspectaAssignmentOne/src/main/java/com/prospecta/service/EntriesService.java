package com.prospecta.service;

import java.util.List;

import com.prospecta.exception.InvalidEntryException;
import com.prospecta.model.Entries;

public interface EntriesService {
	
	public String saveEntry(Entries entries)throws InvalidEntryException; 
	public List<Entries> getAllEntries(); 

}
