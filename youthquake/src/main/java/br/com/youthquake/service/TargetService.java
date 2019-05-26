package br.com.youthquake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.repository.TargetRepository;

@Service
public class TargetService {

	@Autowired
	private TargetRepository targetRepository;
	
	public void deleteTarget(long idTarget) {
		 targetRepository.deleteById(idTarget);
	}
}
