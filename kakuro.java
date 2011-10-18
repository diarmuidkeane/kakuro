
public class kakuro {
/**
 * input : total 
 * input : number of squares
 * input : list of known elements 
 * output : list of possible vectors 
 */
	private static final int order = 10;
	private static final int maxSum = order * ( order-1) / 2;
	
	int[] vector = {2,3,5,6};
	int[] knownElements = {2,3};
	
	public boolean consistencyCheck(){
		boolean check = true, found = true;
		if (vector != null && getSize()>0 && knownElements != null && knownElements.length > 0 )
			for(int i=0 ; found && i< knownElements.length ; i++){
				found = false;
				for(int j=0 ; j< getSize() ; j++)
					if (vector[j]==knownElements[i])
						found = true;
			}
		check = found;
		return check;
	}
	
	private int getSize(){
		return vector.length;
	}
	/**
	 * 
	 * @return
	 */
	public int[][][] generateList(){
		int[][][] list = new int[maxSum][][];
		for (int i = 0 ; i < maxSum ; i++){
			list[i] = generateList(i+1);
		}
		return list;
	}
	
	/**
	 * 
	 * @param a
	 * @return
	 *
	 *1 {{1}}
	 *2 {{2}}
	 *3 {{3} , {1 , 2 }}
	 *4 {{4} , {1 , 3 }}
	 *5 {{5} , {1 , 4 } , {2 , 3 } }
	 *6 {{6} , {1 , 5 } , {2 , 4 } , {1 , 2 , 3} }
	 *7 {{7} , {1 , 6 } , {2 , 5 } , {3 , 4} , {1 , 2 , 4} }
	 *8 {{8} , {1 , 7 } , {2 , 6 } , {3 , 5} , {1 , 2 , 5} , {1 , 3 , 4} }
	 *9 {{9} , {1 , 8 } , {2 , 7 } , {3 , 6} , {4 , 5} , {1 , 2 , 6} , {1 , 3 , 5 } , {2 , 3 , 4} }
	 *9 {{9} , {1 , 8 } , {2 , 7 } , {3 , 6} , {4 , 5} , {1 , 2 , 6} , {1 , 3 , 5 } , {2 , 3 , 4} }
	 *10 { {1 , 9 } , {2 , 8 } , {3 , 7} , {4 , 6} , {1 , 2 , 7} , {1 , 3 , 6 } , {1 , 4 , 5 } , {2 , 3 , 5} , {1 , 2 , 3 , 4} }
	 *11 { {2 , 9 } , {3 , 8} , {4 , 7} , {5 , 6} , {1 , 2 , 8} , {1 , 3 , 7 } , {1 , 4 , 6 } , {2 , 3 , 6} , {2 , 4 , 5} , {1 , 2 , 3 , 5} }
	 *12 { {3 , 9}  , {4 , 8} , {5 , 7} , {1 , 2 , 9 } , {1 , 3 , 8} , {1 , 4 , 7} , {1 , 5 , 6} , {2, 3 , 7} , {2, 4 , 6} , {3 , 4 ,5 }
	 *13 { {4 , 9}  , {5 , 8} , {6 , 7} , { 1 , 3 , 9}  , {1 , 4 , 8} , {1 , 5 , 7} , { 2, 3 , 8 } , { 2 , 4, 7 } , { 2 , 5 , 6 } , {3 , 4 , 6 } , {}
	 * 
	 * X : list(X,3) = map {1 , list(X-1,2)/elements(1) } U map { 2 , list(X-2,2)/elements( [1] , 2 ) } U .. etc ... while X>1

	 * X : list(X,2) = map {1 , list(X-1,1)/elements(1) } U map { 2 , list(X-2,1)/elements( [1] , 2 ) } U .. etc ... while X>1
	 * 7 : {1 , 8 } U {2 , 7 } U {3 , 6} U {4 , 5}  

	 * X : list(X,o) = map {1 , list(X-1,o-1)/elements(1) } U map { 2 , list(X-2,o-1)/elements( [1] , 2 ) } U .. etc .
	 * 
	 * generate(X , o ){
	 * 		int index = 0;
	 * 		int [][] result = new int[][];
	 * 		int [][] temp ;  
	 * 		for(int i = X-1 ; i-- > 1 ;) {
	 * 	 		temp = generate(i,o-1);
	 * 			for (int j = 0 ; j++ < temp.length ;){
	 * 				result[index++] = temp[j] ; 
	 * 			} 
	 * 		}
	 * }
	 * 
	 * 
	 *13 { {1 , 8 } , {2 , 7 } , {3 , 6} , {4 , 5} , {1 , 2 , 6} , {1 , 3 , 5 } , {2 , 3 , 4} }
	 *14 { {1 , 8 } , {2 , 7 } , {3 , 6} , {4 , 5} , {1 , 2 , 6} , {1 , 3 , 5 } , {2 , 3 , 4} }
	 *15 { {1 , 8 } , {2 , 7 } , {3 , 6} , {4 , 5} , {1 , 2 , 6} , {1 , 3 , 5 } , {2 , 3 , 4} }
	 *16 { {1 , 8 } , {2 , 7 } , {3 , 6} , {4 , 5} , {1 , 2 , 6} , {1 , 3 , 5 } , {2 , 3 , 4} }
	 *17 { {1 , 8 } , {2 , 7 } , {3 , 6} , {4 , 5} , {1 , 2 , 6} , {1 , 3 , 5 } , {2 , 3 , 4} }
	 *18 { {1 , 8 } , {2 , 7 } , {3 , 6} , {4 , 5} , {1 , 2 , 6} , {1 , 3 , 5 } , {2 , 3 , 4} }
	 *19 { {1 , 8 } , {2 , 7 } , {3 , 6} , {4 , 5} , {1 , 2 , 6} , {1 , 3 , 5 } , {2 , 3 , 4} }
	 *20 { {1 , 8 } , {2 , 7 } , {3 , 6} , {4 , 5} , {1 , 2 , 6} , {1 , 3 , 5 } , {2 , 3 , 4} }
	 */
	public int[][] generateList(int a){
		int[][] list = new int[order][];
		for (int i = 0 ; i < a ; i++){
			list[i] = generateList(i+1,0);
		}
		return list;
	}
	
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int[] generateList(int X , int o){
		int index = 0;
	  	int [][] result = new int[X][];
	  	int [] temp ;  
	  	for(int i = X-1 ; i-- > 1 ;) {
	  	 	temp = generateList(i,o-1);
	  		/*for (int j = 0 ; temp[j] != null && j++ < temp.length ;){
	  			
	  		} 	*/  		
	  		if (temp != null  )
	  			result[index++] = temp ; 
	  	}
	  	if (result.length > 0 ){
	  		return result[0]; // fix
	  	}
	  	if (X<=1)
	  		return new int[]{1};
	  	return null; 
	  }

	static void showList(int[][] list){
		System.out.print("list of length:" + list.length +" {");
		for (int i = 0 ; i < list.length ; i++){
			if(i>0)
				System.out.print(" , ");
			if(list[i]!=null)
				System.out.print("{"+list[i][0]+","+list[i][1]+"}");
			else
				System.out.print("{null,null}" );
		}
		System.out.println("}");
	}
	
	
	/**
	 * 1  0
	 * 2  0
	 * 3  1   1,2
	 * 4  1   1,3 
	 * 5  2   1,4   2,3
	 * 6  2   1,5   2,4 
	 * 7  3
	 * 8  3
	 * 9  4
	 * 10 4
	 * 11 4
	 * 12 3
	 * 13 3
	 * 14 2
	 * 15 2
	 * 16 1
	 * 17 1
	 * 
	 */
	int[][] splitList(int total){
		return splitList(total,0);
	}
	/**
	 * 
	 * @param total
	 * @param filter
	 * @return
	 *
	 * total   filter   normalLength   length
	 * 12		2		3				3
	 * 12		3		3				2
	 * 12		4		3				1
	 * 12		5
	 * 13		2		3				3
	 * 13		3		3				3
	 * 13		4		3				2
	 * 13		5		3				1
	 * 13		6		
	 * 14		3		2				2
	 * 14		4		2				2
	 * 14		5		2				1
	 * 14		6			
	 * 15		3		2				2
	 * 15		4		2				2
	 * 15		5		2				2
	 * 15		6		2				1
	 * 15		7
	 * 
	 * filter < (total-1)/2
	 */
	
	int[][]  splitList(int total , int filter  ){
 
		int normalLength = total>order?((2*order-total-1)/2):((total-1)/2);
		int filteredLength = (total-1)/2-filter;
		int arrayLength = filteredLength < normalLength?filteredLength:normalLength; 
		
		if(arrayLength>0){
		int[][] result = new int[arrayLength][];
			for(int i=1,j=0 ; j<arrayLength ; i++ ){
				if(total-i >= order )
					continue;
				if (i <= filter)
					continue;
				int[] element = new int[2];
				element[0] = i;
				element[1] = total-i;
				result[j++] = element;
			}
			showList(result);
			return result;
		}
		return null;
	}
	
	/**
	 * 
	 * @param a
	 * @return
	 * 
	 *1 : 1
	 *2 : 1
	 *3 : 2
	 *4 : 2
	 *5 : 2
	 *6 : 3
	 *7 : 3
	 *8 : 3 
	 *9 : 3
	 *10 : 4
	 *
	 */
	public int reverseTriangleSumFloor( int a ) { return 0 ; }

	/**
	 * 
	 * @param a
	 * @return
	 *
	 *1 : 1
	 *2 : 1
	 *3 : 1 + 1
	 *4 : 1 + 1 
	 *5 : 1 + 2 
	 *6 : 1 + 2 + 1
	 *7 : 1 + 3 + 1
	 *8 : 1 + 3 + 2
	 *9 : 1 + 4 + 3 
	 *10 : 
	 *
	 */
	public int cardinalityList( int a ) { return 0 ; }

	
	public int getBreak(int a){
		/***
		 *
		 * 1 : 9  = 9
		 * 2 : 9+8 = 17 
		 * 3 : 9+8+7  = 24
		 * 4 : 9+8+7+6  = 30
		 * 5 : 9+8+7+6+5  = 35
		 * 6 : 9+8+7+6+5+4  = 39
		 * 7 : 9+8+7+6+5+4+3  = 42
		 * 8 : 9+8+7+6+5+4+3+2  = 44
		 * 9 : 9+8+7+6+5+4+3+2+1  = 45
		 * 
		 * n : maxSum  - (order-1-n)(order-2-n)/2
		 * 
		 */
		if (a<1 || a>=order)
			return 0; 
		return maxSum - (order-a)*(order-1-a)/2;
	}
}
