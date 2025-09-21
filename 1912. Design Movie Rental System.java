class MovieRentingSystem {
    HashMap<Integer, TreeMap<Integer, Integer>> movieToShop = new HashMap<>();
    HashMap<Integer, HashMap<Integer, Integer>> shopToMovie = new HashMap<>();
    TreeSet<int[]> rented = new TreeSet<>((a, b) -> {
        if (a[0] != b[0]) return a[0] - b[0];      
        if (a[1] != b[1]) return a[1] - b[1];    
        return a[2] - b[2];               
    });

    public MovieRentingSystem(int n, int[][] entries) {
        for (int i = 0; i < entries.length; i++) {
            int shop = entries[i][0];
            int movie = entries[i][1];
            int price = entries[i][2];
            movieToShop.computeIfAbsent(movie, k -> new TreeMap<>())
                       .put(shop * 1000000 + price, shop); 
        }
        movieToShop.clear();
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            movieToShop.computeIfAbsent(movie, k -> new TreeMap<>())
                       .put(price * 100000 + shop, shop); // sort by price then shop
            shopToMovie.computeIfAbsent(shop, k -> new HashMap<>()).put(movie, price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>();
        if (!movieToShop.containsKey(movie)) return ans;
        TreeMap<Integer, Integer> tm = movieToShop.get(movie);
        int ind = 0;
        for (Map.Entry<Integer, Integer> ele : tm.entrySet()) {
            ans.add(ele.getValue());
            if (++ind == 5) break;
        }
        return ans;
    }

    public void rent(int shop, int movie) {
        int price = shopToMovie.get(shop).get(movie);
        TreeMap<Integer, Integer> tm = movieToShop.get(movie);
        tm.remove(price * 100000 + shop);
        
        rented.add(new int[]{price, shop, movie});
    }

    public void drop(int shop, int movie) {
        int price = shopToMovie.get(shop).get(movie);
        movieToShop.computeIfAbsent(movie, k -> new TreeMap<>())
                   .put(price * 100000 + shop, shop);
        
        rented.remove(new int[]{price, shop, movie});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        for (int[] r : rented) {
            ans.add(Arrays.asList(r[1], r[2])); // shop, movie
            if (++i == 5) break;
        }
        return ans;
    }
}
