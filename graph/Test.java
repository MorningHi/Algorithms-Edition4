package graph;

import java.util.Arrays;

/**
* @author: Rezero
* @createDate��2019��8��18��
*/
public class Test {

    public static void main(String[] args) throws Exception {
        int V = 6;
        char[] cArr= {'A', 'S', 'D', 'F', 'Z', 'X'};
        
        Graph G = new Graph(V);     // ����һ���а˸������ͼ
        for(char c : cArr){
            G.addVertex(c);
        }
        
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 5);
        G.addEdge(1, 2);
        //G.addEdge(2, 3);
        G.addEdge(2, 4);
        G.addEdge(3, 4);
        G.addEdge(3, 5);
        
//        for(int i : G.adj(3)){
//            System.out.println(i);
//        }
        G.BFS(3);
    }

}
