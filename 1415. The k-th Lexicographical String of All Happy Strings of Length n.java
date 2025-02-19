class Solution {

    List<String> goodStrings = new ArrayList<>();

    public String getHappyString(int n, int k) {
        String currString = "";
        generategoodStrings(n, currString);

        if (goodStrings.size() < k) return "";

        Collections.sort(goodStrings);

        return goodStrings.get(k - 1);
    }

    public void generategoodStrings(int n, String currString) {
        if (currString.length() == n) {
            goodStrings.add(currString);
            return;
        }

        for (char currentChar = 'a'; currentChar <= 'c'; currentChar++) {
            if (
                currString.length() > 0 &&
                currString.charAt(currString.length() - 1) == currentChar
            ) continue;

            generategoodStrings(n, currString + currentChar);
        }
    }
}