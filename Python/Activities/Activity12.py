def sum(num):
    if(num<=1):
        return num
    else:
        return num + sum(num-1)

number = int(input("Enter a number: "))
print("Sum: ",sum(number))