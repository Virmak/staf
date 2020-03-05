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
		SINGLE_STRING=1, DOUBLE_STRING=2, EQUAL=3, COMMA=4, RUN=5, KEYWORD=6, 
		IF=7, PLUS=8, MINUS=9, MUL=10, DIV=11, MOD=12, LT=13, GT=14, LTE=15, GTE=16, 
		NE=17, NOT=18, AND=19, OR=20, LPARENT=21, RPARENT=22, LBRACKET=23, RBRACKET=24, 
		LBRACE=25, RBRACE=26, DOT=27, COLON=28, DOLLAR=29, TRUE=30, FALSE=31, 
		INT=32, FLOAT=33, COMMENT=34, SPACE=35, NL=36, IN=37, TEST_SUITE=38, IMPORTS=39, 
		IMPORT=40, VARS=41, KEYWORDS=42, TEST_CASES=43, BEGIN=44, END=45, RETURN=46, 
		FOR=47, ENDFOR=48, NULL=49, GIVEN=50, WHEN=51, THEN=52, IDENTIFIER=53;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SINGLE_STRING", "DOUBLE_STRING", "EQUAL", "COMMA", "RUN", "KEYWORD", 
			"IF", "PLUS", "MINUS", "MUL", "DIV", "MOD", "LT", "GT", "LTE", "GTE", 
			"NE", "NOT", "AND", "OR", "LPARENT", "RPARENT", "LBRACKET", "RBRACKET", 
			"LBRACE", "RBRACE", "DOT", "COLON", "DOLLAR", "TRUE", "FALSE", "INT", 
			"FLOAT", "COMMENT", "SPACE", "NL", "IN", "TEST_SUITE", "IMPORTS", "IMPORT", 
			"VARS", "KEYWORDS", "TEST_CASES", "BEGIN", "END", "RETURN", "FOR", "ENDFOR", 
			"NULL", "GIVEN", "WHEN", "THEN", "IDENTIFIER", "A", "B", "C", "D", "E", 
			"F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", 
			"T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'='", "','", null, null, null, "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'<'", "'>'", "'<='", "'>='", "'!='", "'!'", null, null, 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "'.'", "':'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SINGLE_STRING", "DOUBLE_STRING", "EQUAL", "COMMA", "RUN", "KEYWORD", 
			"IF", "PLUS", "MINUS", "MUL", "DIV", "MOD", "LT", "GT", "LTE", "GTE", 
			"NE", "NOT", "AND", "OR", "LPARENT", "RPARENT", "LBRACKET", "RBRACKET", 
			"LBRACE", "RBRACE", "DOT", "COLON", "DOLLAR", "TRUE", "FALSE", "INT", 
			"FLOAT", "COMMENT", "SPACE", "NL", "IN", "TEST_SUITE", "IMPORTS", "IMPORT", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u01d7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\3\2\3\2\6\2\u00a4\n\2\r"+
		"\2\16\2\u00a5\3\2\3\2\3\3\3\3\6\3\u00ac\n\3\r\3\16\3\u00ad\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3 \3 \3 \3!\6!\u0103\n!\r!\16!\u0104\3\"\6\"\u0108\n\"\r\"\16\"\u0109"+
		"\3\"\3\"\6\"\u010e\n\"\r\"\16\"\u010f\3#\3#\7#\u0114\n#\f#\16#\u0117\13"+
		"#\3#\3#\3$\6$\u011c\n$\r$\16$\u011d\3$\3$\3%\3%\3%\5%\u0125\n%\3%\3%\3"+
		"&\3&\3&\3\'\3\'\3\'\3\'\3\'\7\'\u0131\n\'\f\'\16\'\u0134\13\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\7\'\u013c\n\'\f\'\16\'\u013f\13\'\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3"+
		",\3,\3,\3,\3,\7,\u0163\n,\f,\16,\u0166\13,\3,\3,\3,\3,\3,\3,\3-\3-\3-"+
		"\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3"+
		"\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\6"+
		"\66\u01a0\n\66\r\66\16\66\u01a1\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3"+
		"<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3"+
		"H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\2\2Q\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m\2o\2q\2s\2u\2"+
		"w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d"+
		"\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b\2\u009d\2\u009f"+
		"\2\3\2\"\3\2))\3\2$$\3\2\62;\4\2\f\f\17\17\4\2\13\13\"\"\5\2\62;C\\c|"+
		"\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2K"+
		"Kkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4"+
		"\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\"+
		"||\2\u01c8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\3\u00a1\3\2\2\2\5\u00a9\3\2\2\2\7\u00b1\3\2\2\2\t\u00b3\3\2\2\2\13\u00b5"+
		"\3\2\2\2\r\u00b9\3\2\2\2\17\u00c1\3\2\2\2\21\u00c4\3\2\2\2\23\u00c6\3"+
		"\2\2\2\25\u00c8\3\2\2\2\27\u00ca\3\2\2\2\31\u00cc\3\2\2\2\33\u00ce\3\2"+
		"\2\2\35\u00d0\3\2\2\2\37\u00d2\3\2\2\2!\u00d5\3\2\2\2#\u00d8\3\2\2\2%"+
		"\u00db\3\2\2\2\'\u00dd\3\2\2\2)\u00e1\3\2\2\2+\u00e4\3\2\2\2-\u00e6\3"+
		"\2\2\2/\u00e8\3\2\2\2\61\u00ea\3\2\2\2\63\u00ec\3\2\2\2\65\u00ee\3\2\2"+
		"\2\67\u00f0\3\2\2\29\u00f2\3\2\2\2;\u00f4\3\2\2\2=\u00f6\3\2\2\2?\u00fb"+
		"\3\2\2\2A\u0102\3\2\2\2C\u0107\3\2\2\2E\u0111\3\2\2\2G\u011b\3\2\2\2I"+
		"\u0124\3\2\2\2K\u0128\3\2\2\2M\u012b\3\2\2\2O\u0140\3\2\2\2Q\u0148\3\2"+
		"\2\2S\u014f\3\2\2\2U\u0154\3\2\2\2W\u015d\3\2\2\2Y\u016d\3\2\2\2[\u0173"+
		"\3\2\2\2]\u0177\3\2\2\2_\u017e\3\2\2\2a\u0182\3\2\2\2c\u0189\3\2\2\2e"+
		"\u018e\3\2\2\2g\u0194\3\2\2\2i\u0199\3\2\2\2k\u019f\3\2\2\2m\u01a3\3\2"+
		"\2\2o\u01a5\3\2\2\2q\u01a7\3\2\2\2s\u01a9\3\2\2\2u\u01ab\3\2\2\2w\u01ad"+
		"\3\2\2\2y\u01af\3\2\2\2{\u01b1\3\2\2\2}\u01b3\3\2\2\2\177\u01b5\3\2\2"+
		"\2\u0081\u01b7\3\2\2\2\u0083\u01b9\3\2\2\2\u0085\u01bb\3\2\2\2\u0087\u01bd"+
		"\3\2\2\2\u0089\u01bf\3\2\2\2\u008b\u01c1\3\2\2\2\u008d\u01c3\3\2\2\2\u008f"+
		"\u01c5\3\2\2\2\u0091\u01c7\3\2\2\2\u0093\u01c9\3\2\2\2\u0095\u01cb\3\2"+
		"\2\2\u0097\u01cd\3\2\2\2\u0099\u01cf\3\2\2\2\u009b\u01d1\3\2\2\2\u009d"+
		"\u01d3\3\2\2\2\u009f\u01d5\3\2\2\2\u00a1\u00a3\7)\2\2\u00a2\u00a4\n\2"+
		"\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\7)\2\2\u00a8\4\3\2\2\2"+
		"\u00a9\u00ab\7$\2\2\u00aa\u00ac\n\3\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b0\7$\2\2\u00b0\6\3\2\2\2\u00b1\u00b2\7?\2\2\u00b2\b\3\2\2\2\u00b3"+
		"\u00b4\7.\2\2\u00b4\n\3\2\2\2\u00b5\u00b6\5\u008fH\2\u00b6\u00b7\5\u0095"+
		"K\2\u00b7\u00b8\5\u0087D\2\u00b8\f\3\2\2\2\u00b9\u00ba\5\u0081A\2\u00ba"+
		"\u00bb\5u;\2\u00bb\u00bc\5\u009dO\2\u00bc\u00bd\5\u0099M\2\u00bd\u00be"+
		"\5\u0089E\2\u00be\u00bf\5\u008fH\2\u00bf\u00c0\5s:\2\u00c0\16\3\2\2\2"+
		"\u00c1\u00c2\5}?\2\u00c2\u00c3\5w<\2\u00c3\20\3\2\2\2\u00c4\u00c5\7-\2"+
		"\2\u00c5\22\3\2\2\2\u00c6\u00c7\7/\2\2\u00c7\24\3\2\2\2\u00c8\u00c9\7"+
		",\2\2\u00c9\26\3\2\2\2\u00ca\u00cb\7\61\2\2\u00cb\30\3\2\2\2\u00cc\u00cd"+
		"\7\'\2\2\u00cd\32\3\2\2\2\u00ce\u00cf\7>\2\2\u00cf\34\3\2\2\2\u00d0\u00d1"+
		"\7@\2\2\u00d1\36\3\2\2\2\u00d2\u00d3\7>\2\2\u00d3\u00d4\7?\2\2\u00d4 "+
		"\3\2\2\2\u00d5\u00d6\7@\2\2\u00d6\u00d7\7?\2\2\u00d7\"\3\2\2\2\u00d8\u00d9"+
		"\7#\2\2\u00d9\u00da\7?\2\2\u00da$\3\2\2\2\u00db\u00dc\7#\2\2\u00dc&\3"+
		"\2\2\2\u00dd\u00de\5m\67\2\u00de\u00df\5\u0087D\2\u00df\u00e0\5s:\2\u00e0"+
		"(\3\2\2\2\u00e1\u00e2\5\u0089E\2\u00e2\u00e3\5\u008fH\2\u00e3*\3\2\2\2"+
		"\u00e4\u00e5\7*\2\2\u00e5,\3\2\2\2\u00e6\u00e7\7+\2\2\u00e7.\3\2\2\2\u00e8"+
		"\u00e9\7]\2\2\u00e9\60\3\2\2\2\u00ea\u00eb\7_\2\2\u00eb\62\3\2\2\2\u00ec"+
		"\u00ed\7}\2\2\u00ed\64\3\2\2\2\u00ee\u00ef\7\177\2\2\u00ef\66\3\2\2\2"+
		"\u00f0\u00f1\7\60\2\2\u00f18\3\2\2\2\u00f2\u00f3\7<\2\2\u00f3:\3\2\2\2"+
		"\u00f4\u00f5\7&\2\2\u00f5<\3\2\2\2\u00f6\u00f7\5\u0093J\2\u00f7\u00f8"+
		"\5\u008fH\2\u00f8\u00f9\5\u0095K\2\u00f9\u00fa\5u;\2\u00fa>\3\2\2\2\u00fb"+
		"\u00fc\5w<\2\u00fc\u00fd\5m\67\2\u00fd\u00fe\5\u0083B\2\u00fe\u00ff\5"+
		"\u0091I\2\u00ff\u0100\5u;\2\u0100@\3\2\2\2\u0101\u0103\t\4\2\2\u0102\u0101"+
		"\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"B\3\2\2\2\u0106\u0108\t\4\2\2\u0107\u0106\3\2\2\2\u0108\u0109\3\2\2\2"+
		"\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010d"+
		"\7\60\2\2\u010c\u010e\t\4\2\2\u010d\u010c\3\2\2\2\u010e\u010f\3\2\2\2"+
		"\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110D\3\2\2\2\u0111\u0115\7"+
		"%\2\2\u0112\u0114\n\5\2\2\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115"+
		"\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2\2\2\u0117\u0115\3\2"+
		"\2\2\u0118\u0119\b#\2\2\u0119F\3\2\2\2\u011a\u011c\t\6\2\2\u011b\u011a"+
		"\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0120\b$\2\2\u0120H\3\2\2\2\u0121\u0122\7\17\2\2"+
		"\u0122\u0125\7\f\2\2\u0123\u0125\t\5\2\2\u0124\u0121\3\2\2\2\u0124\u0123"+
		"\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\b%\2\2\u0127J\3\2\2\2\u0128\u0129"+
		"\5}?\2\u0129\u012a\5\u0087D\2\u012aL\3\2\2\2\u012b\u012c\5\u0093J\2\u012c"+
		"\u012d\5u;\2\u012d\u012e\5\u0091I\2\u012e\u0132\5\u0093J\2\u012f\u0131"+
		"\5G$\2\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0136\5\u0091"+
		"I\2\u0136\u0137\5\u0095K\2\u0137\u0138\5}?\2\u0138\u0139\5\u0093J\2\u0139"+
		"\u013d\5u;\2\u013a\u013c\5G$\2\u013b\u013a\3\2\2\2\u013c\u013f\3\2\2\2"+
		"\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013eN\3\2\2\2\u013f\u013d\3"+
		"\2\2\2\u0140\u0141\5}?\2\u0141\u0142\5\u0085C\2\u0142\u0143\5\u008bF\2"+
		"\u0143\u0144\5\u0089E\2\u0144\u0145\5\u008fH\2\u0145\u0146\5\u0093J\2"+
		"\u0146\u0147\5\u0091I\2\u0147P\3\2\2\2\u0148\u0149\5}?\2\u0149\u014a\5"+
		"\u0085C\2\u014a\u014b\5\u008bF\2\u014b\u014c\5\u0089E\2\u014c\u014d\5"+
		"\u008fH\2\u014d\u014e\5\u0093J\2\u014eR\3\2\2\2\u014f\u0150\5\u0097L\2"+
		"\u0150\u0151\5m\67\2\u0151\u0152\5\u008fH\2\u0152\u0153\5\u0091I\2\u0153"+
		"T\3\2\2\2\u0154\u0155\5\u0081A\2\u0155\u0156\5u;\2\u0156\u0157\5\u009d"+
		"O\2\u0157\u0158\5\u0099M\2\u0158\u0159\5\u0089E\2\u0159\u015a\5\u008f"+
		"H\2\u015a\u015b\5s:\2\u015b\u015c\5\u0091I\2\u015cV\3\2\2\2\u015d\u015e"+
		"\5\u0093J\2\u015e\u015f\5u;\2\u015f\u0160\5\u0091I\2\u0160\u0164\5\u0093"+
		"J\2\u0161\u0163\5G$\2\u0162\u0161\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0162"+
		"\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0167\3\2\2\2\u0166\u0164\3\2\2\2\u0167"+
		"\u0168\5q9\2\u0168\u0169\5m\67\2\u0169\u016a\5\u0091I\2\u016a\u016b\5"+
		"u;\2\u016b\u016c\5\u0091I\2\u016cX\3\2\2\2\u016d\u016e\5o8\2\u016e\u016f"+
		"\5u;\2\u016f\u0170\5y=\2\u0170\u0171\5}?\2\u0171\u0172\5\u0087D\2\u0172"+
		"Z\3\2\2\2\u0173\u0174\5u;\2\u0174\u0175\5\u0087D\2\u0175\u0176\5s:\2\u0176"+
		"\\\3\2\2\2\u0177\u0178\5\u008fH\2\u0178\u0179\5u;\2\u0179\u017a\5\u0093"+
		"J\2\u017a\u017b\5\u0095K\2\u017b\u017c\5\u008fH\2\u017c\u017d\5\u0087"+
		"D\2\u017d^\3\2\2\2\u017e\u017f\5w<\2\u017f\u0180\5\u0089E\2\u0180\u0181"+
		"\5\u008fH\2\u0181`\3\2\2\2\u0182\u0183\5u;\2\u0183\u0184\5\u0087D\2\u0184"+
		"\u0185\5s:\2\u0185\u0186\5w<\2\u0186\u0187\5\u0089E\2\u0187\u0188\5\u008f"+
		"H\2\u0188b\3\2\2\2\u0189\u018a\5\u0087D\2\u018a\u018b\5\u0095K\2\u018b"+
		"\u018c\5\u0083B\2\u018c\u018d\5\u0083B\2\u018dd\3\2\2\2\u018e\u018f\5"+
		"y=\2\u018f\u0190\5}?\2\u0190\u0191\5\u0097L\2\u0191\u0192\5u;\2\u0192"+
		"\u0193\5\u0087D\2\u0193f\3\2\2\2\u0194\u0195\5\u0099M\2\u0195\u0196\5"+
		"{>\2\u0196\u0197\5u;\2\u0197\u0198\5\u0087D\2\u0198h\3\2\2\2\u0199\u019a"+
		"\5\u0093J\2\u019a\u019b\5{>\2\u019b\u019c\5u;\2\u019c\u019d\5\u0087D\2"+
		"\u019dj\3\2\2\2\u019e\u01a0\t\7\2\2\u019f\u019e\3\2\2\2\u01a0\u01a1\3"+
		"\2\2\2\u01a1\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2l\3\2\2\2\u01a3\u01a4"+
		"\t\b\2\2\u01a4n\3\2\2\2\u01a5\u01a6\t\t\2\2\u01a6p\3\2\2\2\u01a7\u01a8"+
		"\t\n\2\2\u01a8r\3\2\2\2\u01a9\u01aa\t\13\2\2\u01aat\3\2\2\2\u01ab\u01ac"+
		"\t\f\2\2\u01acv\3\2\2\2\u01ad\u01ae\t\r\2\2\u01aex\3\2\2\2\u01af\u01b0"+
		"\t\16\2\2\u01b0z\3\2\2\2\u01b1\u01b2\t\17\2\2\u01b2|\3\2\2\2\u01b3\u01b4"+
		"\t\20\2\2\u01b4~\3\2\2\2\u01b5\u01b6\t\21\2\2\u01b6\u0080\3\2\2\2\u01b7"+
		"\u01b8\t\22\2\2\u01b8\u0082\3\2\2\2\u01b9\u01ba\t\23\2\2\u01ba\u0084\3"+
		"\2\2\2\u01bb\u01bc\t\24\2\2\u01bc\u0086\3\2\2\2\u01bd\u01be\t\25\2\2\u01be"+
		"\u0088\3\2\2\2\u01bf\u01c0\t\26\2\2\u01c0\u008a\3\2\2\2\u01c1\u01c2\t"+
		"\27\2\2\u01c2\u008c\3\2\2\2\u01c3\u01c4\t\30\2\2\u01c4\u008e\3\2\2\2\u01c5"+
		"\u01c6\t\31\2\2\u01c6\u0090\3\2\2\2\u01c7\u01c8\t\32\2\2\u01c8\u0092\3"+
		"\2\2\2\u01c9\u01ca\t\33\2\2\u01ca\u0094\3\2\2\2\u01cb\u01cc\t\34\2\2\u01cc"+
		"\u0096\3\2\2\2\u01cd\u01ce\t\35\2\2\u01ce\u0098\3\2\2\2\u01cf\u01d0\t"+
		"\36\2\2\u01d0\u009a\3\2\2\2\u01d1\u01d2\t\37\2\2\u01d2\u009c\3\2\2\2\u01d3"+
		"\u01d4\t \2\2\u01d4\u009e\3\2\2\2\u01d5\u01d6\t!\2\2\u01d6\u00a0\3\2\2"+
		"\2\17\2\u00a5\u00ad\u0104\u0109\u010f\u0115\u011d\u0124\u0132\u013d\u0164"+
		"\u01a1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}