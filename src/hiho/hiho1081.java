package hiho;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class hiho1081 {
	static int[][] map;
	static Scanner cin;
	static int n,m,s,t;
	static HashSet<Integer> set;
	
	public static void main(String[] args){
		init();
		int dp[]=new int[n+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		for(int i=1;i<=n;i++){
			dp[i]=getDistance(s,i);
		}
		set.remove(s);
		for(int i=1;i<n;i++){
			int idx=getMinIndex(dp);
			if(idx==t)
				break;
			set.remove(idx);
			for(int k:set){
				int dis=getDistance(idx,k);
				if(dis==Integer.MAX_VALUE){
					continue;
				}
				dp[k]=Math.min(dis+dp[idx],dp[k]);
			}
		}
		System.out.println(dp[t]);
	}
	
	public static int getDistance(int i,int j){
		return Math.min(map[i][j], map[j][i]);
	}
	
	public static int getMinIndex(int[] a){
		int minIndex=-1;
		int curMinValue=Integer.MAX_VALUE;
		for(int i:set){
			if(a[i]<curMinValue){
				curMinValue=a[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	
	public static void init(){
		cin=new Scanner(System.in);
		n=cin.nextInt();
		m=cin.nextInt();
		s=cin.nextInt();
		t=cin.nextInt();
		map=new int[n+1][n+1];
		set=new HashSet<Integer>();
		for(int i=1;i<n+1;++i){
			Arrays.fill(map[i], Integer.MAX_VALUE);
			set.add(i);
		}
		for(int i=0;i<m;i++){
			int t1=cin.nextInt();
			int t2=cin.nextInt();
			int len=cin.nextInt();
			map[t1][t2]=Math.min(map[t1][t2], len);
		}
	}
	
}