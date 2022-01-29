
class DoublyLinkedNode{
    DoublyLinkedNode previous;
    DoublyLinkedNode next;
    int data;
    DoublyLinkedNode(int data){
        this.data=data;
    }
}

class List{
    DoublyLinkedNode head;
    DoublyLinkedNode tail;
    public void insertLast(int data){
        DoublyLinkedNode node =new DoublyLinkedNode(data);
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            tail.next=node;
            node.previous=tail;
            tail=node;
        }
    }

    public void insertStart(int data){
        DoublyLinkedNode node=new DoublyLinkedNode(data);
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            head.previous=node;
            node.next=head;
            head=node;
        }
    }

    public void showForwards(){
        if(head==null){
            System.out.println("null");
        }
        else{
            DoublyLinkedNode n=head;
            while(n.next!=null){
                System.out.print(n.data+" --> ");
                n=n.next;
            }
            System.out.println(n.data+" --> null");
        }
    }

    public void showBackwards(){
        if(tail==null){
            System.out.println("null");
        }
        else{
            DoublyLinkedNode temp=tail;
            while(temp.previous!=null){
                System.out.print(temp.data+" --> ");
                temp=temp.previous;
            }
            System.out.println(temp.data+" --> null ");
        }
    }

    public int length(){
        if(head==null){
            System.out.println(0);
            return 0;
        }
        else{
            DoublyLinkedNode n=head;
            int count=0;
            while(n!=null){
                count++;
                n=n.next;
            }
            System.out.println(count);
            return count;
        }
    }
    public void deleteStartNode(){
        if(head==null){
            System.out.println("List is Empty");
        }
        else{
            if(head==tail){
                head=null;
                tail=null;
            }
            else{
                head=head.next;
                head.previous=null;
            }
        }
    }
    public void deleteLast(){
        if(head==null){
            System.out.println("List is Empty");
        }
        else{
            if(head==tail){
                head=null;
                tail=null;
            }
            else{
                tail=tail.previous;
                tail.next=null;
            }
        }
    }
}
 
public class DoublyLinkedList {
    public static void main(String[] args) {
        List linked=new List();
        linked.insertLast(1);
        linked.insertLast(2);
        linked.insertLast(3);
        linked.insertLast(4);
        linked.insertLast(5);
        linked.insertLast(6);
        linked.insertStart(0);
        // linked.insertStart(-1);

        // linked.deleteStartNode();

        linked.deleteLast();
    
        linked.showForwards();
        linked.showBackwards();
        linked.length();
    }
}