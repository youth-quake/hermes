package br.com.youthquake.service;
import java.util.Base64;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.youthquake.dto.UserDTO;
import br.com.youthquake.model.User;
import br.com.youthquake.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	public List<User> getUserInfo(long idUser){
		return userRepository.GetInformationUserById(idUser);
	}
	
	public User AuthenticUser(UserDTO dto) {
		User user = new User();
		user = userRepository.findLoginUserExist(dto.getLogin());	
		if(user != null) {
			if(descriptPassword(user.getPassword()).equals(dto.getPassword())) {
				return user;
			}else {
				return null;
			}
		}
		return null;
	}

	public User userInclude(UserDTO dto) {
		User user = new User();
		List<User> valid = null;
		user.setName(dto.getName());
		user.setLogin(dto.getLogin());
		user.setPassword(encriptPassword(dto.getPassword()));
		user.setEmail(dto.getEmail());
		// começar com level 0 ao cadastrar
		user.setLevel(0);

		valid = userRepository.existEmailAndLoginUser(dto.getEmail(), dto.getLogin());

		if(!(valid.isEmpty())){
			return null; 
		}
		
		return userRepository.save(user);
	}
	
	public User verifyUser(String login, String password){
		User user = userRepository.findLoginUserExist(login);
		if(user != null) {
			if(descriptPassword(user.getPassword()).equals(password)) {
				return user;
			}else {
				return null;
			}
		}
		return null;
	}
	
	public void deleteUserById(long idUser){
		userRepository.deleteById(idUser);
	}
	
	public User userUpdate(UserDTO dto) {
		User user = userRepository.getOne(dto.getId());
		if(user != null)
			user.userUpdateInformations(dto);
		
		return userRepository.save(user);
	}

	public User updateInfoUser(long idUser, UserDTO dto) {
		User user = userRepository.getOne(idUser);
		user.updateUserInfos(dto);
		return userRepository.save(user);
	}

	public User pictureInclude(UserDTO dto, long idUser) {
		User user = userRepository.getOne(idUser);
		user.setPicture(dto.getPicture());
		return userRepository.save(user);
	}

	public User updatePicture(long idUser, UserDTO dto) {
		User user = userRepository.getOne(idUser);
		user.updatePictureUser(dto);
		return userRepository.save(user);
	}
	
	public static String encriptPassword(String password) {
		try {
			IvParameterSpec iv = new IvParameterSpec("RandomInitVector".getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec("Bar12345Bar12345".getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
			byte[] encrypted = cipher.doFinal(password.getBytes());
			return Base64.getEncoder().encodeToString(encrypted);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static String descriptPassword(String password) {
		try {
			IvParameterSpec iv = new IvParameterSpec("RandomInitVector".getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec("Bar12345Bar12345".getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] descrypt = cipher.doFinal(Base64.getDecoder().decode(password));
			return new String(descrypt);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}