package com.example.enchere.ControllerClient;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.enchere.ModelClient.Stat_Utilisateur_Produit;

@RestController
@RequestMapping("/Stat_Utilisateur")
@CrossOrigin

public class Stat_Utilisateur_ProduitController {

	@GetMapping
	public ArrayList<Stat_Utilisateur_Produit> selectAll()
	{
		return new Stat_Utilisateur_Produit().listeAll();
	}
}
