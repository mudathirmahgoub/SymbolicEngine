package rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import symbolicengine.Answer;
import symbolicengine.Result;
import symbolicengine.SymbolicEngine;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoTests
{

    @BeforeEach
    public void clear()
    {
    }

    @Test()
    void simplestTest()
    {
        String code = "void f () { assert (true);}";
        SymbolicEngine engine = new SymbolicEngine(code);
        Result result= engine.verify();
        assertEquals(Answer.Yes, result.answer);
    }
}
