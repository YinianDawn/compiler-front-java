package inter;
import symbols.*;

public class Do extends Stmt {

   Expr expr; Stmt stmt;

   public Do() { expr = null; stmt = null; }

   public void init(Stmt s, Expr x) {
      expr = x; stmt = s;
      if( expr.type != Type.BOOL) expr.error("boolean required in do");
   }

   @Override
   public void gen(int b, int a) {
      after = a;
      int label = newLabel();   // label for expr
      stmt.gen(b,label);
      emitLabel(label);
      expr.jumping(b,0);
   }
}
