
public class SubsetSumExample {
	
	public static boolean isSubsetSum(int set[], int n, int sum) {

		boolean[][] subset = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			subset[i][0] = true;
		}

		for (int i = 1; i <= n; i++) {
			
			for (int j = 1; j <= sum; j++) {
				
				if (set[i - 1] > j) {
					subset[i][j] = subset[i - 1][j];
				}
				else {
					subset[i][j] = subset[i - 1][j] || subset[i - 1][j - set[i - 1]];
				}
			}
		}
		
		return subset[n][sum];
	}

	public static void main(String[] args) {
		 
		int set[] = {3, 34, 4, 12, 5, 2}; 
	    int sum = 9; 
	    int n = set.length; 
	    if (isSubsetSum(set, n, sum) == true) 
	            System.out.println("Found a subset"
	                          + " with given sum"); 
	    else
	            System.out.println("No subset with"
	                               + " given sum"); 
	}
}
