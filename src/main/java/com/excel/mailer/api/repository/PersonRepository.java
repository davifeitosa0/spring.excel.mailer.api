package com.excel.mailer.api.repository;

import com.excel.mailer.api.entity.PersonEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, UUID>,
      JpaSpecificationExecutor<PersonEntity> {

}
