package test.algorithm.search;

import java.util.Arrays;

/**
 * 二分查找算法
 * 
 * 通过递归，将待查找数组分半进行查找;先排序？
 * 
 * 结论:
 * (1)、必须采用顺序存储结构（2）、必须按关键大小有序排列
 * 算法思想：首先，将表中间位置记录的关键字与查找关键字比较，如果两者相等则查找成功，否则利用中间位置记录将表分成前后两个字表，
 * 如果中间位置记录的关键字大于查找关键字，则进一步查找前一子表，否则进一步查找后一子表。
 * 
 * 特点：
 * 
 * 
 */
public class HalfSplitSearch {

	/**
	 * 二分查找
	 * @param natureSortedArr 自然排序的目标数组，从小到大
	 * @param targetValue 待查找值
	 * @return 查找结果
	 */
	public static int Search(int[] natureSortedArr, int targetValue){
		
		System.out.println("Log:find");
		
		int length = natureSortedArr.length;
		
		if(length == 0){
			return -1; 
		}
		
		if(length == 1){
			return natureSortedArr[0] == targetValue? natureSortedArr[0]:-1; 
		}
		
		//分割点index
		int index ;
		int findValue;
		if(length % 2 == 0){
			index = length / 2 - 1;
			findValue = natureSortedArr[index];
			if(findValue == targetValue){
				return natureSortedArr[index];
			}else{
				/* 此处递归只能有一条途径，推理出源数组是一个有序的数组，从而判断选哪个子数组
				HalfSplitSearch.HalfSplitSearch(Arrays.copyOfRange(sourceArr, 0, index - 1),targetValue);
				*/
				if(findValue > targetValue){
					//Search(Arrays.copyOfRange(natureSortedArr, 0, index ), targetValue);
					int[] newIntArr = new int[length / 2];
					System.arraycopy(natureSortedArr, 0, newIntArr, 0, length/2);
					return Search(newIntArr,targetValue);
				}else{
					return Search(Arrays.copyOfRange(natureSortedArr, index+1, natureSortedArr.length ), targetValue);
					
				}
			}
		}else if(length % 2 > 0){
			index = length / 2;
			findValue = natureSortedArr[index];
			if(findValue == targetValue){
				return natureSortedArr[index];
			}else{
				/* 此处递归只能有一条途径，推理出源数组是一个有序的数组，从而判断选哪个子数组
				HalfSplitSearch.HalfSplitSearch(Arrays.copyOfRange(sourceArr, 0, index - 1),targetValue);
				*/
				if(findValue > targetValue){
					int[] newIntArr = new int[index - 1];
					System.arraycopy(natureSortedArr, 0, newIntArr, 0, newIntArr.length);
					return Search(newIntArr,targetValue);
				}else{
					int[] newIntArr = new int[length - index - 1];
					System.arraycopy(natureSortedArr, index + 1, newIntArr, 0, newIntArr.length);
					return Search(newIntArr,targetValue);
					
				}
			}
		}
		
		return -1;
	}
	
	/**
     * description : 二分查找。
     *
     * @param <E>
     * @param array 需要查找的有序数组
     * @param from 起始下标
     * @param to 终止下标
     * @param key 需要查找的关键字
     * @return
     * @throws Exception
     */
    public static <E extends Comparable<E>> int binarySearch(E[] array, int from, int to, E key) throws Exception {
        if (from < 0 || to < 0) {
            throw new IllegalArgumentException("params from & length must larger than 0 .");
        }
        if (from <= to) {
            int middle = (from >>> 1) + (to >>> 1); // 右移即除2
            E temp = array[middle];
            if (temp.compareTo(key) > 0) {
                to = middle - 1;
            } else if (temp.compareTo(key) < 0) {
                from = middle + 1;
            } else {
                return middle;
            }
        }
        return binarySearch(array, from, to, key);
    }
	
	private static int binarySearch0(int[] a, int fromIndex, int toIndex,
			int key) {
		int low = fromIndex;
		int high = toIndex - 1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[mid];
			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}
    
	public static void main(String[] args) {
		
		int[] targetArr = new int[]{1,2,3,4,5,6,7,8,9,10};
		int targetValue = 7;
		
		//System.out.println(HalfSplitSearch.Search(targetArr, targetValue));
		System.out.println(binarySearch0(targetArr, 0, targetArr.length, targetValue));
		
	}
	
}
