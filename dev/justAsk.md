# Solution

## Description of the problem

There is an app installed on the system. The app has four activities. Each of them has one part of the flag. If you ask them nicely, they will all kindly reply with their part of the flag. They will reply with an Intent, the part of the flag is somehow contained there. Check the app's manifest for the specs.

## Solution

I've solved the challenge by developing an app doing lanuching the activity.

There are four parts of the flags, which means four components in the other package.
For the part one and part three, they are both ```android:exported="true"```, I just need to create an intent, classify the component I want to connected, and use ```startActivityForResult()``` as well as ```onActivityResult()``` to get the result. Using Part One as example, here are the codes:
```
val intent = Intent()
intent.component = ComponentName("com.mobisec.justask", "com.mobisec.justask.PartOne")
intent.putExtra("MOBISEC", "Can you tell me the flag?")
intent.putExtra("flag", "Can you tell me the flag?")
intent.putExtra(Intent.EXTRA_TEXT, "Can you tell me the flag?")
startActivityForResult(intent, 1)


@RequiresApi(Build.VERSION_CODES.Q)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK){

            data?.toUri(0)?.let { Log.d("MOBISEC", it) };
        }
    }
```

For part two and part four, they specifie the action of the intent, so the action needs to be definted in the intent. Here is an example.
```
val sendIntent: Intent = Intent().apply {
    action = "com.mobisec.intent.action.JUSTASK"
    putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
    putExtra("MOBISEC", "This is my text to send.")
    putExtra("flag", "Can you tell me the flag?")
}
```
Specifically, part four's reply has many levels of bundles, so I need to open it level by level. I check the key of the next level bundle and use it to get the next next bundle until I reached the final bundle. Here are the codes.
```
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK){

            val bundle = data?.extras
            if (bundle != null) {
                Log.e("MOBISEC", bundle.toString()) // print the bundle
                for (key in bundle.keySet()) {
                    Log.e("MOBISEC", "keys $key")
                    var value = data?.getStringExtra(key)
                    if (value != null) {
                        Log.e("MOBISEC", "value is not null")
                        Log.e("MOBISEC", value)
                    }
                    if( key == "follow"){
                        val followBundlw = bundle.getParcelable<Bundle>("follow") // bundle include bundle
                        Log.e("MOBISEC", followBundlw.toString())

                        if (followBundlw != null) {
                            for (key in followBundlw.keySet()) { //get the key
                                Log.e("MOBISEC", "followBundle keys $key")
                                val nextBundle = followBundlw.getParcelable<Bundle>(key) // bundle include bundle
                                Log.e("MOBISEC", nextBundle.toString())
                                if (nextBundle != null) {
                                    for (key in nextBundle.keySet()){
                                        Log.e("MOBISEC", "nextBundle keys $key")
                                        val nextnextBundle = nextBundle.getParcelable<Bundle>(key) // bundle include bundle
                                        Log.e("MOBISEC", nextnextBundle.toString())
                                        if (nextnextBundle != null) {
                                            for (key in nextnextBundle.keySet()){
                                                Log.e("MOBISEC", "nextBundle keys $key")
                                                val nextnextnextBundle = nextnextBundle.getParcelable<Bundle>(key) // bundle include bundle
                                                Log.e("MOBISEC", nextnextnextBundle.toString())
                                                if (nextnextnextBundle != null) {
                                                    for (key in nextnextnextBundle.keySet()){
                                                        Log.e("MOBISEC", "nextnextnextBundle keys $key")
                                                        val nextnextnextnextBundle = nextnextnextBundle.getParcelable<Bundle>(key) // bundle include bundle
                                                        Log.e("MOBISEC", nextnextnextnextBundle.toString())

                                                        if (nextnextnextnextBundle != null) {
                                                            for (key in nextnextnextnextBundle.keySet()){
                                                                Log.e("MOBISEC", "nextnextnextnextnextBundle keys $key")
                                                                val secret = nextnextnextnextBundle.getString(key)
                                                                Log.e("MOBISEC", "last secret $secret")
                                                                val nextnextnextnextnextBundle = nextnextnextnextBundle.getParcelable<Bundle>(key) // bundle include bundle
                                                                Log.e("MOBISEC", nextnextnextnextnextBundle.toString())
                                                            }
                                                        }
                                                    }
                                                }

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
```