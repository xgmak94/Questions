/*
Let's have some fun with 2D Matrices! Write a method findSpiral to traverse a 2D matrix of ints in a clockwise spiral order and append the elements to an output ArrayList if Integers.



Example:

Input Matrix :      

    {1, 2, 3}

    {4, 5, 6}

    {7, 8, 9}

Output ArrayList:[1, 2, 3, 6, 9, 8, 7, 4, 5]
*/

public static ArrayList<Integer> findSpiral(int[][] arr) {
    ArrayList<Integer> spiralOrder = new ArrayList<Integer>();
    if(arr == null || arr.length == 0) return spiralOrder;
    int m = arr.length, n = arr[0].length;
    int x=0, y=0;
    while(m>0 && n>0){
        if(m==1){
            for(int i=0; i<n; i++)
                spiralOrder.add(arr[x][y++]);
            break;
        }else if(n==1){
            for(int i=0; i<m; i++)
                spiralOrder.add(arr[x++][y]);
            break;
        }
        for(int i=0;i<n-1;i++)
            spiralOrder.add(arr[x][y++]);
        for(int j=0;j<m-1;j++)
            spiralOrder.add(arr[x++][y]);
        for(int i=0;i<n-1;i++)
            spiralOrder.add(arr[x][y--]);
        for(int j=0;j<m-1;j++)
            spiralOrder.add(arr[x--][y]);
        x++;
        y++;
        m=m-2;
        n=n-2;
    }
    return spiralOrder; 
}