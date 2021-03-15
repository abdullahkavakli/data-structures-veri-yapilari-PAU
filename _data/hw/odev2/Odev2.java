//Abdullah Kavaklı 19253037

import java.util.*;

public class Odev2 {
    
    static String traversalString= "";
    
    /**
     * Postfix biçiminde verilen metni ExpressionTree sınıfına dönüştürür
     * @param girdi postfix girdi metni
     * @return Oluşturulan ifade ağacı
     */
    public static ExpressionTree postfixToExpressionTree(String girdi){        
        return new ExpressionTree(tokensToRoot(girdi));
    }

    /**
     * Parametre olarak verilen ifade ağacını değerlendirir(sonucunu hesaplar).
     * @param agac İfade ağacı
     * @return İfade ağacının sonucu
     */
    public static int evaluateExpressionTree(ExpressionTree agac){
        return postfixDegerlendir(postOrder(agac.getRoot()));
    }
    
    private static String[] splitToTokens(String girdi)
    {
        StringTokenizer t=new StringTokenizer(girdi, "+-*/^() ",true);
        List<String> tokenList=new ArrayList<>();
        while (t.hasMoreTokens()){
            String s=t.nextToken().trim();
            if(!s.equals(""))
                tokenList.add(s);
        }
        String [] tl=new String[tokenList.size()];
        tokenList.toArray(tl);
        return tl;
    }
    
    
    public static BTNode tokensToRoot(String girdi)
    {
        StringTokenizer t=new StringTokenizer(girdi, "+-*/^() ",true);
        Stack<BTNode<String>> st= new Stack<>();
        
        while (t.hasMoreTokens()){
            String s=t.nextToken().trim();
            System.out.println(s);
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                BTNode<String> op2=st.pop();
                BTNode<String> op1=st.pop();
                BTNode<String> o = new BTNode<>(s,op1,op2);
                st.push(o);
                
            }else if(!s.equals("")){
               
                BTNode<String> r = new BTNode<>(s,null,null);
                st.push(r);                
            }
        }
        return st.pop();
    }
    
    
    /**
     * Postfix ifadeyi değerlendirir. İşlemler tamsayılar üzerinde gerçekleşir. "7 5 /" işleminin sonucu 1'dir.
     * @param girdi Girdi ifadesi
     * @return İfadenin sonucu
     */
    public static int postfixDegerlendir(String girdi) {
        String[] tokenList = splitToTokens(girdi);
        Stack<Integer> stackforpf = new Stack();
        for (String tokenList1 : tokenList) {
            if(Character.isDigit(tokenList1.charAt(0))) {                
                stackforpf.push(Integer.parseInt(tokenList1));
            } else {
                int num2 = (int) stackforpf.pop();
                int num1 = (int) stackforpf.pop();
                switch (tokenList1) {
                    case "/":
                        try{stackforpf.push((num1 / num2) );
                        
                        }catch (java.lang.ArithmeticException e){
                            stackforpf.push(1);
                        }
                        break;
                    case "*":
                        stackforpf.push((num1 * num2) );
                        break;
                    case "+":
                        stackforpf.push((num1 + num2) );
                        break;
                    case "-":
                        stackforpf.push((num1 - num2) );
                        break;
                    default:
                        break;
                }
            }
        }
        return (int) stackforpf.peek();
    }
    
    public static<T> String postOrder(BTNode<T> node) {
        traversalString= "";
        postOrderAssist(node);
        
        
        return traversalString;
    }
    
    
    protected static<T> String postOrderAssist(BTNode<T> node) {
        
        if(node.left!=null)
            postOrderAssist(node.left);
        if(node.right!=null)
            postOrderAssist(node.right);
        
        
        return traversalString+=node.value+" ";
    }
    
    
}