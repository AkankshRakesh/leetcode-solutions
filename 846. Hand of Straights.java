class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int card : hand) {
            tm.put(card, tm.getOrDefault(card, 0) + 1);
        }
        
        while(!tm.isEmpty()){
            int ele = tm.firstKey();

            for(int i = 0; i < groupSize; i++){
                int card = ele + i;
                if(!tm.containsKey(card)) return false;

                if(tm.get(card) == 1) tm.remove(card);
                else tm.put(card, tm.get(card) - 1);
            }
        }

        return true;
    }
}