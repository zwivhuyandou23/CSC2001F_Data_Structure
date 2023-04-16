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


for acts in range(20):
      n = random.randint(0, 929)
      r = random.randint(0, 929)
      x = random.randint(0,3)
      if x==1:
         x
         newactions.append ('Find '+fullnames[r]+" description")
      elif x==2:
 
         newactions.append ('Display '+fullnames[r]+" Posts")
         
      else:
         newactions.append ('Delete '+fullnames[n])
     
         
             
        
AddToFile = []
   
for na in actions:

   AddToFile.append(na)
   
newTest = open("commandsList.txt", "w")

for i in newactions:

   newTest.write(i + "\n")
   
   print(i)
   print(count)
   count += 1
print("done")
   

