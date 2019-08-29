package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
* @author: Rezero
* @createDate：2019年8月18日
* 
* 无向图的数据结构
*/
public class Graph {

    private final int V;       // 总顶点数
    private int E;             // 边数
    private Vertex[] vertexList;    // 存储顶点的数组
    public ArrayList<Integer>[] adj;     // 邻接表
    private int currentV;      // 已经初始化的顶点数
    
    // 顶点类
    private class Vertex{
        private char label;
        private boolean Visited;     // 是否被访问过
        
        public Vertex(char label){
            this.label = label;
            this.Visited = false;
        }
    }
    
    public Graph(int V){
        this.V = V;
        this.E = 0;
        this.vertexList = new Vertex[V];
        this.currentV = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[V];    // 创建邻接表
        for(int v = 0; v < V; v++){                         // 所有链表初始化为空
            adj[v] = new ArrayList<Integer>();
        }
    }
    
    public int V(){
        return currentV;
    }
    public int E(){
        return E;
    }
    
    // 向图中添加顶点
    public void addVertex(char label) throws Exception{
        if(currentV == V){            // 所有顶点都已经被赋值
            throw new Exception("Cannot add vertices because all vertices have been initialized!");
        }
        vertexList[currentV++] = new Vertex(label);    // 否则将新的顶点添加到图
    }
    
    // 向图中添加边
    public void addEdge(int v1, int v2) throws Exception{
        if(v1 >= currentV || v2 >= currentV){
            throw new Exception("Vertex doesn't exist");
        }
        if(v1 == v2) return;   // 自己到自己的链接不用添加到邻接表
        adj[v1].add(v2);      // 将v2添加到v1的链表中
        adj[v2].add(v1);      // 将v1添加到v2的链表中
        E++;
    }
    
    public Iterable<Integer> adj(int v){   // 使得邻接表可迭代
        return adj[v];
    }
    
    // 深度优先搜索
    public void DFS(int end){
        // 默认搜索的起始顶点为第一个顶点
         DFS(0, end);
    }
    public void DFS(int start, int end){
        Stack<Integer> stack = new Stack<>();    
        ArrayList<Integer> path = new ArrayList<>();     // 使用链表存储路径
        
        vertexList[start].Visited = true;    // 从start开始遍历
        path.add(start);
        stack.push(start);  
        
        while(!stack.isEmpty() && stack.peek() != end){
            // 找到与栈顶顶点邻接且未被访问的顶点
            int v = getAdjUnvisitedVertex(stack.peek());
            if(v == -1){
                stack.pop();   // 当前顶点的所有邻接顶点都已被访问，将其出栈
                path.remove(path.size()-1);    // 当前顶点无法到达end,从路径中移除
            }
            else{
                vertexList[v].Visited = true;
                path.add(v);
                stack.push(v);
            }
        }
        System.out.println(Arrays.toString(path.toArray()));

        for(Vertex v : vertexList){    // 一次搜索完毕之后重置所有顶点的访问标记
            v.Visited = false;
        }
    }
    
    // 广度优先搜索
    public void BFS(int end){
        BFS(0, end);
    }
    public void BFS(int start, int end){
        Queue<Integer> queue = new LinkedList<Integer>();  
        ArrayList<Integer> path = new ArrayList<>();     // 使用链表存储路径
        
        vertexList[start].Visited = true;    // 从start开始遍历
        path.add(start);
        queue.add(start);
        
        while(!queue.isEmpty()){
            int v = queue.remove();   // 获取队头的顶点
            for(int x : adj(v)){
                if(!vertexList[x].Visited){
                    vertexList[x].Visited = true;
                    queue.add(x);
                    System.out.println(x);
                }
                if(x == end)  break;
            }
            if(v == end)  break;
        }
        
        for(Vertex v : vertexList){    // 一次搜索完毕之后重置所有顶点的访问标记
            v.Visited = false;
        }
    }
    
    // 返回与v相邻且未被访问过的顶点，不存在则返回-1 
    private int getAdjUnvisitedVertex(int v){
        for(int x : adj(v)){
            if(!vertexList[x].Visited){
                return x;
            }
        }
        return -1;
    }
}
