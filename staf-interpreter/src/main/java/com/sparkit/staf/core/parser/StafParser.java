// Generated from Staf.g4 by ANTLR 4.8
package com.sparkit.staf.core.parser;
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
		T__0=1, T__1=2, SINGLE_STRING=3, DOUBLE_STRING=4, EQUAL=5, COMMA=6, RUN=7, 
		KEYWORD=8, IF=9, ELSE=10, PLUS=11, MINUS=12, MUL=13, DIV=14, MOD=15, LT=16, 
		GT=17, LTE=18, GTE=19, NE=20, NOT=21, AND_OP=22, OR=23, LPARENT=24, RPARENT=25, 
		LBRACKET=26, RBRACKET=27, LBRACE=28, RBRACE=29, DOT=30, COLON=31, DOLLAR=32, 
		TRUE=33, FALSE=34, INT=35, FLOAT=36, COMMENT=37, SPACE=38, NL=39, TEST_SUITE=40, 
		IMPORTS=41, IMPORT=42, VARS=43, KEYWORDS=44, TEST_CASES=45, BEGIN=46, 
		END=47, RETURN=48, FOR=49, ENDFOR=50, NULL=51, GIVEN=52, WHEN=53, THEN=54, 
		IGNORE=55, EXIT=56, LOOP=57, IDENTIFIER=58;
	public static final int
		RULE_staf_file = 0, RULE_suite_name = 1, RULE_documentation = 2, RULE_imports_section = 3, 
		RULE_import_stat = 4, RULE_import_obj = 5, RULE_vars_section = 6, RULE_test_cases_section = 7, 
		RULE_test_case_declaration = 8, RULE_test_case_before = 9, RULE_test_case_body = 10, 
		RULE_test_case_priority = 11, RULE_keywords_section = 12, RULE_keyword_declaration = 13, 
		RULE_keyword_body = 14, RULE_statement = 15, RULE_run_keyword_if = 16, 
		RULE_run_keyword_else = 17, RULE_exit_loop = 18, RULE_exit_loop_condition = 19, 
		RULE_keyword_call = 20, RULE_keyword_call_arguments = 21, RULE_keyword_return_stat = 22, 
		RULE_keyword_name = 23, RULE_reserved_keyword = 24, RULE_keyword_declaration_arguments = 25, 
		RULE_assignment = 26, RULE_for_stat = 27, RULE_for_stat_body = 28, RULE_listLiteral = 29, 
		RULE_dictionaryLiteral = 30, RULE_keyValuePair = 31, RULE_object = 32, 
		RULE_complex_object = 33, RULE_scalar_object = 34, RULE_variable_reference = 35, 
		RULE_primitive = 36, RULE_variable = 37, RULE_dot_item_access = 38, RULE_brackets_item_access = 39, 
		RULE_expression = 40, RULE_mulop = 41, RULE_addop = 42, RULE_binop = 43, 
		RULE_number = 44, RULE_string = 45, RULE_bool = 46;
	private static String[] makeRuleNames() {
		return new String[] {
			"staf_file", "suite_name", "documentation", "imports_section", "import_stat", 
			"import_obj", "vars_section", "test_cases_section", "test_case_declaration", 
			"test_case_before", "test_case_body", "test_case_priority", "keywords_section", 
			"keyword_declaration", "keyword_body", "statement", "run_keyword_if", 
			"run_keyword_else", "exit_loop", "exit_loop_condition", "keyword_call", 
			"keyword_call_arguments", "keyword_return_stat", "keyword_name", "reserved_keyword", 
			"keyword_declaration_arguments", "assignment", "for_stat", "for_stat_body", 
			"listLiteral", "dictionaryLiteral", "keyValuePair", "object", "complex_object", 
			"scalar_object", "variable_reference", "primitive", "variable", "dot_item_access", 
			"brackets_item_access", "expression", "mulop", "addop", "binop", "number", 
			"string", "bool"
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
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEST_SUITE) {
				{
				setState(94);
				suite_name();
				}
			}

			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPORTS) {
				{
				setState(97);
				imports_section();
				}
			}

			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARS) {
				{
				setState(100);
				vars_section();
				}
			}

			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORDS) {
				{
				setState(103);
				keywords_section();
				}
			}

			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEST_CASES) {
				{
				setState(106);
				test_cases_section();
				}
			}

			setState(109);
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
		public DocumentationContext documentation() {
			return getRuleContext(DocumentationContext.class,0);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(TEST_SUITE);
			setState(112);
			string();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(113);
				documentation();
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

	public static class DocumentationContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(StafParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(StafParser.RBRACKET, 0); }
		public DocumentationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documentation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterDocumentation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitDocumentation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitDocumentation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentationContext documentation() throws RecognitionException {
		DocumentationContext _localctx = new DocumentationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_documentation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(LBRACKET);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=1 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(117);
					matchWildcard();
					}
					} 
				}
				setState(122);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(123);
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
		enterRule(_localctx, 6, RULE_imports_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(IMPORTS);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(126);
				import_stat();
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
		enterRule(_localctx, 8, RULE_import_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(IMPORT);
			setState(133);
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
		enterRule(_localctx, 10, RULE_import_obj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
			case DOUBLE_STRING:
				{
				setState(135);
				string();
				}
				break;
			case IDENTIFIER:
				{
				setState(136);
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
		enterRule(_localctx, 12, RULE_vars_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(VARS);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOLLAR) {
				{
				{
				setState(140);
				assignment();
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
		enterRule(_localctx, 14, RULE_test_cases_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(TEST_CASES);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << INT) | (1L << IMPORT) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << IGNORE) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(147);
				test_case_declaration();
				}
				}
				setState(152);
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
		public List<Test_case_beforeContext> test_case_before() {
			return getRuleContexts(Test_case_beforeContext.class);
		}
		public Test_case_beforeContext test_case_before(int i) {
			return getRuleContext(Test_case_beforeContext.class,i);
		}
		public Test_case_priorityContext test_case_priority() {
			return getRuleContext(Test_case_priorityContext.class,0);
		}
		public DocumentationContext documentation() {
			return getRuleContext(DocumentationContext.class,0);
		}
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
		enterRule(_localctx, 16, RULE_test_case_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(153);
				test_case_before();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT || _la==IGNORE) {
				{
				setState(159);
				test_case_priority();
				}
			}

			setState(162);
			keyword_name();
			setState(163);
			match(COLON);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(164);
				documentation();
				}
			}

			setState(167);
			test_case_body();
			setState(168);
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

	public static class Test_case_beforeContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(StafParser.LBRACKET, 0); }
		public Keyword_nameContext keyword_name() {
			return getRuleContext(Keyword_nameContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(StafParser.RBRACKET, 0); }
		public Test_case_beforeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_case_before; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterTest_case_before(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitTest_case_before(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitTest_case_before(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_case_beforeContext test_case_before() throws RecognitionException {
		Test_case_beforeContext _localctx = new Test_case_beforeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_test_case_before);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(T__0);
			setState(171);
			match(LBRACKET);
			setState(172);
			keyword_name();
			setState(173);
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

	public static class Test_case_bodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> GIVEN() { return getTokens(StafParser.GIVEN); }
		public TerminalNode GIVEN(int i) {
			return getToken(StafParser.GIVEN, i);
		}
		public List<TerminalNode> WHEN() { return getTokens(StafParser.WHEN); }
		public TerminalNode WHEN(int i) {
			return getToken(StafParser.WHEN, i);
		}
		public List<TerminalNode> THEN() { return getTokens(StafParser.THEN); }
		public TerminalNode THEN(int i) {
			return getToken(StafParser.THEN, i);
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
		enterRule(_localctx, 20, RULE_test_case_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << RUN) | (1L << DOLLAR) | (1L << IMPORT) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << EXIT) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(176);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(175);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					break;
				}
				setState(178);
				statement();
				}
				}
				setState(183);
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

	public static class Test_case_priorityContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(StafParser.MINUS, 0); }
		public TerminalNode INT() { return getToken(StafParser.INT, 0); }
		public TerminalNode IGNORE() { return getToken(StafParser.IGNORE, 0); }
		public Test_case_priorityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test_case_priority; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterTest_case_priority(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitTest_case_priority(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitTest_case_priority(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Test_case_priorityContext test_case_priority() throws RecognitionException {
		Test_case_priorityContext _localctx = new Test_case_priorityContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_test_case_priority);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==IGNORE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(185);
			match(MINUS);
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
		enterRule(_localctx, 24, RULE_keywords_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(KEYWORDS);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMPORT) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(188);
				keyword_declaration();
				}
				}
				setState(193);
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
		public DocumentationContext documentation() {
			return getRuleContext(DocumentationContext.class,0);
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
		enterRule(_localctx, 26, RULE_keyword_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			keyword_name();
			setState(195);
			keyword_declaration_arguments();
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(196);
				documentation();
				}
			}

			setState(199);
			keyword_body();
			setState(200);
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
		enterRule(_localctx, 28, RULE_keyword_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RUN) | (1L << DOLLAR) | (1L << IMPORT) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << EXIT) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(202);
				statement();
				}
				}
				setState(207);
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
		public Exit_loopContext exit_loop() {
			return getRuleContext(Exit_loopContext.class,0);
		}
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
		enterRule(_localctx, 30, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(208);
				exit_loop();
				}
				break;
			case 2:
				{
				setState(209);
				assignment();
				}
				break;
			case 3:
				{
				setState(210);
				keyword_call();
				}
				break;
			case 4:
				{
				setState(211);
				for_stat();
				}
				break;
			case 5:
				{
				setState(212);
				run_keyword_if();
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
		public Exit_loopContext exit_loop() {
			return getRuleContext(Exit_loopContext.class,0);
		}
		public Run_keyword_elseContext run_keyword_else() {
			return getRuleContext(Run_keyword_elseContext.class,0);
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
		enterRule(_localctx, 32, RULE_run_keyword_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(RUN);
			setState(216);
			match(KEYWORD);
			setState(217);
			match(IF);
			setState(218);
			match(LPARENT);
			setState(219);
			expression(0);
			setState(220);
			match(RPARENT);
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
			case FOR:
			case GIVEN:
			case WHEN:
			case THEN:
			case IDENTIFIER:
				{
				setState(221);
				keyword_call();
				}
				break;
			case EXIT:
				{
				setState(222);
				exit_loop();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(225);
				run_keyword_else();
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

	public static class Run_keyword_elseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(StafParser.ELSE, 0); }
		public Keyword_callContext keyword_call() {
			return getRuleContext(Keyword_callContext.class,0);
		}
		public Exit_loopContext exit_loop() {
			return getRuleContext(Exit_loopContext.class,0);
		}
		public Run_keyword_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_run_keyword_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterRun_keyword_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitRun_keyword_else(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitRun_keyword_else(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Run_keyword_elseContext run_keyword_else() throws RecognitionException {
		Run_keyword_elseContext _localctx = new Run_keyword_elseContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_run_keyword_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(ELSE);
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
			case FOR:
			case GIVEN:
			case WHEN:
			case THEN:
			case IDENTIFIER:
				{
				setState(229);
				keyword_call();
				}
				break;
			case EXIT:
				{
				setState(230);
				exit_loop();
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

	public static class Exit_loopContext extends ParserRuleContext {
		public TerminalNode EXIT() { return getToken(StafParser.EXIT, 0); }
		public TerminalNode LOOP() { return getToken(StafParser.LOOP, 0); }
		public Exit_loop_conditionContext exit_loop_condition() {
			return getRuleContext(Exit_loop_conditionContext.class,0);
		}
		public Exit_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exit_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterExit_loop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitExit_loop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitExit_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exit_loopContext exit_loop() throws RecognitionException {
		Exit_loopContext _localctx = new Exit_loopContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_exit_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(EXIT);
			setState(234);
			match(LOOP);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(235);
				exit_loop_condition();
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

	public static class Exit_loop_conditionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(StafParser.IF, 0); }
		public TerminalNode LPARENT() { return getToken(StafParser.LPARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPARENT() { return getToken(StafParser.RPARENT, 0); }
		public Exit_loop_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exit_loop_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterExit_loop_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitExit_loop_condition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitExit_loop_condition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exit_loop_conditionContext exit_loop_condition() throws RecognitionException {
		Exit_loop_conditionContext _localctx = new Exit_loop_conditionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_exit_loop_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(238);
			match(IF);
			setState(239);
			match(LPARENT);
			setState(240);
			expression(0);
			setState(241);
			match(RPARENT);
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
		enterRule(_localctx, 40, RULE_keyword_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			keyword_name();
			setState(244);
			keyword_call_arguments();
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
		enterRule(_localctx, 42, RULE_keyword_call_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(LPARENT);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SINGLE_STRING) | (1L << DOUBLE_STRING) | (1L << MINUS) | (1L << NOT) | (1L << LPARENT) | (1L << LBRACKET) | (1L << LBRACE) | (1L << DOLLAR) | (1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << FLOAT) | (1L << IMPORT) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(247);
				object();
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(248);
					match(COMMA);
					setState(249);
					object();
					}
					}
					setState(254);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(257);
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
		enterRule(_localctx, 44, RULE_keyword_return_stat);
		try {
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(259);
				match(RETURN);
				setState(260);
				object();
				}
				}
				break;
			case END:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
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
		public List<Reserved_keywordContext> reserved_keyword() {
			return getRuleContexts(Reserved_keywordContext.class);
		}
		public Reserved_keywordContext reserved_keyword(int i) {
			return getRuleContext(Reserved_keywordContext.class,i);
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
		enterRule(_localctx, 46, RULE_keyword_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(264);
				match(IDENTIFIER);
				}
				break;
			case IMPORT:
			case FOR:
			case GIVEN:
			case WHEN:
			case THEN:
				{
				setState(265);
				reserved_keyword();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMPORT) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(270);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(268);
					match(IDENTIFIER);
					}
					break;
				case IMPORT:
				case FOR:
				case GIVEN:
				case WHEN:
				case THEN:
					{
					setState(269);
					reserved_keyword();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(274);
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

	public static class Reserved_keywordContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(StafParser.IMPORT, 0); }
		public TerminalNode FOR() { return getToken(StafParser.FOR, 0); }
		public TerminalNode GIVEN() { return getToken(StafParser.GIVEN, 0); }
		public TerminalNode WHEN() { return getToken(StafParser.WHEN, 0); }
		public TerminalNode THEN() { return getToken(StafParser.THEN, 0); }
		public Reserved_keywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reserved_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterReserved_keyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitReserved_keyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitReserved_keyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Reserved_keywordContext reserved_keyword() throws RecognitionException {
		Reserved_keywordContext _localctx = new Reserved_keywordContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_reserved_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMPORT) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN))) != 0)) ) {
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

	public static class Keyword_declaration_argumentsContext extends ParserRuleContext {
		public TerminalNode LPARENT() { return getToken(StafParser.LPARENT, 0); }
		public TerminalNode RPARENT() { return getToken(StafParser.RPARENT, 0); }
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
		enterRule(_localctx, 50, RULE_keyword_declaration_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(LPARENT);
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOLLAR) {
				{
				setState(278);
				variable();
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(279);
					match(COMMA);
					setState(280);
					variable();
					}
					}
					setState(285);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(288);
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
		enterRule(_localctx, 52, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			variable_reference(0);
			setState(291);
			match(EQUAL);
			setState(294);
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
			case IMPORT:
			case FOR:
			case GIVEN:
			case WHEN:
			case THEN:
			case IDENTIFIER:
				{
				setState(292);
				object();
				}
				break;
			case NULL:
				{
				setState(293);
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
		public TerminalNode FOR() { return getToken(StafParser.FOR, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode COLON() { return getToken(StafParser.COLON, 0); }
		public For_stat_bodyContext for_stat_body() {
			return getRuleContext(For_stat_bodyContext.class,0);
		}
		public TerminalNode ENDFOR() { return getToken(StafParser.ENDFOR, 0); }
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
		enterRule(_localctx, 54, RULE_for_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(FOR);
			setState(297);
			variable();
			setState(298);
			match(COLON);
			setState(302);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACKET:
			case LBRACE:
				{
				setState(299);
				complex_object();
				}
				break;
			case DOLLAR:
				{
				setState(300);
				variable_reference(0);
				}
				break;
			case IMPORT:
			case FOR:
			case GIVEN:
			case WHEN:
			case THEN:
			case IDENTIFIER:
				{
				setState(301);
				keyword_call();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(304);
			for_stat_body();
			setState(305);
			match(ENDFOR);
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
		enterRule(_localctx, 56, RULE_for_stat_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RUN) | (1L << DOLLAR) | (1L << IMPORT) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << EXIT) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(307);
				statement();
				}
				}
				setState(312);
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
		enterRule(_localctx, 58, RULE_listLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(LBRACKET);
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SINGLE_STRING) | (1L << DOUBLE_STRING) | (1L << MINUS) | (1L << NOT) | (1L << LPARENT) | (1L << LBRACKET) | (1L << LBRACE) | (1L << DOLLAR) | (1L << TRUE) | (1L << FALSE) | (1L << INT) | (1L << FLOAT) | (1L << IMPORT) | (1L << FOR) | (1L << GIVEN) | (1L << WHEN) | (1L << THEN) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(314);
				object();
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(315);
					match(COMMA);
					setState(316);
					object();
					}
					}
					setState(321);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(324);
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
		enterRule(_localctx, 60, RULE_dictionaryLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(LBRACE);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SINGLE_STRING) | (1L << DOUBLE_STRING) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(327);
				keyValuePair();
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(328);
					match(COMMA);
					setState(329);
					keyValuePair();
					}
					}
					setState(334);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(337);
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
		enterRule(_localctx, 62, RULE_keyValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(339);
				match(IDENTIFIER);
				}
				break;
			case SINGLE_STRING:
			case DOUBLE_STRING:
				{
				setState(340);
				string();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(343);
			match(COLON);
			setState(344);
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
		enterRule(_localctx, 64, RULE_object);
		try {
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				complex_object();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				scalar_object();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(348);
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
		enterRule(_localctx, 66, RULE_complex_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(351);
				dictionaryLiteral();
				}
				break;
			case LBRACKET:
				{
				setState(352);
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
		enterRule(_localctx, 68, RULE_scalar_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
			case DOUBLE_STRING:
			case TRUE:
			case FALSE:
			case INT:
			case FLOAT:
				{
				setState(355);
				primitive();
				}
				break;
			case DOLLAR:
				{
				setState(356);
				variable_reference(0);
				}
				break;
			case IMPORT:
			case FOR:
			case GIVEN:
			case WHEN:
			case THEN:
			case IDENTIFIER:
				{
				setState(357);
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
		public Variable_referenceContext variable_reference() {
			return getRuleContext(Variable_referenceContext.class,0);
		}
		public Brackets_item_accessContext brackets_item_access() {
			return getRuleContext(Brackets_item_accessContext.class,0);
		}
		public Dot_item_accessContext dot_item_access() {
			return getRuleContext(Dot_item_accessContext.class,0);
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
		return variable_reference(0);
	}

	private Variable_referenceContext variable_reference(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Variable_referenceContext _localctx = new Variable_referenceContext(_ctx, _parentState);
		Variable_referenceContext _prevctx = _localctx;
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_variable_reference, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(361);
			variable();
			}
			_ctx.stop = _input.LT(-1);
			setState(369);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(367);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
					case 1:
						{
						_localctx = new Variable_referenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_variable_reference);
						setState(363);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(364);
						brackets_item_access();
						}
						break;
					case 2:
						{
						_localctx = new Variable_referenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_variable_reference);
						setState(365);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(366);
						dot_item_access();
						}
						break;
					}
					} 
				}
				setState(371);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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
		enterRule(_localctx, 72, RULE_primitive);
		try {
			setState(375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
			case DOUBLE_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(372);
				string();
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				bool();
				}
				break;
			case INT:
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(374);
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
		enterRule(_localctx, 74, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			match(DOLLAR);
			setState(378);
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

	public static class Dot_item_accessContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(StafParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(StafParser.IDENTIFIER, 0); }
		public Dot_item_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot_item_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterDot_item_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitDot_item_access(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitDot_item_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dot_item_accessContext dot_item_access() throws RecognitionException {
		Dot_item_accessContext _localctx = new Dot_item_accessContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_dot_item_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(DOT);
			setState(381);
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

	public static class Brackets_item_accessContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(StafParser.LBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(StafParser.RBRACKET, 0); }
		public Brackets_item_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_brackets_item_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).enterBrackets_item_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StafListener ) ((StafListener)listener).exitBrackets_item_access(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof StafVisitor ) return ((StafVisitor<? extends T>)visitor).visitBrackets_item_access(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Brackets_item_accessContext brackets_item_access() throws RecognitionException {
		Brackets_item_accessContext _localctx = new Brackets_item_accessContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_brackets_item_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(LBRACKET);
			setState(384);
			expression(0);
			setState(385);
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
		int _startState = 80;
		enterRecursionRule(_localctx, 80, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case NOT:
				{
				setState(388);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==NOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(389);
				expression(6);
				}
				break;
			case LPARENT:
				{
				setState(390);
				match(LPARENT);
				setState(391);
				expression(0);
				setState(392);
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
			case IMPORT:
			case FOR:
			case GIVEN:
			case WHEN:
			case THEN:
			case IDENTIFIER:
				{
				setState(394);
				scalar_object();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(411);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(409);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(397);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(398);
						mulop();
						setState(399);
						expression(6);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(401);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(402);
						addop();
						setState(403);
						expression(5);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(405);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(406);
						binop();
						setState(407);
						expression(4);
						}
						break;
					}
					} 
				}
				setState(413);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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
		enterRule(_localctx, 82, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
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
		enterRule(_localctx, 84, RULE_addop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
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
		enterRule(_localctx, 86, RULE_binop);
		try {
			setState(427);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AND_OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(418);
				match(AND_OP);
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(419);
				match(OR);
				}
				break;
			case EQUAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(420);
				match(EQUAL);
				setState(421);
				match(EQUAL);
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 4);
				{
				setState(422);
				match(LT);
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 5);
				{
				setState(423);
				match(GT);
				}
				break;
			case LTE:
				enterOuterAlt(_localctx, 6);
				{
				setState(424);
				match(LTE);
				}
				break;
			case GTE:
				enterOuterAlt(_localctx, 7);
				{
				setState(425);
				match(GTE);
				}
				break;
			case NE:
				enterOuterAlt(_localctx, 8);
				{
				setState(426);
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
		enterRule(_localctx, 88, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
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
		enterRule(_localctx, 90, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
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
		enterRule(_localctx, 92, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
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
		case 35:
			return variable_reference_sempred((Variable_referenceContext)_localctx, predIndex);
		case 40:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean variable_reference_sempred(Variable_referenceContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3<\u01b6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\5\2b\n\2\3\2\5\2e\n\2\3\2\5\2h\n"+
		"\2\3\2\5\2k\n\2\3\2\5\2n\n\2\3\2\3\2\3\3\3\3\3\3\5\3u\n\3\3\4\3\4\7\4"+
		"y\n\4\f\4\16\4|\13\4\3\4\3\4\3\5\3\5\7\5\u0082\n\5\f\5\16\5\u0085\13\5"+
		"\3\6\3\6\3\6\3\7\3\7\5\7\u008c\n\7\3\b\3\b\7\b\u0090\n\b\f\b\16\b\u0093"+
		"\13\b\3\t\3\t\7\t\u0097\n\t\f\t\16\t\u009a\13\t\3\n\7\n\u009d\n\n\f\n"+
		"\16\n\u00a0\13\n\3\n\5\n\u00a3\n\n\3\n\3\n\3\n\5\n\u00a8\n\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\f\5\f\u00b3\n\f\3\f\7\f\u00b6\n\f\f\f\16"+
		"\f\u00b9\13\f\3\r\3\r\3\r\3\16\3\16\7\16\u00c0\n\16\f\16\16\16\u00c3\13"+
		"\16\3\17\3\17\3\17\5\17\u00c8\n\17\3\17\3\17\3\17\3\20\7\20\u00ce\n\20"+
		"\f\20\16\20\u00d1\13\20\3\21\3\21\3\21\3\21\3\21\5\21\u00d8\n\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00e2\n\22\3\22\5\22\u00e5\n"+
		"\22\3\23\3\23\3\23\5\23\u00ea\n\23\3\24\3\24\3\24\5\24\u00ef\n\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u00fd\n\27"+
		"\f\27\16\27\u0100\13\27\5\27\u0102\n\27\3\27\3\27\3\30\3\30\3\30\5\30"+
		"\u0109\n\30\3\31\3\31\5\31\u010d\n\31\3\31\3\31\7\31\u0111\n\31\f\31\16"+
		"\31\u0114\13\31\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u011c\n\33\f\33\16"+
		"\33\u011f\13\33\5\33\u0121\n\33\3\33\3\33\3\34\3\34\3\34\3\34\5\34\u0129"+
		"\n\34\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0131\n\35\3\35\3\35\3\35\3\36"+
		"\7\36\u0137\n\36\f\36\16\36\u013a\13\36\3\37\3\37\3\37\3\37\7\37\u0140"+
		"\n\37\f\37\16\37\u0143\13\37\5\37\u0145\n\37\3\37\3\37\3 \3 \3 \3 \7 "+
		"\u014d\n \f \16 \u0150\13 \5 \u0152\n \3 \3 \3!\3!\5!\u0158\n!\3!\3!\3"+
		"!\3\"\3\"\3\"\5\"\u0160\n\"\3#\3#\5#\u0164\n#\3$\3$\3$\5$\u0169\n$\3%"+
		"\3%\3%\3%\3%\3%\3%\7%\u0172\n%\f%\16%\u0175\13%\3&\3&\3&\5&\u017a\n&\3"+
		"\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\5*\u018e\n*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\7*\u019c\n*\f*\16*\u019f\13*\3+\3+"+
		"\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u01ae\n-\3.\3.\3/\3/\3\60\3\60\3"+
		"\60\3z\4HR\61\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^\2\13\4\2\4\4\668\4\2%%99\5\2,,\63\63\668\4\2"+
		"\16\16\27\27\3\2\17\21\3\2\r\16\3\2%&\3\2\5\6\3\2#$\2\u01c7\2a\3\2\2\2"+
		"\4q\3\2\2\2\6v\3\2\2\2\b\177\3\2\2\2\n\u0086\3\2\2\2\f\u008b\3\2\2\2\16"+
		"\u008d\3\2\2\2\20\u0094\3\2\2\2\22\u009e\3\2\2\2\24\u00ac\3\2\2\2\26\u00b7"+
		"\3\2\2\2\30\u00ba\3\2\2\2\32\u00bd\3\2\2\2\34\u00c4\3\2\2\2\36\u00cf\3"+
		"\2\2\2 \u00d7\3\2\2\2\"\u00d9\3\2\2\2$\u00e6\3\2\2\2&\u00eb\3\2\2\2(\u00f0"+
		"\3\2\2\2*\u00f5\3\2\2\2,\u00f8\3\2\2\2.\u0108\3\2\2\2\60\u010c\3\2\2\2"+
		"\62\u0115\3\2\2\2\64\u0117\3\2\2\2\66\u0124\3\2\2\28\u012a\3\2\2\2:\u0138"+
		"\3\2\2\2<\u013b\3\2\2\2>\u0148\3\2\2\2@\u0157\3\2\2\2B\u015f\3\2\2\2D"+
		"\u0163\3\2\2\2F\u0168\3\2\2\2H\u016a\3\2\2\2J\u0179\3\2\2\2L\u017b\3\2"+
		"\2\2N\u017e\3\2\2\2P\u0181\3\2\2\2R\u018d\3\2\2\2T\u01a0\3\2\2\2V\u01a2"+
		"\3\2\2\2X\u01ad\3\2\2\2Z\u01af\3\2\2\2\\\u01b1\3\2\2\2^\u01b3\3\2\2\2"+
		"`b\5\4\3\2a`\3\2\2\2ab\3\2\2\2bd\3\2\2\2ce\5\b\5\2dc\3\2\2\2de\3\2\2\2"+
		"eg\3\2\2\2fh\5\16\b\2gf\3\2\2\2gh\3\2\2\2hj\3\2\2\2ik\5\32\16\2ji\3\2"+
		"\2\2jk\3\2\2\2km\3\2\2\2ln\5\20\t\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7"+
		"\2\2\3p\3\3\2\2\2qr\7*\2\2rt\5\\/\2su\5\6\4\2ts\3\2\2\2tu\3\2\2\2u\5\3"+
		"\2\2\2vz\7\34\2\2wy\13\2\2\2xw\3\2\2\2y|\3\2\2\2z{\3\2\2\2zx\3\2\2\2{"+
		"}\3\2\2\2|z\3\2\2\2}~\7\35\2\2~\7\3\2\2\2\177\u0083\7+\2\2\u0080\u0082"+
		"\5\n\6\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\t\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7,\2\2"+
		"\u0087\u0088\5\f\7\2\u0088\13\3\2\2\2\u0089\u008c\5\\/\2\u008a\u008c\7"+
		"<\2\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\r\3\2\2\2\u008d\u0091"+
		"\7-\2\2\u008e\u0090\5\66\34\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2"+
		"\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\17\3\2\2\2\u0093\u0091"+
		"\3\2\2\2\u0094\u0098\7/\2\2\u0095\u0097\5\22\n\2\u0096\u0095\3\2\2\2\u0097"+
		"\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\21\3\2\2"+
		"\2\u009a\u0098\3\2\2\2\u009b\u009d\5\24\13\2\u009c\u009b\3\2\2\2\u009d"+
		"\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a2\3\2"+
		"\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a3\5\30\r\2\u00a2\u00a1\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\5\60\31\2\u00a5\u00a7\7"+
		"!\2\2\u00a6\u00a8\5\6\4\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00aa\5\26\f\2\u00aa\u00ab\7\61\2\2\u00ab\23\3\2"+
		"\2\2\u00ac\u00ad\7\3\2\2\u00ad\u00ae\7\34\2\2\u00ae\u00af\5\60\31\2\u00af"+
		"\u00b0\7\35\2\2\u00b0\25\3\2\2\2\u00b1\u00b3\t\2\2\2\u00b2\u00b1\3\2\2"+
		"\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\5 \21\2\u00b5\u00b2"+
		"\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\27\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb\t\3\2\2\u00bb\u00bc\7\16\2"+
		"\2\u00bc\31\3\2\2\2\u00bd\u00c1\7.\2\2\u00be\u00c0\5\34\17\2\u00bf\u00be"+
		"\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\33\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\5\60\31\2\u00c5\u00c7\5\64"+
		"\33\2\u00c6\u00c8\5\6\4\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00ca\5\36\20\2\u00ca\u00cb\5.\30\2\u00cb\35\3\2"+
		"\2\2\u00cc\u00ce\5 \21\2\u00cd\u00cc\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\37\3\2\2\2\u00d1\u00cf\3\2\2"+
		"\2\u00d2\u00d8\5&\24\2\u00d3\u00d8\5\66\34\2\u00d4\u00d8\5*\26\2\u00d5"+
		"\u00d8\58\35\2\u00d6\u00d8\5\"\22\2\u00d7\u00d2\3\2\2\2\u00d7\u00d3\3"+
		"\2\2\2\u00d7\u00d4\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8"+
		"!\3\2\2\2\u00d9\u00da\7\t\2\2\u00da\u00db\7\n\2\2\u00db\u00dc\7\13\2\2"+
		"\u00dc\u00dd\7\32\2\2\u00dd\u00de\5R*\2\u00de\u00e1\7\33\2\2\u00df\u00e2"+
		"\5*\26\2\u00e0\u00e2\5&\24\2\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2"+
		"\u00e4\3\2\2\2\u00e3\u00e5\5$\23\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5#\3\2\2\2\u00e6\u00e9\7\f\2\2\u00e7\u00ea\5*\26\2\u00e8\u00ea"+
		"\5&\24\2\u00e9\u00e7\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea%\3\2\2\2\u00eb"+
		"\u00ec\7:\2\2\u00ec\u00ee\7;\2\2\u00ed\u00ef\5(\25\2\u00ee\u00ed\3\2\2"+
		"\2\u00ee\u00ef\3\2\2\2\u00ef\'\3\2\2\2\u00f0\u00f1\7\13\2\2\u00f1\u00f2"+
		"\7\32\2\2\u00f2\u00f3\5R*\2\u00f3\u00f4\7\33\2\2\u00f4)\3\2\2\2\u00f5"+
		"\u00f6\5\60\31\2\u00f6\u00f7\5,\27\2\u00f7+\3\2\2\2\u00f8\u0101\7\32\2"+
		"\2\u00f9\u00fe\5B\"\2\u00fa\u00fb\7\b\2\2\u00fb\u00fd\5B\"\2\u00fc\u00fa"+
		"\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"\u0102\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u00f9\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102\u0103\3\2\2\2\u0103\u0104\7\33\2\2\u0104-\3\2\2\2\u0105\u0106"+
		"\7\62\2\2\u0106\u0109\5B\"\2\u0107\u0109\7\61\2\2\u0108\u0105\3\2\2\2"+
		"\u0108\u0107\3\2\2\2\u0109/\3\2\2\2\u010a\u010d\7<\2\2\u010b\u010d\5\62"+
		"\32\2\u010c\u010a\3\2\2\2\u010c\u010b\3\2\2\2\u010d\u0112\3\2\2\2\u010e"+
		"\u0111\7<\2\2\u010f\u0111\5\62\32\2\u0110\u010e\3\2\2\2\u0110\u010f\3"+
		"\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"\61\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0116\t\4\2\2\u0116\63\3\2\2\2\u0117"+
		"\u0120\7\32\2\2\u0118\u011d\5L\'\2\u0119\u011a\7\b\2\2\u011a\u011c\5L"+
		"\'\2\u011b\u0119\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0118\3\2"+
		"\2\2\u0120\u0121\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\7\33\2\2\u0123"+
		"\65\3\2\2\2\u0124\u0125\5H%\2\u0125\u0128\7\7\2\2\u0126\u0129\5B\"\2\u0127"+
		"\u0129\7\65\2\2\u0128\u0126\3\2\2\2\u0128\u0127\3\2\2\2\u0129\67\3\2\2"+
		"\2\u012a\u012b\7\63\2\2\u012b\u012c\5L\'\2\u012c\u0130\7!\2\2\u012d\u0131"+
		"\5D#\2\u012e\u0131\5H%\2\u012f\u0131\5*\26\2\u0130\u012d\3\2\2\2\u0130"+
		"\u012e\3\2\2\2\u0130\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\5:"+
		"\36\2\u0133\u0134\7\64\2\2\u01349\3\2\2\2\u0135\u0137\5 \21\2\u0136\u0135"+
		"\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		";\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u0144\7\34\2\2\u013c\u0141\5B\"\2"+
		"\u013d\u013e\7\b\2\2\u013e\u0140\5B\"\2\u013f\u013d\3\2\2\2\u0140\u0143"+
		"\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0145\3\2\2\2\u0143"+
		"\u0141\3\2\2\2\u0144\u013c\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0146\3\2"+
		"\2\2\u0146\u0147\7\35\2\2\u0147=\3\2\2\2\u0148\u0151\7\36\2\2\u0149\u014e"+
		"\5@!\2\u014a\u014b\7\b\2\2\u014b\u014d\5@!\2\u014c\u014a\3\2\2\2\u014d"+
		"\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0152\3\2"+
		"\2\2\u0150\u014e\3\2\2\2\u0151\u0149\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\u0154\7\37\2\2\u0154?\3\2\2\2\u0155\u0158\7<\2\2"+
		"\u0156\u0158\5\\/\2\u0157\u0155\3\2\2\2\u0157\u0156\3\2\2\2\u0158\u0159"+
		"\3\2\2\2\u0159\u015a\7!\2\2\u015a\u015b\5B\"\2\u015bA\3\2\2\2\u015c\u0160"+
		"\5D#\2\u015d\u0160\5F$\2\u015e\u0160\5R*\2\u015f\u015c\3\2\2\2\u015f\u015d"+
		"\3\2\2\2\u015f\u015e\3\2\2\2\u0160C\3\2\2\2\u0161\u0164\5> \2\u0162\u0164"+
		"\5<\37\2\u0163\u0161\3\2\2\2\u0163\u0162\3\2\2\2\u0164E\3\2\2\2\u0165"+
		"\u0169\5J&\2\u0166\u0169\5H%\2\u0167\u0169\5*\26\2\u0168\u0165\3\2\2\2"+
		"\u0168\u0166\3\2\2\2\u0168\u0167\3\2\2\2\u0169G\3\2\2\2\u016a\u016b\b"+
		"%\1\2\u016b\u016c\5L\'\2\u016c\u0173\3\2\2\2\u016d\u016e\f\5\2\2\u016e"+
		"\u0172\5P)\2\u016f\u0170\f\4\2\2\u0170\u0172\5N(\2\u0171\u016d\3\2\2\2"+
		"\u0171\u016f\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171\3\2\2\2\u0173\u0174"+
		"\3\2\2\2\u0174I\3\2\2\2\u0175\u0173\3\2\2\2\u0176\u017a\5\\/\2\u0177\u017a"+
		"\5^\60\2\u0178\u017a\5Z.\2\u0179\u0176\3\2\2\2\u0179\u0177\3\2\2\2\u0179"+
		"\u0178\3\2\2\2\u017aK\3\2\2\2\u017b\u017c\7\"\2\2\u017c\u017d\7<\2\2\u017d"+
		"M\3\2\2\2\u017e\u017f\7 \2\2\u017f\u0180\7<\2\2\u0180O\3\2\2\2\u0181\u0182"+
		"\7\34\2\2\u0182\u0183\5R*\2\u0183\u0184\7\35\2\2\u0184Q\3\2\2\2\u0185"+
		"\u0186\b*\1\2\u0186\u0187\t\5\2\2\u0187\u018e\5R*\b\u0188\u0189\7\32\2"+
		"\2\u0189\u018a\5R*\2\u018a\u018b\7\33\2\2\u018b\u018e\3\2\2\2\u018c\u018e"+
		"\5F$\2\u018d\u0185\3\2\2\2\u018d\u0188\3\2\2\2\u018d\u018c\3\2\2\2\u018e"+
		"\u019d\3\2\2\2\u018f\u0190\f\7\2\2\u0190\u0191\5T+\2\u0191\u0192\5R*\b"+
		"\u0192\u019c\3\2\2\2\u0193\u0194\f\6\2\2\u0194\u0195\5V,\2\u0195\u0196"+
		"\5R*\7\u0196\u019c\3\2\2\2\u0197\u0198\f\5\2\2\u0198\u0199\5X-\2\u0199"+
		"\u019a\5R*\6\u019a\u019c\3\2\2\2\u019b\u018f\3\2\2\2\u019b\u0193\3\2\2"+
		"\2\u019b\u0197\3\2\2\2\u019c\u019f\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019e"+
		"\3\2\2\2\u019eS\3\2\2\2\u019f\u019d\3\2\2\2\u01a0\u01a1\t\6\2\2\u01a1"+
		"U\3\2\2\2\u01a2\u01a3\t\7\2\2\u01a3W\3\2\2\2\u01a4\u01ae\7\30\2\2\u01a5"+
		"\u01ae\7\31\2\2\u01a6\u01a7\7\7\2\2\u01a7\u01ae\7\7\2\2\u01a8\u01ae\7"+
		"\22\2\2\u01a9\u01ae\7\23\2\2\u01aa\u01ae\7\24\2\2\u01ab\u01ae\7\25\2\2"+
		"\u01ac\u01ae\7\26\2\2\u01ad\u01a4\3\2\2\2\u01ad\u01a5\3\2\2\2\u01ad\u01a6"+
		"\3\2\2\2\u01ad\u01a8\3\2\2\2\u01ad\u01a9\3\2\2\2\u01ad\u01aa\3\2\2\2\u01ad"+
		"\u01ab\3\2\2\2\u01ad\u01ac\3\2\2\2\u01aeY\3\2\2\2\u01af\u01b0\t\b\2\2"+
		"\u01b0[\3\2\2\2\u01b1\u01b2\t\t\2\2\u01b2]\3\2\2\2\u01b3\u01b4\t\n\2\2"+
		"\u01b4_\3\2\2\2\64adgjmtz\u0083\u008b\u0091\u0098\u009e\u00a2\u00a7\u00b2"+
		"\u00b7\u00c1\u00c7\u00cf\u00d7\u00e1\u00e4\u00e9\u00ee\u00fe\u0101\u0108"+
		"\u010c\u0110\u0112\u011d\u0120\u0128\u0130\u0138\u0141\u0144\u014e\u0151"+
		"\u0157\u015f\u0163\u0168\u0171\u0173\u0179\u018d\u019b\u019d\u01ad";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}