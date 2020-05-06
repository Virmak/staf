// Generated from Staf.g4 by ANTLR 4.8
package com.sparkit.interpreter.compiler.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StafParserParser extends Parser {
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
	public static final int
		RULE_staf_file = 0, RULE_suite_name = 1, RULE_imports_section = 2, RULE_import_stat = 3, 
		RULE_import_obj = 4, RULE_vars_section = 5, RULE_test_cases_section = 6, 
		RULE_test_case_declaration = 7, RULE_test_case_body = 8, RULE_keywords_section = 9, 
		RULE_keyword_declaration = 10, RULE_keyword_body = 11, RULE_statement = 12, 
		RULE_keyword_call = 13, RULE_keyword_call_arguments = 14, RULE_keyword_return_stat = 15, 
		RULE_keyword_name = 16, RULE_keyword_declaration_arguments = 17, RULE_assignment = 18, 
		RULE_for_stat = 19, RULE_for_stat_body = 20, RULE_listLiteral = 21, RULE_dictionaryLiteral = 22, 
		RULE_keyValuePair = 23, RULE_object = 24, RULE_variable_reference = 25, 
		RULE_primitive = 26, RULE_variable = 27, RULE_list_item_access = 28, RULE_dictionary_item_access = 29, 
		RULE_number = 30, RULE_string = 31, RULE_bool = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"staf_file", "suite_name", "imports_section", "import_stat", "import_obj", 
			"vars_section", "test_cases_section", "test_case_declaration", "test_case_body", 
			"keywords_section", "keyword_declaration", "keyword_body", "statement", 
			"keyword_call", "keyword_call_arguments", "keyword_return_stat", "keyword_name", 
			"keyword_declaration_arguments", "assignment", "for_stat", "for_stat_body", 
			"listLiteral", "dictionaryLiteral", "keyValuePair", "object", "variable_reference", 
			"primitive", "variable", "list_item_access", "dictionary_item_access", 
			"number", "string", "bool"
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

	@Override
	public String getGrammarFileName() { return "Staf.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public StafParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Staf_fileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(StafParserParser.EOF, 0); }
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
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterStaf_file(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitStaf_file(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitStaf_file(this);
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
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEST_SUITE) {
				{
				setState(66);
				suite_name();
				}
			}

			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPORTS) {
				{
				setState(69);
				imports_section();
				}
			}

			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARS) {
				{
				setState(72);
				vars_section();
				}
			}

			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORDS) {
				{
				setState(75);
				keywords_section();
				}
			}

			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEST_CASES) {
				{
				setState(78);
				test_cases_section();
				}
			}

			setState(81);
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
		public TerminalNode TEST_SUITE() { return getToken(StafParserParser.TEST_SUITE, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public Suite_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterSuite_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitSuite_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitSuite_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Suite_nameContext suite_name() throws RecognitionException {
		Suite_nameContext _localctx = new Suite_nameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_suite_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(TEST_SUITE);
			setState(84);
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
		public TerminalNode IMPORTS() { return getToken(StafParserParser.IMPORTS, 0); }
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
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterImports_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitImports_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitImports_section(this);
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
			setState(86);
			match(IMPORTS);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(87);
				import_stat();
				}
				}
				setState(92);
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
		public TerminalNode IMPORT() { return getToken(StafParserParser.IMPORT, 0); }
		public Import_objContext import_obj() {
			return getRuleContext(Import_objContext.class,0);
		}
		public Import_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterImport_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitImport_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitImport_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_statContext import_stat() throws RecognitionException {
		Import_statContext _localctx = new Import_statContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_import_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(IMPORT);
			setState(94);
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
		public TerminalNode IDENTIFIER() { return getToken(StafParserParser.IDENTIFIER, 0); }
		public Import_objContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_obj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterImport_obj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitImport_obj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitImport_obj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_objContext import_obj() throws RecognitionException {
		Import_objContext _localctx = new Import_objContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_import_obj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
			case DOUBLE_STRING:
				{
				setState(96);
				string();
				}
				break;
			case IDENTIFIER:
				{
				setState(97);
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
		public TerminalNode VARS() { return getToken(StafParserParser.VARS, 0); }
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
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterVars_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitVars_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitVars_section(this);
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
			setState(100);
			match(VARS);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOLLAR) {
				{
				{
				setState(101);
				assignment();
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

	public static class Test_cases_sectionContext extends ParserRuleContext {
		public TerminalNode TEST_CASES() { return getToken(StafParserParser.TEST_CASES, 0); }
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
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterTest_cases_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitTest_cases_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitTest_cases_section(this);
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
			setState(107);
			match(TEST_CASES);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(108);
				test_case_declaration();
				}
				}
				setState(113);
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
		public TerminalNode COLON() { return getToken(StafParserParser.COLON, 0); }
		public Test_case_bodyContext test_case_body() {
			return getRuleContext(Test_case_bodyContext.class,0);
		}
		public TerminalNode END() { return getToken(StafParserParser.END, 0); }
		public Test_case_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_case_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterTest_case_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitTest_case_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitTest_case_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_case_declarationContext test_case_declaration() throws RecognitionException {
		Test_case_declarationContext _localctx = new Test_case_declarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_test_case_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			keyword_name();
			setState(115);
			match(COLON);
			setState(116);
			test_case_body();
			setState(117);
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
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterTest_case_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitTest_case_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitTest_case_body(this);
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
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOLLAR) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(119);
				statement();
				}
				}
				setState(124);
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
		public TerminalNode KEYWORDS() { return getToken(StafParserParser.KEYWORDS, 0); }
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
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterKeywords_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitKeywords_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitKeywords_section(this);
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
			setState(125);
			match(KEYWORDS);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(126);
				keyword_declaration();
				}
				}
				setState(131);
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
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterKeyword_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitKeyword_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitKeyword_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_declarationContext keyword_declaration() throws RecognitionException {
		Keyword_declarationContext _localctx = new Keyword_declarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_keyword_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			keyword_name();
			setState(133);
			keyword_declaration_arguments();
			setState(134);
			keyword_body();
			setState(135);
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
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterKeyword_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitKeyword_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitKeyword_body(this);
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
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOLLAR) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(137);
				statement();
				}
				}
				setState(142);
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
		public TerminalNode GIVEN() { return getToken(StafParserParser.GIVEN, 0); }
		public TerminalNode WHEN() { return getToken(StafParserParser.WHEN, 0); }
		public TerminalNode THEN() { return getToken(StafParserParser.THEN, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitStatement(this);
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
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GIVEN) | (1L << WHEN) | (1L << THEN))) != 0)) {
				{
				setState(143);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GIVEN) | (1L << WHEN) | (1L << THEN))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
				{
				setState(146);
				assignment();
				}
				break;
			case IDENTIFIER:
				{
				setState(147);
				keyword_call();
				}
				break;
			case FOR:
				{
				setState(148);
				for_stat();
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
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterKeyword_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitKeyword_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitKeyword_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_callContext keyword_call() throws RecognitionException {
		Keyword_callContext _localctx = new Keyword_callContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_keyword_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			keyword_name();
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPARENT) {
				{
				setState(152);
				keyword_call_arguments();
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

	public static class Keyword_call_argumentsContext extends ParserRuleContext {
		public TerminalNode LPARENT() { return getToken(StafParserParser.LPARENT, 0); }
		public TerminalNode RPARENT() { return getToken(StafParserParser.RPARENT, 0); }
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StafParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StafParserParser.COMMA, i);
		}
		public Keyword_call_argumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_call_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterKeyword_call_arguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitKeyword_call_arguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitKeyword_call_arguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_call_argumentsContext keyword_call_arguments() throws RecognitionException {
		Keyword_call_argumentsContext _localctx = new Keyword_call_argumentsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_keyword_call_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(LPARENT);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SINGLE_STRING) | (1L << DOUBLE_STRING) | (1L << LBRACKET) | (1L << LBRACE) | (1L << DOLLAR) | (1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << FLOAT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(156);
				object();
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(157);
					match(COMMA);
					setState(158);
					object();
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(166);
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
		public TerminalNode RETURN() { return getToken(StafParserParser.RETURN, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public TerminalNode NL() { return getToken(StafParserParser.NL, 0); }
		public Keyword_return_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_return_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterKeyword_return_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitKeyword_return_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitKeyword_return_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_return_statContext keyword_return_stat() throws RecognitionException {
		Keyword_return_statContext _localctx = new Keyword_return_statContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_keyword_return_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(RETURN);
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
			case DOUBLE_STRING:
			case LBRACKET:
			case LBRACE:
			case DOLLAR:
			case TRUE:
			case FALSE:
			case INT:
			case FLOAT:
			case IDENTIFIER:
				{
				setState(169);
				object();
				}
				break;
			case NL:
				{
				setState(170);
				match(NL);
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

	public static class Keyword_nameContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(StafParserParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(StafParserParser.IDENTIFIER, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(StafParserParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(StafParserParser.SPACE, i);
		}
		public Keyword_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterKeyword_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitKeyword_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitKeyword_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_nameContext keyword_name() throws RecognitionException {
		Keyword_nameContext _localctx = new Keyword_nameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_keyword_name);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(IDENTIFIER);
			setState(183);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACE) {
						{
						{
						setState(174);
						match(SPACE);
						}
						}
						setState(179);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(180);
					match(IDENTIFIER);
					}
					} 
				}
				setState(185);
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
		public TerminalNode LPARENT() { return getToken(StafParserParser.LPARENT, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StafParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StafParserParser.COMMA, i);
		}
		public TerminalNode RPARENT() { return getToken(StafParserParser.RPARENT, 0); }
		public Keyword_declaration_argumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_declaration_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterKeyword_declaration_arguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitKeyword_declaration_arguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitKeyword_declaration_arguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_declaration_argumentsContext keyword_declaration_arguments() throws RecognitionException {
		Keyword_declaration_argumentsContext _localctx = new Keyword_declaration_argumentsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_keyword_declaration_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(LPARENT);
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(187);
				variable();
				}
				break;
			}
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(190);
				match(COMMA);
				setState(191);
				variable();
				}
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RPARENT) {
				{
				setState(197);
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
		public TerminalNode EQUAL() { return getToken(StafParserParser.EQUAL, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public TerminalNode NULL() { return getToken(StafParserParser.NULL, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			variable_reference();
			setState(201);
			match(EQUAL);
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
			case DOUBLE_STRING:
			case LBRACKET:
			case LBRACE:
			case DOLLAR:
			case TRUE:
			case FALSE:
			case INT:
			case FLOAT:
			case IDENTIFIER:
				{
				setState(202);
				object();
				}
				break;
			case NULL:
				{
				setState(203);
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
		public List<TerminalNode> FOR() { return getTokens(StafParserParser.FOR); }
		public TerminalNode FOR(int i) {
			return getToken(StafParserParser.FOR, i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode IN() { return getToken(StafParserParser.IN, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public For_stat_bodyContext for_stat_body() {
			return getRuleContext(For_stat_bodyContext.class,0);
		}
		public TerminalNode END() { return getToken(StafParserParser.END, 0); }
		public For_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterFor_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitFor_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitFor_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statContext for_stat() throws RecognitionException {
		For_statContext _localctx = new For_statContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_for_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(FOR);
			setState(207);
			variable();
			setState(208);
			match(IN);
			setState(209);
			object();
			setState(210);
			for_stat_body();
			setState(211);
			match(END);
			setState(212);
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
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterFor_stat_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitFor_stat_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitFor_stat_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stat_bodyContext for_stat_body() throws RecognitionException {
		For_stat_bodyContext _localctx = new For_stat_bodyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_for_stat_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOLLAR) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(214);
				statement();
				}
				}
				setState(219);
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
		public TerminalNode LBRACKET() { return getToken(StafParserParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(StafParserParser.RBRACKET, 0); }
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StafParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StafParserParser.COMMA, i);
		}
		public ListLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterListLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitListLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitListLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListLiteralContext listLiteral() throws RecognitionException {
		ListLiteralContext _localctx = new ListLiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_listLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(LBRACKET);
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SINGLE_STRING) | (1L << DOUBLE_STRING) | (1L << LBRACKET) | (1L << LBRACE) | (1L << DOLLAR) | (1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << FLOAT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(221);
				object();
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(222);
					match(COMMA);
					setState(223);
					object();
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(231);
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
		public TerminalNode LBRACE() { return getToken(StafParserParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(StafParserParser.RBRACE, 0); }
		public List<KeyValuePairContext> keyValuePair() {
			return getRuleContexts(KeyValuePairContext.class);
		}
		public KeyValuePairContext keyValuePair(int i) {
			return getRuleContext(KeyValuePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(StafParserParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(StafParserParser.COMMA, i);
		}
		public DictionaryLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictionaryLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterDictionaryLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitDictionaryLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitDictionaryLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictionaryLiteralContext dictionaryLiteral() throws RecognitionException {
		DictionaryLiteralContext _localctx = new DictionaryLiteralContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_dictionaryLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(LBRACE);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SINGLE_STRING) | (1L << DOUBLE_STRING) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(234);
				keyValuePair();
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(235);
					match(COMMA);
					setState(236);
					keyValuePair();
					}
					}
					setState(241);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(244);
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
		public TerminalNode COLON() { return getToken(StafParserParser.COLON, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(StafParserParser.IDENTIFIER, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public KeyValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterKeyValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitKeyValuePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitKeyValuePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyValuePairContext keyValuePair() throws RecognitionException {
		KeyValuePairContext _localctx = new KeyValuePairContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_keyValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(246);
				match(IDENTIFIER);
				}
				break;
			case SINGLE_STRING:
			case DOUBLE_STRING:
				{
				setState(247);
				string();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(250);
			match(COLON);
			setState(251);
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
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public Variable_referenceContext variable_reference() {
			return getRuleContext(Variable_referenceContext.class,0);
		}
		public DictionaryLiteralContext dictionaryLiteral() {
			return getRuleContext(DictionaryLiteralContext.class,0);
		}
		public ListLiteralContext listLiteral() {
			return getRuleContext(ListLiteralContext.class,0);
		}
		public Keyword_callContext keyword_call() {
			return getRuleContext(Keyword_callContext.class,0);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
			case DOUBLE_STRING:
			case TRUE:
			case FALSE:
			case INT:
			case FLOAT:
				{
				setState(253);
				primitive();
				}
				break;
			case DOLLAR:
				{
				setState(254);
				variable_reference();
				}
				break;
			case LBRACE:
				{
				setState(255);
				dictionaryLiteral();
				}
				break;
			case LBRACKET:
				{
				setState(256);
				listLiteral();
				}
				break;
			case IDENTIFIER:
				{
				setState(257);
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
		public List_item_accessContext list_item_access() {
			return getRuleContext(List_item_accessContext.class,0);
		}
		public Dictionary_item_accessContext dictionary_item_access() {
			return getRuleContext(Dictionary_item_accessContext.class,0);
		}
		public Variable_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterVariable_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitVariable_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitVariable_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_referenceContext variable_reference() throws RecognitionException {
		Variable_referenceContext _localctx = new Variable_referenceContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_variable_reference);
		try {
			setState(263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				list_item_access();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(262);
				dictionary_item_access();
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
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterPrimitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitPrimitive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_primitive);
		try {
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
			case DOUBLE_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				string();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				bool();
				}
				break;
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(267);
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
		public TerminalNode DOLLAR() { return getToken(StafParserParser.DOLLAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(StafParserParser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(DOLLAR);
			setState(271);
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(StafParserParser.LBRACKET, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(StafParserParser.RBRACKET, 0); }
		public List_item_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_item_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterList_item_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitList_item_access(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitList_item_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_item_accessContext list_item_access() throws RecognitionException {
		List_item_accessContext _localctx = new List_item_accessContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_list_item_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			variable();
			{
			setState(274);
			match(LBRACKET);
			setState(275);
			object();
			setState(276);
			match(RBRACKET);
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

	public static class Dictionary_item_accessContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(StafParserParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(StafParserParser.DOT, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(StafParserParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(StafParserParser.IDENTIFIER, i);
		}
		public Dictionary_item_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictionary_item_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterDictionary_item_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitDictionary_item_access(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitDictionary_item_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dictionary_item_accessContext dictionary_item_access() throws RecognitionException {
		Dictionary_item_accessContext _localctx = new Dictionary_item_accessContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_dictionary_item_access);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			variable();
			setState(281); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(279);
				match(DOT);
				setState(280);
				match(IDENTIFIER);
				}
				}
				setState(283); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DOT );
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
		public TerminalNode INT() { return getToken(StafParserParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(StafParserParser.FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
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
		public TerminalNode SINGLE_STRING() { return getToken(StafParserParser.SINGLE_STRING, 0); }
		public TerminalNode DOUBLE_STRING() { return getToken(StafParserParser.DOUBLE_STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
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
		public TerminalNode TRUE() { return getToken(StafParserParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(StafParserParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafParserListener ) ((StafParserListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafParserVisitor ) return ((StafParserVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u0126\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\5\2F\n\2\3\2\5\2I\n\2\3\2\5\2L\n\2\3\2\5\2O\n\2\3\2\5"+
		"\2R\n\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\7\4[\n\4\f\4\16\4^\13\4\3\5\3\5\3"+
		"\5\3\6\3\6\5\6e\n\6\3\7\3\7\7\7i\n\7\f\7\16\7l\13\7\3\b\3\b\7\bp\n\b\f"+
		"\b\16\bs\13\b\3\t\3\t\3\t\3\t\3\t\3\n\7\n{\n\n\f\n\16\n~\13\n\3\13\3\13"+
		"\7\13\u0082\n\13\f\13\16\13\u0085\13\13\3\f\3\f\3\f\3\f\3\f\3\r\7\r\u008d"+
		"\n\r\f\r\16\r\u0090\13\r\3\16\5\16\u0093\n\16\3\16\3\16\3\16\5\16\u0098"+
		"\n\16\3\17\3\17\5\17\u009c\n\17\3\20\3\20\3\20\3\20\7\20\u00a2\n\20\f"+
		"\20\16\20\u00a5\13\20\5\20\u00a7\n\20\3\20\3\20\3\21\3\21\3\21\5\21\u00ae"+
		"\n\21\3\22\3\22\7\22\u00b2\n\22\f\22\16\22\u00b5\13\22\3\22\7\22\u00b8"+
		"\n\22\f\22\16\22\u00bb\13\22\3\23\3\23\5\23\u00bf\n\23\3\23\3\23\7\23"+
		"\u00c3\n\23\f\23\16\23\u00c6\13\23\3\23\5\23\u00c9\n\23\3\24\3\24\3\24"+
		"\3\24\5\24\u00cf\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\7\26"+
		"\u00da\n\26\f\26\16\26\u00dd\13\26\3\27\3\27\3\27\3\27\7\27\u00e3\n\27"+
		"\f\27\16\27\u00e6\13\27\5\27\u00e8\n\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\7\30\u00f0\n\30\f\30\16\30\u00f3\13\30\5\30\u00f5\n\30\3\30\3\30\3\31"+
		"\3\31\5\31\u00fb\n\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u0105"+
		"\n\32\3\33\3\33\3\33\5\33\u010a\n\33\3\34\3\34\3\34\5\34\u010f\n\34\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\6\37\u011c\n\37"+
		"\r\37\16\37\u011d\3 \3 \3!\3!\3\"\3\"\3\"\2\2#\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2\6\3\2$&\3\2\22\23\3\2\3\4"+
		"\3\2\20\21\2\u012c\2E\3\2\2\2\4U\3\2\2\2\6X\3\2\2\2\b_\3\2\2\2\nd\3\2"+
		"\2\2\ff\3\2\2\2\16m\3\2\2\2\20t\3\2\2\2\22|\3\2\2\2\24\177\3\2\2\2\26"+
		"\u0086\3\2\2\2\30\u008e\3\2\2\2\32\u0092\3\2\2\2\34\u0099\3\2\2\2\36\u009d"+
		"\3\2\2\2 \u00aa\3\2\2\2\"\u00af\3\2\2\2$\u00bc\3\2\2\2&\u00ca\3\2\2\2"+
		"(\u00d0\3\2\2\2*\u00db\3\2\2\2,\u00de\3\2\2\2.\u00eb\3\2\2\2\60\u00fa"+
		"\3\2\2\2\62\u0104\3\2\2\2\64\u0109\3\2\2\2\66\u010e\3\2\2\28\u0110\3\2"+
		"\2\2:\u0113\3\2\2\2<\u0118\3\2\2\2>\u011f\3\2\2\2@\u0121\3\2\2\2B\u0123"+
		"\3\2\2\2DF\5\4\3\2ED\3\2\2\2EF\3\2\2\2FH\3\2\2\2GI\5\6\4\2HG\3\2\2\2H"+
		"I\3\2\2\2IK\3\2\2\2JL\5\f\7\2KJ\3\2\2\2KL\3\2\2\2LN\3\2\2\2MO\5\24\13"+
		"\2NM\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PR\5\16\b\2QP\3\2\2\2QR\3\2\2\2RS\3\2"+
		"\2\2ST\7\2\2\3T\3\3\2\2\2UV\7\30\2\2VW\5@!\2W\5\3\2\2\2X\\\7\31\2\2Y["+
		"\5\b\5\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\7\3\2\2\2^\\\3\2\2"+
		"\2_`\7\32\2\2`a\5\n\6\2a\t\3\2\2\2be\5@!\2ce\7\'\2\2db\3\2\2\2dc\3\2\2"+
		"\2e\13\3\2\2\2fj\7\33\2\2gi\5&\24\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3"+
		"\2\2\2k\r\3\2\2\2lj\3\2\2\2mq\7\35\2\2np\5\20\t\2on\3\2\2\2ps\3\2\2\2"+
		"qo\3\2\2\2qr\3\2\2\2r\17\3\2\2\2sq\3\2\2\2tu\5\"\22\2uv\7\16\2\2vw\5\22"+
		"\n\2wx\7\37\2\2x\21\3\2\2\2y{\5\32\16\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2"+
		"|}\3\2\2\2}\23\3\2\2\2~|\3\2\2\2\177\u0083\7\34\2\2\u0080\u0082\5\26\f"+
		"\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\25\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\5\"\22\2\u0087"+
		"\u0088\5$\23\2\u0088\u0089\5\30\r\2\u0089\u008a\5 \21\2\u008a\27\3\2\2"+
		"\2\u008b\u008d\5\32\16\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\31\3\2\2\2\u0090\u008e\3\2\2"+
		"\2\u0091\u0093\t\2\2\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0097"+
		"\3\2\2\2\u0094\u0098\5&\24\2\u0095\u0098\5\34\17\2\u0096\u0098\5(\25\2"+
		"\u0097\u0094\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098\33"+
		"\3\2\2\2\u0099\u009b\5\"\22\2\u009a\u009c\5\36\20\2\u009b\u009a\3\2\2"+
		"\2\u009b\u009c\3\2\2\2\u009c\35\3\2\2\2\u009d\u00a6\7\7\2\2\u009e\u00a3"+
		"\5\62\32\2\u009f\u00a0\7\6\2\2\u00a0\u00a2\5\62\32\2\u00a1\u009f\3\2\2"+
		"\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a7"+
		"\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u009e\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\7\b\2\2\u00a9\37\3\2\2\2\u00aa\u00ad\7 \2\2"+
		"\u00ab\u00ae\5\62\32\2\u00ac\u00ae\7\26\2\2\u00ad\u00ab\3\2\2\2\u00ad"+
		"\u00ac\3\2\2\2\u00ae!\3\2\2\2\u00af\u00b9\7\'\2\2\u00b0\u00b2\7\25\2\2"+
		"\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4"+
		"\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b8\7\'\2\2\u00b7"+
		"\u00b3\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba#\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00be\7\7\2\2\u00bd\u00bf"+
		"\58\35\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c4\3\2\2\2\u00c0"+
		"\u00c1\7\6\2\2\u00c1\u00c3\58\35\2\u00c2\u00c0\3\2\2\2\u00c3\u00c6\3\2"+
		"\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c7\u00c9\7\b\2\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9%\3\2\2\2\u00ca\u00cb\5\64\33\2\u00cb\u00ce\7\5\2\2\u00cc\u00cf"+
		"\5\62\32\2\u00cd\u00cf\7#\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2"+
		"\u00cf\'\3\2\2\2\u00d0\u00d1\7!\2\2\u00d1\u00d2\58\35\2\u00d2\u00d3\7"+
		"\27\2\2\u00d3\u00d4\5\62\32\2\u00d4\u00d5\5*\26\2\u00d5\u00d6\7\37\2\2"+
		"\u00d6\u00d7\7!\2\2\u00d7)\3\2\2\2\u00d8\u00da\5\32\16\2\u00d9\u00d8\3"+
		"\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"+\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e7\7\t\2\2\u00df\u00e4\5\62\32"+
		"\2\u00e0\u00e1\7\6\2\2\u00e1\u00e3\5\62\32\2\u00e2\u00e0\3\2\2\2\u00e3"+
		"\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e8\3\2"+
		"\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00df\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\u00ea\7\n\2\2\u00ea-\3\2\2\2\u00eb\u00f4\7\13\2\2"+
		"\u00ec\u00f1\5\60\31\2\u00ed\u00ee\7\6\2\2\u00ee\u00f0\5\60\31\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00ec\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\7\f\2\2\u00f7/\3\2\2\2"+
		"\u00f8\u00fb\7\'\2\2\u00f9\u00fb\5@!\2\u00fa\u00f8\3\2\2\2\u00fa\u00f9"+
		"\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\7\16\2\2\u00fd\u00fe\5\62\32"+
		"\2\u00fe\61\3\2\2\2\u00ff\u0105\5\66\34\2\u0100\u0105\5\64\33\2\u0101"+
		"\u0105\5.\30\2\u0102\u0105\5,\27\2\u0103\u0105\5\34\17\2\u0104\u00ff\3"+
		"\2\2\2\u0104\u0100\3\2\2\2\u0104\u0101\3\2\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0103\3\2\2\2\u0105\63\3\2\2\2\u0106\u010a\58\35\2\u0107\u010a\5:\36"+
		"\2\u0108\u010a\5<\37\2\u0109\u0106\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u0108"+
		"\3\2\2\2\u010a\65\3\2\2\2\u010b\u010f\5@!\2\u010c\u010f\5B\"\2\u010d\u010f"+
		"\5> \2\u010e\u010b\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010d\3\2\2\2\u010f"+
		"\67\3\2\2\2\u0110\u0111\7\17\2\2\u0111\u0112\7\'\2\2\u01129\3\2\2\2\u0113"+
		"\u0114\58\35\2\u0114\u0115\7\t\2\2\u0115\u0116\5\62\32\2\u0116\u0117\7"+
		"\n\2\2\u0117;\3\2\2\2\u0118\u011b\58\35\2\u0119\u011a\7\r\2\2\u011a\u011c"+
		"\7\'\2\2\u011b\u0119\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e=\3\2\2\2\u011f\u0120\t\3\2\2\u0120?\3\2\2\2\u0121"+
		"\u0122\t\4\2\2\u0122A\3\2\2\2\u0123\u0124\t\5\2\2\u0124C\3\2\2\2$EHKN"+
		"Q\\djq|\u0083\u008e\u0092\u0097\u009b\u00a3\u00a6\u00ad\u00b3\u00b9\u00be"+
		"\u00c4\u00c8\u00ce\u00db\u00e4\u00e7\u00f1\u00f4\u00fa\u0104\u0109\u010e"+
		"\u011d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}