import pandas

dataframe = pandas.read_excel("UserDetails.xlsx")

print("User Details: ")
print(dataframe)

print("Number of rows and columns: ", dataframe.shape)

print("Email ids: ")
print(dataframe["Email"])

print("Sorted in ascending order: ")
print(dataframe.sort_values("FirstName"))