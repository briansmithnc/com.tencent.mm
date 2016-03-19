package com.tencent.mm.plugin.report.service;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ag.b.a;
import com.tencent.mm.jni.platformcomm.PlatformComm.C2Java;
import com.tencent.mm.model.ah;
import com.tencent.mm.plugin.report.b.f;
import com.tencent.mm.protocal.b;
import com.tencent.mm.protocal.b.yw;
import com.tencent.mm.r.m;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.u;
import java.util.ArrayList;
import java.util.Map;

public class KVReportJni
{
  private static final String TAG = "!32@/B4Tb64lLpKe2JfXcMjS1rQ+BzZzSUQb";
  public static IKVReportNotify kvReportNotify = null;
  
  public static void parseKVPluginMsg(String paramString)
  {
    if (ay.kz(paramString))
    {
      u.w("!32@/B4Tb64lLpKe2JfXcMjS1rQ+BzZzSUQb", "msg content is null");
      return;
    }
    u.i("!32@/B4Tb64lLpKe2JfXcMjS1rQ+BzZzSUQb", "receive msg: " + paramString);
    Map localMap = q.J(paramString, "sysmsg", null);
    if ((localMap == null) || (localMap.size() == 0))
    {
      u.e("!32@/B4Tb64lLpKe2JfXcMjS1rQ+BzZzSUQb", "plugin msg parse fail:" + paramString);
      return;
    }
    String str = (String)localMap.get(".sysmsg.$type");
    if ((ay.kz(str)) || (!str.equalsIgnoreCase("getkvidkeystg")))
    {
      u.e("!32@/B4Tb64lLpKe2JfXcMjS1rQ+BzZzSUQb", "plugin msg parse fail:" + paramString);
      return;
    }
    long l1 = ay.getLong((String)localMap.get(".sysmsg.getkvidkeystg.generalversion"), -1L);
    long l2 = ay.getLong((String)localMap.get(".sysmsg.getkvidkeystg.specialversion"), -1L);
    long l3 = ay.getLong((String)localMap.get(".sysmsg.getkvidkeystg.whiteorblackuinversion"), -1L);
    long l4 = ay.getLong((String)localMap.get(".sysmsg.getkvidkeystg.timeinterval"), -1L);
    long l5 = ay.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvgeneralversion"), -1L);
    long l6 = ay.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvspecialversion"), -1L);
    long l7 = ay.getLong((String)localMap.get(".sysmsg.getkvidkeystg.kvwhiteorblackuinversion"), -1L);
    if ((l1 == -1L) || (l2 == -1L) || (l3 == -1L) || (l4 == -1L) || (-1L == l5) || (-1L == l6) || (-1L == l7))
    {
      u.e("!32@/B4Tb64lLpKe2JfXcMjS1rQ+BzZzSUQb", "plugin msg parse fail:" + paramString);
      return;
    }
    u.i("!32@/B4Tb64lLpKe2JfXcMjS1rQ+BzZzSUQb", "plugin msg version:" + l1 + ", " + l2 + ", " + l3);
    KVReportJava2C.onKVPluginMsg(l5, l6, l7, l1, l2, l3, l4);
  }
  
  public static class IDKeyDataInfo
    implements Parcelable
  {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
      public final KVReportJni.IDKeyDataInfo createFromParcel(Parcel paramAnonymousParcel)
      {
        return new KVReportJni.IDKeyDataInfo(paramAnonymousParcel);
      }
      
      public final KVReportJni.IDKeyDataInfo[] newArray(int paramAnonymousInt)
      {
        return new KVReportJni.IDKeyDataInfo[paramAnonymousInt];
      }
    };
    private long id;
    private long key;
    private long value;
    
    public IDKeyDataInfo()
    {
      id = 0L;
      key = 0L;
      value = 0L;
    }
    
    public IDKeyDataInfo(int paramInt1, int paramInt2, int paramInt3)
    {
      id = paramInt1;
      key = paramInt2;
      value = paramInt3;
    }
    
    protected IDKeyDataInfo(Parcel paramParcel)
    {
      id = paramParcel.readLong();
      key = paramParcel.readLong();
      value = paramParcel.readLong();
    }
    
    public long GetID()
    {
      return id;
    }
    
    public long GetKey()
    {
      return key;
    }
    
    public long GetValue()
    {
      return value;
    }
    
    public void SetID(int paramInt)
    {
      id = paramInt;
    }
    
    public void SetKey(int paramInt)
    {
      key = paramInt;
    }
    
    public void SetValue(int paramInt)
    {
      value = paramInt;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(id);
      paramParcel.writeLong(key);
      paramParcel.writeLong(value);
    }
  }
  
  static class KVCommBaseInfo
  {
    String deviceBrand;
    String deviceModel;
    String languageVer;
    String osName;
    String osVersion;
  }
  
  public static class KVReportC2Java
  {
    public static int getClientVersion2()
    {
      u.v("!32@/B4Tb64lLpKe2JfXcMjS1rQ+BzZzSUQb", "clientversion:" + b.iUf);
      return b.iUf;
    }
    
    public static String getKVCommPath()
    {
      return PlatformComm.C2Java.getAppFilePath() + "/kvcomm/";
    }
    
    public static KVReportJni.KVCommBaseInfo getKVCommReqBaseInfo()
    {
      KVReportJni.KVCommBaseInfo localKVCommBaseInfo = new KVReportJni.KVCommBaseInfo();
      deviceModel = (Build.MODEL + Build.CPU_ABI);
      deviceBrand = Build.BRAND;
      osName = ("android-" + Build.MANUFACTURER);
      osVersion = Build.VERSION.SDK_INT;
      languageVer = t.aUB();
      return localKVCommBaseInfo;
    }
    
    public static int getSingleReportBufSizeB()
    {
      return 20480;
    }
    
    public static boolean onReportKVDaSelfMonitorOpLogReady(byte[] paramArrayOfByte)
    {
      if ((!ah.rh()) || (ay.J(ah.tq())))
      {
        u.e("!32@/B4Tb64lLpKe2JfXcMjS1rQ+BzZzSUQb", "onReportKVDaSelfMonitorOpLogReady account not ready");
        return false;
      }
      yw localyw;
      try
      {
        localyw = new yw();
        localyw.am(paramArrayOfByte);
        if (jvL <= 0)
        {
          u.e("KVReportJni", "error selfmonitor count");
          return true;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        u.e("KVReportJni", paramArrayOfByte.getMessage());
        return false;
      }
      ah.tD().rp().b(new b.a(202, localyw));
      return true;
    }
    
    public static void onReportKVDataReady(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
    {
      try
      {
        if ((KVReportJni.kvReportNotify != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
          KVReportJni.kvReportNotify.onReportKVDataReady(paramArrayOfByte1, paramArrayOfByte2, paramInt);
        }
        return;
      }
      catch (Exception paramArrayOfByte1)
      {
        u.e("KVReportJni", paramArrayOfByte1.getMessage());
      }
    }
    
    public static boolean onRequestGetStrategy(byte[] paramArrayOfByte)
    {
      try
      {
        if (ah.tg())
        {
          u.e("!32@/B4Tb64lLpKe2JfXcMjS1rQ+BzZzSUQb", "MMCore not inited");
          return false;
        }
        paramArrayOfByte = new f(paramArrayOfByte);
        ah.tE().d(paramArrayOfByte);
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        u.e("KVReportJni", "onRequestGetStrategy error: " + paramArrayOfByte.getMessage());
      }
      return false;
    }
    
    public static void reportGroupIDKey(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int paramInt, boolean paramBoolean)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramInt)
      {
        localArrayList.add(new KVReportJni.IDKeyDataInfo(paramArrayOfInt1[i], paramArrayOfInt2[i], paramArrayOfInt3[i]));
        i += 1;
      }
      paramArrayOfInt1 = h.fUJ;
      h.d(localArrayList, paramBoolean);
    }
    
    public static void reportIDKey(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
    {
      h localh = h.fUJ;
      h.b(paramLong1, paramLong2, paramLong3, paramBoolean);
    }
    
    public static void reportKV(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      h localh = h.fUJ;
      h.c((int)paramLong, paramString, paramBoolean2, paramBoolean1);
    }
  }
  
  public static class KVReportJava2C
  {
    public static native void ackKvStrategy(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3);
    
    public static native void onCreate();
    
    public static native void onDestroy();
    
    public static native void onExitAppOrAppCrash();
    
    public static native void onForeground(boolean paramBoolean);
    
    public static native void onKVPluginMsg(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7);
    
    public static native void onReportStrategyResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
    
    public static native void reportIDKey(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean);
    
    public static native void reportListIDKey(KVReportJni.IDKeyDataInfo[] paramArrayOfIDKeyDataInfo, boolean paramBoolean);
    
    public static native void setUin(long paramLong);
    
    public static native void writeImportKvData(long paramLong, String paramString, boolean paramBoolean);
    
    public static native void writeKvData(long paramLong, String paramString, boolean paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.plugin.report.service.KVReportJni
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */