
import com.sun.source.tree.LiteralTree;
import org.json.JSONArray;
import org.json.JSONException;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Solution {
    /*easy functions*/
    private void swap(int a, int b, int[][] ma) {
        int temp = ma[a][b];
        ma[a][b] = ma[b][a];
        ma[b][a] = temp;
    }

    private void swap(int a, int b, int[] ma) {
        int temp = ma[b];
        ma[b] = ma[a];
        ma[a] = temp;
    }

    public static List<List<Integer>> stringto2dList(String input) {
        input = input.substring(1, input.length() - 1);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '[') {
                continue;
            }
            List<Integer> now = new ArrayList<>();
            while (input.charAt(i) != ',') {
                now.add(input.charAt(i) - '0');
                i += 2;
                if (i > input.length() - 1) {
                    break;
                }
            }
            i++;
            ans.add(now);
        }
        return ans;
    }

    public TreeNode string2TreeNode(String input) {
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


    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }


    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }


    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

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
    private static class TreeNode {
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
*//*
    public int uniquePaths(int m, int n) {
        if (m == 1 || n ==1) {
            return 1;
        }
        if (m == 2) {
            return n;
        }
        if (n == 2) {
            return m;
        }
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }
*/


    /*
    public int minPathSum(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] = grid[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
*//*
    public void setZeroes(int[][] matrix) {
        //record the positions of zeros
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i : row) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i : col) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[j][i] = 0;
            }
        }
    }
    */

/*
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0)) {
            return false;
        }
        int low;
        int high;
        for (low = 0, high = matrix.length - 1; low <= high;)
        {
            int middle = (low + high) / 2;
            if (matrix[middle][0] < target)
            {
                low = middle + 1;
            }
            else if (matrix[middle][0] > target)
            {
                high = middle - 1;
            }
            else
            {
                return true;
            }
        }


        // when above loop ends, search in row[high]
        int row = high;
        if (row >= 0)
        {
            for (low = 0, high = matrix[row].length - 1; low <= high;)
            {
                int middle = (low + high) / 2;
                if (matrix[row][middle] < target)
                {
                    low = middle + 1;
                }
                else if (matrix[row][middle] > target)
                {
                    high = middle - 1;
                }
                else
                {
                    return true;
                }
            }
        }

        return false;
    }
*/
/*
    public void sortColors(int A[]) {
        int second=A.length-1, zero=0;
        for (int i=0; i<=second; i++) {
            while (A[i]==2 && i<second)//如果在2区之外发现了2，就吧它传送到2区的边缘上，并且扩大2区，不断循环，保证i处要不然进入红区，要不然不是2；
                swap(A,i, second--);
            while (A[i]==0 && i>zero)//如果在0区之外。。。。。。。（因为zero小于i，之前的算法保证了i之前的🈚2，那么不是0就是1了，吧发现的0换过去，如果换到了1，就重复这个过程找找有没有1了到底t）
        swap(A,i, zero++);
    }
}

    private void swap(int[] A, int i, int i1) {
        int temp = A[i];
        A[i] = A[i1];
        A[i1] = temp;
    }
*/

/*
    public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> now = new ArrayList<>();
            helper(n, k, ans, now, 0);
        return ans;
    }

    private void helper(int n, int k, List<List<Integer>> ans, List<Integer> now, int top) {
        if (k == 0) {
            ans.add(new ArrayList(now));
            return;
        }
        for (int i = top + 1; i <= n - k + 1; i++) {
            now.add(i);
            helper(n,k-1,ans,now,i);
            now.remove(now.size()-1);
        }
    }
*/
/*
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            List<List<Integer>> temp = combine(nums.length,i);
            for (List<Integer> now : temp) {
                List<Integer> anspart = new ArrayList<>();
                for (int index : now) {
                    anspart.add(nums[index-1]);
                }
                ans.add(anspart);
            }
        }
        return ans;

    }
*/


    //TODO: Finish 79
    //Todo: 127

/*
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int pos = 0;
        int detect = 0;
        while (detect < nums.length) {
            count = (pos != 0 && nums[pos-1] == nums[detect]) ? count+1 : 1;
            if (count < 3) {
                swap(pos, detect, nums);
                detect++;
                pos++;
            } else {
                detect++;
            }
        }
        return pos ;
    }
*/

/*
    public ListNode deleteDuplicates(ListNode head) {
        //find a good start
        if (head == null || head.next == null) {
            return head;
        }

        ListNode ans = null;
        int rep = 9994899;
        if (head.val != head.next.val) {
            ans = head;
        }else {
            rep = head.val;
            ListNode sel = head;
            while(sel.next!=null &&(rep==sel.val||sel.val==sel.next.val)){
                if (sel.val == sel.next.val) {
                    rep = sel.val;
                }
                sel = sel.next;
            }
            if (sel.val == rep ) {
                return null;
            }else
                ans = sel;
        }

        //seek for nonreps
        ListNode p = ans.next;
        ListNode build =  ans;
        while (p != null) {
            if (p.next == null) {
                if(p.val!=rep){
                    build.next = p;
                    return ans;
                }
                if (build != null) {
                    build.next = null;
                }
                return ans;
            }
            if (p.val == p.next.val || p.val == rep) {
                rep = p.val;
                p = p.next;
                continue;
            }
            build.next = p;
            p = p.next;
            build = build.next;
        }
        if (build != null) {
            build.next = null;
        }
        return ans;
    }
*/


//    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> now = new ArrayList<>();
//        helper(n, k, ans, now, 0);
//        return ans;
//    }
//
//    private void helper(int n, int k, List<List<Integer>> ans, List<Integer> now, int top) {
//        if (k == 0) {
//            ans.add(new ArrayList(now));
//            return;
//        }
//        for (int i = top + 1; i <= n - k + 1; i++) {
//            now.add(i);
//            helper(n,k-1,ans,now,i);
//            now.remove(now.size()-1);
//        }
//    }

//
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        for (int i = 0; i <= nums.length; i++) {
//            List<List<Integer>> temp = combine(nums.length,i);
//            for (List<Integer> now : temp) {
//                List<Integer> anspart = new ArrayList<>();
//                for (int index : now) {
//                    anspart.add(nums[index-1]);
//                }
//                ans.add(anspart);
//            }
//        }
//
//        //remove the same
//        if (ans.size() == 0 || ans.size() == 1) {
//            return ans;
//        }
//        List<Integer> bf = new ArrayList(ans.get(0));
//        List<Integer> rm = new ArrayList<>();
//        hoop : for (int i = 1; i < ans.size(); i++) {
//            List<Integer> af = ans.get(i);
//            if (bf.size() == af.size()) {
//
//                for(int j=0;j<af.size();j++){
//                    if(!af.get(j).equals(bf.get(j))){
//                        continue hoop;
//                    }
//                }
//                rm.add(i);
//
//
//            }
//            bf = af;
//        }
//        for (int i = rm.size() - 1; i >= 0; i--) {
//            int j = rm.get(i);
//            ans.remove(j);
//        }
//        return ans;
//
//    }


//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> each = new ArrayList<>();
//        helper(res, each, 0, nums);
//        return res;
//    }
//
////    private void dfs(int[] nums, int i, ArrayList<Integer> now, List<List<Integer>> result) {
////        if (i == nums.length) {
////            result.add(now);
////            return;
////        }
////        for (int j = i; j <= nums.length - 1; ) {
////            now.add(nums[j]);
////            dfs(nums,j+1,now,result);
////            now.remove(now.size()-1);
////            j++;
////            while(j<nums.length-1&&nums[j]==nums[j+1]){
////                j++;
////            }
////        }
////    }
//public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
//    if (pos <= n.length) {
//        res.add(new ArrayList<>(each));
//    }
//    int i = pos;
//    while (i < n.length) {
//        each.add(n[i]);
//        helper(res, each, i + 1, n);
//        each.remove(each.size() - 1);
//        i++;
//        while (i < n.length && n[i] == n[i - 1]) {i++;}
//    }
//    return;
//}

/*
    public ListNode reverseBetween(ListNode head, int m, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode pre = head;
        ListNode oldhead,oldtail;

        for (int i = 1; i < m - 1; i++) {
            pre = pre.next;
        }
        if (m == 1) {
            oldhead = null;
        }else {
            oldhead = pre;
            pre = pre.next;
        }


        for (int i = m; pre!=null&&i <= n; i++) {
            stack.push(pre);
            pre = pre.next;
        }
        oldtail = pre;
        int lin = stack.size();
        ListNode for1 = null;
        if (m == 1) {
            oldhead = stack.pop();
            for1 = oldhead;
        }

        for (int i = 0;oldhead!=null&& !stack.isEmpty(); i++) {
            oldhead.next = stack.pop();
            oldhead = oldhead.next;
        }
        oldhead.next = oldtail;
        if (m == 1) {
            return for1;
        }
        return head;
    }
*//*
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root,ans);
        return ans;
    }

    private void helper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        helper(root.left,ans);
        ans.add(root.val);
        helper(root.right,ans);
    }
    */
/*
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private List<TreeNode> helper(int i, int n) {
        if(n == 0)
            return new ArrayList<>();
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if (i > n) {
            ans.add(null);
        } else {
            for (int j = i; j <= n; j++) {
                List<TreeNode> ll = helper(i, j - 1);
                List<TreeNode> rr = helper(j + 1, n);
                for (TreeNode l : ll) {
                    for (TreeNode r : rr) {
                        TreeNode t = new TreeNode(j);
                        t.left = l;
                        t.right = r;
                        ans.add(t);
                    }
                }

            }
        }
        return ans;
    }
*/

/*
    public int numTrees(int n) {
        if (n == 0 || n==1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans = ans + numTrees(i) * numTrees(n - 1 - i);
        }
        return ans;
    }
*/

/*
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        return helper(root.left,56625,root.val)&&helper(root.right,root.val,56625);

    }

    private boolean helper(TreeNode root, int min, int max) {
        boolean ans = true;
        if (root == null) {
            return true;
        }
        if (min != 56625) {
            ans = ans && min<root.val;
        }
        if (max != 56625) {
            ans = ans && root.val < max;
        }
        if (root.right != null) {
            ans = ans && helper(root.right,root.val,max);
        }
        if (root.left != null) {
            ans = ans && helper(root.left,min,root.val);
        }
        return ans;
    }
*/


/*
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sizeOfLevel = q.size();
            List<Integer> now = new ArrayList<>();
            for (int i = 0; i < sizeOfLevel; i++) {
                TreeNode t = q.poll();
                now.add(t.val);
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }
            ans.add(now);
        }

        for (int i = 0; i < ans.size(); i++) {
            if(i%2==0)
        }
        return ans;
    }
    */
/*
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sizeOfLevel = q.size();
            List<Integer> now = new ArrayList<>();
            for (int i = 0; i < sizeOfLevel; i++) {
                TreeNode t = q.poll();
                now.add(t.val);
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }
            ans.add(now);
        }

        for (int i = 0; i < ans.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(ans.get(i));
            }
        }
        return ans;
    }
*/

/*
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int indexOfroot = 0;
        while (inorder[indexOfroot] != preorder[0]) {
            indexOfroot++;
        }
        root.left = buildTree(Arrays.copyOfRange(preorder,1,1+indexOfroot),Arrays.copyOfRange(inorder,0,indexOfroot));
        root.right = buildTree(Arrays.copyOfRange(preorder,1+indexOfroot, preorder.length),Arrays.copyOfRange(inorder,indexOfroot+1,inorder.length));
        return root;

    }
*/

/*
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return helper(inorder,postorder,0,inorder.length-1,0,inorder.length-1,map);

    }

    private TreeNode helper(int[] inorder, int[] postorder, int beg1, int end1,int beg2, int end2,HashMap<Integer,Integer> map) {
        if (end1>postorder.length-1 || beg1 < 0|| end1<beg1) {
            return null;
        }
        if (end1 == beg1) {
            return new TreeNode(inorder[end1]);
        }
        TreeNode root = new TreeNode(postorder[end2]);
        int indexOfRoot = map.get(postorder[end2]);
        root.left = helper(inorder,postorder,beg1,indexOfRoot-1,beg2,beg2+indexOfRoot-beg1-1,map);
        root.right = helper(inorder,postorder,indexOfRoot + 1,end1,beg2+indexOfRoot-beg1,end2-1,map);
        return root;
    }
*/
/*
    public TreeNode sortedListToBST(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode sen = new ListNode(999);
        sen.next = head;
        if (head == null) {
            return null;
        }
        if (fast.next == null) {
            return new TreeNode(fast.val);
        }
        if (fast.next.next == null) {
            TreeNode root = new TreeNode(fast.next.val);
            root.left = new TreeNode(fast.val);
            return root;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            sen = sen.next;
        }
        sen.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
*/

/*
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        helper(ans,root, sum,now);
        return ans;
    }

    private void helper(List<List<Integer>> ans, TreeNode root, int sum,List<Integer> now) {
        now.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                ans.add(new ArrayList(now));
            }
            now.remove(now.size()-1);
            return;
        }
        if (root.left != null) {
            helper(ans,root.left, sum - root.val,now);
        }
        if (root.right != null) {
            helper(ans,root.right, sum - root.val,now);
        }
        now.remove(now.size()-1);
        return;
    }
*/
/* easider
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void flatten(TreeNode root) {
        if(root==null || (root.left==null&&root.right==null)){
            return;
        }
        helper(root);
        return;
    }

    private TreeNode helper(TreeNode root) {
        boolean noFkleaf = true;
        if((root.left==null&&root.right==null))
            return root;
        if (root.right != null) {
            noFkleaf = noFkleaf && (root.right.right!=null||root.right.left!=null);
        }
        if (root.left != null) {
            noFkleaf = noFkleaf && (root.left.right!=null||root.left.left!=null);
        }
        if(noFkleaf){
            if (root.left == null) {
                return helper(root.right);
            }
            if (root.right == null) {
                root.right = root.left;
                root.left = null;
                return helper(root.right);
            }
            TreeNode zancun = helper(root.right);
            helper(root.left).right = root.right;
            root.right =root.left;
            root.left = null;
            return zancun;
        }else {
            if (root.right == null) {
                root.right = root.left;
                root.left = null;
                return root.right;
            }else {
                if (root.left != null) {
                    TreeNode za = helper(root.right);
                    helper(root.left).right = root.right;
                    root.right = root.left;
                    root.left = null;
                    return za;
                }else {
                    return helper(root.right);
                }
            }
        }
    }

 */

/*
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return null;
        }
        q.add(root);
        while (!q.isEmpty()) {
            int iengthOfLevel = q.size();
            Node pre = null;
            Node af = q.poll();

            for (int i = 0; i < iengthOfLevel-1; i++) {
                if (af.left != null) {
                    q.add(af.left);
                }
                if (af.right != null) {
                    q.add(af.right);
                }
                pre = q.poll();
                af.next = pre;
                af = pre;
            }
            if (af.left != null) {
                q.add(af.left);
            }
            if (af.right != null) {
                q.add(af.right);
            }

        }
        return root;
    }
*/
/*
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> stst = new ArrayList<>();
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        stst.add(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            helper(stst,stst.get(i-1),triangle.get(i));
        }
        Integer minnow = null;
        for (int now : stst.get(stst.size() - 1)) {
            if (minnow == null) {
                minnow = now;
            }else {
                minnow = (minnow>now)? now:minnow;
            }
        }
        return minnow;
    }

    private void helper(List<List<Integer>> stst, List<Integer> integers,List<Integer> integersnow) {
        List<Integer> now = new ArrayList<>();
        for (int i = 0; i < integersnow.size(); i++) {
            if (i == 0) {
                now.add(integers.get(i) + integersnow.get(i));
                continue;
            }
            if (i == integersnow.size()-1) {
                now.add(integers.get(i-1) + integersnow.get(i));
                continue;
            }
            now.add(Math.min(integers.get(i-1),integers.get(i)) + integersnow.get(i));
        }
        stst.add(now);
    }
*/

/*
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {  // if begin is longer than end, swap their containing
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }
        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int numofsame = 0;
        for (String now : wordList) {
            if (issame(now, endWord)) {
                numofsame++;
            }
        }
        if (numofsame != 1) {
            return 0;
        }
        Boolean[] used = new Boolean[wordList.size()];
        Arrays.fill(used,false);
        int fakeans = helper(beginWord,endWord,wordList,1,used);
        return fakeans==9999?0:fakeans;
    }

    private int helper(String beginWord, String endWord, List<String> wordList, int length, Boolean[] used) {
        int ans = 9999;
        for (int i = 0; i < wordList.size(); i++) {
            if(used[i])
                continue;
            String now = wordList.get(i);

            if (neig(beginWord, now)) {
                if (issame(endWord,now)) {
                    return length+1;
                }
                used[i]=true;
                ans = Math.min(ans,helper(now,endWord,wordList,length+1,used));
                used[i]=false;
            }
        }
        return ans;
    }

    private boolean neig(String beginWord, String now) {
        int numOfDiff = 0;
        for (int i = 0; i < now.length(); i++) {
            if (beginWord.charAt(i) != now.charAt(i)) {
                numOfDiff++;
            }
        }
        return numOfDiff==1;
    }

    private boolean issame(String beginWord, String now) {
        int numOfDiff = 0;
        for (int i = 0; i < now.length(); i++) {
            if (beginWord.charAt(i) != now.charAt(i)) {
                numOfDiff++;
            }
        }
        return numOfDiff==0;
    }
*/



/*  fuck fake question, I will continue

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s.length() == 0) {
            return ans;
        }
        if (s.length() == 1) {
            List<String> li = new ArrayList<>();
            li.add(s);
            ans.add(li);
            return ans;
        }
        List<List<Integer>> z = new ArrayList<>(12);
        List<Integer> now = new ArrayList<>();
        z.add(now);//takes the 0 pos
        //find1s
        now = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            now.add(i);
        }
        z.add(1,now);
        //find2s
        now = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                now.add(i);
            }
        }
        z.add(2,now);

        //find all odd para
        for (int i = 1; 2 * i + 1 <= s.length(); i++) {
            now = new ArrayList<>();
            List<Integer> cores = z.get(2 * (i - 1) + 1);
            for (int core : cores) {
                if (core + i > s.length() - 1 || core - i < 0) {
                    continue;
                }
                if (s.charAt(core + i) == s.charAt(core - i)) {
                    now.add(core);
                }
            }
            if (now.size() == 0) {
                break;
            }
            z.add(2 * i + 1,now);
        }


        //find all even para
        for (int i = 1; 2 + 2 * i <= s.length(); i++) {
            now = new ArrayList<>();
            List<Integer> cores = z.get(2 * (i - 1) + 2);
            for (int core : cores) {
                if (core + i + 1 > s.length() - 1 || core - i < 0) {
                    continue;
                }
                if (s.charAt(core + i + 1) == s.charAt(core - i)) {
                    now.add(core);
                }
            }
            if (now.size() == 0) {
                break;
            }
            if(z.size()<2 + 2 * i)
                z.add(new ArrayList<>());
            z.add(2 + 2 * i ,now);
        }


        for (int i = 0; i < z.size(); i++) {
            List<String> g = new ArrayList<>();
            List<Integer> cores = z.get(i);
            for (int core : cores) {
                if (i % 2 == 1) {
                    int j = i - 1;
                    g.add(s.substring(core-j,core + j +1));
                }else {
                    int j = i/2 - 1;
                    g.add(s.substring(core-j,core + j +2));
                }
            }
            ans.add(g);
        }
        return ans;
    }
*/

/*
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> now = new ArrayList<>();
        helper(s,ans,now,0,s.length()-1);
        return ans;
    }

    private void helper(String s, List<List<String>> ans, ArrayList<String> now, int beg, int end) {
        if (beg > end) {
            ans.add(new ArrayList(now));
            return;
        }
        for (int i = 1; beg+i - 1 <= end; i++) {
            String pro = s.substring(beg,beg+i);
            if(isPal(pro)){
                now.add(pro);
                helper(s,ans,now,beg + i,end);
                now.remove(now.size()-1);
            }
        }
    }

    private boolean isPal(String substring) {
        for (int i = 0; 2 * i <= substring.length(); i++) {
            if(substring.charAt(i)!=substring.charAt(substring.length()-1-i)){
                return false;
            }
        }
        return true;
    }
*/

/*
    public boolean wordBreak(String s, List<String> wordDict) {
        wordDict.sort((String a, String b)->b.length()-a.length() );
        boolean[] visited = new boolean[s.length()+3];
        Arrays.fill(visited,false);
        return helper(s, wordDict, 0, s.length() - 1,visited);
    }

    private boolean helper(String s, List<String> wordDict, int beg, int end,boolean[] visited) {
        if (beg > end) {
            return true;
        }
        for (int i = 0; beg + i <= s.length(); i++) {
            if (visited[beg + i]) {
                continue;
            }
            String now = s.substring(beg, beg + i);
            if (wordDict.contains(now)) {
                visited[beg + i] = true;
                if (helper(s, wordDict, beg + i, end,visited)) {
                    return true;
                }
            }
        }
//        for (String now : wordDict) {
//            if (  beg + now.length()<=s.length() &&s.substring(beg, beg + now.length()).equals(now)) {
//                if (helper(s, wordDict, beg + now.length(), end)) {
//                    return true;
//                }
//            }
//        }
        return false;
    }
*/



    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = fast.next;
            if (fast == slow) {
                break;
            }
        }
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {9, 3, 15, 20, 7};
        String[] testfstring = {"lt", "code"};
        int[][] test2 = new int[][]{{1}};//        TreeNode test = s.stringToTreeNode("[]");
//        int[][] test = {{1,2},{3,4}};

        System.out.println(s.wordBreak("leetcode",Arrays.asList(testfstring)));

    }
}
