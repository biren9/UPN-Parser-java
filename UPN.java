/**
 * Created by gilbiren on 05/01/2017.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class UPN {
    private String ausdruck;

    public UPN(String ausdruck) {
        this.ausdruck = ausdruck;
    }

    public int getResult() {
        String tmp;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        StringTokenizer st = new StringTokenizer(ausdruck);

        while (st.hasMoreTokens()) {
            System.out.println(stack);
            tmp = st.nextToken();

            if( tmp.equals("+") || tmp.equals("-") || tmp.equals("*") || tmp.equals("/") ) {
                int b = stack.pop();
                int a = stack.pop();
                int c = 0;
                if (tmp.equals("+")) c = a + b;
                else if (tmp.equals("-")) c = a - b;
                else if (tmp.equals("*")) c = a * b;
                else if (tmp.equals("/")) c = a / b;

                stack.push(c);
            }

            else {
                stack.push(Integer.parseInt(tmp));
            }
        }

        return stack.pop();
    }

    public String getAusdruck() {
        return ausdruck;
    }


    public static void main(String args[]) {
        UPN a = new UPN("15 42 18 + 61 24 - * 71 + *");
        System.out.println(a.getAusdruck() + " = " + a.getResult());
    }
}
