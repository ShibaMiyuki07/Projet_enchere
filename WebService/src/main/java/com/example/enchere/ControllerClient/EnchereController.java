package com.example.enchere.ControllerClient;

import java.util.ArrayList;
import java.util.List;

import com.example.enchere.ModelClient.Image;
import com.example.enchere.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.enchere.ModelClient.Enchere;

@RestController
@RequestMapping("/Enchere")
public class EnchereController {
	@Autowired
	ImageRepository imageRepository;
	@PostMapping("/sary")
	public void insertImage(@RequestBody Image image){
		imageRepository.save(image);
	}

	@PostMapping("/ListSary")
	public List<Image> ListImage(@RequestBody Enchere enchere){
		System.out.println("id "+enchere.getIdenchere());
		return imageRepository.findAllImageByEnchere(enchere.getIdenchere());
	}
	
	@PostMapping
	public boolean insert(@RequestBody Enchere enchere) throws Exception
	{
		return new Enchere().insertion(enchere);
	}
	
	@GetMapping
	public ArrayList<Enchere> selectValide() throws Exception
	{
		return new Enchere().select_valide();
	}
	@GetMapping("/All")
	public ArrayList<Enchere> selectAll() throws Exception
	{
		return new Enchere().selectall();
	}
	@GetMapping("/historique/{idhistorique}")
	public ArrayList<Enchere> selectByIDDate(@PathVariable("idhistorique") int id) throws Exception
	{
		return new Enchere().selectByIdDate(id);
	}
	
	@GetMapping("/recherche/{valeur}")
	public ArrayList<Enchere> recherche(@PathVariable("valeur") String valeur) throws Exception
	{
		return new Enchere().selectRecherche(valeur);
	}
	
	@GetMapping("/{id}")
	public ArrayList<Enchere> selectById(@PathVariable("id") int id) throws Exception
	{
		return new Enchere().selectById(id);
	}
}
