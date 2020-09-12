package dev.paie.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.Grade;
import dev.paie.service.GradeService;

@RestController
@CrossOrigin
@RequestMapping("grade")
public class GradeCtrl {

	private GradeService gradeServ;

	public GradeCtrl(GradeService gradeServ) {
		super();
		this.gradeServ = gradeServ;
	}
	
	
	//lire tout
			@GetMapping
			public List<Grade> readAll(){
				return gradeServ.readAll();
			}
	
	
}
