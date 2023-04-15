# Create test dataset for assignment on BSTs
# Hussein Suleman
# 29 March 2023

import random
#
#wordsfile = open ('words.txt', "r")
#words = [a.rstrip ('\n') for a in wordsfile.readlines ()]
#wordsfile.close ()
#
namesfile = open ("/home/zwivhuya/School/CSC2001F/Assignments/DS/CSC2001F_Data_Structure/Assignment_1/Code/resources/names.txt", "r")
names = [a.rstrip ('\n') for a in namesfile.readlines ()]
namesfile.close ()

duplicates = 10
fullnames = []

for i in range(duplicates):
   for n in names:
      fullnames.append (n+str(i))

actions = []
newactions = []
videonum=1

for n in fullnames:
   newactions = []
   newactions.append (n+' '+' '.join (random.choice(n) for i in range(3)))
   for acts in range (random.randint (1, 30)):
      r = random.randint (0, 19)
      if r==0:
         x=1
         newactions.append ('Find '+n)
      elif r==1:
         x=1
         newactions.append ('List')
 
      else:
         x=1
         newactions.append ('Display '+n)
         newactions.append ('Delete '+n)
   
   oldactions = actions
   actions = []
   lenoldactions = len(oldactions)
   lennewactions = len(newactions)
   while (len(oldactions)>0 and len(newactions)>0):
      if (random.randint (1, lenoldactions+lennewactions) <= lenoldactions):
         actions.append (oldactions.pop(0))
      else:
         actions.append (newactions.pop(0))
   actions += oldactions + newactions      
   
for na in actions:
   print (na)
