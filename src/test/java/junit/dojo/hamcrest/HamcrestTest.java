package junit.dojo.hamcrest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

class HamcrestTest {

	@Test 
	public void testIs() { 
	    String expected = new String("Ginger"); 
	    String actual = new String("Ginger"); 
	    
	    assertThat(expected, is(actual)); 
	}
	
	@Test 
	public void testEqualTo() { 
	    String expected = new String("Ginger"); 
	    String actual = new String("Ginger"); 
	    
	    assertThat(expected, equalTo(actual)); 
	}
	
	@Test 
	public void testHamcrestNull() { 
	    String actual = null;
	    
	    assertThat(actual, is(nullValue())); 
	    assertThat(actual, is(notNullValue())); 
	}
	
	@Test 
	public void testBothGreaterThanAndLessThan() { 
	    Random rand = new Random();
	    int randNum = rand.nextInt(100);
	    
	    assertThat(randNum, is(both(greaterThan(1)).and(lessThan(2))));
	}


}
