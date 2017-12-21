package lab.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entity.Fish;
import entity.User;
import lab.service.FishService;
import lab.service.UserService;

@CrossOrigin
@RestController
public class FishController {
	
	@Autowired
	private FishService fishService;
	
	@RequestMapping(value = "/findFishDetails", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	private ResponseEntity<?> findfishDetails() {
		List <Fish> fishes = fishService.findAll();
		
		fishes.forEach(a->{
			if(a.getFishPic() != null &&a.getFishPic().length>0) {
				a.setShowPicture(Base64.getEncoder().encodeToString(a.getFishPic()));
				
			}
		});
		
		return new ResponseEntity<List<Fish>>(fishes, HttpStatus.OK);
		}

	
}
