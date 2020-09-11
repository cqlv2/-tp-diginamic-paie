package dev.paie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;

@Service
public class GradeService {

	private GradeRepository gradeRepo;

	public GradeService(GradeRepository gradeRepo) {
		super();
		this.gradeRepo = gradeRepo;
	}
	
	//lecture
	
	public List<Grade> readAll(){
		return gradeRepo.findAll();
	}
	
	
}
