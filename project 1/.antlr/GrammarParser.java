// Generated from /Users/ramonwanderley/Repositories/Compilers/project 1/Grammar.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, TYPE_INT=29, TYPE_FLOAT=30, QUOTE=31, 
		COMMENT_BLOCK=32, COMMENT_LINE=33, LIB=34, WHITESPACE=35, INT=36, FLOAT=37, 
		IDENTIFIER=38, STRING=39, DEFAULT=40;
	public static final int
		RULE_file = 0, RULE_identifier = 1, RULE_integer = 2, RULE_floating = 3, 
		RULE_string = 4, RULE_array = 5, RULE_array_literal = 6, RULE_variable_definition = 7, 
		RULE_type = 8, RULE_function_definition = 9, RULE_body = 10, RULE_arguments = 11, 
		RULE_argumentsType = 12, RULE_function_call = 13, RULE_variable_assignment = 14, 
		RULE_for_loop = 15, RULE_for_initializer = 16, RULE_for_condition = 17, 
		RULE_for_step = 18, RULE_if_statement = 19, RULE_else_statement = 20, 
		RULE_expression = 21, RULE_statement = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "identifier", "integer", "floating", "string", "array", "array_literal", 
			"variable_definition", "type", "function_definition", "body", "arguments", 
			"argumentsType", "function_call", "variable_assignment", "for_loop", 
			"for_initializer", "for_condition", "for_step", "if_statement", "else_statement", 
			"expression", "statement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'['", "']'", "'{'", "','", "'}'", "'='", "'('", "')'", 
			"'*='", "'/='", "'+='", "'-='", "'++'", "'--'", "'for'", "'if'", "'else'", 
			"'*'", "'/'", "'+'", "'-'", "'<='", "'=='", "'>='", "'<'", "'>'", "'return'", 
			"'int'", "'float'", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "TYPE_INT", "TYPE_FLOAT", "QUOTE", "COMMENT_BLOCK", 
			"COMMENT_LINE", "LIB", "WHITESPACE", "INT", "FLOAT", "IDENTIFIER", "STRING", 
			"DEFAULT"
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public List<Variable_definitionContext> variable_definition() {
			return getRuleContexts(Variable_definitionContext.class);
		}
		public Variable_definitionContext variable_definition(int i) {
			return getRuleContext(Variable_definitionContext.class,i);
		}
		public List<Function_definitionContext> function_definition() {
			return getRuleContexts(Function_definitionContext.class);
		}
		public Function_definitionContext function_definition(int i) {
			return getRuleContext(Function_definitionContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(50);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(46);
					variable_definition();
					setState(47);
					match(T__0);
					}
					break;
				case 2:
					{
					setState(49);
					function_definition();
					}
					break;
				}
				}
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TYPE_INT || _la==TYPE_FLOAT );
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GrammarParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(INT);
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

	public static class FloatingContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(GrammarParser.FLOAT, 0); }
		public FloatingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floating; }
	}

	public final FloatingContext floating() throws RecognitionException {
		FloatingContext _localctx = new FloatingContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_floating);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(FLOAT);
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
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(STRING);
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

	public static class ArrayContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			identifier();
			setState(63);
			match(T__1);
			setState(64);
			expression(0);
			setState(65);
			match(T__2);
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

	public static class Array_literalContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Array_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_literal; }
	}

	public final Array_literalContext array_literal() throws RecognitionException {
		Array_literalContext _localctx = new Array_literalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_array_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__3);
			setState(68);
			expression(0);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(69);
				match(T__4);
				setState(70);
				expression(0);
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			match(T__5);
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

	public static class Variable_definitionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<ArrayContext> array() {
			return getRuleContexts(ArrayContext.class);
		}
		public ArrayContext array(int i) {
			return getRuleContext(ArrayContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<Array_literalContext> array_literal() {
			return getRuleContexts(Array_literalContext.class);
		}
		public Array_literalContext array_literal(int i) {
			return getRuleContext(Array_literalContext.class,i);
		}
		public Variable_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_definition; }
	}

	public final Variable_definitionContext variable_definition() throws RecognitionException {
		Variable_definitionContext _localctx = new Variable_definitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variable_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			type();
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(79);
				identifier();
				}
				break;
			case 2:
				{
				setState(80);
				array();
				}
				break;
			}
			setState(83);
			match(T__6);
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__20:
			case T__21:
			case INT:
			case FLOAT:
			case IDENTIFIER:
			case STRING:
				{
				setState(84);
				expression(0);
				}
				break;
			case T__3:
				{
				setState(85);
				array_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(88);
				match(T__4);
				setState(91);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(89);
					identifier();
					}
					break;
				case 2:
					{
					setState(90);
					array();
					}
					break;
				}
				setState(93);
				match(T__6);
				setState(96);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
				case T__20:
				case T__21:
				case INT:
				case FLOAT:
				case IDENTIFIER:
				case STRING:
					{
					setState(94);
					expression(0);
					}
					break;
				case T__3:
					{
					setState(95);
					array_literal();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(102);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode TYPE_INT() { return getToken(GrammarParser.TYPE_INT, 0); }
		public TerminalNode TYPE_FLOAT() { return getToken(GrammarParser.TYPE_FLOAT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_la = _input.LA(1);
			if ( !(_la==TYPE_INT || _la==TYPE_FLOAT) ) {
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

	public static class Function_definitionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_function_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			type();
			setState(106);
			identifier();
			setState(107);
			arguments();
			setState(108);
			body();
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

	public static class BodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__3);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__15) | (1L << T__16) | (1L << T__20) | (1L << T__21) | (1L << T__27) | (1L << TYPE_INT) | (1L << TYPE_FLOAT) | (1L << INT) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << STRING))) != 0)) {
				{
				{
				setState(111);
				statement();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(T__5);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__7);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_INT || _la==TYPE_FLOAT) {
				{
				setState(120);
				type();
				setState(121);
				identifier();
				}
			}

			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(125);
				match(T__4);
				setState(126);
				type();
				setState(127);
				identifier();
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134);
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

	public static class ArgumentsTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArgumentsTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentsType; }
	}

	public final ArgumentsTypeContext argumentsType() throws RecognitionException {
		ArgumentsTypeContext _localctx = new ArgumentsTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_argumentsType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			type();
			setState(137);
			identifier();
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

	public static class Function_callContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			identifier();
			setState(140);
			match(T__7);
			setState(141);
			expression(0);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(142);
				match(T__4);
				setState(143);
				expression(0);
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(149);
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

	public static class Variable_assignmentContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Variable_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_assignment; }
	}

	public final Variable_assignmentContext variable_assignment() throws RecognitionException {
		Variable_assignmentContext _localctx = new Variable_assignmentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variable_assignment);
		int _la;
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(151);
				identifier();
				setState(152);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(153);
				expression(0);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				identifier();
				setState(156);
				_la = _input.LA(1);
				if ( !(_la==T__13 || _la==T__14) ) {
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

	public static class For_loopContext extends ParserRuleContext {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public For_initializerContext for_initializer() {
			return getRuleContext(For_initializerContext.class,0);
		}
		public For_conditionContext for_condition() {
			return getRuleContext(For_conditionContext.class,0);
		}
		public For_stepContext for_step() {
			return getRuleContext(For_stepContext.class,0);
		}
		public For_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_loop; }
	}

	public final For_loopContext for_loop() throws RecognitionException {
		For_loopContext _localctx = new For_loopContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_for_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__15);
			setState(161);
			match(T__7);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_INT || _la==TYPE_FLOAT) {
				{
				setState(162);
				for_initializer();
				}
			}

			setState(165);
			match(T__0);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__20) | (1L << T__21) | (1L << INT) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << STRING))) != 0)) {
				{
				setState(166);
				for_condition();
				}
			}

			setState(169);
			match(T__0);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(170);
				for_step();
				}
			}

			setState(173);
			match(T__8);
			setState(174);
			body();
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

	public static class For_initializerContext extends ParserRuleContext {
		public Variable_definitionContext variable_definition() {
			return getRuleContext(Variable_definitionContext.class,0);
		}
		public For_initializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_initializer; }
	}

	public final For_initializerContext for_initializer() throws RecognitionException {
		For_initializerContext _localctx = new For_initializerContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_for_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(176);
			variable_definition();
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

	public static class For_conditionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public For_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_condition; }
	}

	public final For_conditionContext for_condition() throws RecognitionException {
		For_conditionContext _localctx = new For_conditionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_for_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(178);
			expression(0);
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

	public static class For_stepContext extends ParserRuleContext {
		public Variable_assignmentContext variable_assignment() {
			return getRuleContext(Variable_assignmentContext.class,0);
		}
		public For_stepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_step; }
	}

	public final For_stepContext for_step() throws RecognitionException {
		For_stepContext _localctx = new For_stepContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_for_step);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(180);
			variable_assignment();
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

	public static class If_statementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<Else_statementContext> else_statement() {
			return getRuleContexts(Else_statementContext.class);
		}
		public Else_statementContext else_statement(int i) {
			return getRuleContext(Else_statementContext.class,i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_if_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(T__16);
			setState(183);
			match(T__7);
			setState(184);
			expression(0);
			setState(185);
			match(T__8);
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(186);
				body();
				}
				break;
			case T__7:
			case T__15:
			case T__16:
			case T__20:
			case T__21:
			case T__27:
			case TYPE_INT:
			case TYPE_FLOAT:
			case INT:
			case FLOAT:
			case IDENTIFIER:
			case STRING:
				{
				setState(187);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(190);
					else_statement();
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class Else_statementContext extends ParserRuleContext {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__17);
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(197);
				body();
				}
				break;
			case T__7:
			case T__15:
			case T__16:
			case T__20:
			case T__21:
			case T__27:
			case TYPE_INT:
			case TYPE_FLOAT:
			case INT:
			case FLOAT:
			case IDENTIFIER:
			case STRING:
				{
				setState(198);
				statement();
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

	public static class ExpressionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public FloatingContext floating() {
			return getRuleContext(FloatingContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(202);
				identifier();
				}
				break;
			case 2:
				{
				setState(203);
				array();
				}
				break;
			case 3:
				{
				setState(204);
				floating();
				}
				break;
			case 4:
				{
				setState(205);
				integer();
				}
				break;
			case 5:
				{
				setState(206);
				string();
				}
				break;
			case 6:
				{
				setState(207);
				_la = _input.LA(1);
				if ( !(_la==T__20 || _la==T__21) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(208);
				expression(4);
				}
				break;
			case 7:
				{
				setState(209);
				match(T__7);
				setState(210);
				expression(0);
				setState(211);
				match(T__8);
				}
				break;
			case 8:
				{
				setState(213);
				function_call();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(234);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(232);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(217);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__19) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(218);
						expression(7);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(220);
						_la = _input.LA(1);
						if ( !(_la==T__20 || _la==T__21) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(221);
						expression(6);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(222);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(229);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__22:
							{
							setState(223);
							match(T__22);
							}
							break;
						case T__23:
							{
							setState(224);
							match(T__23);
							}
							break;
						case T__24:
							{
							setState(225);
							match(T__24);
							}
							break;
						case T__25:
							{
							setState(226);
							match(T__25);
							}
							break;
						case T__26:
							{
							setState(227);
							match(T__26);
							}
							break;
						case T__7:
						case T__20:
						case T__21:
						case INT:
						case FLOAT:
						case IDENTIFIER:
						case STRING:
							{
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(231);
						expression(4);
						}
						break;
					}
					} 
				}
				setState(236);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class StatementContext extends ParserRuleContext {
		public Variable_assignmentContext variable_assignment() {
			return getRuleContext(Variable_assignmentContext.class,0);
		}
		public For_loopContext for_loop() {
			return getRuleContext(For_loopContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Variable_definitionContext variable_definition() {
			return getRuleContext(Variable_definitionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(237);
				variable_assignment();
				setState(238);
				match(T__0);
				}
				break;
			case 2:
				{
				setState(240);
				for_loop();
				}
				break;
			case 3:
				{
				setState(241);
				if_statement();
				}
				break;
			case 4:
				{
				setState(242);
				variable_definition();
				setState(243);
				match(T__0);
				}
				break;
			case 5:
				{
				setState(245);
				match(T__27);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__20) | (1L << T__21) | (1L << INT) | (1L << FLOAT) | (1L << IDENTIFIER) | (1L << STRING))) != 0)) {
					{
					setState(246);
					expression(0);
					}
				}

				setState(249);
				match(T__0);
				}
				break;
			case 6:
				{
				setState(250);
				expression(0);
				setState(251);
				match(T__0);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u0102\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\6\2\65\n\2\r\2\16\2\66\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\bJ\n\b\f\b\16\bM\13\b\3\b\3\b\3\t\3\t\3"+
		"\t\5\tT\n\t\3\t\3\t\3\t\5\tY\n\t\3\t\3\t\3\t\5\t^\n\t\3\t\3\t\3\t\5\t"+
		"c\n\t\7\te\n\t\f\t\16\th\13\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\7\fs\n\f\f\f\16\fv\13\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r~\n\r\3\r\3\r\3\r"+
		"\3\r\7\r\u0084\n\r\f\r\16\r\u0087\13\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\7\17\u0093\n\17\f\17\16\17\u0096\13\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00a1\n\20\3\21\3\21\3\21\5\21\u00a6"+
		"\n\21\3\21\3\21\5\21\u00aa\n\21\3\21\3\21\5\21\u00ae\n\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00bf"+
		"\n\25\3\25\7\25\u00c2\n\25\f\25\16\25\u00c5\13\25\3\26\3\26\3\26\5\26"+
		"\u00ca\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u00d9\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\5\27\u00e8\n\27\3\27\7\27\u00eb\n\27\f\27\16\27\u00ee"+
		"\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00fa\n"+
		"\30\3\30\3\30\3\30\3\30\5\30\u0100\n\30\3\30\2\3,\31\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\2\7\3\2\37 \4\2\t\t\f\17\3\2\20\21\3\2"+
		"\27\30\3\2\25\26\2\u0112\2\64\3\2\2\2\48\3\2\2\2\6:\3\2\2\2\b<\3\2\2\2"+
		"\n>\3\2\2\2\f@\3\2\2\2\16E\3\2\2\2\20P\3\2\2\2\22i\3\2\2\2\24k\3\2\2\2"+
		"\26p\3\2\2\2\30y\3\2\2\2\32\u008a\3\2\2\2\34\u008d\3\2\2\2\36\u00a0\3"+
		"\2\2\2 \u00a2\3\2\2\2\"\u00b2\3\2\2\2$\u00b4\3\2\2\2&\u00b6\3\2\2\2(\u00b8"+
		"\3\2\2\2*\u00c6\3\2\2\2,\u00d8\3\2\2\2.\u00ff\3\2\2\2\60\61\5\20\t\2\61"+
		"\62\7\3\2\2\62\65\3\2\2\2\63\65\5\24\13\2\64\60\3\2\2\2\64\63\3\2\2\2"+
		"\65\66\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\3\3\2\2\289\7(\2\29\5\3"+
		"\2\2\2:;\7&\2\2;\7\3\2\2\2<=\7\'\2\2=\t\3\2\2\2>?\7)\2\2?\13\3\2\2\2@"+
		"A\5\4\3\2AB\7\4\2\2BC\5,\27\2CD\7\5\2\2D\r\3\2\2\2EF\7\6\2\2FK\5,\27\2"+
		"GH\7\7\2\2HJ\5,\27\2IG\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2"+
		"MK\3\2\2\2NO\7\b\2\2O\17\3\2\2\2PS\5\22\n\2QT\5\4\3\2RT\5\f\7\2SQ\3\2"+
		"\2\2SR\3\2\2\2TU\3\2\2\2UX\7\t\2\2VY\5,\27\2WY\5\16\b\2XV\3\2\2\2XW\3"+
		"\2\2\2Yf\3\2\2\2Z]\7\7\2\2[^\5\4\3\2\\^\5\f\7\2][\3\2\2\2]\\\3\2\2\2^"+
		"_\3\2\2\2_b\7\t\2\2`c\5,\27\2ac\5\16\b\2b`\3\2\2\2ba\3\2\2\2ce\3\2\2\2"+
		"dZ\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\21\3\2\2\2hf\3\2\2\2ij\t\2\2"+
		"\2j\23\3\2\2\2kl\5\22\n\2lm\5\4\3\2mn\5\30\r\2no\5\26\f\2o\25\3\2\2\2"+
		"pt\7\6\2\2qs\5.\30\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2"+
		"vt\3\2\2\2wx\7\b\2\2x\27\3\2\2\2y}\7\n\2\2z{\5\22\n\2{|\5\4\3\2|~\3\2"+
		"\2\2}z\3\2\2\2}~\3\2\2\2~\u0085\3\2\2\2\177\u0080\7\7\2\2\u0080\u0081"+
		"\5\22\n\2\u0081\u0082\5\4\3\2\u0082\u0084\3\2\2\2\u0083\177\3\2\2\2\u0084"+
		"\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088\3\2"+
		"\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7\13\2\2\u0089\31\3\2\2\2\u008a\u008b"+
		"\5\22\n\2\u008b\u008c\5\4\3\2\u008c\33\3\2\2\2\u008d\u008e\5\4\3\2\u008e"+
		"\u008f\7\n\2\2\u008f\u0094\5,\27\2\u0090\u0091\7\7\2\2\u0091\u0093\5,"+
		"\27\2\u0092\u0090\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0098\7\13"+
		"\2\2\u0098\35\3\2\2\2\u0099\u009a\5\4\3\2\u009a\u009b\t\3\2\2\u009b\u009c"+
		"\5,\27\2\u009c\u00a1\3\2\2\2\u009d\u009e\5\4\3\2\u009e\u009f\t\4\2\2\u009f"+
		"\u00a1\3\2\2\2\u00a0\u0099\3\2\2\2\u00a0\u009d\3\2\2\2\u00a1\37\3\2\2"+
		"\2\u00a2\u00a3\7\22\2\2\u00a3\u00a5\7\n\2\2\u00a4\u00a6\5\"\22\2\u00a5"+
		"\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\7\3"+
		"\2\2\u00a8\u00aa\5$\23\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ad\7\3\2\2\u00ac\u00ae\5&\24\2\u00ad\u00ac\3\2"+
		"\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\7\13\2\2\u00b0"+
		"\u00b1\5\26\f\2\u00b1!\3\2\2\2\u00b2\u00b3\5\20\t\2\u00b3#\3\2\2\2\u00b4"+
		"\u00b5\5,\27\2\u00b5%\3\2\2\2\u00b6\u00b7\5\36\20\2\u00b7\'\3\2\2\2\u00b8"+
		"\u00b9\7\23\2\2\u00b9\u00ba\7\n\2\2\u00ba\u00bb\5,\27\2\u00bb\u00be\7"+
		"\13\2\2\u00bc\u00bf\5\26\f\2\u00bd\u00bf\5.\30\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bd\3\2\2\2\u00bf\u00c3\3\2\2\2\u00c0\u00c2\5*\26\2\u00c1\u00c0\3\2"+
		"\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		")\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\7\24\2\2\u00c7\u00ca\5\26\f"+
		"\2\u00c8\u00ca\5.\30\2\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca+"+
		"\3\2\2\2\u00cb\u00cc\b\27\1\2\u00cc\u00d9\5\4\3\2\u00cd\u00d9\5\f\7\2"+
		"\u00ce\u00d9\5\b\5\2\u00cf\u00d9\5\6\4\2\u00d0\u00d9\5\n\6\2\u00d1\u00d2"+
		"\t\5\2\2\u00d2\u00d9\5,\27\6\u00d3\u00d4\7\n\2\2\u00d4\u00d5\5,\27\2\u00d5"+
		"\u00d6\7\13\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d9\5\34\17\2\u00d8\u00cb"+
		"\3\2\2\2\u00d8\u00cd\3\2\2\2\u00d8\u00ce\3\2\2\2\u00d8\u00cf\3\2\2\2\u00d8"+
		"\u00d0\3\2\2\2\u00d8\u00d1\3\2\2\2\u00d8\u00d3\3\2\2\2\u00d8\u00d7\3\2"+
		"\2\2\u00d9\u00ec\3\2\2\2\u00da\u00db\f\b\2\2\u00db\u00dc\t\6\2\2\u00dc"+
		"\u00eb\5,\27\t\u00dd\u00de\f\7\2\2\u00de\u00df\t\5\2\2\u00df\u00eb\5,"+
		"\27\b\u00e0\u00e7\f\5\2\2\u00e1\u00e8\7\31\2\2\u00e2\u00e8\7\32\2\2\u00e3"+
		"\u00e8\7\33\2\2\u00e4\u00e8\7\34\2\2\u00e5\u00e8\7\35\2\2\u00e6\u00e8"+
		"\3\2\2\2\u00e7\u00e1\3\2\2\2\u00e7\u00e2\3\2\2\2\u00e7\u00e3\3\2\2\2\u00e7"+
		"\u00e4\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8\u00e9\3\2"+
		"\2\2\u00e9\u00eb\5,\27\6\u00ea\u00da\3\2\2\2\u00ea\u00dd\3\2\2\2\u00ea"+
		"\u00e0\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed-\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\5\36\20\2\u00f0\u00f1"+
		"\7\3\2\2\u00f1\u0100\3\2\2\2\u00f2\u0100\5 \21\2\u00f3\u0100\5(\25\2\u00f4"+
		"\u00f5\5\20\t\2\u00f5\u00f6\7\3\2\2\u00f6\u0100\3\2\2\2\u00f7\u00f9\7"+
		"\36\2\2\u00f8\u00fa\5,\27\2\u00f9\u00f8\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\u0100\7\3\2\2\u00fc\u00fd\5,\27\2\u00fd\u00fe\7\3"+
		"\2\2\u00fe\u0100\3\2\2\2\u00ff\u00ef\3\2\2\2\u00ff\u00f2\3\2\2\2\u00ff"+
		"\u00f3\3\2\2\2\u00ff\u00f4\3\2\2\2\u00ff\u00f7\3\2\2\2\u00ff\u00fc\3\2"+
		"\2\2\u0100/\3\2\2\2\33\64\66KSX]bft}\u0085\u0094\u00a0\u00a5\u00a9\u00ad"+
		"\u00be\u00c3\u00c9\u00d8\u00e7\u00ea\u00ec\u00f9\u00ff";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}