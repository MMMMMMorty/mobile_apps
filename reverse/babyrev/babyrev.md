
# Solution

## Description of the problem

The career of every reverser starts with a babyrev chall. Get the flag from code.

## Solution

I've solved the challenge by checking the class ```FlagChecker```.

There are two steps to get the real flag. First, reversing the flag from the code. In this class's function ```checkFlag```, the flag is hardcoded, I used a notebook to write down the part that I can get in the function, and the other part I wrote an easy programs to caculate the string. And then, it is not enough, there is another step to get the real flag ```flag.substring(8, flag.length() - 1).matches(r)```, here ```r``` represents the rule that singular letters are capitalised and plural characters are lowercase.

In the end, I got the flag, which is ```MOBISEC{ThIs_iS_A_ReAlLy_bAsIc_rEv}```.


## Optional Feedback

I really liked this challenge because it is interesting and easy.