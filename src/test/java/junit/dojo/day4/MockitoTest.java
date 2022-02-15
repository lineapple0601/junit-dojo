package junit.dojo.day4;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MockitoTest {

	@SuppressWarnings("unchecked")
	@Test
	void testMockitoVerify() {
		// mock creation
		List<String> mockedList = mock(List.class);

		// using mock object - it does not throw any "unexpected interaction" exception
		mockedList.add("one");
		mockedList.clear();

		// selective, explicit, highly readable verification
		verify(mockedList).add("one");
		verify(mockedList).clear();
	}
	
	@Test
	void testMockitoVerify2() {
		List<Integer> mockedList = mock(List.class);
		for (int i = 0; i < 20; i++) {
			if (i % 4 == 0) {
				mockedList.add(Integer.valueOf(i));
			}
		}
		
		verify(mockedList).add(Integer.valueOf(0));
		verify(mockedList).add(Integer.valueOf(4));
		verify(mockedList).add(Integer.valueOf(8));
		verify(mockedList).add(Integer.valueOf(12));
		verify(mockedList).add(Integer.valueOf(16));
		
		verify(mockedList, times(5)).add(anyInt()); // 5回呼ばれたことを確認
		
		System.out.println(mockedList.size());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void testSpyVSMock() {
//		List<String> spy = spy(List.class); // List.classではadd()で引数が追加されない
		List<String> spy = spy(new ArrayList<>());
		List<String> mock = mock(List.class);
		
		mock.add("a");
		mock.add("b");
		mock.add("c");
		
		spy.add("a");
		spy.add("b");
		spy.add("c");
		
		System.out.println("Mock size = " + mock.size());
		System.out.println("Spy size = " + spy.size());
		
		System.out.println("spy.get(0) = " + spy.get(0));
		System.out.println("spy.get(1) = " + spy.get(1));
		System.out.println("spy.get(2) = " + spy.get(2));
		
	}
	
	@Test
	void testMockitothenReturn() {
		// you can mock concrete classes, not only interfaces
		LinkedList mockedList = mock(LinkedList.class);

		// stubbing appears before the actual execution
		when(mockedList.get(0)).thenReturn("first");

		// the following prints "first"
		System.out.println(mockedList.get(0));

		// the following prints "null" because get(999) was not stubbed
		System.out.println(mockedList.get(999));
		
		// will be return String 'anyInteger'
		when(mockedList.get(anyInt())).thenReturn("anyInteger");
		System.out.println(mockedList.get(999));
	}
	

}
