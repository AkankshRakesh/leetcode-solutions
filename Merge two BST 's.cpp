/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

*/
class Solution {
    public void trav(Node root, ArrayList<Integer> arr){
        if(root == null) return;
        
        trav(root.left, arr);
        arr.add(root.data);
        trav(root.right, arr);
    }
    public ArrayList<Integer> merge(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        
        trav(root1, arr1);
        trav(root2, arr2);
        
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr1.size();
        int m = arr2.size();
        
        int i = 0, j = 0;
        while(i < n && j < m){
            if(arr1.get(i) < arr2.get(j)){
                ans.add(arr1.get(i));
                i++;
            }
            else{
                ans.add(arr2.get(j));
                j++;
            }
        }
        
        while(i < n){
            ans.add(arr1.get(i));
            i++;
        }
        while(j < m){
            ans.add(arr2.get(j));
            j++;
        }
        
        return ans;
    }
}