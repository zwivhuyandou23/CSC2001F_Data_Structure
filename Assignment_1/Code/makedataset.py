# Create test dataset for assignment on BSTs
# Hussein Suleman
# 29 March 2023

import random
#
#wordsfile = open ('words.txt', "r")
#words = [a.rstrip ('\n') for a in wordsfile.readlines ()]
#wordsfile.close ()
#
namesfile = open("names.txt", "r")
names = [a.rstrip ('\n') for a in namesfile.readlines ()]
namesfile.close ()

duplicates = 10
fullnames = []
for i in range(10):
    
   for n in names:
      print(n+str(i))
      
      fullnames.append (n+str(i))

actions = []
newactions = []
videonum=1
count = 0


for acts in range(1000):
      n = random.randint(0, 900)
      r = random.randint(0, 900)
      x = 1
      if fullnames[r] != fullnames[n]:
         newactions.append(fullnames[r] + ' Follows ' + fullnames[n])
             
        
AddToFile = []
   
for na in actions:

   AddToFile.append(na)
   
newTest = open("dataset.txt", "a")

for i in newactions:

   newTest.write(i + "\n")
   count += 1
   print(i)
   print(count)
print("done")
   

