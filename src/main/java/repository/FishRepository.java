package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.Fish;
import entity.User;

@Repository
public interface FishRepository extends JpaRepository<Fish, String>  {
	
	
	
}
