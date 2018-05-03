import java.util.*;

public class TSPAlgorithm {
	
	public static int nodes;
	public static int cost[][] = new int[10][10];
	public static int dp[][] = new int[1024][10];
	public static int v[][] = new int[1024][10];
	
	public static void main(String ar[]) {
		
	}
	
	public TSPAlgorithm(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of nodes");
		nodes = scanner.nextInt();
		
		for(int i=0; i<(1<<nodes); i++) {
			for(int j=0; j<nodes; j++) {
				dp[i][j] = -1;
				v[i][j] = -1;
			}
		}
		
		for(int i=0; i<nodes; i++) {
			for(int j=0; j<nodes; j++) {
				cost[i][j] = scanner.nextInt();
			}
		}
		
		int k = tsp(1,0);
		
		System.out.println(k);
		
		System.out.print("1->");
		
		int m=1, city=0;
		int u;
		while(m != (1<<nodes)-1) {
			u = v[m][city];
			System.out.print(u+1+ "->");
			m = m|(1<<u);
			city = u;
		}
		
		System.out.println("1");
	}
	
	public static int tsp(int mask, int pos) {
		if(mask == (1<<nodes)-1)
	    {
	        if(cost[pos][0] != 0)
	            return cost[pos][0];
	        else
	            return 999;
	    }
		
		if(dp[mask][pos] != -1)
	        return dp[mask][pos];

	    int ans,newans;
	    ans = 999;
	    
	    for(int city=0;city<nodes;city++)
	    {
	        if((mask&(1<<city))==0 && cost[pos][city]!=0)
	        {
	            newans = cost[pos][city] + tsp(mask|(1<<city),city);
	            if(newans < ans)
	            {
	                ans = newans;
	                v[mask][pos] = city;
	            }
	        }
	    }
	    
	    return dp[mask][pos] = ans;
	}

}
