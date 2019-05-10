package com.serpanalo.legalaplication;

import android.content.Context;
import com.serpanalo.legalaplication.model.Constants;

import java.util.UUID;

public class UUIDGenerator {

    public static void deviceIdGenerator(Context context) {
        String uniqueID = UUID.randomUUID().toString();
        Utils.saveStringValue(context, Constants.DEVICE_UUID, uniqueID);
    }
}
