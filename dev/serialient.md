# Solution

## Description of the problem

Start the SerialActivity, it will give you back the flag. Kinda.
## Solution

I've solved the challenge by developing an app that added a project to gradle, retrieved a Serializable extra in bundle, and used Java reflection.

1. **Add the other package Class to the priject**
    To do that, first, I added the Class file under the directory.
    Second, I add the project to the gradle file (```setting.gradle```).
    ```
    include ':app', ':com.mobisec.serialintent'
    ```
    Third, I add the project to the another gradle file (```build.gradle(app:)```)
    ```
    project(':com.mobisec.serialintent')
    ```

2. **Start Activity and get the result**
   ```
   val intent = Intent()
   intent.component = ComponentName("com.mobisec.serialintent", "com.mobisec.serialintent.SerialActivity")
   startActivityForResult(intent, 0)
   ```

3. **Receive the result and retrieve a Serializable extra from bundle**
   
   Here, I retrieved a Serializable extra named "flag" from the data Intent, and assert that the "flag" extra is indeed a ```FlagContainer``` object.
   ```
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ( resultCode == RESULT_OK && data != null) {
            // Handle the result data
            try{
                log("new one")
                val receivedFlagContainer = data.getSerializableExtra("flag") as FlagContainer
                log("receivedFlagContainer, $receivedFlagContainer")
                
                ...
            } catch (e: Exception){
                log("Exception: ${e}")
            }
        }
    }
   ```

4. **Reflection Usage**

    I used reflection to access a private method (```getFlag```) of the ```FlagContainer``` class.

    ```
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ( resultCode == RESULT_OK && data != null) {
            // Handle the result data
            try{

                ...

                val getFlagMethod: Method = FlagContainer::class.java.getDeclaredMethod("getFlag")
                getFlagMethod.setAccessible(true)
                val flag = getFlagMethod.invoke(receivedFlagContainer) as String
                log("Flag: $flag")

            } catch (e: Exception){
                log("Exception: ${e}")
            }
        }
    }
    ```

## Optional Feedback

I really liked this challenge because it is really challenging and good-desined. It took me some time to figure it out how to add the Class to the project.
