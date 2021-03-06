## 1.动态规划DP

官方定义：指把多个阶段过程转化为一系列单阶段的问题，利用各阶段之间的关系，逐个求解。

概念中各阶段之间的关系，其实指的就是状态转移方程。

**DP是一种解决问题的思想，思想本质一个规模比较大的问题，可以通过若干较小的问题的结果来得到。**

### 1.1.爬楼梯

#### 问题

假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？       
注意：给定 n 是一个正整数

#### 解析

`
输入：3   输出：3  解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

输入 4：- 5种方式
1.  1+1+1 +1
2.  1+1+2
3.  1+2+1
4.  2+1+1
5.  2+2

信息||||||
---|---|---|---|---|---|
台阶总数|1|2|3|4|5|6
方法总数|1|2|3|5|8|13
`

`
dp(n) = dp(n-1) + dp(n-2)
`

### 1.2.最大子序和

#### 问题

给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例：

`
输入: [-2,1,-3,4,-1,2,1,-5,4],

输出: 6

解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
`

#### 推导

- 1.如果得到dp[i],则 nums[i]一定会被选取，dp[i]与dp[i-1]相差一个 nums[i]
    - 即：dp[i]=dp[i-1] + nums[i], if(dp[i-1]>=0)
- 2.如果dp[i-1]为一个负数，dp[i]=dp[i-1]+nums[i]  反而会变小
    - 即：dp[i] = max(dp[i-1],num[i]) = nums[i] if(dp[i-1]<0)
- 3.dp[0] = nums[0]

最终答案： max(dp[0],dp[1],...,dp[i-1],dp[i])


### 1.3.三角形最小路径和 - 120

#### 问题

给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
`
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
`
最短路径 2 3 5 1

#### 推导

题目中给出的条件：每一步只能移动到下一行中相邻


- 1.第一个为 2 dp[0,0]
- 2.第二个为 3 或 4,这里为3 dp[1,0],dp[1,1]
- 3.第三个为 5 或 7,这里为5 dp[2,1],dp[2,2]

5这个位置的最小路径和，要么从 2-3-5 要么 2-4-5，取两条路径和中较小的一个即可。
dp[i][j] = min(dp[i-1][j-1],dp[i-1][j])+dp[i][j]


--

- 定义状态： dp[i][j] : 表示包含第i行j列元素的最小路径和
- 顶上元素： dp[0][0] = [0][0]位置所在的元素值
- 下一个预期为 dp[] = min(dp[i+1][j],dp[i+1,j+1])
- 状态转移方程：反推为 dp[i][j] = min(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j]
- 特殊处理 位于第2行的元素，都是特殊元素（因为都只能从[0,0]的元素走过来）
    dp[1,0] = triangle[1,0] + triangle[0,0]
    dp[1,1] = triangle[1,1] + triangle[0,0]
- 最终得到 我们只要找到最后一行元素中，路径和最小的一个 
    l：dp数组长度
  result = min(dp[l-1,0]，dp[l-1,1]，dp[l-1,2]....)








