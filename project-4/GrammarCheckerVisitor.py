# Generated from antlr4-python3-runtime-4.7.2/src/autogen/Grammar.g4 by ANTLR 4.7.2
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .GrammarParser import GrammarParser
else:
    from GrammarParser import GrammarParser


import sys
err = sys.stderr.write
def printf(string, *args):
    sys.stdout.write(string % args)

import struct
import math

f = open("output.ll", "w")

# Função utilizada para transformar um valor float para um valor hexadecimal 
# (o equivalente em hexadecimal dos valores dos bits de um float)
def float_to_hex(f):
    float_hex = hex(struct.unpack("<Q", struct.pack("<d", f))[0])
    if (int(float_hex[10],16) % 2 != 0):
        if (float_hex[10] == "f"):
            float_hex = float(math.ceil(f))
        else:
            float_hex = float_hex[:10] + hex(int(float_hex[10],16) + 1)[2] + "0000000"

    else: 
        float_hex = float_hex[:11] + "0000000"
    return float_hex


# retorne Type.INT, etc para fazer checagem de tipos
class Type:
    VOID = "void"
    INT = "int"
    FLOAT = "float"
    STRING = "char *"

def llvm_type(tyype):
    if tyype == Type.VOID:
        return "void"
    if tyype == Type.INT:
        return "i32"
    if tyype == Type.FLOAT:
        return "float"


# This class defines a complete generic visitor for a parse tree produced by GrammarParser.
class GrammarCheckerVisitor(ParseTreeVisitor):
    ids_defined = {} # armazenar informações necessárias para cada identifier definido
    inside_what_function = ""
    next_ir_register = 0
    global_vars = []

    # Visit a parse tree produced by GrammarParser#fiile.
    def visitFiile(self, ctx:GrammarParser.FiileContext):
        result = self.visitChildren(ctx)
        f.close()
        return result

    # Visit a parse tree produced by GrammarParser#function_definition.
    def visitFunction_definition(self, ctx:GrammarParser.Function_definitionContext):
        tyype = ctx.tyype().getText()
        name = ctx.identifier().getText()

        params = self.visit(ctx.arguments())

        cte_value = None
        ir_register = []

        f.write("define " + llvm_type(tyype) + " @" + name + "(")
        
        for idx, param in enumerate(params):
            if idx >= 1:
                f.write(", ")
            f.write(llvm_type(param[0]) + " %" + str(idx))
        f.write(") {\n")
        for idx, alloc_param in enumerate(params):
            f.write("\t%" + alloc_param[1] + " = alloca " + llvm_type(alloc_param[0]) + ", align 4\n")
            f.write("\tstore " + llvm_type(alloc_param[0]) + " %" + str(idx) + ", " +  llvm_type(alloc_param[0]) + "* " + "%" + alloc_param[1] + ", align 4\n")
            self.ids_defined[alloc_param[1]] = alloc_param[0], [], None, alloc_param[1]
        
        self.ids_defined[name] = tyype, params, cte_value, ir_register
        self.inside_what_function = name
        self.next_ir_register = len(params) + 1
        self.visit(ctx.body())
        f.write("}\n\n")
        return


    # Visit a parse tree produced by GrammarParser#body.
    def visitBody(self, ctx:GrammarParser.BodyContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#statement.
    def visitStatement(self, ctx:GrammarParser.StatementContext):
        if ctx.RETURN() != None:
            token = ctx.RETURN().getPayload()
            function_type, params, cte_value, ir_register = self.ids_defined[self.inside_what_function]
            if ctx.expression() != None:
                tyype, cte_value, ir_register = self.visit(ctx.expression())
                if function_type == Type.INT and tyype == Type.FLOAT:
                    err("WARNING: possible loss of information returning float expression from int function '" + self.inside_what_function + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
                elif function_type != Type.VOID and tyype == Type.VOID:
                    err("ERROR: trying to return void expression from function '" + self.inside_what_function + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
                    exit(-1)
                elif function_type == Type.VOID and tyype != Type.VOID:
                    err("ERROR: trying to return a non void expression from void function '" + self.inside_what_function + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
                    exit(-1)

                if ir_register:
                    f.write("\tret {} %{}".format(llvm_type(tyype), ir_register) + "\n")
                elif tyype == Type.FLOAT and cte_value:
                    f.write("\tret {} {}".format(llvm_type(tyype), float_to_hex(cte_value)) + "\n")
                    pass
                elif cte_value:
                    f.write("\tret {} {}".format(llvm_type(tyype), str(cte_value)) + "\n")
                    pass
            elif function_type != Type.VOID:
                err("ERROR: trying to return void expression from function '" + self.inside_what_function + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
                exit(-1)
            else:
                f.write("\tret void\n")


        else:
            self.visitChildren(ctx)
        return


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
        tyype = ctx.tyype().getText()
        ir_register = None

        # identifiers
        for i in range(len(ctx.identifier())):
            name = ctx.identifier(i).getText()
            token = ctx.identifier(i).IDENTIFIER().getPayload()
            if ctx.expression(i) != None:
                if self.inside_what_function:
                    f.write("\t%" + name + " = alloca " + llvm_type(tyype) + ", align 4\n")
                    expr_type, cte_value, ir_register = self.visit(ctx.expression(i))
                    if tyype == Type.FLOAT and cte_value:
                        f.write("\tstore " + llvm_type(tyype) + " " + float_to_hex(cte_value) + ", " +  llvm_type(tyype) + "* %" + name + ", align 4\n")
                    elif cte_value:
                        f.write("\tstore " + llvm_type(tyype) + " " + str(int(cte_value)) + ", " + llvm_type(tyype) + "* %" + name + ", align 4\n")
                    elif ir_register:
                        f.write("\tstore " + llvm_type(tyype) +
                        " %" + str(ir_register) + ", " + llvm_type(tyype) + "* %" + name + ", align 4\n")
                    if expr_type == Type.VOID:
                        err("ERROR: trying to assign void expression to variable '" + name + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
                        exit(-1)
                    elif expr_type == Type.FLOAT and tyype == Type.INT:
                        err("WARNING: possible loss of information assigning float expression to int variable '" + name + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
                else:
                    expr_type, cte_value, ir_register = self.visit(ctx.expression(i))
                    self.global_vars.append(name)
                    if expr_type == Type.FLOAT:
                        f.write("@" + name +  " = global " + llvm_type(expr_type) +" "+ float_to_hex(cte_value)+"\n")
                    else:
                        f.write("@" + name + " = global " + llvm_type(expr_type) +" "+str(cte_value)+"\n")
                    pass
            else:
                # unitialized variables now get value 0
                cte_value = 0
                ir_register = self.next_ir_register
                self.next_ir_register += 1
            self.ids_defined[name] = tyype, -1, cte_value, ir_register # -1 means not a array, therefore no length here (vide 15 lines below)

        # arrays
        for i in range(len(ctx.array())):
            name = ctx.array(i).identifier().getText()
            token = ctx.array(i).identifier().IDENTIFIER().getPayload()

            array_length, _ = self.visit(ctx.array(i))
            if ctx.array_literal(i) != None:
                expr_types, cte_values_array, ir_registers_array = self.visit(ctx.array_literal(i))
                for j in range(len(expr_types)):
                    if expr_types[j] == Type.VOID:
                        err("ERROR: trying to initialize void expression to array '" + name + "' at index " + str(j) + " of array literal in line " + str(token.line) + " and column " + str(token.column) + "\n")
                        exit(-1)
                    elif expr_types[j] == Type.FLOAT and tyype == Type.INT:
                        err("WARNING: possible loss of information initializing float expression to int array '" + name + "' at index " + str(j) + " of array literal in line " + str(token.line) + " and column " + str(token.column) + "\n")
            else:
                # unitialized variables now get value 0
                cte_values_array = [0] * array_length
                ir_registers_array = [None] * array_length
            self.ids_defined[name] = tyype, array_length, cte_values_array, ir_registers_array

        return


    # Visit a parse tree produced by GrammarParser#variable_assignment.
    def visitVariable_assignment(self, ctx:GrammarParser.Variable_assignmentContext):
        op = ctx.OP.text
        # identifier assignment
        if ctx.identifier() != None:
            name = ctx.identifier().getText()
            token = ctx.identifier().IDENTIFIER().getPayload()
            try:
                tyype, _, cte_value, ir_register = self.ids_defined[name]
            except:
                err("ERROR: undefined variable '" + name + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
                exit(-1)
                return

        # array assignment
        else:
            name = ctx.array().identifier().getText()
            token = ctx.array().identifier().IDENTIFIER().getPayload()
            try:
                tyype, array_length, cte_values_array, ir_registers_array = self.ids_defined[name]
            except:
                err("ERROR: undefined array '" + name + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
                exit(-1)
            array_index_cte, array_index_ir = self.visit(ctx.array())
            if array_index_cte == None:
                cte_value = None
            else:
                if array_index_cte < 0 or array_index_cte >= array_length:
                    err("ERROR: array '" + name + "' index out of range in line " + str(token.line) + " and column " + str(token.column) + "\n")
                    exit(-1)
                else:
                    cte_value = cte_values_array[array_index_cte]
                    ir_register = ir_registers_array[array_index_cte]

        if op == "++" or op == "--":
            tyype, _, _, _ = self.ids_defined[name]
            ir_register = self.next_ir_register
            self.next_ir_register += 1
            f.write("\t%{} = load {}, {}* %{}, align 4".format(ir_register, llvm_type(tyype), llvm_type(tyype), name)+"\n")
            if cte_value != None:
                if op == "++":
                    cte_value += 1
                    process_operands(self, "add", ir_register, 1, None, Type.INT, tyype, name)
                elif op == "--":
                    cte_value -= 1
                    process_operands(self, "sub", ir_register, 1, None, Type.INT, tyype, name)
            else:
                if op == "++":
                    process_operands(self, "add", ir_register, 1, None, Type.INT, tyype, name)
                elif op == "--":
                    process_operands(self, "sub", ir_register, 1, None, Type.INT, tyype, name)
                cte_value = None
        else:
            expr_type, expr_cte_value, expr_ir_register = self.visit(ctx.expression())
            if expr_type == Type.VOID:
                err("ERROR: trying to assign void expression to variable '" + name + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
                exit(-1)
            elif expr_type == Type.FLOAT and tyype == Type.INT:
                err("WARNING: possible loss of information assigning float expression to int variable '" + name + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
            tyype, _, _, _ = self.ids_defined[name]
            if not self.ids_defined[name][3]:
                ir_register = self.next_ir_register
                self.next_ir_register += 1
                f.write("\t%{} = load {}, {}* %{}, align 4".format(ir_register, llvm_type(tyype), llvm_type(tyype), name)+"\n")
                self.ids_defined[name] = self.ids_defined[name][0], self.ids_defined[name][1], self.ids_defined[name][2], ir_register

            if op == "=":
                cte_value = expr_cte_value
                f.write("\tstore {} %{}, {}* %{}, align 4".format(llvm_type(tyype), ir_register, llvm_type(tyype), name)+"\n")
            if cte_value != None:
                if op == "+=":
                    cte_value += expr_cte_value
                    process_operands(self, "add", ir_register, expr_cte_value, expr_ir_register, expr_type, tyype, name)
                elif op == "-=":
                    cte_value -= expr_cte_value
                    process_operands(self, "sub", ir_register, expr_cte_value, expr_ir_register, expr_type, tyype, name)
                elif op == "*=":
                    cte_value *= expr_cte_value
                    process_operands(self, "mul", ir_register, expr_cte_value, expr_ir_register, expr_type, tyype, name)
                elif op == "/=":
                    cte_value /= expr_cte_value
                    process_operands(self, "sdiv", ir_register, expr_cte_value, expr_ir_register, expr_type, tyype, name)
           
        if ctx.identifier() != None:
            self.ids_defined[name] = tyype, -1, cte_value, ir_register
        else: # array
            if array_index_cte != None:
                cte_values_array[array_index_cte] = cte_value
                ir_registers_array[array_index_cte] = ir_register
            self.ids_defined[name] = tyype, array_length, cte_values_array, ir_registers_array

        return


    # Visit a parse tree produced by GrammarParser#expression.
    def visitExpression(self, ctx:GrammarParser.ExpressionContext):
        tyype = Type.VOID
        cte_value = None
        ir_register = None

        if len(ctx.expression()) == 0:

            if ctx.integer() != None:
                tyype = Type.INT
                cte_value = int(ctx.integer().getText())

            elif ctx.floating() != None:
                tyype = Type.FLOAT
                cte_value = float(ctx.floating().getText())

            elif ctx.string() != None:
                tyype = Type.STRING

            elif ctx.identifier() != None:
                name = ctx.identifier().getText()
                try:
                    tyype, _, cte_value, ir_register = self.ids_defined[name]
                    modifier = "%"
                    if name in self.global_vars:
                        modifier = "@"
                        cte_value = None
                        ir_register = None
                    search_register = [b for a, b in self.ids_defined[self.inside_what_function][3] if a == ctx.getText()]
                    if search_register:
                        ir_register = search_register[0]
                    elif not cte_value:
                        f.write("\t%" + str(self.next_ir_register) + " = load " + llvm_type(tyype) + ", " + llvm_type(tyype) + "* " +modifier + ctx.getText() + ", align 4\n")
                        self.ids_defined[self.inside_what_function][3].append((ctx.getText(), self.next_ir_register))
                        ir_register = self.next_ir_register
                        self.next_ir_register += 1
                except:
                    token = ctx.identifier().IDENTIFIER().getPayload()
                    err("ERROR: undefined variable '" + name + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
                    exit(-1)

            elif ctx.array() != None:
                name = ctx.array().identifier().getText()
                try:
                    tyype, array_length, cte_values_array, ir_registers_array = self.ids_defined[name]
                except:
                    token = ctx.array().identifier().IDENTIFIER().getPayload()
                    err("ERROR: undefined array '" + name + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
                    exit(-1)

                array_index_cte, array_index_ir = self.visit(ctx.array())
                if array_index_cte != None:
                    if array_index_cte < 0 or array_index_cte >= array_length:
                        err("ERROR:  array '" + name + "' index out of bounds in line " + str(token.line) + " and column " + str(token.column) + "\n")
                        exit(-1)
                    else:
                        cte_value = cte_values_array[array_index_cte]
                        ir_register = ir_registers_array[array_index_cte]

            elif ctx.function_call() != None:
                tyype, cte_value, ir_register = self.visit(ctx.function_call())

        elif len(ctx.expression()) == 1:

            if ctx.OP != None: #unary operators
                text = ctx.OP.text
                token = ctx.OP
                tyype, cte_value, ir_register = self.visit(ctx.expression(0))
                if tyype == Type.VOID:
                    err("ERROR: unary operator '" + text + "' used on type void in line " + str(token.line) + " and column " + str(token.column) + "\n")
                    exit(-1)
                elif cte_value != None:
                    if text == "-":
                        cte_value = -cte_value

            else: # parentheses
                tyype, cte_value, ir_register = self.visit(ctx.expression(0))


        elif len(ctx.expression()) == 2: # binary operators
            text = ctx.OP.text
            token = ctx.OP
            left_type, left_cte_value, left_ir_register = self.visit(ctx.expression(0))
            right_type, right_cte_value, right_ir_register = self.visit(ctx.expression(1))
            if left_type == Type.VOID or right_type == Type.VOID:
                err("ERROR: binary operator '" + text + "' used on type void in line " + str(token.line) + " and column " + str(token.column) + "\n")
                exit(-1)

            if text == "*" or text == "/" or text == "+" or text == "-":
                if left_type == Type.FLOAT or right_type == Type.FLOAT:
                    tyype = Type.FLOAT
                else:
                    tyype = Type.INT
                
                if text == "*":
                    cte_value, ir_register = process_operations(self, "mul", cte_value, left_type, right_type, left_ir_register, right_ir_register, left_cte_value, right_cte_value, tyype, ctx)
                elif text == "/":
                    cte_value, ir_register = process_operations(self, "div", cte_value, left_type, right_type, left_ir_register, right_ir_register, left_cte_value, right_cte_value, tyype, ctx)
                elif text == "+":
                    cte_value, ir_register = process_operations(self, "add", cte_value, left_type, right_type, left_ir_register, right_ir_register, left_cte_value, right_cte_value, tyype, ctx)
                elif text == "-":
                    cte_value, ir_register = process_operations(self, "sub", cte_value, left_type, right_type, left_ir_register, right_ir_register, left_cte_value, right_cte_value, tyype, ctx)
                if not (left_cte_value != None and right_cte_value != None):
                    cte_value = None
                
            else:
                tyype = Type.INT
                if left_cte_value != None and right_cte_value != None:
                    if text == "<":
                        if left_cte_value < right_cte_value:
                            cte_value = 1
                        else:
                            cte_value = 0
                    elif text == ">":
                        if left_cte_value > right_cte_value:
                            cte_value = 1
                        else:
                            cte_value = 0
                    elif text == "==":
                        if left_cte_value == right_cte_value:
                            cte_value = 1
                        else:
                            cte_value = 0
                    elif text == "!=":
                        if left_cte_value != right_cte_value:
                            cte_value = 1
                        else:
                            cte_value = 0
                    elif text == "<=":
                        if left_cte_value <= right_cte_value:
                            cte_value = 1
                        else:
                            cte_value = 0
                    elif text == ">=":
                        if left_cte_value >= right_cte_value:
                            cte_value = 1
                        else:
                            cte_value = 0
                else:
                    cte_value = None

        return tyype, cte_value, ir_register


    # Visit a parse tree produced by GrammarParser#array.
    def visitArray(self, ctx:GrammarParser.ArrayContext):
        tyype, cte_value, ir_register = self.visit(ctx.expression())
        if tyype != Type.INT:
            token = ctx.identifier().IDENTIFIER().getPayload()
            err("ERROR: array expression must be an integer, but it is " + str(tyype) + " in line " + str(token.line) + " and column " + str(token.column) + "\n")
            exit(-1)
        return cte_value, ir_register


    # Visit a parse tree produced by GrammarParser#array_literal.
    def visitArray_literal(self, ctx:GrammarParser.Array_literalContext):
        types_array = []
        cte_values_array = []
        ir_registers_array = []
        for i in range(len(ctx.expression())):
            tyype, cte_value, ir_register = self.visit(ctx.expression(i))
            types_array += [tyype]
            cte_values_array += [cte_value]
            ir_registers_array += [ir_register]
        return types_array, cte_values_array, ir_registers_array


    # Visit a parse tree produced by GrammarParser#function_call.
    def visitFunction_call(self, ctx:GrammarParser.Function_callContext):
        name = ctx.identifier().getText()
        token = ctx.identifier().IDENTIFIER().getPayload()
        display_string = ""
        try:
            tyype, args, cte_value, ir_register = self.ids_defined[name]
            if tyype == Type.VOID:
                display_string += "\tcall void @{}(".format(name)
            else:
                ir_register = self.next_ir_register
                display_string += "\t%{} = call {} @{}(".format(self.next_ir_register, llvm_type(tyype), name)
                self.next_ir_register += 1
                pass
            if len(args) != len(ctx.expression()):
                err("ERROR: incorrect number of parameters for function '" + name + "' in line " + str(token.line) + " and column " + str(token.column) + ". Expecting " + str(len(args)) + ", but " + str(len(ctx.expression())) + " were given" + "\n")
                exit(-1)
        except:
            err("ERROR: undefined function '" + name + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
            exit(-1)

        for i in range(len(ctx.expression())):
            arg_type, arg_cte_value, arg_ir_register = self.visit(ctx.expression(i))
            if i > 0:
                display_string += ", "
            
            if arg_cte_value:
                if arg_type == Type.FLOAT:
                    display_string += "{} {}".format(llvm_type(arg_type), float_to_hex(arg_cte_value))
                else:
                    display_string += "{} {}".format(llvm_type(arg_type), str(int(arg_cte_value)))
            else:
                display_string += "{} {}".format(llvm_type(arg_type), arg_ir_register)

            
            if i < len(args):
                if arg_type == Type.VOID:
                    err("ERROR: void expression passed as parameter " + str(i) + " of function '" + name + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
                    exit(-1)
                elif arg_type == Type.FLOAT and args[i] == Type.INT:
                    err("WARNING: possible loss of information converting float expression to int expression in parameter " + str(i) + " of function '" + name + "' in line " + str(token.line) + " and column " + str(token.column) + "\n")
        
        if display_string:
            display_string += ")"
            f.write(display_string+"\n")

        return tyype, cte_value, ir_register


    # Visit a parse tree produced by GrammarParser#arguments.
    def visitArguments(self, ctx:GrammarParser.ArgumentsContext):
        params = []
        cte_value = None
        for i in range(len(ctx.identifier())):
            tyype = ctx.tyype(i).getText()
            name = ctx.identifier(i).getText()
            ir_register = i
            self.ids_defined[name] = tyype, -1, cte_value, ir_register
            params += [(tyype, name)]
        return params


    # Visit a parse tree produced by GrammarParser#tyype.
    def visitTyype(self, ctx:GrammarParser.TyypeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#integer.
    def visitInteger(self, ctx:GrammarParser.IntegerContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#floating.
    def visitFloating(self, ctx:GrammarParser.FloatingContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#string.
    def visitString(self, ctx:GrammarParser.StringContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by GrammarParser#identifier.
    def visitIdentifier(self, ctx:GrammarParser.IdentifierContext):
        return self.visitChildren(ctx)

# HELPER FUNCTIONS:
def process_operands(self, action, ir_register, expr_cte_value, expr_ir_register, expr_type, tyype, name):
    ids_defined = self.ids_defined[self.inside_what_function][3]
    if expr_cte_value:
        if expr_type == Type.FLOAT:
            f.write("\t%{} = {} {} %{}, {}".format(self.next_ir_register, action, llvm_type(tyype), ir_register, float_to_hex(expr_cte_value))+"\n")
        else:
            f.write("\t%{} = {} {} %{}, {}".format(self.next_ir_register, action, llvm_type(tyype), ir_register, expr_cte_value)+"\n")
        ir_register = self.next_ir_register
        self.next_ir_register += 1
    elif expr_ir_register:
        f.write("\t%{} = {} {} %{}, %{}".format(self.next_ir_register, action, llvm_type(tyype), ir_register, expr_ir_register)+"\n")
        ir_register = self.next_ir_register
        self.next_ir_register += 1
    f.write("\tstore {} %{}, {}* %{}, align 4".format(llvm_type(tyype), ir_register, llvm_type(tyype), name)+"\n")
    return ir_register

def process_operations(self, op, cte_value, left_type, right_type, left_ir_register, right_ir_register, left_cte_value, right_cte_value, tyype, ctx):
    left = None
    right = None
    fcount = 0
    if left_type == Type.FLOAT or right_type == Type.FLOAT:
        fcount = 1
    if left_ir_register:
        left = "%{}".format(left_ir_register)
    elif left_type == Type.FLOAT or right_type == Type.FLOAT and left_cte_value:
        left = "{:.1f}".format(float(left_cte_value))
    elif left_cte_value:
        left = "{}".format(left_cte_value)
    if right_ir_register:
        right = "%{}".format(right_ir_register)
    elif right_type == Type.FLOAT or left_type == Type.FLOAT and right_cte_value:
        right = "{:.1f}".format(float(right_cte_value))
    elif right_cte_value:
        right = "{}".format(right_cte_value)
    if fcount > 0:
        op = "f"+op
    elif op == "div":
        op = "s"+op
    
    if left_type == Type.FLOAT or right_type == Type.FLOAT:
        if left_type != Type.FLOAT and left_ir_register != None:
            f.write("\t%{} = sitofp {} %{} to float".format(self.next_ir_register, llvm_type(left_type), left_ir_register)+"\n")
            left = "%{}".format(self.next_ir_register)
            self.next_ir_register += 1
        elif right_type != Type.FLOAT and right_ir_register != None:
            f.write("\t%{} = sitofp {} %{} to float".format(self.next_ir_register, llvm_type(right_type), right_ir_register)+"\n")
            right = "%{}".format(self.next_ir_register)
            self.next_ir_register += 1
    if left_cte_value != None and right_cte_value != None:
        if "mul" in op:
            cte_value = left_cte_value * right_cte_value
        elif "div" in op:
            cte_value = left_cte_value / right_cte_value
        elif "add" in op:
            cte_value = left_cte_value + right_cte_value
        elif "sub" in op:
            cte_value = left_cte_value - right_cte_value
        ir_register = None
    elif left and right:
        tp = llvm_type(tyype)
        ir_register = self.next_ir_register
        f.write ("\t%{} = {} {} {}, {}".format(ir_register, op, tp, left, right)+"\n")
        self.ids_defined[self.inside_what_function][3].append((ctx.getText(), self.next_ir_register))
        self.next_ir_register += 1

    return cte_value, ir_register