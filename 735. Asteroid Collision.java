class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] < 0){
                boolean destroyed = false;
                while(stack.size() >= 1 && stack.peek() > 0){
                    int top = stack.peek();
                    if(top < Math.abs(asteroids[i])){
                        stack.pop();
                    }
                    else if(top == Math.abs(asteroids[i])){
                        stack.pop();
                        destroyed = true;
                        break;
                    }
                    else{
                        destroyed = true;
                        break;
                    }
                }
                if(!destroyed) stack.push(asteroids[i]);
            }
            else stack.push(asteroids[i]);
        }
        int[] arr = new int[stack.size()];
        for(int i = 0; i < stack.size(); i++){
            arr[i] = stack.elementAt(i);
        }
        return arr;
    }
}