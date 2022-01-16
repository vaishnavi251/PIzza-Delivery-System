/*
Project name : Pizza delivery management system
This project aims to develop a system which places order for pizza, displays it and delivers it digitally using queue and linked list data structure
 */

package com.company;
import java.util.*;

public class pizzaDeliverySystem {
    public static void main(String[] args) {
        //object of queue class
        Queue obj = new Queue();
        int choice;
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO PIZZA PARLOUR");

        //do while loop to display menu
        do
        {
            System.out.println("\n**********MENU**********");
            System.out.println("1.Place order\n2.Deliver the order\n3.Display\n4.Exit");
            System.out.println("\nEnter your choice:");
            choice = sc.nextInt();

            //if to place order option chosen
            if(choice == 1)
                obj.placeOrder();

            //if delivery option chosen
            else if(choice == 2)
                obj.deliver();

            //if display option chosen
            else if(choice == 3)
                obj.display();

            //to exit
            else if(choice==4)
                System.out.println("\nThank you!! Visit again");

            //if choice is invalid
            else
                System.out.println("\nInvalid choice ");
        }while(choice!=4);
    }
}


class node {
    //variable declaration
    String pizzaName;
    char size; // (S/s-small, M/m-medium ,L/l-large)
    int price;
    node next;

    //constructor of class node
    node (String name, char s, int p)
    {
        pizzaName = name;
        price = p;
        size = s;
        next = null;
    }
}

//class queue to perform the desired operation
class Queue {
    //declare two nodes named rear and front
    node front; //reference to front end
    node rear; //reference to rear end
    int p;

    //constructor of class queue to set front and rear to null
    Queue() {
        front = null;
        rear = null;
    }

    //method to enqueue
    void placeOrder() {
        //temp node to hold standby entry
        node temp;

        Scanner sc1 = new Scanner(System.in);
        //read entries in appropriate variables
        System.out.println("\nEnter Pizza name:");
        String name = sc1.nextLine();
       // sc1.nextLine();
        System.out.println("\nEnter Pizza size:\nS for small\nM for medium\nL for large");
        char s = sc1.next().charAt(0);
        if(s=='S' || s=='s')
            p = 199;
        else if(s=='m' || s=='M')
            p = 299;
        else
            p = 399;

        //assign the current entries received to temp node
        temp = new node(name,s,p);
        temp.next = null;

        //if queue was empty,insert first node
        if(front == null) {
            rear = temp;
            front = temp;
        }
        else {
            rear.next = temp;
            temp.next = null;
            rear = temp;
        }
    }

    //method to dequeue
    void deliver() {
        node prev,cur;
        //if queue is empty
        if(front == null) {
            System.out.println("\n All the deliveries are done");
            return;
        }

        // Store previous front and move front one node ahead
        else {
            cur = front;
            front = front.next;
            //if all nodes get dequeued, front node will set to null, but rear will still point to last node. so set rear to null if front becomes null
            if(front == null)
                rear = null;
            System.out.println("\nDelivered!");
        }
    }

    //method to display details of order
    void display() {
        node cur;
        if(rear == null)
            System.out.println("\nAll the deliveries are done.");
        else {
            cur = front;//equate front to cur
            //transverse the entire queue
            while(cur != null) {
                System.out.println("\n*****Details of Order***** ");
                System.out.println("Name of Pizza : "+cur.pizzaName);
                System.out.println("Size : "+cur.size);
                System.out.println("Price : "+cur.price);
                cur=cur.next;  // increment link
            }
        }
    }
}

/*
OUTPUT

WELCOME TO PIZZA PARLOUR

**********MENU**********
1.Place order
2.Deliver the order
3.Display
4.Exit

Enter your choice:
1

Enter Pizza name:
margherita pizza

Enter Pizza size:
S for small
M for medium
L for large
s

**********MENU**********
1.Place order
2.Deliver the order
3.Display
4.Exit

Enter your choice:
1

Enter Pizza name:
farm house pizza

Enter Pizza size:
S for small
M for medium
L for large
m

**********MENU**********
1.Place order
2.Deliver the order
3.Display
4.Exit

Enter your choice:
1

Enter Pizza name:
peppy paneer pizza

Enter Pizza size:
S for small
M for medium
L for large
l

**********MENU**********
1.Place order
2.Deliver the order
3.Display
4.Exit

Enter your choice:
1

Enter Pizza name:
veggie paradise

Enter Pizza size:
S for small
M for medium
L for large
u

**********MENU**********
1.Place order
2.Deliver the order
3.Display
4.Exit

Enter your choice:
3

*****Details of Order*****
Name of Pizza : margherita pizza
Size : s
Price : 199

*****Details of Order*****
Name of Pizza : farm house pizza
Size : m
Price : 299

*****Details of Order*****
Name of Pizza : peppy paneer pizza
Size : l
Price : 399

*****Details of Order*****
Name of Pizza : veggie paradise
Size : u
Price : 399

**********MENU**********
1.Place order
2.Deliver the order
3.Display
4.Exit

Enter your choice:
2

Delivered!

**********MENU**********
1.Place order
2.Deliver the order
3.Display
4.Exit

Enter your choice:
3

*****Details of Order*****
Name of Pizza : farm house pizza
Size : m
Price : 299

*****Details of Order*****
Name of Pizza : peppy paneer pizza
Size : l
Price : 399

*****Details of Order*****
Name of Pizza : veggie paradise
Size : u
Price : 399

**********MENU**********
1.Place order
2.Deliver the order
3.Display
4.Exit

Enter your choice:
4

Thank you!! Visit again

Process finished with exit code 0

 */