package com.jet_sys.graphql.graphtest;

import com.jet_sys.graphql.graphtest.model.Actor;
import com.jet_sys.graphql.graphtest.repository.ActorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.fail;

@SpringBootTest
class GraphtestApplicationTests {

	ActorRepository actorRepository;
	@Autowired
	private void setActorRepository(ActorRepository actorRepository) {this.actorRepository = actorRepository; }


	@Test
	void contextLoads() {
	}

	@Test
	void testRetrieve() {
		Optional<Actor> optionalActor = actorRepository.findById(1);
		if (optionalActor.isPresent()) {
			assertEquals("First Name Mismpatch", "Penelope", optionalActor.get().getFirstName());
		} else {
			fail("Actor not found");
		}
	}

}
