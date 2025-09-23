class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        int n = version1.length(), m = version2.length();
        while(i < n || j < m){
            int v1 = 0;
            int v2 = 0;
            for(; i < n ; i++){
                if(version1.charAt(i) == '.') break;
                v1 *= 10;
                v1 += (version1.charAt(i) - '0');
            }
            i++;
            for(; j < m ; j++){
                if(version2.charAt(j) == '.') break;
                v2 *= 10;
                // System.out.println(v2);
                v2 += (version2.charAt(j) - '0');
            }
            j++;
            // System.out.println(v2);
            if(v1 > v2) return 1;
            else if(v1 < v2) return -1;
        }

        return 0;
    }
}