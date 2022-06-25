package app.revanced.integrations.videoswipecontrols;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import app.revanced.integrations.utils.LogHelper;

/* loaded from: classes6.dex */
public class FensterGestureController {
    public boolean TouchesEnabled = false;
    private GestureDetector gestureDetector;
    public FensterEventsListener listener;

    public boolean onTouchEvent(MotionEvent event) {
        if (event == null || !this.TouchesEnabled || event.getPointerCount() > 1) {
            return false;
        }
        if (event.getAction() == 1) {
            this.listener.onUp();
            LogHelper.debug("TouchTest", "Touch up");
        }
        return this.gestureDetector.onTouchEvent(event);
    }

    public void setFensterEventsListener(FensterEventsListener listener, Context context, ViewConfiguration viewConfiguration) {
        this.listener = listener;
        this.gestureDetector = new GestureDetector(context, new FensterGestureListener(listener, viewConfiguration));
    }
}