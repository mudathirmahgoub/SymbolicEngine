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
}
