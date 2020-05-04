package inter;
import lexer.*;

/**
 * @author Brave
 */
public class Node {

   Node() { }

   void error(String s) { throw new Error("near line "+Lexer.line+": "+s); }

   static int labels = 0;

   public int newLabel() { return ++labels; }

   public void emitLabel(int i) { System.out.print("L" + i + ":"); }

   public void emit(String s) { System.out.println("\t" + s); }
}
