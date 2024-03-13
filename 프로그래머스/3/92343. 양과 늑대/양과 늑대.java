import java.util.*;

public class Solution {
	static int maxSheepCnt;
	static HashMap<Integer, ArrayList<Integer>> hm;
	
	public static void dfs(int currentIndex, int s, int w, ArrayList<Integer> indexList, int[] info) {
		
		if (info[currentIndex] == 0) {
			s += 1;
		} else {
			w += 1;
		}
		
		if (s <= w) return;
		
		maxSheepCnt = Math.max(maxSheepCnt, s);
		
		ArrayList<Integer> nextIndexList = new ArrayList<>();
		nextIndexList.addAll(indexList);
		
		if (hm.containsKey(currentIndex)) {
			nextIndexList.addAll(hm.get(currentIndex));
		}
		
		nextIndexList.remove(Integer.valueOf(currentIndex));
		
		for (int nextIndex : nextIndexList) {
			dfs(nextIndex, s, w, nextIndexList, info);
		}
		
		return;
	}
	
	public static int solution(int[] info, int[][] edges) {
		maxSheepCnt = 0;
		hm = new HashMap<>();
		
		for (int i = 0; i < edges.length; i++) {
			
			if (!hm.containsKey(edges[i][0])) {
				hm.put(edges[i][0], new ArrayList<>());
			}
			
			hm.get(edges[i][0]).add(edges[i][1]);
		}
		
//		hm : {0=[1, 8], 1=[2, 4], 4=[3, 6], 6=[5], 8=[7, 9], 9=[10, 11]}
		
		ArrayList<Integer> startIndexList = new ArrayList<>();
		startIndexList.add(0);
		
		dfs(0, 0, 0, startIndexList, info);
		
		return maxSheepCnt;
	}
}