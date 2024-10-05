
    //this is a brute force solution
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class sortLinkedList {
        public ListNode sortList(ListNode head) {
            int count =0;
            ListNode temp = new ListNode();
            temp = head;
            while(temp!=null){
                count++;
                temp = temp.next;
            }
            int arr[] = new int[count];
            temp = head;
            int k =0;
            while(temp!=null){
                arr[k]=temp.val;
                k++;
                temp=temp.next;
            }
            Arrays.sort(arr);
            temp = head;
            k=0;
            while(temp!=null){
                temp.val=arr[k];
                k++;
                temp=temp.next;

            }
            return head;
        }
    }

