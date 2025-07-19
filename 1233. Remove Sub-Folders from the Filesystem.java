class Solution {
    public List<String> removeSubfolders(String[] folder) {
        ArrayList<String> arr = new ArrayList<>();
        Arrays.sort(folder, (a, b) -> Integer.compare(a.length(), b.length()));

        HashSet<Stack<String>> hs = new HashSet<>();

        for (String s : folder) {
            Stack<String> folderName = new Stack<>();
            int i = 0;
            int n = s.length();
            boolean add = true;
            while (i < n) {
                if (s.charAt(i) == '/'){
                    i++;
                    continue;
                }
                String currFolder = s.charAt(i) + "";
                i++;
                while (i < n && s.charAt(i) != '/') {
                    currFolder += s.charAt(i);
                    i++;
                }
                folderName.push(currFolder);
                if (hs.contains(folderName)) {
                    add = false;
                    break;
                }
            }
            if (add) {
                hs.add(folderName);
                arr.add(s);
            }
        }
        return arr;
    }
}