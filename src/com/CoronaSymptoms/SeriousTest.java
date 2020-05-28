package com.CoronaSymptoms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SeriousTest {

	@Test
	void testSerious()
	{
		Result r = new Result();
		SeriousSymptomps ss = new SeriousSymptomps(r);
		boolean[] questionAnswered = new boolean[3];
		for(int i=0; i<3; i++)
			questionAnswered[i] = true;		
		boolean resultS = ss.allAnswered(questionAnswered);
		assertEquals(true, resultS);
	}
}
