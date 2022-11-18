package ba.unsa.etf.rpr;


import java.util.Stack;
import java.lang.Double;

/**
 * @author Faris Ćosić
 * @version 1.0
 */
public class ExpressionEvaluator {

    private static Stack <Double> val;
    private static Stack <String> op;


    public static String[] parsedString(String s){
        return s.split(" ");
    }


    public ExpressionEvaluator(){
        op = new Stack<>();
        val = new Stack<>();
    }

    public static void validiraj(String s){
        String[] p = parsedString(s);
        int l = 0;
        int d = 0;
        for(String i : p){
            if(!(i.equals("0") || i.equals("1") || i.equals("2") || i.equals("3") || i.equals("4") || i.equals("5") || i.equals("6") || i.equals("7") || i.equals("8") || i.equals("9")
                    || i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/") || i.equals("sqrt")
                    || i.equals("(") || i.equals(")") )) throw new RuntimeException("Pogrešni operandi!");
        }

        for(String i : p){
            if(i.equals("(")) l += 1;
            if(i.equals(")")) d += 1;

        }
        if(l != d) throw new RuntimeException("Pogrešno!");
    }

    public Boolean validan(String s){
        if(!s.startsWith("(")) return false;
        return true;
    }
    public Double evaluate(String str){
        str = str.trim();
        if(!validan(str)) throw new RuntimeException("Nevalidan unos");

        boolean r = false;
        for(int i = 0; i < str.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();

            if(str.charAt(i) == ' ' && str.charAt(i+1) == ' ') throw new RuntimeException("Nevalidan unos");
            while (str.charAt(i) != ' ') {
                stringBuilder.append(str.charAt(i));
                if (i == str.length() - 1) break;
                i++;
            }

            String s = String.valueOf(stringBuilder);

            boolean validan = false;
            if (s.equals("(") || s.equals("+") || s.equals("-") || s.equals("/") || s.equals("sqrt") || s.equals(")") || s.equals("*")) {
                validan = true;
            } else {
                Double b = Double.parseDouble(s);
                validan = true;
            }


            if (validan) {

                if (s.equals("("));
                else if (s.equals("+")) op.push(s);
                else if (s.equals("-")) op.push(s);
                else if (s.equals("*")) op.push(s);
                else if (s.equals("/")) op.push(s);
                else if (s.equals("sqrt")) op.push(s);

                else if (s.equals(")")) {
                    String o = (String) op.pop();
                    double v = (double) val.pop();
                    if (o.equals("+")) v = (double) val.pop() + v;
                    else if (o.equals("-")) v = (double) val.pop() - v;
                    else if (o.equals("*")) v = (double) val.pop() * v;
                    else if (o.equals("/")) v = (double) val.pop() / v;
                    else if (o.equals("sqrt")) v = Math.sqrt(v);
                    val.push(v);
                } else{
                    val.push(Double.parseDouble(s));
                }
            } else {
                throw new RuntimeException("Nevalidan unos");
            }
        }

        Double vrati = (Double) val.pop();
        if(!val.empty()) throw new RuntimeException("Nevalidan unos");
        return vrati;
    }
}

