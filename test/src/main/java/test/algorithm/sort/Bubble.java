package test.algorithm.sort;

/**
 * Bubble sort Algorithm 
 * 
 * 相邻交换
 * 
 * 特点：
 * 
 */
public class Bubble {

	public static void BubbleSortArray(int[] intArr) {
		
		int n = intArr.length;

		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(intArr[i] >intArr[j]){
					int num = intArr[i];
					intArr[i] = intArr[j];
					intArr[j] = num;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] a = new int[]{2,3,7,4,3,9,4,6};
		
		System.out.print("before:");
		for(int i: a){
			System.out.print(i+" ");
		}
		
		//sort
		Bubble.BubbleSortArray(a);
		
		System.out.print(" After:");
		for(int i: a){
			System.out.print(i+" ");
		}
	}
}
