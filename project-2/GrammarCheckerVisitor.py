# Generated from antlr4-python3-runtime-4.7.2/src/autogen/Grammar.g4 by ANTLR 4.7.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .GrammarParser import GrammarParser
else:
    from GrammarParser import GrammarParser

# This class defines a complete generic visitor for a parse tree produced by GrammarParser.

'''
COMO RESGATAR INFORMAÇÕES DA ÁRVORE

Observe o seu Grammar.g4. Cada regra sintática gera uma função com o nome corespondente no Visitor e na ordem em que está na gramática.

Se for utilizar sua gramática do projeto 1, por causa de conflitos com Python, substitua as regras file por fiile e type por tyype. Use prints temporários para ver se está no caminho certo.  
"make tree" agora desenha a árvore sintática, se quiser vê-la para qualquer input, enquanto "make" roda este visitor sobre o a árvore gerada a partir de Grammar.g4 alimentada pelo input.

Exemplos:

# Obs.: Os exemplos abaixo utilizam nós 'expression', mas servem apra qualquer tipo de nó

self.visitChildren(ctx) # visita todos os filhos do nó atual
expr = self.visit(ctx.expression())  # visita a subárvore do nó expression e retorna o valor retornado na função "visitRegra"

for i in range(len(ctx.expression())): # para cada expressão que este nó possui...
    ident = ctx.expression(i) # ...pegue a i-ésima expressão


if ctx.FLOAT() != None: # se houver um FLOAT (em vez de INT ou VOID) neste nó (parser)
    return Type.FLOAT # retorne tipo float

ctx.identifier().getText()  # Obtém o texto contido no nó (neste caso, será obtido o nome do identifier)

token = ctx.identifier(i).IDENTIFIER().getPayload() # Obtém o token referente à uma determinada regra léxica (neste caso, IDENTIFIER)
token.line      # variável com a linha do token
token.column    # variável com a coluna do token
'''


# Dica: Retorne Type.INT, Type.FLOAT, etc. Nos nós e subnós das expressões para fazer a checagem de tipos enquanto percorre a expressão.
class Type:
    VOID = "void"
    INT = "int"
    FLOAT = "float"
    STRING = "char *"

class GrammarCheckerVisitor(ParseTreeVisitor):
    ids_defined = {} # Dicionário para armazenar as informações necessárias para cada identifier definido
    inside_what_function = "" # String que guarda a função atual que o visitor está visitando. Útil para acessar dados da função durante a visitação da árvore sintática da função.

    # Visit a parse tree produced by GrammarParser#fiile.
    def visitFiile(self, ctx:GrammarParser.FiileContext):
        return self.visitChildren(ctx)


     # Visit a parse tree produced by GrammarParser#function_definition.
    def visitFunction_definition(self, ctx:GrammarParser.Function_definitionContext):
        tyype = ctx.tyype().getText()
        name = ctx.identifier().getText()
        params = self.visit(ctx.arguments())
        self.ids_defined[name] = tyype, params, None
        self.inside_what_function = name
        self.visit(ctx.body())
        return


    # Visit a parse tree produced by GrammarParser#body.
    def visitBody(self, ctx:GrammarParser.BodyContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#statement.
    def visitStatement(self, ctx:GrammarParser.StatementContext):
        ret = ctx.RETURN()
        if(ret != None):
            expression_tyype = self.visit(ctx.expression())
            function_tyype = self.ids_defined[self.inside_what_function][0]
            if(function_tyype != expression_tyype):
                token = ret.getPayload()
                line = token.line
                column = token.column
                if(function_tyype == Type.VOID):
                    print(f"ERROR: trying to return a non void expression from void function '{self.inside_what_function}' in line {line} and column {column}")
                elif(expression_tyype == Type.VOID):
                    print(f"ERROR: trying to return void expression from function '{self.inside_what_function}' in line {line} and column {column}")
                
                

            return

            

        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#if_statement.
    def visitIf_statement(self, ctx:GrammarParser.If_statementContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#else_statement.
    def visitElse_statement(self, ctx:GrammarParser.Else_statementContext):
     
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#for_loop.
    def visitFor_loop(self, ctx:GrammarParser.For_loopContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#for_initializer.
    def visitFor_initializer(self, ctx:GrammarParser.For_initializerContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#for_condition.
    def visitFor_condition(self, ctx:GrammarParser.For_conditionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#for_step.
    def visitFor_step(self, ctx:GrammarParser.For_stepContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#variable_definition.
    def visitVariable_definition(self, ctx:GrammarParser.Variable_definitionContext):
        for i in range(len(ctx.identifier())):
            token = ctx.identifier(i).IDENTIFIER().getPayload()
            variable_name = ctx.identifier(i).getText()
            variable_type = ctx.tyype().getText()
            expression_type = self.visitExpression(ctx.expression(i)) 
            
            if(variable_type == Type.INT and expression_type == Type.FLOAT):
                print(f"WARNING: possible loss of information assigning float expression to int variable '{variable_name}' in line {token.line} and column {token.column}")

        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#variable_assignment.
    def visitVariable_assignment(self, ctx:GrammarParser.Variable_assignmentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#expression.
    def visitExpression(self, ctx:GrammarParser.ExpressionContext):
        tyype = Type.VOID
        if len(ctx.expression()) == 0:
            if ctx.integer() != None:
                tyype = Type.STRING
            elif ctx.floating() != None:
                tyype = Type.FLOAT
            elif ctx.string() != None:
                tyype = Type.STRING
            elif ctx.identifier() != None:  
                text = ctx.identifier().getText()
                token = ctx.identifier().IDENTIFIER().getPayload()
                tyype = self.ids_defined.get(text, Type.VOID)
        elif len(ctx.expression()) == 1:
            if ctx.OP != None:
                text = ctx.OP.text
                token = ctx.OP
                tyype = self.visit(ctx.expression()[0])
            else:
                tyype = self.visit(ctx.expression()[0])
        elif len(ctx.expression()) == 2:
            text = ctx.OP.text
            token = ctx.OP
            #print("Binary Operator: '" + text + "' => line: " + str(token.line) + " , col: " + str(token.column))
            left = self.visit(ctx.expression()[0])
            right = self.visit(ctx.expression()[1])
            # if ctx.OP.text in ['<', '<=', '==', '>=', '>', '!=']:
            #     # if left != right:
            #     #     # print("[ERROR]::[Good lord, what were you thinking trying to do a '{} {} {}' operation? Please, fix that type error. But do it right this time, yes?] ({},{})".format(left, ctx.OP.text, right, str(token.line), str(token.column)))
            # elif ctx.OP.text in ['+', '-', '*', '/']:
            #     if not(left == right or (left == Type.INT and right == Type.FLOAT)):
            #         #print("left = {}".format(left))
            #         #print("right = {}".format(right))
            #         #print(self.ids_defined)
            #         # print("[ERROR]::[Good lord, what were you thinking trying to do a '{} {} {}' operation? Please, fix that type error. But do it right this time, yes?] ({},{})".format(left, ctx.OP.text, right, str(token.line), str(token.column)))
            tyype = right

        return tyype


    # Visit a parse tree produced by GrammarParser#array.
    def visitArray(self, ctx:GrammarParser.ArrayContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#array_literal.
    def visitArray_literal(self, ctx:GrammarParser.Array_literalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#function_call.
    def visitFunction_call(self, ctx:GrammarParser.Function_callContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#arguments.
    def visitArguments(self, ctx:GrammarParser.ArgumentsContext):
        # print("Arguments: ", ctx.tyype()[0].getText())
        for i in range(len(ctx.tyype())): # para cada expressão que este nó possui...
            currentItem = ctx.identifier()[i].IDENTIFIER().getText()   
            self.ids_defined[currentItem] = (ctx.tyype()[i].getText())
    

        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#tyype.
    def visitTyype(self, ctx:GrammarParser.TyypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#integer.
    def visitInteger(self, ctx:GrammarParser.IntegerContext):
        return Type.INTEGER


    # Visit a parse tree produced by GrammarParser#floating.
    def visitFloating(self, ctx:GrammarParser.FloatingContext):
        return Type.FLOAT


    # Visit a parse tree produced by GrammarParser#string.
    def visitString(self, ctx:GrammarParser.StringContext):
        return Type.STRING


    # Visit a parse tree produced by GrammarParser#identifier.
    def visitIdentifier(self, ctx:GrammarParser.IdentifierContext):
        return self.visitChildren(ctx)

