package test.zhaoyin._0906;

import java.util.*;

public class _02 {

    static boolean flag = false;
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        Set<Integer>[] graph = new HashSet[n];
        for(int i = 0; i < n; i++){
            graph[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
                if(matrix[i][j] == 1){
                    graph[i].add(j);
                }
            }
        }
        int start = sc.nextInt();
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n];
        dfs(graph,start, sb, res, visited, start);
        for(int i = 0; i < res.size(); i++){
            String s = res.get(i);
            System.out.println(s.substring(s.length()-1)+s.substring(0,s.length()-1));
        }
    }


    private static void dfs(Set<Integer>[] graph, int k, StringBuilder sb, List<String> res, boolean[] visited, int start) {

        if(visited[k] && k == start){
            res.add(new String(sb.toString()));
            return;
        }
        for(int num : graph[k]){
            if(visited[num]){
                continue;
            }
            sb.append(num+"");
            visited[num] = true;
            dfs(graph,num,sb,res,visited,start);
            sb.deleteCharAt(sb.length()-1);
            visited[num] = false;
        }

    }
}
