/**
 * @author abdullahkavakli
 */

import java.util.*;

/**
 * Islemler sınıfı içindeki 4 metodun yazılması istenmektedir
 */
public class Islemler {
    /**
     * Yığıtın elemnlarının sırasını tersine çevirir
     * @param <T>
     * @param s Tersine çevrilecek yığıt
     * @return Tersine çevirlmiş yığıtı döndürür
     */
    public static <T> Stack<T> tersCevir(Stack<T> s){
        //Metodun gövdesini yazınız
        Stack<T> s2= (Stack<T>) s.clone();
        Stack<T> donen=  new Stack<>();
        while(!s2.isEmpty())
            donen.push(s2.pop());
            
        return donen;
    }

    /**
     * İki yığıtın eşit olup olmadığını kontrol eder
     * @param s1 Birinci yığıt
     * @param s2 İkinci yığıt
     * @return İki yığıtın eşit olma durumunu döndürür
     */
    public static <T> boolean esit(Stack<T> s1, Stack<T> s2)
    {
        //Metodun gövdesini yazınız
        Stack<T> s1_d = (Stack<T>) s1.clone();
        Stack<T> s2_d = (Stack<T>) s2.clone();
        while(!s1_d.isEmpty() && !s2_d.isEmpty()){
            if(!(s1_d.pop()==s2_d.pop())){
                return false;
            }
        }
        
        if(!s1_d.isEmpty() && !s1_d.isEmpty()){
            return false;
        }
       
        return true;
    }

    /**
     * Postfix ifadeyi değerlendirir. İşlemler tamsayılar üzerinde gerçekleşir. "7 5 /" işleminin sonucu 1'dir.
     * @param girdi Girdi ifadesi
     * @return İfadenin sonucu
     */
    public static int postfixDegerlendir(String girdi) {
        String[] tokenList = splitToTokens(girdi);
        Stack stackforpf = new Stack();
        for (int i = 0; i < tokenList.length ; i++) {
            try{
                int itilensayi = Integer.parseInt(tokenList[i]);
                stackforpf.push(itilensayi);
            }catch (NumberFormatException e){
                int num2 = (int) stackforpf.pop();
                int num1 = (int) stackforpf.pop();

                if(tokenList[i].equals("/")){
                    stackforpf.push((num1 / num2) );
                }else if(tokenList[i].equals("*")){
                    stackforpf.push((num1 * num2) );
                }else if(tokenList[i].equals("+")){
                    stackforpf.push((num1 + num2) );
                }else if (tokenList[i].equals("-")){
                    stackforpf.push((num1 - num2) );
                }
            }
        }
        return (int) stackforpf.peek();
    }


    /**
     * Infix ifadeyi postfix'e dönüştürür.
     * @param girdi Infix girdi metni
     * @return Dönüştürülmüş postfix ifade
     */
    public static String infixToPostfix(String girdi){
        
        String result ="";
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<girdi.length();i++){
            char ch = girdi.charAt(i);
            
            
            if(Character.isDigit(ch)){
                int basamak=basamakBulucu(girdi,i);
                if(basamak==1){
                result+=ch+" ";
                }else{
                    for (int s = 1; s <= basamak; s++) {                        
                        ch = girdi.charAt(i);
                        result+=ch;
                        if((basamak-s)!=0)
                            i++;
                    }
                    result+=" ";
                }
                
            }else if(isOperator(ch)){
                
                while (!stack.isEmpty() && OpPrec(ch) <= OpPrec(stack.peek())&& stack.peek()!='('){ 
                    
                    result += stack.pop()+ " "; 
                } 
                stack.push(ch);
            
            }else if(isLeftParanthesis(ch)){
                stack.push(ch);
            }else if(isRightParanthesis(ch)){
                while(stack.peek()!='(' ){
                    result+=stack.pop()+" ";
                }
                stack.pop();//sondaki sol parantez için
            }
            
            
        }
        while (!stack.isEmpty()){
            if(stack.size()>1)
                result += stack.pop()+" ";
            else
                result += stack.pop();
        }       
                
        return result;
    }
    
    protected static int basamakBulucu(String girdi, int sayac) {
        int basamak=1;
        int length=girdi.length();
        while(length>(sayac+1)){
            char ch = girdi.charAt(++sayac);
        
            if(Character.isDigit(ch)){
                basamak++;             
            }else
                break;
        }
                
        return basamak;
    }

    protected static boolean isOperator(char ch){
        return ch == '+'|| ch == '-'|| ch == '*'|| ch == '/';
    }

    protected static boolean isLeftParanthesis(char ch){
        return ch == '(';
    }
    
    protected static boolean isRightParanthesis(char ch){
        return ch == ')';
    }

    protected static int OpPrec(char ch){
        switch(ch){
          case '+':
          case '-':
              return 1;  
          case '*':
          case '/':
              return 2;
        }
        return 1;
    }
    



    /**
     * Infix ifadeyi sembollerine ayıran metod
     * @param girdi Infix ifade
     * @return Sembol dizisi
     */
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

}
