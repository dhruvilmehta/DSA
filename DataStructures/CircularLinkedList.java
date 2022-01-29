
class CircularNode{
    CircularNode next;
    CircularNode last;
    int data;
    CircularNode(int data){
        this.data=data;
    }
}

class CircularList{
    CircularNode head;
    CircularNode last;
    public void insert(int data){
        CircularNode node=new CircularNode(data);
        if(head==null){
            head=node;
            last=node;
            last.next=head;
        }
        else{
            CircularNode temp=head;
            while(temp!=last){
                temp=temp.next;
            }
            temp.next=node;
            last=node;
            last.next=head;
        }
    }

    public void show(){
        if(head==null){
            System.out.println("List is Empty");
        }
        else{
            CircularNode temp=head;
            while(temp!=last){
                System.out.print(temp.data+" --> ");
                temp=temp.next;
            }
            System.out.println(temp.data+" --> "+last.next.data);
        }
    }

    public void length(){
        int count=0;
        if(head==null){
            System.out.println("List is Empty");
        }
        else{
            CircularNode temp=head;
            while(temp!=last){
                count++;
                temp=temp.next;
            }
            System.out.println(++count);
        }
    }

    public void insertAtBeginning(int data){
        CircularNode node=new CircularNode(data);
        if(head==null){
            head=node;
            last=node;
            last.next=head;
        }
        else{
            last.next=node;
            node.next=head;
            head=node;
        }
    }

    public void deleteFirstNode(){
        if(head==null){
            System.out.println("null");
        }
        else{
            head=head.next;
            last.next=head;
        }
    }
}

public class CircularLinkedList {
    public static void main(String[] args) {
        CircularList linked=new CircularList();
        linked.insert(1);
        linked.insert(2);
        linked.insert(3);
        linked.insert(4);
        linked.insert(5);
        linked.insert(6);

        linked.insertAtBeginning(0);
        // linked.insertAtBeginning(-1);

        linked.deleteFirstNode();

        linked.show();
        linked.length();
    }
}
