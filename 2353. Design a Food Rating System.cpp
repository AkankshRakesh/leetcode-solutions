class FoodRatings {
    struct Pair {
        int rating;
        string food;
        Pair(int r, string f) : rating(r), food(f) {}
    };

    struct cmp {
        bool operator()(const Pair& a, const Pair& b) const {
            if (a.rating != b.rating)
                return a.rating < b.rating; 
            return a.food > b.food;         
        }
    };

    unordered_map<string, priority_queue<Pair, vector<Pair>, cmp>> hm; 
    unordered_map<string, int> foodRating;                       
    unordered_map<string, string> fToC;                               

public:
    FoodRatings(vector<string>& foods, vector<string>& cuisines, vector<int>& ratings) {
        int n = foods.size();
        for (int i = 0; i < n; i++) {
            hm[cuisines[i]].push(Pair(ratings[i], foods[i]));
            fToC[foods[i]] = cuisines[i];
            foodRating[foods[i]] = ratings[i];
        }
    }

    void changeRating(string food, int newRating) {
        foodRating[food] = newRating;
        hm[fToC[food]].push(Pair(newRating, food)); 
    }

    string highestRated(string cuisine) {
        auto& pq = hm[cuisine];
        while (!pq.empty() && pq.top().rating != foodRating[pq.top().food])
            pq.pop();
        return pq.top().food;
    }
};
