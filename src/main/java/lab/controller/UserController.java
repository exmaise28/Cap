package lab.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import entity.Files;
import entity.Fish;
import entity.User;
import lab.service.FilesService;
import lab.service.UserService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FilesService filesService;

	@RequestMapping(value = "/submitUserDetails", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	private void submitUserDetails(@RequestBody User user) {
		this.userService.save(user);
	}

	@RequestMapping(value = "/findUserDetails", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	private ResponseEntity<List<User>> findUserDetails(String username) {
		System.out.println("Username "+username);
		List<User> users = this.userService.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findFilesDetails", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	private ResponseEntity<?> findFilesDetails() {
		List <Files> fileses = filesService.findAll();
		
		fileses.forEach(a->{
			if(a.getPic() != null &&a.getPic().length>0) {
				a.setShowTrophy(Base64.getEncoder().encodeToString(a.getPic()));
				
			}
		});
		
		return new ResponseEntity<List<Files>>(fileses, HttpStatus.OK);
		}


	@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	private ResponseEntity<User> login(@RequestBody User u) {
		User user = userService.login(u.getUsername(), u.getPassword());
		System.out.println(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	private ResponseEntity<?> find(@RequestBody Files f) {
		
		System.out.println("in find...");
		List <Files> fileses = filesService.find(f.getUsername());
		
		fileses.forEach(a->{
			if(a.getPic() != null &&a.getPic().length>0) {
				a.setShowTrophy(Base64.getEncoder().encodeToString(a.getPic()));
				
			}
		});
		
		for (Files files : fileses) {
			System.out.println("File name: "+files.getUsername());
		}
		
		
		return new ResponseEntity<List<Files>>(fileses, HttpStatus.OK);
		}

	
	@RequestMapping(value="/upload/{username}", produces = MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	private ResponseEntity<?> upload(@RequestBody MultipartFile image,HttpSession session,Model model, @PathVariable("username") String username) {
		System.out.println("HERE!!");

		Files myFile = new Files();
		System.out.println(username);
		
	 
				try {
					myFile.setPic(image.getBytes());
					myFile.setUsername(username);
					myFile.setPath("C:\\Users\\ellisx\\Desktop\\images\\"+image.getOriginalFilename());
					System.out.println("File Path "+myFile.getPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
				filesService.save(myFile);
		
		 
				
	   return new ResponseEntity<HttpStatus>( HttpStatus.OK);
	}
	
	
}