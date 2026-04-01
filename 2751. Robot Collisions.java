class Solution {
    public class Robot{
        int position;
        int health;
        char direction;
        public Robot(int position, int health, char direction){
            this.health = health;
            this.direction = direction;
            this.position = position;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Stack<Robot> st = new Stack<>();
        ArrayList<Robot> arr = new ArrayList<>();
        for(int i = 0; i < positions.length; i++){
            arr.add(new Robot(positions[i], healths[i], directions.charAt(i)));
        }
        Collections.sort(arr, (a, b) -> Integer.compare(a.position, b.position));

        for(int i = 0; i < positions.length; i++){
            Robot curr = arr.get(i);
            if(curr.direction == 'R'){
                st.push(curr);
                continue;
            }
            while(!st.isEmpty() && st.peek().direction == 'R'){
                Robot top = st.pop();
                if(top.health > curr.health){
                    st.push(new Robot(top.position, top.health - 1, top.direction));
                    curr.health = 0;
                    break;
                }
                else if(top.health == curr.health){
                    curr.health = 0;
                    break;
                }
                curr.health--;
            }

            if(curr.health > 0) st.push(new Robot(curr.position, curr.health, curr.direction));
        }

        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        while(!st.isEmpty()){
            hm.put(st.peek().position, st.pop().health);
        }
        for(int position : positions){
            if(hm.containsKey(position)) ans.add(hm.get(position));
        }
        // Collections.reverse(ans);

        return ans;
    }
}