// Generated from Staf.g4 by ANTLR 4.8testCaseDefaultOrder
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
		T__0=1, T__1=2, SINGLE_STRING=3, DOUBLE_STRING=4, EQUAL=5, COMMA=6, RUN=7, 
		KEYWORD=8, IF=9, ELSE=10, PLUS=11, MINUS=12, MUL=13, DIV=14, MOD=15, LT=16, 
		GT=17, LTE=18, GTE=19, NE=20, NOT=21, AND_OP=22, OR=23, LPARENT=24, RPARENT=25, 
		LBRACKET=26, RBRACKET=27, LBRACE=28, RBRACE=29, DOT=30, COLON=31, DOLLAR=32, 
		TRUE=33, FALSE=34, INT=35, FLOAT=36, COMMENT=37, SPACE=38, NL=39, TEST_SUITE=40, 
		IMPORTS=41, IMPORT=42, VARS=43, KEYWORDS=44, TEST_CASES=45, BEGIN=46, 
		END=47, RETURN=48, FOR=49, ENDFOR=50, NULL=51, GIVEN=52, WHEN=53, THEN=54, 
		IGNORE=55, EXIT=56, LOOP=57, IDENTIFIER=58;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "SINGLE_STRING", "DOUBLE_STRING", "EQUAL", "COMMA", "RUN", 
			"KEYWORD", "IF", "ELSE", "PLUS", "MINUS", "MUL", "DIV", "MOD", "LT", 
			"GT", "LTE", "GTE", "NE", "NOT", "AND_OP", "OR", "LPARENT", "RPARENT", 
			"LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "DOT", "COLON", "DOLLAR", 
			"TRUE", "FALSE", "INT", "FLOAT", "COMMENT", "SPACE", "NL", "TEST_SUITE", 
			"IMPORTS", "IMPORT", "VARS", "KEYWORDS", "TEST_CASES", "BEGIN", "END", 
			"RETURN", "FOR", "ENDFOR", "NULL", "GIVEN", "WHEN", "THEN", "IGNORE", 
			"EXIT", "LOOP", "IDENTIFIER", "A", "B", "C", "D", "E", "F", "G", "H", 
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", 
			"W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@'", "'AND'", null, null, "'='", "','", null, null, null, null, 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'<'", "'>'", "'<='", "'>='", "'!='", 
			"'!'", "'&'", null, "'('", "')'", "'['", "']'", "'{'", "'}'", "'.'", 
			"':'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "SINGLE_STRING", "DOUBLE_STRING", "EQUAL", "COMMA", 
			"RUN", "KEYWORD", "IF", "ELSE", "PLUS", "MINUS", "MUL", "DIV", "MOD", 
			"LT", "GT", "LTE", "GTE", "NE", "NOT", "AND_OP", "OR", "LPARENT", "RPARENT", 
			"LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "DOT", "COLON", "DOLLAR", 
			"TRUE", "FALSE", "INT", "FLOAT", "COMMENT", "SPACE", "NL", "TEST_SUITE", 
			"IMPORTS", "IMPORT", "VARS", "KEYWORDS", "TEST_CASES", "BEGIN", "END", 
			"RETURN", "FOR", "ENDFOR", "NULL", "GIVEN", "WHEN", "THEN", "IGNORE", 
			"EXIT", "LOOP", "IDENTIFIER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2<\u01fa\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\7\4\u00b4\n\4\f\4\16\4\u00b7\13"+
		"\4\3\4\3\4\3\5\3\5\7\5\u00bd\n\5\f\5\16\5\u00c0\13\5\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#"+
		"\3#\3#\3$\6$\u0118\n$\r$\16$\u0119\3%\6%\u011d\n%\r%\16%\u011e\3%\3%\6"+
		"%\u0123\n%\r%\16%\u0124\3&\3&\7&\u0129\n&\f&\16&\u012c\13&\3&\3&\3\'\6"+
		"\'\u0131\n\'\r\'\16\'\u0132\3\'\3\'\3(\3(\3(\5(\u013a\n(\3(\3(\3)\3)\3"+
		")\3)\3)\7)\u0143\n)\f)\16)\u0146\13)\3)\3)\3)\3)\3)\3)\7)\u014e\n)\f)"+
		"\16)\u0151\13)\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3"+
		",\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\7.\u0175\n.\f.\16.\u0178"+
		"\13.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\66"+
		"\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\38\39"+
		"\39\39\39\39\3:\3:\3:\3:\3:\3;\6;\u01c3\n;\r;\16;\u01c4\3<\3<\3=\3=\3"+
		">\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3"+
		"I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3"+
		"U\3U\2\2V\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\66k\67m8o9q:s;u<w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089"+
		"\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b"+
		"\2\u009d\2\u009f\2\u00a1\2\u00a3\2\u00a5\2\u00a7\2\u00a9\2\3\2\"\3\2)"+
		")\3\2$$\3\2\62;\4\2\f\f\17\17\4\2\13\13\"\"\6\2\62;C\\aac|\4\2CCcc\4\2"+
		"DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4"+
		"\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUu"+
		"u\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u01eb\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2"+
		"\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2"+
		"\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\3\u00ab\3\2\2\2\5\u00ad\3"+
		"\2\2\2\7\u00b1\3\2\2\2\t\u00ba\3\2\2\2\13\u00c3\3\2\2\2\r\u00c5\3\2\2"+
		"\2\17\u00c7\3\2\2\2\21\u00cb\3\2\2\2\23\u00d3\3\2\2\2\25\u00d6\3\2\2\2"+
		"\27\u00db\3\2\2\2\31\u00dd\3\2\2\2\33\u00df\3\2\2\2\35\u00e1\3\2\2\2\37"+
		"\u00e3\3\2\2\2!\u00e5\3\2\2\2#\u00e7\3\2\2\2%\u00e9\3\2\2\2\'\u00ec\3"+
		"\2\2\2)\u00ef\3\2\2\2+\u00f2\3\2\2\2-\u00f4\3\2\2\2/\u00f6\3\2\2\2\61"+
		"\u00f9\3\2\2\2\63\u00fb\3\2\2\2\65\u00fd\3\2\2\2\67\u00ff\3\2\2\29\u0101"+
		"\3\2\2\2;\u0103\3\2\2\2=\u0105\3\2\2\2?\u0107\3\2\2\2A\u0109\3\2\2\2C"+
		"\u010b\3\2\2\2E\u0110\3\2\2\2G\u0117\3\2\2\2I\u011c\3\2\2\2K\u0126\3\2"+
		"\2\2M\u0130\3\2\2\2O\u0139\3\2\2\2Q\u013d\3\2\2\2S\u0152\3\2\2\2U\u015a"+
		"\3\2\2\2W\u0161\3\2\2\2Y\u0166\3\2\2\2[\u016f\3\2\2\2]\u017f\3\2\2\2_"+
		"\u0185\3\2\2\2a\u0189\3\2\2\2c\u0190\3\2\2\2e\u0194\3\2\2\2g\u019b\3\2"+
		"\2\2i\u01a0\3\2\2\2k\u01a6\3\2\2\2m\u01ab\3\2\2\2o\u01b0\3\2\2\2q\u01b7"+
		"\3\2\2\2s\u01bc\3\2\2\2u\u01c2\3\2\2\2w\u01c6\3\2\2\2y\u01c8\3\2\2\2{"+
		"\u01ca\3\2\2\2}\u01cc\3\2\2\2\177\u01ce\3\2\2\2\u0081\u01d0\3\2\2\2\u0083"+
		"\u01d2\3\2\2\2\u0085\u01d4\3\2\2\2\u0087\u01d6\3\2\2\2\u0089\u01d8\3\2"+
		"\2\2\u008b\u01da\3\2\2\2\u008d\u01dc\3\2\2\2\u008f\u01de\3\2\2\2\u0091"+
		"\u01e0\3\2\2\2\u0093\u01e2\3\2\2\2\u0095\u01e4\3\2\2\2\u0097\u01e6\3\2"+
		"\2\2\u0099\u01e8\3\2\2\2\u009b\u01ea\3\2\2\2\u009d\u01ec\3\2\2\2\u009f"+
		"\u01ee\3\2\2\2\u00a1\u01f0\3\2\2\2\u00a3\u01f2\3\2\2\2\u00a5\u01f4\3\2"+
		"\2\2\u00a7\u01f6\3\2\2\2\u00a9\u01f8\3\2\2\2\u00ab\u00ac\7B\2\2\u00ac"+
		"\4\3\2\2\2\u00ad\u00ae\7C\2\2\u00ae\u00af\7P\2\2\u00af\u00b0\7F\2\2\u00b0"+
		"\6\3\2\2\2\u00b1\u00b5\7)\2\2\u00b2\u00b4\n\2\2\2\u00b3\u00b2\3\2\2\2"+
		"\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8"+
		"\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7)\2\2\u00b9\b\3\2\2\2\u00ba"+
		"\u00be\7$\2\2\u00bb\u00bd\n\3\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2"+
		"\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c1\u00c2\7$\2\2\u00c2\n\3\2\2\2\u00c3\u00c4\7?\2\2\u00c4"+
		"\f\3\2\2\2\u00c5\u00c6\7.\2\2\u00c6\16\3\2\2\2\u00c7\u00c8\5\u0099M\2"+
		"\u00c8\u00c9\5\u009fP\2\u00c9\u00ca\5\u0091I\2\u00ca\20\3\2\2\2\u00cb"+
		"\u00cc\5\u008bF\2\u00cc\u00cd\5\177@\2\u00cd\u00ce\5\u00a7T\2\u00ce\u00cf"+
		"\5\u00a3R\2\u00cf\u00d0\5\u0093J\2\u00d0\u00d1\5\u0099M\2\u00d1\u00d2"+
		"\5}?\2\u00d2\22\3\2\2\2\u00d3\u00d4\5\u0087D\2\u00d4\u00d5\5\u0081A\2"+
		"\u00d5\24\3\2\2\2\u00d6\u00d7\5\177@\2\u00d7\u00d8\5\u008dG\2\u00d8\u00d9"+
		"\5\u009bN\2\u00d9\u00da\5\177@\2\u00da\26\3\2\2\2\u00db\u00dc\7-\2\2\u00dc"+
		"\30\3\2\2\2\u00dd\u00de\7/\2\2\u00de\32\3\2\2\2\u00df\u00e0\7,\2\2\u00e0"+
		"\34\3\2\2\2\u00e1\u00e2\7\61\2\2\u00e2\36\3\2\2\2\u00e3\u00e4\7\'\2\2"+
		"\u00e4 \3\2\2\2\u00e5\u00e6\7>\2\2\u00e6\"\3\2\2\2\u00e7\u00e8\7@\2\2"+
		"\u00e8$\3\2\2\2\u00e9\u00ea\7>\2\2\u00ea\u00eb\7?\2\2\u00eb&\3\2\2\2\u00ec"+
		"\u00ed\7@\2\2\u00ed\u00ee\7?\2\2\u00ee(\3\2\2\2\u00ef\u00f0\7#\2\2\u00f0"+
		"\u00f1\7?\2\2\u00f1*\3\2\2\2\u00f2\u00f3\7#\2\2\u00f3,\3\2\2\2\u00f4\u00f5"+
		"\7(\2\2\u00f5.\3\2\2\2\u00f6\u00f7\5\u0093J\2\u00f7\u00f8\5\u0099M\2\u00f8"+
		"\60\3\2\2\2\u00f9\u00fa\7*\2\2\u00fa\62\3\2\2\2\u00fb\u00fc\7+\2\2\u00fc"+
		"\64\3\2\2\2\u00fd\u00fe\7]\2\2\u00fe\66\3\2\2\2\u00ff\u0100\7_\2\2\u0100"+
		"8\3\2\2\2\u0101\u0102\7}\2\2\u0102:\3\2\2\2\u0103\u0104\7\177\2\2\u0104"+
		"<\3\2\2\2\u0105\u0106\7\60\2\2\u0106>\3\2\2\2\u0107\u0108\7<\2\2\u0108"+
		"@\3\2\2\2\u0109\u010a\7&\2\2\u010aB\3\2\2\2\u010b\u010c\5\u009dO\2\u010c"+
		"\u010d\5\u0099M\2\u010d\u010e\5\u009fP\2\u010e\u010f\5\177@\2\u010fD\3"+
		"\2\2\2\u0110\u0111\5\u0081A\2\u0111\u0112\5w<\2\u0112\u0113\5\u008dG\2"+
		"\u0113\u0114\5\u009bN\2\u0114\u0115\5\177@\2\u0115F\3\2\2\2\u0116\u0118"+
		"\t\4\2\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011aH\3\2\2\2\u011b\u011d\t\4\2\2\u011c\u011b\3\2\2\2"+
		"\u011d\u011e\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0120"+
		"\3\2\2\2\u0120\u0122\7\60\2\2\u0121\u0123\t\4\2\2\u0122\u0121\3\2\2\2"+
		"\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125J\3"+
		"\2\2\2\u0126\u012a\7%\2\2\u0127\u0129\n\5\2\2\u0128\u0127\3\2\2\2\u0129"+
		"\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d\3\2"+
		"\2\2\u012c\u012a\3\2\2\2\u012d\u012e\b&\2\2\u012eL\3\2\2\2\u012f\u0131"+
		"\t\6\2\2\u0130\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\b\'\2\2\u0135N\3\2\2\2"+
		"\u0136\u0137\7\17\2\2\u0137\u013a\7\f\2\2\u0138\u013a\t\5\2\2\u0139\u0136"+
		"\3\2\2\2\u0139\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\b(\2\2\u013c"+
		"P\3\2\2\2\u013d\u013e\5\u009dO\2\u013e\u013f\5\177@\2\u013f\u0140\5\u009b"+
		"N\2\u0140\u0144\5\u009dO\2\u0141\u0143\5M\'\2\u0142\u0141\3\2\2\2\u0143"+
		"\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147\3\2"+
		"\2\2\u0146\u0144\3\2\2\2\u0147\u0148\5\u009bN\2\u0148\u0149\5\u009fP\2"+
		"\u0149\u014a\5\u0087D\2\u014a\u014b\5\u009dO\2\u014b\u014f\5\177@\2\u014c"+
		"\u014e\5M\'\2\u014d\u014c\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2"+
		"\2\2\u014f\u0150\3\2\2\2\u0150R\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0153"+
		"\5\u0087D\2\u0153\u0154\5\u008fH\2\u0154\u0155\5\u0095K\2\u0155\u0156"+
		"\5\u0093J\2\u0156\u0157\5\u0099M\2\u0157\u0158\5\u009dO\2\u0158\u0159"+
		"\5\u009bN\2\u0159T\3\2\2\2\u015a\u015b\5\u0087D\2\u015b\u015c\5\u008f"+
		"H\2\u015c\u015d\5\u0095K\2\u015d\u015e\5\u0093J\2\u015e\u015f\5\u0099"+
		"M\2\u015f\u0160\5\u009dO\2\u0160V\3\2\2\2\u0161\u0162\5\u00a1Q\2\u0162"+
		"\u0163\5w<\2\u0163\u0164\5\u0099M\2\u0164\u0165\5\u009bN\2\u0165X\3\2"+
		"\2\2\u0166\u0167\5\u008bF\2\u0167\u0168\5\177@\2\u0168\u0169\5\u00a7T"+
		"\2\u0169\u016a\5\u00a3R\2\u016a\u016b\5\u0093J\2\u016b\u016c\5\u0099M"+
		"\2\u016c\u016d\5}?\2\u016d\u016e\5\u009bN\2\u016eZ\3\2\2\2\u016f\u0170"+
		"\5\u009dO\2\u0170\u0171\5\177@\2\u0171\u0172\5\u009bN\2\u0172\u0176\5"+
		"\u009dO\2\u0173\u0175\5M\'\2\u0174\u0173\3\2\2\2\u0175\u0178\3\2\2\2\u0176"+
		"\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0179\3\2\2\2\u0178\u0176\3\2"+
		"\2\2\u0179\u017a\5{>\2\u017a\u017b\5w<\2\u017b\u017c\5\u009bN\2\u017c"+
		"\u017d\5\177@\2\u017d\u017e\5\u009bN\2\u017e\\\3\2\2\2\u017f\u0180\5y"+
		"=\2\u0180\u0181\5\177@\2\u0181\u0182\5\u0083B\2\u0182\u0183\5\u0087D\2"+
		"\u0183\u0184\5\u0091I\2\u0184^\3\2\2\2\u0185\u0186\5\177@\2\u0186\u0187"+
		"\5\u0091I\2\u0187\u0188\5}?\2\u0188`\3\2\2\2\u0189\u018a\5\u0099M\2\u018a"+
		"\u018b\5\177@\2\u018b\u018c\5\u009dO\2\u018c\u018d\5\u009fP\2\u018d\u018e"+
		"\5\u0099M\2\u018e\u018f\5\u0091I\2\u018fb\3\2\2\2\u0190\u0191\5\u0081"+
		"A\2\u0191\u0192\5\u0093J\2\u0192\u0193\5\u0099M\2\u0193d\3\2\2\2\u0194"+
		"\u0195\5\177@\2\u0195\u0196\5\u0091I\2\u0196\u0197\5}?\2\u0197\u0198\5"+
		"\u0081A\2\u0198\u0199\5\u0093J\2\u0199\u019a\5\u0099M\2\u019af\3\2\2\2"+
		"\u019b\u019c\5\u0091I\2\u019c\u019d\5\u009fP\2\u019d\u019e\5\u008dG\2"+
		"\u019e\u019f\5\u008dG\2\u019fh\3\2\2\2\u01a0\u01a1\5\u0083B\2\u01a1\u01a2"+
		"\5\u0087D\2\u01a2\u01a3\5\u00a1Q\2\u01a3\u01a4\5\177@\2\u01a4\u01a5\5"+
		"\u0091I\2\u01a5j\3\2\2\2\u01a6\u01a7\5\u00a3R\2\u01a7\u01a8\5\u0085C\2"+
		"\u01a8\u01a9\5\177@\2\u01a9\u01aa\5\u0091I\2\u01aal\3\2\2\2\u01ab\u01ac"+
		"\5\u009dO\2\u01ac\u01ad\5\u0085C\2\u01ad\u01ae\5\177@\2\u01ae\u01af\5"+
		"\u0091I\2\u01afn\3\2\2\2\u01b0\u01b1\5\u0087D\2\u01b1\u01b2\5\u0083B\2"+
		"\u01b2\u01b3\5\u0091I\2\u01b3\u01b4\5\u0093J\2\u01b4\u01b5\5\u0099M\2"+
		"\u01b5\u01b6\5\177@\2\u01b6p\3\2\2\2\u01b7\u01b8\5\177@\2\u01b8\u01b9"+
		"\5\u00a5S\2\u01b9\u01ba\5\u0087D\2\u01ba\u01bb\5\u009dO\2\u01bbr\3\2\2"+
		"\2\u01bc\u01bd\5\u008dG\2\u01bd\u01be\5\u0093J\2\u01be\u01bf\5\u0093J"+
		"\2\u01bf\u01c0\5\u0095K\2\u01c0t\3\2\2\2\u01c1\u01c3\t\7\2\2\u01c2\u01c1"+
		"\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5"+
		"v\3\2\2\2\u01c6\u01c7\t\b\2\2\u01c7x\3\2\2\2\u01c8\u01c9\t\t\2\2\u01c9"+
		"z\3\2\2\2\u01ca\u01cb\t\n\2\2\u01cb|\3\2\2\2\u01cc\u01cd\t\13\2\2\u01cd"+
		"~\3\2\2\2\u01ce\u01cf\t\f\2\2\u01cf\u0080\3\2\2\2\u01d0\u01d1\t\r\2\2"+
		"\u01d1\u0082\3\2\2\2\u01d2\u01d3\t\16\2\2\u01d3\u0084\3\2\2\2\u01d4\u01d5"+
		"\t\17\2\2\u01d5\u0086\3\2\2\2\u01d6\u01d7\t\20\2\2\u01d7\u0088\3\2\2\2"+
		"\u01d8\u01d9\t\21\2\2\u01d9\u008a\3\2\2\2\u01da\u01db\t\22\2\2\u01db\u008c"+
		"\3\2\2\2\u01dc\u01dd\t\23\2\2\u01dd\u008e\3\2\2\2\u01de\u01df\t\24\2\2"+
		"\u01df\u0090\3\2\2\2\u01e0\u01e1\t\25\2\2\u01e1\u0092\3\2\2\2\u01e2\u01e3"+
		"\t\26\2\2\u01e3\u0094\3\2\2\2\u01e4\u01e5\t\27\2\2\u01e5\u0096\3\2\2\2"+
		"\u01e6\u01e7\t\30\2\2\u01e7\u0098\3\2\2\2\u01e8\u01e9\t\31\2\2\u01e9\u009a"+
		"\3\2\2\2\u01ea\u01eb\t\32\2\2\u01eb\u009c\3\2\2\2\u01ec\u01ed\t\33\2\2"+
		"\u01ed\u009e\3\2\2\2\u01ee\u01ef\t\34\2\2\u01ef\u00a0\3\2\2\2\u01f0\u01f1"+
		"\t\35\2\2\u01f1\u00a2\3\2\2\2\u01f2\u01f3\t\36\2\2\u01f3\u00a4\3\2\2\2"+
		"\u01f4\u01f5\t\37\2\2\u01f5\u00a6\3\2\2\2\u01f6\u01f7\t \2\2\u01f7\u00a8"+
		"\3\2\2\2\u01f8\u01f9\t!\2\2\u01f9\u00aa\3\2\2\2\17\2\u00b5\u00be\u0119"+
		"\u011e\u0124\u012a\u0132\u0139\u0144\u014f\u0176\u01c4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}