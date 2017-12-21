package lab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Files;

import repository.FilesRepository;

@Service
public class FilesService {

	@Autowired
	private FilesRepository filesRepository;
	
	public Files save(Files file)
	{
		return filesRepository.save(file);
	}
public List<Files> findAll() {
		
		return filesRepository.findAll();
	}
public List<Files> find(String username) {
	return filesRepository.find(username);		
}

}
