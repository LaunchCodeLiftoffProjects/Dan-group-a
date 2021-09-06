package org.launchcode.project.data;

import org.launchcode.project.models.Tag;
import org.launchcode.project.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
