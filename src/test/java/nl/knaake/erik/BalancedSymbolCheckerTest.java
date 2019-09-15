package nl.knaake.erik;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedSymbolCheckerTest {
    private BalancedSymbolChecker checker;

    @Before
    public void before() {
        checker = new BalancedSymbolChecker();
    }

    @Test
    public void simpleOneBracketType() {
        assertTrue(checker.checkBalancedSymbols("{}"));
    }


    @Test
    public void oneBracketTypeTooManyOpening() {
        assertFalse(checker.checkBalancedSymbols("{"));
    }

    @Test
    public void oneBracketTypeTooManyClosing() {
        assertFalse(checker.checkBalancedSymbols("}"));
    }

    @Test
    public void nestedBrackets() {
        assertTrue(checker.checkBalancedSymbols("{[()]}"));
    }

    @Test
    public void nestedOneOfEachMissingOpening() {
        assertFalse(checker.checkBalancedSymbols(")]}"));
    }

    @Test
    public void nestedOneOfEachMissingClosing() {
        assertFalse(checker.checkBalancedSymbols("([{"));
    }

    @Test
    public void wrongClosingOrder() {
        assertFalse(checker.checkBalancedSymbols("{[(])}"));
    }

    @Test
    public void noSymbols() {
        assertTrue(checker.checkBalancedSymbols(""));
    }

    @Test
    public void noBracketSymbols() {
        assertTrue(checker.checkBalancedSymbols("aab"));
    }
}
