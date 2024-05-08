def fibUR(n):
    if(n>-1 and n<2):
        return n
    return fibUR(n-1)+fibUR(n-2)

if __name__ == "__main__":
    # This code block will only run if this script is executed directly
    
    n = int(input("Enter the value for n: "))
    print(f"The {n}th Fibonacci number is {fibUR(n)}")