# Solution

## Description of the problem

There is an HTTP server listening on 10.0.2.2:31337 (reachable from within the emulator where your app is running). The flag is there. It's easy, but you may need to pro-up your math skills.

## Solution

I've solved the challenge by developing an app with url connection.

1. **Asking for permission in ```AndroidManifest.xml``` for intenet access**
   android.permission.INTERNET: Allows applications to open network sockets.
   android.permission.ACCESS_NETWORK_STATE: Allows applications to access information about networks.
    ```
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    ```
2. **Using URLConnection Class to connect to url and get response**
    - The connection object is created by invoking the openConnection method on a URL.
        ```
        val url = URL("http://10.0.2.2:31337/flag")
        val urlConnection = url.openConnection() as HttpURLConnection
        ```
    - The setup parameters and general request properties are manipulated.
        ```
        // Set request properties
        urlConnection.requestMethod = "POST"
        urlConnection.doOutput = true   // indicates POST method
        urlConnection.doInput = true

        // Set header for request
        val headers: MutableMap<String, String> = HashMap()

        headers["Connection"] = "close"

        for (headerKey in headers.keys) {
            urlConnection.setRequestProperty(headerKey, headers[headerKey])
        }

        var postData = URLEncoder.encode("answer", "UTF-8") + "=" + URLEncoder.encode("9", "UTF-8") + "&" + URLEncoder.encode("val1", "UTF-8") + "=" + URLEncoder.encode("3", "UTF-8") + "&" +  URLEncoder.encode("oper", "UTF-8") + "=" + URLEncoder.encode("+", "UTF-8") + "&" +  URLEncoder.encode("val2", "UTF-8") + "=" + URLEncoder.encode("6", "UTF-8")

        // Send the POST data
        val wr = OutputStreamWriter(urlConnection.outputStream)
        wr.write(postData)
        wr.flush()
        wr.close()
        ```

        **Note: postData needs to be encoded with UTF-8, which should be ```answer=9&val1=3&oper=%2B&val2=6```**

    - The actual connection to the remote object is made, and check the response code.
        ```
        var br: BufferedReader? = null
        if (urlConnection.getResponseCode() === 200) {
            br = BufferedReader(InputStreamReader(urlConnection.getInputStream()))
            var strCurrentLine: String?
            while (br.readLine().also { strCurrentLine = it } != null) {
                strCurrentLine?.let { Log.e("MOBISEC", it) }
            }
        } else {
            br = BufferedReader(InputStreamReader(urlConnection.getErrorStream()))
            var strCurrentLine: String?
            while (br.readLine().also { strCurrentLine = it } != null) {
                strCurrentLine?.let { Log.e("MOBISEC", it) }
            }
        }
        ```