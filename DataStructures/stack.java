
import java.util.EmptyStackException;
import java.util.Stack;

// class stackimp{
//     int top=0;
//     int stack[]=new int[5];
//     void push(int data){
//         stack[top]=data;
//         top++;
//     }
//     void show(){
//         for(int n:stack){
//             System.out.print(n+" ");
//         }
//     }
//     void pop(){
//         top--;
//         stack[top]=0;
//     }
//     void peek(){
//         System.out.println();
//         System.out.println(stack[top-1]);
//     }
//     void size(){
//         System.out.println("size is "+stack[top-1]);
//     }
// }
// public class stack {
//     public static void main(String[] args) {
//         stackimp a=new stackimp();
//         a.push(1);
//         a.push(2);
//         a.push(3);
//         a.push(4);
//         a.push(5);
//         a.push(6);
//         a.size();
//     }
// }

public class stack{

    private class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
        }
    }

    private Node top;
    private int length;

    public stack(){
        top=null;
        length=0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void push(int data){
        Node temp=new Node(data);
        temp.next=top;
        top=temp;
        length++;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int result=top.data;
        top=top.next;
        length--;
        return result;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public String reverse(String str){
        Stack<Character> stack=new Stack<>();
        char[] chars=str.toCharArray();

        for(char c:chars){
            stack.push(c);
        }

        for(int i=0;i<str.length();i++){
            chars[i]=stack.pop();
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        stack stack=new stack();
        stack.push(1);   
        stack.push(2);   
        stack.push(3);   
        stack.push(4);   

        // System.out.println(stack.peek());
        // stack.pop();
        // System.out.println(stack.peek());

        System.out.println(stack.reverse("Dhruvil Mehta"));
    }
}