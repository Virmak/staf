// Generated from Staf.g4 by ANTLR 4.8
package com.sparkit.staf.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StafParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SINGLE_STRING=1, DOUBLE_STRING=2, EQUAL=3, COMMA=4, RUN=5, KEYWORD=6, 
		IF=7, PLUS=8, MINUS=9, MUL=10, DIV=11, MOD=12, LT=13, GT=14, LTE=15, GTE=16, 
		NE=17, NOT=18, AND_OP=19, OR=20, LPARENT=21, RPARENT=22, LBRACKET=23, 
		RBRACKET=24, LBRACE=25, RBRACE=26, DOT=27, COLON=28, DOLLAR=29, TRUE=30, 
		FALSE=31, INT=32, FLOAT=33, COMMENT=34, SPACE=35, NL=36, IN=37, TEST_SUITE=38, 
		IMPORTS=39, IMPORT=40, VARS=41, KEYWORDS=42, TEST_CASES=43, BEGIN=44, 
		END=45, RETURN=46, FOR=47, ENDFOR=48, NULL=49, GIVEN=50, WHEN=51, THEN=52, 
		AND=53, IDENTIFIER=54;
	public static final int
		RULE_staf_file = 0, RULE_suite_name = 1, RULE_imports_section = 2, RULE_import_stat = 3, 
		RULE_import_obj = 4, RULE_vars_section = 5, RULE_test_cases_section = 6, 
		RULE_test_case_declaration = 7, RULE_test_case_body = 8, RULE_keywords_section = 9, 
		RULE_keyword_declaration = 10, RULE_keyword_body = 11, RULE_statement = 12, 
		RULE_run_keyword_if = 13, RULE_keyword_call = 14, RULE_keyword_call_arguments = 15, 
		RULE_keyword_return_stat = 16, RULE_keyword_name = 17, RULE_keyword_declaration_arguments = 18, 
		RULE_assignment = 19, RULE_for_stat = 20, RULE_for_stat_body = 21, RULE_listLiteral = 22, 
		RULE_dictionaryLiteral = 23, RULE_keyValuePair = 24, RULE_object = 25, 
		RULE_complex_object = 26, RULE_scalar_object = 27, RULE_variable_reference = 28, 
		RULE_primitive = 29, RULE_variable = 30, RULE_list_item_access = 31, RULE_dictionary_item_access = 32, 
		RULE_expression = 33, RULE_mulop = 34, RULE_addop = 35, RULE_binop = 36, 
		RULE_number = 37, RULE_string = 38, RULE_bool = 39;
	private static String[] makeRuleNames() {
		return new String[] {
			"staf_file", "suite_name", "imports_section", "import_stat", "import_obj", 
			"vars_section", "test_cases_section", "test_case_declaration", "test_case_body", 
			"keywords_section", "keyword_declaration", "keyword_body", "statement", 
			"run_keyword_if", "keyword_call", "keyword_call_arguments", "keyword_return_stat", 
			"keyword_name", "keyword_declaration_arguments", "assignment", "for_stat", 
			"for_stat_body", "listLiteral", "dictionaryLiteral", "keyValuePair", 
			"object", "complex_object", "scalar_object", "variable_reference", "primitive", 
			"variable", "list_item_access", "dictionary_item_access", "expression", 
			"mulop", "addop", "binop", "number", "string", "bool"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'='", "','", null, null, null, "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'<'", "'>'", "'<='", "'>='", "'!='", "'!'", "'&'", null, 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "'.'", "':'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SINGLE_STRING", "DOUBLE_STRING", "EQUAL", "COMMA", "RUN", "KEYWORD", 
			"IF", "PLUS", "MINUS", "MUL", "DIV", "MOD", "LT", "GT", "LTE", "GTE", 
			"NE", "NOT", "AND_OP", "OR", "LPARENT", "RPARENT", "LBRACKET", "RBRACKET", 
			"LBRACE", "RBRACE", "DOT", "COLON", "DOLLAR", "TRUE", "FALSE", "INT", 
			"FLOAT", "COMMENT", "SPACE", "NL", "IN", "TEST_SUITE", "IMPORTS", "IMPORT", 
			"VARS", "KEYWORDS", "TEST_CASES", "BEGIN", "END", "RETURN", "FOR", "ENDFOR", 
			"NULL", "GIVEN", "WHEN", "THEN", "AND", "IDENTIFIER"
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

	@Override
	public String getGrammarFileName() { return "Staf.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public StafParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Staf_fileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(StafParser.EOF, 0); }
		public Suite_nameContext suite_name() {
			return getRuleContext(Suite_nameContext.class,0);
		}
		public Imports_sectionContext imports_section() {
			return getRuleContext(Imports_sectionContext.class,0);
		}
		public Vars_sectionContext vars_section() {
			return getRuleContext(Vars_sectionContext.class,0);
		}
		public Keywords_sectionContext keywords_section() {
			return getRuleContext(Keywords_sectionContext.class,0);
		}
		public Test_cases_sectionContext test_cases_section() {
			return getRuleContext(Test_cases_sectionContext.class,0);
		}
		public Staf_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staf_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterStaf_file(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitStaf_file(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitStaf_file(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Staf_fileContext staf_file() throws RecognitionException {
		Staf_fileContext _localctx = new Staf_fileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_staf_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEST_SUITE) {
				{
				setState(80);
				suite_name();
				}
			}

			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPORTS) {
				{
				setState(83);
				imports_section();
				}
			}

			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARS) {
				{
				setState(86);
				vars_section();
				}
			}

			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORDS) {
				{
				setState(89);
				keywords_section();
				}
			}

			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEST_CASES) {
				{
				setState(92);
				test_cases_section();
				}
			}

			setState(95);
			match(EOF);
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

	public static class Suite_nameContext extends ParserRuleContext {
		public TerminalNode TEST_SUITE() { return getToken(StafParser.TEST_SUITE, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public Suite_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterSuite_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitSuite_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitSuite_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Suite_nameContext suite_name() throws RecognitionException {
		Suite_nameContext _localctx = new Suite_nameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_suite_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(TEST_SUITE);
			setState(98);
			string();
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

	public static class Imports_sectionContext extends ParserRuleContext {
		public TerminalNode IMPORTS() { return getToken(StafParser.IMPORTS, 0); }
		public List<Import_statContext> import_stat() {
			return getRuleContexts(Import_statContext.class);
		}
		public Import_statContext import_stat(int i) {
			return getRuleContext(Import_statContext.class,i);
		}
		public Imports_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imports_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterImports_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitImports_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitImports_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Imports_sectionContext imports_section() throws RecognitionException {
		Imports_sectionContext _localctx = new Imports_sectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_imports_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(IMPORTS);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(101);
				import_stat();
				}
				}
				setState(106);
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

	public static class Import_statContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(StafParser.IMPORT, 0); }
		public Import_objContext import_obj() {
			return getRuleContext(Import_objContext.class,0);
		}
		public Import_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterImport_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitImport_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitImport_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_statContext import_stat() throws RecognitionException {
		Import_statContext _localctx = new Import_statContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_import_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(IMPORT);
			setState(108);
			import_obj();
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

	public static class Import_objContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(StafParser.IDENTIFIER, 0); }
		public Import_objContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_obj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterImport_obj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitImport_obj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitImport_obj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_objContext import_obj() throws RecognitionException {
		Import_objContext _localctx = new Import_objContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_import_obj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
			case DOUBLE_STRING:
				{
				setState(110);
				string();
				}
				break;
			case IDENTIFIER:
				{
				setState(111);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Vars_sectionContext extends ParserRuleContext {
		public TerminalNode VARS() { return getToken(StafParser.VARS, 0); }
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public Vars_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterVars_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitVars_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitVars_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Vars_sectionContext vars_section() throws RecognitionException {
		Vars_sectionContext _localctx = new Vars_sectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_vars_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(VARS);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOLLAR) {
				{
				{
				setState(115);
				assignment();
				}
				}
				setState(120);
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

	public static class Test_cases_sectionContext extends ParserRuleContext {
		public TerminalNode TEST_CASES() { return getToken(StafParser.TEST_CASES, 0); }
		public List<Test_case_declarationContext> test_case_declaration() {
			return getRuleContexts(Test_case_declarationContext.class);
		}
		public Test_case_declarationContext test_case_declaration(int i) {
			return getRuleContext(Test_case_declarationContext.class,i);
		}
		public Test_cases_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_cases_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterTest_cases_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitTest_cases_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitTest_cases_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_cases_sectionContext test_cases_section() throws RecognitionException {
		Test_cases_sectionContext _localctx = new Test_cases_sectionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_test_cases_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(TEST_CASES);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(122);
				test_case_declaration();
				}
				}
				setState(127);
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

	public static class Test_case_declarationContext extends ParserRuleContext {
		public Keyword_nameContext keyword_name() {
			return getRuleContext(Keyword_nameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(StafParser.COLON, 0); }
		public Test_case_bodyContext test_case_body() {
			return getRuleContext(Test_case_bodyContext.class,0);
		}
		public TerminalNode END() { return getToken(StafParser.END, 0); }
		public Test_case_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_case_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterTest_case_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitTest_case_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitTest_case_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_case_declarationContext test_case_declaration() throws RecognitionException {
		Test_case_declarationContext _localctx = new Test_case_declarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_test_case_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			keyword_name();
			setState(129);
			match(COLON);
			setState(130);
			test_case_body();
			setState(131);
			match(END);
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

	public static class Test_case_bodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Test_case_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_case_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterTest_case_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitTest_case_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitTest_case_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_case_bodyContext test_case_body() throws RecognitionException {
		Test_case_bodyContext _localctx = new Test_case_bodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_test_case_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RUN) | (1L << DOLLAR) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << AND) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(133);
				statement();
				}
				}
				setState(138);
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

	public static class Keywords_sectionContext extends ParserRuleContext {
		public TerminalNode KEYWORDS() { return getToken(StafParser.KEYWORDS, 0); }
		public List<Keyword_declarationContext> keyword_declaration() {
			return getRuleContexts(Keyword_declarationContext.class);
		}
		public Keyword_declarationContext keyword_declaration(int i) {
			return getRuleContext(Keyword_declarationContext.class,i);
		}
		public Keywords_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywords_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterKeywords_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitKeywords_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitKeywords_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keywords_sectionContext keywords_section() throws RecognitionException {
		Keywords_sectionContext _localctx = new Keywords_sectionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_keywords_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(KEYWORDS);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(140);
				keyword_declaration();
				}
				}
				setState(145);
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

	public static class Keyword_declarationContext extends ParserRuleContext {
		public Keyword_nameContext keyword_name() {
			return getRuleContext(Keyword_nameContext.class,0);
		}
		public Keyword_declaration_argumentsContext keyword_declaration_arguments() {
			return getRuleContext(Keyword_declaration_argumentsContext.class,0);
		}
		public Keyword_bodyContext keyword_body() {
			return getRuleContext(Keyword_bodyContext.class,0);
		}
		public Keyword_return_statContext keyword_return_stat() {
			return getRuleContext(Keyword_return_statContext.class,0);
		}
		public Keyword_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterKeyword_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitKeyword_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitKeyword_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_declarationContext keyword_declaration() throws RecognitionException {
		Keyword_declarationContext _localctx = new Keyword_declarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_keyword_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			keyword_name();
			setState(147);
			keyword_declaration_arguments();
			setState(148);
			keyword_body();
			setState(149);
			keyword_return_stat();
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

	public static class Keyword_bodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Keyword_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterKeyword_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitKeyword_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitKeyword_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_bodyContext keyword_body() throws RecognitionException {
		Keyword_bodyContext _localctx = new Keyword_bodyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_keyword_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RUN) | (1L << DOLLAR) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << AND) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(151);
				statement();
				}
				}
				setState(156);
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

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Keyword_callContext keyword_call() {
			return getRuleContext(Keyword_callContext.class,0);
		}
		public For_statContext for_stat() {
			return getRuleContext(For_statContext.class,0);
		}
		public Run_keyword_ifContext run_keyword_if() {
			return getRuleContext(Run_keyword_ifContext.class,0);
		}
		public TerminalNode GIVEN() { return getToken(StafParser.GIVEN, 0); }
		public TerminalNode WHEN() { return getToken(StafParser.WHEN, 0); }
		public TerminalNode THEN() { return getToken(StafParser.THEN, 0); }
		public TerminalNode AND() { return getToken(StafParser.AND, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << AND))) != 0)) {
				{
				setState(157);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << AND))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
				{
				setState(160);
				assignment();
				}
				break;
			case IDENTIFIER:
				{
				setState(161);
				keyword_call();
				}
				break;
			case FOR:
				{
				setState(162);
				for_stat();
				}
				break;
			case RUN:
				{
				setState(163);
				run_keyword_if();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Run_keyword_ifContext extends ParserRuleContext {
		public TerminalNode RUN() { return getToken(StafParser.RUN, 0); }
		public TerminalNode KEYWORD() { return getToken(StafParser.KEYWORD, 0); }
		public TerminalNode IF() { return getToken(StafParser.IF, 0); }
		public TerminalNode LPARENT() { return getToken(StafParser.LPARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPARENT() { return getToken(StafParser.RPARENT, 0); }
		public Keyword_callContext keyword_call() {
			return getRuleContext(Keyword_callContext.class,0);
		}
		public Run_keyword_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_run_keyword_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterRun_keyword_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitRun_keyword_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitRun_keyword_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Run_keyword_ifContext run_keyword_if() throws RecognitionException {
		Run_keyword_ifContext _localctx = new Run_keyword_ifContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_run_keyword_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(RUN);
			setState(167);
			match(KEYWORD);
			setState(168);
			match(IF);
			setState(169);
			match(LPARENT);
			setState(170);
			expression(0);
			setState(171);
			match(RPARENT);
			setState(172);
			keyword_call();
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

	public static class Keyword_callContext extends ParserRuleContext {
		public Keyword_nameContext keyword_name() {
			return getRuleContext(Keyword_nameContext.class,0);
		}
		public Keyword_call_argumentsContext keyword_call_arguments() {
			return getRuleContext(Keyword_call_argumentsContext.class,0);
		}
		public Keyword_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterKeyword_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitKeyword_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitKeyword_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_callContext keyword_call() throws RecognitionException {
		Keyword_callContext _localctx = new Keyword_callContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_keyword_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			keyword_name();
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(175);
				keyword_call_arguments();
				}
				break;
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

	public static class Keyword_call_argumentsContext extends ParserRuleContext {
		public TerminalNode LPARENT() { return getToken(StafParser.LPARENT, 0); }
		public TerminalNode RPARENT() { return getToken(StafParser.RPARENT, 0); }
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StafParser.COMMA, i);
		}
		public Keyword_call_argumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_call_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterKeyword_call_arguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitKeyword_call_arguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitKeyword_call_arguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_call_argumentsContext keyword_call_arguments() throws RecognitionException {
		Keyword_call_argumentsContext _localctx = new Keyword_call_argumentsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_keyword_call_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(LPARENT);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SINGLE_STRING) | (1L << DOUBLE_STRING) | (1L << MINUS) | (1L << NOT) | (1L << LPARENT) | (1L << LBRACKET) | (1L << LBRACE) | (1L << DOLLAR) | (1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << FLOAT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(179);
				object();
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(180);
					match(COMMA);
					setState(181);
					object();
					}
					}
					setState(186);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(189);
			match(RPARENT);
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

	public static class Keyword_return_statContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(StafParser.RETURN, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public TerminalNode END() { return getToken(StafParser.END, 0); }
		public Keyword_return_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_return_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterKeyword_return_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitKeyword_return_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitKeyword_return_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_return_statContext keyword_return_stat() throws RecognitionException {
		Keyword_return_statContext _localctx = new Keyword_return_statContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_keyword_return_stat);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(191);
				match(RETURN);
				setState(192);
				object();
				}
				}
				break;
			case END:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Keyword_nameContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(StafParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(StafParser.IDENTIFIER, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(StafParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(StafParser.SPACE, i);
		}
		public Keyword_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterKeyword_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitKeyword_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitKeyword_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_nameContext keyword_name() throws RecognitionException {
		Keyword_nameContext _localctx = new Keyword_nameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_keyword_name);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(IDENTIFIER);
			setState(206);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACE) {
						{
						{
						setState(197);
						match(SPACE);
						}
						}
						setState(202);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(203);
					match(IDENTIFIER);
					}
					} 
				}
				setState(208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class Keyword_declaration_argumentsContext extends ParserRuleContext {
		public TerminalNode LPARENT() { return getToken(StafParser.LPARENT, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StafParser.COMMA, i);
		}
		public TerminalNode RPARENT() { return getToken(StafParser.RPARENT, 0); }
		public Keyword_declaration_argumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_declaration_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterKeyword_declaration_arguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitKeyword_declaration_arguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitKeyword_declaration_arguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_declaration_argumentsContext keyword_declaration_arguments() throws RecognitionException {
		Keyword_declaration_argumentsContext _localctx = new Keyword_declaration_argumentsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_keyword_declaration_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(LPARENT);
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(210);
				variable();
				}
				break;
			}
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(213);
				match(COMMA);
				setState(214);
				variable();
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RPARENT) {
				{
				setState(220);
				match(RPARENT);
				}
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

	public static class AssignmentContext extends ParserRuleContext {
		public Variable_referenceContext variable_reference() {
			return getRuleContext(Variable_referenceContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(StafParser.EQUAL, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public TerminalNode NULL() { return getToken(StafParser.NULL, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			variable_reference();
			setState(224);
			match(EQUAL);
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
			case DOUBLE_STRING:
			case MINUS:
			case NOT:
			case LPARENT:
			case LBRACKET:
			case LBRACE:
			case DOLLAR:
			case TRUE:
			case FALSE:
			case INT:
			case FLOAT:
			case IDENTIFIER:
				{
				setState(225);
				object();
				}
				break;
			case NULL:
				{
				setState(226);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class For_statContext extends ParserRuleContext {
		public List<TerminalNode> FOR() { return getTokens(StafParser.FOR); }
		public TerminalNode FOR(int i) {
			return getToken(StafParser.FOR, i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode IN() { return getToken(StafParser.IN, 0); }
		public For_stat_bodyContext for_stat_body() {
			return getRuleContext(For_stat_bodyContext.class,0);
		}
		public TerminalNode END() { return getToken(StafParser.END, 0); }
		public Complex_objectContext complex_object() {
			return getRuleContext(Complex_objectContext.class,0);
		}
		public Variable_referenceContext variable_reference() {
			return getRuleContext(Variable_referenceContext.class,0);
		}
		public Keyword_callContext keyword_call() {
			return getRuleContext(Keyword_callContext.class,0);
		}
		public For_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterFor_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitFor_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitFor_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statContext for_stat() throws RecognitionException {
		For_statContext _localctx = new For_statContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_for_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(FOR);
			setState(230);
			variable();
			setState(231);
			match(IN);
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACKET:
			case LBRACE:
				{
				setState(232);
				complex_object();
				}
				break;
			case DOLLAR:
				{
				setState(233);
				variable_reference();
				}
				break;
			case IDENTIFIER:
				{
				setState(234);
				keyword_call();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(237);
			for_stat_body();
			setState(238);
			match(END);
			setState(239);
			match(FOR);
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

	public static class For_stat_bodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public For_stat_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stat_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterFor_stat_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitFor_stat_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitFor_stat_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stat_bodyContext for_stat_body() throws RecognitionException {
		For_stat_bodyContext _localctx = new For_stat_bodyContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_for_stat_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RUN) | (1L << DOLLAR) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << AND) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(241);
				statement();
				}
				}
				setState(246);
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

	public static class ListLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(StafParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(StafParser.RBRACKET, 0); }
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StafParser.COMMA, i);
		}
		public ListLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterListLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitListLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitListLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListLiteralContext listLiteral() throws RecognitionException {
		ListLiteralContext _localctx = new ListLiteralContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_listLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(LBRACKET);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SINGLE_STRING) | (1L << DOUBLE_STRING) | (1L << MINUS) | (1L << NOT) | (1L << LPARENT) | (1L << LBRACKET) | (1L << LBRACE) | (1L << DOLLAR) | (1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << FLOAT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(248);
				object();
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(249);
					match(COMMA);
					setState(250);
					object();
					}
					}
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(258);
			match(RBRACKET);
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

	public static class DictionaryLiteralContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(StafParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(StafParser.RBRACE, 0); }
		public List<KeyValuePairContext> keyValuePair() {
			return getRuleContexts(KeyValuePairContext.class);
		}
		public KeyValuePairContext keyValuePair(int i) {
			return getRuleContext(KeyValuePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StafParser.COMMA, i);
		}
		public DictionaryLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictionaryLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterDictionaryLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitDictionaryLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitDictionaryLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictionaryLiteralContext dictionaryLiteral() throws RecognitionException {
		DictionaryLiteralContext _localctx = new DictionaryLiteralContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_dictionaryLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(LBRACE);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SINGLE_STRING) | (1L << DOUBLE_STRING) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(261);
				keyValuePair();
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(262);
					match(COMMA);
					setState(263);
					keyValuePair();
					}
					}
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(271);
			match(RBRACE);
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

	public static class KeyValuePairContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(StafParser.COLON, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(StafParser.IDENTIFIER, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public KeyValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterKeyValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitKeyValuePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitKeyValuePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyValuePairContext keyValuePair() throws RecognitionException {
		KeyValuePairContext _localctx = new KeyValuePairContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_keyValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(273);
				match(IDENTIFIER);
				}
				break;
			case SINGLE_STRING:
			case DOUBLE_STRING:
				{
				setState(274);
				string();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(277);
			match(COLON);
			setState(278);
			object();
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

	public static class ObjectContext extends ParserRuleContext {
		public Complex_objectContext complex_object() {
			return getRuleContext(Complex_objectContext.class,0);
		}
		public Scalar_objectContext scalar_object() {
			return getRuleContext(Scalar_objectContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_object);
		try {
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				complex_object();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				scalar_object();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(282);
				expression(0);
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

	public static class Complex_objectContext extends ParserRuleContext {
		public DictionaryLiteralContext dictionaryLiteral() {
			return getRuleContext(DictionaryLiteralContext.class,0);
		}
		public ListLiteralContext listLiteral() {
			return getRuleContext(ListLiteralContext.class,0);
		}
		public Complex_objectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complex_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterComplex_object(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitComplex_object(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitComplex_object(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Complex_objectContext complex_object() throws RecognitionException {
		Complex_objectContext _localctx = new Complex_objectContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_complex_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(285);
				dictionaryLiteral();
				}
				break;
			case LBRACKET:
				{
				setState(286);
				listLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Scalar_objectContext extends ParserRuleContext {
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public Variable_referenceContext variable_reference() {
			return getRuleContext(Variable_referenceContext.class,0);
		}
		public Keyword_callContext keyword_call() {
			return getRuleContext(Keyword_callContext.class,0);
		}
		public Scalar_objectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalar_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterScalar_object(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitScalar_object(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitScalar_object(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Scalar_objectContext scalar_object() throws RecognitionException {
		Scalar_objectContext _localctx = new Scalar_objectContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_scalar_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
			case DOUBLE_STRING:
			case TRUE:
			case FALSE:
			case INT:
			case FLOAT:
				{
				setState(289);
				primitive();
				}
				break;
			case DOLLAR:
				{
				setState(290);
				variable_reference();
				}
				break;
			case IDENTIFIER:
				{
				setState(291);
				keyword_call();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Variable_referenceContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<List_item_accessContext> list_item_access() {
			return getRuleContexts(List_item_accessContext.class);
		}
		public List_item_accessContext list_item_access(int i) {
			return getRuleContext(List_item_accessContext.class,i);
		}
		public List<Dictionary_item_accessContext> dictionary_item_access() {
			return getRuleContexts(Dictionary_item_accessContext.class);
		}
		public Dictionary_item_accessContext dictionary_item_access(int i) {
			return getRuleContext(Dictionary_item_accessContext.class,i);
		}
		public Variable_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterVariable_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitVariable_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitVariable_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_referenceContext variable_reference() throws RecognitionException {
		Variable_referenceContext _localctx = new Variable_referenceContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_variable_reference);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			variable();
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(297);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LBRACKET:
						{
						setState(295);
						list_item_access();
						}
						break;
					case DOT:
						{
						setState(296);
						dictionary_item_access();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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

	public static class PrimitiveContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public PrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterPrimitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitPrimitive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_primitive);
		try {
			setState(305);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
			case DOUBLE_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				string();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				bool();
				}
				break;
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(304);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode DOLLAR() { return getToken(StafParser.DOLLAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(StafParser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(DOLLAR);
			setState(308);
			match(IDENTIFIER);
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

	public static class List_item_accessContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(StafParser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(StafParser.RBRACKET, 0); }
		public List_item_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_item_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterList_item_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitList_item_access(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitList_item_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_item_accessContext list_item_access() throws RecognitionException {
		List_item_accessContext _localctx = new List_item_accessContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_list_item_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(LBRACKET);
			setState(311);
			expression(0);
			setState(312);
			match(RBRACKET);
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

	public static class Dictionary_item_accessContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(StafParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(StafParser.IDENTIFIER, 0); }
		public Dictionary_item_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictionary_item_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterDictionary_item_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitDictionary_item_access(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitDictionary_item_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dictionary_item_accessContext dictionary_item_access() throws RecognitionException {
		Dictionary_item_accessContext _localctx = new Dictionary_item_accessContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_dictionary_item_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(DOT);
			setState(315);
			match(IDENTIFIER);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(StafParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(StafParser.NOT, 0); }
		public TerminalNode LPARENT() { return getToken(StafParser.LPARENT, 0); }
		public TerminalNode RPARENT() { return getToken(StafParser.RPARENT, 0); }
		public Scalar_objectContext scalar_object() {
			return getRuleContext(Scalar_objectContext.class,0);
		}
		public MulopContext mulop() {
			return getRuleContext(MulopContext.class,0);
		}
		public AddopContext addop() {
			return getRuleContext(AddopContext.class,0);
		}
		public BinopContext binop() {
			return getRuleContext(BinopContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitExpression(this);
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
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
				{
				setState(318);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==NOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(319);
				expression(6);
				}
				break;
			case LPARENT:
				{
				setState(320);
				match(LPARENT);
				setState(321);
				expression(0);
				setState(322);
				match(RPARENT);
				}
				break;
			case SINGLE_STRING:
			case DOUBLE_STRING:
			case DOLLAR:
			case TRUE:
			case FALSE:
			case INT:
			case FLOAT:
			case IDENTIFIER:
				{
				setState(324);
				scalar_object();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(341);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(339);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(327);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(328);
						mulop();
						setState(329);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(331);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(332);
						addop();
						setState(333);
						expression(5);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(335);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(336);
						binop();
						setState(337);
						expression(4);
						}
						break;
					}
					} 
				}
				setState(343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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

	public static class MulopContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(StafParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(StafParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(StafParser.MOD, 0); }
		public MulopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterMulop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitMulop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitMulop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulopContext mulop() throws RecognitionException {
		MulopContext _localctx = new MulopContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
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

	public static class AddopContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(StafParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(StafParser.MINUS, 0); }
		public AddopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterAddop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitAddop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitAddop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddopContext addop() throws RecognitionException {
		AddopContext _localctx = new AddopContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_addop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
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

	public static class BinopContext extends ParserRuleContext {
		public TerminalNode AND_OP() { return getToken(StafParser.AND_OP, 0); }
		public TerminalNode OR() { return getToken(StafParser.OR, 0); }
		public List<TerminalNode> EQUAL() { return getTokens(StafParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(StafParser.EQUAL, i);
		}
		public TerminalNode LT() { return getToken(StafParser.LT, 0); }
		public TerminalNode GT() { return getToken(StafParser.GT, 0); }
		public TerminalNode LTE() { return getToken(StafParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(StafParser.GTE, 0); }
		public TerminalNode NE() { return getToken(StafParser.NE, 0); }
		public BinopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterBinop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitBinop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitBinop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinopContext binop() throws RecognitionException {
		BinopContext _localctx = new BinopContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_binop);
		try {
			setState(357);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND_OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				match(AND_OP);
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				match(OR);
				}
				break;
			case EQUAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				match(EQUAL);
				setState(351);
				match(EQUAL);
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 4);
				{
				setState(352);
				match(LT);
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 5);
				{
				setState(353);
				match(GT);
				}
				break;
			case LTE:
				enterOuterAlt(_localctx, 6);
				{
				setState(354);
				match(LTE);
				}
				break;
			case GTE:
				enterOuterAlt(_localctx, 7);
				{
				setState(355);
				match(GTE);
				}
				break;
			case NE:
				enterOuterAlt(_localctx, 8);
				{
				setState(356);
				match(NE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(StafParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(StafParser.FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode SINGLE_STRING() { return getToken(StafParser.SINGLE_STRING, 0); }
		public TerminalNode DOUBLE_STRING() { return getToken(StafParser.DOUBLE_STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			_la = _input.LA(1);
			if ( !(_la==SINGLE_STRING || _la==DOUBLE_STRING) ) {
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

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(StafParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(StafParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 33:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\38\u0170\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\5\2T\n\2\3"+
		"\2\5\2W\n\2\3\2\5\2Z\n\2\3\2\5\2]\n\2\3\2\5\2`\n\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\4\3\4\7\4i\n\4\f\4\16\4l\13\4\3\5\3\5\3\5\3\6\3\6\5\6s\n\6\3\7\3\7"+
		"\7\7w\n\7\f\7\16\7z\13\7\3\b\3\b\7\b~\n\b\f\b\16\b\u0081\13\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\7\n\u0089\n\n\f\n\16\n\u008c\13\n\3\13\3\13\7\13\u0090"+
		"\n\13\f\13\16\13\u0093\13\13\3\f\3\f\3\f\3\f\3\f\3\r\7\r\u009b\n\r\f\r"+
		"\16\r\u009e\13\r\3\16\5\16\u00a1\n\16\3\16\3\16\3\16\3\16\5\16\u00a7\n"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\5\20\u00b3\n\20"+
		"\3\21\3\21\3\21\3\21\7\21\u00b9\n\21\f\21\16\21\u00bc\13\21\5\21\u00be"+
		"\n\21\3\21\3\21\3\22\3\22\3\22\5\22\u00c5\n\22\3\23\3\23\7\23\u00c9\n"+
		"\23\f\23\16\23\u00cc\13\23\3\23\7\23\u00cf\n\23\f\23\16\23\u00d2\13\23"+
		"\3\24\3\24\5\24\u00d6\n\24\3\24\3\24\7\24\u00da\n\24\f\24\16\24\u00dd"+
		"\13\24\3\24\5\24\u00e0\n\24\3\25\3\25\3\25\3\25\5\25\u00e6\n\25\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\5\26\u00ee\n\26\3\26\3\26\3\26\3\26\3\27\7\27"+
		"\u00f5\n\27\f\27\16\27\u00f8\13\27\3\30\3\30\3\30\3\30\7\30\u00fe\n\30"+
		"\f\30\16\30\u0101\13\30\5\30\u0103\n\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\7\31\u010b\n\31\f\31\16\31\u010e\13\31\5\31\u0110\n\31\3\31\3\31\3\32"+
		"\3\32\5\32\u0116\n\32\3\32\3\32\3\32\3\33\3\33\3\33\5\33\u011e\n\33\3"+
		"\34\3\34\5\34\u0122\n\34\3\35\3\35\3\35\5\35\u0127\n\35\3\36\3\36\3\36"+
		"\7\36\u012c\n\36\f\36\16\36\u012f\13\36\3\37\3\37\3\37\5\37\u0134\n\37"+
		"\3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0148\n#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u0156\n#\f#\16#\u0159\13#\3$\3"+
		"$\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0168\n&\3\'\3\'\3(\3(\3)\3)\3)"+
		"\2\3D*\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<"+
		">@BDFHJLNP\2\t\3\2\64\67\4\2\13\13\24\24\3\2\f\16\3\2\n\13\3\2\"#\3\2"+
		"\3\4\3\2 !\2\u017e\2S\3\2\2\2\4c\3\2\2\2\6f\3\2\2\2\bm\3\2\2\2\nr\3\2"+
		"\2\2\ft\3\2\2\2\16{\3\2\2\2\20\u0082\3\2\2\2\22\u008a\3\2\2\2\24\u008d"+
		"\3\2\2\2\26\u0094\3\2\2\2\30\u009c\3\2\2\2\32\u00a0\3\2\2\2\34\u00a8\3"+
		"\2\2\2\36\u00b0\3\2\2\2 \u00b4\3\2\2\2\"\u00c4\3\2\2\2$\u00c6\3\2\2\2"+
		"&\u00d3\3\2\2\2(\u00e1\3\2\2\2*\u00e7\3\2\2\2,\u00f6\3\2\2\2.\u00f9\3"+
		"\2\2\2\60\u0106\3\2\2\2\62\u0115\3\2\2\2\64\u011d\3\2\2\2\66\u0121\3\2"+
		"\2\28\u0126\3\2\2\2:\u0128\3\2\2\2<\u0133\3\2\2\2>\u0135\3\2\2\2@\u0138"+
		"\3\2\2\2B\u013c\3\2\2\2D\u0147\3\2\2\2F\u015a\3\2\2\2H\u015c\3\2\2\2J"+
		"\u0167\3\2\2\2L\u0169\3\2\2\2N\u016b\3\2\2\2P\u016d\3\2\2\2RT\5\4\3\2"+
		"SR\3\2\2\2ST\3\2\2\2TV\3\2\2\2UW\5\6\4\2VU\3\2\2\2VW\3\2\2\2WY\3\2\2\2"+
		"XZ\5\f\7\2YX\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[]\5\24\13\2\\[\3\2\2\2\\]\3"+
		"\2\2\2]_\3\2\2\2^`\5\16\b\2_^\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\7\2\2\3b\3"+
		"\3\2\2\2cd\7(\2\2de\5N(\2e\5\3\2\2\2fj\7)\2\2gi\5\b\5\2hg\3\2\2\2il\3"+
		"\2\2\2jh\3\2\2\2jk\3\2\2\2k\7\3\2\2\2lj\3\2\2\2mn\7*\2\2no\5\n\6\2o\t"+
		"\3\2\2\2ps\5N(\2qs\78\2\2rp\3\2\2\2rq\3\2\2\2s\13\3\2\2\2tx\7+\2\2uw\5"+
		"(\25\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\r\3\2\2\2zx\3\2\2\2{\177"+
		"\7-\2\2|~\5\20\t\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2"+
		"\2\2\u0080\17\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083\5$\23\2\u0083\u0084"+
		"\7\36\2\2\u0084\u0085\5\22\n\2\u0085\u0086\7/\2\2\u0086\21\3\2\2\2\u0087"+
		"\u0089\5\32\16\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3"+
		"\2\2\2\u008a\u008b\3\2\2\2\u008b\23\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\u0091\7,\2\2\u008e\u0090\5\26\f\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2"+
		"\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\25\3\2\2\2\u0093\u0091"+
		"\3\2\2\2\u0094\u0095\5$\23\2\u0095\u0096\5&\24\2\u0096\u0097\5\30\r\2"+
		"\u0097\u0098\5\"\22\2\u0098\27\3\2\2\2\u0099\u009b\5\32\16\2\u009a\u0099"+
		"\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\31\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\t\2\2\2\u00a0\u009f\3\2\2"+
		"\2\u00a0\u00a1\3\2\2\2\u00a1\u00a6\3\2\2\2\u00a2\u00a7\5(\25\2\u00a3\u00a7"+
		"\5\36\20\2\u00a4\u00a7\5*\26\2\u00a5\u00a7\5\34\17\2\u00a6\u00a2\3\2\2"+
		"\2\u00a6\u00a3\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\33"+
		"\3\2\2\2\u00a8\u00a9\7\7\2\2\u00a9\u00aa\7\b\2\2\u00aa\u00ab\7\t\2\2\u00ab"+
		"\u00ac\7\27\2\2\u00ac\u00ad\5D#\2\u00ad\u00ae\7\30\2\2\u00ae\u00af\5\36"+
		"\20\2\u00af\35\3\2\2\2\u00b0\u00b2\5$\23\2\u00b1\u00b3\5 \21\2\u00b2\u00b1"+
		"\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\37\3\2\2\2\u00b4\u00bd\7\27\2\2\u00b5"+
		"\u00ba\5\64\33\2\u00b6\u00b7\7\6\2\2\u00b7\u00b9\5\64\33\2\u00b8\u00b6"+
		"\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00b5\3\2\2\2\u00bd\u00be\3\2"+
		"\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\7\30\2\2\u00c0!\3\2\2\2\u00c1\u00c2"+
		"\7\60\2\2\u00c2\u00c5\5\64\33\2\u00c3\u00c5\7/\2\2\u00c4\u00c1\3\2\2\2"+
		"\u00c4\u00c3\3\2\2\2\u00c5#\3\2\2\2\u00c6\u00d0\78\2\2\u00c7\u00c9\7%"+
		"\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00cf\78"+
		"\2\2\u00ce\u00ca\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1%\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d5\7\27\2\2"+
		"\u00d4\u00d6\5> \2\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00db"+
		"\3\2\2\2\u00d7\u00d8\7\6\2\2\u00d8\u00da\5> \2\u00d9\u00d7\3\2\2\2\u00da"+
		"\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00df\3\2"+
		"\2\2\u00dd\u00db\3\2\2\2\u00de\u00e0\7\30\2\2\u00df\u00de\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\'\3\2\2\2\u00e1\u00e2\5:\36\2\u00e2\u00e5\7\5\2\2"+
		"\u00e3\u00e6\5\64\33\2\u00e4\u00e6\7\63\2\2\u00e5\u00e3\3\2\2\2\u00e5"+
		"\u00e4\3\2\2\2\u00e6)\3\2\2\2\u00e7\u00e8\7\61\2\2\u00e8\u00e9\5> \2\u00e9"+
		"\u00ed\7\'\2\2\u00ea\u00ee\5\66\34\2\u00eb\u00ee\5:\36\2\u00ec\u00ee\5"+
		"\36\20\2\u00ed\u00ea\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef\u00f0\5,\27\2\u00f0\u00f1\7/\2\2\u00f1\u00f2\7\61"+
		"\2\2\u00f2+\3\2\2\2\u00f3\u00f5\5\32\16\2\u00f4\u00f3\3\2\2\2\u00f5\u00f8"+
		"\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7-\3\2\2\2\u00f8"+
		"\u00f6\3\2\2\2\u00f9\u0102\7\31\2\2\u00fa\u00ff\5\64\33\2\u00fb\u00fc"+
		"\7\6\2\2\u00fc\u00fe\5\64\33\2\u00fd\u00fb\3\2\2\2\u00fe\u0101\3\2\2\2"+
		"\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff"+
		"\3\2\2\2\u0102\u00fa\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\u0105\7\32\2\2\u0105/\3\2\2\2\u0106\u010f\7\33\2\2\u0107\u010c\5\62\32"+
		"\2\u0108\u0109\7\6\2\2\u0109\u010b\5\62\32\2\u010a\u0108\3\2\2\2\u010b"+
		"\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u0110\3\2"+
		"\2\2\u010e\u010c\3\2\2\2\u010f\u0107\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111\u0112\7\34\2\2\u0112\61\3\2\2\2\u0113\u0116\78\2"+
		"\2\u0114\u0116\5N(\2\u0115\u0113\3\2\2\2\u0115\u0114\3\2\2\2\u0116\u0117"+
		"\3\2\2\2\u0117\u0118\7\36\2\2\u0118\u0119\5\64\33\2\u0119\63\3\2\2\2\u011a"+
		"\u011e\5\66\34\2\u011b\u011e\58\35\2\u011c\u011e\5D#\2\u011d\u011a\3\2"+
		"\2\2\u011d\u011b\3\2\2\2\u011d\u011c\3\2\2\2\u011e\65\3\2\2\2\u011f\u0122"+
		"\5\60\31\2\u0120\u0122\5.\30\2\u0121\u011f\3\2\2\2\u0121\u0120\3\2\2\2"+
		"\u0122\67\3\2\2\2\u0123\u0127\5<\37\2\u0124\u0127\5:\36\2\u0125\u0127"+
		"\5\36\20\2\u0126\u0123\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0125\3\2\2\2"+
		"\u01279\3\2\2\2\u0128\u012d\5> \2\u0129\u012c\5@!\2\u012a\u012c\5B\"\2"+
		"\u012b\u0129\3\2\2\2\u012b\u012a\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b"+
		"\3\2\2\2\u012d\u012e\3\2\2\2\u012e;\3\2\2\2\u012f\u012d\3\2\2\2\u0130"+
		"\u0134\5N(\2\u0131\u0134\5P)\2\u0132\u0134\5L\'\2\u0133\u0130\3\2\2\2"+
		"\u0133\u0131\3\2\2\2\u0133\u0132\3\2\2\2\u0134=\3\2\2\2\u0135\u0136\7"+
		"\37\2\2\u0136\u0137\78\2\2\u0137?\3\2\2\2\u0138\u0139\7\31\2\2\u0139\u013a"+
		"\5D#\2\u013a\u013b\7\32\2\2\u013bA\3\2\2\2\u013c\u013d\7\35\2\2\u013d"+
		"\u013e\78\2\2\u013eC\3\2\2\2\u013f\u0140\b#\1\2\u0140\u0141\t\3\2\2\u0141"+
		"\u0148\5D#\b\u0142\u0143\7\27\2\2\u0143\u0144\5D#\2\u0144\u0145\7\30\2"+
		"\2\u0145\u0148\3\2\2\2\u0146\u0148\58\35\2\u0147\u013f\3\2\2\2\u0147\u0142"+
		"\3\2\2\2\u0147\u0146\3\2\2\2\u0148\u0157\3\2\2\2\u0149\u014a\f\7\2\2\u014a"+
		"\u014b\5F$\2\u014b\u014c\5D#\b\u014c\u0156\3\2\2\2\u014d\u014e\f\6\2\2"+
		"\u014e\u014f\5H%\2\u014f\u0150\5D#\7\u0150\u0156\3\2\2\2\u0151\u0152\f"+
		"\5\2\2\u0152\u0153\5J&\2\u0153\u0154\5D#\6\u0154\u0156\3\2\2\2\u0155\u0149"+
		"\3\2\2\2\u0155\u014d\3\2\2\2\u0155\u0151\3\2\2\2\u0156\u0159\3\2\2\2\u0157"+
		"\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158E\3\2\2\2\u0159\u0157\3\2\2\2"+
		"\u015a\u015b\t\4\2\2\u015bG\3\2\2\2\u015c\u015d\t\5\2\2\u015dI\3\2\2\2"+
		"\u015e\u0168\7\25\2\2\u015f\u0168\7\26\2\2\u0160\u0161\7\5\2\2\u0161\u0168"+
		"\7\5\2\2\u0162\u0168\7\17\2\2\u0163\u0168\7\20\2\2\u0164\u0168\7\21\2"+
		"\2\u0165\u0168\7\22\2\2\u0166\u0168\7\23\2\2\u0167\u015e\3\2\2\2\u0167"+
		"\u015f\3\2\2\2\u0167\u0160\3\2\2\2\u0167\u0162\3\2\2\2\u0167\u0163\3\2"+
		"\2\2\u0167\u0164\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0166\3\2\2\2\u0168"+
		"K\3\2\2\2\u0169\u016a\t\6\2\2\u016aM\3\2\2\2\u016b\u016c\t\7\2\2\u016c"+
		"O\3\2\2\2\u016d\u016e\t\b\2\2\u016eQ\3\2\2\2+SVY\\_jrx\177\u008a\u0091"+
		"\u009c\u00a0\u00a6\u00b2\u00ba\u00bd\u00c4\u00ca\u00d0\u00d5\u00db\u00df"+
		"\u00e5\u00ed\u00f6\u00ff\u0102\u010c\u010f\u0115\u011d\u0121\u0126\u012b"+
		"\u012d\u0133\u0147\u0155\u0157\u0167";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}