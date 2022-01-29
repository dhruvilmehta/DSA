

public class UndirectedGraph {
    int[][] adjmatrix;
    private int v; //number of vertices in graph
    private int e; //number of edges in graph

    public UndirectedGraph(int nodes){
        this.v=nodes;
        this.e=0;
        this.adjmatrix=new int[nodes][nodes];
    }

    public void addEdge(int u,int v){
        this.adjmatrix[u][v]=1;
        this.adjmatrix[v][u]=1;
        e++;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(v+" vertices, "+e+" edges "+"\n");
        for(int i=0;i<v;i++){
            sb.append(i+" : ");
            for(int w:adjmatrix[i]){
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        UndirectedGraph graph=new UndirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        System.out.println(graph); //compiler writes here s1.toString() for every object so we have overrided the toString function
    }
}
