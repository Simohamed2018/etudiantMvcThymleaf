package com.simo.etudiant.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.simo.etudiant.entite.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
@Query("from Etudiant e where e.email like :x")
	Page <Etudiant> chercherEtudiantParEmail (@Param("x")String motCle,Pageable pageable);
	

}
