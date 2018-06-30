import json

import csv


with open('name_dob_height.json') as f1, open('name_dob_salary.json') as f2:
    first_list = json.load(f1)
    second_list = json.load(f2)

for i, v in enumerate(first_list):
    second_list[i].update(v)

first_list.close()

second_list.sort(key=operator.itemgetter('Date_of_birth'))

employ_data = open('Output.csv', 'w')

csvwriter = csv.writer(employ_data)

count = 0

for row in second_list:

      if count == 0:
             header = row.keys()
             csvwriter.writerow(header)
             count += 1

      csvwriter.writerow(row.values())

employ_data.close()
second_list.close()




