import java.util.*;

import javax.swing.JOptionPane;
public class DijkstraClass {
	
	public static Vector<Vector<Integer>> adj = new Vector<Vector<Integer>>();
	
	public static void main(String ar[]) {
		createCostMatrix();
	}
	
	private static void createCostMatrix() {
		int[][] costMatrix = new int[32][32];
		for(int i=0; i<31; i++) {
			if((i+1)%8==0) {
				for(int j=0; j<31; j++) {
					if(j==i+8) {
						costMatrix[i][j] = 1;
					} else {
						costMatrix[i][j] = 0;
					}
				}
			} else if(i>=24 && i<31) {
				for(int j=0; j<31; j++) {
					if(j==i+1) {
						costMatrix[i][j] = 1;
					} else {
						costMatrix[i][j] = 0;
					}
				}
			} else {
				for(int j=0; j<31; j++) {
					if(j==i+1 || j==i+8) {
						costMatrix[i][j] = 1;
					} else {
						costMatrix[i][j] = 0;
					}
				}
			}
		}
	}
	
	public static boolean obstaclecVectorContain(int vertex) {
		for(int i=0; i<DijkstraUI.obstacles.size(); i++) {
			if(vertex == DijkstraUI.obstacles.get(i)) {
				return true;
			}
		}
		return false;
	}
}
