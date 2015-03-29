package www.raghu.com.calllogemailer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by Raghu on 26-03-2015.
 */
public class IncomingCall extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {

        try {
            // TELEPHONY MANAGER class object to register one listner
            /*TelephonyManager tmgr = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);

            //Create Listner
            PhoneCallListener PhoneListener = new PhoneCallListener(context);

            // Register listener for LISTEN_CALL_STATE
            tmgr.listen(PhoneListener, PhoneCallListener.LISTEN_CALL_STATE);*/


        } catch (Exception e) {
            Log.e("Phone Receive Error", " " + e);
        }

    }
}
