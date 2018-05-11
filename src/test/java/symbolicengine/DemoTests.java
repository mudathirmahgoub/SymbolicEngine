package symbolicengine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cparser.syntaxtree.CNode;
import symbolicengine.Answer;
import symbolicengine.Result;
import symbolicengine.SymbolicEngine;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DemoTests
{

    @BeforeEach
    public void clear()
    {
        CNode.symbolicValues.clear();
        SymbolicEngine.debug = true;
    }

    @Test()
    void simpleTest1() throws IOException
    {
        String code = "void f () { assert (true);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
    }

    @Test()
    void simpleTest2() throws IOException
    {
        String code = "void f () { assert (false);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }

    @Test()
    void simpleTest3() throws IOException
    {
        String code = "void f () { assert (0);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }

    @Test()
    void simpleTest4() throws IOException
    {
        String code = "void f () { assert (5);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }


    @Test()
    void simpleTest5() throws IOException
    {
        String code = "void f () { assert (5 + 3);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }

    @Test()
    void simpleTest6() throws IOException
    {
        String code = "void f () { assert (5 - 3);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }

    @Test()
    void simpleTest7() throws IOException
    {
        String code = "void f () { assert (5 - 7);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }

    @Test()
    void simpleTest8() throws IOException
    {
        String code = "void f () { assert (5 * 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }

    @Test()
    void simpleTest9() throws IOException
    {
        String code = "void f () { assert (5 / 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }

    @Test()
    void simpleTest10() throws IOException
    {
        String code = "void f () { assert (5 % 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }

    @Test()
    void simpleTest11() throws IOException
    {
        String code = "void f () { assert (5 > 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }

    @Test()
    void simpleTest12() throws IOException
    {
        String code = "void f () { assert (5 >= 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }


    @Test()
    void simpleTest13() throws IOException
    {
        String code = "void f () { assert (5 < 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }

    @Test()
    void simpleTest14() throws IOException
    {
        String code = "void f () { assert (5 <= 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }


    @Test()
    void simpleTest15() throws IOException
    {
        String code = "void f () { assert (5 == 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }

    @Test()
    void simpleTest16() throws IOException
    {
        String code = "void f () { assert (5 != 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }

    /**************************************************************************/

    @Test()
    void simpleTestWithArguments1() throws IOException
    {
        String code = "void f (int x) { assert (x > 0);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(1, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
        assertEquals("{x=0}", result.assertions.get(0).assertionFormulas.get(0).counterExample.toString());
    }

    @Test()
    void simpleTestWithArguments2() throws IOException
    {
        String code = "void f (int x, int y) { assert (x + y > -1);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(2, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
        assertEquals("{x=-1, y=0}", result.assertions.get(0).assertionFormulas.get(0).counterExample.toString());
    }

    @Test()
    void simpleTestWithArguments3SquareAlwaysPositive() throws IOException
    {
        String code = "void f (int x) { assert (x * x >= 0);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
    }

    @Test()
    void simpleTestWithArguments4AlwaysNegative() throws IOException
    {
        String code = "void f (int x) { assert (x * -x <= 0);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
    }

    /**************************************************************************/
    @Test()
    void simpleTestWithAssignment1() throws IOException
    {
        String code = "void f (int x) { x = 1;  assert (x > 0);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
    }

    @Test()
    void simpleTestWithAssignment2() throws IOException
    {
        String code = "void f (int x) { x = 1;  assert (x == 1);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
    }

    @Test()
    void simpleTestWithAssignment3() throws IOException
    {
        String code = "void f (int x) { x = x;  assert (x != x);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.assertions.get(0).assertionFormulas.get(0).counterExample.size());
    }

    @Test()
    void simpleTestWithAssignment4() throws IOException
    {
        String code = "void f (int x) { x = x;  assert (x + 1 >= x);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
    }

    @Test()
    void simpleTestWithAssignment5() throws IOException
    {
        String code = "void f (int x) { x = x + 5;  assert (x >= 0);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals("{x=-6}", result.assertions.get(0).assertionFormulas.get(0).counterExample.toString());
    }

    @Test()
    void simpleTestWithAssignment6() throws IOException
    {
        String code = "void f (int x, int y) { x = x + y + 5;  assert (x >= 0);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals("{x=-6, y=0}", result.assertions.get(0).assertionFormulas.get(0).counterExample.toString());
    }

    @Test()
    void simpleTestWithAssignment7() throws IOException
    {
        String code = "void f (int x, int y) { x = x * y;  assert (x <= 0);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals("{x=1, y=1}", result.assertions.get(0).assertionFormulas.get(0).counterExample.toString());
    }

    /**********************************************************/

    @Test()
    void plusPlus1() throws IOException
    {
        String code = "void f (int x) { x ++;  assert (x <= 5);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals("{x=5}", result.assertions.get(0).assertionFormulas.get(0).counterExample.toString());
    }

    @Test()
    void plusPlus2() throws IOException
    {
        String code = "void f (int x) {x = 0; ++x;  assert (x >= 1);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
    }

    /**********************************************************/
    @Test()
    void simpleTestWithVariableDefinition1() throws IOException
    {
        String code = "void f (int x, int y) { int z ;  assert (z >= z);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
    }

    @Test()
    void simpleTestWithVariableDefinition2() throws IOException
    {
        String code = "void f (int x, int y) { int z = x * y;  assert (z <= 0);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals("{x=1, y=1}", result.assertions.get(0).assertionFormulas.get(0).counterExample.toString());
    }

    @Test()
    void simpleTestWithVariableDefinition3() throws IOException
    {
        String code = "void f (int x, int y) { int z = - x * x;  assert (z <= 0);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
    }

    /**********************************************************/
    @Test()
    void ifTest1() throws IOException
    {
        String code = "void f (int x, int y) { if(x > 0) y = x;  assert (y == x);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals("{x=0, y=1}", result.assertions.get(0).assertionFormulas.get(1).counterExample.toString());

        System.out.println(result);
    }

    @Test()
    void ifTest2() throws IOException
    {
        String code = "void f (int x, int y) {" +
                    "if(x > 0) y = x; " +
                    "else y = x;  " +
                    "assert (y == x);" +
                "}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
    }


    /**********************************************************/

    @Test()
    void testDivisionAssertions1() throws IOException
    {
        String code = "void f (int x, int y) {x = x / y;}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals("{x=null, y=0}", result.assertions.get(0).assertionFormulas.get(0).counterExample.toString());
    }

    @Test()
    void testDivisionAssertions2() throws IOException
    {
        String code = "void f (int x, int y) {x = x / ((x+1)*(x+1) + (y+1)*(y+1));}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals("{x=-1, y=-1}", result.assertions.get(0).assertionFormulas.get(0).counterExample.toString());
    }

    @Test()
    void testDivisionAssertions3() throws IOException
    {
        String code = "void f (int x, int y) {x = x / (x*x + y*y + 1);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
    }



    /**********************************************************/

    @Test()
    void examProblem() throws IOException
    {
        String code = "int function_to_test(int x, int y) {" +
                "/*Suppose inputs x and y are set to have symbolic values */" +
                "" +
                "int k = x - y;" +
                "int t = x + y + 3;" +
                "if(x % 2 == 0) /* check whether x is even; remainder is 0 when x is divisible by 2 */" +
                "{" +
                "x = y + 1;" +
                "++y; /* Increment y value by 1 */" +
                "if(t > 0){" +
                "k = t - 2;" +
                "}" +
                "}" +
                "if(x+6 > k) {" +
                "y = 5;" +
                "}" +
                "if(t+x+y == 20){ /* Check whether t+x+y is equal to 20*/" +
                "assert(0); /* Bug */" +
                "}" +
                "" +
                "int z = (t + x + y) / x;" +
                "return z;" +
                "}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
    }

    /**********************************************************/

    @Test()
    void unknown() throws IOException
    {
        String code = "void f (int x, int y, int z) " +
                "{assert(!((x*x*x + y*y*y == z*z*z) && (x>10) && (y>10) && (z>10)));}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Unknown, result.isValid);
    }
}
