# Solution

## Description of the problem

Don't be scared. It's going to be alright (and native).

Credits: pox

## Solution

I've solved the challenge by installing Ghirda.

In this code, it has ```System.loadLibrary("native-lib");```, then I found out the this library ```lobnative-lib.so``` under the ```\res\lib``` directory.

To figure out how to flag is getting from the lib,  I downloaded Ghirda and then threw the lib package to it. And then I successfully get the flag.


## Optional Feedback

I stuck because I don't know what is the meaning of the load the library, until I tried to figure out what is inside the lib.