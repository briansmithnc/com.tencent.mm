package com.tencent.mm.plugin.sight.encode.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class MainSightForwardContainerView$7
  implements MediaPlayer.OnCompletionListener
{
  MainSightForwardContainerView$7(MainSightForwardContainerView paramMainSightForwardContainerView) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.MainSightForwardContainerView.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */