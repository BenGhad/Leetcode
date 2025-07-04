class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> wordCount = new HashMap<>();
        String winna = senders[0];

        for(int i = 0; i < messages.length; i++){
            String sender = senders[i];
            String[] msg = messages[i].split(" ");
            wordCount.put(sender, wordCount.getOrDefault(sender, 0) + msg.length);

            if(wordCount.get(winna) < wordCount.get(sender)){
                winna = sender;
            } else if(wordCount.get(winna) == wordCount.get(sender) && sender.compareTo(winna) > 0){
                winna = sender;
            }
        }
        return winna;
    }
}
