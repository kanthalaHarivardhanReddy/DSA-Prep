// { Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while(t>0)
		{
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;	
			int flag=1;
			int flag1=1;
			for(int i=0; i<N;i++)
			{
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if(flag == 1)
				{
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				}
				else
				{
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}
				
				for(int j=0;j<m;j++)
				{
					int a = sc.nextInt();
					tempB = new Node(a);
					if(flag1 == 1)
					{
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else
					{
						preB.bottom = tempB;
						preB = tempB;
					}
				}
				
			}
			//list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);
		
		t--;
		}
	}	
}// } Driver Code Ends


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    public Node merge(Node list1, Node list2) {
        Node dummy = new Node(0);
        Node head = dummy;
        while(list1 != null && list2 != null) {
            if(list1.data > list2.data) {
                dummy.bottom = list2;
                dummy = dummy.bottom;
                list2 = list2.bottom;
            }
            else {
                dummy.bottom = list1;
                dummy = dummy.bottom;
                list1 = list1.bottom;
            }
        }
        if(list1 != null) 
            dummy.bottom = list1;
        else
            dummy.bottom = list2;
        return head.bottom;
    }
    Node flatten(Node root) {
        if(root == null || root.next == null) return root;
        
        root.next = flatten(root.next);
        root =  merge(root,root.next);
        return root;
        
        // Node dummyhead = new Node(-1);
        // Node temp = dummyhead;
        // Node pres = root;
        // Node curr = temp.next;
        // Node next = (curr == null)?null:curr.next;
        // while(pres != null || curr!= null) {
        //     if(pres == null) {
        //          temp.bottom = curr;
        //          temp = curr;
        //         if(curr.bottom == null){
        //             curr = next;
        //             next = (next == null)?null:next.next;
        //         }
        //         else
        //             curr = curr.bottom;
        //     }
        //     else if(curr == null) {
        //         temp.bottom = pres;
        //         temp = pres;
        //         if(pres.bottom == null){
        //             pres = next;
        //             next = (next == null)?null:next.next;
        //         }
        //         else
        //             pres = pres.bottom;
        //     }
        //     else{
        //         if(pres.data < curr.data) {
        //             temp.bottom = pres;
        //             root = pres;
        //             if(pres.bottom == null){
        //                 pres = next;
        //                 next = (next == null)?null:next.next;
        //             }
        //             else
        //                 pres = pres.bottom;
        //         }
        //         else {
        //             temp.bottom = curr;
        //             temp = curr;
        //             if(curr.bottom == null){
        //                 curr = next;
        //                 next = (next == null)?null:next.next;
        //             }
        //             else
        //                 curr = curr.bottom;
        //         }
        //     }
            
        // }
        // while(tail != null) {
        //     tail = connectBot(tail);
        //     // if(next != null)
        //     // System.out.println(tail.data +" "+next.data);
        //     tail.next = next;
        //     tail = next;
        //     next = next == null? null: next.next;
        // }
        // head = mergesort(head);
        // return dummyhead.next;
    }
}