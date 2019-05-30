package br.com.youthquake.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.youthquake.dto.TargetDTO;
import br.com.youthquake.model.Target;
import br.com.youthquake.model.User;
import br.com.youthquake.repository.TargetRepository;

@Service
public class TargetService {

	@Autowired
	private TargetRepository targetRepository;
	
	@Autowired
	HttpSession session;
	
	private static String SESSION_USER = "SessionUser";
	
	
	public void deleteTarget(long idTarget) {
		 targetRepository.deleteById(idTarget);
	}
	
	public List<Target> getTargetMicroservice(long idTarget){
		return targetRepository.getTargets(idTarget);
	}
	
	public Target updateTarget(long id, TargetDTO dto) {
		Target target = targetRepository.getOne(id);
		target.targetUpdateInformations(dto);
		return targetRepository.save(target);
	}
}
