package sort;

/**

* @author: bingo 
* @date:   2018��12��19��
*/

public class SelectionSort
{
    public void sort(Comparable[] a)
    {
        int lenght = a.length;  //���鳤��
        for(int i = 0; i < lenght; i++)
        {
            int min = i; //��СԪ�ص�����
            for(int j = i+1; j < lenght; j++)
            {
                if(less(a[j], a[min]))  //�ж�a[i]��a[j]��С��ϵ
                {
                    min = j;
                }
            }
            swap(a, i, min);  //����a[i]��a[min]
        }
    }
    
    public boolean less(Comparable a, Comparable b)
    {
        // a < b����True
        return a.compareTo(b) < 0;
    }
    
    public void swap(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

