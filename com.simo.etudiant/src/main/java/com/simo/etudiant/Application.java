package com.simo.etudiant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import com.simo.etudiant.entite.Etudiant;
import com.simo.etudiant.repository.EtudiantRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
@Autowired 
EtudiantRepository etudiantRepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {
		/* DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		
		
		etudiantRepo.save((new Etudiant("adam", "adam@gmail.com", df.parse("1980-05-29"), "photo1")));
		etudiantRepo.save((new Etudiant("zizo", "zizo@gmail.com", df.parse("1994-06-05"), "photo2")));
		etudiantRepo.save((new Etudiant("mounir", "mounir@hotmail.com", df.parse("1983-06-05"), "photo3")));
		etudiantRepo.save((new Etudiant("hicham", "hicham@yahoo.com", df.parse("1985-02-05"), "photo4")));
		etudiantRepo.save((new Etudiant("simo", "simo@qc.ca", df.parse("1960-09-05"), "photo5")));
		
		etudiantRepo.findAll().forEach(System.out::println);
		//etudiantRepo.chercherEtudiant("%gmail%", new PageRequest(0,5))
		
		//.forEach(System.out::println);
*/	
	}
}
