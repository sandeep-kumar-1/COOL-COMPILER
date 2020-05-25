lexer grammar CoolLexer;

tokens{
	ERROR,
	TYPEID,
	OBJECTID,
	BOOL_CONST,
	INT_CONST,
	STR_CONST,
	LPAREN,
	RPAREN,
	COLON,
	ATSYM,
	SEMICOLON,
	COMMA,
	PLUS,
	MINUS,
	STAR,
	SLASH,
	TILDE,
	LT,
	EQUALS,
	LBRACE,
	RBRACE,
	DOT,
	DARROW,
	LE,
	ASSIGN,
	CLASS,
	ELSE,
	FI,
	IF,
	IN,
	INHERITS,
	LET,
	LOOP,
	POOL,
	THEN,
	WHILE,
	CASE,
	ESAC,
	OF,
	NEW,
	ISVOID,
	NOT
}

/*
  DO NOT EDIT CODE ABOVE THIS LINE
*/

@members{

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
}

/*
	WRITE ALL LEXER RULES BELOW
*/

SEMICOLON   : ';';
DARROW      : '=>';
COLON	    : ':';
LBRACE	    : '{';
RBRACE	    : '}';
LPAREN	    : '(';
RPAREN	    : ')';
PLUS	    : '+';
MINUS	    : '-'; 
COMMA	    : ',';
SLASH	    : '/';
LT	        : '<';
LE	        : '<=';
EQUALS	    : '=';
DOT	        : '.';
ASSIGN	    : '<-';
ATSYM	    : '@';
STAR	    : '*';
TILDE	    : '~';
SELF        : 'self';
SELF_TYPE   : 'SELF_TYPE';
CLASS       : ('c'|'C')('l'|'L')('a'|'A')('s'|'S')('s'|'S');
ELSE        : ('e'|'E')('l'|'L')('s'|'S')('e'|'E');
FI          : ('f'|'F')('i'|'I');
IF          : ('i'|'I')('f'|'F');
IN          : ('i'|'I')('n'|'N');
INHERITS    : ('i'|'I')('n'|'N')('h'|'H')('e'|'E')('r'|'R')('i'|'I')('t'|'T')('s'|'S');
ISVOID      : ('i'|'I')('s'|'S')('v'|'V')('o'|'O')('i'|'I')('d'|'D');
LET         : ('l'|'L')('e'|'E')('t'|'T');
LOOP        : ('l'|'L')('o'|'O')('o'|'O')('p'|'p');
POOL        : ('p'|'p')('o'|'O')('o'|'O')('l'|'L');
WHILE       : ('w'|'W')('h'|'H')('i'|'I')('l'|'L')('e'|'E');
THEN	    : ('t'|'T')('h'|'H')('e'|'E')('n'|'N');
CASE        : ('c'|'C')('a'|'A')('s'|'S')('e'|'E');
ESAC	    : ('e'|'E')('s'|'S')('a'|'A')('c'|'C');
NEW		    : ('n'|'N')('e'|'E')('w'|'W');
OF		    : ('o'|'O')('f'|'F');
NOT		    : ('n'|'N')('o'|'O')('t'|'T');
TRUE	    : 't'('r'|'R')('u'|'U')('e'|'E');
FALSE	    : 'f'('a'|'A')('l'|'L')('s'|'S')('e'|'E');
BOOL_CONST	: (TRUE|FALSE);
INT_CONST	: [0-9]+ ;
STR_CONST 	: '"' ( '\\' | ~('"'| '\n') | WHITESPACE )* '"' {processString();};
TYPEID		: [A-Z] [a-zA-Z0-9_]* ;
OBJECTID	: [a-z] [0-9_a-zA-z]* ;
WHITESPACE 	: [ \r\t\n\f]+ -> skip ;
COMMENT     : ('(*'(COMMENT|.)*?'*)')->skip;
CCOMMENT    : '(*' {reportError("EOF in comment");};
OCOMMENT	: '*)' {reportError("UnMatched comment identifier.");};
SL_COMMENT	: '--'(.)*? ('\n'|'\r') -> skip;
DIFFSTRING  : . {notmatched();}; 