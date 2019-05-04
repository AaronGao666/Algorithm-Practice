package algorithm;

import java.util.Stack;
public class checkValidParenthese {

        public boolean checkInside(Stack<Integer> primestack, Stack<Integer> otherstack1, Stack<Integer> otherstack2){   //返回是否中间夹住了别的括号
            if(otherstack1.empty()&&otherstack2.empty()){
                return false;
            }//中间没有别的夹住
            else{
                if(otherstack1.empty()){
                    if(otherstack2.peek()>primestack.peek())  return true;
                    else return false;
                }
                else if(otherstack2.empty()){
                    if(otherstack1.peek()>primestack.peek()) return true;
                    else return false;
                }
                else {//两个都有值
                    int temp=otherstack1.peek()>otherstack2.peek()?otherstack1.peek():otherstack2.peek();
                    if(temp>primestack.peek()) return true;
                    else return false;
                }
            }
        }

        public boolean checkParenthese(char c){
            if(c=='('||c==')'||c=='{'||c=='}'||c=='['||c==']') return true;
            else return false;
        }

        public boolean checkValidParenthese(String s){
            int index=0;//当前遍历的字符位置
            Stack<Integer> sp=new Stack<Integer>();//小括号左半括号位置寄存栈
            Stack<Integer> mp=new Stack<Integer>();//中...
            Stack<Integer> lp=new Stack<Integer>();//大...
            char[] c=s.toCharArray();
            for(index=0;index<c.length;index++){
                if(checkParenthese(c[index])){
                    switch (c[index]) {
                        case '(':sp.push(index) ;continue;
                        case ')':{
                            if(sp.empty()) return false;//前面已经没有可以和本字符配对的小括号了
                            else{
                                if(checkInside(sp,mp,lp)) return false;
                                else {
                                    sp.pop();
                                    continue;
                                }
                            }
                        }
                        case '[':mp.push(index) ; continue;
                        case ']':{
                            if(mp.empty()) return false;
                            else{
                                if(checkInside(mp,sp,lp)) return false;
                                else {
                                    mp.pop();
                                    continue;
                                }
                            }
                        }
                        case '{':lp.push(index);continue;
                        case '}':{
                            if(lp.empty()) return false;
                            else{
                                if(checkInside(lp,mp,sp)) return false;
                                else {
                                    lp.pop();
                                    continue;
                                }
                            }
                        }
                    }
                }
                else{
                    System.out.println("输入的字符串不全是三种括号，请检查输入！");
                    return false;
                }
            }
            if(sp.empty()&&mp.empty()&&lp.empty())  return true; else return false;//当遍历完了以后如果三个栈都是空，则表示正确
        }

    public static void main(String[] args){

            String s="()()()(){}{}(((((()))))){}[]";//测试用的字符串
            checkValidParenthese ck=new checkValidParenthese();
            System.out.println(ck.checkValidParenthese(s));//打印最后结果
    }

}
