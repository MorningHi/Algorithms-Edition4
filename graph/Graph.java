package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
* @author: Rezero
* @createDate��2019��8��18��
* 
* ����ͼ�����ݽṹ
*/
public class Graph {

    private final int V;       // �ܶ�����
    private int E;             // ����
    private Vertex[] vertexList;    // �洢���������
    public ArrayList<Integer>[] adj;     // �ڽӱ�
    private int currentV;      // �Ѿ���ʼ���Ķ�����
    
    // ������
    private class Vertex{
        private char label;
        private boolean Visited;     // �Ƿ񱻷��ʹ�
        
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
        adj = (ArrayList<Integer>[]) new ArrayList[V];    // �����ڽӱ�
        for(int v = 0; v < V; v++){                         // ���������ʼ��Ϊ��
            adj[v] = new ArrayList<Integer>();
        }
    }
    
    public int V(){
        return currentV;
    }
    public int E(){
        return E;
    }
    
    // ��ͼ����Ӷ���
    public void addVertex(char label) throws Exception{
        if(currentV == V){            // ���ж��㶼�Ѿ�����ֵ
            throw new Exception("Cannot add vertices because all vertices have been initialized!");
        }
        vertexList[currentV++] = new Vertex(label);    // �����µĶ�����ӵ�ͼ
    }
    
    // ��ͼ����ӱ�
    public void addEdge(int v1, int v2) throws Exception{
        if(v1 >= currentV || v2 >= currentV){
            throw new Exception("Vertex doesn't exist");
        }
        if(v1 == v2) return;   // �Լ����Լ������Ӳ�����ӵ��ڽӱ�
        adj[v1].add(v2);      // ��v2��ӵ�v1��������
        adj[v2].add(v1);      // ��v1��ӵ�v2��������
        E++;
    }
    
    public Iterable<Integer> adj(int v){   // ʹ���ڽӱ�ɵ���
        return adj[v];
    }
    
    // �����������
    public void DFS(int end){
        // Ĭ����������ʼ����Ϊ��һ������
         DFS(0, end);
    }
    public void DFS(int start, int end){
        Stack<Integer> stack = new Stack<>();    
        ArrayList<Integer> path = new ArrayList<>();     // ʹ������洢·��
        
        vertexList[start].Visited = true;    // ��start��ʼ����
        path.add(start);
        stack.push(start);  
        
        while(!stack.isEmpty() && stack.peek() != end){
            // �ҵ���ջ�������ڽ���δ�����ʵĶ���
            int v = getAdjUnvisitedVertex(stack.peek());
            if(v == -1){
                stack.pop();   // ��ǰ����������ڽӶ��㶼�ѱ����ʣ������ջ
                path.remove(path.size()-1);    // ��ǰ�����޷�����end,��·�����Ƴ�
            }
            else{
                vertexList[v].Visited = true;
                path.add(v);
                stack.push(v);
            }
        }
        System.out.println(Arrays.toString(path.toArray()));

        for(Vertex v : vertexList){    // һ���������֮���������ж���ķ��ʱ��
            v.Visited = false;
        }
    }
    
    // �����������
    public void BFS(int end){
        BFS(0, end);
    }
    public void BFS(int start, int end){
        Queue<Integer> queue = new LinkedList<Integer>();  
        ArrayList<Integer> path = new ArrayList<>();     // ʹ������洢·��
        
        vertexList[start].Visited = true;    // ��start��ʼ����
        path.add(start);
        queue.add(start);
        
        while(!queue.isEmpty()){
            int v = queue.remove();   // ��ȡ��ͷ�Ķ���
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
        
        for(Vertex v : vertexList){    // һ���������֮���������ж���ķ��ʱ��
            v.Visited = false;
        }
    }
    
    // ������v������δ�����ʹ��Ķ��㣬�������򷵻�-1 
    private int getAdjUnvisitedVertex(int v){
        for(int x : adj(v)){
            if(!vertexList[x].Visited){
                return x;
            }
        }
        return -1;
    }
}
