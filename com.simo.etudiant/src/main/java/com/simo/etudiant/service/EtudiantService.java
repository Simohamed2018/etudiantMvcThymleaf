package com.simo.etudiant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.simo.etudiant.entite.Etudiant;
import com.simo.etudiant.repository.EtudiantRepository;

@Service
public class EtudiantService {
	@Autowired
	EtudiantRepository etudiantRepo;
	public List<Etudiant> getEudiants(){
		
		return etudiantRepo.findAll();
		
	}
public Page<Etudiant> chercherEtudiantParEmail(String motCle,Pageable pageable){
		
		return etudiantRepo.chercherEtudiantParEmail(motCle, pageable);
		
	}
public Etudiant saveEtudiant(Etudiant etudiant){
	
	return etudiantRepo.save(etudiant);
	
}
public boolean supprimer(Long id) {
	
	etudiantRepo.deleteById(id);
	return true;
	
}

public Etudiant getEtudiant(Long id) {
	//Etudiant etudiant=etudiantRepo.getOne(id);
	Optional<Etudiant> etudiant=etudiantRepo.findById(id);
	return etudiant.get();	
	
}

}
