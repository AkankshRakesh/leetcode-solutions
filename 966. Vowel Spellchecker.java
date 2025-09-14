class Solution {
    public boolean isVow(char ch){
        switch(ch){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
        }
        return false;
    }
    public String buildKey(String original){
        StringBuilder sb = new StringBuilder();
        StringBuilder ind = new StringBuilder();
        original = original.toLowerCase();
        for(int i = 0; i < original.length(); i++){
            if(isVow(original.charAt(i))) ind.append(i);
            else sb.append(original.charAt(i));
        }

        sb.append("+");
        sb.append(ind);
        return sb.toString();
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashMap<String, Integer> exact = new HashMap<>();
        HashMap<String, Integer> cap = new HashMap<>();
        HashMap<String, Integer> vow = new HashMap<>();

        for(int i = 0; i < wordlist.length; i++) exact.put(wordlist[i], i);
        for(int i = 0; i < wordlist.length; i++){
            if(!cap.containsKey(wordlist[i].toLowerCase())) cap.put(wordlist[i].toLowerCase(), i);
        }
        for(int i = 0; i < wordlist.length; i++){
            String key = buildKey(wordlist[i]);
            if(!vow.containsKey(key)) vow.put(key, i);
        }

        String[] ans = new String[queries.length];
        for(int i = 0; i < queries.length; i++){
            String curr = queries[i];
            if(exact.containsKey(curr)){
                ans[i] = wordlist[exact.get(curr)];
            }
            else if(cap.containsKey(curr.toLowerCase())){
                ans[i] = wordlist[cap.get(curr.toLowerCase())];
            }
            else{
                String key = buildKey(curr);
                if(vow.containsKey(key)){
                    ans[i] = wordlist[vow.get(key)];
                }
                else ans[i] = "";
            }
        }

        return ans;
    }
}