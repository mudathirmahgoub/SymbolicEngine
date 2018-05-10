// Generated from Smt.g4 by ANTLR 4.7.1
package smtparser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SmtParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SmtVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SmtParser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(SmtParser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmtParser#definitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinitions(SmtParser.DefinitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmtParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(SmtParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmtParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SmtParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmtParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(SmtParser.ValueContext ctx);
}