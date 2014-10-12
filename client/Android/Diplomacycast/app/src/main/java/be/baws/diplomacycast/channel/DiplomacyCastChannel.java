package be.baws.diplomacycast.channel;

import android.util.Log;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;

/**
 * Created by fbousson on 12/10/14.
 */
public class DiplomacyCastChannel implements Cast.MessageReceivedCallback {

    private static final String TAG = DiplomacyCastChannel.class.getSimpleName();

    private String _namespace;

    public DiplomacyCastChannel(String namespace) {
        _namespace = namespace;
    }

    /**
     * @return custom namespace
     */
    public String getNamespace() {
        return _namespace;
    }

    /*
     * Receive message from the receiver app
     */
    @Override
    public void onMessageReceived(CastDevice castDevice, String namespace,
                                  String message) {
        Log.d(TAG, "onMessageReceived: " + message);
    }


}

