class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        
        int i = 0;
        while(i < s.length()) {
            int j = 1;
            while(i+j < s.length() && s.charAt(i+j) == s.charAt(i)) {
                j++;
            }
            
            if(j >= 3) {
                list.add(Arrays.asList(i, i+j-1));
                // equivelent
                // List<Integer> group = new ArrayList<>();
                // group.add(i);
                // group.add(i+j-1);
                // list.add(group);
            }
            i = i+j;
        }
        return list;
    }
}
