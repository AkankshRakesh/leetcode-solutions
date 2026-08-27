class Solution {
    public String lexGreaterPermutation(String s, String target) {
        StringBuilder sb = new StringBuilder();
        int[] sFreq = new int[128];

        for (int i = 0; i < s.length(); i++)
            sFreq[s.charAt(i)]++;

        boolean track = true;
        int index = 0;

        while (track && index < target.length()) {
            char ch = target.charAt(index);
            char ans = ' ';

            if (sFreq[ch] != 0) {
                ans = ch;
            } else {
                for (int i = ch + 1; i < 128; i++) {
                    if (sFreq[i] != 0) {
                        ans = (char) i;
                        break;
                    }
                }
            }

            if (ans == ' ') {
                while (index > 0) {
                    index--;
                    char prev = sb.charAt(index);
                    sb.deleteCharAt(index);
                    sFreq[prev]++;

                    for (int i = prev + 1; i < 128; i++) {
                        if (sFreq[i] != 0) {
                            sb.append((char) i);
                            sFreq[i]--;
                            track = false;
                            break;
                        }
                    }

                    if (!track) break;
                }

                if (track) return "";
            } else {
                if (ans != ch) track = false;

                sb.append(ans);
                sFreq[ans]--;
                index++;
            }
        }

        if (!track) {
            for (int i = 0; i < 128; i++) {
                while (sFreq[i] != 0) {
                    sFreq[i]--;
                    sb.append((char) i);
                }
            }
            return sb.toString();
        }

        while (index > 0) {
            index--;
            char prev = sb.charAt(index);
            sb.deleteCharAt(index);
            sFreq[prev]++;

            for (int i = prev + 1; i < 128; i++) {
                if (sFreq[i] != 0) {
                    sb.append((char) i);
                    sFreq[i]--;

                    for (int j = 0; j < 128; j++) {
                        while (sFreq[j] != 0) {
                            sFreq[j]--;
                            sb.append((char) j);
                        }
                    }

                    return sb.toString();
                }
            }
        }

        return "";
    }
}