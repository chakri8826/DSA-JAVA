import java.util.ArrayList;

public class A9Intersection {
    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m){
		int i=0,j=0;
		ArrayList<Integer> res = new ArrayList<>();
		while(i<n && j<m){
			if(arr1.get(i).equals(arr2.get(j))) {
				res.add(arr1.get(i));
				i++;
				j++;
			}
			else if(arr1.get(i)<arr2.get(j)){
				i++;
			}
			else{
				j++;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		arr1.add(1);
		arr1.add(2);
		arr1.add(3);
		arr1.add(4);
		arr1.add(5);
		arr2.add(3);
		arr2.add(4);
		arr2.add(5);
		arr2.add(6);
		arr2.add(7);
		System.out.println(findArrayIntersection(arr1, arr1.size(), arr2, arr2.size()));
	}
}



