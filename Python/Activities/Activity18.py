import pandas
dataframe = pandas.read_csv("UserLogin.csv")
print(dataframe)

print("Username: ",dataframe["Usernames"][1] + " " + "Password: " , dataframe["Passwords"][1])

print("Username sorted in ascending order: ")
print(dataframe.sort_values('Usernames'))

print("Password sorted in descending order: ")
print(dataframe.sort_values('Passwords',ascending=False))