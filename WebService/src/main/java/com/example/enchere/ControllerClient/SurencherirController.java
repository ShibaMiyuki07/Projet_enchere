package com.example.enchere.ControllerClient;

import org.springframework.web.bind.annotation.*;

import com.example.enchere.ModelClient.Surencherir;

@RestController
@RequestMapping("/Surencherir")
@CrossOrigin
public class SurencherirController {
	@PostMapping
	public boolean surenchere(@RequestBody Surencherir surenchere) throws Exception
	{
		return new Surencherir().insertion(surenchere);
	}
}
