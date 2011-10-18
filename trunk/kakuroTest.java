import junit.framework.TestCase;
import junit.framework.TestSuite;


public class kakuroTest extends TestCase {
	
public kakuroTest(){
	super();
}
	
public 	kakuroTest(String string){
		super(string); 
	}

public void TestConsistencyCheck(){
	assertTrue (new kakuro().consistencyCheck());
	}

public void TestGetBreak(){
	assertTrue (new kakuro().getBreak(2)==17);
	assertTrue (new kakuro().getBreak(3)==24);
	assertTrue (new kakuro().getBreak(4)==30);
	assertTrue (new kakuro().getBreak(6)==39);
	assertTrue (new kakuro().getBreak(7)==42);
	assertTrue (new kakuro().getBreak(9)==45);
	}

public void TestGenerateList(){
	int [] value = new kakuro().generateList(2,1);
	assertTrue (java.util.Arrays.equals(value,new int[]{2}));
}


public void TestSplitList(){
	int [][] value = new kakuro().splitList(3);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{1,2}));
	value = new kakuro().splitList(4);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{1,3}));
	value = new kakuro().splitList(5);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{1,4}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{2,3}));
	value = new kakuro().splitList(6);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{1,5}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{2,4}));
	value = new kakuro().splitList(7);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{1,6}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{2,5}));
	assertTrue (java.util.Arrays.equals(value[2], new int[]{3,4}));
	value = new kakuro().splitList(8);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{1,7}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{2,6}));
	assertTrue (java.util.Arrays.equals(value[2], new int[]{3,5}));
	value = new kakuro().splitList(9);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{1,8}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{2,7}));
	assertTrue (java.util.Arrays.equals(value[2], new int[]{3,6}));
	assertTrue (java.util.Arrays.equals(value[3], new int[]{4,5}));
	value = new kakuro().splitList(10);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{1,9}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{2,8}));
	assertTrue (java.util.Arrays.equals(value[2], new int[]{3,7}));
	assertTrue (java.util.Arrays.equals(value[3], new int[]{4,6}));
	value = new kakuro().splitList(11);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{2,9}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{3,8}));
	assertTrue (java.util.Arrays.equals(value[2], new int[]{4,7}));
	assertTrue (java.util.Arrays.equals(value[3], new int[]{5,6}));
	value = new kakuro().splitList(12);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{3,9}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{4,8}));
	assertTrue (java.util.Arrays.equals(value[2], new int[]{5,7}));
	value = new kakuro().splitList(13);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{4,9}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{5,8}));
	assertTrue (java.util.Arrays.equals(value[2], new int[]{6,7}));
	value = new kakuro().splitList(14);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{5,9}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{6,8}));
	value = new kakuro().splitList(15);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{6,9}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{7,8}));
	value = new kakuro().splitList(16);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{7,9}));
	value = new kakuro().splitList(17);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{8,9}));
}

public void TestSplitList2(){

	int[][]value = new kakuro().splitList(7,1);
	assertTrue (value.length == 2) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{2,5}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{3,4}));

	value = new kakuro().splitList(7,2);
	assertTrue (value.length == 1) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{3,4}));

	value = new kakuro().splitList(7,3);
	assertTrue (value == null) ;

	value = new kakuro().splitList(8,1);
	assertTrue (value.length == 2) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{2,6}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{3,5}));

	value = new kakuro().splitList(8,2);
	assertTrue (value.length == 1) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{3,5}));

	value = new kakuro().splitList(9,1);
	assertTrue (value.length == 3) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{2,7}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{3,6}));
	assertTrue (java.util.Arrays.equals(value[2], new int[]{4,5}));

	value = new kakuro().splitList(9,3);
	assertTrue (value.length == 1) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{4,5}));
}

public void TestSplitList3(){
	
	int[][] value = new kakuro().splitList(12,2);
	assertTrue (value.length == 3) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{3,9}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{4,8}));
	assertTrue (java.util.Arrays.equals(value[2], new int[]{5,7}));

	value = new kakuro().splitList(12,3);
	assertTrue (value.length == 2) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{4,8}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{5,7}));

	value = new kakuro().splitList(12,4);
	assertTrue (value.length == 1) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{5,7}));

	value = new kakuro().splitList(12,5);
	assertTrue (value == null) ;

	value = new kakuro().splitList(12,6);
	assertTrue (value == null) ;
	
	value = new kakuro().splitList(13,2);
	assertTrue (value.length == 3) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{4,9}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{5,8}));
	assertTrue (java.util.Arrays.equals(value[2], new int[]{6,7}));

	value = new kakuro().splitList(13,3);
	assertTrue (value.length == 3) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{4,9}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{5,8}));
	assertTrue (java.util.Arrays.equals(value[2], new int[]{6,7}));

	value = new kakuro().splitList(13,4);
	assertTrue (value.length == 2) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{5,8}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{6,7}));

	value = new kakuro().splitList(13,5);
	assertTrue (value.length == 1) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{6,7}));

	value = new kakuro().splitList(14,3);
	assertTrue (value.length == 2) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{5,9}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{6,8}));

	
	value = new kakuro().splitList(15,3);
	assertTrue (java.util.Arrays.equals(value[0], new int[]{6,9}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{7,8}));

	value = new kakuro().splitList(15,5);
	assertTrue (value.length == 2) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{6,9}));
	assertTrue (java.util.Arrays.equals(value[1], new int[]{7,8}));

	value = new kakuro().splitList(15,6);
	assertTrue (value.length == 1) ;
	assertTrue (java.util.Arrays.equals(value[0], new int[]{7,8}));

}

public static TestSuite suite() {
	TestSuite suite = new TestSuite();
	suite.addTest(new kakuroTest("TestConsistencyCheck"));
	suite.addTest(new kakuroTest("TestGetBreak"));
	//suite.addTest(new kakuroTest("TestGenerateList"));
	suite.addTest(new kakuroTest("TestSplitList"));
	suite.addTest(new kakuroTest("TestSplitList2"));
//	suite.addTest(new kakuroTest("TestSplitList3"));
	return suite;
}

public static void main(String [] args ){
	suite();
	}
}
	
