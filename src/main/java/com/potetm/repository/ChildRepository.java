package com.potetm.repository;

import com.potetm.domain.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tpote
 */
@Repository
public interface ChildRepository extends JpaRepository<Child, String> {
}

