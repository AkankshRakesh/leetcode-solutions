class Solution {

    public List<String> findAllRecipes(
        String[] recipes,
        List<List<String>> ingredients,
        String[] supplies
    ) {
        Set<String> available = new HashSet<>();
        for (String supply : supplies) {
            available.add(supply);
        }

        Queue<Integer> recipeQueue = new LinkedList<>();
        for (int idx = 0; idx < recipes.length; ++idx) {
            recipeQueue.offer(idx);
        }

        List<String> createdRecipes = new ArrayList<>();
        int lastSize = -1;

        while (available.size() > lastSize) {
            lastSize = available.size();
            int queueSize = recipeQueue.size();

            while (queueSize-- > 0) {
                int recipeIdx = recipeQueue.poll();
                boolean canCreate = true;

                for (String ingredient : ingredients.get(recipeIdx)) {
                    if (!available.contains(ingredient)) {
                        canCreate = false;
                        break;
                    }
                }

                if (!canCreate) {
                    recipeQueue.offer(recipeIdx);
                } else {
                    available.add(recipes[recipeIdx]);
                    createdRecipes.add(recipes[recipeIdx]);
                }
            }
        }

        return createdRecipes;
    }
}