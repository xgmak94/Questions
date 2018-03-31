/*

Selection sort offers improved performance over bubble sort, especially for arrays with a large number of elements. 
Where bubble sort accumulated the largest elements towards the end of the array, selection sort accumulates the smallest elements at the beginning of the array.

Write a method that uses the selection sort algorithm to sort an input array of integers. 
See the hints and click the red colored links for additonal details on the algorithm.

Examples:

selectionSortArray({1,5,2}) -> {1,2,5}

selectionSortArray({11}) -> {11}

selectionSortArray({}) -> {}
    {} -> [Empty] Array 

*/

public static int[] selectionSortArray(int[] arr){
    for(int i = 0 ; i < arr.length ; i++) {
        int minIndex = i;
        for(int j = i ; j < arr.length ; j++) {
            if(arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        //swap
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
    return arr;
}