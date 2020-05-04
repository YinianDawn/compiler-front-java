package inter;

/**
 * @author Brave
 */
public class Stmt extends Node {

   public Stmt() { }

   public static Stmt Null = new Stmt();

   public void gen(int b, int a) {} // called with labels begin and after

   // saves label after

   int after = 0;
   // used for break stmts

   public static Stmt Enclosing = Stmt.Null;

   @Override
   public String toString() {
      return "empty";
   }
}
