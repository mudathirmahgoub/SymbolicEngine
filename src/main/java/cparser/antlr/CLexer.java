// Generated from C.g4 by ANTLR 4.7.1
package cparser.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BooleanConstant", "Break", "Case", "Char", "Const", "Continue", "Do", 
		"Double", "Else", "Enum", "For", "Goto", "If", "Long", "Return", "Short", 
		"Signed", "Sizeof", "Struct", "Switch", "Unsigned", "Void", "While", "LeftParen", 
		"RightParen", "LeftBracket", "RightBracket", "LeftBrace", "RightBrace", 
		"Less", "LessEqual", "Greater", "GreaterEqual", "LeftShift", "RightShift", 
		"Plus", "PlusPlus", "Minus", "MinusMinus", "Star", "Div", "Mod", "And", 
		"Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", "Colon", 
		"Semi", "Comma", "Assign", "StarAssign", "DivAssign", "ModAssign", "PlusAssign", 
		"MinusAssign", "LeftShiftAssign", "RightShiftAssign", "AndAssign", "XorAssign", 
		"OrAssign", "Equal", "NotEqual", "Arrow", "Dot", "IntegerType", "Identifier", 
		"IdentifierLetter", "Integer", "Digit", "Whitespace", "Newline", "BlockComment", 
		"LineComment"
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


	public CLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "C.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2O\u01d8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\5\2\u00a7\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3"+
		"\"\3#\3#\3#\3$\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3+\3"+
		"+\3,\3,\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63"+
		"\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\38\39\39\39\3:\3:\3:\3"+
		";\3;\3;\3<\3<\3<\3=\3=\3=\3=\3>\3>\3>\3>\3?\3?\3?\3@\3@\3@\3A\3A\3A\3"+
		"B\3B\3B\3C\3C\3C\3D\3D\3D\3E\3E\3F\3F\3F\3F\3G\3G\3G\7G\u01a2\nG\fG\16"+
		"G\u01a5\13G\3H\3H\3I\6I\u01aa\nI\rI\16I\u01ab\3J\3J\3K\6K\u01b1\nK\rK"+
		"\16K\u01b2\3K\3K\3L\3L\5L\u01b9\nL\3L\5L\u01bc\nL\3L\3L\3M\3M\3M\3M\7"+
		"M\u01c4\nM\fM\16M\u01c7\13M\3M\3M\3M\3M\3M\3N\3N\3N\3N\7N\u01d2\nN\fN"+
		"\16N\u01d5\13N\3N\3N\3\u01c5\2O\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60"+
		"_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085"+
		"D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099"+
		"N\u009bO\3\2\5\5\2C\\aac|\4\2\13\13\"\"\4\2\f\f\17\17\2\u01e0\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2"+
		"c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3"+
		"\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2"+
		"\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3"+
		"\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2"+
		"\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\3\u00a6\3\2\2\2\5\u00a8\3\2\2"+
		"\2\7\u00ae\3\2\2\2\t\u00b3\3\2\2\2\13\u00b8\3\2\2\2\r\u00be\3\2\2\2\17"+
		"\u00c7\3\2\2\2\21\u00ca\3\2\2\2\23\u00d1\3\2\2\2\25\u00d6\3\2\2\2\27\u00db"+
		"\3\2\2\2\31\u00df\3\2\2\2\33\u00e4\3\2\2\2\35\u00e7\3\2\2\2\37\u00ec\3"+
		"\2\2\2!\u00f3\3\2\2\2#\u00f9\3\2\2\2%\u0100\3\2\2\2\'\u0107\3\2\2\2)\u010e"+
		"\3\2\2\2+\u0115\3\2\2\2-\u011e\3\2\2\2/\u0123\3\2\2\2\61\u0129\3\2\2\2"+
		"\63\u012b\3\2\2\2\65\u012d\3\2\2\2\67\u012f\3\2\2\29\u0131\3\2\2\2;\u0133"+
		"\3\2\2\2=\u0135\3\2\2\2?\u0137\3\2\2\2A\u013a\3\2\2\2C\u013c\3\2\2\2E"+
		"\u013f\3\2\2\2G\u0142\3\2\2\2I\u0145\3\2\2\2K\u0147\3\2\2\2M\u014a\3\2"+
		"\2\2O\u014c\3\2\2\2Q\u014f\3\2\2\2S\u0151\3\2\2\2U\u0153\3\2\2\2W\u0155"+
		"\3\2\2\2Y\u0157\3\2\2\2[\u0159\3\2\2\2]\u015c\3\2\2\2_\u015f\3\2\2\2a"+
		"\u0161\3\2\2\2c\u0163\3\2\2\2e\u0165\3\2\2\2g\u0167\3\2\2\2i\u0169\3\2"+
		"\2\2k\u016b\3\2\2\2m\u016d\3\2\2\2o\u016f\3\2\2\2q\u0172\3\2\2\2s\u0175"+
		"\3\2\2\2u\u0178\3\2\2\2w\u017b\3\2\2\2y\u017e\3\2\2\2{\u0182\3\2\2\2}"+
		"\u0186\3\2\2\2\177\u0189\3\2\2\2\u0081\u018c\3\2\2\2\u0083\u018f\3\2\2"+
		"\2\u0085\u0192\3\2\2\2\u0087\u0195\3\2\2\2\u0089\u0198\3\2\2\2\u008b\u019a"+
		"\3\2\2\2\u008d\u019e\3\2\2\2\u008f\u01a6\3\2\2\2\u0091\u01a9\3\2\2\2\u0093"+
		"\u01ad\3\2\2\2\u0095\u01b0\3\2\2\2\u0097\u01bb\3\2\2\2\u0099\u01bf\3\2"+
		"\2\2\u009b\u01cd\3\2\2\2\u009d\u009e\7v\2\2\u009e\u009f\7t\2\2\u009f\u00a0"+
		"\7w\2\2\u00a0\u00a7\7g\2\2\u00a1\u00a2\7h\2\2\u00a2\u00a3\7c\2\2\u00a3"+
		"\u00a4\7n\2\2\u00a4\u00a5\7u\2\2\u00a5\u00a7\7g\2\2\u00a6\u009d\3\2\2"+
		"\2\u00a6\u00a1\3\2\2\2\u00a7\4\3\2\2\2\u00a8\u00a9\7d\2\2\u00a9\u00aa"+
		"\7t\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7m\2\2\u00ad"+
		"\6\3\2\2\2\u00ae\u00af\7e\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7u\2\2\u00b1"+
		"\u00b2\7g\2\2\u00b2\b\3\2\2\2\u00b3\u00b4\7e\2\2\u00b4\u00b5\7j\2\2\u00b5"+
		"\u00b6\7c\2\2\u00b6\u00b7\7t\2\2\u00b7\n\3\2\2\2\u00b8\u00b9\7e\2\2\u00b9"+
		"\u00ba\7q\2\2\u00ba\u00bb\7p\2\2\u00bb\u00bc\7u\2\2\u00bc\u00bd\7v\2\2"+
		"\u00bd\f\3\2\2\2\u00be\u00bf\7e\2\2\u00bf\u00c0\7q\2\2\u00c0\u00c1\7p"+
		"\2\2\u00c1\u00c2\7v\2\2\u00c2\u00c3\7k\2\2\u00c3\u00c4\7p\2\2\u00c4\u00c5"+
		"\7w\2\2\u00c5\u00c6\7g\2\2\u00c6\16\3\2\2\2\u00c7\u00c8\7f\2\2\u00c8\u00c9"+
		"\7q\2\2\u00c9\20\3\2\2\2\u00ca\u00cb\7f\2\2\u00cb\u00cc\7q\2\2\u00cc\u00cd"+
		"\7w\2\2\u00cd\u00ce\7d\2\2\u00ce\u00cf\7n\2\2\u00cf\u00d0\7g\2\2\u00d0"+
		"\22\3\2\2\2\u00d1\u00d2\7g\2\2\u00d2\u00d3\7n\2\2\u00d3\u00d4\7u\2\2\u00d4"+
		"\u00d5\7g\2\2\u00d5\24\3\2\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7p\2\2\u00d8"+
		"\u00d9\7w\2\2\u00d9\u00da\7o\2\2\u00da\26\3\2\2\2\u00db\u00dc\7h\2\2\u00dc"+
		"\u00dd\7q\2\2\u00dd\u00de\7t\2\2\u00de\30\3\2\2\2\u00df\u00e0\7i\2\2\u00e0"+
		"\u00e1\7q\2\2\u00e1\u00e2\7v\2\2\u00e2\u00e3\7q\2\2\u00e3\32\3\2\2\2\u00e4"+
		"\u00e5\7k\2\2\u00e5\u00e6\7h\2\2\u00e6\34\3\2\2\2\u00e7\u00e8\7n\2\2\u00e8"+
		"\u00e9\7q\2\2\u00e9\u00ea\7p\2\2\u00ea\u00eb\7i\2\2\u00eb\36\3\2\2\2\u00ec"+
		"\u00ed\7t\2\2\u00ed\u00ee\7g\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7w\2\2"+
		"\u00f0\u00f1\7t\2\2\u00f1\u00f2\7p\2\2\u00f2 \3\2\2\2\u00f3\u00f4\7u\2"+
		"\2\u00f4\u00f5\7j\2\2\u00f5\u00f6\7q\2\2\u00f6\u00f7\7t\2\2\u00f7\u00f8"+
		"\7v\2\2\u00f8\"\3\2\2\2\u00f9\u00fa\7u\2\2\u00fa\u00fb\7k\2\2\u00fb\u00fc"+
		"\7i\2\2\u00fc\u00fd\7p\2\2\u00fd\u00fe\7g\2\2\u00fe\u00ff\7f\2\2\u00ff"+
		"$\3\2\2\2\u0100\u0101\7u\2\2\u0101\u0102\7k\2\2\u0102\u0103\7|\2\2\u0103"+
		"\u0104\7g\2\2\u0104\u0105\7q\2\2\u0105\u0106\7h\2\2\u0106&\3\2\2\2\u0107"+
		"\u0108\7u\2\2\u0108\u0109\7v\2\2\u0109\u010a\7t\2\2\u010a\u010b\7w\2\2"+
		"\u010b\u010c\7e\2\2\u010c\u010d\7v\2\2\u010d(\3\2\2\2\u010e\u010f\7u\2"+
		"\2\u010f\u0110\7y\2\2\u0110\u0111\7k\2\2\u0111\u0112\7v\2\2\u0112\u0113"+
		"\7e\2\2\u0113\u0114\7j\2\2\u0114*\3\2\2\2\u0115\u0116\7w\2\2\u0116\u0117"+
		"\7p\2\2\u0117\u0118\7u\2\2\u0118\u0119\7k\2\2\u0119\u011a\7i\2\2\u011a"+
		"\u011b\7p\2\2\u011b\u011c\7g\2\2\u011c\u011d\7f\2\2\u011d,\3\2\2\2\u011e"+
		"\u011f\7x\2\2\u011f\u0120\7q\2\2\u0120\u0121\7k\2\2\u0121\u0122\7f\2\2"+
		"\u0122.\3\2\2\2\u0123\u0124\7y\2\2\u0124\u0125\7j\2\2\u0125\u0126\7k\2"+
		"\2\u0126\u0127\7n\2\2\u0127\u0128\7g\2\2\u0128\60\3\2\2\2\u0129\u012a"+
		"\7*\2\2\u012a\62\3\2\2\2\u012b\u012c\7+\2\2\u012c\64\3\2\2\2\u012d\u012e"+
		"\7]\2\2\u012e\66\3\2\2\2\u012f\u0130\7_\2\2\u01308\3\2\2\2\u0131\u0132"+
		"\7}\2\2\u0132:\3\2\2\2\u0133\u0134\7\177\2\2\u0134<\3\2\2\2\u0135\u0136"+
		"\7>\2\2\u0136>\3\2\2\2\u0137\u0138\7>\2\2\u0138\u0139\7?\2\2\u0139@\3"+
		"\2\2\2\u013a\u013b\7@\2\2\u013bB\3\2\2\2\u013c\u013d\7@\2\2\u013d\u013e"+
		"\7?\2\2\u013eD\3\2\2\2\u013f\u0140\7>\2\2\u0140\u0141\7>\2\2\u0141F\3"+
		"\2\2\2\u0142\u0143\7@\2\2\u0143\u0144\7@\2\2\u0144H\3\2\2\2\u0145\u0146"+
		"\7-\2\2\u0146J\3\2\2\2\u0147\u0148\7-\2\2\u0148\u0149\7-\2\2\u0149L\3"+
		"\2\2\2\u014a\u014b\7/\2\2\u014bN\3\2\2\2\u014c\u014d\7/\2\2\u014d\u014e"+
		"\7/\2\2\u014eP\3\2\2\2\u014f\u0150\7,\2\2\u0150R\3\2\2\2\u0151\u0152\7"+
		"\61\2\2\u0152T\3\2\2\2\u0153\u0154\7\'\2\2\u0154V\3\2\2\2\u0155\u0156"+
		"\7(\2\2\u0156X\3\2\2\2\u0157\u0158\7~\2\2\u0158Z\3\2\2\2\u0159\u015a\7"+
		"(\2\2\u015a\u015b\7(\2\2\u015b\\\3\2\2\2\u015c\u015d\7~\2\2\u015d\u015e"+
		"\7~\2\2\u015e^\3\2\2\2\u015f\u0160\7`\2\2\u0160`\3\2\2\2\u0161\u0162\7"+
		"#\2\2\u0162b\3\2\2\2\u0163\u0164\7\u0080\2\2\u0164d\3\2\2\2\u0165\u0166"+
		"\7A\2\2\u0166f\3\2\2\2\u0167\u0168\7<\2\2\u0168h\3\2\2\2\u0169\u016a\7"+
		"=\2\2\u016aj\3\2\2\2\u016b\u016c\7.\2\2\u016cl\3\2\2\2\u016d\u016e\7?"+
		"\2\2\u016en\3\2\2\2\u016f\u0170\7,\2\2\u0170\u0171\7?\2\2\u0171p\3\2\2"+
		"\2\u0172\u0173\7\61\2\2\u0173\u0174\7?\2\2\u0174r\3\2\2\2\u0175\u0176"+
		"\7\'\2\2\u0176\u0177\7?\2\2\u0177t\3\2\2\2\u0178\u0179\7-\2\2\u0179\u017a"+
		"\7?\2\2\u017av\3\2\2\2\u017b\u017c\7/\2\2\u017c\u017d\7?\2\2\u017dx\3"+
		"\2\2\2\u017e\u017f\7>\2\2\u017f\u0180\7>\2\2\u0180\u0181\7?\2\2\u0181"+
		"z\3\2\2\2\u0182\u0183\7@\2\2\u0183\u0184\7@\2\2\u0184\u0185\7?\2\2\u0185"+
		"|\3\2\2\2\u0186\u0187\7(\2\2\u0187\u0188\7?\2\2\u0188~\3\2\2\2\u0189\u018a"+
		"\7`\2\2\u018a\u018b\7?\2\2\u018b\u0080\3\2\2\2\u018c\u018d\7~\2\2\u018d"+
		"\u018e\7?\2\2\u018e\u0082\3\2\2\2\u018f\u0190\7?\2\2\u0190\u0191\7?\2"+
		"\2\u0191\u0084\3\2\2\2\u0192\u0193\7#\2\2\u0193\u0194\7?\2\2\u0194\u0086"+
		"\3\2\2\2\u0195\u0196\7/\2\2\u0196\u0197\7@\2\2\u0197\u0088\3\2\2\2\u0198"+
		"\u0199\7\60\2\2\u0199\u008a\3\2\2\2\u019a\u019b\7k\2\2\u019b\u019c\7p"+
		"\2\2\u019c\u019d\7v\2\2\u019d\u008c\3\2\2\2\u019e\u01a3\5\u008fH\2\u019f"+
		"\u01a2\5\u008fH\2\u01a0\u01a2\5\u0093J\2\u01a1\u019f\3\2\2\2\u01a1\u01a0"+
		"\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4"+
		"\u008e\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01a7\t\2\2\2\u01a7\u0090\3\2"+
		"\2\2\u01a8\u01aa\5\u0093J\2\u01a9\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab"+
		"\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u0092\3\2\2\2\u01ad\u01ae\4\62"+
		";\2\u01ae\u0094\3\2\2\2\u01af\u01b1\t\3\2\2\u01b0\u01af\3\2\2\2\u01b1"+
		"\u01b2\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\3\2"+
		"\2\2\u01b4\u01b5\bK\2\2\u01b5\u0096\3\2\2\2\u01b6\u01b8\7\17\2\2\u01b7"+
		"\u01b9\7\f\2\2\u01b8\u01b7\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01bc\3\2"+
		"\2\2\u01ba\u01bc\7\f\2\2\u01bb\u01b6\3\2\2\2\u01bb\u01ba\3\2\2\2\u01bc"+
		"\u01bd\3\2\2\2\u01bd\u01be\bL\2\2\u01be\u0098\3\2\2\2\u01bf\u01c0\7\61"+
		"\2\2\u01c0\u01c1\7,\2\2\u01c1\u01c5\3\2\2\2\u01c2\u01c4\13\2\2\2\u01c3"+
		"\u01c2\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c5\u01c3\3\2"+
		"\2\2\u01c6\u01c8\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c8\u01c9\7,\2\2\u01c9"+
		"\u01ca\7\61\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cc\bM\2\2\u01cc\u009a\3\2"+
		"\2\2\u01cd\u01ce\7\61\2\2\u01ce\u01cf\7\61\2\2\u01cf\u01d3\3\2\2\2\u01d0"+
		"\u01d2\n\4\2\2\u01d1\u01d0\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3\u01d1\3\2"+
		"\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d6"+
		"\u01d7\bN\2\2\u01d7\u009c\3\2\2\2\f\2\u00a6\u01a1\u01a3\u01ab\u01b2\u01b8"+
		"\u01bb\u01c5\u01d3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}