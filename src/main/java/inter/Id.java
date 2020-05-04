package inter;
import lexer.*; import symbols.*;

/**
 * @author Brave
 */
public class Id extends Expr {
	// relative address

	public int offset;

	public Id(Word id, Type p, int b) { super(id, p); offset = b; }

	@Override
	public String toString() {return op.toString() + "#" + offset; }
}
