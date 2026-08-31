public class Solution {
    public string DiscountPrices(string sentence, int d) {
        StringBuilder ans = new StringBuilder();
        int index = 0;
        decimal discount = (decimal)d / (decimal)100;

        while(index < sentence.Length){
            if(sentence[index] == '$' && (index == 0 || sentence[index - 1] == ' ')){
                ans.Append('$');
                index++;

                StringBuilder temp = new StringBuilder();
                long num = 0;
                while(index < sentence.Length && sentence[index] != ' '){
                    temp.Append(sentence[index]);
                    if(sentence[index] > '9' || sentence[index] < '0'){
                        num = 0;
                        break;
                    }

                    num *= 10;
                    num += sentence[index] - '0';

                    index++;
                }
                
                // Console.WriteLine(num);
                if(num == 0) {
                    if(temp.Length != 0) ans.Append(temp);
                }
                else{
                    decimal nextPrice = num - (num * discount);
                    ans.Append($"{nextPrice:F2}");
                }
                if(index < sentence.Length && sentence[index] == ' ') ans.Append(' ');
            }
            else ans.Append(sentence[index]);

            // Console.WriteLine(index + " " + sentence[index]);
            index++;
        }

        return ans.ToString();
    }
}