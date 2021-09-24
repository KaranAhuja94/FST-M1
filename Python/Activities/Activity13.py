def sum(num=[]):
    result = 0
    for x in num:
        result+=x
    return result

numbers = []
limit = int(input("Enter the limit: "))
print("Enter the numbers: ")
for x in range(0,limit):
    num = int(input())
    numbers.append(num)

number = "Elements in list : {}"
print(number.format(numbers))

print("Sum of numbers from list: ", sum(numbers))