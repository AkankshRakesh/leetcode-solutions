class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Collections.sort(events, (a, b) -> Integer.parseInt(a.get(1)) != Integer.parseInt(b.get(1)) ? Integer.compare(Integer.parseInt(a.get(1)), Integer.parseInt(b.get(1))) : a.get(0).equals("OFFLINE") ? -1 : 1);
        int[] mentions = new int[numberOfUsers];
        HashSet<Integer> onlineUsers = new HashSet<>();
        int[] offlineUsers = new int[numberOfUsers];
        for(int i = 0; i < numberOfUsers; i++) onlineUsers.add(i);

        for(List<String> event : events){
            int currTime = Integer.parseInt(event.get(1));
            for(int i = 0; i < numberOfUsers; i++){
                if(!onlineUsers.contains(i) && offlineUsers[i] + 60 <= currTime) onlineUsers.add(i);
            }
            if(event.get(0).equals("MESSAGE")){
                if(event.get(2).equals("ALL")){
                    for(int i = 0; i < numberOfUsers; i++) mentions[i]++;
                }
                else if(event.get(2).equals("HERE")){
                    for(int i = 0; i < numberOfUsers; i++) if(onlineUsers.contains(i)) mentions[i]++;
                }
                else{
                    String str = event.get(2);
                    int curr = 0;
                    for(int i = 0; i < str.length(); i++){
                        if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                            curr *= 10;
                            curr += (str.charAt(i) - '0');
                        }
                        else if(str.charAt(i) == ' '){
                            mentions[curr]++;
                            curr = 0;
                        }
                    }

                    mentions[curr]++;
                }
            }
            else{
                int id = Integer.parseInt(event.get(2));
                onlineUsers.remove(id);
                offlineUsers[id] = Integer.parseInt(event.get(1));
            }
        }

        return mentions;
    }
}