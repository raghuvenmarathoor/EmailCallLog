package www.raghu.com.calllogemailer;

import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.util.Log;

/**
 * Created by Raghu on 27-03-2015.
 */
public class EmailSenderThread implements Runnable {
    Context context = null;
    String recipientMail = "";
    String senderMail = "";
    String senderPassword = "";
    public EmailSenderThread(Context context, String recepientMail, String senderMail, String senderPassword){
        this.context = context;
        this.recipientMail = recepientMail;
        this.senderMail = senderMail;
        this.senderPassword = senderPassword;
    }
    @Override
    public void run() {
        // get start of cursor
        Log.i("CallLogDetailsActivity", "Getting Log activity...");
        String[] projection = new String[]{CallLog.Calls.NUMBER};
        Cursor cur = context.getContentResolver().query(CallLog.Calls.CONTENT_URI, projection, null, null, CallLog.Calls.DATE +" desc");
        cur.moveToFirst();
        String lastCallnumber = cur.getString(0);
        try {
            GMailSender sender = new GMailSender(senderMail , senderPassword);
            sender.sendMail("You have received a call",
                    lastCallnumber,
                    senderMail,
                    recipientMail);
            Log.i("SendMail", "emailSendingprocess ended:" + lastCallnumber);
        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }
    }
}

