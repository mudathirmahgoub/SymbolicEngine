// Generated from Smt.g4 by ANTLR 4.7.1
package smtparser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SmtParser}.
 */
public interface SmtListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SmtParser#model}.
	 * @param ctx the parse tree
	 */
	void enterModel(SmtParser.ModelContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmtParser#model}.
	 * @param ctx the parse tree
	 */
	void exitModel(SmtParser.ModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmtParser#definitions}.
	 * @param ctx the parse tree
	 */
	void enterDefinitions(SmtParser.DefinitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmtParser#definitions}.
	 * @param ctx the parse tree
	 */
	void exitDefinitions(SmtParser.DefinitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmtParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(SmtParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmtParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(SmtParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmtParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SmtParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmtParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SmtParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmtParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(SmtParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmtParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(SmtParser.ValueContext ctx);
}