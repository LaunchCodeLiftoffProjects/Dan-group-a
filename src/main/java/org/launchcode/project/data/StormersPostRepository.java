package org.launchcode.project.data;

import org.launchcode.project.models.StormersPosts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StormersPostRepository extends CrudRepository<StormersPosts, Integer> {
}
