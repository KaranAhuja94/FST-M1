import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Activity1 {
	
	static ArrayList<String> list;
	
	@BeforeAll
	public static void setUp() {
		
		list = new ArrayList<String>();
		
		list.add("alpha");
		list.add("beta");
	}
	
	@Test
	public void insertTest() {
		assertEquals(2, list.size());
		list.add("gamma");
		assertEquals(3, list.size());
		assertEquals("alpha", list.get(0));
		assertEquals("beta", list.get(1));
		assertEquals("gamma", list.get(2));
	}
	
	@Test
	public void replaceTest() {
		assertEquals(2, list.size());
		list.add("charlie");
		assertEquals(3, list.size());
		list.set(1, "juliet");
		assertEquals("alpha", list.get(0));
		assertEquals("beta", list.get(1),"Wrong element");
		assertEquals("juliet", list.get(1),"Correct element");
	}
}
