class Solution {
    // Function to return a list of BST elements in a given range.
    public static void build(Node root, int low, int high, ArrayList<Integer> arr){
        if(root == null) return;
        build(root.left, low, high, arr);
        
        if(root.data >= low && root.data <= high){
            arr.add(root.data);
        }
        
        build(root.right, low, high, arr);
    }
    public static ArrayList<Integer> printNearNodes(Node root, int low, int high) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        build(root, low, high, arr);
        
        return arr;
    }
}