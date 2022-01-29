class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
    }
}
class list{
    Node head;
    public void insert(int data){
        Node node = new Node(data);
        if(head==null){
            head=node;
        }
        else{
            Node n=head;
            while(n.next!=null){
                n=n.next;
            }
            n.next=node;
        }
    }
    public void show(){  
        if(head==null){
            System.out.println("Null");
        }
        else{
            Node node = head; 
            while(node.next != null)
            {
                System.out.print(node.data+" --> ");
                node=node.next;
            }
            System.out.println(node.data);
        }
    }
    public void length(){
        if(head==null){
            System.out.println("0");
        }
        else{
            Node current=head;
            int count=0;
            while(current!=null){
                count=count+1;
                current=current.next;
            }
            System.out.println("Length "+count);
        }
    }
    public void insertAtBeginning(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }
    public void insertAtEnd(int data){
        Node newNode=new Node(data);
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;
    }
    public void insertAtIndex(int data,int index){
        boolean flag=false;
        Node newNode=new Node(data);
        if(index==1){
            newNode.next=head;
            head=newNode;
        }
        else{
            Node previous=head;
            int count=1;
            while(count<index-1){
                previous=previous.next;
                if(previous==null){
                    flag=true;
                    break;
                }
                count++;
            }
            if(flag==true){
                System.out.println("Index Does Not Exists");
            }
            else{
                Node current=previous.next;
                previous.next=newNode;
                newNode.next=current;
            }
        }
    }
    public void deleteFirstNode(){
        if(head==null){
            System.out.println("List is Empty");
        }
        else{
            head=head.next;
        }
    }
    public void deleteLastNode(){
        if(head==null||head.next==null){
            System.out.println("Null");
        }
        else{
            Node current=head;
            Node previous=null;
            while(current.next!=null){
                previous=current;
                current=current.next;
            }
            previous.next=null;
        }
    }
    public void deleteAtIndex(int index){
        if(index==1){
            head=head.next;
        } 
        else{
            Node current=head;
            Node previous=null;
            int count=0;
            while(count<index-1){
                previous=current;
                current=current.next;
                count++;
            }
            previous.next=current.next;
        }
    }
    public int find(int value){
        if(head==null){
            System.out.println("List is Empty");
            return -1;
        }
        else{
            Node current = head;
            int index=0;
            while(current!=null){
                if(current.data==value){
                    System.out.println("Found At Index "+index);
                    return index;
                }
                index++;
                current=current.next;
            }
            return -1;
        }
    }
    public void reverse(){
        Node current=head;
        Node previous=null;
        Node next=null;
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        head=previous;
    }
    public Node findMiddle(){
        Node slowPtr=head;
        Node fastPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
        }
        System.out.println("Middle Node is "+slowPtr.data);
        return slowPtr;
    }
    public Node findNthNodeFromEnd(int n){
        if(head==null){
            return null;
        }
        Node mainPtr=head;
        Node refPtr=head;
        int count=0;
        while(count<n){
            if(refPtr==null){
                System.out.println("Node is greater than length of linked list");
                return null;
            }
            refPtr=refPtr.next;
            count++;
        }
            while(refPtr!=null){
                refPtr=refPtr.next;
                mainPtr=mainPtr.next;
            }
            System.out.println("Node "+mainPtr.data);
            return mainPtr;
    }
    public void removeDuplicateFromSortedLL(){
        if(head==null){
            System.out.println("List is Empty");
        }
        else{
            Node current=head;
            while(current!=null && current.next!=null){
                if(current.data==current.next.data){
                    current.next=current.next.next;
                }
                else{
                    current=current.next;
                }
            }
        }
    }
    public void insertNodeinSortedLL(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
        }
        else{
            Node current=head;
            Node temp=null;
            while(current!=null && current.data<data){
                temp=current;
                current=current.next;
            }
            try{
                if(current.data==data){}
                else{
                    newNode.next=current;
                    temp.next=newNode;
                }
            }
            catch(Exception e){
                newNode.next=current;
                temp.next=newNode;
            }
        }
    }
    public void deleteValue(int data){
        if(head==null){
            System.out.println("List is Empty");
        }
        else if(head.data==data){
            head=head.next;
        }
        else{
            Node current=head;
            Node temp=null;
            while(current!=null && current.data!=data){
                temp=current;
                current=current.next;
            }
            if(current==null){
                System.out.println("Value Not Found");
            }
            else{
                temp.next=current.next;
            }
        }
    }
    public boolean detectLoop(){
        Node fastPtr=head;
        Node slowPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if(slowPtr==fastPtr){
                return true;
            }
        }
        return false;
    }
    public void createALoop(){
        Node first=new Node(1);
        Node second=new Node(2);
        Node third=new Node(3);
        Node fourth=new Node(4);
        Node fifth=new Node(5);
        Node sixth=new Node(6);
        head=first;
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=third;
    }
    public Node findStartOfALoop(){
        Node fastPtr=head;
        Node slowPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if(slowPtr==fastPtr){
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }
    private Node getStartingNode(Node slowPtr){
        Node temp=head;
        while(temp!=slowPtr){
            temp=temp.next;
            slowPtr=slowPtr.next;
        }
        return temp;
    }
    public void removeLoop(){
        Node fastPtr=head;
        Node slowPtr=head;
        while(fastPtr!=null && fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
            if(slowPtr==fastPtr){
                removeLoop(slowPtr);
            }
        }
    }
    private void removeLoop(Node slowPtr){
        Node temp=head;
        while(temp.next!=slowPtr.next){
            temp=temp.next;
            slowPtr=slowPtr.next;
        }
        slowPtr.next=null;
    }
}
public class SinglyLinkedList {
    public static void main(String[] args) {
        list linked=new list();
        // linked.insert(10);
        // linked.insert(11);
        // linked.insert(12);
        // linked.insert(13);
        // linked.insert(14);
        // linked.insert(15);
        // linked.insertAtBeginning(9);
        // linked.insertAtBeginning(8);

        // linked.insertAtEnd(13);
        // linked.insertAtEnd(14);

        // linked.insertAtIndex(1, 3);
        // linked.insertAtIndex(2, 9);

        // linked.deleteFirstNode();
        // linked.deleteFirstNode();

        // linked.deleteLastNode();
        // linked.deleteLastNode();

        // linked.deleteAtIndex(4);
        // linked.deleteAtIndex(1);

        // int index=linked.find(14);
        // System.out.println(index);

        // linked.reverse();

        // linked.findMiddle();
        // Node middleNode=linked.findMiddle();
        // System.out.println(middleNode.data);

        // linked.findNthNodeFromEnd(5);
        // Node n =linked.findNthNodeFromEnd(5);
        // System.out.println(n.data);

        // linked.removeDuplicateFromSortedLL();

        // linked.insertNodeinSortedLL(15);

        // linked.deleteValue(13);

        // linked.createALoop();
        // System.out.print(linked.detectLoop());

        // linked.createALoop();
        // System.out.println(linked.findStartOfALoop().data);

        linked.createALoop();
        linked.removeLoop();

        linked.show();
        linked.length();

    }
}