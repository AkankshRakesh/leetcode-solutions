class Solution {
    public boolean isVowel(char ch){
        boolean check = false;
        switch (ch) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
        case 'A':
        case 'E':
        case 'I':
        case 'O':
        case 'U':
            check = true;
        }
        return check;
    }
    public String sortVowels(String s) {
        TreeMap<Character, Integer> tm = new TreeMap<>();
        for(int i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))) tm.put(s.charAt(i), tm.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++){
            if(!isVowel(s.charAt(i))) continue;
            Character ch = tm.firstKey();
            int count = tm.get(ch);
            sb.setCharAt(i, ch);

            if(count == 1) tm.remove(ch);
            else tm.put(ch, count - 1);
        }

        return sb.toString();
    }
}