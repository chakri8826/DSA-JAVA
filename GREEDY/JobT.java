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



	// NO EXTRA CLASS FOR SORTING 
	public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        ArrayList<int[]> jobs = new ArrayList<>();
        for(int i=0;i<id.length;i++){
            jobs.add(new int[]{id[i],deadline[i],profit[i]});
        }
        Collections.sort(jobs,(a,b)->Integer.compare(b[2],a[2]));
        int cnt=0,prof=0;
        
        int maxDeadline = 0;
        for (int i = 0; i < jobs.size(); i++) {
            maxDeadline = Math.max(maxDeadline, jobs.get(i)[1]);
        }
        
        Boolean check[] = new Boolean[maxDeadline];
        for(int i=0;i<jobs.size();i++){
            // ZERO BASED WE ARE TAKING
            for(int j=jobs.get(i)[1]-1;j>=0;j--){
                if(check[j]==null){
                    prof+=jobs.get(i)[2];
                    cnt++;
                    check[j]=true;
                    break;
                }
            }
        }
        
        ArrayList<Integer> li = new ArrayList<>();
        li.add(cnt);
        li.add(prof);
        return li;
        
    }
    public static void main(String[] args) {
        JobT arr[] ={new JobT('a', 3, 35),
                    new JobT('b', 4, 30),
                    new JobT('c', 4, 25),
                    new JobT('d', 2, 20),
                    new JobT('e', 3, 15), 
                    new JobT('e', 1, 12), 
                    new JobT('e', 2, 5) 
                	};
        int t=7;
        printJobScheduling(arr,t);
    }
}

