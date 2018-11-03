val sum3 = (a: Int, b: Int, c: Int) => a + b + c

val sum2 = sum3(1, _, _)

sum2(10, 20)

val sum = sum2(2, _: Int)

sum(10)