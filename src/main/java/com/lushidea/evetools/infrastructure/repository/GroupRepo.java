package com.lushidea.evetools.infrastructure.repository;

import com.lushidea.evetools.infrastructure.entity.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepo extends CrudRepository<Group, Long> {
    List<Group> findByCategoryId(Long id);
}
