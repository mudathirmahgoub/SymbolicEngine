// Generated from C.g4 by ANTLR 4.7.1
package parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(CParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(CParser.VariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(CParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(CParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(CParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(CParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CParser#argumentExpressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentExpressions(CParser.ArgumentExpressionsContext ctx);
}