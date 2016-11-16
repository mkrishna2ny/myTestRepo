import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DeDup {
	public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};

	public static void main(String [] args) {
		DeDup dup = new DeDup();
		int[] method1 = dup.eleminateDuplicates();
		dup.print(method1);
		System.out.println();
		int[] method2 = dup.eleminateDuplicatesUsingHashSet();
		dup.print(method2);
		System.out.println();
		int[] method3 = dup.eleminateDuplicatesUsingSortAndCompare();
		dup.print(method3);
	}
		
	public int[] eleminateDuplicates() {
		int[] tempArr = new int[randomIntegers.length];
		int size = 0;
		for (int i = 0; i < randomIntegers.length; i++) { 
			if(checknotExists(tempArr,randomIntegers[i])){
				tempArr[size]=randomIntegers[i];
				size++;
			}
		}
		return tempArr;
	}

	private boolean checknotExists(int[] tempArr, int element) {
		for (int i = 0; i < tempArr.length; i++) { 
			if(tempArr[i]==element){
				return false;
			}
		}
		return true;
	}
	
	private void print(int[] tempArr) {
		for (int i = 0; i < tempArr.length; i++) { 
			System.out.print(tempArr[i]);
			System.out.print(' ');
		}
		
	}
	
	public int[] eleminateDuplicatesUsingHashSet() {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < randomIntegers.length; i++) { 
			set.add(randomIntegers[i]);
		}
		int[] tempArr = new int[set.size()];
		int size=0;
		for(Integer ele:set){
			tempArr[size]=ele;
			size++;
		}
		return tempArr;
	}
	
	public int[] eleminateDuplicatesUsingSortAndCompare() {
		int[] tempArr = new int[randomIntegers.length];
		Arrays.sort(randomIntegers);
		int size = 1;
		int previous = randomIntegers[0];
        tempArr[0] = previous;
        for (int i = 1; i < randomIntegers.length; i++) {
            int ch = randomIntegers[i];

            if (previous != ch) {
                tempArr[size] = ch;
                size++;
            }
            previous = ch;
        }


		return tempArr;
	}
}