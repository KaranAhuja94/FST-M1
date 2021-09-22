elements = []
sum = 0
limit = int(input("Enter the number of elements: "))
print("Enter a number: ")
for i in range(0,limit):
    number = int(input())
    elements.append(number)  

print(elements)

for element in elements:
    sum+=element

result = "Sum of all elements from list {}"
print(result.format(sum))