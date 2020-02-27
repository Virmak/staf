// Generated from Staf.g4 by ANTLR 4.8
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
		FOR=31, ENDFOR=32, NULL=33, IDENTIFIER=34;
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
			"FOR", "ENDFOR", "NULL", "IDENTIFIER", "A", "B", "C", "D", "E", "F", 
			"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", 
			"U", "V", "W", "X", "Y", "Z"
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
			"TEST_CASES", "BEGIN", "END", "RETURN", "FOR", "ENDFOR", "NULL", "IDENTIFIER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u016f\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\6\17\u009f\n\17\r\17\16\17\u00a0\3\17\3\17\3\20\3\20\6\20\u00a7"+
		"\n\20\r\20\16\20\u00a8\3\20\3\20\3\21\6\21\u00ae\n\21\r\21\16\21\u00af"+
		"\3\22\6\22\u00b3\n\22\r\22\16\22\u00b4\3\22\3\22\6\22\u00b9\n\22\r\22"+
		"\16\22\u00ba\3\23\3\23\7\23\u00bf\n\23\f\23\16\23\u00c2\13\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\25\6\25\u00cb\n\25\r\25\16\25\u00cc\3\25\3\25\3"+
		"\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\7\27\u00d9\n\27\f\27\16\27\u00dc"+
		"\13\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u00e4\n\27\f\27\16\27\u00e7"+
		"\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\7\34\u010b\n\34\f\34\16\34\u010e\13"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!"+
		"\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\6#\u0138\n#\r#\16#\u0139\3$\3$\3%"+
		"\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60"+
		"\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67"+
		"\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\2\2>\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G\2I\2K\2M"+
		"\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2\3"+
		"\2#\3\2))\3\2$$\3\2\62;\4\2\f\f\17\17\4\2\13\13\"\"\5\2\13\f\17\17\"\""+
		"\5\2\62;C\\c|\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii"+
		"\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2R"+
		"Rrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4"+
		"\2[[{{\4\2\\\\||\2\u015f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\3{\3\2\2\2\5}\3\2\2\2\7\177\3\2\2\2\t\u0081\3\2\2\2\13\u0083"+
		"\3\2\2\2\r\u0085\3\2\2\2\17\u0087\3\2\2\2\21\u0089\3\2\2\2\23\u008b\3"+
		"\2\2\2\25\u008d\3\2\2\2\27\u008f\3\2\2\2\31\u0091\3\2\2\2\33\u0096\3\2"+
		"\2\2\35\u009c\3\2\2\2\37\u00a4\3\2\2\2!\u00ad\3\2\2\2#\u00b2\3\2\2\2%"+
		"\u00bc\3\2\2\2\'\u00c5\3\2\2\2)\u00ca\3\2\2\2+\u00d0\3\2\2\2-\u00d3\3"+
		"\2\2\2/\u00e8\3\2\2\2\61\u00f0\3\2\2\2\63\u00f7\3\2\2\2\65\u00fc\3\2\2"+
		"\2\67\u0105\3\2\2\29\u0115\3\2\2\2;\u011b\3\2\2\2=\u011f\3\2\2\2?\u0126"+
		"\3\2\2\2A\u012a\3\2\2\2C\u0131\3\2\2\2E\u0137\3\2\2\2G\u013b\3\2\2\2I"+
		"\u013d\3\2\2\2K\u013f\3\2\2\2M\u0141\3\2\2\2O\u0143\3\2\2\2Q\u0145\3\2"+
		"\2\2S\u0147\3\2\2\2U\u0149\3\2\2\2W\u014b\3\2\2\2Y\u014d\3\2\2\2[\u014f"+
		"\3\2\2\2]\u0151\3\2\2\2_\u0153\3\2\2\2a\u0155\3\2\2\2c\u0157\3\2\2\2e"+
		"\u0159\3\2\2\2g\u015b\3\2\2\2i\u015d\3\2\2\2k\u015f\3\2\2\2m\u0161\3\2"+
		"\2\2o\u0163\3\2\2\2q\u0165\3\2\2\2s\u0167\3\2\2\2u\u0169\3\2\2\2w\u016b"+
		"\3\2\2\2y\u016d\3\2\2\2{|\7<\2\2|\4\3\2\2\2}~\7*\2\2~\6\3\2\2\2\177\u0080"+
		"\7.\2\2\u0080\b\3\2\2\2\u0081\u0082\7+\2\2\u0082\n\3\2\2\2\u0083\u0084"+
		"\7?\2\2\u0084\f\3\2\2\2\u0085\u0086\7]\2\2\u0086\16\3\2\2\2\u0087\u0088"+
		"\7_\2\2\u0088\20\3\2\2\2\u0089\u008a\7}\2\2\u008a\22\3\2\2\2\u008b\u008c"+
		"\7\177\2\2\u008c\24\3\2\2\2\u008d\u008e\7&\2\2\u008e\26\3\2\2\2\u008f"+
		"\u0090\7\60\2\2\u0090\30\3\2\2\2\u0091\u0092\7v\2\2\u0092\u0093\7t\2\2"+
		"\u0093\u0094\7w\2\2\u0094\u0095\7g\2\2\u0095\32\3\2\2\2\u0096\u0097\7"+
		"h\2\2\u0097\u0098\7c\2\2\u0098\u0099\7n\2\2\u0099\u009a\7u\2\2\u009a\u009b"+
		"\7g\2\2\u009b\34\3\2\2\2\u009c\u009e\7)\2\2\u009d\u009f\n\2\2\2\u009e"+
		"\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\7)\2\2\u00a3\36\3\2\2\2\u00a4\u00a6"+
		"\7$\2\2\u00a5\u00a7\n\3\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\7$"+
		"\2\2\u00ab \3\2\2\2\u00ac\u00ae\t\4\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\"\3\2\2\2\u00b1"+
		"\u00b3\t\4\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\7\60\2\2\u00b7"+
		"\u00b9\t\4\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00ba\u00bb\3\2\2\2\u00bb$\3\2\2\2\u00bc\u00c0\7%\2\2\u00bd\u00bf"+
		"\n\5\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\b\23"+
		"\2\2\u00c4&\3\2\2\2\u00c5\u00c6\t\6\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8"+
		"\b\24\2\2\u00c8(\3\2\2\2\u00c9\u00cb\t\7\2\2\u00ca\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\u00cf\b\25\2\2\u00cf*\3\2\2\2\u00d0\u00d1\5W,\2\u00d1\u00d2"+
		"\5a\61\2\u00d2,\3\2\2\2\u00d3\u00d4\5m\67\2\u00d4\u00d5\5O(\2\u00d5\u00d6"+
		"\5k\66\2\u00d6\u00da\5m\67\2\u00d7\u00d9\5\'\24\2\u00d8\u00d7\3\2\2\2"+
		"\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd"+
		"\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\5k\66\2\u00de\u00df\5o8\2\u00df"+
		"\u00e0\5W,\2\u00e0\u00e1\5m\67\2\u00e1\u00e5\5O(\2\u00e2\u00e4\5\'\24"+
		"\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6"+
		"\3\2\2\2\u00e6.\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9\5W,\2\u00e9\u00ea"+
		"\5_\60\2\u00ea\u00eb\5e\63\2\u00eb\u00ec\5c\62\2\u00ec\u00ed\5i\65\2\u00ed"+
		"\u00ee\5m\67\2\u00ee\u00ef\5k\66\2\u00ef\60\3\2\2\2\u00f0\u00f1\5W,\2"+
		"\u00f1\u00f2\5_\60\2\u00f2\u00f3\5e\63\2\u00f3\u00f4\5c\62\2\u00f4\u00f5"+
		"\5i\65\2\u00f5\u00f6\5m\67\2\u00f6\62\3\2\2\2\u00f7\u00f8\5q9\2\u00f8"+
		"\u00f9\5G$\2\u00f9\u00fa\5i\65\2\u00fa\u00fb\5k\66\2\u00fb\64\3\2\2\2"+
		"\u00fc\u00fd\5[.\2\u00fd\u00fe\5O(\2\u00fe\u00ff\5w<\2\u00ff\u0100\5s"+
		":\2\u0100\u0101\5c\62\2\u0101\u0102\5i\65\2\u0102\u0103\5M\'\2\u0103\u0104"+
		"\5k\66\2\u0104\66\3\2\2\2\u0105\u0106\5m\67\2\u0106\u0107\5O(\2\u0107"+
		"\u0108\5k\66\2\u0108\u010c\5m\67\2\u0109\u010b\5\'\24\2\u010a\u0109\3"+
		"\2\2\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u010f\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0110\5K&\2\u0110\u0111\5G$\2"+
		"\u0111\u0112\5k\66\2\u0112\u0113\5O(\2\u0113\u0114\5k\66\2\u01148\3\2"+
		"\2\2\u0115\u0116\5I%\2\u0116\u0117\5O(\2\u0117\u0118\5S*\2\u0118\u0119"+
		"\5W,\2\u0119\u011a\5a\61\2\u011a:\3\2\2\2\u011b\u011c\5O(\2\u011c\u011d"+
		"\5a\61\2\u011d\u011e\5M\'\2\u011e<\3\2\2\2\u011f\u0120\5i\65\2\u0120\u0121"+
		"\5O(\2\u0121\u0122\5m\67\2\u0122\u0123\5o8\2\u0123\u0124\5i\65\2\u0124"+
		"\u0125\5a\61\2\u0125>\3\2\2\2\u0126\u0127\5Q)\2\u0127\u0128\5c\62\2\u0128"+
		"\u0129\5i\65\2\u0129@\3\2\2\2\u012a\u012b\5O(\2\u012b\u012c\5a\61\2\u012c"+
		"\u012d\5M\'\2\u012d\u012e\5Q)\2\u012e\u012f\5c\62\2\u012f\u0130\5i\65"+
		"\2\u0130B\3\2\2\2\u0131\u0132\5a\61\2\u0132\u0133\5o8\2\u0133\u0134\5"+
		"]/\2\u0134\u0135\5]/\2\u0135D\3\2\2\2\u0136\u0138\t\b\2\2\u0137\u0136"+
		"\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"F\3\2\2\2\u013b\u013c\t\t\2\2\u013cH\3\2\2\2\u013d\u013e\t\n\2\2\u013e"+
		"J\3\2\2\2\u013f\u0140\t\13\2\2\u0140L\3\2\2\2\u0141\u0142\t\f\2\2\u0142"+
		"N\3\2\2\2\u0143\u0144\t\r\2\2\u0144P\3\2\2\2\u0145\u0146\t\16\2\2\u0146"+
		"R\3\2\2\2\u0147\u0148\t\17\2\2\u0148T\3\2\2\2\u0149\u014a\t\20\2\2\u014a"+
		"V\3\2\2\2\u014b\u014c\t\21\2\2\u014cX\3\2\2\2\u014d\u014e\t\22\2\2\u014e"+
		"Z\3\2\2\2\u014f\u0150\t\23\2\2\u0150\\\3\2\2\2\u0151\u0152\t\24\2\2\u0152"+
		"^\3\2\2\2\u0153\u0154\t\25\2\2\u0154`\3\2\2\2\u0155\u0156\t\26\2\2\u0156"+
		"b\3\2\2\2\u0157\u0158\t\27\2\2\u0158d\3\2\2\2\u0159\u015a\t\30\2\2\u015a"+
		"f\3\2\2\2\u015b\u015c\t\31\2\2\u015ch\3\2\2\2\u015d\u015e\t\32\2\2\u015e"+
		"j\3\2\2\2\u015f\u0160\t\33\2\2\u0160l\3\2\2\2\u0161\u0162\t\34\2\2\u0162"+
		"n\3\2\2\2\u0163\u0164\t\35\2\2\u0164p\3\2\2\2\u0165\u0166\t\36\2\2\u0166"+
		"r\3\2\2\2\u0167\u0168\t\37\2\2\u0168t\3\2\2\2\u0169\u016a\t \2\2\u016a"+
		"v\3\2\2\2\u016b\u016c\t!\2\2\u016cx\3\2\2\2\u016d\u016e\t\"\2\2\u016e"+
		"z\3\2\2\2\16\2\u00a0\u00a8\u00af\u00b4\u00ba\u00c0\u00cc\u00da\u00e5\u010c"+
		"\u0139\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}