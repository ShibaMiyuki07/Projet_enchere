package com.example.enchere.ControllerAdmin;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CategorieAdmin")
public class CategorieAdminController {
	
	@GetMapping
	public ArrayList<CategorieAdminController> selectAll() throws Exception
	{
		ArrayList<CategorieAdminController> liste = null;
		return liste;
	}
}
