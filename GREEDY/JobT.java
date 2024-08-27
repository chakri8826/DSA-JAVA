import java.util.*;
public class JobT implements Comparable<JobT>{
    char id;
	int deadline, profit;

    public JobT(char id, int deadline, int profit){
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}
    public int compareTo(JobT j){
        return j.profit-this.profit;
    }

    public static void  printJobScheduling(JobT[] arr,int t){
        Arrays.sort(arr);
        int n = arr.length;
        boolean result[] = new boolean[t];
		// To store result (Sequence of jobs)
		char job[] = new char[t];
		
		// Iterate through all given jobs
		for (int i = 0; i < n; i++) {
			// Find a free slot for this job (Note that we
			// start from the last possible slot)
			for (int j =  arr[i].deadline - 1;j >= 0; j--) {
				// Free slot found
				if (result[j] == false) {
					result[j] = true;
					job[j] = arr[i].id;
					break;
				}
			}
		}

		// Print the sequence
		for (char jb : job)
			System.out.print(jb + " ");
		System.out.println();

    }
    public static void main(String[] args) {
        JobT arr[] ={new JobT('a', 4, 50),
                    new JobT('b', 1, 5),
                    new JobT('c', 1, 20),
                    new JobT('d', 5, 10),
                    new JobT('e', 5, 80) 
                                     };
        int t=5;
        printJobScheduling(arr,t);
    }
}

