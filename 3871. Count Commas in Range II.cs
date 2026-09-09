public class Solution
{
    public long CountCommas(long n)
    {
        long ans = 0;

        if (n >= 1_000)
            ans += n - 999;              

        if (n >= 1_000_000)
            ans += n - 999_999;            

        if (n >= 1_000_000_000)
            ans += n - 999_999_999;    

        if (n >= 1_000_000_000_000)
            ans += n - 999_999_999_999;

        if (n >= 1_000_000_000_000_000)
            ans += n - 999_999_999_999_999;

        return ans;
    }
}