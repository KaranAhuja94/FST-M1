fruits = {"Apple": 45, "Banana": 30, "Kiwi": 50}

print("Fruits: ")
for fruit in fruits:
    x = "Name: {0}" + " " + "Price: {1}"
    print(x.format(fruit,fruits[fruit]))

fruitName = input("Enter the name of the fruit: ")
if(fruitName in fruit):
    print(fruitName + " is available")
else:
    print(fruitName + " is not available")


