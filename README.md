
# AndroidUIThread
> **UI Thread** and **Main Thread** are **same** in most case (=> it still different in some case).

https://developer.android.com/guide/components/processes-and-threads.html#Threads
https://developer.android.com/studio/write/annotations.html#thread-annotations
https://stackoverflow.com/questions/40784584/difference-between-the-main-thread-and-ui-thread/40795895#40795895

According to the document and the answer in `stackoverflow`,  the **UI Thread** and **Main Thread** is only different in **system app**  (applications that run as part of OS)
> Therefore, as long as you don't build a custom ROM or work on customizing Android for phone manufacturers, I wouldn't bother to make any distinction at all

### runOnUiThread

    /**
     * Runs the specified action on the UI thread. If the current thread is the UI
     * thread, then the action is executed immediately. If the current thread is
     * not the UI thread, the action is posted to the event queue of the UI thread.
     *
     * @param action the action to run on the UI thread
     */

    @Override
    public final void runOnUiThread(Runnable action) {
        if (Thread.currentThread() != mUiThread) {
            mHandler.post(action);
        } else {
            action.run();
        }
    }

### View.post

    /**
     * <p>Causes the Runnable to be added to the message queue.
     * The runnable will be run on the user interface thread.</p>
     *
     * @param action The Runnable that will be executed.
     *
     * @return Returns true if the Runnable was successfully placed in to the
     *         message queue.  Returns false on failure, usually because the
     *         looper processing the message queue is exiting.
     */

    public boolean post(Runnable action) {
        final AttachInfo attachInfo = mAttachInfo;
        if (attachInfo != null) {
            return attachInfo.mHandler.post(action);
        }

        // Postpone the runnable until we know on which thread it needs to run.
        // Assume that the runnable will be successfully placed after attach.
        getRunQueue().post(action);
        return true;
    }


