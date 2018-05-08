// Generated from C.g4 by ANTLR 4.7.1
package parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BooleanConstant=1, Break=2, Case=3, Char=4, Const=5, Continue=6, Do=7, 
		Double=8, Else=9, Enum=10, For=11, Goto=12, If=13, Long=14, Return=15, 
		Short=16, Signed=17, Sizeof=18, Struct=19, Switch=20, Unsigned=21, Void=22, 
		While=23, LeftParen=24, RightParen=25, LeftBracket=26, RightBracket=27, 
		LeftBrace=28, RightBrace=29, Less=30, LessEqual=31, Greater=32, GreaterEqual=33, 
		LeftShift=34, RightShift=35, Plus=36, PlusPlus=37, Minus=38, MinusMinus=39, 
		Star=40, Div=41, Mod=42, And=43, Or=44, AndAnd=45, OrOr=46, Caret=47, 
		Not=48, Tilde=49, Question=50, Colon=51, Semi=52, Comma=53, Assign=54, 
		StarAssign=55, DivAssign=56, ModAssign=57, PlusAssign=58, MinusAssign=59, 
		LeftShiftAssign=60, RightShiftAssign=61, AndAssign=62, XorAssign=63, OrAssign=64, 
		Equal=65, NotEqual=66, Arrow=67, Dot=68, IntegerType=69, Identifier=70, 
		IdentifierLetter=71, Integer=72, Digit=73, Whitespace=74, Newline=75, 
		BlockComment=76, LineComment=77;
	public static final int
		RULE_program = 0, RULE_functionDefinition = 1, RULE_variableDefinition = 2, 
		RULE_arguments = 3, RULE_argument = 4, RULE_type = 5, RULE_block = 6, 
		RULE_statement = 7, RULE_expression = 8, RULE_functionCall = 9;
	public static final String[] ruleNames = {
		"program", "functionDefinition", "variableDefinition", "arguments", "argument", 
		"type", "block", "statement", "expression", "functionCall"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'break'", "'case'", "'char'", "'const'", "'continue'", "'do'", 
		"'double'", "'else'", "'enum'", "'for'", "'goto'", "'if'", "'long'", "'return'", 
		"'short'", "'signed'", "'sizeof'", "'struct'", "'switch'", "'unsigned'", 
		"'void'", "'while'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", 
		"'<='", "'>'", "'>='", "'<<'", "'>>'", "'+'", "'++'", "'-'", "'--'", "'*'", 
		"'/'", "'%'", "'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", "'?'", 
		"':'", "';'", "','", "'='", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", 
		"'>>='", "'&='", "'^='", "'|='", "'=='", "'!='", "'->'", "'.'", "'int'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BooleanConstant", "Break", "Case", "Char", "Const", "Continue", 
		"Do", "Double", "Else", "Enum", "For", "Goto", "If", "Long", "Return", 
		"Short", "Signed", "Sizeof", "Struct", "Switch", "Unsigned", "Void", "While", 
		"LeftParen", "RightParen", "LeftBracket", "RightBracket", "LeftBrace", 
		"RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", "LeftShift", 
		"RightShift", "Plus", "PlusPlus", "Minus", "MinusMinus", "Star", "Div", 
		"Mod", "And", "Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", 
		"Colon", "Semi", "Comma", "Assign", "StarAssign", "DivAssign", "ModAssign", 
		"PlusAssign", "MinusAssign", "LeftShiftAssign", "RightShiftAssign", "AndAssign", 
		"XorAssign", "OrAssign", "Equal", "NotEqual", "Arrow", "Dot", "IntegerType", 
		"Identifier", "IdentifierLetter", "Integer", "Digit", "Whitespace", "Newline", 
		"BlockComment", "LineComment"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "C.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CVisitor ) return ((CVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(22);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(20);
					functionDefinition();
					}
					break;
				case 2:
					{
					setState(21);
					variableDefinition();
					}
					break;
				}
				}
				setState(24); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Void || _la==IntegerType );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CVisitor ) return ((CVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			type();
			setState(27);
			match(Identifier);
			setState(28);
			match(LeftParen);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Void || _la==IntegerType) {
				{
				setState(29);
				arguments();
				}
			}

			setState(32);
			match(RightParen);
			setState(33);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDefinitionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterVariableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitVariableDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CVisitor ) return ((CVisitor<? extends T>)visitor).visitVariableDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variableDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			type();
			setState(36);
			match(Identifier);
			{
			setState(37);
			match(Assign);
			setState(38);
			expression(0);
			}
			setState(40);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CVisitor ) return ((CVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			argument();
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(43);
				match(Comma);
				setState(44);
				argument();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CVisitor ) return ((CVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			type();
			setState(51);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode IntegerType() { return getToken(CParser.IntegerType, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CVisitor ) return ((CVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_la = _input.LA(1);
			if ( !(_la==Void || _la==IntegerType) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CVisitor ) return ((CVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(LeftBrace);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (If - 13)) | (1L << (Return - 13)) | (1L << (Void - 13)) | (1L << (LeftBrace - 13)) | (1L << (PlusPlus - 13)) | (1L << (IntegerType - 13)) | (1L << (Identifier - 13)))) != 0)) {
				{
				{
				setState(56);
				statement();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VariableDefinitionContext variableDefinition() {
			return getRuleContext(VariableDefinitionContext.class,0);
		}
		public TerminalNode If() { return getToken(CParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode PlusPlus() { return getToken(CParser.PlusPlus, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CVisitor ) return ((CVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		int _la;
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				variableDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				match(If);
				setState(67);
				match(LeftParen);
				setState(68);
				expression(0);
				setState(69);
				match(RightParen);
				setState(70);
				statement();
				setState(73);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(71);
					match(Else);
					setState(72);
					statement();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				match(Return);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanConstant) | (1L << LeftParen) | (1L << Minus) | (1L << Not))) != 0) || _la==Identifier || _la==Integer) {
					{
					setState(76);
					expression(0);
					}
				}

				setState(79);
				match(Semi);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(80);
				match(Identifier);
				setState(81);
				match(Assign);
				setState(82);
				expression(0);
				setState(83);
				match(Semi);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(85);
				functionCall();
				setState(86);
				match(Semi);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(88);
				match(PlusPlus);
				setState(89);
				match(Identifier);
				setState(90);
				match(Semi);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(91);
				match(Identifier);
				setState(92);
				match(PlusPlus);
				setState(93);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public TerminalNode Integer() { return getToken(CParser.Integer, 0); }
		public TerminalNode BooleanConstant() { return getToken(CParser.BooleanConstant, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CVisitor ) return ((CVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(97);
				functionCall();
				}
				break;
			case 2:
				{
				setState(98);
				match(Minus);
				setState(99);
				expression(15);
				}
				break;
			case 3:
				{
				setState(100);
				match(Not);
				setState(101);
				expression(14);
				}
				break;
			case 4:
				{
				setState(102);
				match(Identifier);
				}
				break;
			case 5:
				{
				setState(103);
				match(Integer);
				}
				break;
			case 6:
				{
				setState(104);
				match(BooleanConstant);
				}
				break;
			case 7:
				{
				setState(105);
				match(LeftParen);
				setState(106);
				expression(0);
				setState(107);
				match(RightParen);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(145);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(143);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(111);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(112);
						match(Star);
						setState(113);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(114);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(115);
						match(Div);
						setState(116);
						expression(13);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(117);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(118);
						match(Mod);
						setState(119);
						expression(12);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(120);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(121);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(122);
						expression(11);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(123);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(124);
						match(Greater);
						setState(125);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(126);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(127);
						match(GreaterEqual);
						setState(128);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(129);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(130);
						match(Less);
						setState(131);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(132);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(133);
						match(LessEqual);
						setState(134);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(135);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(136);
						match(Equal);
						setState(137);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(138);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(139);
						match(LeftBracket);
						setState(140);
						expression(0);
						setState(141);
						match(RightBracket);
						}
						break;
					}
					} 
				}
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CVisitor ) return ((CVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(Identifier);
			setState(149);
			match(LeftParen);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanConstant) | (1L << LeftParen) | (1L << Minus) | (1L << Not))) != 0) || _la==Identifier || _la==Integer) {
				{
				setState(150);
				expression(0);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(151);
					match(Comma);
					setState(152);
					expression(0);
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(160);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3O\u00a5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\6\2\31\n\2\r\2\16\2\32\3\3\3\3\3\3\3\3\5\3!\n\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5\60\n\5\f\5\16\5\63\13\5"+
		"\3\6\3\6\3\6\3\7\3\7\3\b\3\b\7\b<\n\b\f\b\16\b?\13\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tL\n\t\3\t\3\t\5\tP\n\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\ta\n\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\np\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0092\n\n\f\n\16\n\u0095\13\n\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u009c\n\13\f\13\16\13\u009f\13\13\5\13\u00a1"+
		"\n\13\3\13\3\13\3\13\2\3\22\f\2\4\6\b\n\f\16\20\22\24\2\4\4\2\30\30GG"+
		"\4\2&&((\2\u00ba\2\30\3\2\2\2\4\34\3\2\2\2\6%\3\2\2\2\b,\3\2\2\2\n\64"+
		"\3\2\2\2\f\67\3\2\2\2\169\3\2\2\2\20`\3\2\2\2\22o\3\2\2\2\24\u0096\3\2"+
		"\2\2\26\31\5\4\3\2\27\31\5\6\4\2\30\26\3\2\2\2\30\27\3\2\2\2\31\32\3\2"+
		"\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\3\3\2\2\2\34\35\5\f\7\2\35\36\7H\2"+
		"\2\36 \7\32\2\2\37!\5\b\5\2 \37\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"#\7\33\2"+
		"\2#$\5\16\b\2$\5\3\2\2\2%&\5\f\7\2&\'\7H\2\2\'(\78\2\2()\5\22\n\2)*\3"+
		"\2\2\2*+\7\66\2\2+\7\3\2\2\2,\61\5\n\6\2-.\7\67\2\2.\60\5\n\6\2/-\3\2"+
		"\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\t\3\2\2\2\63\61\3\2\2"+
		"\2\64\65\5\f\7\2\65\66\7H\2\2\66\13\3\2\2\2\678\t\2\2\28\r\3\2\2\29=\7"+
		"\36\2\2:<\5\20\t\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?"+
		"=\3\2\2\2@A\7\37\2\2A\17\3\2\2\2Ba\5\16\b\2Ca\5\6\4\2DE\7\17\2\2EF\7\32"+
		"\2\2FG\5\22\n\2GH\7\33\2\2HK\5\20\t\2IJ\7\13\2\2JL\5\20\t\2KI\3\2\2\2"+
		"KL\3\2\2\2La\3\2\2\2MO\7\21\2\2NP\5\22\n\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2"+
		"\2Qa\7\66\2\2RS\7H\2\2ST\78\2\2TU\5\22\n\2UV\7\66\2\2Va\3\2\2\2WX\5\24"+
		"\13\2XY\7\66\2\2Ya\3\2\2\2Z[\7\'\2\2[\\\7H\2\2\\a\7\66\2\2]^\7H\2\2^_"+
		"\7\'\2\2_a\7\66\2\2`B\3\2\2\2`C\3\2\2\2`D\3\2\2\2`M\3\2\2\2`R\3\2\2\2"+
		"`W\3\2\2\2`Z\3\2\2\2`]\3\2\2\2a\21\3\2\2\2bc\b\n\1\2cp\5\24\13\2de\7("+
		"\2\2ep\5\22\n\21fg\7\62\2\2gp\5\22\n\20hp\7H\2\2ip\7J\2\2jp\7\3\2\2kl"+
		"\7\32\2\2lm\5\22\n\2mn\7\33\2\2np\3\2\2\2ob\3\2\2\2od\3\2\2\2of\3\2\2"+
		"\2oh\3\2\2\2oi\3\2\2\2oj\3\2\2\2ok\3\2\2\2p\u0093\3\2\2\2qr\f\17\2\2r"+
		"s\7*\2\2s\u0092\5\22\n\20tu\f\16\2\2uv\7+\2\2v\u0092\5\22\n\17wx\f\r\2"+
		"\2xy\7,\2\2y\u0092\5\22\n\16z{\f\f\2\2{|\t\3\2\2|\u0092\5\22\n\r}~\f\13"+
		"\2\2~\177\7\"\2\2\177\u0092\5\22\n\f\u0080\u0081\f\n\2\2\u0081\u0082\7"+
		"#\2\2\u0082\u0092\5\22\n\13\u0083\u0084\f\t\2\2\u0084\u0085\7 \2\2\u0085"+
		"\u0092\5\22\n\n\u0086\u0087\f\b\2\2\u0087\u0088\7!\2\2\u0088\u0092\5\22"+
		"\n\t\u0089\u008a\f\7\2\2\u008a\u008b\7C\2\2\u008b\u0092\5\22\n\b\u008c"+
		"\u008d\f\22\2\2\u008d\u008e\7\34\2\2\u008e\u008f\5\22\n\2\u008f\u0090"+
		"\7\35\2\2\u0090\u0092\3\2\2\2\u0091q\3\2\2\2\u0091t\3\2\2\2\u0091w\3\2"+
		"\2\2\u0091z\3\2\2\2\u0091}\3\2\2\2\u0091\u0080\3\2\2\2\u0091\u0083\3\2"+
		"\2\2\u0091\u0086\3\2\2\2\u0091\u0089\3\2\2\2\u0091\u008c\3\2\2\2\u0092"+
		"\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\23\3\2\2"+
		"\2\u0095\u0093\3\2\2\2\u0096\u0097\7H\2\2\u0097\u00a0\7\32\2\2\u0098\u009d"+
		"\5\22\n\2\u0099\u009a\7\67\2\2\u009a\u009c\5\22\n\2\u009b\u0099\3\2\2"+
		"\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a1"+
		"\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u0098\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\u00a3\7\33\2\2\u00a3\25\3\2\2\2\17\30\32 \61=KO`"+
		"o\u0091\u0093\u009d\u00a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}