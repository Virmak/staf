// Generated from StafLexer.g4 by ANTLR 4.8
package com.sparkit.staf.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StafLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, SINGLE_STRING=14, DOUBLE_STRING=15, 
		INT=16, FLOAT=17, COMMENT=18, SPACE=19, WS=20, IN=21, TEST_SUITE=22, IMPORTS=23, 
		IMPORT=24, VARS=25, KEYWORDS=26, TEST_CASES=27, BEGIN=28, END=29, RETURN=30, 
		FOR=31, ENDFOR=32, NULL=33, GIVEN=34, WHEN=35, THEN=36, IDENTIFIER=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "SINGLE_STRING", "DOUBLE_STRING", 
			"INT", "FLOAT", "COMMENT", "SPACE", "WS", "IN", "TEST_SUITE", "IMPORTS", 
			"IMPORT", "VARS", "KEYWORDS", "TEST_CASES", "BEGIN", "END", "RETURN", 
			"FOR", "ENDFOR", "NULL", "GIVEN", "WHEN", "THEN", "IDENTIFIER", "A", 
			"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", 
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", 
			"'$'", "'.'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "SINGLE_STRING", "DOUBLE_STRING", "INT", "FLOAT", "COMMENT", 
			"SPACE", "WS", "IN", "TEST_SUITE", "IMPORTS", "IMPORT", "VARS", "KEYWORDS", 
			"TEST_CASES", "BEGIN", "END", "RETURN", "FOR", "ENDFOR", "NULL", "GIVEN", 
			"WHEN", "THEN", "IDENTIFIER"
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


	public StafLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "StafLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u0185\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\6\17\u00a5\n\17\r\17\16\17\u00a6\3\17\3\17"+
		"\3\20\3\20\6\20\u00ad\n\20\r\20\16\20\u00ae\3\20\3\20\3\21\6\21\u00b4"+
		"\n\21\r\21\16\21\u00b5\3\22\6\22\u00b9\n\22\r\22\16\22\u00ba\3\22\3\22"+
		"\6\22\u00bf\n\22\r\22\16\22\u00c0\3\23\3\23\7\23\u00c5\n\23\f\23\16\23"+
		"\u00c8\13\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\6\25\u00d1\n\25\r\25\16"+
		"\25\u00d2\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\7\27\u00df"+
		"\n\27\f\27\16\27\u00e2\13\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00ea"+
		"\n\27\f\27\16\27\u00ed\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\7\34\u0111"+
		"\n\34\f\34\16\34\u0114\13\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3"+
		"#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\6&\u014e\n&\r&\16&\u014f\3\'\3\'"+
		"\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3"+
		"\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\3"+
		"9\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\2\2A\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M\2"+
		"O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2"+
		"}\2\177\2\3\2#\3\2))\3\2$$\3\2\62;\4\2\f\f\17\17\4\2\13\13\"\"\5\2\13"+
		"\f\17\17\"\"\5\2\62;C\\c|\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2"+
		"HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4"+
		"\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYy"+
		"y\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u0175\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3\u0081\3"+
		"\2\2\2\5\u0083\3\2\2\2\7\u0085\3\2\2\2\t\u0087\3\2\2\2\13\u0089\3\2\2"+
		"\2\r\u008b\3\2\2\2\17\u008d\3\2\2\2\21\u008f\3\2\2\2\23\u0091\3\2\2\2"+
		"\25\u0093\3\2\2\2\27\u0095\3\2\2\2\31\u0097\3\2\2\2\33\u009c\3\2\2\2\35"+
		"\u00a2\3\2\2\2\37\u00aa\3\2\2\2!\u00b3\3\2\2\2#\u00b8\3\2\2\2%\u00c2\3"+
		"\2\2\2\'\u00cb\3\2\2\2)\u00d0\3\2\2\2+\u00d6\3\2\2\2-\u00d9\3\2\2\2/\u00ee"+
		"\3\2\2\2\61\u00f6\3\2\2\2\63\u00fd\3\2\2\2\65\u0102\3\2\2\2\67\u010b\3"+
		"\2\2\29\u011b\3\2\2\2;\u0121\3\2\2\2=\u0125\3\2\2\2?\u012c\3\2\2\2A\u0130"+
		"\3\2\2\2C\u0137\3\2\2\2E\u013c\3\2\2\2G\u0142\3\2\2\2I\u0147\3\2\2\2K"+
		"\u014d\3\2\2\2M\u0151\3\2\2\2O\u0153\3\2\2\2Q\u0155\3\2\2\2S\u0157\3\2"+
		"\2\2U\u0159\3\2\2\2W\u015b\3\2\2\2Y\u015d\3\2\2\2[\u015f\3\2\2\2]\u0161"+
		"\3\2\2\2_\u0163\3\2\2\2a\u0165\3\2\2\2c\u0167\3\2\2\2e\u0169\3\2\2\2g"+
		"\u016b\3\2\2\2i\u016d\3\2\2\2k\u016f\3\2\2\2m\u0171\3\2\2\2o\u0173\3\2"+
		"\2\2q\u0175\3\2\2\2s\u0177\3\2\2\2u\u0179\3\2\2\2w\u017b\3\2\2\2y\u017d"+
		"\3\2\2\2{\u017f\3\2\2\2}\u0181\3\2\2\2\177\u0183\3\2\2\2\u0081\u0082\7"+
		"<\2\2\u0082\4\3\2\2\2\u0083\u0084\7*\2\2\u0084\6\3\2\2\2\u0085\u0086\7"+
		".\2\2\u0086\b\3\2\2\2\u0087\u0088\7+\2\2\u0088\n\3\2\2\2\u0089\u008a\7"+
		"?\2\2\u008a\f\3\2\2\2\u008b\u008c\7]\2\2\u008c\16\3\2\2\2\u008d\u008e"+
		"\7_\2\2\u008e\20\3\2\2\2\u008f\u0090\7}\2\2\u0090\22\3\2\2\2\u0091\u0092"+
		"\7\177\2\2\u0092\24\3\2\2\2\u0093\u0094\7&\2\2\u0094\26\3\2\2\2\u0095"+
		"\u0096\7\60\2\2\u0096\30\3\2\2\2\u0097\u0098\7v\2\2\u0098\u0099\7t\2\2"+
		"\u0099\u009a\7w\2\2\u009a\u009b\7g\2\2\u009b\32\3\2\2\2\u009c\u009d\7"+
		"h\2\2\u009d\u009e\7c\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7u\2\2\u00a0\u00a1"+
		"\7g\2\2\u00a1\34\3\2\2\2\u00a2\u00a4\7)\2\2\u00a3\u00a5\n\2\2\2\u00a4"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\7)\2\2\u00a9\36\3\2\2\2\u00aa\u00ac"+
		"\7$\2\2\u00ab\u00ad\n\3\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\7$"+
		"\2\2\u00b1 \3\2\2\2\u00b2\u00b4\t\4\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5"+
		"\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\"\3\2\2\2\u00b7"+
		"\u00b9\t\4\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\7\60\2\2\u00bd"+
		"\u00bf\t\4\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1$\3\2\2\2\u00c2\u00c6\7%\2\2\u00c3\u00c5"+
		"\n\5\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca\b\23"+
		"\2\2\u00ca&\3\2\2\2\u00cb\u00cc\t\6\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce"+
		"\b\24\2\2\u00ce(\3\2\2\2\u00cf\u00d1\t\7\2\2\u00d0\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\3\2"+
		"\2\2\u00d4\u00d5\b\25\2\2\u00d5*\3\2\2\2\u00d6\u00d7\5]/\2\u00d7\u00d8"+
		"\5g\64\2\u00d8,\3\2\2\2\u00d9\u00da\5s:\2\u00da\u00db\5U+\2\u00db\u00dc"+
		"\5q9\2\u00dc\u00e0\5s:\2\u00dd\u00df\5\'\24\2\u00de\u00dd\3\2\2\2\u00df"+
		"\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2"+
		"\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\5q9\2\u00e4\u00e5\5u;\2\u00e5\u00e6"+
		"\5]/\2\u00e6\u00e7\5s:\2\u00e7\u00eb\5U+\2\u00e8\u00ea\5\'\24\2\u00e9"+
		"\u00e8\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2"+
		"\2\2\u00ec.\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\5]/\2\u00ef\u00f0"+
		"\5e\63\2\u00f0\u00f1\5k\66\2\u00f1\u00f2\5i\65\2\u00f2\u00f3\5o8\2\u00f3"+
		"\u00f4\5s:\2\u00f4\u00f5\5q9\2\u00f5\60\3\2\2\2\u00f6\u00f7\5]/\2\u00f7"+
		"\u00f8\5e\63\2\u00f8\u00f9\5k\66\2\u00f9\u00fa\5i\65\2\u00fa\u00fb\5o"+
		"8\2\u00fb\u00fc\5s:\2\u00fc\62\3\2\2\2\u00fd\u00fe\5w<\2\u00fe\u00ff\5"+
		"M\'\2\u00ff\u0100\5o8\2\u0100\u0101\5q9\2\u0101\64\3\2\2\2\u0102\u0103"+
		"\5a\61\2\u0103\u0104\5U+\2\u0104\u0105\5}?\2\u0105\u0106\5y=\2\u0106\u0107"+
		"\5i\65\2\u0107\u0108\5o8\2\u0108\u0109\5S*\2\u0109\u010a\5q9\2\u010a\66"+
		"\3\2\2\2\u010b\u010c\5s:\2\u010c\u010d\5U+\2\u010d\u010e\5q9\2\u010e\u0112"+
		"\5s:\2\u010f\u0111\5\'\24\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2"+
		"\2\2\u0115\u0116\5Q)\2\u0116\u0117\5M\'\2\u0117\u0118\5q9\2\u0118\u0119"+
		"\5U+\2\u0119\u011a\5q9\2\u011a8\3\2\2\2\u011b\u011c\5O(\2\u011c\u011d"+
		"\5U+\2\u011d\u011e\5Y-\2\u011e\u011f\5]/\2\u011f\u0120\5g\64\2\u0120:"+
		"\3\2\2\2\u0121\u0122\5U+\2\u0122\u0123\5g\64\2\u0123\u0124\5S*\2\u0124"+
		"<\3\2\2\2\u0125\u0126\5o8\2\u0126\u0127\5U+\2\u0127\u0128\5s:\2\u0128"+
		"\u0129\5u;\2\u0129\u012a\5o8\2\u012a\u012b\5g\64\2\u012b>\3\2\2\2\u012c"+
		"\u012d\5W,\2\u012d\u012e\5i\65\2\u012e\u012f\5o8\2\u012f@\3\2\2\2\u0130"+
		"\u0131\5U+\2\u0131\u0132\5g\64\2\u0132\u0133\5S*\2\u0133\u0134\5W,\2\u0134"+
		"\u0135\5i\65\2\u0135\u0136\5o8\2\u0136B\3\2\2\2\u0137\u0138\5g\64\2\u0138"+
		"\u0139\5u;\2\u0139\u013a\5c\62\2\u013a\u013b\5c\62\2\u013bD\3\2\2\2\u013c"+
		"\u013d\5Y-\2\u013d\u013e\5]/\2\u013e\u013f\5w<\2\u013f\u0140\5U+\2\u0140"+
		"\u0141\5g\64\2\u0141F\3\2\2\2\u0142\u0143\5y=\2\u0143\u0144\5[.\2\u0144"+
		"\u0145\5U+\2\u0145\u0146\5g\64\2\u0146H\3\2\2\2\u0147\u0148\5s:\2\u0148"+
		"\u0149\5[.\2\u0149\u014a\5U+\2\u014a\u014b\5g\64\2\u014bJ\3\2\2\2\u014c"+
		"\u014e\t\b\2\2\u014d\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u014d\3\2"+
		"\2\2\u014f\u0150\3\2\2\2\u0150L\3\2\2\2\u0151\u0152\t\t\2\2\u0152N\3\2"+
		"\2\2\u0153\u0154\t\n\2\2\u0154P\3\2\2\2\u0155\u0156\t\13\2\2\u0156R\3"+
		"\2\2\2\u0157\u0158\t\f\2\2\u0158T\3\2\2\2\u0159\u015a\t\r\2\2\u015aV\3"+
		"\2\2\2\u015b\u015c\t\16\2\2\u015cX\3\2\2\2\u015d\u015e\t\17\2\2\u015e"+
		"Z\3\2\2\2\u015f\u0160\t\20\2\2\u0160\\\3\2\2\2\u0161\u0162\t\21\2\2\u0162"+
		"^\3\2\2\2\u0163\u0164\t\22\2\2\u0164`\3\2\2\2\u0165\u0166\t\23\2\2\u0166"+
		"b\3\2\2\2\u0167\u0168\t\24\2\2\u0168d\3\2\2\2\u0169\u016a\t\25\2\2\u016a"+
		"f\3\2\2\2\u016b\u016c\t\26\2\2\u016ch\3\2\2\2\u016d\u016e\t\27\2\2\u016e"+
		"j\3\2\2\2\u016f\u0170\t\30\2\2\u0170l\3\2\2\2\u0171\u0172\t\31\2\2\u0172"+
		"n\3\2\2\2\u0173\u0174\t\32\2\2\u0174p\3\2\2\2\u0175\u0176\t\33\2\2\u0176"+
		"r\3\2\2\2\u0177\u0178\t\34\2\2\u0178t\3\2\2\2\u0179\u017a\t\35\2\2\u017a"+
		"v\3\2\2\2\u017b\u017c\t\36\2\2\u017cx\3\2\2\2\u017d\u017e\t\37\2\2\u017e"+
		"z\3\2\2\2\u017f\u0180\t \2\2\u0180|\3\2\2\2\u0181\u0182\t!\2\2\u0182~"+
		"\3\2\2\2\u0183\u0184\t\"\2\2\u0184\u0080\3\2\2\2\16\2\u00a6\u00ae\u00b5"+
		"\u00ba\u00c0\u00c6\u00d2\u00e0\u00eb\u0112\u014f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}