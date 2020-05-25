// Generated from CoolLexer.g4 by ANTLR 4.5
package cool;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, TYPEID=2, OBJECTID=3, BOOL_CONST=4, INT_CONST=5, STR_CONST=6, 
		LPAREN=7, RPAREN=8, COLON=9, ATSYM=10, SEMICOLON=11, COMMA=12, PLUS=13, 
		MINUS=14, STAR=15, SLASH=16, TILDE=17, LT=18, EQUALS=19, LBRACE=20, RBRACE=21, 
		DOT=22, DARROW=23, LE=24, ASSIGN=25, CLASS=26, ELSE=27, FI=28, IF=29, 
		IN=30, INHERITS=31, LET=32, LOOP=33, POOL=34, THEN=35, WHILE=36, CASE=37, 
		ESAC=38, OF=39, NEW=40, ISVOID=41, NOT=42, SELF=43, SELF_TYPE=44, TRUE=45, 
		FALSE=46, WHITESPACE=47, COMMENT=48, CCOMMENT=49, OCOMMENT=50, SL_COMMENT=51, 
		DIFFSTRING=52;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SEMICOLON", "DARROW", "COLON", "LBRACE", "RBRACE", "LPAREN", "RPAREN", 
		"PLUS", "MINUS", "COMMA", "SLASH", "LT", "LE", "EQUALS", "DOT", "ASSIGN", 
		"ATSYM", "STAR", "TILDE", "SELF", "SELF_TYPE", "CLASS", "ELSE", "FI", 
		"IF", "IN", "INHERITS", "ISVOID", "LET", "LOOP", "POOL", "WHILE", "THEN", 
		"CASE", "ESAC", "NEW", "OF", "NOT", "TRUE", "FALSE", "BOOL_CONST", "INT_CONST", 
		"STR_CONST", "TYPEID", "OBJECTID", "WHITESPACE", "COMMENT", "CCOMMENT", 
		"OCOMMENT", "SL_COMMENT", "DIFFSTRING"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'('", "')'", "':'", "'@'", 
		"';'", "','", "'+'", "'-'", "'*'", "'/'", "'~'", "'<'", "'='", "'{'", 
		"'}'", "'.'", "'=>'", "'<='", "'<-'", null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "'self'", 
		"'SELF_TYPE'", null, null, null, null, "'(*'", "'*)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ERROR", "TYPEID", "OBJECTID", "BOOL_CONST", "INT_CONST", "STR_CONST", 
		"LPAREN", "RPAREN", "COLON", "ATSYM", "SEMICOLON", "COMMA", "PLUS", "MINUS", 
		"STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", "RBRACE", "DOT", "DARROW", 
		"LE", "ASSIGN", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "LET", 
		"LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", 
		"NOT", "SELF", "SELF_TYPE", "TRUE", "FALSE", "WHITESPACE", "COMMENT", 
		"CCOMMENT", "OCOMMENT", "SL_COMMENT", "DIFFSTRING"
	};
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



		/*
			YOU CAN ADD YOUR MEMBER VARIABLES AND METHODS HERE
		*/

		/**
		* Function to report errors.
		* Use this function whenever your lexer encounters any erroneous input
		* DO NOT EDIT THIS FUNCTION
		*/
		public void reportError(String errorString){
			setText(errorString);
			setType(ERROR);
		}
		public void notmatched()
		{
		Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
		String text = t.getText();
		reportError(text);
		}
		public void processString() {
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();
			//write your code to test strings here
			text = text.substring(1, text.length() -1);
			String buffer="";
			  if(text.length() > 1024) {
				reportError("String constant too long");
				return;
			}
			else{
			int x=0;
			while(x<text.length())
			{
			if(text.charAt(x) == '\n') {reportError("Unterminated string constant");}
			else if(text.charAt(x) == '\0'){reportError("String contains null character");}
			else if(text.charAt(x)=='\\')
			{
	        if(text.charAt(x+1)=='n') {buffer=buffer.concat("\n");}
	        else if(text.charAt(x+1)=='\n') {buffer=buffer.concat("\n");}
	        else if(text.charAt(x+1)=='t') {buffer=buffer.concat("\t");}
	        else if(text.charAt(x+1)=='b') {buffer=buffer.concat("\b");}
	        else if(text.charAt(x+1)=='f') {buffer=buffer.concat("\f");}
	        else if(text.charAt(x+1)=='r') {buffer=buffer.concat("\r");}
	        else if(text.charAt(x+1)=='0') {buffer=buffer.concat("0");}
	        else buffer=buffer.concat(String.valueOf(text.charAt(x +1)));
			x=x+2;
	        }
	        else {buffer=buffer.concat(String.valueOf(text.charAt(x)));}
	        x++;
	        }
	        setText(buffer);
	}

		}


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CoolLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 42:
			STR_CONST_action((RuleContext)_localctx, actionIndex);
			break;
		case 47:
			CCOMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 48:
			OCOMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 50:
			DIFFSTRING_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STR_CONST_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			processString();
			break;
		}
	}
	private void CCOMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			reportError("EOF in comment");
			break;
		}
	}
	private void OCOMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			reportError("UnMatched comment identifier.");
			break;
		}
	}
	private void DIFFSTRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			notmatched();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\66\u0151\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3"+
		" \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$"+
		"\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3"+
		")\3)\3)\3)\3)\3*\3*\5*\u0101\n*\3+\6+\u0104\n+\r+\16+\u0105\3,\3,\3,\3"+
		",\7,\u010c\n,\f,\16,\u010f\13,\3,\3,\3,\3-\3-\7-\u0116\n-\f-\16-\u0119"+
		"\13-\3.\3.\7.\u011d\n.\f.\16.\u0120\13.\3/\6/\u0123\n/\r/\16/\u0124\3"+
		"/\3/\3\60\3\60\3\60\3\60\3\60\7\60\u012e\n\60\f\60\16\60\u0131\13\60\3"+
		"\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3"+
		"\62\3\63\3\63\3\63\3\63\7\63\u0146\n\63\f\63\16\63\u0149\13\63\3\63\3"+
		"\63\3\63\3\63\3\64\3\64\3\64\4\u012f\u0147\2\65\3\r\5\31\7\13\t\26\13"+
		"\27\r\t\17\n\21\17\23\20\25\16\27\22\31\24\33\32\35\25\37\30!\33#\f%\21"+
		"\'\23)-+.-\34/\35\61\36\63\37\65 \67!9+;\"=#?$A&C%E\'G(I*K)M,O/Q\60S\6"+
		"U\7W\bY\4[\5]\61_\62a\63c\64e\65g\66\3\2\32\4\2EEee\4\2NNnn\4\2CCcc\4"+
		"\2UUuu\4\2GGgg\4\2HHhh\4\2KKkk\4\2PPpp\4\2JJjj\4\2TTtt\4\2VVvv\4\2XXx"+
		"x\4\2QQqq\4\2FFff\4\2YYyy\4\2WWww\3\2\62;\4\2\f\f$$\3\2C\\\6\2\62;C\\"+
		"aac|\3\2c|\4\2\62;C|\5\2\13\f\16\17\"\"\4\2\f\f\17\17\u015b\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\3i\3\2\2\2\5k\3\2\2\2\7n\3\2\2\2\tp\3\2\2"+
		"\2\13r\3\2\2\2\rt\3\2\2\2\17v\3\2\2\2\21x\3\2\2\2\23z\3\2\2\2\25|\3\2"+
		"\2\2\27~\3\2\2\2\31\u0080\3\2\2\2\33\u0082\3\2\2\2\35\u0085\3\2\2\2\37"+
		"\u0087\3\2\2\2!\u0089\3\2\2\2#\u008c\3\2\2\2%\u008e\3\2\2\2\'\u0090\3"+
		"\2\2\2)\u0092\3\2\2\2+\u0097\3\2\2\2-\u00a1\3\2\2\2/\u00a7\3\2\2\2\61"+
		"\u00ac\3\2\2\2\63\u00af\3\2\2\2\65\u00b2\3\2\2\2\67\u00b5\3\2\2\29\u00be"+
		"\3\2\2\2;\u00c5\3\2\2\2=\u00c9\3\2\2\2?\u00ce\3\2\2\2A\u00d3\3\2\2\2C"+
		"\u00d9\3\2\2\2E\u00de\3\2\2\2G\u00e3\3\2\2\2I\u00e8\3\2\2\2K\u00ec\3\2"+
		"\2\2M\u00ef\3\2\2\2O\u00f3\3\2\2\2Q\u00f8\3\2\2\2S\u0100\3\2\2\2U\u0103"+
		"\3\2\2\2W\u0107\3\2\2\2Y\u0113\3\2\2\2[\u011a\3\2\2\2]\u0122\3\2\2\2_"+
		"\u0128\3\2\2\2a\u0137\3\2\2\2c\u013c\3\2\2\2e\u0141\3\2\2\2g\u014e\3\2"+
		"\2\2ij\7=\2\2j\4\3\2\2\2kl\7?\2\2lm\7@\2\2m\6\3\2\2\2no\7<\2\2o\b\3\2"+
		"\2\2pq\7}\2\2q\n\3\2\2\2rs\7\177\2\2s\f\3\2\2\2tu\7*\2\2u\16\3\2\2\2v"+
		"w\7+\2\2w\20\3\2\2\2xy\7-\2\2y\22\3\2\2\2z{\7/\2\2{\24\3\2\2\2|}\7.\2"+
		"\2}\26\3\2\2\2~\177\7\61\2\2\177\30\3\2\2\2\u0080\u0081\7>\2\2\u0081\32"+
		"\3\2\2\2\u0082\u0083\7>\2\2\u0083\u0084\7?\2\2\u0084\34\3\2\2\2\u0085"+
		"\u0086\7?\2\2\u0086\36\3\2\2\2\u0087\u0088\7\60\2\2\u0088 \3\2\2\2\u0089"+
		"\u008a\7>\2\2\u008a\u008b\7/\2\2\u008b\"\3\2\2\2\u008c\u008d\7B\2\2\u008d"+
		"$\3\2\2\2\u008e\u008f\7,\2\2\u008f&\3\2\2\2\u0090\u0091\7\u0080\2\2\u0091"+
		"(\3\2\2\2\u0092\u0093\7u\2\2\u0093\u0094\7g\2\2\u0094\u0095\7n\2\2\u0095"+
		"\u0096\7h\2\2\u0096*\3\2\2\2\u0097\u0098\7U\2\2\u0098\u0099\7G\2\2\u0099"+
		"\u009a\7N\2\2\u009a\u009b\7H\2\2\u009b\u009c\7a\2\2\u009c\u009d\7V\2\2"+
		"\u009d\u009e\7[\2\2\u009e\u009f\7R\2\2\u009f\u00a0\7G\2\2\u00a0,\3\2\2"+
		"\2\u00a1\u00a2\t\2\2\2\u00a2\u00a3\t\3\2\2\u00a3\u00a4\t\4\2\2\u00a4\u00a5"+
		"\t\5\2\2\u00a5\u00a6\t\5\2\2\u00a6.\3\2\2\2\u00a7\u00a8\t\6\2\2\u00a8"+
		"\u00a9\t\3\2\2\u00a9\u00aa\t\5\2\2\u00aa\u00ab\t\6\2\2\u00ab\60\3\2\2"+
		"\2\u00ac\u00ad\t\7\2\2\u00ad\u00ae\t\b\2\2\u00ae\62\3\2\2\2\u00af\u00b0"+
		"\t\b\2\2\u00b0\u00b1\t\7\2\2\u00b1\64\3\2\2\2\u00b2\u00b3\t\b\2\2\u00b3"+
		"\u00b4\t\t\2\2\u00b4\66\3\2\2\2\u00b5\u00b6\t\b\2\2\u00b6\u00b7\t\t\2"+
		"\2\u00b7\u00b8\t\n\2\2\u00b8\u00b9\t\6\2\2\u00b9\u00ba\t\13\2\2\u00ba"+
		"\u00bb\t\b\2\2\u00bb\u00bc\t\f\2\2\u00bc\u00bd\t\5\2\2\u00bd8\3\2\2\2"+
		"\u00be\u00bf\t\b\2\2\u00bf\u00c0\t\5\2\2\u00c0\u00c1\t\r\2\2\u00c1\u00c2"+
		"\t\16\2\2\u00c2\u00c3\t\b\2\2\u00c3\u00c4\t\17\2\2\u00c4:\3\2\2\2\u00c5"+
		"\u00c6\t\3\2\2\u00c6\u00c7\t\6\2\2\u00c7\u00c8\t\f\2\2\u00c8<\3\2\2\2"+
		"\u00c9\u00ca\t\3\2\2\u00ca\u00cb\t\16\2\2\u00cb\u00cc\t\16\2\2\u00cc\u00cd"+
		"\4rr\2\u00cd>\3\2\2\2\u00ce\u00cf\4rr\2\u00cf\u00d0\t\16\2\2\u00d0\u00d1"+
		"\t\16\2\2\u00d1\u00d2\t\3\2\2\u00d2@\3\2\2\2\u00d3\u00d4\t\20\2\2\u00d4"+
		"\u00d5\t\n\2\2\u00d5\u00d6\t\b\2\2\u00d6\u00d7\t\3\2\2\u00d7\u00d8\t\6"+
		"\2\2\u00d8B\3\2\2\2\u00d9\u00da\t\f\2\2\u00da\u00db\t\n\2\2\u00db\u00dc"+
		"\t\6\2\2\u00dc\u00dd\t\t\2\2\u00ddD\3\2\2\2\u00de\u00df\t\2\2\2\u00df"+
		"\u00e0\t\4\2\2\u00e0\u00e1\t\5\2\2\u00e1\u00e2\t\6\2\2\u00e2F\3\2\2\2"+
		"\u00e3\u00e4\t\6\2\2\u00e4\u00e5\t\5\2\2\u00e5\u00e6\t\4\2\2\u00e6\u00e7"+
		"\t\2\2\2\u00e7H\3\2\2\2\u00e8\u00e9\t\t\2\2\u00e9\u00ea\t\6\2\2\u00ea"+
		"\u00eb\t\20\2\2\u00ebJ\3\2\2\2\u00ec\u00ed\t\16\2\2\u00ed\u00ee\t\7\2"+
		"\2\u00eeL\3\2\2\2\u00ef\u00f0\t\t\2\2\u00f0\u00f1\t\16\2\2\u00f1\u00f2"+
		"\t\f\2\2\u00f2N\3\2\2\2\u00f3\u00f4\7v\2\2\u00f4\u00f5\t\13\2\2\u00f5"+
		"\u00f6\t\21\2\2\u00f6\u00f7\t\6\2\2\u00f7P\3\2\2\2\u00f8\u00f9\7h\2\2"+
		"\u00f9\u00fa\t\4\2\2\u00fa\u00fb\t\3\2\2\u00fb\u00fc\t\5\2\2\u00fc\u00fd"+
		"\t\6\2\2\u00fdR\3\2\2\2\u00fe\u0101\5O(\2\u00ff\u0101\5Q)\2\u0100\u00fe"+
		"\3\2\2\2\u0100\u00ff\3\2\2\2\u0101T\3\2\2\2\u0102\u0104\t\22\2\2\u0103"+
		"\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106V\3\2\2\2\u0107\u010d\7$\2\2\u0108\u010c\7^\2\2\u0109\u010c"+
		"\n\23\2\2\u010a\u010c\5]/\2\u010b\u0108\3\2\2\2\u010b\u0109\3\2\2\2\u010b"+
		"\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2"+
		"\2\2\u010e\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\7$\2\2\u0111"+
		"\u0112\b,\2\2\u0112X\3\2\2\2\u0113\u0117\t\24\2\2\u0114\u0116\t\25\2\2"+
		"\u0115\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118"+
		"\3\2\2\2\u0118Z\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011e\t\26\2\2\u011b"+
		"\u011d\t\27\2\2\u011c\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3"+
		"\2\2\2\u011e\u011f\3\2\2\2\u011f\\\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0123"+
		"\t\30\2\2\u0122\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2"+
		"\u0124\u0125\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\b/\3\2\u0127^\3\2"+
		"\2\2\u0128\u0129\7*\2\2\u0129\u012a\7,\2\2\u012a\u012f\3\2\2\2\u012b\u012e"+
		"\5_\60\2\u012c\u012e\13\2\2\2\u012d\u012b\3\2\2\2\u012d\u012c\3\2\2\2"+
		"\u012e\u0131\3\2\2\2\u012f\u0130\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0132"+
		"\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0133\7,\2\2\u0133\u0134\7+\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\u0136\b\60\3\2\u0136`\3\2\2\2\u0137\u0138\7*\2\2"+
		"\u0138\u0139\7,\2\2\u0139\u013a\3\2\2\2\u013a\u013b\b\61\4\2\u013bb\3"+
		"\2\2\2\u013c\u013d\7,\2\2\u013d\u013e\7+\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u0140\b\62\5\2\u0140d\3\2\2\2\u0141\u0142\7/\2\2\u0142\u0143\7/\2\2\u0143"+
		"\u0147\3\2\2\2\u0144\u0146\13\2\2\2\u0145\u0144\3\2\2\2\u0146\u0149\3"+
		"\2\2\2\u0147\u0148\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u014a\3\2\2\2\u0149"+
		"\u0147\3\2\2\2\u014a\u014b\t\31\2\2\u014b\u014c\3\2\2\2\u014c\u014d\b"+
		"\63\3\2\u014df\3\2\2\2\u014e\u014f\13\2\2\2\u014f\u0150\b\64\6\2\u0150"+
		"h\3\2\2\2\r\2\u0100\u0105\u010b\u010d\u0117\u011e\u0124\u012d\u012f\u0147"+
		"\7\3,\2\b\2\2\3\61\3\3\62\4\3\64\5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}