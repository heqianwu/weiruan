import java.util.LinkedList;
import java.util.Queue;



public class Game {
	
	
	public Result playOldGame(String s){
		int[][] gongge=new int[3][3];
		String[] str=s.split(",");
		boolean dan=true;
		for(int i=0;i<str.length;i++){
			int a,b;
			b=str[i].charAt(0)-'A';
			a=str[i].charAt(1)-'1';
			if(gongge[a][b]==1||gongge[a][b]==4)
				return Result.DRAW;
			if(dan==true){
				gongge[a][b]=1;
				dan=false;
			}
			else{
				gongge[a][b]=4;
				dan=true;
			}
			show(gongge);
		}
		if(str.length>9||str.length<5)
			return Result.DRAW;
//		for(int i=0;i<3;i++){
//			if(gongge[i][0]+gongge[i][0]+gongge[i][0]==3){
//				return Result.X_WIN;
//			}
//			if(gongge[i][0]+gongge[i][0]+gongge[i][0]==12){
//				return Result.O_WIN;
//			}
//			if(gongge[0][i]+gongge[1][i]+gongge[2][i]==12){
//				return Result.O_WIN;
//			}
//			if(gongge[0][i]+gongge[1][i]+gongge[2][i]==3){
//				return Result.X_WIN;
//			}
//		}
//		if(gongge[0][0]+gongge[1][1]+gongge[2][2]==3){
//			return Result.X_WIN;
//		}
//		if(gongge[0][0]+gongge[1][1]+gongge[2][2]==12){
//			return Result.O_WIN;
//		}
//		if(gongge[0][2]+gongge[1][1]+gongge[2][0]==3){
//			return Result.X_WIN;
//		}
//		if(gongge[0][2]+gongge[1][1]+gongge[2][0]==12){
//			return Result.O_WIN;
//		}
		return judge(gongge);
	}
	
	public static Result judge(int[][] gongge){
		for(int i=0;i<3;i++){
			if(gongge[i][0]+gongge[i][0]+gongge[i][0]==3){
				return Result.X_WIN;
			}
			if(gongge[i][0]+gongge[i][0]+gongge[i][0]==12){
				return Result.O_WIN;
			}
			if(gongge[0][i]+gongge[1][i]+gongge[2][i]==12){
				return Result.O_WIN;
			}
			if(gongge[0][i]+gongge[1][i]+gongge[2][i]==3){
				return Result.X_WIN;
			}
		}
		if(gongge[0][0]+gongge[1][1]+gongge[2][2]==3){
			return Result.X_WIN;
		}
		if(gongge[0][0]+gongge[1][1]+gongge[2][2]==12){
			return Result.O_WIN;
		}
		if(gongge[0][2]+gongge[1][1]+gongge[2][0]==3){
			return Result.X_WIN;
		}
		if(gongge[0][2]+gongge[1][1]+gongge[2][0]==12){
			return Result.O_WIN;
		}
		return Result.DRAW;
	}
	
	public static void show(int[][] gong){

		System.out.println("  A B C");
		for(int k=0;k<3;k++){
			System.out.print(k+1+" ");
			for(int j=0;j<3;j++){
			   if(gong[k][j]==1)
				   System.out.print("X");
			   else if(gong[k][j]==4)
				   System.out.print("O");
			   else 
				   System.out.print("_");
			   if(j!=2)
				   System.out.print(" ");
			}

			System.out.println();
		}
	}
	
	public Result playNewGame(String s){
		
		int[][] gongge=new int[3][3];
		Queue<Integer> queue=new LinkedList<Integer>(); 
		String[] str=s.split(",");
		boolean dan=true;
		int h=0;
		for(int i=0;i<str.length;i++){
			int a,b;
			b=str[i].charAt(0)-'A';
			a=str[i].charAt(1)-'1';
			if(gongge[a][b]!=0)
				return Result.DRAW;
			if(dan==true){
				gongge[a][b]=1;
				dan=false;
			}
			else{
				gongge[a][b]=4;
				dan=true;
			}
			queue.add(a*3+b);
			if(queue.size()==7){
				int f=queue.poll();
				gongge[f/3][f%3]=0;
			}
			show(gongge);
		}
		
		for(int i=0;i<3;i++){
			if(gongge[i][0]+gongge[i][0]+gongge[i][0]==3){
				return Result.X_WIN;
			}
			if(gongge[i][0]+gongge[i][0]+gongge[i][0]==12){
				return Result.O_WIN;
			}
			if(gongge[0][i]+gongge[1][i]+gongge[2][i]==12){
				return Result.O_WIN;
			}
			if(gongge[0][i]+gongge[1][i]+gongge[2][i]==3){
				return Result.X_WIN;
			}
		}
		if(gongge[0][0]+gongge[1][1]+gongge[2][2]==3){
			return Result.X_WIN;
		}
		if(gongge[0][0]+gongge[1][1]+gongge[2][2]==12){
			return Result.O_WIN;
		}
		if(gongge[0][2]+gongge[1][1]+gongge[2][0]==3){
			return Result.X_WIN;
		}
		if(gongge[0][2]+gongge[1][1]+gongge[2][0]==12){
			return Result.O_WIN;
		}
		return Result.DRAW;
	}
	
	public static void main(String[] args){
		Game game=new Game();
		Result result=game.playOldGame("A1,B1,B2,B3,C3");
		System.out.println(result);
		Result re=game.playNewGame("A1,B1,B2,B3,C3");
		System.out.println(re);
	}

}
