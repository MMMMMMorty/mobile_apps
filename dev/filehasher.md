# Solution

## Description of the problem

You will need to write an app that exports a functionality to compute the SHA256 hash of a given file. You will need to define an activity with an intent filter for the "com.mobisec.intent.action.HASHFILE" action. The system will start your activity and ask you for hashing a file. The file path is specified in the Uri part of the intent you receive (which you can access with Intent.getData()). This file will always be stored on the SDCard (so make sure to request the right permissions ;-). You need to put the calculated hash in a result intent (under the "hash" key, see below) and in hexadecimal format. To help you debug problems, the system will add in the log what the content of the file was, what it was expecting as the result hash, and what it found from your reply. If the expected hash and the one from your app match, the flag will be printed in the logs.

## Solution

I've solved the challenge by developing an app doing X and Y. My app uses
permissions PX because of FOO. I'm also using the BAR API to do BAZ.

1. **Add permission to ```AndroidManifest.xml``` to Allows an app to access location in the background**
   ```
   <uses-permission android:name="android.permission.ACCESS_BACKGROUND_LOCATION" />
   ```

2. **Define an exported activity with an intent filter for the "com.mobisec.intent.action.HASHFILE" action in ```AndroidManifest.xml```**

    ```
    <activity
         android:name=".MainActivity"
         android:exported="true"
         android:label="@string/app_name"
         android:theme="@style/Theme.MobiSec6.NoActionBar">
         <intent-filter>
             <action android:name="android.intent.action.MAIN" />
             <action android:name="com.mobisec.intent.action.HASHFILE" />

             <category android:name="android.intent.category.LAUNCHER" />
         </intent-filter>
     </activity>
    ```

3. **Receive the intent from the system, retrieve the Uri from the intent and use it to access the SDcard**

    ```
    if (intent.action == "com.mobisec.intent.action.HASHFILE") {
      Log.e("MOBISEC", "receive the action")

      val urlPath = intent.data

      Log.e("MOBISEC", urlPath.toString())
      val externalDir = Environment.getExternalStorageDirectory()
      val lastIndex = urlPath.toString().lastIndexOf("/")
      var fileName: String
      if (lastIndex != -1) {
          fileName = urlPath.toString().substring(lastIndex + 1)
          Log.e("MOBISEC", "fileName $fileName")
      } else{
          fileName = ""
          Log.e("MOBISEC", "get fileName failed")
      }
      Log.e("MOBISEC", "externalDir $externalDir")
      val file = File(externalDir, fileName)
      var content = ""
      if (file.exists()) {
          Log.e("MOBISEC", "read the file successfully")
          val fileInputStream = FileInputStream(file)
          val reader = BufferedReader(InputStreamReader(fileInputStream))
          var line: String?
          while (reader.readLine().also { line = it } != null) {
              content += line
              line?.let { Log.e("MOBISEC", it) }
          }
          reader.close()
      }
      Log.e("MOBISEC", "what I receive $content")

      val sha256Hash = sha256(content)
      Log.e("MOBISEC", "what I calculate $sha256Hash")

      ...
    }
    ```

4. **Put the calculated hash in a result intent**
    ```
    if (intent.action == "com.mobisec.intent.action.HASHFILE") {
      ...

      val sha256Hash = sha256(content)
      Log.e("MOBISEC", "what I calculate $sha256Hash")

      val resultIntent = Intent()
      resultIntent.putExtra("hash", sha256Hash);
      setResult(Activity.RESULT_OK, resultIntent);
      finish()
      Log.e("MOBISEC", "I have returned the value")
      ...
    }
    ```