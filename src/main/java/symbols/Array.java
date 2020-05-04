package symbols;
import lexer.*;
/**
 * @author Brave
 */
public class Array extends Type {
   // array *of* type

   public Type of;
   // number of elements

   public int size;
   public Array(int sz, Type p) {
      super("[]", Tag.INDEX, sz*p.width); size = sz;  of = p;
   }
   @Override
   public String toString() { return "[" + size + "] " + of.toString(); }
}
