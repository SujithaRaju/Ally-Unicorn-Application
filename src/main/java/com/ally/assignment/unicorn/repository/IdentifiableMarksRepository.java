package com.ally.assignment.unicorn.repository;

import com.ally.assignment.unicorn.model.IdentifiableMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface IdentifiableMarksRepository extends JpaRepository<IdentifiableMarks, Long> {

    @Query("FROM IdentifiableMarks idm where idm.unicorn.unicornId = :unicornId")
    Set<IdentifiableMarks> findAllIdentifiableMarksByUnicorn(@Param("unicornId") Long unicornId);
}
