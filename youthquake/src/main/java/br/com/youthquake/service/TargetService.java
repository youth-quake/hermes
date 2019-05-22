package br.com.youthquake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.youthquake.dto.TargetDTO;
import br.com.youthquake.model.Target;
import br.com.youthquake.repository.TargetRepository;

public class TargetService {

	@Autowired
	private TargetRepository targetRepository;
	
	public void deleteTarget(TargetDTO dto) {
		 targetRepository.deleteById(dto.getIdTarget());
	}
}
