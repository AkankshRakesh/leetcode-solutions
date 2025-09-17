class FoodRatings {
    class Pair{
        int rating;
        String food;
        public Pair(int rating, String food){
            this.rating = rating;
            this.food = food;
        }
    }
    HashMap<String, PriorityQueue<Pair>> hm = new HashMap<>();
    HashMap<String, Integer> foodRating = new HashMap<>();
    HashMap<String, String> fToC = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for(int i = 0; i < n; i++){
            if(hm.containsKey(cuisines[i])) hm.get(cuisines[i]).offer(new Pair(ratings[i], foods[i]));
            else{
                PriorityQueue<Pair> temp = new PriorityQueue<>((a, b) -> a.rating != b.rating ? Integer.compare(b.rating, a.rating) : a.food.compareTo(b.food));
                temp.offer(new Pair(ratings[i], foods[i]));
                hm.put(cuisines[i], temp);
            }
            fToC.put(foods[i], cuisines[i]);
            foodRating.put(foods[i], ratings[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        foodRating.put(food, newRating);
        hm.get(fToC.get(food)).offer(new Pair(newRating, food));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Pair> pq = hm.get(cuisine);
        while(pq.peek().rating != foodRating.get(pq.peek().food)) pq.poll();

        return pq.peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */