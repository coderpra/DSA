def optimized_fib_using_recurssion(n, arr):

    if(n<0): 
        return "Wrong Input!!"
    
    if(n>-1 and n<2):
        return n
    
    if arr[n] ==0:
        arr[n] = optimized_fib_using_recurssion(n-1, arr) + optimized_fib_using_recurssion(n-2, arr)
    return arr[n]
    
def fib(n):
    arr = [0]*(n+1)
    arr[1] = 1
    return optimized_fib_using_recurssion(n,arr)

if __name__ == "__main__":
    # This code block will only run if this script is executed directly
    
    n = int(input("Enter the value for n: "))
    print(f"The {n}th Fibonacci number is {fib(n)}")