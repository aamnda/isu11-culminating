def findLastBinary(s):
    # vars
    binaryNums = ""
    newBinaryNums = ""
    count = 0
    begFound = True
    endFound = True
    
    # creates the str of ascii binary numbers
    for index in range(len(s)):
        ascii = ord(s[index])
        
        binaryNums = binaryNums + str(bin(ascii)[2:].zfill(8))


    # looks for the nums
    while begFound or endFound:
        searchNum = "{0:08b}".format(count)
        searchNum = int(searchNum)

        begFound = False
        endFound = False


        # from beginning
        if str(searchNum) in binaryNums:
            # print("beg yes")
            indexOfOccurence = binaryNums.find(str(searchNum))
            
            for i in range(len(binaryNums)):
                if i >= indexOfOccurence and i < indexOfOccurence + len(str(searchNum)):
                    newBinaryNums = newBinaryNums + ""
                    # print("deleted")

                else:
                    newBinaryNums = newBinaryNums + binaryNums[i]
                    # print("same")
            
            begFound = True
            binaryNums = newBinaryNums
            newBinaryNums = ""
            
        reversedSearchNum = str(searchNum)[::-1]
        reversedBinaryNums = binaryNums[::-1]


        # from end
        if reversedSearchNum in reversedBinaryNums:
            # print("end yes")
            indexOfOccurence = reversedBinaryNums.find(reversedSearchNum)

            for i in range(len(reversedBinaryNums)):
                
                if i >= indexOfOccurence and i < indexOfOccurence + len(str(searchNum)):
                    newBinaryNums = newBinaryNums + ""

                else:
                    newBinaryNums = newBinaryNums + reversedBinaryNums[i]

            endFound = True
            binaryNums = newBinaryNums[::-1]       
            newBinaryNums = ""    

        # print(binaryNums, end="\n\n")
        count+=1
        # time.sleep(2)
    print(binaryNums)
    return(int(str(searchNum),2)-1)

     

findLastBinary("Roses are Red.")


# from end



        # # from beginning
        # for binaryNum in binaryNums:
        #     if str(searchNum) in binaryNum:
        #         binaryNums[forwardIndicator] = binaryNum.replace(str(searchNum),"",1)
        #         begFound = True

        #     if begFound:
        #         break
        #     forwardIndicator += 1   
         
        # # from end
        # # flip the search number for backwards indicating
        
        # for binaryNum in reversed(binaryNums):
        #     backIndicator -= 1
        #     binaryNum = binaryNum[::-1]
            
        #     if str(searchNum)[::-1] in binaryNum[::-1]:
        #         newBinaryNum = binaryNum.replace(str(searchNum),"",1)
        #         binaryNums[backIndicator] = newBinaryNum[::-1]
        #         endFound = True
            
        #     if endFound:
        #         break