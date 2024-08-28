class Solution {
    public String reverseVowels(String s) {
        char[] string = s.toCharArray();
        Queue<Character> queue = new LinkedList<>();

        for(int i = 0; i < string.length; i++){
            char c = string[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                queue.add(c);
            }
        }

        for(int i = string.length - 1; i >= 0; i--){
            char c = string[i];
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                string[i] = queue.poll();
            }
        }
        return String.valueOf(string);
    }
}
