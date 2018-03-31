/*
In doubly linked list, implement a method to insert a node at specified position and return the list's head. Do nothing if insertion position is outside the bounds of the list.

Examples:
insertAtPos(1<=>2<=>3,4,2) ==> 1<=>4<=>2<=>3
insertAtPos(1,4,3) ==> 1

*/

public DoublyLinkedNode insertAtPos(DoublyLinkedNode head, int data, int pos) {
    if(head == null && pos == 1)
        return new DoublyLinkedNode(data);
    if(pos <= 0)
        return head;
    
    HashMap<Integer, DoublyLinkedNode> map = new HashMap<>();
    
    int totalLength = 1;
    DoublyLinkedNode temp = head;
    
    while(temp != null) {
        map.put(totalLength, temp);
        totalLength++;
        temp = temp.next;
    }
    
    if(pos > totalLength)
        return head;
    else {
        DoublyLinkedNode newNode = new DoublyLinkedNode(data);
        newNode.prev = null;
        newNode.next = null;

        if(pos == 1) { // head
            DoublyLinkedNode nextNode = map.get(pos);
            newNode.next = nextNode;
            nextNode.prev = newNode;
            head = newNode;
        }
        else if(totalLength == pos) { // tail
            DoublyLinkedNode prevNode = map.get(pos - 1);
            newNode.prev = prevNode;
            prevNode.next = newNode;
        }
        else { // middle
            DoublyLinkedNode prevNode = map.get(pos - 1);
            DoublyLinkedNode nextNode = map.get(pos);
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = nextNode;
            nextNode.prev = null;
        }
        return head;
    }
}   