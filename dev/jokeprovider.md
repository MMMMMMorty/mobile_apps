# Solution

## Description of the problem

This task will let you play with Content Providers.

The target app exposes a Content Provider. Find all jokes authored by "reyammer" and concatenate them. That's the flag.

## Solution

I've solved the challenge by developing an app with ContentResolver.

1. **Add permission to ```AndroidManifest.xml```**
    READ_USER_DICTIONARY: Allows the app to read all words, names and phrases that the user may have stored in the user dictionary.
    PERMISSION_READ: Allows someone or something to read.
    PERMISSION_WRITE: Allows someone or something to write.
    ```
    <uses-permission android:name="android.permission.READ_USER_DICTIONARY" />
    <uses-permission android:name="com.example.PERMISSION_READ" />
    <uses-permission android:name="com.example.PERMISSION_WRITE" />
    ```

2. **Register ContentResolver object communicates with the provider object.**

    ```
    val contentResolver: ContentResolver = contentResolver
    ```
3. **Visit the content with Content URIs, and get a list of the words and their locales from the User Dictionary Provider**

    ```
    val providerName = "com.mobisec.provider.Joke"
    val uri = Uri.parse("content://$providerName/jokes")
    log("uri, $uri")
    var mCursor = contentResolver.query(uri, null, null, null, null)
    if (mCursor!!.count > 0) {
       var number = mCursor!!.count
       for(name in mCursor.columnNames){
           log("columnNames $name")
       }
       log("number $number")
    }
    ```

4. **Define query condition (projection, selecetion, selectionArgs), and get the flag.**
    ```
    // A "projection" defines the columns that are returned for each row
    val mProjection= arrayOf(
         "id",
         "author",
         "joke"
    )
    val selection = "author = ?"

    val selectionArgs = arrayOf("reyammer")
    mCursor = contentResolver.query(uri, mProjection, selection, selectionArgs, null)
    if (mCursor!!.count > 0) {
        var number = mCursor!!.count
        log("number $number")
        while (mCursor.moveToNext()) {
            val joke = mCursor.getString(mCursor.getColumnIndex("joke"))
            log("partFlag: $joke") //MOBISEC{lol_roftl_ahahah_:D_REYAMMER_TELLS_THE_BEST_JOKES!}
            // Handle the retrieved data
        }
    }
    ```