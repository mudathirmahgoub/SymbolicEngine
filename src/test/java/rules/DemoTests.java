package rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import symbolicengine.Answer;
import symbolicengine.Result;
import symbolicengine.SymbolicEngine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DemoTests
{

    @BeforeEach
    public void clear()
    {
    }

    @Test()
    void simplestTest1()
    {
        String code = "void f () { assert (true);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
    }

    @Test()
    void simplestTest2()
    {
        String code = "void f () { assert (false);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest3()
    {
        String code = "void f () { assert (0);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest4()
    {
        String code = "void f () { assert (5);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }


    @Test()
    void simplestTest5()
    {
        String code = "void f () { assert (5 + 3);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest6()
    {
        String code = "void f () { assert (5 - 3);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest7()
    {
        String code = "void f () { assert (5 - 7);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest8()
    {
        String code = "void f () { assert (5 * 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest9()
    {
        String code = "void f () { assert (5 / 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest10()
    {
        String code = "void f () { assert (5 % 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest11()
    {
        String code = "void f () { assert (5 > 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest12()
    {
        String code = "void f () { assert (5 >= 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }


    @Test()
    void simplestTest13()
    {
        String code = "void f () { assert (5 < 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest14()
    {
        String code = "void f () { assert (5 <= 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.counterExample.size());
    }


    @Test()
    void simplestTest15()
    {
        String code = "void f () { assert (5 == 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.No, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTest16()
    {
        String code = "void f () { assert (5 != 2);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

    @Test()
    void simplestTestWithArguments1()
    {
        String code = "void f (int x) { assert (x);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.isValid);
        assertEquals(0, result.counterExample.size());
    }

}
