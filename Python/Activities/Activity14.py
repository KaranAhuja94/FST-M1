def fibonacci(limit):
    a,b=1,1
    i=0
    while i < limit:
        print(a)
        result = a+b
        a=b
        b=result
        i+=1

number = int(input("Enter the limit:"))        
fibonacci(number)
