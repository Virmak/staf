// Generated from Staf.g4 by ANTLR 4.8
package com.sparkit.staf;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, SINGLE_STRING=14, DOUBLE_STRING=15, 
		INT=16, FLOAT=17, COMMENT=18, SPACE=19, WS=20, IN=21, TEST_SUITE=22, IMPORTS=23, 
		IMPORT=24, VARS=25, KEYWORDS=26, TEST_CASES=27, BEGIN=28, END=29, RETURN=30, 
		FOR=31, ENDFOR=32, NULL=33, IDENTIFIER=34;
	public static final int
		RULE_staf_file = 0, RULE_suite_name = 1, RULE_imports_section = 2, RULE_import_stat = 3, 
		RULE_import_obj = 4, RULE_vars_section = 5, RULE_test_cases_section = 6, 
		RULE_test_case_declaration = 7, RULE_test_case_body = 8, RULE_keywords_section = 9, 
		RULE_keyword_declaration = 10, RULE_keyword_body = 11, RULE_statement = 12, 
		RULE_keyword_call = 13, RULE_keyword_call_arguments = 14, RULE_keyword_return_stat = 15, 
		RULE_keyword_name = 16, RULE_keyword_declaration_arguments = 17, RULE_assignment = 18, 
		RULE_for_stat = 19, RULE_listLiteral = 20, RULE_dictionaryLiteral = 21, 
		RULE_keyValuePair = 22, RULE_object = 23, RULE_variable_reference = 24, 
		RULE_primitive = 25, RULE_variable = 26, RULE_list_item_access = 27, RULE_dictionary_item_access = 28, 
		RULE_number = 29, RULE_string = 30, RULE_bool = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"staf_file", "suite_name", "imports_section", "import_stat", "import_obj", 
			"vars_section", "test_cases_section", "test_case_declaration", "test_case_body", 
			"keywords_section", "keyword_declaration", "keyword_body", "statement", 
			"keyword_call", "keyword_call_arguments", "keyword_return_stat", "keyword_name", 
			"keyword_declaration_arguments", "assignment", "for_stat", "listLiteral", 
			"dictionaryLiteral", "keyValuePair", "object", "variable_reference", 
			"primitive", "variable", "list_item_access", "dictionary_item_access", 
			"number", "string", "bool"
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
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEST_SUITE) {
				{
				setState(64);
				suite_name();
				}
			}

			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPORTS) {
				{
				setState(67);
				imports_section();
				}
			}

			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARS) {
				{
				setState(70);
				vars_section();
				}
			}

			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORDS) {
				{
				setState(73);
				keywords_section();
				}
			}

			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEST_CASES) {
				{
				setState(76);
				test_cases_section();
				}
			}

			setState(79);
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
			setState(81);
			match(TEST_SUITE);
			setState(82);
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
			setState(84);
			match(IMPORTS);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(85);
				import_stat();
				}
				}
				setState(90);
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
			setState(91);
			match(IMPORT);
			setState(92);
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
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
			case DOUBLE_STRING:
				{
				setState(94);
				string();
				}
				break;
			case IDENTIFIER:
				{
				setState(95);
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
			setState(98);
			match(VARS);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(99);
				assignment();
				}
				}
				setState(104);
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
			setState(105);
			match(TEST_CASES);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(106);
				test_case_declaration();
				}
				}
				setState(111);
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
			setState(112);
			keyword_name();
			setState(113);
			match(T__0);
			setState(114);
			test_case_body();
			setState(115);
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
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << FOR) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(117);
				statement();
				}
				}
				setState(122);
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
			setState(123);
			match(KEYWORDS);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(124);
				keyword_declaration();
				}
				}
				setState(129);
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
			setState(130);
			keyword_name();
			setState(131);
			keyword_declaration_arguments();
			setState(132);
			keyword_body();
			setState(133);
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
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << FOR) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(135);
				statement();
				}
				}
				setState(140);
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
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				assignment();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				keyword_call();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				for_stat();
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
		enterRule(_localctx, 26, RULE_keyword_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			keyword_name();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(147);
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
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
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
		enterRule(_localctx, 28, RULE_keyword_call_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__1);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << SINGLE_STRING) | (1L << DOUBLE_STRING) | (1L << INT) | (1L << FLOAT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(151);
				object();
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(152);
					match(T__2);
					setState(153);
					object();
					}
					}
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(161);
			match(T__3);
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
		enterRule(_localctx, 30, RULE_keyword_return_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(RETURN);
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(164);
				object();
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
		enterRule(_localctx, 32, RULE_keyword_name);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(IDENTIFIER);
			setState(177);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(171);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACE) {
						{
						{
						setState(168);
						match(SPACE);
						}
						}
						setState(173);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(174);
					match(IDENTIFIER);
					}
					} 
				}
				setState(179);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
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
		enterRule(_localctx, 34, RULE_keyword_declaration_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__1);
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(181);
				variable();
				}
				break;
			}
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(184);
				match(T__2);
				setState(185);
				variable();
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(191);
				match(T__3);
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
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public TerminalNode NULL() { return getToken(StafParser.NULL, 0); }
		public List<TerminalNode> WS() { return getTokens(StafParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(StafParser.WS, i);
		}
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
		enterRule(_localctx, 36, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			variable_reference();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(195);
				match(WS);
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(201);
			match(T__4);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(202);
				match(WS);
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__7:
			case T__9:
			case T__11:
			case T__12:
			case SINGLE_STRING:
			case DOUBLE_STRING:
			case INT:
			case FLOAT:
			case IDENTIFIER:
				{
				setState(208);
				object();
				}
				break;
			case NULL:
				{
				setState(209);
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
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public TerminalNode END() { return getToken(StafParser.END, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		enterRule(_localctx, 38, RULE_for_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(FOR);
			setState(213);
			variable();
			setState(214);
			match(IN);
			setState(215);
			object();
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << FOR) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(216);
				statement();
				}
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(222);
			match(END);
			setState(223);
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

	public static class ListLiteralContext extends ParserRuleContext {
		public List<ObjectContext> object() {
			return getRuleContexts(ObjectContext.class);
		}
		public ObjectContext object(int i) {
			return getRuleContext(ObjectContext.class,i);
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
		enterRule(_localctx, 40, RULE_listLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(T__5);
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__7) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << SINGLE_STRING) | (1L << DOUBLE_STRING) | (1L << INT) | (1L << FLOAT) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(226);
				object();
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(227);
					match(T__2);
					setState(228);
					object();
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(236);
			match(T__6);
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
		public List<KeyValuePairContext> keyValuePair() {
			return getRuleContexts(KeyValuePairContext.class);
		}
		public KeyValuePairContext keyValuePair(int i) {
			return getRuleContext(KeyValuePairContext.class,i);
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
		enterRule(_localctx, 42, RULE_dictionaryLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(T__7);
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SINGLE_STRING) | (1L << DOUBLE_STRING) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(239);
				keyValuePair();
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(240);
					match(T__2);
					setState(241);
					keyValuePair();
					}
					}
					setState(246);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(249);
			match(T__8);
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
		enterRule(_localctx, 44, RULE_keyValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(251);
				match(IDENTIFIER);
				}
				break;
			case SINGLE_STRING:
			case DOUBLE_STRING:
				{
				setState(252);
				string();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(255);
			match(T__0);
			setState(256);
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
		enterRule(_localctx, 46, RULE_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__12:
			case SINGLE_STRING:
			case DOUBLE_STRING:
			case INT:
			case FLOAT:
				{
				setState(258);
				primitive();
				}
				break;
			case T__9:
				{
				setState(259);
				variable_reference();
				}
				break;
			case T__7:
				{
				setState(260);
				dictionaryLiteral();
				}
				break;
			case T__5:
				{
				setState(261);
				listLiteral();
				}
				break;
			case IDENTIFIER:
				{
				setState(262);
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
		enterRule(_localctx, 48, RULE_variable_reference);
		try {
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				list_item_access();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(267);
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
		enterRule(_localctx, 50, RULE_primitive);
		try {
			setState(273);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
			case DOUBLE_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				string();
				}
				break;
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
				bool();
				}
				break;
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(272);
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
		enterRule(_localctx, 52, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(T__9);
			setState(276);
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
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
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
		enterRule(_localctx, 54, RULE_list_item_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			variable();
			{
			setState(279);
			match(T__5);
			setState(280);
			object();
			setState(281);
			match(T__6);
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
		public List<TerminalNode> IDENTIFIER() { return getTokens(StafParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(StafParser.IDENTIFIER, i);
		}
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
		enterRule(_localctx, 56, RULE_dictionary_item_access);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			variable();
			setState(286); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(284);
				match(T__10);
				setState(285);
				match(IDENTIFIER);
				}
				}
				setState(288); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__10 );
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
		enterRule(_localctx, 58, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
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
		enterRule(_localctx, 60, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
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
		enterRule(_localctx, 62, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_la = _input.LA(1);
			if ( !(_la==T__11 || _la==T__12) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u012b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\5\2D\n\2\3\2\5\2G\n\2\3\2\5\2J\n\2\3\2\5\2M\n\2\3\2\5\2P\n\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\4\3\4\7\4Y\n\4\f\4\16\4\\\13\4\3\5\3\5\3\5\3\6\3"+
		"\6\5\6c\n\6\3\7\3\7\7\7g\n\7\f\7\16\7j\13\7\3\b\3\b\7\bn\n\b\f\b\16\b"+
		"q\13\b\3\t\3\t\3\t\3\t\3\t\3\n\7\ny\n\n\f\n\16\n|\13\n\3\13\3\13\7\13"+
		"\u0080\n\13\f\13\16\13\u0083\13\13\3\f\3\f\3\f\3\f\3\f\3\r\7\r\u008b\n"+
		"\r\f\r\16\r\u008e\13\r\3\16\3\16\3\16\5\16\u0093\n\16\3\17\3\17\5\17\u0097"+
		"\n\17\3\20\3\20\3\20\3\20\7\20\u009d\n\20\f\20\16\20\u00a0\13\20\5\20"+
		"\u00a2\n\20\3\20\3\20\3\21\3\21\5\21\u00a8\n\21\3\22\3\22\7\22\u00ac\n"+
		"\22\f\22\16\22\u00af\13\22\3\22\7\22\u00b2\n\22\f\22\16\22\u00b5\13\22"+
		"\3\23\3\23\5\23\u00b9\n\23\3\23\3\23\7\23\u00bd\n\23\f\23\16\23\u00c0"+
		"\13\23\3\23\5\23\u00c3\n\23\3\24\3\24\7\24\u00c7\n\24\f\24\16\24\u00ca"+
		"\13\24\3\24\3\24\7\24\u00ce\n\24\f\24\16\24\u00d1\13\24\3\24\3\24\5\24"+
		"\u00d5\n\24\3\25\3\25\3\25\3\25\3\25\7\25\u00dc\n\25\f\25\16\25\u00df"+
		"\13\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\7\26\u00e8\n\26\f\26\16\26\u00eb"+
		"\13\26\5\26\u00ed\n\26\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u00f5\n\27\f"+
		"\27\16\27\u00f8\13\27\5\27\u00fa\n\27\3\27\3\27\3\30\3\30\5\30\u0100\n"+
		"\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\5\31\u010a\n\31\3\32\3\32"+
		"\3\32\5\32\u010f\n\32\3\33\3\33\3\33\5\33\u0114\n\33\3\34\3\34\3\34\3"+
		"\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\6\36\u0121\n\36\r\36\16\36\u0122"+
		"\3\37\3\37\3 \3 \3!\3!\3!\2\2\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@\2\5\3\2\22\23\3\2\20\21\3\2\16\17\2\u0133\2"+
		"C\3\2\2\2\4S\3\2\2\2\6V\3\2\2\2\b]\3\2\2\2\nb\3\2\2\2\fd\3\2\2\2\16k\3"+
		"\2\2\2\20r\3\2\2\2\22z\3\2\2\2\24}\3\2\2\2\26\u0084\3\2\2\2\30\u008c\3"+
		"\2\2\2\32\u0092\3\2\2\2\34\u0094\3\2\2\2\36\u0098\3\2\2\2 \u00a5\3\2\2"+
		"\2\"\u00a9\3\2\2\2$\u00b6\3\2\2\2&\u00c4\3\2\2\2(\u00d6\3\2\2\2*\u00e3"+
		"\3\2\2\2,\u00f0\3\2\2\2.\u00ff\3\2\2\2\60\u0109\3\2\2\2\62\u010e\3\2\2"+
		"\2\64\u0113\3\2\2\2\66\u0115\3\2\2\28\u0118\3\2\2\2:\u011d\3\2\2\2<\u0124"+
		"\3\2\2\2>\u0126\3\2\2\2@\u0128\3\2\2\2BD\5\4\3\2CB\3\2\2\2CD\3\2\2\2D"+
		"F\3\2\2\2EG\5\6\4\2FE\3\2\2\2FG\3\2\2\2GI\3\2\2\2HJ\5\f\7\2IH\3\2\2\2"+
		"IJ\3\2\2\2JL\3\2\2\2KM\5\24\13\2LK\3\2\2\2LM\3\2\2\2MO\3\2\2\2NP\5\16"+
		"\b\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7\2\2\3R\3\3\2\2\2ST\7\30\2\2TU\5"+
		"> \2U\5\3\2\2\2VZ\7\31\2\2WY\5\b\5\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z["+
		"\3\2\2\2[\7\3\2\2\2\\Z\3\2\2\2]^\7\32\2\2^_\5\n\6\2_\t\3\2\2\2`c\5> \2"+
		"ac\7$\2\2b`\3\2\2\2ba\3\2\2\2c\13\3\2\2\2dh\7\33\2\2eg\5&\24\2fe\3\2\2"+
		"\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\r\3\2\2\2jh\3\2\2\2ko\7\35\2\2ln\5\20"+
		"\t\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\17\3\2\2\2qo\3\2\2\2rs\5"+
		"\"\22\2st\7\3\2\2tu\5\22\n\2uv\7\37\2\2v\21\3\2\2\2wy\5\32\16\2xw\3\2"+
		"\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{\23\3\2\2\2|z\3\2\2\2}\u0081\7\34\2"+
		"\2~\u0080\5\26\f\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2"+
		"\u0081\u0082\3\2\2\2\u0082\25\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085"+
		"\5\"\22\2\u0085\u0086\5$\23\2\u0086\u0087\5\30\r\2\u0087\u0088\5 \21\2"+
		"\u0088\27\3\2\2\2\u0089\u008b\5\32\16\2\u008a\u0089\3\2\2\2\u008b\u008e"+
		"\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\31\3\2\2\2\u008e"+
		"\u008c\3\2\2\2\u008f\u0093\5&\24\2\u0090\u0093\5\34\17\2\u0091\u0093\5"+
		"(\25\2\u0092\u008f\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093"+
		"\33\3\2\2\2\u0094\u0096\5\"\22\2\u0095\u0097\5\36\20\2\u0096\u0095\3\2"+
		"\2\2\u0096\u0097\3\2\2\2\u0097\35\3\2\2\2\u0098\u00a1\7\4\2\2\u0099\u009e"+
		"\5\60\31\2\u009a\u009b\7\5\2\2\u009b\u009d\5\60\31\2\u009c\u009a\3\2\2"+
		"\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a2"+
		"\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u0099\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a4\7\6\2\2\u00a4\37\3\2\2\2\u00a5\u00a7\7 \2\2"+
		"\u00a6\u00a8\5\60\31\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8!"+
		"\3\2\2\2\u00a9\u00b3\7$\2\2\u00aa\u00ac\7\25\2\2\u00ab\u00aa\3\2\2\2\u00ac"+
		"\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\3\2"+
		"\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\7$\2\2\u00b1\u00ad\3\2\2\2\u00b2"+
		"\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4#\3\2\2\2"+
		"\u00b5\u00b3\3\2\2\2\u00b6\u00b8\7\4\2\2\u00b7\u00b9\5\66\34\2\u00b8\u00b7"+
		"\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00be\3\2\2\2\u00ba\u00bb\7\5\2\2\u00bb"+
		"\u00bd\5\66\34\2\u00bc\u00ba\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3"+
		"\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1"+
		"\u00c3\7\6\2\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3%\3\2\2\2"+
		"\u00c4\u00c8\5\62\32\2\u00c5\u00c7\7\26\2\2\u00c6\u00c5\3\2\2\2\u00c7"+
		"\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2"+
		"\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cf\7\7\2\2\u00cc\u00ce\7\26\2\2\u00cd"+
		"\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\u00d4\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\5\60\31\2\u00d3"+
		"\u00d5\7#\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\'\3\2\2\2"+
		"\u00d6\u00d7\7!\2\2\u00d7\u00d8\5\66\34\2\u00d8\u00d9\7\27\2\2\u00d9\u00dd"+
		"\5\60\31\2\u00da\u00dc\5\32\16\2\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2"+
		"\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00dd"+
		"\3\2\2\2\u00e0\u00e1\7\37\2\2\u00e1\u00e2\7!\2\2\u00e2)\3\2\2\2\u00e3"+
		"\u00ec\7\b\2\2\u00e4\u00e9\5\60\31\2\u00e5\u00e6\7\5\2\2\u00e6\u00e8\5"+
		"\60\31\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9"+
		"\u00ea\3\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00e4\3\2"+
		"\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7\t\2\2\u00ef"+
		"+\3\2\2\2\u00f0\u00f9\7\n\2\2\u00f1\u00f6\5.\30\2\u00f2\u00f3\7\5\2\2"+
		"\u00f3\u00f5\5.\30\2\u00f4\u00f2\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9"+
		"\u00f1\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\7\13"+
		"\2\2\u00fc-\3\2\2\2\u00fd\u0100\7$\2\2\u00fe\u0100\5> \2\u00ff\u00fd\3"+
		"\2\2\2\u00ff\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102\7\3\2\2\u0102"+
		"\u0103\5\60\31\2\u0103/\3\2\2\2\u0104\u010a\5\64\33\2\u0105\u010a\5\62"+
		"\32\2\u0106\u010a\5,\27\2\u0107\u010a\5*\26\2\u0108\u010a\5\34\17\2\u0109"+
		"\u0104\3\2\2\2\u0109\u0105\3\2\2\2\u0109\u0106\3\2\2\2\u0109\u0107\3\2"+
		"\2\2\u0109\u0108\3\2\2\2\u010a\61\3\2\2\2\u010b\u010f\5\66\34\2\u010c"+
		"\u010f\58\35\2\u010d\u010f\5:\36\2\u010e\u010b\3\2\2\2\u010e\u010c\3\2"+
		"\2\2\u010e\u010d\3\2\2\2\u010f\63\3\2\2\2\u0110\u0114\5> \2\u0111\u0114"+
		"\5@!\2\u0112\u0114\5<\37\2\u0113\u0110\3\2\2\2\u0113\u0111\3\2\2\2\u0113"+
		"\u0112\3\2\2\2\u0114\65\3\2\2\2\u0115\u0116\7\f\2\2\u0116\u0117\7$\2\2"+
		"\u0117\67\3\2\2\2\u0118\u0119\5\66\34\2\u0119\u011a\7\b\2\2\u011a\u011b"+
		"\5\60\31\2\u011b\u011c\7\t\2\2\u011c9\3\2\2\2\u011d\u0120\5\66\34\2\u011e"+
		"\u011f\7\r\2\2\u011f\u0121\7$\2\2\u0120\u011e\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123;\3\2\2\2\u0124\u0125"+
		"\t\2\2\2\u0125=\3\2\2\2\u0126\u0127\t\3\2\2\u0127?\3\2\2\2\u0128\u0129"+
		"\t\4\2\2\u0129A\3\2\2\2%CFILOZbhoz\u0081\u008c\u0092\u0096\u009e\u00a1"+
		"\u00a7\u00ad\u00b3\u00b8\u00be\u00c2\u00c8\u00cf\u00d4\u00dd\u00e9\u00ec"+
		"\u00f6\u00f9\u00ff\u0109\u010e\u0113\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}