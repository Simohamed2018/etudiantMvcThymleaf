package com.simo.etudiant.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;
import org.apache.commons.io.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.simo.etudiant.entite.Etudiant;
import com.simo.etudiant.service.EtudiantService;

@Controller
@RequestMapping("/web")
public class EtudiantController {
	@Autowired
	EtudiantService etudservice;
	@Value("${dir.photos}")
	private String cheminPhotos;

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/content")
	public String template() {
		return "Content1";
	}

	@GetMapping("/form")
	public String formEtudiant(Model theModel) throws ParseException {
		// DateFormat df = new SimpleDateFormat("yyyy-dd-MM");

		// theModel.addAttribute("etudiant",new Etudiant("hohoh", "hoho@gmail.com",
		// df.parse("03-05-2001"), "photoHoho"));
		theModel.addAttribute("etudiant", new Etudiant());
		// sans uplaod return "FormEtudiant";
		return "FormEtudiantUplaod";
	}

	@PostMapping("/saveEtudiant")
	public String SaveEtudiant(@Valid Etudiant etudiant, BindingResult bindingresult) {
		System.out.println("+***************" + etudiant);
		if (bindingresult.hasErrors())
			return "FormEtudiant";

		etudservice.saveEtudiant(etudiant);
		System.out.println(etudiant);
		return "redirect:chercherParEmail";

	}

	@PostMapping("/saveEtudiantUplaod")
	public String SaveEtudiantAvecImage(@Valid Etudiant etudiant, BindingResult bindingresult,
			@RequestParam("picture") MultipartFile picture) throws IllegalStateException, IOException {

		if (bindingresult.hasErrors()) {
			return "FormEtudiantUplaod";
		}
		etudservice.saveEtudiant(etudiant);

		if (!(picture.isEmpty())) {
			etudiant.setPhoto(picture.getOriginalFilename());}
			etudservice.saveEtudiant(etudiant);
			if (!(picture.isEmpty())) 
				{
				etudiant.setPhoto(picture.getOriginalFilename());
			// on inject le chemin par spring (bon pour modifier le chemin sana arreter l
			// application
			picture.transferTo(new File(cheminPhotos + etudiant.getId()));
			// si on veut mettre le chemin directement dans le code
			// picture.transferTo(new
			// File(System.getProperty("user.home")+"/photos/"+picture.getOriginalFilename()));

		}

		System.out.println("+***************" + etudiant);
		return "redirect:chercherParEmail";
		
	}

	@SuppressWarnings("deprecation")
	@GetMapping("/chercherParEmail")
	public String getEmailEtudaint(@RequestParam(value = "motCle", defaultValue = "") String motCle,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "5") int size, Model theModel) {

		Page<Etudiant> pageEtudiants = etudservice.chercherEtudiantParEmail("%" + motCle + "%",
				new PageRequest(page, size));
		theModel.addAttribute("pageEtudiant", pageEtudiants);
		// nombre de page
		int nbPages = pageEtudiants.getTotalPages();
		theModel.addAttribute("nbPages", nbPages);
		// les pages on declare un tableau de pages
		int pages[] = new int[nbPages];
		// remplir le tableau
		for (int i = 0; i < pages.length; i++) {
			pages[i] = i;
		}
		// on l ajoute au modele
		theModel.addAttribute("pages", pages);

		// ajout de la page courante dans le model
		theModel.addAttribute("pageCourante", page);
		// add mot cle
		theModel.addAttribute("motCle", motCle);
		theModel.addAttribute("cheminPhotos", cheminPhotos);
		return "page";
	}

	@RequestMapping("/supprimer")
	public String supprimer(Long id) {
		etudservice.supprimer(id);
		return "redirect:chercherParEmail";
	}

	@PostMapping("/editerEtudiant")
	public String editerEtudiant(@Valid Etudiant etudiant, BindingResult bindingresult,
			@RequestParam("picture") MultipartFile picture) throws IllegalStateException, IOException {

		if (bindingresult.hasErrors()) {
			return "editEtudiant";
		}
		etudservice.saveEtudiant(etudiant);

		if (!(picture.isEmpty())) {
			etudiant.setPhoto(picture.getOriginalFilename());}
			etudservice.saveEtudiant(etudiant);
			if (!(picture.isEmpty())) 
				{
				etudiant.setPhoto(picture.getOriginalFilename());
			// on inject le chemin par spring (bon pour modifier le chemin sana arreter l
			// application
			picture.transferTo(new File(cheminPhotos + etudiant.getId()));
			// si on veut mettre le chemin directement dans le code
			// picture.transferTo(new
			// File(System.getProperty("user.home")+"/photos/"+picture.getOriginalFilename()));

		}

		System.out.println("+***************" + etudiant);
		return "redirect:chercherParEmail";
	}
	
	@RequestMapping("/editer")
	public String editer(Long id, Model theModel) {
		Etudiant etudiant = etudservice.getEtudiant(id);
		theModel.addAttribute("etudiant", etudiant);
		return "editEtudiant";
	}
	
	
	

	@GetMapping(value = "/getPhoto", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long id) throws FileNotFoundException, IOException {
		
		File file = new File(cheminPhotos + id);		
		// System.getProperty("java.io.tmpdir")+'/'+"PROD_"+theIdProd+"_"+theProduit.getCheminPhoto());
		return IOUtils.toByteArray(new FileInputStream(file));
		
	}

}
