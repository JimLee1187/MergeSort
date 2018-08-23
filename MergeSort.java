package sort;
/**
 *
 * @author  LiJing 
 * @date    2017年9月11日 上午9:40:53
 * @Version 1.0
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr={7,6,5,4,3,2,1,1,0,7,6,5,8,2,1,4,2,1,5,8,4,6,4,8,54,4,3};
		int[] arr1={7,6,5,4,3,2,1,1,0,7,6,5,8,2,1,4,8,4,8,4,6,4,7,9,4,3,4,5,6};
		int left=0;
		int right=arr.length-1;
		MergeSortRecursion(arr,left,right);
		for(int a:arr){
			System.out.print(a+"  ");
		}
		System.out.println();
		 MergeSortIteration(arr1, arr1.length);
			for(int a:arr1){
				System.out.print(a+"  ");
			}
	}
	
	/**
	 * 
	 * 
	 * @Title: merge
	 * @Description: 
	 * @param: @param arr
	 * @param: @param left
	 * @param: @param mid
	 * @param: @param right   
	 * @return: void   
	 * @throws
	 */
	public static void merge(int[] arr, int left, int mid, int right){
		int len=right-left-1;
		int [] temp=new int[len];
		int index=0;
		int i=left;
		int j=mid+1;
		while(i <= mid && j <= right){
			temp[index++]=arr[i] <= arr[j] ? arr[i++] : arr[j++];
		}
		while(i <= mid){
			temp[index++]=arr[i++];
		}
		while(j <= right){
			temp[index++]=arr[j++];
		}
		for(int p = 0; p < len; p++){
			arr[left++]=temp[p];
		}
	}
	
	/**
	 * 
	 * @Title: MergeSortRecursion
	 * @Description: 
	 * @param: @param arr
	 * @param: @param left
	 * @param: @param right   
	 * @return: void   
	 * @throws
	 */
	public static void MergeSortRecursion(int[] arr, int left, int right){
		if(left==right)
			return;
		int mid = (left + right) / 2;
		MergeSortRecursion(arr, left, mid);
		MergeSortRecursion(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}
	
	public static void MergeSortIteration(int[] arr, int len){
		int left, mid, right;
		for(int i=1; i<len; i*=2){
			left=0;
			while(left + 1 < len){
				mid = left + i - 1;
				right = mid + i < len ? mid + i : len - 1;
	            merge(arr, left, mid, right);
	            left = right + 1; 
			}
		}
	}
}
