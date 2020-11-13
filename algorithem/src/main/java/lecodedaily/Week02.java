package lecodedaily;

import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: pengLi
 * @create: 2020-10-26 17:46
 **/
public class Week02 {

    /**
     * 1365. 有多少小于当前数字的数字
     * @param nums
     * @return
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }
        int[] r = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j =0;
            Iterator iterator = priorityQueue.iterator();
            while (iterator.hasNext()) {
                if (nums[i] > (int)iterator.next()) {
                    j++;
                }
            }
            r[i] = j;
        }
        return r;
    }

    public static int longestMountain(int[] A) {
        if (A.length <= 3) {
            return 0;
        }
        int ans =0;
        int n = A.length;
        int left = 0;
        //+2 最小长度为3
        while (left + 2 < n) {
            int right = left +1;
            if (A[left] < A[left + 1]) {
                while (right + 1 < n && A[right] < A[right + 1]) {
                    //山脉增
                    ++right;
                }
                //山脉减
                if (right < n - 1 && A[right] > A[right + 1]) {
                    while (right + 1 < n && A[right + 1] < A[right]) {
                        ++right;
                    }
                    ans = Math.max(ans, right - left + 1);
                }else {
                    ++right;
                }
            }
            left = right;
        }
        return ans;
    }

    /**
     * 695 计算岛屿周长
     * 岛屿的周长就是岛屿方格和非岛屿方格相邻边的数量
     * 在DFS遍历中，从一个岛屿方格走向一个非岛屿方格，就将周长+1
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    //1个岛屿，从第一陆地格子开始即可
                    return dfs2(grid, r, c);
                }
            }
        }
        return 0;
    }

    public int dfs2(int[][] grid,int r,int c) {
        if (!(0<=r && r < grid.length && 0<=c && c < grid[r].length)) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        //2 已经遍历过
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return dfs2(grid, r - 1, c)
                + dfs2(grid, r + 1, c)
                + dfs2(grid, r, c - 1)
                + dfs2(grid, r, c + 1);
    }

    public void dfs(int[][] grid,int r ,int c ) {
        //判断坐标，不合法直接返回
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[r].length)) {
            return;
        }
        //方格不是岛屿，直接返回
        if (grid[r][c] != 1) {
            return;
        }
        //标记已遍历
        grid[r][c] = 2;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,1,2,2,3};
        int[] r = smallerNumbersThanCurrent(nums);
        System.out.println(JSONObject.toJSONString(r));

        String id = "60175402151184";
        System.out.println(id.hashCode() % 8);

        Week02 week02 = new Week02();
        int[][] grid = new int[1][1];
        grid[0][0] = 1;
        System.out.println(week02.islandPerimeter(grid));
    }
}
