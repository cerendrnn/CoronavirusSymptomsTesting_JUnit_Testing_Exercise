package com.CoronaSymptoms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResultTest {

	@Test
	void testResult()
	{
		Result r = new Result();
		int result =r.explainResult(1, 2, 0);
		assertEquals(0, result);
	}

}
