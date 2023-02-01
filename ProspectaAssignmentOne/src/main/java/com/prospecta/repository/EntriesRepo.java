package com.prospecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prospecta.model.Entries;

@Repository
public interface EntriesRepo extends JpaRepository<Entries, Integer> {

	public Entries findByApi(String api);
}
