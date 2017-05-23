;Kevin Ponek
;May 24, 2016
;CS 122 - Architecture/Assembly Language
;Project 3
;switch.pep
;Description: This project describes what the program would do.  We had to implement PEP8 assembly code to match
         ;the description.  The description was of a switch statement that uses branch and compare to navigate through the statements.
         ;There is a case 0, case 1, case 2, case 3, case 4, and default.


         BR      main
input:   .EQUATE 0           
main:    SUBSP   2,i
         STRO    msg1,d      ;ask for input value from 0 to 4
         DECI    input,s
         LDA     input,s     ;Start of switch
         BR      options,x

options: .ADDRSS case0       
         .ADDRSS case1
         .ADDRSS case2
         .ADDRSS case3
         .ADDRSS case4
         .ADDRSS default

case0:   CPA     0,i         ;Start of case \'0\'
         BRNE    case1
         DECO    input,s     
         STRO    msg2,d
         DECO    0,i
         BR      endCase     ;break
case1:   CPA     1,i         ;Start of case \'1\'
         BRNE    case2
         DECO    input,s     
         STRO    msg2,d
         DECO    1,i
         BR      endCase     ;break
case2:   CPA     2,i         ;Start of case \'2\'
         BRNE    case3
         DECO    input,s     
         STRO    msg2,d
         DECO    2,i
         BR      endCase     ;break
case3:   CPA     3,i         ;Start of case \'3\'
         BRNE    case4
         DECO    input,s     
         STRO    msg2,d
         DECO    3,i
         BR      endCase     ;break
case4:   CPA     4,i         ;Start of case \'4\'
         BRNE    default
         DECO    input,s     
         STRO    msg2,d
         DECO    4,i
         BR      endCase     ;break
default: DECO    input,s
         STRO    msg3,d
         BR      endCase     ;break
                             ;End of switch body


endCase: CHARO   '\n',i      ;switch end, jump here when switch done
         STRO    msg4,d
         ADDSP   2,i
         STOP         

msg1:    .ASCII  "Input a number between 0 and 4: \x00"
msg2:    .ASCII  " inside the switch matches \x00"
msg3:    .ASCII " is not 0 to 4\x00"
msg4:    .ASCII  "switch done\x00"

         .END