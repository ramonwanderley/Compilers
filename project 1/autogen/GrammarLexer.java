// Generated from autogen/Grammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NUMBER=9, 
		CHAR=10, COMMENTBLOCK=11, COMMENTLINE=12, LIB=13, WHITESPACE=14, INT=15, 
		IDENTIFIER=16, TYPE_INT=17, TYPE_FLOAT=18, DEFAULT=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "NUMBER", 
			"CHAR", "COMMENTBLOCK", "COMMENTLINE", "LIB", "WHITESPACE", "INT", "IDENTIFIER", 
			"TYPE_INT", "TYPE_FLOAT", "DEFAULT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='", "'*'", "'/'", "'+'", "'-'", "'*='", "'/='", null, 
			null, null, null, null, null, null, null, "'int'", "'float'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "NUMBER", "CHAR", 
			"COMMENTBLOCK", "COMMENTLINE", "LIB", "WHITESPACE", "INT", "IDENTIFIER", 
			"TYPE_INT", "TYPE_FLOAT", "DEFAULT"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u008d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\7\fD\n"+
		"\f\f\f\16\fG\13\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\rR\n\r\f\r\16"+
		"\rU\13\r\3\r\3\r\3\r\3\r\3\16\3\16\7\16]\n\16\f\16\16\16`\13\16\3\16\3"+
		"\16\3\16\3\16\3\17\6\17g\n\17\r\17\16\17h\3\17\3\17\3\20\6\20n\n\20\r"+
		"\20\16\20o\3\21\6\21s\n\21\r\21\16\21t\3\21\7\21x\n\21\f\21\16\21{\13"+
		"\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\6\24\u0088"+
		"\n\24\r\24\16\24\u0089\3\24\3\24\6ES^\u0089\2\25\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		"\3\2\7\3\2\62;\3\2c|\5\2\13\f\17\17\"\"\5\2C\\aac|\5\2\62;C\\c|\2\u0094"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5+\3\2\2\2\7-\3\2\2\2\t/\3\2\2"+
		"\2\13\61\3\2\2\2\r\63\3\2\2\2\17\65\3\2\2\2\218\3\2\2\2\23;\3\2\2\2\25"+
		"=\3\2\2\2\27?\3\2\2\2\31M\3\2\2\2\33Z\3\2\2\2\35f\3\2\2\2\37m\3\2\2\2"+
		"!r\3\2\2\2#|\3\2\2\2%\u0080\3\2\2\2\'\u0087\3\2\2\2)*\7=\2\2*\4\3\2\2"+
		"\2+,\7?\2\2,\6\3\2\2\2-.\7,\2\2.\b\3\2\2\2/\60\7\61\2\2\60\n\3\2\2\2\61"+
		"\62\7-\2\2\62\f\3\2\2\2\63\64\7/\2\2\64\16\3\2\2\2\65\66\7,\2\2\66\67"+
		"\7?\2\2\67\20\3\2\2\289\7\61\2\29:\7?\2\2:\22\3\2\2\2;<\t\2\2\2<\24\3"+
		"\2\2\2=>\t\3\2\2>\26\3\2\2\2?@\7\61\2\2@A\7,\2\2AE\3\2\2\2BD\13\2\2\2"+
		"CB\3\2\2\2DG\3\2\2\2EF\3\2\2\2EC\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7,\2\2"+
		"IJ\7\61\2\2JK\3\2\2\2KL\b\f\2\2L\30\3\2\2\2MN\7\61\2\2NO\7\61\2\2OS\3"+
		"\2\2\2PR\13\2\2\2QP\3\2\2\2RU\3\2\2\2ST\3\2\2\2SQ\3\2\2\2TV\3\2\2\2US"+
		"\3\2\2\2VW\7\f\2\2WX\3\2\2\2XY\b\r\2\2Y\32\3\2\2\2Z^\7%\2\2[]\13\2\2\2"+
		"\\[\3\2\2\2]`\3\2\2\2^_\3\2\2\2^\\\3\2\2\2_a\3\2\2\2`^\3\2\2\2ab\7\f\2"+
		"\2bc\3\2\2\2cd\b\16\2\2d\34\3\2\2\2eg\t\4\2\2fe\3\2\2\2gh\3\2\2\2hf\3"+
		"\2\2\2hi\3\2\2\2ij\3\2\2\2jk\b\17\2\2k\36\3\2\2\2ln\5\23\n\2ml\3\2\2\2"+
		"no\3\2\2\2om\3\2\2\2op\3\2\2\2p \3\2\2\2qs\t\5\2\2rq\3\2\2\2st\3\2\2\2"+
		"tr\3\2\2\2tu\3\2\2\2uy\3\2\2\2vx\t\6\2\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2"+
		"yz\3\2\2\2z\"\3\2\2\2{y\3\2\2\2|}\7k\2\2}~\7p\2\2~\177\7v\2\2\177$\3\2"+
		"\2\2\u0080\u0081\7h\2\2\u0081\u0082\7n\2\2\u0082\u0083\7q\2\2\u0083\u0084"+
		"\7c\2\2\u0084\u0085\7v\2\2\u0085&\3\2\2\2\u0086\u0088\13\2\2\2\u0087\u0086"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008c\b\24\2\2\u008c(\3\2\2\2\13\2ES^hoty\u0089\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}