package junt.dojo.day6;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoSettings;

import junit.dojo.day6.HogeProcessor;
import junit.dojo.day6.ISingleton;

@MockitoSettings
class HogeProcessorTestPattern2 {
	
	HogeProcessor it = new HogeProcessor(new MockSingleton());
	
	@Test
	void testProcess() {
		assertThat(it.process("hogehoge"), is("csv_mod"));
	}
	
	class MockSingleton implements ISingleton {
		@Override
		public String getValue(String key) {
			return "csv";
		}
	}
	
}
