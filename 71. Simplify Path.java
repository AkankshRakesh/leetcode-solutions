class Solution {
    public String simplifyPath(String path) {
        Deque<String> q = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        for(int i = 1; i < path.length(); i++){
            char ch = path.charAt(i);
            if(ch == '/'){
                if(curr.length() == 0 || curr.toString().equals(".")){
                    curr = new StringBuilder();
                    continue;
                }
                if(curr.toString().equals("..")){
                    if(!q.isEmpty()) q.pollLast();
                }
                else q.offerLast(curr.toString());
                curr = new StringBuilder();
            }
            else{
                curr.append(ch);
            }
        }
        if(curr.toString().equals("..")){
            if(!q.isEmpty()) q.pollLast();
        }
        else if(curr.length() != 0 && !curr.toString().equals(".")) q.offerLast(curr.toString());
        
        StringBuilder ans = new StringBuilder();
        ans.append("/");
        while(!q.isEmpty()){
            ans.append(q.pollFirst());
            if(!q.isEmpty()) ans.append("/");
        }

        return ans.toString();
    }
}  