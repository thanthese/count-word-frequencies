import re
import sys

##
# Adam Colton
# February 2010
#
# The python answer to the challenge.
#
# Call app like this:
#
#   time python sampleFile.txt output.txt
#
#
# (This header added by Stephen Mann.)
#

f = open(sys.argv[1],'r')
fileString=f.read()
f.close

finalCount={}
for word in map(lambda word:word.lower(), re.split('\W+', fileString)):
  finalCount[word] = finalCount.get(word,0)+1

f = open(sys.argv[2],'w')
for n in sorted([(count,word) for (word,count) in finalCount.items()]):
  f.write(str(n) + "\n")
f.close()
