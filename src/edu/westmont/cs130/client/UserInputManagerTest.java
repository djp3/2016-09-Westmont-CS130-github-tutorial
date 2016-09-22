package edu.westmont.cs130.client;

import static org.junit.Assert.*;

import java.io.PrintWriter;

import org.junit.Test;

public class UserInputManagerTest {

	@Test
	public void testUserInputManager() {
		try{
			PrintWriter printWriter = new PrintWriter(System.out);
			new UserInputManager(printWriter);
		}
		catch(RuntimeException e){
			fail("Got an unexpected exception");
		}
	}

}
