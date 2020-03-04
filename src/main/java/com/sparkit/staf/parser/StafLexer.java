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
		SINGLE_STRING=1, DOUBLE_STRING=2, EQUAL=3, COMMA=4, PLUS=5, MINUS=6, MUL=7, 
		DIV=8, MOD=9, LT=10, GT=11, LTE=12, GTE=13, NE=14, NOT=15, AND=16, OR=17, 
		LPARENT=18, RPARENT=19, LBRACKET=20, RBRACKET=21, LBRACE=22, RBRACE=23, 
		DOT=24, COLON=25, DOLLAR=26, TRUE=27, FALSE=28, INT=29, FLOAT=30, COMMENT=31, 
		SPACE=32, NL=33, IN=34, TEST_SUITE=35, IMPORTS=36, IMPORT=37, VARS=38, 
		KEYWORDS=39, TEST_CASES=40, BEGIN=41, END=42, RETURN=43, FOR=44, ENDFOR=45, 
		NULL=46, GIVEN=47, WHEN=48, THEN=49, IDENTIFIER=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SINGLE_STRING", "DOUBLE_STRING", "EQUAL", "COMMA", "PLUS", "MINUS", 
			"MUL", "DIV", "MOD", "LT", "GT", "LTE", "GTE", "NE", "NOT", "AND", "OR", 
			"LPARENT", "RPARENT", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "DOT", 
			"COLON", "DOLLAR", "TRUE", "FALSE", "INT", "FLOAT", "COMMENT", "SPACE", 
			"NL", "IN", "TEST_SUITE", "IMPORTS", "IMPORT", "VARS", "KEYWORDS", "TEST_CASES", 
			"BEGIN", "END", "RETURN", "FOR", "ENDFOR", "NULL", "GIVEN", "WHEN", "THEN", 
			"IDENTIFIER", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", 
			"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", 
			"Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'='", "','", "'+'", "'-'", "'*'", "'/'", "'%'", "'<'", 
			"'>'", "'<='", "'>='", "'!='", "'!'", null, null, "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'.'", "':'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SINGLE_STRING", "DOUBLE_STRING", "EQUAL", "COMMA", "PLUS", "MINUS", 
			"MUL", "DIV", "MOD", "LT", "GT", "LTE", "GTE", "NE", "NOT", "AND", "OR", 
			"LPARENT", "RPARENT", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "DOT", 
			"COLON", "DOLLAR", "TRUE", "FALSE", "INT", "FLOAT", "COMMENT", "SPACE", 
			"NL", "IN", "TEST_SUITE", "IMPORTS", "IMPORT", "VARS", "KEYWORDS", "TEST_CASES", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u01c2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\3\2\3\2\6\2\u009e\n\2\r\2\16\2\u009f\3\2"+
		"\3\2\3\3\3\3\6\3\u00a6\n\3\r\3\16\3\u00a7\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\6\36\u00ee\n\36\r\36\16\36\u00ef\3\37\6\37\u00f3\n\37\r\37"+
		"\16\37\u00f4\3\37\3\37\6\37\u00f9\n\37\r\37\16\37\u00fa\3 \3 \7 \u00ff"+
		"\n \f \16 \u0102\13 \3 \3 \3!\6!\u0107\n!\r!\16!\u0108\3!\3!\3\"\3\"\3"+
		"\"\5\"\u0110\n\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3$\7$\u011c\n$\f$\16$\u011f"+
		"\13$\3$\3$\3$\3$\3$\3$\7$\u0127\n$\f$\16$\u012a\13$\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3)\3)\3)\3)\3)\7)\u014e\n)\f)\16)\u0151\13)\3)\3)\3)\3)\3)\3)\3*"+
		"\3*\3*\3*\3*\3*\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3."+
		"\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3"+
		"\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\6\63\u018b\n\63\r\63\16\63"+
		"\u018c\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3"+
		";\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3"+
		"G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\2\2N\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S"+
		"+U,W-Y.[/]\60_\61a\62c\63e\64g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2{\2}\2\177"+
		"\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091"+
		"\2\u0093\2\u0095\2\u0097\2\u0099\2\3\2\"\3\2))\3\2$$\3\2\62;\4\2\f\f\17"+
		"\17\4\2\13\13\"\"\5\2\62;C\\c|\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGg"+
		"g\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2"+
		"PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4"+
		"\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u01b3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\3"+
		"\u009b\3\2\2\2\5\u00a3\3\2\2\2\7\u00ab\3\2\2\2\t\u00ad\3\2\2\2\13\u00af"+
		"\3\2\2\2\r\u00b1\3\2\2\2\17\u00b3\3\2\2\2\21\u00b5\3\2\2\2\23\u00b7\3"+
		"\2\2\2\25\u00b9\3\2\2\2\27\u00bb\3\2\2\2\31\u00bd\3\2\2\2\33\u00c0\3\2"+
		"\2\2\35\u00c3\3\2\2\2\37\u00c6\3\2\2\2!\u00c8\3\2\2\2#\u00cc\3\2\2\2%"+
		"\u00cf\3\2\2\2\'\u00d1\3\2\2\2)\u00d3\3\2\2\2+\u00d5\3\2\2\2-\u00d7\3"+
		"\2\2\2/\u00d9\3\2\2\2\61\u00db\3\2\2\2\63\u00dd\3\2\2\2\65\u00df\3\2\2"+
		"\2\67\u00e1\3\2\2\29\u00e6\3\2\2\2;\u00ed\3\2\2\2=\u00f2\3\2\2\2?\u00fc"+
		"\3\2\2\2A\u0106\3\2\2\2C\u010f\3\2\2\2E\u0113\3\2\2\2G\u0116\3\2\2\2I"+
		"\u012b\3\2\2\2K\u0133\3\2\2\2M\u013a\3\2\2\2O\u013f\3\2\2\2Q\u0148\3\2"+
		"\2\2S\u0158\3\2\2\2U\u015e\3\2\2\2W\u0162\3\2\2\2Y\u0169\3\2\2\2[\u016d"+
		"\3\2\2\2]\u0174\3\2\2\2_\u0179\3\2\2\2a\u017f\3\2\2\2c\u0184\3\2\2\2e"+
		"\u018a\3\2\2\2g\u018e\3\2\2\2i\u0190\3\2\2\2k\u0192\3\2\2\2m\u0194\3\2"+
		"\2\2o\u0196\3\2\2\2q\u0198\3\2\2\2s\u019a\3\2\2\2u\u019c\3\2\2\2w\u019e"+
		"\3\2\2\2y\u01a0\3\2\2\2{\u01a2\3\2\2\2}\u01a4\3\2\2\2\177\u01a6\3\2\2"+
		"\2\u0081\u01a8\3\2\2\2\u0083\u01aa\3\2\2\2\u0085\u01ac\3\2\2\2\u0087\u01ae"+
		"\3\2\2\2\u0089\u01b0\3\2\2\2\u008b\u01b2\3\2\2\2\u008d\u01b4\3\2\2\2\u008f"+
		"\u01b6\3\2\2\2\u0091\u01b8\3\2\2\2\u0093\u01ba\3\2\2\2\u0095\u01bc\3\2"+
		"\2\2\u0097\u01be\3\2\2\2\u0099\u01c0\3\2\2\2\u009b\u009d\7)\2\2\u009c"+
		"\u009e\n\2\2\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7)\2\2\u00a2"+
		"\4\3\2\2\2\u00a3\u00a5\7$\2\2\u00a4\u00a6\n\3\2\2\u00a5\u00a4\3\2\2\2"+
		"\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9"+
		"\3\2\2\2\u00a9\u00aa\7$\2\2\u00aa\6\3\2\2\2\u00ab\u00ac\7?\2\2\u00ac\b"+
		"\3\2\2\2\u00ad\u00ae\7.\2\2\u00ae\n\3\2\2\2\u00af\u00b0\7-\2\2\u00b0\f"+
		"\3\2\2\2\u00b1\u00b2\7/\2\2\u00b2\16\3\2\2\2\u00b3\u00b4\7,\2\2\u00b4"+
		"\20\3\2\2\2\u00b5\u00b6\7\61\2\2\u00b6\22\3\2\2\2\u00b7\u00b8\7\'\2\2"+
		"\u00b8\24\3\2\2\2\u00b9\u00ba\7>\2\2\u00ba\26\3\2\2\2\u00bb\u00bc\7@\2"+
		"\2\u00bc\30\3\2\2\2\u00bd\u00be\7>\2\2\u00be\u00bf\7?\2\2\u00bf\32\3\2"+
		"\2\2\u00c0\u00c1\7@\2\2\u00c1\u00c2\7?\2\2\u00c2\34\3\2\2\2\u00c3\u00c4"+
		"\7#\2\2\u00c4\u00c5\7?\2\2\u00c5\36\3\2\2\2\u00c6\u00c7\7#\2\2\u00c7 "+
		"\3\2\2\2\u00c8\u00c9\5g\64\2\u00c9\u00ca\5\u0081A\2\u00ca\u00cb\5m\67"+
		"\2\u00cb\"\3\2\2\2\u00cc\u00cd\5\u0083B\2\u00cd\u00ce\5\u0089E\2\u00ce"+
		"$\3\2\2\2\u00cf\u00d0\7*\2\2\u00d0&\3\2\2\2\u00d1\u00d2\7+\2\2\u00d2("+
		"\3\2\2\2\u00d3\u00d4\7]\2\2\u00d4*\3\2\2\2\u00d5\u00d6\7_\2\2\u00d6,\3"+
		"\2\2\2\u00d7\u00d8\7}\2\2\u00d8.\3\2\2\2\u00d9\u00da\7\177\2\2\u00da\60"+
		"\3\2\2\2\u00db\u00dc\7\60\2\2\u00dc\62\3\2\2\2\u00dd\u00de\7<\2\2\u00de"+
		"\64\3\2\2\2\u00df\u00e0\7&\2\2\u00e0\66\3\2\2\2\u00e1\u00e2\5\u008dG\2"+
		"\u00e2\u00e3\5\u0089E\2\u00e3\u00e4\5\u008fH\2\u00e4\u00e5\5o8\2\u00e5"+
		"8\3\2\2\2\u00e6\u00e7\5q9\2\u00e7\u00e8\5g\64\2\u00e8\u00e9\5}?\2\u00e9"+
		"\u00ea\5\u008bF\2\u00ea\u00eb\5o8\2\u00eb:\3\2\2\2\u00ec\u00ee\t\4\2\2"+
		"\u00ed\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0"+
		"\3\2\2\2\u00f0<\3\2\2\2\u00f1\u00f3\t\4\2\2\u00f2\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6\u00f8\7\60\2\2\u00f7\u00f9\t\4\2\2\u00f8\u00f7\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb>\3\2\2\2"+
		"\u00fc\u0100\7%\2\2\u00fd\u00ff\n\5\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0102"+
		"\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0103\3\2\2\2\u0102"+
		"\u0100\3\2\2\2\u0103\u0104\b \2\2\u0104@\3\2\2\2\u0105\u0107\t\6\2\2\u0106"+
		"\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2"+
		"\2\2\u0109\u010a\3\2\2\2\u010a\u010b\b!\2\2\u010bB\3\2\2\2\u010c\u010d"+
		"\7\17\2\2\u010d\u0110\7\f\2\2\u010e\u0110\t\5\2\2\u010f\u010c\3\2\2\2"+
		"\u010f\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\b\"\2\2\u0112D\3"+
		"\2\2\2\u0113\u0114\5w<\2\u0114\u0115\5\u0081A\2\u0115F\3\2\2\2\u0116\u0117"+
		"\5\u008dG\2\u0117\u0118\5o8\2\u0118\u0119\5\u008bF\2\u0119\u011d\5\u008d"+
		"G\2\u011a\u011c\5A!\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b"+
		"\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120"+
		"\u0121\5\u008bF\2\u0121\u0122\5\u008fH\2\u0122\u0123\5w<\2\u0123\u0124"+
		"\5\u008dG\2\u0124\u0128\5o8\2\u0125\u0127\5A!\2\u0126\u0125\3\2\2\2\u0127"+
		"\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129H\3\2\2\2"+
		"\u012a\u0128\3\2\2\2\u012b\u012c\5w<\2\u012c\u012d\5\177@\2\u012d\u012e"+
		"\5\u0085C\2\u012e\u012f\5\u0083B\2\u012f\u0130\5\u0089E\2\u0130\u0131"+
		"\5\u008dG\2\u0131\u0132\5\u008bF\2\u0132J\3\2\2\2\u0133\u0134\5w<\2\u0134"+
		"\u0135\5\177@\2\u0135\u0136\5\u0085C\2\u0136\u0137\5\u0083B\2\u0137\u0138"+
		"\5\u0089E\2\u0138\u0139\5\u008dG\2\u0139L\3\2\2\2\u013a\u013b\5\u0091"+
		"I\2\u013b\u013c\5g\64\2\u013c\u013d\5\u0089E\2\u013d\u013e\5\u008bF\2"+
		"\u013eN\3\2\2\2\u013f\u0140\5{>\2\u0140\u0141\5o8\2\u0141\u0142\5\u0097"+
		"L\2\u0142\u0143\5\u0093J\2\u0143\u0144\5\u0083B\2\u0144\u0145\5\u0089"+
		"E\2\u0145\u0146\5m\67\2\u0146\u0147\5\u008bF\2\u0147P\3\2\2\2\u0148\u0149"+
		"\5\u008dG\2\u0149\u014a\5o8\2\u014a\u014b\5\u008bF\2\u014b\u014f\5\u008d"+
		"G\2\u014c\u014e\5A!\2\u014d\u014c\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d"+
		"\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0152\3\2\2\2\u0151\u014f\3\2\2\2\u0152"+
		"\u0153\5k\66\2\u0153\u0154\5g\64\2\u0154\u0155\5\u008bF\2\u0155\u0156"+
		"\5o8\2\u0156\u0157\5\u008bF\2\u0157R\3\2\2\2\u0158\u0159\5i\65\2\u0159"+
		"\u015a\5o8\2\u015a\u015b\5s:\2\u015b\u015c\5w<\2\u015c\u015d\5\u0081A"+
		"\2\u015dT\3\2\2\2\u015e\u015f\5o8\2\u015f\u0160\5\u0081A\2\u0160\u0161"+
		"\5m\67\2\u0161V\3\2\2\2\u0162\u0163\5\u0089E\2\u0163\u0164\5o8\2\u0164"+
		"\u0165\5\u008dG\2\u0165\u0166\5\u008fH\2\u0166\u0167\5\u0089E\2\u0167"+
		"\u0168\5\u0081A\2\u0168X\3\2\2\2\u0169\u016a\5q9\2\u016a\u016b\5\u0083"+
		"B\2\u016b\u016c\5\u0089E\2\u016cZ\3\2\2\2\u016d\u016e\5o8\2\u016e\u016f"+
		"\5\u0081A\2\u016f\u0170\5m\67\2\u0170\u0171\5q9\2\u0171\u0172\5\u0083"+
		"B\2\u0172\u0173\5\u0089E\2\u0173\\\3\2\2\2\u0174\u0175\5\u0081A\2\u0175"+
		"\u0176\5\u008fH\2\u0176\u0177\5}?\2\u0177\u0178\5}?\2\u0178^\3\2\2\2\u0179"+
		"\u017a\5s:\2\u017a\u017b\5w<\2\u017b\u017c\5\u0091I\2\u017c\u017d\5o8"+
		"\2\u017d\u017e\5\u0081A\2\u017e`\3\2\2\2\u017f\u0180\5\u0093J\2\u0180"+
		"\u0181\5u;\2\u0181\u0182\5o8\2\u0182\u0183\5\u0081A\2\u0183b\3\2\2\2\u0184"+
		"\u0185\5\u008dG\2\u0185\u0186\5u;\2\u0186\u0187\5o8\2\u0187\u0188\5\u0081"+
		"A\2\u0188d\3\2\2\2\u0189\u018b\t\7\2\2\u018a\u0189\3\2\2\2\u018b\u018c"+
		"\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018df\3\2\2\2\u018e"+
		"\u018f\t\b\2\2\u018fh\3\2\2\2\u0190\u0191\t\t\2\2\u0191j\3\2\2\2\u0192"+
		"\u0193\t\n\2\2\u0193l\3\2\2\2\u0194\u0195\t\13\2\2\u0195n\3\2\2\2\u0196"+
		"\u0197\t\f\2\2\u0197p\3\2\2\2\u0198\u0199\t\r\2\2\u0199r\3\2\2\2\u019a"+
		"\u019b\t\16\2\2\u019bt\3\2\2\2\u019c\u019d\t\17\2\2\u019dv\3\2\2\2\u019e"+
		"\u019f\t\20\2\2\u019fx\3\2\2\2\u01a0\u01a1\t\21\2\2\u01a1z\3\2\2\2\u01a2"+
		"\u01a3\t\22\2\2\u01a3|\3\2\2\2\u01a4\u01a5\t\23\2\2\u01a5~\3\2\2\2\u01a6"+
		"\u01a7\t\24\2\2\u01a7\u0080\3\2\2\2\u01a8\u01a9\t\25\2\2\u01a9\u0082\3"+
		"\2\2\2\u01aa\u01ab\t\26\2\2\u01ab\u0084\3\2\2\2\u01ac\u01ad\t\27\2\2\u01ad"+
		"\u0086\3\2\2\2\u01ae\u01af\t\30\2\2\u01af\u0088\3\2\2\2\u01b0\u01b1\t"+
		"\31\2\2\u01b1\u008a\3\2\2\2\u01b2\u01b3\t\32\2\2\u01b3\u008c\3\2\2\2\u01b4"+
		"\u01b5\t\33\2\2\u01b5\u008e\3\2\2\2\u01b6\u01b7\t\34\2\2\u01b7\u0090\3"+
		"\2\2\2\u01b8\u01b9\t\35\2\2\u01b9\u0092\3\2\2\2\u01ba\u01bb\t\36\2\2\u01bb"+
		"\u0094\3\2\2\2\u01bc\u01bd\t\37\2\2\u01bd\u0096\3\2\2\2\u01be\u01bf\t"+
		" \2\2\u01bf\u0098\3\2\2\2\u01c0\u01c1\t!\2\2\u01c1\u009a\3\2\2\2\17\2"+
		"\u009f\u00a7\u00ef\u00f4\u00fa\u0100\u0108\u010f\u011d\u0128\u014f\u018c"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}