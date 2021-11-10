package com.ally.assignment.unicorn.repository;

import com.ally.assignment.unicorn.model.Unicorn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnicornRepository extends JpaRepository<Unicorn, Long> {


}
