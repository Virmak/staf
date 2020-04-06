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
public class StafLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SINGLE_STRING=2, DOUBLE_STRING=3, EQUAL=4, COMMA=5, RUN=6, KEYWORD=7, 
		IF=8, PLUS=9, MINUS=10, MUL=11, DIV=12, MOD=13, LT=14, GT=15, LTE=16, 
		GTE=17, NE=18, NOT=19, AND_OP=20, OR=21, LPARENT=22, RPARENT=23, LBRACKET=24, 
		RBRACKET=25, LBRACE=26, RBRACE=27, DOT=28, COLON=29, DOLLAR=30, TRUE=31, 
		FALSE=32, INT=33, FLOAT=34, COMMENT=35, SPACE=36, NL=37, TEST_SUITE=38, 
		IMPORTS=39, IMPORT=40, VARS=41, KEYWORDS=42, TEST_CASES=43, BEGIN=44, 
		END=45, RETURN=46, FOR=47, ENDFOR=48, NULL=49, GIVEN=50, WHEN=51, THEN=52, 
		IDENTIFIER=53;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "SINGLE_STRING", "DOUBLE_STRING", "EQUAL", "COMMA", "RUN", "KEYWORD", 
			"IF", "PLUS", "MINUS", "MUL", "DIV", "MOD", "LT", "GT", "LTE", "GTE", 
			"NE", "NOT", "AND_OP", "OR", "LPARENT", "RPARENT", "LBRACKET", "RBRACKET", 
			"LBRACE", "RBRACE", "DOT", "COLON", "DOLLAR", "TRUE", "FALSE", "INT", 
			"FLOAT", "COMMENT", "SPACE", "NL", "TEST_SUITE", "IMPORTS", "IMPORT", 
			"VARS", "KEYWORDS", "TEST_CASES", "BEGIN", "END", "RETURN", "FOR", "ENDFOR", 
			"NULL", "GIVEN", "WHEN", "THEN", "IDENTIFIER", "A", "B", "C", "D", "E", 
			"F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", 
			"T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'AND'", null, null, "'='", "','", null, null, null, "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'<'", "'>'", "'<='", "'>='", "'!='", "'!'", "'&'", 
			null, "'('", "')'", "'['", "']'", "'{'", "'}'", "'.'", "':'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "SINGLE_STRING", "DOUBLE_STRING", "EQUAL", "COMMA", "RUN", 
			"KEYWORD", "IF", "PLUS", "MINUS", "MUL", "DIV", "MOD", "LT", "GT", "LTE", 
			"GTE", "NE", "NOT", "AND_OP", "OR", "LPARENT", "RPARENT", "LBRACKET", 
			"RBRACKET", "LBRACE", "RBRACE", "DOT", "COLON", "DOLLAR", "TRUE", "FALSE", 
			"INT", "FLOAT", "COMMENT", "SPACE", "NL", "TEST_SUITE", "IMPORTS", "IMPORT", 
			"VARS", "KEYWORDS", "TEST_CASES", "BEGIN", "END", "RETURN", "FOR", "ENDFOR", 
			"NULL", "GIVEN", "WHEN", "THEN", "IDENTIFIER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u01d8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\7\3\u00a8\n\3\f\3\16\3\u00ab\13\3\3\3\3\3\3\4\3\4\7\4\u00b1\n\4\f\4\16"+
		"\4\u00b4\13\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3 \3"+
		"!\3!\3!\3!\3!\3!\3\"\6\"\u0107\n\"\r\"\16\"\u0108\3#\6#\u010c\n#\r#\16"+
		"#\u010d\3#\3#\6#\u0112\n#\r#\16#\u0113\3$\3$\7$\u0118\n$\f$\16$\u011b"+
		"\13$\3$\3$\3%\6%\u0120\n%\r%\16%\u0121\3%\3%\3&\3&\3&\5&\u0129\n&\3&\3"+
		"&\3\'\3\'\3\'\3\'\3\'\7\'\u0132\n\'\f\'\16\'\u0135\13\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\7\'\u013d\n\'\f\'\16\'\u0140\13\'\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		")\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3"+
		",\3,\3,\7,\u0164\n,\f,\16,\u0167\13,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-"+
		"\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\6\66\u01a1"+
		"\n\66\r\66\16\66\u01a2\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3"+
		">\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3"+
		"I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\2\2Q\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m\2o\2q\2s\2u\2w\2y\2{\2"+
		"}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f"+
		"\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b\2\u009d\2\u009f\2\3\2"+
		"\"\3\2))\3\2$$\3\2\62;\4\2\f\f\17\17\4\2\13\13\"\"\6\2\62;C\\aac|\4\2"+
		"CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4"+
		"\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTt"+
		"t\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2"+
		"\u01c9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\3"+
		"\u00a1\3\2\2\2\5\u00a5\3\2\2\2\7\u00ae\3\2\2\2\t\u00b7\3\2\2\2\13\u00b9"+
		"\3\2\2\2\r\u00bb\3\2\2\2\17\u00bf\3\2\2\2\21\u00c7\3\2\2\2\23\u00ca\3"+
		"\2\2\2\25\u00cc\3\2\2\2\27\u00ce\3\2\2\2\31\u00d0\3\2\2\2\33\u00d2\3\2"+
		"\2\2\35\u00d4\3\2\2\2\37\u00d6\3\2\2\2!\u00d8\3\2\2\2#\u00db\3\2\2\2%"+
		"\u00de\3\2\2\2\'\u00e1\3\2\2\2)\u00e3\3\2\2\2+\u00e5\3\2\2\2-\u00e8\3"+
		"\2\2\2/\u00ea\3\2\2\2\61\u00ec\3\2\2\2\63\u00ee\3\2\2\2\65\u00f0\3\2\2"+
		"\2\67\u00f2\3\2\2\29\u00f4\3\2\2\2;\u00f6\3\2\2\2=\u00f8\3\2\2\2?\u00fa"+
		"\3\2\2\2A\u00ff\3\2\2\2C\u0106\3\2\2\2E\u010b\3\2\2\2G\u0115\3\2\2\2I"+
		"\u011f\3\2\2\2K\u0128\3\2\2\2M\u012c\3\2\2\2O\u0141\3\2\2\2Q\u0149\3\2"+
		"\2\2S\u0150\3\2\2\2U\u0155\3\2\2\2W\u015e\3\2\2\2Y\u016e\3\2\2\2[\u0174"+
		"\3\2\2\2]\u0178\3\2\2\2_\u017f\3\2\2\2a\u0183\3\2\2\2c\u018a\3\2\2\2e"+
		"\u018f\3\2\2\2g\u0195\3\2\2\2i\u019a\3\2\2\2k\u01a0\3\2\2\2m\u01a4\3\2"+
		"\2\2o\u01a6\3\2\2\2q\u01a8\3\2\2\2s\u01aa\3\2\2\2u\u01ac\3\2\2\2w\u01ae"+
		"\3\2\2\2y\u01b0\3\2\2\2{\u01b2\3\2\2\2}\u01b4\3\2\2\2\177\u01b6\3\2\2"+
		"\2\u0081\u01b8\3\2\2\2\u0083\u01ba\3\2\2\2\u0085\u01bc\3\2\2\2\u0087\u01be"+
		"\3\2\2\2\u0089\u01c0\3\2\2\2\u008b\u01c2\3\2\2\2\u008d\u01c4\3\2\2\2\u008f"+
		"\u01c6\3\2\2\2\u0091\u01c8\3\2\2\2\u0093\u01ca\3\2\2\2\u0095\u01cc\3\2"+
		"\2\2\u0097\u01ce\3\2\2\2\u0099\u01d0\3\2\2\2\u009b\u01d2\3\2\2\2\u009d"+
		"\u01d4\3\2\2\2\u009f\u01d6\3\2\2\2\u00a1\u00a2\7C\2\2\u00a2\u00a3\7P\2"+
		"\2\u00a3\u00a4\7F\2\2\u00a4\4\3\2\2\2\u00a5\u00a9\7)\2\2\u00a6\u00a8\n"+
		"\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\7)"+
		"\2\2\u00ad\6\3\2\2\2\u00ae\u00b2\7$\2\2\u00af\u00b1\n\3\2\2\u00b0\u00af"+
		"\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7$\2\2\u00b6\b\3\2\2\2"+
		"\u00b7\u00b8\7?\2\2\u00b8\n\3\2\2\2\u00b9\u00ba\7.\2\2\u00ba\f\3\2\2\2"+
		"\u00bb\u00bc\5\u008fH\2\u00bc\u00bd\5\u0095K\2\u00bd\u00be\5\u0087D\2"+
		"\u00be\16\3\2\2\2\u00bf\u00c0\5\u0081A\2\u00c0\u00c1\5u;\2\u00c1\u00c2"+
		"\5\u009dO\2\u00c2\u00c3\5\u0099M\2\u00c3\u00c4\5\u0089E\2\u00c4\u00c5"+
		"\5\u008fH\2\u00c5\u00c6\5s:\2\u00c6\20\3\2\2\2\u00c7\u00c8\5}?\2\u00c8"+
		"\u00c9\5w<\2\u00c9\22\3\2\2\2\u00ca\u00cb\7-\2\2\u00cb\24\3\2\2\2\u00cc"+
		"\u00cd\7/\2\2\u00cd\26\3\2\2\2\u00ce\u00cf\7,\2\2\u00cf\30\3\2\2\2\u00d0"+
		"\u00d1\7\61\2\2\u00d1\32\3\2\2\2\u00d2\u00d3\7\'\2\2\u00d3\34\3\2\2\2"+
		"\u00d4\u00d5\7>\2\2\u00d5\36\3\2\2\2\u00d6\u00d7\7@\2\2\u00d7 \3\2\2\2"+
		"\u00d8\u00d9\7>\2\2\u00d9\u00da\7?\2\2\u00da\"\3\2\2\2\u00db\u00dc\7@"+
		"\2\2\u00dc\u00dd\7?\2\2\u00dd$\3\2\2\2\u00de\u00df\7#\2\2\u00df\u00e0"+
		"\7?\2\2\u00e0&\3\2\2\2\u00e1\u00e2\7#\2\2\u00e2(\3\2\2\2\u00e3\u00e4\7"+
		"(\2\2\u00e4*\3\2\2\2\u00e5\u00e6\5\u0089E\2\u00e6\u00e7\5\u008fH\2\u00e7"+
		",\3\2\2\2\u00e8\u00e9\7*\2\2\u00e9.\3\2\2\2\u00ea\u00eb\7+\2\2\u00eb\60"+
		"\3\2\2\2\u00ec\u00ed\7]\2\2\u00ed\62\3\2\2\2\u00ee\u00ef\7_\2\2\u00ef"+
		"\64\3\2\2\2\u00f0\u00f1\7}\2\2\u00f1\66\3\2\2\2\u00f2\u00f3\7\177\2\2"+
		"\u00f38\3\2\2\2\u00f4\u00f5\7\60\2\2\u00f5:\3\2\2\2\u00f6\u00f7\7<\2\2"+
		"\u00f7<\3\2\2\2\u00f8\u00f9\7&\2\2\u00f9>\3\2\2\2\u00fa\u00fb\5\u0093"+
		"J\2\u00fb\u00fc\5\u008fH\2\u00fc\u00fd\5\u0095K\2\u00fd\u00fe\5u;\2\u00fe"+
		"@\3\2\2\2\u00ff\u0100\5w<\2\u0100\u0101\5m\67\2\u0101\u0102\5\u0083B\2"+
		"\u0102\u0103\5\u0091I\2\u0103\u0104\5u;\2\u0104B\3\2\2\2\u0105\u0107\t"+
		"\4\2\2\u0106\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0106\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109D\3\2\2\2\u010a\u010c\t\4\2\2\u010b\u010a\3\2\2\2"+
		"\u010c\u010d\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f"+
		"\3\2\2\2\u010f\u0111\7\60\2\2\u0110\u0112\t\4\2\2\u0111\u0110\3\2\2\2"+
		"\u0112\u0113\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114F\3"+
		"\2\2\2\u0115\u0119\7%\2\2\u0116\u0118\n\5\2\2\u0117\u0116\3\2\2\2\u0118"+
		"\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2"+
		"\2\2\u011b\u0119\3\2\2\2\u011c\u011d\b$\2\2\u011dH\3\2\2\2\u011e\u0120"+
		"\t\6\2\2\u011f\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\b%\2\2\u0124J\3\2\2\2\u0125"+
		"\u0126\7\17\2\2\u0126\u0129\7\f\2\2\u0127\u0129\t\5\2\2\u0128\u0125\3"+
		"\2\2\2\u0128\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\b&\2\2\u012b"+
		"L\3\2\2\2\u012c\u012d\5\u0093J\2\u012d\u012e\5u;\2\u012e\u012f\5\u0091"+
		"I\2\u012f\u0133\5\u0093J\2\u0130\u0132\5I%\2\u0131\u0130\3\2\2\2\u0132"+
		"\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0136\3\2"+
		"\2\2\u0135\u0133\3\2\2\2\u0136\u0137\5\u0091I\2\u0137\u0138\5\u0095K\2"+
		"\u0138\u0139\5}?\2\u0139\u013a\5\u0093J\2\u013a\u013e\5u;\2\u013b\u013d"+
		"\5I%\2\u013c\u013b\3\2\2\2\u013d\u0140\3\2\2\2\u013e\u013c\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013fN\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0142\5}?\2\u0142"+
		"\u0143\5\u0085C\2\u0143\u0144\5\u008bF\2\u0144\u0145\5\u0089E\2\u0145"+
		"\u0146\5\u008fH\2\u0146\u0147\5\u0093J\2\u0147\u0148\5\u0091I\2\u0148"+
		"P\3\2\2\2\u0149\u014a\5}?\2\u014a\u014b\5\u0085C\2\u014b\u014c\5\u008b"+
		"F\2\u014c\u014d\5\u0089E\2\u014d\u014e\5\u008fH\2\u014e\u014f\5\u0093"+
		"J\2\u014fR\3\2\2\2\u0150\u0151\5\u0097L\2\u0151\u0152\5m\67\2\u0152\u0153"+
		"\5\u008fH\2\u0153\u0154\5\u0091I\2\u0154T\3\2\2\2\u0155\u0156\5\u0081"+
		"A\2\u0156\u0157\5u;\2\u0157\u0158\5\u009dO\2\u0158\u0159\5\u0099M\2\u0159"+
		"\u015a\5\u0089E\2\u015a\u015b\5\u008fH\2\u015b\u015c\5s:\2\u015c\u015d"+
		"\5\u0091I\2\u015dV\3\2\2\2\u015e\u015f\5\u0093J\2\u015f\u0160\5u;\2\u0160"+
		"\u0161\5\u0091I\2\u0161\u0165\5\u0093J\2\u0162\u0164\5I%\2\u0163\u0162"+
		"\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166"+
		"\u0168\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u0169\5q9\2\u0169\u016a\5m\67"+
		"\2\u016a\u016b\5\u0091I\2\u016b\u016c\5u;\2\u016c\u016d\5\u0091I\2\u016d"+
		"X\3\2\2\2\u016e\u016f\5o8\2\u016f\u0170\5u;\2\u0170\u0171\5y=\2\u0171"+
		"\u0172\5}?\2\u0172\u0173\5\u0087D\2\u0173Z\3\2\2\2\u0174\u0175\5u;\2\u0175"+
		"\u0176\5\u0087D\2\u0176\u0177\5s:\2\u0177\\\3\2\2\2\u0178\u0179\5\u008f"+
		"H\2\u0179\u017a\5u;\2\u017a\u017b\5\u0093J\2\u017b\u017c\5\u0095K\2\u017c"+
		"\u017d\5\u008fH\2\u017d\u017e\5\u0087D\2\u017e^\3\2\2\2\u017f\u0180\5"+
		"w<\2\u0180\u0181\5\u0089E\2\u0181\u0182\5\u008fH\2\u0182`\3\2\2\2\u0183"+
		"\u0184\5u;\2\u0184\u0185\5\u0087D\2\u0185\u0186\5s:\2\u0186\u0187\5w<"+
		"\2\u0187\u0188\5\u0089E\2\u0188\u0189\5\u008fH\2\u0189b\3\2\2\2\u018a"+
		"\u018b\5\u0087D\2\u018b\u018c\5\u0095K\2\u018c\u018d\5\u0083B\2\u018d"+
		"\u018e\5\u0083B\2\u018ed\3\2\2\2\u018f\u0190\5y=\2\u0190\u0191\5}?\2\u0191"+
		"\u0192\5\u0097L\2\u0192\u0193\5u;\2\u0193\u0194\5\u0087D\2\u0194f\3\2"+
		"\2\2\u0195\u0196\5\u0099M\2\u0196\u0197\5{>\2\u0197\u0198\5u;\2\u0198"+
		"\u0199\5\u0087D\2\u0199h\3\2\2\2\u019a\u019b\5\u0093J\2\u019b\u019c\5"+
		"{>\2\u019c\u019d\5u;\2\u019d\u019e\5\u0087D\2\u019ej\3\2\2\2\u019f\u01a1"+
		"\t\7\2\2\u01a0\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2"+
		"\u01a3\3\2\2\2\u01a3l\3\2\2\2\u01a4\u01a5\t\b\2\2\u01a5n\3\2\2\2\u01a6"+
		"\u01a7\t\t\2\2\u01a7p\3\2\2\2\u01a8\u01a9\t\n\2\2\u01a9r\3\2\2\2\u01aa"+
		"\u01ab\t\13\2\2\u01abt\3\2\2\2\u01ac\u01ad\t\f\2\2\u01adv\3\2\2\2\u01ae"+
		"\u01af\t\r\2\2\u01afx\3\2\2\2\u01b0\u01b1\t\16\2\2\u01b1z\3\2\2\2\u01b2"+
		"\u01b3\t\17\2\2\u01b3|\3\2\2\2\u01b4\u01b5\t\20\2\2\u01b5~\3\2\2\2\u01b6"+
		"\u01b7\t\21\2\2\u01b7\u0080\3\2\2\2\u01b8\u01b9\t\22\2\2\u01b9\u0082\3"+
		"\2\2\2\u01ba\u01bb\t\23\2\2\u01bb\u0084\3\2\2\2\u01bc\u01bd\t\24\2\2\u01bd"+
		"\u0086\3\2\2\2\u01be\u01bf\t\25\2\2\u01bf\u0088\3\2\2\2\u01c0\u01c1\t"+
		"\26\2\2\u01c1\u008a\3\2\2\2\u01c2\u01c3\t\27\2\2\u01c3\u008c\3\2\2\2\u01c4"+
		"\u01c5\t\30\2\2\u01c5\u008e\3\2\2\2\u01c6\u01c7\t\31\2\2\u01c7\u0090\3"+
		"\2\2\2\u01c8\u01c9\t\32\2\2\u01c9\u0092\3\2\2\2\u01ca\u01cb\t\33\2\2\u01cb"+
		"\u0094\3\2\2\2\u01cc\u01cd\t\34\2\2\u01cd\u0096\3\2\2\2\u01ce\u01cf\t"+
		"\35\2\2\u01cf\u0098\3\2\2\2\u01d0\u01d1\t\36\2\2\u01d1\u009a\3\2\2\2\u01d2"+
		"\u01d3\t\37\2\2\u01d3\u009c\3\2\2\2\u01d4\u01d5\t \2\2\u01d5\u009e\3\2"+
		"\2\2\u01d6\u01d7\t!\2\2\u01d7\u00a0\3\2\2\2\17\2\u00a9\u00b2\u0108\u010d"+
		"\u0113\u0119\u0121\u0128\u0133\u013e\u0165\u01a2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}