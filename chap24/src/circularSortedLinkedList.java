/*
Implement a copy constructor for the circular linked list class. The signature for
your method should be:
public CircularSortedLinkedList(CircularSortedLinkedList inList)
 */
public class circularSortedLinkedList extends LinkedList {
    public circularSortedLinkedList() {
        super();
    }
    //copy constructor
    public circularSortedLinkedList(circularSortedLinkedList inList){
        numItems = inList.numItems;
        list = inList.list;
        currentPos = inList.currentPos;
    }

    public void reset() {
        if (list == null)
            currentPos = list;
        else
            currentPos = list.next;
    }

    @Override
    public Listable getNextItem() {
        Listable nextItemInfo = currentPos.info.copy();
        currentPos = currentPos.next;

        return nextItemInfo;
    }

    @Override
    public boolean isThere(Listable item) {
        int holdCompare;
        boolean moreToSearch;
        ListNode location = list;
        boolean found = false;
        moreToSearch = (location != null);
        while (moreToSearch && !found) {
            holdCompare = item.compareTo(location.next.info);
            if (holdCompare == 0)
                found = true;
            else if (holdCompare < 0) // If list element is larger than item
                moreToSearch = false;
            else {
                location = location.next;
                moreToSearch = (location != list);
            }
        }
        return found;
    }

    public void delete(Listable item)
// Deletes the element of this list whose key matches item's key
    {
        ListNode location = list;
        if (location == location.next) // Single element list
            list = null;
        else {
            while (item.compareTo(location.next.info) != 0)
                location = location.next;
            if (location.next == list) // Deleting last element
                list = location;
// Delete node at location.next
            location.next = location.next.next;
        }
        numItems--;
    }

    @Override
    public void insert(Listable item) {
        // Adds a copy of item to list
        {
            ListNode newNode = new ListNode(); // Reference to node being inserted
            newNode.info = (Listable) item.copy(); // Set info attribute of new node
            if (list == null) // Insert into an empty list
            {
                list = newNode;
                newNode.next = newNode;
            } else // Insert into a nonempty list
            {
                ListNode prevLoc = new ListNode(); // Create trailing reference
                ListNode location = new ListNode(); // Create traveling reference
                boolean moreToSearch = true;
                location = list.next;
                prevLoc = list;
// Find insertion point
                while (moreToSearch) {
                    if (item.compareTo(location.info) < 0) // List element is larger than item
                        moreToSearch = false;
                    else {
                        prevLoc = location;
                        location = location.next;
                        moreToSearch = (location != list.next);
                    }
                }
// Insert node into list
                newNode.next = location;
                prevLoc.next = newNode;
                if (item.compareTo(list.info) > 0) // New item is last on this list
                    list = newNode;
            }
            numItems++;
        }
    }
}
