package sort;

/**

* @author: bingo 
* @date:   2018年12月19日
*/

public class SelectionSort
{
    public void sort(Comparable[] a)
    {
        int lenght = a.length;  //数组长度
        for(int i = 0; i < lenght; i++)
        {
            int min = i; //最小元素的索引
            for(int j = i+1; j < lenght; j++)
            {
                if(less(a[j], a[min]))  //判断a[i]和a[j]大小关系
                {
                    min = j;
                }
            }
            swap(a, i, min);  //交换a[i]和a[min]
        }
    }
    
    public boolean less(Comparable a, Comparable b)
    {
        // a < b返回True
        return a.compareTo(b) < 0;
    }
    
    public void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

