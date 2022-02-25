package junt.dojo.day6;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoSettings;

import junit.dojo.day6.HogeProcessor;
import junit.dojo.day6.HogeSingleton;

@MockitoSettings
class HogeProcessorTest {
	
	HogeProcessor it = new HogeProcessor();
	
	@Mock
	HogeSingleton hs;
	MockedStatic<HogeSingleton> hsMockStatic = mockStatic(HogeSingleton.class);
	
	@BeforeEach
	void setUp() {
		when(hs.getValue(anyString())).thenReturn("csv");
		hsMockStatic.when(HogeSingleton::instance).thenReturn(hs);
	}
	
	@AfterEach
	void tearDown() {
		hsMockStatic.close();
	}
	
	@Test
	void testProcess() {
		assertThat(it.process("hogehoge"), is("csv_mod"));
	}
	
}
