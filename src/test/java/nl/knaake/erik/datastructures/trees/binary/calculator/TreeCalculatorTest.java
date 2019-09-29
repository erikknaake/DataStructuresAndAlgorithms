package nl.knaake.erik.datastructures.trees.binary.calculator;

import nl.knaake.erik.datastructures.trees.binary.BinaryTree;
import nl.knaake.erik.datastructures.trees.binary.IApplyBinaryTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeCalculatorTest {
    private IApplyBinaryTree<String, Integer> calculator;
    private BinaryTree<String> tree;

    @Before
    public void before() {
        calculator = new TreeCalculator();
        tree = new BinaryTree<>();
    }

    @Test
    public void singleMultiplication() {
        tree.root.value = "*";
        tree.root.setLeft("4");
        tree.root.setRight("3");

        assertEquals(Integer.valueOf(12), calculator.apply(tree));
    }

    @Test
    public void multiMultiplication() {
        tree.root.value = "*";
        tree.root.setLeft("*");
        tree.root.setRight("3");
        tree.root.left.setLeft("1");
        tree.root.left.setRight("2");

        assertEquals(Integer.valueOf(6), calculator.apply(tree));
    }

    @Test
    public void addition() {
        tree.root.value = "+";
        tree.root.setLeft("1");
        tree.root.setRight("5");

        assertEquals(Integer.valueOf(6), calculator.apply(tree));
    }

    @Test
    public void additionAfterMultiplication() {
        tree.root.value = "+";
        tree.root.setLeft("*");
        tree.root.setRight("5");
        tree.root.left.setLeft("4");
        tree.root.left.setRight("6");

        assertEquals(Integer.valueOf(29), calculator.apply(tree));
    }

    @Test
    public void division() {
        tree.root.value = "/";
        tree.root.setLeft("5");
        tree.root.setRight("2");

        assertEquals(Integer.valueOf(2), calculator.apply(tree));
    }

    @Test
    public void divisionBeforeAddition() {
        tree.root.value = "+";
        tree.root.setLeft("/");
        tree.root.left.setLeft("5");
        tree.root.left.setRight("2");
        tree.root.setRight("2");

        assertEquals(Integer.valueOf(4), calculator.apply(tree));
    }

    @Test
    public void modulo() {
        tree.root.value = "%";
        tree.root.setLeft("5");
        tree.root.setRight("2");

        assertEquals(Integer.valueOf(1), calculator.apply(tree));
    }

    @Test
    public void minus() {
        tree.root.value = "-";
        tree.root.setLeft("5");
        tree.root.setRight("2");

        assertEquals(Integer.valueOf(3), calculator.apply(tree));
    }

    @Test
    public void valueLiteralTree() {
        tree.root.value = "6";
        assertEquals(Integer.valueOf(6), calculator.apply(tree));
    }

    @Test(expected = CalculatorException.class)
    public void unparseable() {
        tree.root.value = "a";
        calculator.apply(tree);
        try {
            calculator.apply(tree);
        } catch (CalculatorException e) {
            assertEquals("a is not a valid string in this expression", e.getMessage());
            throw e;
        }
    }

    @Test(expected = CalculatorException.class)
    public void devideByUnparseable() {
        tree.root.value = "/";
        tree.root.setLeft("2");
        tree.root.setRight("a");
        try {
            calculator.apply(tree);
        } catch (CalculatorException e) {
            assertEquals("a is not a valid string in this expression", e.getMessage());
            throw e;
        }
    }

    @Test(expected = NullPointerException.class)
    public void expressionWithMissingOperand() {
        tree.root.value = "/";
        tree.root.setLeft("2");
        // right intentionally left empty
        calculator.apply(tree);
    }
}
