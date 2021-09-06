package org.launchcode.project.data;

import org.launchcode.project.models.Tag;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
