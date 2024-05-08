import fibUsingLoop as ful
import fibUsingRecurssion as fur
import OptimizedFibUsingRecurssion as ofur

n = int(input("Enter the value for n : "))

print(f"The {n}th fib number using loop is",ful.fibUL(n))
print(f"The {n}th fib number using loop is",ofur.fib(n))
print(f"The {n}th fib number using recursion is",fur.fibUR(n))
