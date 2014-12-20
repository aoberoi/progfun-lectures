// can we get rid of repeating the parameters in the sumX funcs from before?

//def sum(f: Int => Int): (Int, Int) => Int = {
//  def sumF(a: Int, b: Int): Int =
//    if (a > b) 0
//    else f(a) + sumF(a + 1, b)
//  sumF
//}

//def fact(x: Int): Int = {
//  def loop(acc: Int, x: Int): Int =
//    if (x == 1) acc else loop(acc * x, x - 1)
//  loop(1, x)
//}

//def sumInts = sum(x => x)
//def sumCubes = sum(x => x * x * x)
//def sumFactorials = sum(fact)

def cube(x: Int) = x * x * x

//sumCubes(1, 10)
//sum(cube)(1, 10)

// syntactic sugar for function that returns a function

//def sum(f: Int => Int)(a: Int, b: Int): Int = {
//  if (a > b) 0
//  else f(a) + sum(f)(a + 1, b)
//}

//def product(f: Int => Int)(a: Int, b: Int): Int = {
//  if (a > b) 1
//  else f(a) * product(f)(a + 1, b)
//}

//def fact(x: Int): Int = product(x => x)(1, x)

// can we generalize both sum and product?

def mapReduce(f: Int => Int)(unit: Int, comb: (Int, Int) => Int)(a: Int, b: Int): Int =
  if (a > b) unit
  else comb(f(a), mapReduce(f)(unit, comb)(a + 1, b))

def sum(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f)(0, (x, y) => x + y)(a, b)

def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f)(1, (x, y) => x * y)(a, b)

def fact(x: Int): Int = product(x => x)(1, x)

fact(5)