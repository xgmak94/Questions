/*
Rotate an array to the left by k positions without using extra space.
k can be greater than the size of the array.

Example: 
rotateLeft({1,2,3,4,5},2) --> {3,4,5,1,2}
*/

public static int[] rotateLeft(int[] arr, int k) {
    reverse(arr, 0, arr.length - 1);
    reverse(arr, 0, arr.length - (k % arr.length) - 1);
    reverse(arr, arr.length - (k % arr.length), arr.length - 1);
    return arr;
}

public static void reverse(int[] arr, int left, int right){
	if(arr == null || arr.length == 1) return;
	while(left < right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
		left++;
		right--;
	}	
}