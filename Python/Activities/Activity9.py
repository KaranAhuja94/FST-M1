evenList = [4,9,5,6,10,3]
oddList = [5,7,10,12,21,26]
thirdList = []

x = "List 1: {}"
print(x.format(evenList))

y = "List 2: {}"
print(y.format(oddList))

for i in evenList:
    if(i%2 == 0):
        thirdList.append(i)

for j in oddList:
    if(j%2 != 0):
        thirdList.append(j)

z = "List 3: {}"
print(z.format(thirdList))