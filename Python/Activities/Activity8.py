number = []
limit = int(input("Enter the limit: "))
print("Enter the number: ")
for x in range(0,limit):
    num=int(input())
    number.append(num)

print("List elements:")
print(number)

a = number[0]
b = number[-1]

if(a == b):
    print("True")
else:
    print("False")