define i32 @half(i32 %0) {
	%x = alloca i32, align 4
	store i32 %0, i32* %x, align 4
	%2 = load i32, i32* %x, align 4
	%3 = sdiv i32 %2, 2
	ret i32 %3
}

define i32 @scalar(i32 %0, i32 %1) {
	%a = alloca i32, align 4
	store i32 %0, i32* %a, align 4
	%b = alloca i32, align 4
	store i32 %1, i32* %b, align 4
	%3 = load i32, i32* %b, align 4
	%4 = load i32, i32* %b, align 4
	%5 = add i32 %4, 1
	store i32 %5, i32* %b, align 4
	%7 = load i32, i32* %a, align 4
	%8 = mul i32 %7, %7
	%9 = add i32 %8, %3
	%10 = sub i32 %3, %7
	%11 = mul i32 %10, %3
	%12 = add i32 %9, %11
	%6 = call i32 @half(i32 12)
	%13 = add i32 %6, 3
	%14 = sdiv i32 %13, 2
	ret i32 %14
}

define float @fscalar(float %0, float %1) {
	%a = alloca float, align 4
	store float %0, float* %a, align 4
	%b = alloca float, align 4
	store float %1, float* %b, align 4
	%result = alloca float, align 4
	%3 = load float, float* %a, align 4
	%4 = load float, float* %b, align 4
	%5 = fadd float %3, %4
	%6 = fsub float %3, %4
	%7 = fdiv float %5, %6
	%8 = fmul float %3, %4
	%9 = fmul float %7, %8
	%10 = fdiv float %3, %4
	%11 = fdiv float %9, %10
	store float %11, float* %result, align 4
	%12 = load float, float* %result, align 4
	ret float %12
}

define i32 @main() {
	%quantas_trincas = alloca i32, align 4
	store i32 33, i32* %quantas_trincas, align 4
	%valor1 = alloca i32, align 4
	store i32 821, i32* %valor1, align 4
	%tk2 = alloca i32, align 4
	store i32 1, i32* %tk2, align 4
	%tk0 = alloca i32, align 4
	store i32 -1, i32* %tk0, align 4
	%1 = call i32 @scalar(i32 32, i32 821)
	%2 = sub i32 %1, -1
	%3 = load i32, i32* %valor1, align 4
	store i32 %3, i32* %valor1, align 4
	%4 = load i32, i32* %valor1, align 4
	ret i32 %4
}

