# Solution

## Description of the problem

Bind to the service and get the flag. It can't get any easier.
## Solution

I've solved the challenge by developing an app using a Messenger.

1. **Create client Messager**
    client Messager
    ```
    private val clientMessenger = Messenger(ServiceHandler())
    ```

2. **Implement ServiceConnection**
   
   In ```onServiceConnected()```, after registering the server messafer, server send the message to register the client, and get the flag back. At the same time, the clientMessenger must be registered as the receiver for the sending message.

    ```
    val MSG_REGISTER_CLIENT = 1
    val MSG_UNREGISTER_CLIENT = 2
    val MSG_SET_VALUE = 3
    val MSG_GET_FLAG = 4

    private val mConnection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // This is called when the connection with the service has been
            // established, giving us the object we can use to
            // interact with the service.  We are communicating with the
            // service using a Messenger, so here we get a client-side
            // representation of that from the raw IBinder object.
            log("connected")
            val msg: Message = Message.obtain(null, MSG_REGISTER_CLIENT, 0, 0)

            val msg2: Message = Message.obtain(null, MSG_SET_VALUE, 4, 0)
            val msg3: Message = Message.obtain(null, MSG_GET_FLAG, 0, 0)
            msg.replyTo = clientMessenger
            log("Ibinder, $service")
            mService = Messenger(service) //get the service
            log("mService, $mService")
            try {
                mService?.send(msg)
                log("first msg sent successfully")
                mService?.send(msg2)
                log("second msg sent successfully")
                mService?.send(msg3)
                log("third msg sent successfully")
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
            bound = true
        }

        override fun onServiceDisconnected(className: ComponentName) {
            // This is called when the connection with the service has been
            // unexpectedly disconnected -- that is, its process crashed.
            log("disconnected")
            mService = null
            bound = false
        }
    }
    ```

3. **Bind the service**
    ```
    val intent = Intent()
    intent.component = ComponentName("com.mobisec.unbindable", "com.mobisec.unbindable.UnbindableService")
    bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
    ```

4. **Define the ```handleMessage()``` for client messager**

    ```
    inner class ServiceHandler : Handler() {
        override fun handleMessage(msg: Message) {
            // Handle responses from the service here
            log("handler receive from service: ${msg.what}")
            if(msg.what == MSG_GET_FLAG){
                val bundle = msg.obj as Bundle
                val flag = bundle.getString("flag")
                log("flag is $flag")

            }
            if(msg.what == MSG_SET_VALUE){
                log("flag is $msg")

            }
        }
    }
    ```