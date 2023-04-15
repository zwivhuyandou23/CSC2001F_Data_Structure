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


for i in range(int(len(fullnames) / 2)):
   newactions = []

   #newactions.append (n+' '+' '.join (random.choice(n) for i in range(3)))
   for acts in range(100):
      n = random.randint(0, int(len(fullnames) - 1))
      r = random.randint(0, int(len(fullnames) - 1))
      x = 1
      if fullnames[i] != fullnames[n]:
         newactions.append(fullnames[i] + ' Follows ' + fullnames[n])
         print(fullnames[i] + ' Follows ' + fullnames[n])
      count += 1
      print(count)         
         
        
AddToFile = []
   
for na in actions:

   AddToFile.append(na)
   
newTest = open("dataset.txt", "a")

for i in AddToFile:

   newTest.write(i + "\n")
print("done")
   

