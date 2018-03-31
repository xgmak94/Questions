// https://leetcode.com/problems/excel-sheet-column-number/#/description

/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 

*/

import java.io.*;
import java.util.*;

public class Solution {
    public int titleToNumber(String s) {
        int column = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            column = column *26 + (s.charAt(i) - 'A' + 1);
        }
        return column;
    }
}
