#Cannot directly add elements to a tupple so created a list and then converted to a tupple

list1 = []
limit = int(input("Enter the limit: "))
print("Enter the number: ")
for x in range(0,limit):
    num = int(input())
    list1.append(num)

number=tuple(list1)

x = "Elements in tupple: {}"
print(x.format(number))

print("Elements divisible by 5: ")
for num in number:
    if(num%5 == 0):
        print(num)