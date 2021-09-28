import pandas

data = {
    "Usernames" : ["admin","Charles","Deku"],
    "Passwords" : ["password","Charl13","AllMight"]
}

dataFrame = pandas.DataFrame(data)

print(dataFrame)

dataFrame.to_csv("UserLogin.csv",index=False)