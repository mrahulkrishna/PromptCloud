
import java.io.*;

import java.util.*;;
public class ball_puzzle
{
  public static void main(String[] args) throws Exception
  {
	  Scanner sc;
	  try
	  {  
		int n=0;
		int i=0;
	    int p=0;
	   String aa[] = new String[n];
		sc=  new Scanner(new File("input.txt"));  
		 while(sc.hasNext())
		 {
			String a = sc.next();
	        if(i==0)
	        {
	          n = Integer.parseInt(a);
	          i++;
	        }
	        else if(i==1)
	        {
	          aa = a.split(",");
	          i++;
	        }
	        else
	       	p= Integer.parseInt(a);
		 }
		 int k[] = new int[n];
		 for(int j=0;j<n;j++)
			 k[j] = Integer.parseInt(aa[j]);
		 ball_puzzle b = new ball_puzzle();
		 b.sort(k, 0, k.length-1);
		int diff = k[0+p-1]-k[0];
		int startingindex = 0;
		for(int j=0;j<=n-p;j++)
		{if(diff>k[j+p-1]-k[j])
			{diff = k[j+p-1]-k[j];
				startingindex = j;
			}
		}
		
		
		
		String output="";
		for(int j=startingindex;j<startingindex+p;j++)
		{
			if(j==(startingindex+p-1))
				output += String.valueOf(k[j]);
			else
			{
				output += String.valueOf(k[j]);
				output +=String.valueOf(",");
			}
		}
		//System.out.println(output);
		
		PrintWriter writer = new PrintWriter("output.txt");
		writer.println(output);
		writer.close();
		
	  }
	  catch (Exception e) 
	  {
		System.out.println("Exception");
	  }
	  }
  void merge(int arr[], int l, int m, int r)
  {
      int n1 = m - l + 1;
      int n2 = r - m;
      int L[] = new int [n1];
      int R[] = new int [n2];
      
      for (int i=0; i<n1; ++i)
          L[i] = arr[l + i];
      for (int j=0; j<n2; ++j)
          R[j] = arr[m + 1+ j];
      
      int i = 0, j = 0;
      int k = l;
      while (i < n1 && j < n2)
      {
          if (L[i] <= R[j])
          {
              arr[k] = L[i];
              i++;
          }
          else
          {
              arr[k] = R[j];
              j++;
          }
          k++;
      }
      
      while (i < n1)
      {
          arr[k] = L[i];
          i++;
          k++;
      }
      
      while (j < n2)
      {
          arr[k] = R[j];
          j++;
          k++;
      }
  }
  
  void sort(int arr[], int l, int r)
  {
      if (l < r)
      {
          int m = (l+r)/2; 
          sort(arr, l, m);
          sort(arr , m+1, r);
          merge(arr, l, m, r);
      }
  }
}