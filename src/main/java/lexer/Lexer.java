package lexer;

import java.io.*;
import java.util.*;

import symbols.*;

/**
 * @author Brave
 */
public class Lexer {
    public static int line = 1;
    private char peek = ' ';
    private HashMap<String, Word> words = new HashMap<>();

    public Lexer() {

        reserve(new Word("if", Tag.IF));
        reserve(new Word("else", Tag.ELSE));
        reserve(new Word("while", Tag.WHILE));
        reserve(new Word("do", Tag.DO));
        reserve(new Word("break", Tag.BREAK));

        reserve(Word.TRUE);
        reserve(Word.FALSE);

        reserve(Type.INT);
        reserve(Type.CHAR);
        reserve(Type.BOOL);
        reserve(Type.FLOAT);
    }

    private void reserve(Word w) {
        words.put(w.lexeme, w);
    }



    private void readChar() throws IOException {
        peek = (char) System.in.read();
    }

    private boolean readChar(char c) throws IOException {
        readChar();
        if (peek != c) {
            return false;
        }
        peek = ' ';
        return true;
    }

    public Token scan() throws IOException {
        for (; ; readChar()) {
            if (peek == ' ' || peek == '\t') {
                continue;
            } else if (peek == '\n') {
                line = line + 1;
            } else {
                break;
            }
        }
        switch (peek) {
            case '&': return readChar('&') ? Word.AND : new Token('&');
            case '|': return readChar('|') ? Word.OR : new Token('|');
            case '=': return readChar('=') ? Word.EQ : new Token('=');
            case '!': return readChar('=') ? Word.NE : new Token('!');
            case '<': return readChar('=') ? Word.LE : new Token('<');
            case '>': return readChar('=') ? Word.GE : new Token('>');
            default:
        }
        if (Character.isDigit(peek)) {
            int v = 0;
            do {
                v = 10 * v + Character.digit(peek, 10);
                readChar();
            } while (Character.isDigit(peek));
            if (peek != '.') {
                return new Num(v);
            }
            float x = v;
            float d = 10;
            for (; ; ) {
                readChar();
                if (!Character.isDigit(peek)) {
                    break;
                }
                x = x + Character.digit(peek, 10) / d;
                d = d * 10;
            }
            return new Real(x);
        }
        if (Character.isLetter(peek)) {
            StringBuilder b = new StringBuilder();
            do {
                b.append(peek);
                readChar();
            } while (Character.isLetterOrDigit(peek));
            String s = b.toString();
            Word w = words.get(s);
            if (w != null) {
                return w;
            }
            w = new Word(s, Tag.ID);
            words.put(s, w);
            return w;
        }
        Token tok = new Token(peek);
        peek = ' ';
        return tok;
    }
}
