/* nome da gramática -- deve ser o mesmo nome do arquivo .g4 e começar com letra maiúscula*/
/* 
Projeto 1 de Compiladores - CIn | UFPE
Autor: RJVW - Ramon Jorge Valença Wanderley */

grammar Grammar;

/* parser */
/* regra raiz */
file : (variable_definition ';' | function_definition) +;

TYPE_INT:'int';
TYPE_FLOAT:'float';

identifier: IDENTIFIER;
integer: INT;
floating: FLOAT;
string: STRING;
array:  identifier '[' expression ']';

array_literal: '{' expression (',' expression)*'}';

variable_definition: type (identifier | array) '=' (expression | array_literal) (',' (identifier | array) '=' (expression | array_literal) )*;

type: TYPE_INT | TYPE_FLOAT;

function_definition: type  identifier  arguments  body ;

body: '{' statement* '}' ;

arguments: '(' (type identifier)? (',' type identifier)* ')';
	
argumentsType:  type identifier;

function_call: identifier '(' expression (',' expression )* ')' ;

variable_assignment:  (identifier ('*='| '/=' | '+=' | '=' | '-=') expression) |
	identifier('++'|'--');


for_loop: 'for' '(' for_initializer? ';' for_condition? ';' for_step? ')' body;

for_initializer: (variable_definition);

for_condition: (expression);

for_step: (variable_assignment);

if_statement: 'if' '(' expression ')' ( body | statement ) else_statement*;

else_statement: 'else' (body | statement);

expression: 
	identifier |
	array |
	floating |
	integer |
	string |
	expression ( '*'| '/') expression | 
	expression ('+'| '-') expression |
	('+'| '-') expression |
	expression ('<=' | '==' | '>=' | '<'| '>' | ) expression |
	'(' expression ')' |
	function_call
	;

statement: 
	( variable_assignment ';' | for_loop | if_statement | variable_definition ';' | 'return' expression?';' | expression';' ) ; 

/* lexer */  
fragment NUMBER : [0-9];
QUOTE: '"';

COMMENT_BLOCK: '/*' .*? '*/' -> skip;
COMMENT_LINE: '//' .*? '\n' -> skip;
LIB: '#' .*? '\n' -> skip;
WHITESPACE: [\r\t\n]+ -> skip;

INT: NUMBER+;
FLOAT: NUMBER+ '.' NUMBER+;
IDENTIFIER: [a-zA-Z_]+[a-zA-Z0-9]*;
STRING: QUOTE .*? QUOTE;

DEFAULT: .+? -> skip;

/*
MANUAL

caracteres especiais para expressões regulares {
	'xyz'   :  os caracteres rodeados por ' ' são interpretados literalmente 
	\x		:  altera a interpretação do caracter x, se ele tiver outra (\t: tab, \(: o caracter que abre parênteses)
	a(bc)d  :  destaca a subexpressão bc
	x | y   :  aceita a subexpressão x ou y
	[x\yz]	:  equivalente a ('x'|\y|'z'), tal que x, \y e z são caracteres
	[x]		:  equivalente a 'x'
	x*		:  aceita 0 ou mais x's
	x+		:  aceita 1 ou mais x's
	x?		:  aceita 0 ou 1 x
	.       :  aceita qualquer caracter
	.*      :  aceita 0 ou mais caracteres diferentes de \n (guloso)
	.*?     :  aceita 0 ou mais caracteres diferentes de \n (não-guloso)

	regex -> skip : qualquer instância da expressão regular regex não é passada para o parser, sendo assim ignorada (usado em comentários, espaços em branco, ou (no caso deste exercício) diretivas de preprocessamento)


	no ANTLR alguns desses caracteres especiais podem ser utilizados nas regras da gramática também
	ex.:
		expr ('+'|'-') expr
	estabelece que os dois sinais têm a mesma precedência
		'(' (expr (',' expr)*)? ')'
	indica que dentro destes parênteses pode haver zero ou mais expressões separadas por vírgulas
}

regras da gramática {
	nome_da_regra
		: uma seqüência de regras que satisfazem esta
		| outra
		| e mais outra
		;

	NOME_DA_EXPRESSÃO_REGULAR : a_expressão_regular ;

	dentro de uma regra a primeira opção tem maior precedência (útil em expressões matemáticas)
}
*/
