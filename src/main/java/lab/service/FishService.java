package lab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Fish;
import entity.User;
import repository.FishRepository;
import repository.UserRepository;

@Service
public class FishService {
	@Autowired
	private FishRepository fishRepository;

	public void save(Fish fish) {
		
		fishRepository.save(fish);
	}

	public List<Fish> findAll() {
		
		return fishRepository.findAll();
	}

}
