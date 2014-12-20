// functions are first class values

//def sumInts(a: Int, b: Int): Int =
//  if (a > b) 0 else a + sumInts(a + 1, b)
//
//sumInts(3, 7)
//
//def cube(x: Int): Int = x * x * x
//
//def sumCubes(a: Int, b: Int): Int =
//  if (a > b) 0 else cube(a) + sumCubes(a + 1, b)
//
//sumCubes(3, 7)
//
def fact(x: Int): Int = {
  def loop(acc: Int, x: Int): Int =
    if (x == 1) acc else loop(acc * x, x - 1)
  loop(1, x)
}
//
//def sumFactorials(a: Int, b: Int): Int =
//  if (a > b) 0 else fact(a) + sumFactorials(a + 1, b)
//
//sumFactorials(3, 7)

// all of the above are special cases of summation from a to b of f(i)

//def id(x: Int): Int = x

// reuse the pattern and separate the part that is different

//def sum(f: Int => Int, a: Int, b: Int): Int =
//  if (a > b) 0
//  else f(a) + sum(f, a + 1, b)

//def sumInts(a: Int, b: Int): Int = sum(id, a, b)
//def sumCubes(a: Int, b: Int): Int = sum(cube, a, b)
//def sumFactorials(a: Int, b: Int): Int = sum(fact, a, b)

// we can make this less code if we use a "function literal" or an
// anonymous function

//def sumInts(a: Int, b: Int): Int = sum(x => x, a, b)
//def sumCubes(a: Int, b: Int): Int = sum(x => x * x * x, a, b)

// the previous def of sum is linearly recursive (may cause stack overflow
// if the difference between a and b is great enough). can we write a
// tail recursive version?

def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int =
    if (a > b) acc
    else loop(a + 1, f(a) + acc)
  loop(a, 0)
}

def sumInts(a: Int, b: Int): Int = sum(x => x)(a, b)
def sumCubes(a: Int, b: Int): Int = sum(x => x * x * x)(a, b)
def sumFactorials(a: Int, b: Int): Int = sum(fact)(a, b)

sumInts(3, 7)
sumCubes(3, 7)
sumFactorials(3, 7)


