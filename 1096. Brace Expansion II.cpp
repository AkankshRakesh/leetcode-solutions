class Solution {

    String expression;
    int idx;

    public List<String> braceExpansionII(String expression) {
        this.expression = expression;
        this.idx = 0;
        Set<String> ret = expr();
        return new ArrayList<String>(ret);
    }

    private Set<String> item() {
        Set<String> ret = new TreeSet<String>();
        if (expression.charAt(idx) == '{') {
            idx++;
            ret = expr();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(expression.charAt(idx));
            ret.add(sb.toString());
        }
        idx++;
        return ret;
    }

    private Set<String> term() {
        Set<String> ret = new TreeSet<String>() {
            {
                add("");
            }
        };
        while (
            idx < expression.length() &&
            (expression.charAt(idx) == '{' ||
                Character.isLetter(expression.charAt(idx)))
        ) {
            Set<String> sub = item();
            Set<String> tmp = new TreeSet<String>();
            for (String left : ret) {
                for (String right : sub) {
                    tmp.add(left + right);
                }
            }
            ret = tmp;
        }
        return ret;
    }

    private Set<String> expr() {
        Set<String> ret = new TreeSet<String>();
        while (true) {
            ret.addAll(term());
            if (idx < expression.length() && expression.charAt(idx) == ',') {
                idx++;
                continue;
            } else {
                break;
            }
        }
        return ret;
    }
}