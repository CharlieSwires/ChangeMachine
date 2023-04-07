import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ChangeMachine {

	static final int[] coins = {5000, 2000, 1000, 500, 200,100,50,20,10,5,2,1};
	public List<Integer> change(int i) {
		return change(false, toList(coins), i);
	}

	public List<Integer> change(List<Integer> c, int i) {
		return change(true, c, i);
	}

	public List<Integer> change(boolean remove, List<Integer> c, int i) {
		ArrayList<Integer> coins = new ArrayList<Integer>();
		coins.addAll(c);
		coins.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				//descending order
				return o2.compareTo(o1);

			}
		}
				);
		int left = i;
		ArrayList<Integer> changeList = new ArrayList<>();
		int index = 0;
		for(; index < coins.size(); ) {
			int coin = coins.get(index);
			if(coin <= left) {
				left -= coin;
				if (remove) coins.remove(index);
				changeList.add(coin);
			} else {
				index++;
			}
		}
		if(left != 0) {
			StringBuilder sb = new StringBuilder();
			int ii = 0;
			for(Integer item: changeList) {
				if (ii++==0) {
					sb.append(item);
				}else {
					sb.append(","+item);
				}
			}
			throw new RuntimeException(sb.toString());
		}

		return changeList;
	}
	static List<Integer> toList(int[] array){
		ArrayList<Integer> arrayList = new ArrayList<>();
		for(Integer i:array) {
			arrayList.add(i);
		}
		return (List<Integer>)arrayList;
	}
	Boolean[] included = null;
	Boolean[] includedResult = null;

	public List<Integer> changeRecursive(List<Integer> c, int i) {
		ArrayList<Integer> coins = new ArrayList<Integer>();
		coins.addAll(c);
		coins.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				//descending order
				return o2.compareTo(o1);

			}
		});

		included = new Boolean[coins.size()];
		includedResult = new Boolean[coins.size()];
		for(int ii = 0; ii < included.length; ii++) {
			included[ii] = true;
			includedResult[ii] = true;
		}
		int result =  btree(0, coins, i);
		System.out.println("result="+result);
		List<Integer> result2 = new ArrayList<>();
		int j = 0;
		for(Boolean inout: includedResult) {
			if (inout)result2.add(coins.get(j));
			j++;
		}
		System.out.println("result2="+result2);
		return result2;
	}
	int sum2 = 0;
	int btree(int depth, List<Integer> c, int i){
		System.out.print("depth="+depth+" i="+i);

		int sum = 0;
		for(int ii = 0; ii <= depth; ii++) {
			sum += c.get(ii)*(included[ii]?1:0);
		}
		System.out.println(" sum="+sum);
//		if (!done) {

			if (depth >= (included.length -1)) return sum;
			if (depth >= 1 && sum > i && included[depth-1] && (c.get(depth-1) + c.get(depth)) > i){
				included[depth-1] = false;
				btree(depth-1, c, i);
				sum -= c.get(depth-1);
			}
			if (sum > i && included[depth]){
				included[depth] = false;
				btree(depth, c, i);
				sum -= c.get(depth);
			}
			sum2 = btree(depth+1, c, i);
			if (sum2 == i) {
				for(int ii = 0; ii < included.length; ii++) {
					includedResult[ii] = included[ii];
				}
				System.out.println(Arrays.toString(includedResult));
				return sum;
			} 

//		}
		return sum;

	}
}