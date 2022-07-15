package programmingForDevelopers.o_Tree;

import java.util.Arrays;

public class MST {
    Edge edges[];
    int vertices;
    MST(int vertices){
        this.vertices=vertices;
        edges=new Edge[vertices];
    }

    public static class Edge implements  Comparable<Edge>{
        int u;
        int v;
        int w;
        Edge(int u,int v, int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }

        @Override
        public int compareTo(Edge o) {
            return  this.w-o.w;
        }
    }
    int edgeindx=-1;
    void addEdge(int u, int v, int w){
        edges[++edgeindx]=new Edge(u,v,w);

    }

    void minimumspanningtree(){
        Arrays.sort(edges);
        int edgeTaken=1;
        int edgeCounter=-1;

        int parent[]=new int[vertices];
        int size[]=new int[vertices];
        for(int i=0;i<vertices;i++){
            parent[i]=-1;
        }

        int mstgraph[][]=new int[vertices][vertices];
        //Edge mstgraph[]=new Edge[vertices];

        while(edgeTaken<=vertices-1){
           Edge e=edges[++edgeCounter];
           if(find(e.u,parent,size)==find(e.v,parent,size)){
               continue;
           }
            mstgraph[e.u][e.v]=e.w;
            mstgraph[e.v][e.w]=e.w;
            //mstindx=-1;
            //mstgraph[++mstindex]=e;
            union(e.u,e.v,parent,size);
            edgeTaken++;
        }

    }

    public void union(int u, int v,int [] parent, int size[]){
        if(size[u]>size[v]){
            parent[v]=u;
        }
        else if(size[u]<size[v]){
            parent[u]=v;
        }
        else{
            parent[v]=u;
            size[u]++;
        }
    }

    public int find(int u,int [] parent, int size[]){
        if(parent[u]==-1){
            return u;
        }
        return parent[u]=find(parent[u],parent,size);
    }


}
