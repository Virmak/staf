// Generated from Staf.g4 by ANTLR 4.8
package com.sparkit.staf.core.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StafParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SINGLE_STRING=1, DOUBLE_STRING=2, EQUAL=3, COMMA=4, LPARENT=5, RPARENT=6, 
		LBRACKET=7, RBRACKET=8, LBRACE=9, RBRACE=10, DOT=11, COLON=12, DOLLAR=13, 
		TRUE=14, FALSE=15, INT=16, FLOAT=17, COMMENT=18, SPACE=19, NL=20, IN=21, 
		TEST_SUITE=22, IMPORTS=23, IMPORT=24, VARS=25, KEYWORDS=26, TEST_CASES=27, 
		BEGIN=28, END=29, RETURN=30, FOR=31, ENDFOR=32, NULL=33, GIVEN=34, WHEN=35, 
		THEN=36, IDENTIFIER=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SINGLE_STRING", "DOUBLE_STRING", "EQUAL", "COMMA", "LPARENT", "RPARENT", 
			"LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "DOT", "COLON", "DOLLAR", 
			"TRUE", "FALSE", "INT", "FLOAT", "COMMENT", "SPACE", "NL", "IN", "TEST_SUITE", 
			"IMPORTS", "IMPORT", "VARS", "KEYWORDS", "TEST_CASES", "BEGIN", "END", 
			"RETURN", "FOR", "ENDFOR", "NULL", "GIVEN", "WHEN", "THEN", "IDENTIFIER", 
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'='", "','", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"'.'", "':'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SINGLE_STRING", "DOUBLE_STRING", "EQUAL", "COMMA", "LPARENT", 
			"RPARENT", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "DOT", "COLON", 
			"DOLLAR", "TRUE", "FALSE", "INT", "FLOAT", "COMMENT", "SPACE", "NL", 
			"IN", "TEST_SUITE", "IMPORTS", "IMPORT", "VARS", "KEYWORDS", "TEST_CASES", 
			"BEGIN", "END", "RETURN", "FOR", "ENDFOR", "NULL", "GIVEN", "WHEN", "THEN", 
			"IDENTIFIER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public StafParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Staf.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u0188\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\6\2\u0084\n\2\r\2\16\2\u0085\3\2\3\2\3\3\3"+
		"\3\6\3\u008c\n\3\r\3\16\3\u008d\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\6\21\u00b4\n\21"+
		"\r\21\16\21\u00b5\3\22\6\22\u00b9\n\22\r\22\16\22\u00ba\3\22\3\22\6\22"+
		"\u00bf\n\22\r\22\16\22\u00c0\3\23\3\23\7\23\u00c5\n\23\f\23\16\23\u00c8"+
		"\13\23\3\23\3\23\3\24\6\24\u00cd\n\24\r\24\16\24\u00ce\3\24\3\24\3\25"+
		"\3\25\3\25\5\25\u00d6\n\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\7\27\u00e2\n\27\f\27\16\27\u00e5\13\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\7\27\u00ed\n\27\f\27\16\27\u00f0\13\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\7\34\u0114\n\34\f\34\16\34\u0117\13\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\""+
		"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\6&\u0151\n&\r"+
		"&\16&\u0152\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3"+
		"\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3"+
		"\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\2\2A\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o"+
		"\2q\2s\2u\2w\2y\2{\2}\2\177\2\3\2\"\3\2))\3\2$$\3\2\62;\4\2\f\f\17\17"+
		"\4\2\13\13\"\"\5\2\62;C\\c|\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4"+
		"\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPp"+
		"p\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2"+
		"YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u0179\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3\u0081"+
		"\3\2\2\2\5\u0089\3\2\2\2\7\u0091\3\2\2\2\t\u0093\3\2\2\2\13\u0095\3\2"+
		"\2\2\r\u0097\3\2\2\2\17\u0099\3\2\2\2\21\u009b\3\2\2\2\23\u009d\3\2\2"+
		"\2\25\u009f\3\2\2\2\27\u00a1\3\2\2\2\31\u00a3\3\2\2\2\33\u00a5\3\2\2\2"+
		"\35\u00a7\3\2\2\2\37\u00ac\3\2\2\2!\u00b3\3\2\2\2#\u00b8\3\2\2\2%\u00c2"+
		"\3\2\2\2\'\u00cc\3\2\2\2)\u00d5\3\2\2\2+\u00d9\3\2\2\2-\u00dc\3\2\2\2"+
		"/\u00f1\3\2\2\2\61\u00f9\3\2\2\2\63\u0100\3\2\2\2\65\u0105\3\2\2\2\67"+
		"\u010e\3\2\2\29\u011e\3\2\2\2;\u0124\3\2\2\2=\u0128\3\2\2\2?\u012f\3\2"+
		"\2\2A\u0133\3\2\2\2C\u013a\3\2\2\2E\u013f\3\2\2\2G\u0145\3\2\2\2I\u014a"+
		"\3\2\2\2K\u0150\3\2\2\2M\u0154\3\2\2\2O\u0156\3\2\2\2Q\u0158\3\2\2\2S"+
		"\u015a\3\2\2\2U\u015c\3\2\2\2W\u015e\3\2\2\2Y\u0160\3\2\2\2[\u0162\3\2"+
		"\2\2]\u0164\3\2\2\2_\u0166\3\2\2\2a\u0168\3\2\2\2c\u016a\3\2\2\2e\u016c"+
		"\3\2\2\2g\u016e\3\2\2\2i\u0170\3\2\2\2k\u0172\3\2\2\2m\u0174\3\2\2\2o"+
		"\u0176\3\2\2\2q\u0178\3\2\2\2s\u017a\3\2\2\2u\u017c\3\2\2\2w\u017e\3\2"+
		"\2\2y\u0180\3\2\2\2{\u0182\3\2\2\2}\u0184\3\2\2\2\177\u0186\3\2\2\2\u0081"+
		"\u0083\7)\2\2\u0082\u0084\n\2\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087"+
		"\u0088\7)\2\2\u0088\4\3\2\2\2\u0089\u008b\7$\2\2\u008a\u008c\n\3\2\2\u008b"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7$\2\2\u0090\6\3\2\2\2\u0091\u0092"+
		"\7?\2\2\u0092\b\3\2\2\2\u0093\u0094\7.\2\2\u0094\n\3\2\2\2\u0095\u0096"+
		"\7*\2\2\u0096\f\3\2\2\2\u0097\u0098\7+\2\2\u0098\16\3\2\2\2\u0099\u009a"+
		"\7]\2\2\u009a\20\3\2\2\2\u009b\u009c\7_\2\2\u009c\22\3\2\2\2\u009d\u009e"+
		"\7}\2\2\u009e\24\3\2\2\2\u009f\u00a0\7\177\2\2\u00a0\26\3\2\2\2\u00a1"+
		"\u00a2\7\60\2\2\u00a2\30\3\2\2\2\u00a3\u00a4\7<\2\2\u00a4\32\3\2\2\2\u00a5"+
		"\u00a6\7&\2\2\u00a6\34\3\2\2\2\u00a7\u00a8\5s:\2\u00a8\u00a9\5o8\2\u00a9"+
		"\u00aa\5u;\2\u00aa\u00ab\5U+\2\u00ab\36\3\2\2\2\u00ac\u00ad\5W,\2\u00ad"+
		"\u00ae\5M\'\2\u00ae\u00af\5c\62\2\u00af\u00b0\5q9\2\u00b0\u00b1\5U+\2"+
		"\u00b1 \3\2\2\2\u00b2\u00b4\t\4\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3"+
		"\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\"\3\2\2\2\u00b7\u00b9"+
		"\t\4\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\7\60\2\2\u00bd\u00bf\t"+
		"\4\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1$\3\2\2\2\u00c2\u00c6\7%\2\2\u00c3\u00c5\n\5\2\2\u00c4"+
		"\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2"+
		"\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca\b\23\2\2\u00ca"+
		"&\3\2\2\2\u00cb\u00cd\t\6\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2"+
		"\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1"+
		"\b\24\2\2\u00d1(\3\2\2\2\u00d2\u00d3\7\17\2\2\u00d3\u00d6\7\f\2\2\u00d4"+
		"\u00d6\t\5\2\2\u00d5\u00d2\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2"+
		"\2\2\u00d7\u00d8\b\25\2\2\u00d8*\3\2\2\2\u00d9\u00da\5]/\2\u00da\u00db"+
		"\5g\64\2\u00db,\3\2\2\2\u00dc\u00dd\5s:\2\u00dd\u00de\5U+\2\u00de\u00df"+
		"\5q9\2\u00df\u00e3\5s:\2\u00e0\u00e2\5\'\24\2\u00e1\u00e0\3\2\2\2\u00e2"+
		"\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2"+
		"\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7\5q9\2\u00e7\u00e8\5u;\2\u00e8\u00e9"+
		"\5]/\2\u00e9\u00ea\5s:\2\u00ea\u00ee\5U+\2\u00eb\u00ed\5\'\24\2\u00ec"+
		"\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2"+
		"\2\2\u00ef.\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\5]/\2\u00f2\u00f3"+
		"\5e\63\2\u00f3\u00f4\5k\66\2\u00f4\u00f5\5i\65\2\u00f5\u00f6\5o8\2\u00f6"+
		"\u00f7\5s:\2\u00f7\u00f8\5q9\2\u00f8\60\3\2\2\2\u00f9\u00fa\5]/\2\u00fa"+
		"\u00fb\5e\63\2\u00fb\u00fc\5k\66\2\u00fc\u00fd\5i\65\2\u00fd\u00fe\5o"+
		"8\2\u00fe\u00ff\5s:\2\u00ff\62\3\2\2\2\u0100\u0101\5w<\2\u0101\u0102\5"+
		"M\'\2\u0102\u0103\5o8\2\u0103\u0104\5q9\2\u0104\64\3\2\2\2\u0105\u0106"+
		"\5a\61\2\u0106\u0107\5U+\2\u0107\u0108\5}?\2\u0108\u0109\5y=\2\u0109\u010a"+
		"\5i\65\2\u010a\u010b\5o8\2\u010b\u010c\5S*\2\u010c\u010d\5q9\2\u010d\66"+
		"\3\2\2\2\u010e\u010f\5s:\2\u010f\u0110\5U+\2\u0110\u0111\5q9\2\u0111\u0115"+
		"\5s:\2\u0112\u0114\5\'\24\2\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115"+
		"\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2\2\2\u0117\u0115\3\2"+
		"\2\2\u0118\u0119\5Q)\2\u0119\u011a\5M\'\2\u011a\u011b\5q9\2\u011b\u011c"+
		"\5U+\2\u011c\u011d\5q9\2\u011d8\3\2\2\2\u011e\u011f\5O(\2\u011f\u0120"+
		"\5U+\2\u0120\u0121\5Y-\2\u0121\u0122\5]/\2\u0122\u0123\5g\64\2\u0123:"+
		"\3\2\2\2\u0124\u0125\5U+\2\u0125\u0126\5g\64\2\u0126\u0127\5S*\2\u0127"+
		"<\3\2\2\2\u0128\u0129\5o8\2\u0129\u012a\5U+\2\u012a\u012b\5s:\2\u012b"+
		"\u012c\5u;\2\u012c\u012d\5o8\2\u012d\u012e\5g\64\2\u012e>\3\2\2\2\u012f"+
		"\u0130\5W,\2\u0130\u0131\5i\65\2\u0131\u0132\5o8\2\u0132@\3\2\2\2\u0133"+
		"\u0134\5U+\2\u0134\u0135\5g\64\2\u0135\u0136\5S*\2\u0136\u0137\5W,\2\u0137"+
		"\u0138\5i\65\2\u0138\u0139\5o8\2\u0139B\3\2\2\2\u013a\u013b\5g\64\2\u013b"+
		"\u013c\5u;\2\u013c\u013d\5c\62\2\u013d\u013e\5c\62\2\u013eD\3\2\2\2\u013f"+
		"\u0140\5Y-\2\u0140\u0141\5]/\2\u0141\u0142\5w<\2\u0142\u0143\5U+\2\u0143"+
		"\u0144\5g\64\2\u0144F\3\2\2\2\u0145\u0146\5y=\2\u0146\u0147\5[.\2\u0147"+
		"\u0148\5U+\2\u0148\u0149\5g\64\2\u0149H\3\2\2\2\u014a\u014b\5s:\2\u014b"+
		"\u014c\5[.\2\u014c\u014d\5U+\2\u014d\u014e\5g\64\2\u014eJ\3\2\2\2\u014f"+
		"\u0151\t\7\2\2\u0150\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0150\3\2"+
		"\2\2\u0152\u0153\3\2\2\2\u0153L\3\2\2\2\u0154\u0155\t\b\2\2\u0155N\3\2"+
		"\2\2\u0156\u0157\t\t\2\2\u0157P\3\2\2\2\u0158\u0159\t\n\2\2\u0159R\3\2"+
		"\2\2\u015a\u015b\t\13\2\2\u015bT\3\2\2\2\u015c\u015d\t\f\2\2\u015dV\3"+
		"\2\2\2\u015e\u015f\t\r\2\2\u015fX\3\2\2\2\u0160\u0161\t\16\2\2\u0161Z"+
		"\3\2\2\2\u0162\u0163\t\17\2\2\u0163\\\3\2\2\2\u0164\u0165\t\20\2\2\u0165"+
		"^\3\2\2\2\u0166\u0167\t\21\2\2\u0167`\3\2\2\2\u0168\u0169\t\22\2\2\u0169"+
		"b\3\2\2\2\u016a\u016b\t\23\2\2\u016bd\3\2\2\2\u016c\u016d\t\24\2\2\u016d"+
		"f\3\2\2\2\u016e\u016f\t\25\2\2\u016fh\3\2\2\2\u0170\u0171\t\26\2\2\u0171"+
		"j\3\2\2\2\u0172\u0173\t\27\2\2\u0173l\3\2\2\2\u0174\u0175\t\30\2\2\u0175"+
		"n\3\2\2\2\u0176\u0177\t\31\2\2\u0177p\3\2\2\2\u0178\u0179\t\32\2\2\u0179"+
		"r\3\2\2\2\u017a\u017b\t\33\2\2\u017bt\3\2\2\2\u017c\u017d\t\34\2\2\u017d"+
		"v\3\2\2\2\u017e\u017f\t\35\2\2\u017fx\3\2\2\2\u0180\u0181\t\36\2\2\u0181"+
		"z\3\2\2\2\u0182\u0183\t\37\2\2\u0183|\3\2\2\2\u0184\u0185\t \2\2\u0185"+
		"~\3\2\2\2\u0186\u0187\t!\2\2\u0187\u0080\3\2\2\2\17\2\u0085\u008d\u00b5"+
		"\u00ba\u00c0\u00c6\u00ce\u00d5\u00e3\u00ee\u0115\u0152\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}