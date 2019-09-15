package nl.knaake.erik;

import nl.knaake.erik.datastructures.HANStack;

public class BalancedSymbolChecker {
    class MatchingSymbols {
        char opening;
        char closing;

        MatchingSymbols(char opening, char closing) {
            this.opening = opening;
            this.closing = closing;
        }
    }

    private final MatchingSymbols[] matchingSymbols = {
            new MatchingSymbols('(', ')'),
            new MatchingSymbols('{', '}'),
            new MatchingSymbols('[', ']')};

    private HANStack<Character> symbolStack;

    public BalancedSymbolChecker() {
        symbolStack = new HANStack<>();
    }

    public boolean checkBalancedSymbols(String symbols) {
        for(int i = 0; i < symbols.length(); i++) {
            char currentChar = symbols.charAt(i);
            if(isClosingBracket(currentChar)) {
                Character popped = symbolStack.pop();
                if(popped == null || correspondingSymbol(currentChar) != popped)
                    return false;
            }
            else if (isBracketCharacter(currentChar))
                symbolStack.push(symbols.charAt(i));
        }
        return symbolStack.getSize() == 0;
    }

    private Character correspondingSymbol(char symbol) {
        for(MatchingSymbols a : matchingSymbols) {
            if(a.closing == symbol)
                return a.opening;
        }
        return null;
    }

    private boolean isClosingBracket(char symbol) {
        for(MatchingSymbols a : matchingSymbols) {
            if(a.closing == symbol)
                return true;
        }
        return false;
    }

    private boolean isBracketCharacter(char symbol) {
        for(MatchingSymbols a : matchingSymbols) {
            if(a.closing == symbol || a.opening == symbol)
                return true;
        }
        return false;
    }
}
