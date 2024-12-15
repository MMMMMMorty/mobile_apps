# Solution

## Description of the problem

You need to declare and implement a service with an intent filter with action com.mobisec.intent.action.GIMMELOCATION. The system will find your service and it will start it with a startService() method (and an appropriate intent as argument). The system expects to get back the current location (as a Location object).

During the test, the system will change the current location at run-time and it will query your service to get the updated location. If the expected location matches with what you reply back, the flag will be printed in the logs.

Your service should "return" the reply to the system with a broadcast intent, with a specific action and bundle.

## Solution

I've solved the challenge by developing an app using location services.

1. **Ask for Permission in ```AndroidManifest.xml```**
    READ_EXTERNAL_STORAGE: Allows an application to read from external storage.
    ACCESS_FINE_LOCATION: Allows an app to access precise location.
    ACCESS_COARSE_LOCATION: Allows an app to access approximate location.
    INTERNET: Allows applications to open network sockets.
	ACCESS_NETWORK_STATE: Allows applications to access information about networks.
   ```
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
   ```
2. **Create a exported service that receive ```com.mobisec.intent.action.GIMMELOCATION``` action**
   ```
     <service
         android:name=".IntentServiceTask"
         android:exported="true">
         <intent-filter>
             <action android:name="com.mobisec.intent.action.GIMMELOCATION" />
         </intent-filter>
     </service>
   ```
3. **Start service**
    ```
    val intentServiceIntent = Intent(this, IntentServiceTask::class.java)
    startService(intentServiceIntent)
    ```

4. **Create location services client**
    ```
    import com.google.android.gms.location.FusedLocationProviderClient
    import com.google.android.gms.location.LocationServices
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    class IntentServiceTask : IntentService("IntentServiceTask") {


    override fun onHandleIntent(intent: Intent?) {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        ...
        }
    }
    ```

5. **Get the location and broadcast the location**
    ```
    class IntentServiceTask : IntentService("IntentServiceTask") {


    override fun onHandleIntent(intent: Intent?) {
        ...

        fusedLocationClient.lastLocation
            .addOnSuccessListener { location : Location? ->
        log("Here the location is $location") // Use fused succeed twice, use system's only once

        val i = Intent()
        i.action = "com.mobisec.intent.action.LOCATION_ANNOUNCEMENT"
        i.putExtra("location", location)
        sendBroadcast(i)
      }
        }
    }
    
    ```