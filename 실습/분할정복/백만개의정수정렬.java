import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    static int N = 1000000;
	static int[] A = new int[N];
	static int[] tmp = new int[N];
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nums = br.readLine();
		StringTokenizer st = new StringTokenizer(nums);
		
		
		for(int i=0 ; i<N ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0, N-1);
		
		System.out.println(A[500000]);
	}
    
    private static void mergeSort(int left, int right) {
		
		if(left < right) {
			int mid = (left+right)/2;
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			merge(left, mid, right);
			
		}
		
		
	}

	private static void merge(int left, int mid, int right) {
		
		int L = left;
		int R = mid+1;
		int idx = left;
		
		while(L <= mid && R <= right) {
			if(A[L] <= A[R]) {
				tmp[idx++] = A[L++];
			}else {
				tmp[idx++] = A[R++];
			}
		}
		
		while(L <= mid) {
			tmp[idx++] = A[L++];
		}
		while(R <= right) {
			tmp[idx++] = A[R++];
		}
		
		for(int i=left ; i<=right ; i++) {
			A[i] = tmp[i];
		}
		
	}
}
