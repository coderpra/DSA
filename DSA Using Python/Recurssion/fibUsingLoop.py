def fibUL(n):
    first_element=0
    secound_element=1
    next=n
    for i in range (2,n+1):
        next = first_element+secound_element
        first_element = secound_element
        secound_element = next
    return next

if __name__ == "__main__":
    # This code block will only run if this script is executed directly
    
    n = int(input("Enter the value for n: "))
    print(f"The {n}th Fibonacci number is {fibUL(n)}")