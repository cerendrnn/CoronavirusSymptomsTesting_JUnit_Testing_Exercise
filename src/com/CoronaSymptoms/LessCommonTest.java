package com.CoronaSymptoms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LessCommonTest {

	@Test
	void testLessCommon()
	{
		Result r = new Result();
		LessCommon lc = new LessCommon(r);
		boolean[] questionAnswered = new boolean[7];
		for(int i=0; i<7; i++)
			questionAnswered[i] = true;		
		boolean resultLC = lc.allAnswered(questionAnswered);
		assertEquals(true, resultLC);
	}

}
