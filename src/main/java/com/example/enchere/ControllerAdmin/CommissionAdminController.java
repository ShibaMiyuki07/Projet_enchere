package com.example.enchere.ControllerAdmin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.enchere.ModelAdmin.Commission;

@RestController
@RequestMapping("/CommissionAdmin")
public class CommissionAdminController {
	@PostMapping
	public int insertion(@RequestBody Commission commission)
	{
		return 0;
	}
}
