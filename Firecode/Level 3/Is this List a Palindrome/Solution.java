/*
Given a singly-linked list, write a method isListPalindrome to determine if the list is a palindrome. A palindrome is a sequence that reads the same backward as forward.
Examples:

1->2->3->2->1 ==> true

1->2->2->3 ==> false

1 ==> true

null ==> true
*/

public Boolean isListPalindrome(ListNode head) {
    ListNode curr = head;
    ArrayList<Integer> forward = new ArrayList<Integer>();
    ArrayList<Integer> reverse = new ArrayList<Integer>();
    Collections.reverse(reverse);
    while(curr != null) {
        forward.add(curr.data);
        reverse.add(curr.data);
        curr = curr.next;
    }
    
    Collections.reverse(reverse);
    
    int i = 0;
    while (i < forward.size()) {
		if(forward.get(i) != reverse.get(i))
		    return false;
		i++;
	}
    return true;
}