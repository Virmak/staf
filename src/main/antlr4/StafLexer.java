// Generated from Staf.g4 by ANTLR 4.8
package com.sparkit.staf;
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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, SINGLE_STRING=15, DOUBLE_STRING=16, 
		INT=17, FLOAT=18, COMMENT=19, SPACE=20, WS=21, IN=22, TEST_SUITE=23, IMPORTS=24, 
		IMPORT=25, VARS=26, KEYWORDS=27, TEST_CASES=28, BEGIN=29, END=30, RETURN=31, 
		FOR=32, ENDFOR=33, IDENTIFIER=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "SINGLE_STRING", "DOUBLE_STRING", 
			"INT", "FLOAT", "COMMENT", "SPACE", "WS", "IN", "TEST_SUITE", "IMPORTS", 
			"IMPORT", "VARS", "KEYWORDS", "TEST_CASES", "BEGIN", "END", "RETURN", 
			"FOR", "ENDFOR", "IDENTIFIER", "A", "B", "C", "D", "E", "F", "G", "H", 
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", 
			"W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'('", "','", "')'", "'='", "'['", "']'", "'{'", "'}'", 
			"'${'", "'.'", "'$'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "SINGLE_STRING", "DOUBLE_STRING", "INT", "FLOAT", "COMMENT", 
			"SPACE", "WS", "IN", "TEST_SUITE", "IMPORTS", "IMPORT", "VARS", "KEYWORDS", 
			"TEST_CASES", "BEGIN", "END", "RETURN", "FOR", "ENDFOR", "IDENTIFIER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u016d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\6\20\u00a2\n\20\r\20\16\20\u00a3\3\20\3\20"+
		"\3\21\3\21\6\21\u00aa\n\21\r\21\16\21\u00ab\3\21\3\21\3\22\6\22\u00b1"+
		"\n\22\r\22\16\22\u00b2\3\23\6\23\u00b6\n\23\r\23\16\23\u00b7\3\23\3\23"+
		"\6\23\u00bc\n\23\r\23\16\23\u00bd\3\24\3\24\7\24\u00c2\n\24\f\24\16\24"+
		"\u00c5\13\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\6\26\u00ce\n\26\r\26\16"+
		"\26\u00cf\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\7\30\u00dc"+
		"\n\30\f\30\16\30\u00df\13\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u00e7"+
		"\n\30\f\30\16\30\u00ea\13\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\7\35\u010e"+
		"\n\35\f\35\16\35\u0111\13\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3"+
		"!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\6#\u0136\n#\r#\16#\u0137\3$\3$\3%\3%"+
		"\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3"+
		"\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3"+
		"\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\2\2>\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G\2I\2K\2M\2O\2"+
		"Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2\3\2#\3"+
		"\2))\3\2$$\3\2\62;\4\2\f\f\17\17\4\2\13\13\"\"\5\2\13\f\17\17\"\"\5\2"+
		"\62;C\\c|\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2"+
		"JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4"+
		"\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{"+
		"{\4\2\\\\||\2\u015d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\2E\3\2\2\2\3{\3\2\2\2\5}\3\2\2\2\7\177\3\2\2\2\t\u0081\3\2\2\2\13\u0083"+
		"\3\2\2\2\r\u0085\3\2\2\2\17\u0087\3\2\2\2\21\u0089\3\2\2\2\23\u008b\3"+
		"\2\2\2\25\u008d\3\2\2\2\27\u0090\3\2\2\2\31\u0092\3\2\2\2\33\u0094\3\2"+
		"\2\2\35\u0099\3\2\2\2\37\u009f\3\2\2\2!\u00a7\3\2\2\2#\u00b0\3\2\2\2%"+
		"\u00b5\3\2\2\2\'\u00bf\3\2\2\2)\u00c8\3\2\2\2+\u00cd\3\2\2\2-\u00d3\3"+
		"\2\2\2/\u00d6\3\2\2\2\61\u00eb\3\2\2\2\63\u00f3\3\2\2\2\65\u00fa\3\2\2"+
		"\2\67\u00ff\3\2\2\29\u0108\3\2\2\2;\u0118\3\2\2\2=\u011e\3\2\2\2?\u0122"+
		"\3\2\2\2A\u0129\3\2\2\2C\u012d\3\2\2\2E\u0135\3\2\2\2G\u0139\3\2\2\2I"+
		"\u013b\3\2\2\2K\u013d\3\2\2\2M\u013f\3\2\2\2O\u0141\3\2\2\2Q\u0143\3\2"+
		"\2\2S\u0145\3\2\2\2U\u0147\3\2\2\2W\u0149\3\2\2\2Y\u014b\3\2\2\2[\u014d"+
		"\3\2\2\2]\u014f\3\2\2\2_\u0151\3\2\2\2a\u0153\3\2\2\2c\u0155\3\2\2\2e"+
		"\u0157\3\2\2\2g\u0159\3\2\2\2i\u015b\3\2\2\2k\u015d\3\2\2\2m\u015f\3\2"+
		"\2\2o\u0161\3\2\2\2q\u0163\3\2\2\2s\u0165\3\2\2\2u\u0167\3\2\2\2w\u0169"+
		"\3\2\2\2y\u016b\3\2\2\2{|\7<\2\2|\4\3\2\2\2}~\7*\2\2~\6\3\2\2\2\177\u0080"+
		"\7.\2\2\u0080\b\3\2\2\2\u0081\u0082\7+\2\2\u0082\n\3\2\2\2\u0083\u0084"+
		"\7?\2\2\u0084\f\3\2\2\2\u0085\u0086\7]\2\2\u0086\16\3\2\2\2\u0087\u0088"+
		"\7_\2\2\u0088\20\3\2\2\2\u0089\u008a\7}\2\2\u008a\22\3\2\2\2\u008b\u008c"+
		"\7\177\2\2\u008c\24\3\2\2\2\u008d\u008e\7&\2\2\u008e\u008f\7}\2\2\u008f"+
		"\26\3\2\2\2\u0090\u0091\7\60\2\2\u0091\30\3\2\2\2\u0092\u0093\7&\2\2\u0093"+
		"\32\3\2\2\2\u0094\u0095\7v\2\2\u0095\u0096\7t\2\2\u0096\u0097\7w\2\2\u0097"+
		"\u0098\7g\2\2\u0098\34\3\2\2\2\u0099\u009a\7h\2\2\u009a\u009b\7c\2\2\u009b"+
		"\u009c\7n\2\2\u009c\u009d\7u\2\2\u009d\u009e\7g\2\2\u009e\36\3\2\2\2\u009f"+
		"\u00a1\7)\2\2\u00a0\u00a2\n\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a6\7)\2\2\u00a6 \3\2\2\2\u00a7\u00a9\7$\2\2\u00a8\u00aa\n\3\2\2\u00a9"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7$\2\2\u00ae\"\3\2\2\2\u00af\u00b1"+
		"\t\4\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3$\3\2\2\2\u00b4\u00b6\t\4\2\2\u00b5\u00b4\3\2\2\2"+
		"\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9"+
		"\3\2\2\2\u00b9\u00bb\7\60\2\2\u00ba\u00bc\t\4\2\2\u00bb\u00ba\3\2\2\2"+
		"\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be&\3"+
		"\2\2\2\u00bf\u00c3\7%\2\2\u00c0\u00c2\n\5\2\2\u00c1\u00c0\3\2\2\2\u00c2"+
		"\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2"+
		"\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\b\24\2\2\u00c7(\3\2\2\2\u00c8\u00c9"+
		"\t\6\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\b\25\2\2\u00cb*\3\2\2\2\u00cc"+
		"\u00ce\t\7\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00cd\3\2"+
		"\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\b\26\2\2\u00d2"+
		",\3\2\2\2\u00d3\u00d4\5W,\2\u00d4\u00d5\5a\61\2\u00d5.\3\2\2\2\u00d6\u00d7"+
		"\5m\67\2\u00d7\u00d8\5O(\2\u00d8\u00d9\5k\66\2\u00d9\u00dd\5m\67\2\u00da"+
		"\u00dc\5)\25\2\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2"+
		"\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0"+
		"\u00e1\5k\66\2\u00e1\u00e2\5o8\2\u00e2\u00e3\5W,\2\u00e3\u00e4\5m\67\2"+
		"\u00e4\u00e8\5O(\2\u00e5\u00e7\5)\25\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea"+
		"\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\60\3\2\2\2\u00ea"+
		"\u00e8\3\2\2\2\u00eb\u00ec\5W,\2\u00ec\u00ed\5_\60\2\u00ed\u00ee\5e\63"+
		"\2\u00ee\u00ef\5c\62\2\u00ef\u00f0\5i\65\2\u00f0\u00f1\5m\67\2\u00f1\u00f2"+
		"\5k\66\2\u00f2\62\3\2\2\2\u00f3\u00f4\5W,\2\u00f4\u00f5\5_\60\2\u00f5"+
		"\u00f6\5e\63\2\u00f6\u00f7\5c\62\2\u00f7\u00f8\5i\65\2\u00f8\u00f9\5m"+
		"\67\2\u00f9\64\3\2\2\2\u00fa\u00fb\5q9\2\u00fb\u00fc\5G$\2\u00fc\u00fd"+
		"\5i\65\2\u00fd\u00fe\5k\66\2\u00fe\66\3\2\2\2\u00ff\u0100\5[.\2\u0100"+
		"\u0101\5O(\2\u0101\u0102\5w<\2\u0102\u0103\5s:\2\u0103\u0104\5c\62\2\u0104"+
		"\u0105\5i\65\2\u0105\u0106\5M\'\2\u0106\u0107\5k\66\2\u01078\3\2\2\2\u0108"+
		"\u0109\5m\67\2\u0109\u010a\5O(\2\u010a\u010b\5k\66\2\u010b\u010f\5m\67"+
		"\2\u010c\u010e\5)\25\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d"+
		"\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112"+
		"\u0113\5K&\2\u0113\u0114\5G$\2\u0114\u0115\5k\66\2\u0115\u0116\5O(\2\u0116"+
		"\u0117\5k\66\2\u0117:\3\2\2\2\u0118\u0119\5I%\2\u0119\u011a\5O(\2\u011a"+
		"\u011b\5S*\2\u011b\u011c\5W,\2\u011c\u011d\5a\61\2\u011d<\3\2\2\2\u011e"+
		"\u011f\5O(\2\u011f\u0120\5a\61\2\u0120\u0121\5M\'\2\u0121>\3\2\2\2\u0122"+
		"\u0123\5i\65\2\u0123\u0124\5O(\2\u0124\u0125\5m\67\2\u0125\u0126\5o8\2"+
		"\u0126\u0127\5i\65\2\u0127\u0128\5a\61\2\u0128@\3\2\2\2\u0129\u012a\5"+
		"Q)\2\u012a\u012b\5c\62\2\u012b\u012c\5i\65\2\u012cB\3\2\2\2\u012d\u012e"+
		"\5O(\2\u012e\u012f\5a\61\2\u012f\u0130\5M\'\2\u0130\u0131\5Q)\2\u0131"+
		"\u0132\5c\62\2\u0132\u0133\5i\65\2\u0133D\3\2\2\2\u0134\u0136\t\b\2\2"+
		"\u0135\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0138"+
		"\3\2\2\2\u0138F\3\2\2\2\u0139\u013a\t\t\2\2\u013aH\3\2\2\2\u013b\u013c"+
		"\t\n\2\2\u013cJ\3\2\2\2\u013d\u013e\t\13\2\2\u013eL\3\2\2\2\u013f\u0140"+
		"\t\f\2\2\u0140N\3\2\2\2\u0141\u0142\t\r\2\2\u0142P\3\2\2\2\u0143\u0144"+
		"\t\16\2\2\u0144R\3\2\2\2\u0145\u0146\t\17\2\2\u0146T\3\2\2\2\u0147\u0148"+
		"\t\20\2\2\u0148V\3\2\2\2\u0149\u014a\t\21\2\2\u014aX\3\2\2\2\u014b\u014c"+
		"\t\22\2\2\u014cZ\3\2\2\2\u014d\u014e\t\23\2\2\u014e\\\3\2\2\2\u014f\u0150"+
		"\t\24\2\2\u0150^\3\2\2\2\u0151\u0152\t\25\2\2\u0152`\3\2\2\2\u0153\u0154"+
		"\t\26\2\2\u0154b\3\2\2\2\u0155\u0156\t\27\2\2\u0156d\3\2\2\2\u0157\u0158"+
		"\t\30\2\2\u0158f\3\2\2\2\u0159\u015a\t\31\2\2\u015ah\3\2\2\2\u015b\u015c"+
		"\t\32\2\2\u015cj\3\2\2\2\u015d\u015e\t\33\2\2\u015el\3\2\2\2\u015f\u0160"+
		"\t\34\2\2\u0160n\3\2\2\2\u0161\u0162\t\35\2\2\u0162p\3\2\2\2\u0163\u0164"+
		"\t\36\2\2\u0164r\3\2\2\2\u0165\u0166\t\37\2\2\u0166t\3\2\2\2\u0167\u0168"+
		"\t \2\2\u0168v\3\2\2\2\u0169\u016a\t!\2\2\u016ax\3\2\2\2\u016b\u016c\t"+
		"\"\2\2\u016cz\3\2\2\2\16\2\u00a3\u00ab\u00b2\u00b7\u00bd\u00c3\u00cf\u00dd"+
		"\u00e8\u010f\u0137\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}