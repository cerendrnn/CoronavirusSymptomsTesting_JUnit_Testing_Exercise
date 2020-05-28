package com.CoronaSymptoms;
//import static com.CoronaSymptoms.Welcome.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitTesting {

	@Test
	void test() {
		Result r = new Result();
		Welcome w = new Welcome(r);
		boolean nameEntered = w.checkValidName("hackerBoy67");
		assertEquals(false, nameEntered);
	}
	
	
}
