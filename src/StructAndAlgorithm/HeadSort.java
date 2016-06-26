package StructAndAlgorithm;

public class HeadSort {
	
	public static void main(String[] args){
		int[] kh={5,10,7,99,2,18,3,27,28,1,22};
		heapSort(kh,0,7);

	    for(int i=0;i<kh.length;i++){
	    	System.out.print(kh[i]+"  ");
	    	System.out.println();
	    }
	}

	public static void heapSort( int [ ] a, int low, int high)    //low,highÎªÏÂ±ê
	{  for(int i=low+(high-low+1)/2; i>=low; i--)
	    	    perDown(a, i, low, high); 
	    for(int i=high; i>low; i--)
	    {    swapReferences( a, low, i );  
	          perDown(a,low,low,i-1);
	    }
	}

	private static void swapReferences(int[] a, int k, int h) {
		int temp;
		temp=a[k];
		a[k]=a[h];
		a[h]=temp;
	}

	private static int leftchild(int i, int low)
	{     return (2*i+1-low);   //2*(i-low)+1+low
	}

	public static void perDown(int[] a, int i, int low, int high)
	{   int child;
	    int tmp;
	    for(tmp=a[i]; leftchild(i,low)<high+1; i=child) {
	    	  child = leftchild(i,low);
	         if(child!=high && a[ child ]<a[ child + 1 ])
	        	child++;
	    	  if(tmp< a[ child ])
	        	a[i]=a[child];
	    	  else
	        	break;
	    }
		 a[i]=tmp;
	 }
}
