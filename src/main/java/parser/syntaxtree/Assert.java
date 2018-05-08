package parser.syntaxtree;

public class Assert extends Statement
{
    public Expression expression;
    public Assert(Expression expression)
    {
        this.expression = expression;
    }
}
