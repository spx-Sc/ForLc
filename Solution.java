
import org.json.JSONArray;
import org.json.JSONException;

import java.util.*;

public class Solution {
    /*easy functions*/
    private static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result = result + Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    /* The defination of all data structure*/
    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int n) {
            val = n;
        }

        TreeNode(int n, TreeNode a, TreeNode b) {
            val = n;
            left = a;
            right = b;
        }


    }


    /* The end of defination*/

    /*
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o2.length() - o1.length();
                }
            }
        });

        for (String now : d) {
            int i = 0, j = 0;
            while (i < s.length() && j < now.length()) {
                if (s.charAt(i) == now.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if (j == now.length()) return now;
        }
        return "";
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i : nums) {
            int k = Math.abs(i) - 1;
            if (nums[k] > 0) {
                nums[k] = -nums[k];
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
    */


    //501
    /*
    int nowFrequency = 0;
    int nowVal;
    int numOfMods = 0;
    int maxFrequency = 1;
    int maxVal = 0;
    boolean writting = false;
    Set<Integer> ans1 = new HashSet<>();
    public int[] findMode(TreeNode root) {
        if(root==null) return new int[0];

        //start to in-order traversal;
        //count the number of modes
        nowVal = (root.val==0)?1:root.val-1;
        helper501(root);

        if(maxFrequency<nowFrequency){
            maxVal = nowVal;
            ans1.clear();
            ans1.add(maxVal);
        }

        if(maxFrequency==nowFrequency){
            ans1.add(nowVal);
        }

        int[] ans = new int[ans1.size()];
        int index = 0;
        for(int k : ans1){
            ans[index++] = k;
        }
        return ans;
    }

    private void helper501(TreeNode root){
        if(root==null) return;
        helper501(root.left);
        if(nowVal==root.val){
            nowFrequency++;
        }else{
            if(maxFrequency<nowFrequency){
                maxFrequency = nowFrequency;
                maxVal = nowVal;
//                numOfMods=1;
                ans1.clear();
                ans1.add(maxVal);
            }
            if(maxFrequency==nowFrequency){
//                numOfMods++;
                ans1.add(nowVal);
            }
            nowFrequency = 1;
            nowVal = root.val;
        }
        helper501(root.right);
    }

     */


    //530
    /*
    int minDiff = Integer.MAX_VALUE;
    int pre = 999;
    public int getMinimumDifference(TreeNode root) {
        helper530(root);
        return minDiff;
    }
    private void helper530(TreeNode root){
        if(root==null) return;
        helper530(root.left);
        if(Math.abs(pre-root.val)<minDiff){
            minDiff = Math.abs(pre-root.val);
        }
        pre = root.val;
        helper530(root.right);
    }

     */


    /*
    //538
    int pre = 0;
    int storeEqual = 0;
    public TreeNode convertBST(TreeNode root) {
        helper538(root);
        return root;
    }
    private void helper538(TreeNode root){
        if(root==null) return;
        helper538(root.right);
        root.val = root.val + pre;
        pre = root.val;
        helper538(root.left);
    }

     */

    /*
//543
    int maxDimm = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        helper(root, 1 );
        return maxDimm-1;
    }
    private int helper(TreeNode root,int ceng){
        if(root == null) return 0;
        int left = helper(root.left,ceng+1);
        int right = helper(root.right, ceng+1);
        maxDimm = Math.max(left+right+1,maxDimm);
        return Math.max(left,right)+1;
    }
     */

    /*557
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if(root==null) return 0;
        int max = 0;
        for(Node now : root.children){
            max = Math.max(max,maxDepth(now)+1);
        }
        return max;
    }

     */

    /*
//557
    public String reverseWords(String s) {
        if(s.length()==0) return s;
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(String now : words){
            ans.append((new StringBuilder(now).reverse().toString())+" ");
        }
        return ans.deleteCharAt(s.length()).toString();
    }

     */

/*
    //566
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int sum = 0;
        for(int[] now : nums){
            sum+=now.length;
        }
        if(r*c!=sum||nums==null) return nums;


        int[][] ans = new int[r][c];
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                ans[i][j] = nums[(i*c+j)/nums[0].length][(i*c+j)%nums[0].length];
            }
        }
        return ans;

    }

 */
/*
//572
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null&&t==null) return true;
        if(s==null&&t!=null) return false;

        return isSametree(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);


    }
    private boolean isSametree(TreeNode s, TreeNode t){
        if(s==null&&t==null) return true;
        if(s==null||t==null||s.val!=t.val) return false;
        return isSametree(s.left,t.left)&&isSametree(s.right,t.right);

    }

 */


/*
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }else return -1;
        }


        int left = 0;
        int right = nums.length - 1;
        while (left + 1 != right) {
            if (nums[(left + right) / 2] > nums[left]) {
                //question is the right side
                left = (left + right) / 2;
            } else {
                right = (left + right) / 2;
            }
        }
        int l,r;

        if(nums[left]>=nums[right]){
            if (target <= nums[left] && target >= nums[0]) {
                //we should find it in left part
                l = 0;
                r = left;
            } else {
                l = right;
                r = nums.length - 1;
            }
        }else {
            l = 0;
            r = nums.length - 1;
        }
        while (true) {
            if (nums[l] == target) {
                return l;
            }
            if (nums[r] == target) {
                return r;
            }

//            if (l + 1 == r && nums[l]!=target && nums[r]!=target) {
//                return -1;
//            }
            if (target > nums[(l + r) / 2]) {
                if(l ==(l + r) / 2)
                    return -1;
                l = (l + r) / 2;
            } else if (target < nums[(l + r) / 2]) {
                if(r ==(l + r) / 2)
                    return -1;
                r = (l + r) / 2;
            } else {
                //find it!
                return (l + r) / 2;
            }
        }
    }

 */


/*
    //34
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }
        //2-1 to find the ans
        int beg = 0;
        int end = nums.length-1;
        int index = 0;
        for (int i = 0; i < nums.length + 2; i++) {
            index = (beg + end) / 2;
            if (i == nums.length +1 ) {
                return new int[]{-1,-1};
            } else if (nums[index] > target) {
                end = index - 1;
            } else if (nums[index] < target) {
                beg = index + 1;
            } else {
                //we find it!
                break;
            }
        }

        //use 2-1 to determine the edge of target series.
        //left
        beg = 0;
        end = index;
        int leftEdge = -1;
        for (int i = 0; i < nums.length + 2 ; i++) {
            index = (beg + end) / 2;
            if (i == nums.length +1) {
                return new int[]{-1,-1};
            } else if (nums[index] > target) {
                end = index - 1;
            } else if (nums[index] < target) {
                beg = index + 1;
            } else {
                if (index == 0 || nums[index - 1] != target) {
                    leftEdge = index;
                    break;
                }else {
                    end = index - 1;
                }
            }
        }


        beg = index;
        end = nums.length-1;
        int rightEdge = -1;
        for (int i = 0; i < nums.length+2; i++) {
            index = (beg + end) / 2;
            if (i == nums.length +1) {
                return new int[]{-1,-1};
            } else if (nums[index] > target) {
                end = index - 1;
            } else if (nums[index] < target) {
                beg = index + 1;
            } else {
                if (index == nums.length-1 || nums[index + 1] != target) {
                    rightEdge = index;
                    break;
                } else{
                    beg = index + 1;
                }
            }
        }


        return new int[]{leftEdge,rightEdge};
    }

 */


/*
//skudu
    public boolean isValidSudoku(char[][] board) {
        int[][] map = new int[10][10];
        int i = 0, j = 0;
        for (char[] now : board) {
            j = 0;
            for (char gg : now) {
                map[i][j] = gg=='.'?0:gg - '0';
                j++;
            }
            i++;
        }

        //detect each 3*3 box
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                int[] va = new int[10];
                //detect this square
                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        if ( va[map[m * 3 + a][n * 3 + b]] == 1) {
                            if(map[m * 3 + a][n * 3 + b] != 0 )
                                return false;
                        }
                        va[map[m * 3 + a][n * 3 + b]]++;
                    }
                }


            }
        }

        //test every row
        for (int m = 0; m < 10; m++) {
            int[] shu = new int[10];
            int[] heng = new int[10];
            for (int n = 0; n < 10; n++) {
                if (map[m][n] != 0 && shu[map[m][n]] == 1) {
                    return false;
                }
                shu[map[m][n]]++;
                if (map[n][m] != 0 && heng[map[n][m]] == 1) {
                    return false;
                }
                heng[map[n][m]]++;
            }
        }
        return true;
    }
 */


/*
// Combination Sum
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        helper(t, target , ans, candidates);
        return ans;
    }

    private void helper(List<Integer> t, int target, List<List<Integer>> ans, int[] candidates) {
        if (target == 0) {
            ans.add(t);
            return;
        }
        for (int now : candidates) {
            if (t.size() != 0 && t.get(t.size() - 1) > now) {
                continue;
            }
            if (target - now >= 0) {
                List<Integer> n = new ArrayList<>();
                n.addAll(t);
                n.add(now);
                helper(n, target - now, ans, candidates);
            }
        }
    }
*/

/* 40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(ans, target, new ArrayList<>(), candidates, 0);
        return ans;
    }

    public void helper(List<List<Integer>> ans, int target, List<Integer> now, int[] candidates, int progress) {
        if (target == 0) {
            ans.add(new ArrayList(now));
            return;
        }
        if (target < 0) return;
        for (int i = progress; i < candidates.length; i++) {
            if (i > progress && candidates[i] == candidates[i-1]) continue;
            now.add(now.size(), candidates[i]);
            helper(ans, target - candidates[i], now, candidates, i + 1);
            now.remove(now.size() - 1);
        }

    }

 */


/*
    public String multiply(String num1, String num2) {
//        List<String> wfp = new ArrayList<>();
        String s = (num1.length() > num2.length()) ? num2 : num1;
        String l = (num1.length() > num2.length()) ? num1 : num2;
        String ans = "";
        for (int i = s.length() - 1; i > -1; i--) {
            //generate wfp
            String wfp = "";
            int jw = 0;
            int cheng = cc(s.charAt(i));
            for (int j = l.length() - 1; j > -1; j--) {
                wfp = Integer.toString((cc(l.charAt(j)) * cheng + jw) % 10) + wfp;
                jw = (cc(l.charAt(j)) * cheng + jw) / 10;
            }
            if (jw != 0) {
                wfp = Integer.toString(jw) + wfp;
                jw = 0;
            }


            for (int k = 0; k < s.length() - 1 - i; k++) {
                wfp = wfp + "0";
            }
            //add the old and the new wfp


            if (ans.length() < wfp.length()) {
                for (int k = 0;  wfp.length() != ans.length(); k++) {
                    ans = "0" + ans;
                }
            }
            if (ans.length() > wfp.length()) {
                for (int k = 0;  ans.length() != wfp.length(); k++) {
                    wfp = "0" + wfp;
                }
            }
            String nans = "";
            for (int m = Math.max(ans.length(), wfp.length()) - 1; m > -1; m--) {
                int a = (m > ans.length() - 1) ? 0 : cc(ans.charAt(m));
                int b = (m > wfp.length() - 1) ? 0 : cc(wfp.charAt(m));
                nans = Integer.toString(((a + b + jw) % 10)) + nans;
                jw = (a + b + jw) / 10;
            }
            if (jw != 0) {
                nans = Integer.toString(jw) + nans;
                jw = 0;
            }

            ans = nans;
        }
        //remove extra 0
        int we = 0;
        while (we < ans.length() - 1 && ans.charAt(we) == '0') {
            we++;
        }
        ans = ans.substring(we);
        return ans;
    }

    public int cc(char c) {
        return c - '0';
    }

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos)
            if (!(sb.length() == 0 && p == 0))
                sb.append(p);  // skip the leading zeros by trick
        return sb.length() == 0 ? "0" : sb.toString();
    }
*/

/*
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> candidate = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        for (int n : nums) {
            candidate.add(n);
        }
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidate,ans,now);
        System.out.println(ans.size());
        return ans;
    }

    private void helper(List<Integer> candidate, List<List<Integer>> ans, List<Integer> now) {
        if (candidate.size() == 0) {
            ans.add(now);
            return;
        }
        for (int core : candidate) {
            List<Integer> xinCandi = new ArrayList(candidate);
            xinCandi.remove(xinCandi.indexOf(core));
            List<Integer> xin = new ArrayList(now);
            xin.add(core);
            helper(xinCandi,ans,xin);
        }
    }
*/
/*
    public void rotate(int[][] matrix) {


        for (int i = 0; i < matrix.length / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[matrix.length-1 - i];
            matrix[matrix.length-1 - i] = temp;
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = i + 1; j < matrix[i].length; ++j)
                swap(i,j,matrix);
        }
    }

    private void swap(int a, int b,int[][] ma) {
        int temp = ma[a][b];
        ma[a][b] = ma[b][a];
        ma[b][a] = temp;
    }
*/
/*
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String now : strs) {
            int[] kmm = new int[26];
            char[] chars = now.toCharArray();
            for (char p : chars) {
                kmm[p-'a']++;
            }
            String key = Arrays.toString(kmm);
            if(!map.containsKey(key))
                map.put(key,new ArrayList<>());
            map.get(key).add(now);
        }
        List<List<String>> ans = new ArrayList<>();
        for (String now : map.keySet()) {
            ans.add(map.get(now));
        }
        return ans;
    }
*/

/*
    public boolean canJump(int[] nums) {
        int maxl = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxl) {
                return false;
            }
            maxl = Math.max(maxl, nums[i]+i);
        }
        return true;
    }
*/


/*
    //  <-(・ω・!</)= = = = = =
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> preans = new ArrayList<>();
        int[] newrange = intervals[0];
        preans.add(newrange);
        for (int[] now : intervals) {
            if (now[0] <= newrange[1]) {
                newrange[1] = Math.max(newrange[1],now[1]);
            }else {
                newrange = now;
                preans.add(newrange);
            }
        }
        int[][] ans = new int[preans.size()][];
        int index = 0;
        for (int[] now : preans) {
            ans[index++] = now;
        }
        return ans;
    }
*/



    public static void main(String[] args) {
        Solution s = new Solution();
//        StringBuilder sb = new StringBuilder();
//        sb.append("0");
//        sb.append("1");
//        sb.append("0");

//        List<String> test = new ArrayList<>();
//        test.add("ale");
//        test.add("apple");
//        test.add("monkey");
//        test.add("plea");
        int[] test = {1, 3, 2};
        String[] testfstring = { "tea", "tan", "ate", "nat", "bat"};
        int[][] test2 = new int[][]{{3,4},{1,3}};
//        TreeNode test = s.stringToTreeNode("[]");
//        int[][] test = {{1,2},{3,4}};
        System.out.println(s.merge(test2));
//        System.out.println(s.isSubtree(s.stringToTreeNode("[1,null,1,null,1,null,1,2]"),s.stringToTreeNode("[1,null,1,null,1,2]")));
//        System.out.println(s.isSubtree(s.stringToTreeNode("[1,1]"),s.stringToTreeNode("[1]")));
    }
}
