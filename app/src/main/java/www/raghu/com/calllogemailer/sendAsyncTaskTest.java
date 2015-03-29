package www.raghu.com.calllogemailer;

import android.os.AsyncTask;

/**
 * Created by Raghu on 28-03-2015.
 */
public class sendAsyncTaskTest extends AsyncTask<String,Void,Void>{
    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected Void doInBackground(String... params) {
        String subject = params[0];
        String mail = params[1];
        String senderEmail = params[2];
        String receiverEmail = params[3];
        GMailSender sender = new GMailSender("raghuvenmarathoor@gmail.com", "jumbalakka");
        sender.sendMail(subject,mail,senderEmail,receiverEmail);
        return null;
    }
}
