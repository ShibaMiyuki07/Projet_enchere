package com.example.enchere.ControllerClient;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.enchere.ModelClient.Commission;

@RestController
@CrossOrigin
@RequestMapping("/Commission")
public class CommissionController {
	
	@GetMapping
	public int commission()
	{
		return new Commission().getCommission();
	}
	
	@PostMapping
	public void insert(@RequestBody Commission comm)
	{
		Commission.setCommission(comm.getCommission());
	}
}
