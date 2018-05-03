import java.util.*; 
 
public class DijkstraUtils{
    public static Vector<Integer> path = new Vector<>();
 
    public static void main(String[] args) {
    	DijkstraUtils utils = new DijkstraUtils();
    }
    
    public DijkstraUtils() {
    	int[] preD = new int[32];
        int min = 999, nextNode = 0; 
        int[] distance = new int[32]; // the distance matrix
        int[][] costMatrix = new int[32][32]; // the actual matrix
        int[] visited = new int[32]; // the visited array
        
        for(int i=0; i<=31; i++) {
        	for(int j=0; j<=31; j++) {
        		costMatrix[i][j] = min;
        	}
        }
        
        for (int i = 0; i < distance.length; i++)
        {
            if(!DijkstraClass.obstaclecVectorContain(i)) {
            	visited[i] = 0; //initialize visited array to zeros
                preD[i] = 0;
     
                if((i+1)%8==0) {
    				for(int j=0; j<=31; j++) {
    					if(!DijkstraClass.obstaclecVectorContain(j)) {
    						if(j==i+8) {
        						costMatrix[i][j] = 1;
        					} else {
        						costMatrix[i][j] = min;
        					}
    					}
    				}
    			} else if(i>=24 && i<31) {
    				for(int j=0; j<=31; j++) {
    					if(!DijkstraClass.obstaclecVectorContain(j)) {
    						if(j==i+1) {
        						costMatrix[i][j] = 1;
        					} else {
        						costMatrix[i][j] = min;
        					}
    					}
    				}
    			} else {
    				for(int j=0; j<=31; j++) {
    					if(!DijkstraClass.obstaclecVectorContain(j)) {
    						if(j==i+1 || j==i+8) {
        						costMatrix[i][j] = 1;
        					} else {
        						costMatrix[i][j] = min;
        					}
    					}
    				}
    			}
            }
        }
 
        distance = costMatrix[0]; //initialize the distance array
        visited[DijkstraUI.startButtonLabel] = 1; //set the source node as visited
        distance[DijkstraUI.startButtonLabel] = 0; //set the distance from source to source to zero which is the starting point
 
        for (int counter = 0; counter < 32; counter++)
        {
            min = 999;
            for (int i = 0; i < 32; i++)
            {
                if (min > distance[i] && visited[i]!=1)
                {
                    min = distance[i];
                    nextNode = i;
                }
            }
 
            visited[nextNode] = 1;
            for (int i = 0; i < 32; i++)
            {
                if (visited[i]!=1)
                {
                    if (min+costMatrix[nextNode][i] < distance[i])
                    {
                        distance[i] = min+costMatrix[nextNode][i];
                        preD[i] = nextNode;
                    }
 
                }
 
            }
 
        }
 
        for(int i = 0; i < 32; i++)
            System.out.print("|" + distance[i]);
 
        System.out.println("|");
 
        int j;
        for (int i = 0; i < 32; i++)
        {
            if (i!=0 && i == DijkstraUI.endButtonLabel)
            {
 
                System.out.print("Path = " + i);
                j = i;
                do
                {
                    j = preD[j];
                    if(j!=0) {
                    	path.add(j);
                    }
                    System.out.print(" <- " + j);
                }
                while(j != 0);
            }
            System.out.println();
        }
    }
}