package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.Files;


@Repository
public interface FilesRepository  extends JpaRepository<Files, Integer> {
	
	@Query("select F from Files F where username=:username")
	public List<Files> find(@Param("username")String username);

}
