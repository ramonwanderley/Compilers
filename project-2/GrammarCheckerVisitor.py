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
                elif(function_tyype == Type.INT and expression_tyype == Type.FLOAT):
                    print(f"WARNING: possible loss of information returning {expression_tyype} expression from {function_tyype} function '{self.inside_what_function}' in line {line} and column {column}")
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
            variable_name = ctx.identifier(i).getText()
            variable_type = ctx.tyype().getText()
            expression_type = self.visitExpression(ctx.expression(i)) 

            self.ids_defined[variable_name] = ctx.tyype().getText()

            token = ctx.identifier(i).IDENTIFIER().getPayload()

            if(variable_type == Type.INT and expression_type == Type.FLOAT):
                print(f"WARNING: possible loss of information assigning float expression to int variable '{variable_name}' in line {token.line} and column {token.column}")
            elif(expression_type == Type.STRING and variable_type != Type.STRING):
                print(f"ERROR: trying to assign '{expression_type}' expression to variable '{variable_name}' in line {token.line} and column {token.column}")
            elif(expression_type == Type.VOID and variable_type != Type.VOID):
                print(f"ERROR: trying to assign '{expression_type}' expression to variable '{variable_name}' in line {token.line} and column {token.column}")
    
        for i in range(len(ctx.array())):
            variable_name = ctx.array(i).identifier().getText()
            variable_type = ctx.tyype().getText()

            self.ids_defined[variable_name] = variable_type
            
            token = ctx.array(i).identifier().IDENTIFIER().getPayload()
            
            if(len(ctx.array_literal()) != 0):
                for j in range(len(ctx.array_literal(i).expression())):
                    expression_type = self.visitExpression(ctx.array_literal(i).expression(j))
                    if(variable_type != expression_type):
                        if(expression_type == Type.STRING):
                            print(f"ERROR: trying to initialize '{expression_type}' expression to '{variable_type}' array '{variable_name}' at index {j} of array literal in line {token.line} and column {token.column}")
                        elif(variable_type == Type.INT and expression_type == Type.FLOAT):
                            print(f"WARNING: possible loss of information initializing {expression_type} expression to {variable_type} array '{variable_name}' at index {j} of array literal in line {token.line} and column {token.column}")
                        elif(expression_type == Type.VOID):
                            print(f"ERROR: trying to assign '{variable_type}' expression to array variable '{variable_name}' at index {j} in line {token.line} and column {token.column}")
        return


    # Visit a parse tree produced by GrammarParser#variable_assignment.
    def visitVariable_assignment(self, ctx:GrammarParser.Variable_assignmentContext):
        if(ctx.identifier() != None):
            variable_name = ctx.identifier().getText()
            token = ctx.identifier().IDENTIFIER().getPayload()
        else:
            variable_name = ctx.array().identifier().getText()
            token = ctx.array().identifier().IDENTIFIER().getPayload()

        if(self.inside_what_function):
            params = self.ids_defined[self.inside_what_function][1]
            defined_ids = list(map(lambda x: x[0], params))
            if(variable_name in defined_ids):
                if(ctx.expression() != None):
                    self._process_variable_assignment_error(ctx, variable_name, token)
                return 

        if(self.ids_defined.get(variable_name) == None):
            print(f"ERROR: undefined variable '{variable_name}' in line {token.line} and column {token.column}")
       
        if(ctx.expression() != None):
            self._process_variable_assignment_error(ctx, variable_name, token)
            return
        
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#expression.
    def visitExpression(self, ctx:GrammarParser.ExpressionContext):
        if len(ctx.expression()) == 0:
            if ctx.integer() != None:
                return Type.INT
            elif ctx.floating() != None:
                return Type.FLOAT
            elif ctx.string() != None:
                return Type.STRING
            elif ctx.identifier() != None:  
                variable_name = ctx.identifier().getText()
                return self._variable_type(variable_name)
            elif ctx.array() != None:
                return self.visit(ctx.array())
            elif ctx.function_call() != None:
                function_call = self.visit(ctx.function_call())
                return function_call
        elif len(ctx.expression()) == 1:
            return self.visit(ctx.expression()[0])
        elif len(ctx.expression()) == 2:
            left = self.visit(ctx.expression()[0])
            right = self.visit(ctx.expression()[1])
            # print("hello: ",left, right)
            if(left == Type.FLOAT or right == Type.FLOAT):
                return Type.FLOAT
            elif(left == Type.VOID or right == Type.VOID):
                OP = ctx.OP.text
                token = ctx.OP
                line = token.line
                column = token.column
                print(f"ERROR: binary operator '{OP}' used on type void in line {line} and column {column}")  
            return Type.INT
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#array.
    def visitArray(self, ctx:GrammarParser.ArrayContext):
        array_name = ctx.identifier().getText()
        array_type = self._variable_type(array_name)
        token = ctx.identifier().IDENTIFIER().getPayload()

        if(array_type is Type.VOID):
            print(f"ERROR: undefined array '{array_name}' in line {token.line} and column {token.column}")

        index_type = self.visit(ctx.expression())
        if index_type != Type.INT:
            print(f"ERROR: array expression must be an integer, but it is {index_type} in line {token.line} and column {token.column}")
        
        return array_type


    # Visit a parse tree produced by GrammarParser#array_literal.
    def visitArray_literal(self, ctx:GrammarParser.Array_literalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#function_call.
    def visitFunction_call(self, ctx:GrammarParser.Function_callContext):
        function_name = ctx.identifier().getText()
        typpe_function, params, a = self.ids_defined[function_name]

        token = ctx.identifier().IDENTIFIER().getPayload()

        given_params_length = len(ctx.expression())
        expected_params_length = len(params)
        if(given_params_length != expected_params_length):
            print(f"ERROR: incorrect number of parameters for function '{function_name}' in line {token.line} and column {token.column}. Expecting {expected_params_length}, but {given_params_length} were given")
            
        for i in range(len(params)):
            tyype_param_in_call =  self.visitExpression(ctx.expression()[i])
            tyype_param = params[i][1]
            line = token.line
            column = token.column
            if(tyype_param == Type.INT and tyype_param_in_call == Type.FLOAT):
                print(f"WARNING: possible loss of information converting float expression to int expression in parameter {i} of function '{function_name}' in line {line} and column {column}")

        
        return  typpe_function


    # Visit a parse tree produced by GrammarParser#arguments.
    def visitArguments(self, ctx:GrammarParser.ArgumentsContext):
        # print("Arguments: ", ctx.tyype()[0].getText())
        params = []
        for i in range(len(ctx.tyype())):
            currentItem = ctx.identifier()[i].IDENTIFIER().getText()  
            # print("currentItem: ", currentItem , ctx.tyype()[i].getText()) 
            # self.ids_defined[currentItem] = (ctx.tyype()[i].getText())
            params.append((currentItem, ctx.tyype()[i].getText() ))
        self.visitChildren(ctx)
        return params


    # Visit a parse tree produced by GrammarParser#tyype.
    def visitTyype(self, ctx:GrammarParser.TyypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#integer.
    def visitInteger(self, ctx:GrammarParser.IntegerContext):
        return Type.INT


    # Visit a parse tree produced by GrammarParser#floating.
    def visitFloating(self, ctx:GrammarParser.FloatingContext):
        return Type.FLOAT


    # Visit a parse tree produced by GrammarParser#string.
    def visitString(self, ctx:GrammarParser.StringContext):
        return Type.STRING


    # Visit a parse tree produced by GrammarParser#identifier.
    def visitIdentifier(self, ctx:GrammarParser.IdentifierContext):
        return self.visitChildren(ctx)

    def _process_variable_assignment_error(self, ctx, variable_name, token):
        variable_type = self._variable_type(variable_name)
        expression_type = self.visit(ctx.expression())

        if(variable_type == Type.INT and expression_type == Type.FLOAT):
            print(f"WARNING: possible loss of information assigning float expression to int variable '{variable_name}' in line {token.line} and column {token.column}")
        elif(expression_type == Type.STRING and variable_type != Type.STRING):
            if(ctx.array() != None):
                index = ctx.array().expression().getText()
                print(f"ERROR: trying to assign 'char *' expression to array '{variable_name}' at index {index} in line {token.line} and column {token.column}")
            else:
                print(f"ERROR: trying to assign 'char *' expression to variable '{variable_name}' in line {token.line} and column {token.column}")
    
    def _variable_type(self, variable_name):
        if(self.inside_what_function):
            params = self.ids_defined[self.inside_what_function][1]
            defined_ids = list(map(lambda x: x[0], params))
            if(variable_name in defined_ids):
                i = defined_ids.index(variable_name)
                return params[i][1]
        return self.ids_defined.get(variable_name, Type.VOID)