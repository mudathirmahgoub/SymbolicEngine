package rules;

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
    }

    @Test()
    void simplestTest1() throws IOException
    {
        String code = "void f () { assert (true);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
    }

    @Test()
    void simplestTest2() throws IOException
    {
        String code = "void f () { assert (false);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest3() throws IOException
    {
        String code = "void f () { assert (0);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest4() throws IOException
    {
        String code = "void f () { assert (5);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }


    @Test()
    void simplestTest5() throws IOException
    {
        String code = "void f () { assert (5 + 3);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest6() throws IOException
    {
        String code = "void f () { assert (5 - 3);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest7() throws IOException
    {
        String code = "void f () { assert (5 - 7);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest8() throws IOException
    {
        String code = "void f () { assert (5 * 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest9() throws IOException
    {
        String code = "void f () { assert (5 / 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest10() throws IOException
    {
        String code = "void f () { assert (5 % 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest11() throws IOException
    {
        String code = "void f () { assert (5 > 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest12() throws IOException
    {
        String code = "void f () { assert (5 >= 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }


    @Test()
    void simplestTest13() throws IOException
    {
        String code = "void f () { assert (5 < 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest14() throws IOException
    {
        String code = "void f () { assert (5 <= 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.counterExample.size());
    }


    @Test()
    void simplestTest15() throws IOException
    {
        String code = "void f () { assert (5 == 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest16() throws IOException
    {
        String code = "void f () { assert (5 != 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTestWithArguments1() throws IOException
    {
        String code = "void f (int x) { assert (x > 0);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(1, result.counterExample.size());
        assertEquals("{x=0}", result.counterExample.toString());
    }

    @Test()
    void simplestTestWithArguments2() throws IOException
    {
        String code = "void f (int x, int y) { assert (x + y > 0);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(2, result.counterExample.size());
        assertEquals("{x=0, y=0}", result.counterExample.toString());
    }

}
