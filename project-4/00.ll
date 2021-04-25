; ModuleID = 'inputs/00.c'
source_filename = "inputs/00.c"
target datalayout = "e-m:o-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-apple-macosx10.15.0"

; Function Attrs: noinline nounwind optnone ssp uwtable
define i32 @square(i32 %0) #0 {
  %2 = alloca i32, align 4
  store i32 %0, i32* %2, align 4
  %3 = load i32, i32* %2, align 4
  %4 = load i32, i32* %2, align 4
  %5 = mul nsw i32 %3, %4
  ret i32 %5
}

; Function Attrs: noinline nounwind optnone ssp uwtable
define void @splash(i32 %0) #0 {
  %2 = alloca i32, align 4
  store i32 %0, i32* %2, align 4
  ret void
}

; Function Attrs: noinline nounwind optnone ssp uwtable
define float @ResDiv(float %0, float %1) #0 {
  %3 = alloca float, align 4
  %4 = alloca float, align 4
  %5 = alloca float, align 4
  store float %0, float* %3, align 4
  store float %1, float* %4, align 4
  %6 = load float, float* %3, align 4
  %7 = load float, float* %3, align 4
  %8 = load float, float* %4, align 4
  %9 = fadd float %7, %8
  %10 = fdiv float %6, %9
  store float %10, float* %5, align 4
  %11 = load float, float* %5, align 4
  ret float %11
}

; Function Attrs: noinline nounwind optnone ssp uwtable
define i32 @main() #0 {
  %1 = alloca i32, align 4
  %2 = alloca i32, align 4
  %3 = alloca i32, align 4
  %4 = alloca float, align 4
  %5 = alloca float, align 4
  %6 = alloca float, align 4
  %7 = alloca i32, align 4
  store i32 0, i32* %1, align 4
  store i32 8, i32* %2, align 4
  store i32 2, i32* %3, align 4
  %8 = load i32, i32* %2, align 4
  call void @splash(i32 %8)
  %9 = load i32, i32* %2, align 4
  %10 = sitofp i32 %9 to double
  %11 = fmul double 5.000000e+01, %10
  %12 = fptrunc double %11 to float
  store float %12, float* %4, align 4
  %13 = load i32, i32* %3, align 4
  %14 = sitofp i32 %13 to double
  %15 = fmul double 1.500000e+02, %14
  %16 = fptrunc double %15 to float
  store float %16, float* %5, align 4
  %17 = load float, float* %4, align 4
  %18 = load float, float* %5, align 4
  %19 = call float @ResDiv(float %17, float %18)
  store float %19, float* %6, align 4
  %20 = load i32, i32* %2, align 4
  %21 = load i32, i32* %3, align 4
  %22 = sdiv i32 %20, %21
  store i32 %22, i32* %7, align 4
  %23 = load i32, i32* %3, align 4
  %24 = sub nsw i32 2, %23
  %25 = mul nsw i32 3, %24
  %26 = add nsw i32 %25, 4
  %27 = load i32, i32* %7, align 4
  %28 = sdiv i32 %27, %26
  store i32 %28, i32* %7, align 4
  %29 = load i32, i32* %7, align 4
  %30 = add nsw i32 %29, 1
  %31 = call i32 @square(i32 %30)
  ret i32 %31
}

attributes #0 = { noinline nounwind optnone ssp uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "min-legal-vector-width"="0" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="true" "stack-protector-buffer-size"="8" "target-cpu"="penryn" "target-features"="+cx16,+cx8,+fxsr,+mmx,+sahf,+sse,+sse2,+sse3,+sse4.1,+ssse3,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.module.flags = !{!0, !1}
!llvm.ident = !{!2}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{i32 7, !"PIC Level", i32 2}
!2 = !{!"clang version 11.0.0"}
