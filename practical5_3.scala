object Day5three {

  def Fibonacci(count: Int):Int = {
    if (count <= 0) 0
    else if (count==1) 1
    else Fibonacci(count-1)+ Fibonacci(count -2)

  }
  def printFibonacciSequence(count: Int): Unit = {
    // this is a for loop for 0 to count-1
    for (i <- 0 until count) {
      print(Fibonacci(i) + " ")
    }
    println()
  }

  def main(args: Array[String]): Unit = {
    printFibonacciSequence(5)
  }
}