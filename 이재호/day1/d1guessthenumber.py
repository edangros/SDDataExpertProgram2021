
#============================================================
#====================Guess the Number========================
#date:2020.12.08(W1D1)
#Author:Jae-ho Lee
#A part of Digital Training SD class
#============================================================

import random

#=================================
#=========initialization==========
#=================================
hidden_no   :int
hidden_no = random.randint(0,20) #hidden number will be random integer in 0 - 20
print("hidden number generated")

input_no    :int
input_no = -25 #-25 will never be generated in random

count   :int
count = 0 #counter start from 0

result  :bool #win/lose result
result = True #default is win

name    :str
name = input("Type your name : ") #now get the user's name

#=================================
#============Main Loop============
#=================================

while (input_no != hidden_no): #do loop while wrong
    count += 1
    try: #use error catcher cuz cannot certain the input value is a number 
        input_no = int(input("Input the number and press \'Enter\':"))
    except ValueError: #if the input number is not number, ValueError will be thrown. So catch that
        print("write the number!")#print error message and do nothing
    else: #if no error, execute the left
        #compare input and picked number and print the result
        if(input_no>hidden_no):
            print("too high! ", end="")
        elif(input_no<hidden_no):
            print("too low! ", end="")
    if (count>=6): #if the count exceeded 6,
        result = False #change result to Fail
        break #exit the loop

#=================================
#==========Print Result===========
#=================================
#if loop is ended, print the message
if result:
    print("%s Win! The answer is %d. (count : %d)"%(name,hidden_no,count))
else:
    print("%s Lose! The answer is %d"%(name,hidden_no))