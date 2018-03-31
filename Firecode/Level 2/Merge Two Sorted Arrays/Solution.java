/*

The idea behind the classic Mergesort algorithm is to divide an array in half, sort each half, and then use
a merge() method to merge the two halves into a single sorted array. 


Implement the merge() method that takes in 
two sorted arrays and returns a third sorted array that contains elements of both the input arrays. 

You can assume
that the input arrays will always be sorted in ascending order and can have different sizes.


Examples:

merge({2,5,7,8,9},{9}) -> {2,5,7,8,9,9}
merge()({7,8},{1,2}) -> {1,2,7,8}
merge()({2},{}) -> {2}
   {} -> [Empty] Array 

*/

public static int[] merge(int[] arrLeft, int[] arrRight){
    int leftSize = arrLeft.length;
    int rightSize = arrRight.length;
    
    int[] merged = new int[leftSize + rightSize];
    
    int leftIndex = 0, rightIndex = 0;

    while(leftIndex < leftSize && rightIndex < rightSize) {
        if(arrLeft[leftIndex] < arrRight[rightIndex]) {
            merged[leftIndex + rightIndex] = arrLeft[leftIndex];
            leftIndex++;
        }
        else {
            merged[leftIndex + rightIndex] = arrRight[rightIndex];
            rightIndex++;
        }
    }
    
    while(leftIndex < leftSize) {
        merged[leftIndex + rightIndex] = arrLeft[leftIndex];
        leftIndex++;
    }
    
    while(rightIndex < rightSize) {
        merged[leftIndex + rightIndex] = arrRight[rightIndex];
        rightIndex++;
    }
    return merged;
}