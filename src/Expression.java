/**
 * Created by redno on 24/07/2018.
 */
public class Expression {

    private int a, b;
    private Expression b2;
    private boolean expresb;
    private int n;

    Expression( int v1, int v2, int v3){
        a = v1;
        b = v2;
        n = v3;
        expresb = false;
    }

    Expression( int v1, Expression v2, int v3){
        a = v1;
        b2 = v2;
        n = v3;
        expresb = true;
    }

    public int evalExpres(){
        int val = 1;
        if (expresb){
            b = b2.evalExpres();
        }
        if (n>2){
            Expression temp = makeDeepExpres();
            val = temp.evalExpres();
        }else if(n == 2){
            Expression temp = makeDeepExpres();
            val = temp.evalExpres();
        }else if (n == 1){
            val = (int)Math.pow(a,b);
        }
        return val;
    }

    private Expression makeDeepExpres(){
        Expression deep = new Expression(a, a, n-1);
        for (int ct = 0; ct < b-2; ct++){
            deep = new Expression(a, deep, n-1);
        }
        return deep;
    }

    public static void main(String[] args){
        Expression e = new Expression(2,4,1);
        System.out.println(e.evalExpres());
        e = new Expression(2,4,2);
        System.out.println(e.evalExpres());
        e = new Expression(2,3,3);
        System.out.println(e.evalExpres());
    }
}
