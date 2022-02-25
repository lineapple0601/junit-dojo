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
class HogeProcessorTestPattern1 {
	
	MockHogeProcessor it = new MockHogeProcessor();
	
	@Mock
	HogeSingleton hogeSingleton;
	
	@Test
	void testProcess() {
		when(hogeSingleton.getValue(anyString())).thenReturn("csv");
		assertThat(it.process("hogehoge"), is("csv_mod"));
	}
	
	
	private class MockHogeProcessor extends HogeProcessor {
		@Override
		protected String createHogeSingletonValue(String fileType) {
        	return hogeSingleton.getValue("hogehoge");
        }
	}
}
