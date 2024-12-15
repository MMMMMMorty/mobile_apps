# Solution

> RENAME the file to: username-challengecategory-challengeename.md
> E.g., bobby-appdev-helloworld.md
> E.g., bobby-reversing-babyrev.md
> E.g., bobby-exploitation-frontdoor.md

> Never used markdown?
> See: https://guides.github.com/features/mastering-markdown/

> Please, remove all lines starting with > before submitting


## Description of the problem

> Here describe the problems related to the challenge.

The helloworld challenge requires to develop an app that prints a specific
string with a specific verbosity and tag using Android's Logging API.

## Solution

> Here describe how you solved the challenge
> NOTE If you partially solved the challenge describe what you did anyway

I've solved the challenge by developing an app doing X and Y. My app uses
permissions PX because of FOO. I'm also using the BAR API to do BAZ.


## Optional Feedback

> OPTIONALLY provide feedback
> NOTE be polite, thanks

I really liked this challenge because of FOO and BAR.

I think you can improve the challenge by doing X and Z.

This challenge sucks  because of FOO and BAR.


Attempting to install APK /opt/mobisec/challs/filehasher/filehasher.apk
$ adb install /opt/mobisec/challs/filehasher/filehasher.apk
Performing Streamed Install
Success
APK installed successfully.
Granting permissions (if any)
Found permissions: ['android.permission.WRITE_EXTERNAL_STORAGE', 'android.permission.READ_EXTERNAL_STORAGE']
Granting permission: android.permission.WRITE_EXTERNAL_STORAGE
Granting permission: android.permission.READ_EXTERNAL_STORAGE
Start APK /opt/mobisec/challs/filehasher/filehasher.apk
$ adb shell am start -n com.mobisec.filehasher/com.mobisec.filehasher.MainActivity --es flag MOBISEC{XXXXXXXX}
Attempting to install APK /var/apks/54276.apk
$ adb install -R /var/apks/54276.apk
Performing Streamed Install
Success
APK installed successfully.
Granting permissions (if any)
Found permissions: ['android.permission.READ_EXTERNAL_STORAGE']
Granting permission: android.permission.READ_EXTERNAL_STORAGE
Start APK /var/apks/54276.apk
$ adb shell am start -n com.example.mobisec6/com.example.mobisec6.MainActivity
Output of logcat:
10-24 22:02:44.522  4487  4487 E MOBISEC : app:onCreate
10-24 22:02:44.522  4487  4487 E MOBISEC : flag set correctly
Output of logcat:
10-24 22:02:50.333  4487  4487 E MOBISEC : app:onCreate
10-24 22:02:50.334  4487  4487 E MOBISEC : Building explicit intent targeting component: ComponentInfo{com.example.mobisec6/com.example.mobisec6.MainActivity}
10-24 22:02:50.334  4487  4487 E MOBISEC : writing 'dmcqDI9FyX0wyFQX1P2g' to '/storage/emulated/0/8Tosg47A.dat'
10-24 22:02:50.335  4487  4487 E MOBISEC : About to send intent: Intent { act=com.mobisec.intent.action.HASHFILE dat=file:///storage/emulated/0/8Tosg47A.dat cmp=com.example.mobisec6/.MainActivity }
10-24 22:02:50.336  4487  4487 E MOBISEC : I am expecting to receive the following hash: 057e906a73e3e428dbff82ff5d42a85d6f43b3092dcc8880409db0a50d49320b
10-24 22:02:50.502  4525  4525 E MOBISEC : receive the action
10-24 22:02:50.502  4525  4525 E MOBISEC : file:///storage/emulated/0/8Tosg47A.dat
10-24 22:02:50.507  4525  4525 E MOBISEC : fileName 8Tosg47A.dat
10-24 22:02:50.507  4525  4525 E MOBISEC : externalDir /storage/emulated/0
10-24 22:02:50.507  4525  4525 E MOBISEC : read the file successfully
10-24 22:02:50.507  4525  4525 E MOBISEC : dmcqDI9FyX0wyFQX1P2g
10-24 22:02:50.507  4525  4525 E MOBISEC : what I receive dmcqDI9FyX0wyFQX1P2g
10-24 22:02:50.508  4525  4525 E MOBISEC : what I calculate 057e906a73e3e428dbff82ff5d42a85d6f43b3092dcc8880409db0a50d49320b
10-24 22:02:50.514  4525  4525 E MOBISEC : I have returned the value
10-24 22:02:50.587  4487  4487 E MOBISEC : app:onActivityResult
10-24 22:02:50.587  4487  4487 E MOBISEC : app:onActivityResult. got intent: Intent { (has extras) }
10-24 22:02:50.587  4487  4487 E MOBISEC : I have received the following hash: 057e906a73e3e428dbff82ff5d42a85d6f43b3092dcc8880409db0a50d49320b
10-24 22:02:50.587  4487  4487 E MOBISEC : I was expecting the following hash: 057e906a73e3e428dbff82ff5d42a85d6f43b3092dcc8880409db0a50d49320b
10-24 22:02:50.587  4487  4487 E MOBISEC : They match! good job, here is the flag: MOBISEC{Was_it_known_that_these_one_way_functions_give_you_back_flags?}
The analysis terminated without errors.