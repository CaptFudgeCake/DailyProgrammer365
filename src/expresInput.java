import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by redno on 24/07/2018.
 */
public class expresInput {

    private ArrayList<Expression> expresions;
    private File file;

    expresInput(String fp){
        expresions = new ArrayList<>();
        File f = new File(fp);
        file = f;
        Scanner r = null;
        try {
            r = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (r.hasNextLine()) {
            String s = r.nextLine();

            int a = Integer.valueOf(s.substring(0,s.indexOf('↑')));
            int b = Integer.valueOf(s.substring(s.lastIndexOf('↑')+1, s.length()));
            int n = s.substring(s.indexOf('↑'),s.lastIndexOf('↑')+1).length();
            expresions.add(new Expression(a, b, n));
        }
    }

    public void solveExpres(){

        try {
            FileWriter w = new FileWriter(file.getParent() + "\\" + file.getName() + "Answers");
            for (Expression e: expresions){
                int val = e.evalExpres();
                w.write(Integer.toString(val) + "\n");
                w.flush();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args){
        expresInput e = new expresInput(args[0]);
        e.solveExpres();
    }

}
