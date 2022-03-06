package io.web.medpaharm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.web.medpaharm.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findByUserCode(String userCode);

}
