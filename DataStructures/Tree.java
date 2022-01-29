
import java.util.*;

public class Tree {

    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data=data;
        }
    }

    private TreeNode root;

    public void createBinaryTree(){
        TreeNode first=new TreeNode(1);
        TreeNode second=new TreeNode(2);
        TreeNode third=new TreeNode(3);
        TreeNode fourth=new TreeNode(4);
        TreeNode fifth=new TreeNode(5);

        root=first;
        first.left=second;
        first.right=third;

        second.left=fourth;
        second.right=fifth;

    }

    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.data);
        preOrder(root.left); 
        preOrder(root.right);
    }

    public void stackPreOrder(){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            System.out.print(temp.data);
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
    }

    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public void stackInOrder(){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=root;
        while(!stack.isEmpty()||temp!=null){
            if(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }else{
                temp=stack.pop();
                System.out.print(temp.data+" ");
                temp=temp.right;
            }
        }
    }

    public void postOrder(TreeNode root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public void stackPostOrder(){
        TreeNode current=root;
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty()||current!=null){
            if(current!=null){
                stack.push(current);
                current=current.left;
            }else{
                TreeNode temp=stack.peek().right;
                if(temp==null){
                    temp=stack.pop();
                    System.out.print(temp.data+" ");
                    while(!stack.isEmpty() && temp==stack.peek().right){
                        temp=stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }else{
                    current=temp;
                }
            }
        }
    }

    public void levelOrderTraversal(){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int maxvalue=0;

        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            System.out.print(temp.data+" ");
            if(temp.data>maxvalue){
                maxvalue=temp.data;
            }
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }
        System.out.println();
        System.out.println(maxvalue+"  max value ");
    }

    public void findMax(){
        // for max value go through any traversal method Eg done in level order traversal
    }

    public static void main(String[] args) {
        Tree binaryTree=new Tree();
        binaryTree.createBinaryTree();
        // binaryTree.preOrder(binaryTree.root);
        // System.out.println();
        // binaryTree.stackPreOrder(); 

        // binaryTree.inOrder(binaryTree.root);
        // System.out.println();
        // binaryTree.stackInOrder();

        // binaryTree.postOrder(binaryTree.root);
        // System.out.println();
        // binaryTree.stackPostOrder();

        binaryTree.levelOrderTraversal();

        // for max value go through any traversal method Eg done in level order traversal


    }
}