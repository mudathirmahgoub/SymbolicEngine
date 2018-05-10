// Generated from C.g4 by ANTLR 4.7.1
package cparser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CParser}.
 */
public interface CListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(CParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(CParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(CParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(CParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(CParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(CParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(CParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(CParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(CParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(CParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(CParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(CParser.FunctionCallContext ctx);
}