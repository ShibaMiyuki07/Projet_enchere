package com.example.enchere.ControllerAdmin;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.enchere.ModelAdmin.Rechargement;

@RestController
@RequestMapping("/RechargementAdmin")
public class RechargementAdminController {
	
	public ArrayList<Rechargement> selectall()
	{
		ArrayList<Rechargement> liste  = null;
		return liste;
	}
}
