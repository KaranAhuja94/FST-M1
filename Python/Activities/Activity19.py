import pandas
from pandas import ExcelWriter
from pandas import ExcelFile

data = {
    "FirstName" : ["Satvik","Avinash","Lahri"],
    "LastName" : ["Shah","Kati","Rath"],
    "Email" : ["satshah@example.com","avinashk@example.com","lahri.rath@example.com"],
    "PhoneNumber" : ["4537829158","5892184058","4528727830"]
}

dataframe = pandas.DataFrame(data)

writer = ExcelWriter("UserDetails.xlsx")

dataframe.to_excel(writer,"Sheet 1",index=False)

writer.save()