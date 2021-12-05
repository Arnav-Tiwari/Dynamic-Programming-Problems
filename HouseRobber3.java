class Solution {
    HashMap<String,Integer> map;
    public int rob(TreeNode root) {
        map=new HashMap<>();
        return Math.max(Max_Profit(root,true,map),Max_Profit(root,false,map));
    }
    public static int Max_Profit(TreeNode root,boolean taken,HashMap<String,Integer> map){
        if(root==null)
            return 0;
        int max=0;
        String key=root+""+(taken?'0':'1');
        if(map.containsKey(key))
            return map.get(key);
        if(taken){
            max=Max_Profit(root.left,false,map)+Max_Profit(root.right,false,map);
        }
        else{
            max=Math.max(root.val+Max_Profit(root.left,true,map)+Max_Profit(root.right,true,map),Max_Profit(root.left,false,map)+Max_Profit(root.right,false,map));
        }
        map.put(key,max);
        return max;
    }
}
