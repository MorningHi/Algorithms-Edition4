package sort;

import java.util.Random;

/**

* @author: bingo 
* @date: 2018年12月19日
*/

public class Sort_main
{

    public static void main(String[] args)
    {
        int N = 100;
        Double[] arr = new Double[N];  //长度为N的Double类型随机数组
        Random rand = new Random();
        for(int i = 0; i < N; i++)
        {
            arr[i] = rand.nextDouble();
        }
        
        SelectionSort ss = new SelectionSort();
        ss.sort(arr);
        show(arr);

    }

    public static void show(Comparable[] a)
    {
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}

