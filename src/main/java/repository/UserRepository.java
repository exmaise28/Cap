package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query("select U from User U where username=:username and password=:password")
	public User login(@Param("username")String username, @Param("password")
	String password);


}
