package com.jet_sys.graphql.graphtest.repository;

import com.jet_sys.graphql.graphtest.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
