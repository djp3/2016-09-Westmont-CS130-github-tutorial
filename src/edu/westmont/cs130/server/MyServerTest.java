package edu.westmont.cs130.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyServerTest {

	@Test
	public void testMyServerTest() {
		assertEquals(Integer.valueOf(1),MyServer.myServerTest());
	}

}
