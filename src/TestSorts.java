import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

public class TestSorts {

	@Before
	public void setUp(){
		createSorter();
	}
	private SortI mySorter;

	public void createSorter(){
		 mySorter=new MergeSort(); //create sorter here
	}

	@Test
	public void testSmallSimple() {
		int[] testIn={3,2}, testExpect={2,3};
		mySorter.sort(testIn);
		assertArrayEquals(testExpect, testIn);
	}
	
	@Test
	public void testLargerSimple() {
		int[] testIn={6,3,1,2,4,5}, testExpect={1,2,3,4,5,6};
		mySorter.sort(testIn);
		assertArrayEquals(testExpect, testIn);
	}
	

	@Test
	public void testAlreadySortedNoDupes() {
		int[] testIn={-1,2,4,8},testExpect={-1,2,4,8};
		mySorter.sort(testIn);
		assertArrayEquals(testExpect, testIn);
	}

	@Test
	public void testAlreadySortedDupes() {
		int[] testIn={-1,2,2,4,8},testExpect={-1,2,2,4,8};
		mySorter.sort(testIn);
		assertArrayEquals(testExpect, testIn);
	}
	
	@Test
	public void testAllDupes() {
		int[] testIn={-1,-1,-1,-1,-1},testExpect={-1,-1,-1,-1,-1};
		mySorter.sort(testIn);
		assertArrayEquals(testExpect, testIn);
	}

	@Test
	public void testHard() {
		int[] testIn={2,8,10,6,1,2,9}, testExpect={1,2,2,6,8,9,10};
		mySorter.sort(testIn);
		assertArrayEquals(testExpect, testIn);
	}
	
	@Test
	public void testHarder() {
		int[] testIn={2,2,10,6,1,2,9}, testExpect={1,2,2,2,6,9,10};
		mySorter.sort(testIn);
		System.out.println(Arrays.toString(testIn));
		assertArrayEquals(testExpect, testIn);
	}
	
	@Test
	public void testEmpty() {
		int[] testIn={}, testExpect={};
		mySorter.sort(testIn);
		assertArrayEquals(testExpect, testIn);
	}
	
	@Test
	public void testRandom() {
		Random r=new Random();
		for (int i = 0; i < 100; i++) {
			int[] testIn={r.nextInt(10),r.nextInt(10),r.nextInt(10),r.nextInt(10),r.nextInt(10)};
			int[] testExpect=Arrays.copyOf( testIn,testIn.length);
			Arrays.sort(testExpect); 
			
			mySorter.sort(testIn);
			assertArrayEquals(testExpect, testIn);
		}
		
	}
	
}
