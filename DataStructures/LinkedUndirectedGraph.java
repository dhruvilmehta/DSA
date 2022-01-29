
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LinkedUndirectedGraph {

    private LinkedList<Integer>[] adj;
    private int v; // number of vertices
    private int e; // number of edges(connections)

    public LinkedUndirectedGraph(int nodes){
        this.v=nodes;
        this.e=0;
        this.adj=new LinkedList[nodes];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<>();
        }
    }

    public void addEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);
        e++;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(v+" vertices "+e+" edges "+"\n");
        for(int i=0;i<v;i++){
            sb.append(i+": ");
            for(int w:adj[i]){
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void bfs(int s){
        boolean[] visited=new boolean[v];
        Queue<Integer> q=new LinkedList<>();
        visited[s]=true;
        q.offer(s);

        while(!q.isEmpty()){
            int u=q.poll();
            System.out.print(u+" ");
            for(int v:adj[u]){
                if(!visited[v]){
                    visited[v]=true;
                    q.offer(v);
                }
            }
        }
    }

    public void dfs(int s){
        boolean[] visited=new boolean[v];
        Stack<Integer> stack=new Stack<>();
        stack.push(s);
        visited[s]=true;
        while(!stack.isEmpty()){
            int u=stack.pop();
            System.out.print(u+" ");
            for(int v:adj[u]){
                if(!visited[v]){
                    visited[v]=true;
                    stack.push(v);
                }
            }
        }
    }

    public void recursivedfs(){
        /* In the iterative approach: You first insert all the elements into the stack - and then handle the head of the stack [which is the last node inserted] - thus the first node you handle is the last child.
        In the recursive approach: You handle each node when you see it. Thus the first node you handle is the first child. */
        boolean[] visited=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                recursivedfs(i,visited);
            }
        }
    }

    private void recursivedfs(int v,boolean[] visited){
        visited[v]=true;
        System.out.print(v+" ");
        for(int w:adj[v]){
            if(!visited[w]){
                recursivedfs(w,visited);
            }
        }
    }

    public static void main(String[] args) {
        LinkedUndirectedGraph graph=new LinkedUndirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.addEdge(2, 4);

        System.out.println(graph);
        // graph.bfs(0);
        // System.out.println();
        graph.dfs(0);
        System.out.println();
        graph.recursivedfs();

    }
}

