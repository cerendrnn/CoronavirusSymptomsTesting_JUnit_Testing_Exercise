package com.CoronaSymptoms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AgeTesting {

	@Test
	void testAge() {
		Result r = new Result();
		Welcome w = new Welcome(r);
		boolean ageEntered = w.checkValidAge(231);
		assertEquals(false, ageEntered);
		
	}

}
