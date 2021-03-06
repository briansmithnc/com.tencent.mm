package com.tencent.kingkong.database;

import android.util.SparseArray;
import com.tencent.kingkong.CursorWindow;
import com.tencent.kingkong.DatabaseUtils;
import com.tencent.kingkong.support.CancellationSignal;
import com.tencent.kingkong.support.CancellationSignal.OnCancelListener;
import com.tencent.kingkong.support.Log;
import com.tencent.kingkong.support.LruCache;
import com.tencent.mm.dbsupport.newcursor.a;
import com.tencent.mm.dbsupport.newcursor.b;
import com.tencent.mm.dbsupport.newcursor.d;
import com.tencent.mm.dbsupport.newcursor.d.a;
import com.tencent.mm.dbsupport.newcursor.h;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SQLiteConnection
  implements CancellationSignal.OnCancelListener
{
  private static final boolean DEBUG = false;
  private static final byte[] EMPTY_BYTE_ARRAY;
  private static final String[] EMPTY_STRING_ARRAY;
  private static final String TAG = "MicroMsg.kkdb.SQLiteConnection";
  private static final Pattern TRIM_SQL_PATTERN;
  d currentFillingDbCursor;
  b currentFillingWindow;
  private int mArithmetic;
  private int mCancellationSignalAttachCount;
  private final SQLiteDatabaseConfiguration mConfiguration;
  private final int mConnectionId;
  private int mConnectionPtr;
  private boolean mIsInitWaited;
  private final boolean mIsPrimaryConnection;
  private final boolean mIsReadOnlyConnection;
  private boolean mOnlyAllowReadOnlyOperations;
  private boolean mPageTrace;
  private String mPassword;
  private final SQLiteConnectionPool mPool;
  private final PreparedStatementCache mPreparedStatementCache;
  private PreparedStatement mPreparedStatementPool;
  private final OperationLog mRecentOperations = new OperationLog(null);
  private int mlockedDevice;
  d.a rb;
  public int windowAllocatedSize;
  
  static
  {
    if (!SQLiteConnection.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      EMPTY_STRING_ARRAY = new String[0];
      EMPTY_BYTE_ARRAY = new byte[0];
      TRIM_SQL_PATTERN = Pattern.compile("[\\s]*\\n+[\\s]*");
      return;
    }
  }
  
  private SQLiteConnection(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt1, boolean paramBoolean1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    mIsInitWaited = paramBoolean2;
    mPassword = paramString;
    mArithmetic = paramInt3;
    mlockedDevice = paramInt2;
    mPageTrace = paramBoolean3;
    mPool = paramSQLiteConnectionPool;
    mConfiguration = new SQLiteDatabaseConfiguration(paramSQLiteDatabaseConfiguration);
    mConnectionId = paramInt1;
    mIsPrimaryConnection = paramBoolean1;
    if ((openFlags & 0x1) != 0) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      mIsReadOnlyConnection = paramBoolean1;
      mPreparedStatementCache = new PreparedStatementCache(mConfiguration.maxSqlCacheSize);
      return;
    }
  }
  
  private PreparedStatement acquirePreparedStatement(String paramString)
  {
    PreparedStatement localPreparedStatement2 = (PreparedStatement)mPreparedStatementCache.get(paramString);
    if (localPreparedStatement2 != null) {
      if (!mInUse) {
        return localPreparedStatement2;
      }
    }
    for (int i = 1;; i = 0)
    {
      int j = nativePrepareStatement(mConnectionPtr, paramString);
      PreparedStatement localPreparedStatement1 = localPreparedStatement2;
      try
      {
        int k = nativeGetParameterCount(mConnectionPtr, j);
        localPreparedStatement1 = localPreparedStatement2;
        int m = DatabaseUtils.getSqlStatementType(paramString);
        localPreparedStatement1 = localPreparedStatement2;
        localPreparedStatement2 = obtainPreparedStatement(paramString, j, k, m, nativeIsReadOnly(mConnectionPtr, j));
        if (i == 0)
        {
          localPreparedStatement1 = localPreparedStatement2;
          if (isCacheable(m))
          {
            localPreparedStatement1 = localPreparedStatement2;
            mPreparedStatementCache.put(paramString, localPreparedStatement2);
            localPreparedStatement1 = localPreparedStatement2;
            mInCache = true;
          }
        }
        mInUse = true;
        return localPreparedStatement2;
      }
      catch (RuntimeException paramString)
      {
        if ((localPreparedStatement1 == null) || (!mInCache)) {
          nativeFinalizeStatement(mConnectionPtr, j);
        }
        throw paramString;
      }
    }
  }
  
  private void applyBlockGuardPolicy(PreparedStatement paramPreparedStatement)
  {
    mConfiguration.isInMemoryDb();
  }
  
  private void attachCancellationSignal(CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null)
    {
      paramCancellationSignal.throwIfCanceled();
      mCancellationSignalAttachCount += 1;
      if (mCancellationSignalAttachCount == 1)
      {
        nativeResetCancel(mConnectionPtr, true);
        paramCancellationSignal.setOnCancelListener(this);
      }
    }
  }
  
  private void bindArguments(PreparedStatement paramPreparedStatement, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null) {}
    for (int i = paramArrayOfObject.length; i != mNumParameters; i = 0) {
      throw new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + mNumParameters + " bind arguments but " + i + " were provided.");
    }
    if (i == 0) {}
    int k;
    int j;
    do
    {
      return;
      k = mStatementPtr;
      j = 0;
    } while (j >= i);
    paramPreparedStatement = paramArrayOfObject[j];
    long l;
    switch (DatabaseUtils.getTypeOfObject(paramPreparedStatement))
    {
    case 3: 
    default: 
      if ((paramPreparedStatement instanceof Boolean))
      {
        int m = mConnectionPtr;
        if (((Boolean)paramPreparedStatement).booleanValue())
        {
          l = 1L;
          label150:
          nativeBindLong(m, k, j + 1, l);
        }
      }
      break;
    }
    for (;;)
    {
      j += 1;
      break;
      nativeBindNull(mConnectionPtr, k, j + 1);
      continue;
      nativeBindLong(mConnectionPtr, k, j + 1, ((Number)paramPreparedStatement).longValue());
      continue;
      nativeBindDouble(mConnectionPtr, k, j + 1, ((Number)paramPreparedStatement).doubleValue());
      continue;
      nativeBindBlob(mConnectionPtr, k, j + 1, (byte[])paramPreparedStatement);
      continue;
      l = 0L;
      break label150;
      nativeBindString(mConnectionPtr, k, j + 1, paramPreparedStatement.toString());
    }
  }
  
  private static String canonicalizeSyncMode(String paramString)
  {
    String str;
    if (paramString.equals("0")) {
      str = "OFF";
    }
    do
    {
      return str;
      if (paramString.equals("1")) {
        return "NORMAL";
      }
      str = paramString;
    } while (!paramString.equals("2"));
    return "FULL";
  }
  
  private void detachCancellationSignal(CancellationSignal paramCancellationSignal)
  {
    if (paramCancellationSignal != null)
    {
      assert (mCancellationSignalAttachCount > 0);
      mCancellationSignalAttachCount -= 1;
      if (mCancellationSignalAttachCount == 0)
      {
        paramCancellationSignal.setOnCancelListener(null);
        nativeResetCancel(mConnectionPtr, false);
      }
    }
  }
  
  private void dispose(boolean paramBoolean)
  {
    int i;
    if (mConnectionPtr != 0) {
      i = mRecentOperations.beginOperation("close", null, null).mCookie;
    }
    try
    {
      mPreparedStatementCache.evictAll();
      nativeClose(mConnectionPtr);
      mConnectionPtr = 0;
      return;
    }
    finally
    {
      mRecentOperations.endOperation(mConfiguration.path, getCurrentConnectionPtr(), i);
    }
  }
  
  private void finalizePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    nativeFinalizeStatement(mConnectionPtr, mStatementPtr);
    recyclePreparedStatement(paramPreparedStatement);
  }
  
  private SQLiteDebug.DbStats getMainDbStatsUnsafe(int paramInt, long paramLong1, long paramLong2)
  {
    String str2 = mConfiguration.path;
    String str1 = str2;
    if (!mIsPrimaryConnection) {
      str1 = str2 + " (" + mConnectionId + ")";
    }
    return new SQLiteDebug.DbStats(str1, paramLong1, paramLong2, paramInt, mPreparedStatementCache.hitCount(), mPreparedStatementCache.missCount(), mPreparedStatementCache.size());
  }
  
  private void initDb()
  {
    setForeignKeyModeFromConfiguration();
    setWalModeFromConfiguration();
    setJournalSizeLimit();
    setAutoCheckpointInterval();
    setLocaleFromConfiguration();
    int j = mConfiguration.customFunctions.size();
    int i = 0;
    while (i < j)
    {
      SQLiteCustomFunction localSQLiteCustomFunction = (SQLiteCustomFunction)mConfiguration.customFunctions.get(i);
      nativeRegisterCustomFunction(mConnectionPtr, localSQLiteCustomFunction);
      i += 1;
    }
  }
  
  private static boolean isCacheable(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1);
  }
  
  private static native void nativeBindBlob(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  private static native void nativeBindDouble(int paramInt1, int paramInt2, int paramInt3, double paramDouble);
  
  private static native void nativeBindLong(int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  private static native void nativeBindNull(int paramInt1, int paramInt2, int paramInt3);
  
  private static native void nativeBindString(int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  private static native void nativeCancel(int paramInt);
  
  private static native void nativeClose(int paramInt);
  
  private static native void nativeExecute(int paramInt1, int paramInt2);
  
  private static native int nativeExecuteForBlobFileDescriptor(int paramInt1, int paramInt2);
  
  private static native int nativeExecuteForChangedRowCount(int paramInt1, int paramInt2);
  
  private native long nativeExecuteForCursorDataWindow(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native long nativeExecuteForCursorWindow(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean);
  
  private static native long nativeExecuteForLastInsertedRowId(int paramInt1, int paramInt2);
  
  private static native long nativeExecuteForLong(int paramInt1, int paramInt2);
  
  private static native String nativeExecuteForString(int paramInt1, int paramInt2);
  
  private static native String nativeExplainQueryPlan(int paramInt, String paramString);
  
  private static native void nativeFinalizeStatement(int paramInt1, int paramInt2);
  
  private static native int nativeGetColumnCount(int paramInt1, int paramInt2);
  
  private static native String nativeGetColumnName(int paramInt1, int paramInt2, int paramInt3);
  
  private static native int nativeGetDbLookaside(int paramInt);
  
  private static native int[] nativeGetLastPageTrace(int paramInt);
  
  private static native int nativeGetParameterCount(int paramInt1, int paramInt2);
  
  private static native boolean nativeIsReadOnly(int paramInt1, int paramInt2);
  
  private static native int nativeOpen(String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  private static native int nativePrepareStatement(int paramInt, String paramString);
  
  private static native void nativeRegisterCustomFunction(int paramInt, SQLiteCustomFunction paramSQLiteCustomFunction);
  
  private static native void nativeRegisterLocalizedCollators(int paramInt, String paramString);
  
  private static native void nativeResetCancel(int paramInt, boolean paramBoolean);
  
  private static native void nativeResetStatementAndClearBindings(int paramInt1, int paramInt2);
  
  private static native void nativeSetKey(int paramInt1, int paramInt2, String paramString, int paramInt3);
  
  private PreparedStatement obtainPreparedStatement(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    PreparedStatement localPreparedStatement = mPreparedStatementPool;
    if (localPreparedStatement != null)
    {
      mPreparedStatementPool = mPoolNext;
      mPoolNext = null;
      mInCache = false;
    }
    for (;;)
    {
      mSql = paramString;
      mStatementPtr = paramInt1;
      mNumParameters = paramInt2;
      mType = paramInt3;
      mReadOnly = paramBoolean;
      return localPreparedStatement;
      localPreparedStatement = new PreparedStatement(null);
    }
  }
  
  static SQLiteConnection open(SQLiteConnectionPool paramSQLiteConnectionPool, SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration, int paramInt1, boolean paramBoolean1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramSQLiteConnectionPool = new SQLiteConnection(paramSQLiteConnectionPool, paramSQLiteDatabaseConfiguration, paramInt1, paramBoolean1, paramInt2, paramString, paramInt3, paramBoolean2, paramBoolean3);
    try
    {
      paramSQLiteConnectionPool.open();
      return paramSQLiteConnectionPool;
    }
    catch (SQLiteException paramSQLiteDatabaseConfiguration)
    {
      paramSQLiteConnectionPool.dispose(false);
      throw paramSQLiteDatabaseConfiguration;
    }
  }
  
  private void open()
  {
    mConnectionPtr = nativeOpen(mConfiguration.path, mConfiguration.openFlags, mConfiguration.label, false, false, mPageTrace);
    setPageSize();
    nativeSetKey(mConnectionPtr, mlockedDevice, mPassword, mArithmetic);
    if (!mIsInitWaited) {
      initDb();
    }
  }
  
  private void recyclePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    mSql = null;
    mPoolNext = mPreparedStatementPool;
    mPreparedStatementPool = paramPreparedStatement;
  }
  
  private void releasePreparedStatement(PreparedStatement paramPreparedStatement)
  {
    mInUse = false;
    if (mInCache) {
      try
      {
        nativeResetStatementAndClearBindings(mConnectionPtr, mStatementPtr);
        return;
      }
      catch (SQLiteException localSQLiteException)
      {
        mPreparedStatementCache.remove(mSql);
        return;
      }
    }
    finalizePreparedStatement(paramPreparedStatement);
  }
  
  private void setAutoCheckpointInterval()
  {
    if ((!mConfiguration.isInMemoryDb()) && (!mIsReadOnlyConnection))
    {
      long l = SQLiteGlobal.getWALAutoCheckpoint();
      if (executeForLong("PRAGMA wal_autocheckpoint", null, null) != l) {
        executeForLong("PRAGMA wal_autocheckpoint=" + l, null, null);
      }
    }
  }
  
  private void setForeignKeyModeFromConfiguration()
  {
    if (!mIsReadOnlyConnection) {
      if (!mConfiguration.foreignKeyConstraintsEnabled) {
        break label57;
      }
    }
    label57:
    for (long l = 1L;; l = 0L)
    {
      if (executeForLong("PRAGMA foreign_keys", null, null) != l) {
        execute("PRAGMA foreign_keys=" + l, null, null);
      }
      return;
    }
  }
  
  private void setJournalMode(String paramString)
  {
    String str = executeForString("PRAGMA journal_mode", null, null);
    if (!str.equalsIgnoreCase(paramString)) {}
    try
    {
      boolean bool = executeForString("PRAGMA journal_mode=" + paramString, null, null).equalsIgnoreCase(paramString);
      if (bool) {
        return;
      }
    }
    catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
    {
      Log.w("MicroMsg.kkdb.SQLiteConnection", "Could not change the database journal mode of '" + mConfiguration.label + "' from '" + str + "' to '" + paramString + "' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
    }
  }
  
  private void setJournalSizeLimit()
  {
    if ((!mConfiguration.isInMemoryDb()) && (!mIsReadOnlyConnection))
    {
      long l = SQLiteGlobal.getJournalSizeLimit();
      if (executeForLong("PRAGMA journal_size_limit", null, null) != l) {
        executeForLong("PRAGMA journal_size_limit=" + l, null, null);
      }
    }
  }
  
  /* Error */
  private void setLocaleFromConfiguration()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   4: astore_1
    //   5: aload_1
    //   6: aload_1
    //   7: getfield 125	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:openFlags	I
    //   10: bipush 16
    //   12: ior
    //   13: putfield 125	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:openFlags	I
    //   16: aload_0
    //   17: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   20: getfield 125	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:openFlags	I
    //   23: bipush 16
    //   25: iand
    //   26: ifeq +4 -> 30
    //   29: return
    //   30: aload_0
    //   31: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   34: getfield 541	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:locale	Ljava/util/Locale;
    //   37: invokevirtual 544	java/util/Locale:toString	()Ljava/lang/String;
    //   40: astore_1
    //   41: aload_0
    //   42: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   45: aload_1
    //   46: invokestatic 546	com/tencent/kingkong/database/SQLiteConnection:nativeRegisterLocalizedCollators	(ILjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 127	com/tencent/kingkong/database/SQLiteConnection:mIsReadOnlyConnection	Z
    //   53: ifne -24 -> 29
    //   56: aload_0
    //   57: ldc_w 548
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 501	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   65: aload_0
    //   66: ldc_w 550
    //   69: aconst_null
    //   70: aconst_null
    //   71: invokevirtual 510	com/tencent/kingkong/database/SQLiteConnection:executeForString	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)Ljava/lang/String;
    //   74: astore_2
    //   75: aload_2
    //   76: ifnull +11 -> 87
    //   79: aload_2
    //   80: aload_1
    //   81: invokevirtual 305	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifne -55 -> 29
    //   87: aload_0
    //   88: ldc_w 552
    //   91: aconst_null
    //   92: aconst_null
    //   93: invokevirtual 501	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   96: aload_0
    //   97: ldc_w 554
    //   100: aconst_null
    //   101: aconst_null
    //   102: invokevirtual 501	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   105: aload_0
    //   106: ldc_w 556
    //   109: iconst_1
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload_1
    //   116: aastore
    //   117: aconst_null
    //   118: invokevirtual 501	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   121: aload_0
    //   122: ldc_w 558
    //   125: aconst_null
    //   126: aconst_null
    //   127: invokevirtual 501	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   130: aload_0
    //   131: ldc_w 560
    //   134: aconst_null
    //   135: aconst_null
    //   136: invokevirtual 501	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   139: return
    //   140: astore_2
    //   141: new 450	com/tencent/kingkong/database/SQLiteException
    //   144: dup
    //   145: new 233	java/lang/StringBuilder
    //   148: dup
    //   149: ldc_w 562
    //   152: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_0
    //   156: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   159: getfield 459	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:label	Ljava/lang/String;
    //   162: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 522
    //   168: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_1
    //   172: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc_w 564
    //   178: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: aload_2
    //   185: invokespecial 567	com/tencent/kingkong/database/SQLiteException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: athrow
    //   189: astore_2
    //   190: aload_0
    //   191: ldc_w 569
    //   194: aconst_null
    //   195: aconst_null
    //   196: invokevirtual 501	com/tencent/kingkong/database/SQLiteConnection:execute	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   199: aload_2
    //   200: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	SQLiteConnection
    //   4	168	1	localObject1	Object
    //   74	6	2	str	String
    //   140	45	2	localRuntimeException	RuntimeException
    //   189	11	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   56	75	140	java/lang/RuntimeException
    //   79	87	140	java/lang/RuntimeException
    //   87	96	140	java/lang/RuntimeException
    //   130	139	140	java/lang/RuntimeException
    //   190	201	140	java/lang/RuntimeException
    //   96	130	189	finally
  }
  
  private void setPageSize()
  {
    if ((!mConfiguration.isInMemoryDb()) && (!mIsReadOnlyConnection))
    {
      long l = SQLiteGlobal.getDefaultPageSize();
      if (executeForLong("PRAGMA page_size", null, null) != l) {
        execute("PRAGMA page_size=" + l, null, null);
      }
    }
  }
  
  private void setSyncMode(String paramString)
  {
    if (!canonicalizeSyncMode(executeForString("PRAGMA synchronous", null, null)).equalsIgnoreCase(canonicalizeSyncMode(paramString))) {
      execute("PRAGMA synchronous=" + paramString, null, null);
    }
  }
  
  private void setWalModeFromConfiguration()
  {
    if ((!mConfiguration.isInMemoryDb()) && (!mIsReadOnlyConnection))
    {
      if ((mConfiguration.openFlags & 0x20000000) != 0)
      {
        setJournalMode("WAL");
        setSyncMode(SQLiteGlobal.getWALSyncMode());
      }
    }
    else {
      return;
    }
    setJournalMode(SQLiteGlobal.getDefaultJournalMode());
    setSyncMode(SQLiteGlobal.getDefaultSyncMode());
  }
  
  private void throwIfStatementForbidden(PreparedStatement paramPreparedStatement)
  {
    if ((mOnlyAllowReadOnlyOperations) && (!mReadOnly)) {
      throw new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
    }
  }
  
  private static String trimSqlForDisplay(String paramString)
  {
    return TRIM_SQL_PATTERN.matcher(paramString).replaceAll(" ");
  }
  
  final void OverInitWaitedDefault()
  {
    if (mIsInitWaited)
    {
      boolean bool = mOnlyAllowReadOnlyOperations;
      if (bool) {
        mOnlyAllowReadOnlyOperations = false;
      }
      initDb();
      if (bool) {
        mOnlyAllowReadOnlyOperations = bool;
      }
    }
  }
  
  public final void allDataEnd(int paramInt1, int paramInt2)
  {
    if (currentFillingWindow != null)
    {
      b localb = currentFillingWindow;
      bkj = null;
      bkg = bkf.size();
      Log.i("MicroMsg.kkdb.CursorDataWindow", "newcursor fillEnd posistionMaps.size is   %d ,data size is :%d", new Object[] { Integer.valueOf(bkg), Integer.valueOf(bkh.size()) });
      windowAllocatedSize += paramInt2;
      return;
    }
    currentFillingDbCursor = null;
    rb = null;
    currentFillingWindow = null;
  }
  
  final void close()
  {
    dispose(false);
  }
  
  final void collectDbStats(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    int i = nativeGetDbLookaside(mConnectionPtr);
    long l1 = 0L;
    long l3 = 0L;
    try
    {
      l2 = executeForLong("PRAGMA page_count;", null, null);
      l1 = l2;
      l4 = executeForLong("PRAGMA page_size;", null, null);
      l3 = l4;
      l1 = l2;
    }
    catch (SQLiteException localSQLiteException1)
    {
      long l2;
      long l4;
      CursorWindow localCursorWindow;
      label288:
      for (;;) {}
    }
    paramArrayList.add(getMainDbStatsUnsafe(i, l1, l3));
    localCursorWindow = new CursorWindow("collectDbStats");
    try
    {
      executeForCursorWindow("PRAGMA database_list;", null, localCursorWindow, 0, 0, false, null);
      i = 1;
      for (;;)
      {
        if (i >= localCursorWindow.getNumRows()) {
          break label288;
        }
        Object localObject = localCursorWindow.getString(i, 1);
        String str2 = localCursorWindow.getString(i, 2);
        l1 = 0L;
        l3 = 0L;
        try
        {
          l2 = executeForLong("PRAGMA " + (String)localObject + ".page_count;", null, null);
          l1 = l2;
          l4 = executeForLong("PRAGMA " + (String)localObject + ".page_size;", null, null);
          l1 = l4;
        }
        catch (SQLiteException localSQLiteException2)
        {
          for (;;)
          {
            String str1;
            l2 = l1;
            l1 = l3;
          }
        }
        str1 = "  (attached) " + (String)localObject;
        localObject = str1;
        if (str2.length() != 0) {
          localObject = str1 + ": " + str2;
        }
        paramArrayList.add(new SQLiteDebug.DbStats((String)localObject, l2, l1, 0, 0, 0, 0));
        i += 1;
      }
      return;
    }
    catch (SQLiteException paramArrayList) {}finally
    {
      localCursorWindow.close();
    }
  }
  
  final void collectDbStatsUnsafe(ArrayList<SQLiteDebug.DbStats> paramArrayList)
  {
    paramArrayList.add(getMainDbStatsUnsafe(0, 0L, 0L));
  }
  
  final String describeCurrentOperationUnsafe()
  {
    return mRecentOperations.describeCurrentOperation();
  }
  
  public final void dump(boolean paramBoolean)
  {
    dumpUnsafe(paramBoolean);
  }
  
  final void dumpUnsafe(boolean paramBoolean)
  {
    Log.i("MicroMsg.kkdb.SQLiteConnection", "Connection #" + mConnectionId + ":");
    if (paramBoolean) {
      Log.i("MicroMsg.kkdb.SQLiteConnection", "  connectionPtr: 0x" + Integer.toHexString(mConnectionPtr));
    }
    Log.i("MicroMsg.kkdb.SQLiteConnection", "  isPrimaryConnection: " + mIsPrimaryConnection);
    Log.i("MicroMsg.kkdb.SQLiteConnection", "  onlyAllowReadOnlyOperations: " + mOnlyAllowReadOnlyOperations);
    mRecentOperations.dump(paramBoolean);
    if (paramBoolean) {
      mPreparedStatementCache.dump();
    }
  }
  
  /* Error */
  public final void execute(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 743	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 745
    //   11: invokespecial 746	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 747
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 327	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/kingkong/database/SQLiteConnection$Operation;
    //   27: astore 5
    //   29: aload 5
    //   31: getfield 330	com/tencent/kingkong/database/SQLiteConnection$Operation:mCookie	I
    //   34: istore 4
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 749	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   41: astore_1
    //   42: aload 5
    //   44: aload_1
    //   45: getfield 442	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mType	I
    //   48: invokevirtual 752	com/tencent/kingkong/database/SQLiteConnection$Operation:bindStamentType	(I)V
    //   51: aload_0
    //   52: aload_1
    //   53: invokespecial 754	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   56: aload_0
    //   57: aload_1
    //   58: aload_2
    //   59: invokespecial 756	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   62: aload_0
    //   63: aload_1
    //   64: invokespecial 758	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   67: aload_0
    //   68: aload_3
    //   69: invokespecial 760	com/tencent/kingkong/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   72: aload_0
    //   73: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   76: aload_1
    //   77: getfield 257	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   80: invokestatic 762	com/tencent/kingkong/database/SQLiteConnection:nativeExecute	(II)V
    //   83: aload_0
    //   84: aload_3
    //   85: invokespecial 764	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   88: aload_0
    //   89: aload_1
    //   90: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   93: aload_0
    //   94: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   97: aload_0
    //   98: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   101: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   104: aload_0
    //   105: invokevirtual 344	com/tencent/kingkong/database/SQLiteConnection:getCurrentConnectionPtr	()I
    //   108: iload 4
    //   110: invokevirtual 348	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(Ljava/lang/String;II)V
    //   113: return
    //   114: astore_2
    //   115: aload_0
    //   116: aload_3
    //   117: invokespecial 764	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   120: aload_2
    //   121: athrow
    //   122: astore_2
    //   123: aload_0
    //   124: aload_1
    //   125: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   128: aload_2
    //   129: athrow
    //   130: astore_1
    //   131: aload_1
    //   132: instanceof 504
    //   135: ifne +10 -> 145
    //   138: aload_1
    //   139: instanceof 768
    //   142: ifeq +17 -> 159
    //   145: aload_0
    //   146: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   149: ifnull +10 -> 159
    //   152: aload_0
    //   153: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   156: invokevirtual 773	com/tencent/kingkong/database/SQLiteConnectionPool:logConnectionPoolBusy	()V
    //   159: aload_0
    //   160: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   163: iload 4
    //   165: aload_1
    //   166: invokevirtual 777	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   169: aload_1
    //   170: athrow
    //   171: astore_1
    //   172: aload_0
    //   173: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   176: aload_0
    //   177: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   180: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   183: aload_0
    //   184: invokevirtual 344	com/tencent/kingkong/database/SQLiteConnection:getCurrentConnectionPtr	()I
    //   187: iload 4
    //   189: invokevirtual 348	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(Ljava/lang/String;II)V
    //   192: aload_1
    //   193: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	SQLiteConnection
    //   0	194	1	paramString	String
    //   0	194	2	paramArrayOfObject	Object[]
    //   0	194	3	paramCancellationSignal	CancellationSignal
    //   34	154	4	i	int
    //   27	16	5	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   72	83	114	finally
    //   51	72	122	finally
    //   83	88	122	finally
    //   115	122	122	finally
    //   36	51	130	java/lang/RuntimeException
    //   88	93	130	java/lang/RuntimeException
    //   123	130	130	java/lang/RuntimeException
    //   36	51	171	finally
    //   88	93	171	finally
    //   123	130	171	finally
    //   131	145	171	finally
    //   145	159	171	finally
    //   159	171	171	finally
  }
  
  /* Error */
  public final com.tencent.kingkong.ParcelFileDescriptor executeForBlobFileDescriptor(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 743	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 745
    //   11: invokespecial 746	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 780
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 327	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/kingkong/database/SQLiteConnection$Operation;
    //   27: astore 7
    //   29: aload 7
    //   31: getfield 330	com/tencent/kingkong/database/SQLiteConnection$Operation:mCookie	I
    //   34: istore 4
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 749	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   41: astore 6
    //   43: aload 7
    //   45: aload 6
    //   47: getfield 442	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mType	I
    //   50: invokevirtual 752	com/tencent/kingkong/database/SQLiteConnection$Operation:bindStamentType	(I)V
    //   53: aload_0
    //   54: aload 6
    //   56: invokespecial 754	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   59: aload_0
    //   60: aload 6
    //   62: aload_2
    //   63: invokespecial 756	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   66: aload_0
    //   67: aload 6
    //   69: invokespecial 758	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   72: aload_0
    //   73: aload_3
    //   74: invokespecial 760	com/tencent/kingkong/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   77: aload_0
    //   78: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   81: aload 6
    //   83: getfield 257	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   86: invokestatic 782	com/tencent/kingkong/database/SQLiteConnection:nativeExecuteForBlobFileDescriptor	(II)I
    //   89: istore 5
    //   91: iload 5
    //   93: iflt +42 -> 135
    //   96: iload 5
    //   98: invokestatic 788	com/tencent/kingkong/ParcelFileDescriptor:adoptFd	(I)Lcom/tencent/kingkong/ParcelFileDescriptor;
    //   101: astore_1
    //   102: aload_0
    //   103: aload_3
    //   104: invokespecial 764	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   107: aload_0
    //   108: aload 6
    //   110: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   113: aload_0
    //   114: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   117: aload_0
    //   118: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   121: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   124: aload_0
    //   125: invokevirtual 344	com/tencent/kingkong/database/SQLiteConnection:getCurrentConnectionPtr	()I
    //   128: iload 4
    //   130: invokevirtual 348	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(Ljava/lang/String;II)V
    //   133: aload_1
    //   134: areturn
    //   135: aconst_null
    //   136: astore_1
    //   137: goto -35 -> 102
    //   140: astore_1
    //   141: aload_0
    //   142: aload_3
    //   143: invokespecial 764	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   146: aload_1
    //   147: athrow
    //   148: astore_1
    //   149: aload_0
    //   150: aload 6
    //   152: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   155: aload_1
    //   156: athrow
    //   157: astore_1
    //   158: aload_1
    //   159: instanceof 504
    //   162: ifne +10 -> 172
    //   165: aload_1
    //   166: instanceof 768
    //   169: ifeq +17 -> 186
    //   172: aload_0
    //   173: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   176: ifnull +10 -> 186
    //   179: aload_0
    //   180: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   183: invokevirtual 773	com/tencent/kingkong/database/SQLiteConnectionPool:logConnectionPoolBusy	()V
    //   186: aload_0
    //   187: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   190: iload 4
    //   192: aload_1
    //   193: invokevirtual 777	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: aload_0
    //   200: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   203: aload_0
    //   204: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   207: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   210: aload_0
    //   211: invokevirtual 344	com/tencent/kingkong/database/SQLiteConnection:getCurrentConnectionPtr	()I
    //   214: iload 4
    //   216: invokevirtual 348	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(Ljava/lang/String;II)V
    //   219: aload_1
    //   220: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	SQLiteConnection
    //   0	221	1	paramString	String
    //   0	221	2	paramArrayOfObject	Object[]
    //   0	221	3	paramCancellationSignal	CancellationSignal
    //   34	181	4	i	int
    //   89	8	5	j	int
    //   41	110	6	localPreparedStatement	PreparedStatement
    //   27	17	7	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   77	91	140	finally
    //   96	102	140	finally
    //   53	77	148	finally
    //   102	107	148	finally
    //   141	148	148	finally
    //   36	53	157	java/lang/RuntimeException
    //   107	113	157	java/lang/RuntimeException
    //   149	157	157	java/lang/RuntimeException
    //   36	53	198	finally
    //   107	113	198	finally
    //   149	157	198	finally
    //   158	172	198	finally
    //   172	186	198	finally
    //   186	198	198	finally
  }
  
  /* Error */
  public final int executeForChangedRowCount(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 743	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 745
    //   11: invokespecial 746	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 791
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 327	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/kingkong/database/SQLiteConnection$Operation;
    //   27: astore 9
    //   29: aload 9
    //   31: getfield 330	com/tencent/kingkong/database/SQLiteConnection$Operation:mCookie	I
    //   34: istore 7
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 749	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   41: astore 8
    //   43: aload 9
    //   45: aload 8
    //   47: getfield 442	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mType	I
    //   50: invokevirtual 752	com/tencent/kingkong/database/SQLiteConnection$Operation:bindStamentType	(I)V
    //   53: aload_0
    //   54: aload 8
    //   56: invokespecial 754	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   59: aload_0
    //   60: aload 8
    //   62: aload_2
    //   63: invokespecial 756	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   66: aload_0
    //   67: aload 8
    //   69: invokespecial 758	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   72: aload_0
    //   73: aload_3
    //   74: invokespecial 760	com/tencent/kingkong/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   77: aload_0
    //   78: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   81: aload 8
    //   83: getfield 257	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   86: invokestatic 793	com/tencent/kingkong/database/SQLiteConnection:nativeExecuteForChangedRowCount	(II)I
    //   89: istore 5
    //   91: aload_0
    //   92: aload_3
    //   93: invokespecial 764	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   96: iload 5
    //   98: istore 6
    //   100: iload 5
    //   102: istore 4
    //   104: aload_0
    //   105: aload 8
    //   107: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   110: aload_0
    //   111: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   114: aload_0
    //   115: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   118: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   121: aload_0
    //   122: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   125: iload 7
    //   127: invokevirtual 797	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperationDeferLog	(Ljava/lang/String;II)Z
    //   130: ifeq +60 -> 190
    //   133: aload_0
    //   134: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   137: iload 7
    //   139: new 233	java/lang/StringBuilder
    //   142: dup
    //   143: ldc_w 799
    //   146: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: iload 5
    //   151: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 802	com/tencent/kingkong/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   160: aload_0
    //   161: aload_1
    //   162: invokevirtual 805	com/tencent/kingkong/database/SQLiteConnection:explainQueryPlan	(Ljava/lang/String;)Ljava/lang/String;
    //   165: astore_2
    //   166: aload_2
    //   167: ifnull +23 -> 190
    //   170: ldc 32
    //   172: ldc_w 807
    //   175: iconst_2
    //   176: anewarray 4	java/lang/Object
    //   179: dup
    //   180: iconst_0
    //   181: aload_1
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: aload_2
    //   186: aastore
    //   187: invokestatic 657	com/tencent/kingkong/support/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: iload 5
    //   192: ireturn
    //   193: astore_2
    //   194: aload_0
    //   195: aload_3
    //   196: invokespecial 764	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   199: aload_2
    //   200: athrow
    //   201: astore_2
    //   202: iconst_0
    //   203: istore 5
    //   205: iload 5
    //   207: istore 6
    //   209: iload 5
    //   211: istore 4
    //   213: aload_0
    //   214: aload 8
    //   216: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   219: iload 5
    //   221: istore 6
    //   223: iload 5
    //   225: istore 4
    //   227: aload_2
    //   228: athrow
    //   229: astore_2
    //   230: iload 6
    //   232: istore 4
    //   234: aload_2
    //   235: instanceof 504
    //   238: ifne +14 -> 252
    //   241: iload 6
    //   243: istore 4
    //   245: aload_2
    //   246: instanceof 768
    //   249: ifeq +25 -> 274
    //   252: iload 6
    //   254: istore 4
    //   256: aload_0
    //   257: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   260: ifnull +14 -> 274
    //   263: iload 6
    //   265: istore 4
    //   267: aload_0
    //   268: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   271: invokevirtual 773	com/tencent/kingkong/database/SQLiteConnectionPool:logConnectionPoolBusy	()V
    //   274: iload 6
    //   276: istore 4
    //   278: aload_0
    //   279: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   282: iload 7
    //   284: aload_2
    //   285: invokevirtual 777	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   288: iload 6
    //   290: istore 4
    //   292: aload_2
    //   293: athrow
    //   294: astore_2
    //   295: aload_0
    //   296: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   299: aload_0
    //   300: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   303: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   306: aload_0
    //   307: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   310: iload 7
    //   312: invokevirtual 797	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperationDeferLog	(Ljava/lang/String;II)Z
    //   315: ifeq +60 -> 375
    //   318: aload_0
    //   319: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   322: iload 7
    //   324: new 233	java/lang/StringBuilder
    //   327: dup
    //   328: ldc_w 799
    //   331: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: iload 4
    //   336: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokevirtual 802	com/tencent/kingkong/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   345: aload_0
    //   346: aload_1
    //   347: invokevirtual 805	com/tencent/kingkong/database/SQLiteConnection:explainQueryPlan	(Ljava/lang/String;)Ljava/lang/String;
    //   350: astore_3
    //   351: aload_3
    //   352: ifnull +23 -> 375
    //   355: ldc 32
    //   357: ldc_w 807
    //   360: iconst_2
    //   361: anewarray 4	java/lang/Object
    //   364: dup
    //   365: iconst_0
    //   366: aload_1
    //   367: aastore
    //   368: dup
    //   369: iconst_1
    //   370: aload_3
    //   371: aastore
    //   372: invokestatic 657	com/tencent/kingkong/support/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   375: aload_2
    //   376: athrow
    //   377: astore_2
    //   378: iconst_0
    //   379: istore 4
    //   381: goto -86 -> 295
    //   384: astore_2
    //   385: iconst_0
    //   386: istore 6
    //   388: goto -158 -> 230
    //   391: astore_2
    //   392: goto -187 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	SQLiteConnection
    //   0	395	1	paramString	String
    //   0	395	2	paramArrayOfObject	Object[]
    //   0	395	3	paramCancellationSignal	CancellationSignal
    //   102	278	4	i	int
    //   89	135	5	j	int
    //   98	289	6	k	int
    //   34	289	7	m	int
    //   41	174	8	localPreparedStatement	PreparedStatement
    //   27	17	9	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   77	91	193	finally
    //   53	77	201	finally
    //   194	201	201	finally
    //   104	110	229	java/lang/RuntimeException
    //   213	219	229	java/lang/RuntimeException
    //   227	229	229	java/lang/RuntimeException
    //   104	110	294	finally
    //   213	219	294	finally
    //   227	229	294	finally
    //   234	241	294	finally
    //   245	252	294	finally
    //   256	263	294	finally
    //   267	274	294	finally
    //   278	288	294	finally
    //   292	294	294	finally
    //   36	53	377	finally
    //   36	53	384	java/lang/RuntimeException
    //   91	96	391	finally
  }
  
  /* Error */
  public final int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3, b paramb, d paramd)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: aload_1
    //   3: ifnonnull +14 -> 17
    //   6: new 743	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc_w 745
    //   13: invokespecial 746	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload 6
    //   19: ifnull +8 -> 27
    //   22: aload 6
    //   24: invokevirtual 811	com/tencent/mm/dbsupport/newcursor/b:acquireReference	()V
    //   27: aload_0
    //   28: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   31: ldc_w 812
    //   34: aload_1
    //   35: aload_2
    //   36: invokevirtual 327	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/kingkong/database/SQLiteConnection$Operation;
    //   39: astore 19
    //   41: aload 19
    //   43: getfield 330	com/tencent/kingkong/database/SQLiteConnection$Operation:mCookie	I
    //   46: istore 15
    //   48: aload_0
    //   49: aload_1
    //   50: invokespecial 749	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   53: astore 18
    //   55: aload 19
    //   57: aload 18
    //   59: getfield 442	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mType	I
    //   62: invokevirtual 752	com/tencent/kingkong/database/SQLiteConnection$Operation:bindStamentType	(I)V
    //   65: aload_0
    //   66: aload 18
    //   68: invokespecial 754	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   71: aload_0
    //   72: aload 18
    //   74: aload_2
    //   75: invokespecial 756	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   78: aload_0
    //   79: aload 18
    //   81: invokespecial 758	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   84: aload_0
    //   85: aload 6
    //   87: putfield 620	com/tencent/kingkong/database/SQLiteConnection:currentFillingWindow	Lcom/tencent/mm/dbsupport/newcursor/b;
    //   90: aload_0
    //   91: aload 7
    //   93: putfield 661	com/tencent/kingkong/database/SQLiteConnection:currentFillingDbCursor	Lcom/tencent/mm/dbsupport/newcursor/d;
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   101: aload 18
    //   103: getfield 257	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   106: iload 4
    //   108: iload 5
    //   110: invokespecial 814	com/tencent/kingkong/database/SQLiteConnection:nativeExecuteForCursorDataWindow	(IIII)J
    //   113: lstore 16
    //   115: lload 16
    //   117: bipush 32
    //   119: lshr
    //   120: l2i
    //   121: istore 11
    //   123: lload 16
    //   125: l2i
    //   126: istore 10
    //   128: iload_3
    //   129: istore 9
    //   131: aload 6
    //   133: ifnull +23 -> 156
    //   136: aload 6
    //   138: getfield 630	com/tencent/mm/dbsupport/newcursor/b:bkf	Landroid/util/SparseArray;
    //   141: invokevirtual 633	android/util/SparseArray:size	()I
    //   144: istore 9
    //   146: iload 9
    //   148: istore_3
    //   149: aload 6
    //   151: iload 11
    //   153: putfield 817	com/tencent/mm/dbsupport/newcursor/b:mStartPos	I
    //   156: iload 9
    //   158: istore 12
    //   160: iload 10
    //   162: istore 13
    //   164: iload 11
    //   166: istore 14
    //   168: iload 9
    //   170: istore_3
    //   171: iload 10
    //   173: istore 5
    //   175: iload 11
    //   177: istore 8
    //   179: aload_0
    //   180: aload 18
    //   182: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   185: iload 9
    //   187: istore 12
    //   189: iload 10
    //   191: istore 13
    //   193: iload 11
    //   195: istore 14
    //   197: iload 9
    //   199: istore_3
    //   200: iload 10
    //   202: istore 5
    //   204: iload 11
    //   206: istore 8
    //   208: aload_0
    //   209: aconst_null
    //   210: putfield 620	com/tencent/kingkong/database/SQLiteConnection:currentFillingWindow	Lcom/tencent/mm/dbsupport/newcursor/b;
    //   213: iload 9
    //   215: istore 12
    //   217: iload 10
    //   219: istore 13
    //   221: iload 11
    //   223: istore 14
    //   225: iload 9
    //   227: istore_3
    //   228: iload 10
    //   230: istore 5
    //   232: iload 11
    //   234: istore 8
    //   236: aload_0
    //   237: aconst_null
    //   238: putfield 661	com/tencent/kingkong/database/SQLiteConnection:currentFillingDbCursor	Lcom/tencent/mm/dbsupport/newcursor/d;
    //   241: aload_0
    //   242: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   245: aload_0
    //   246: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   249: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   252: aload_0
    //   253: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   256: iload 15
    //   258: invokevirtual 797	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperationDeferLog	(Ljava/lang/String;II)Z
    //   261: ifeq +104 -> 365
    //   264: aload_0
    //   265: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   268: iload 15
    //   270: new 233	java/lang/StringBuilder
    //   273: dup
    //   274: ldc_w 819
    //   277: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   280: aload 6
    //   282: invokevirtual 822	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: ldc_w 824
    //   288: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: iload 4
    //   293: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: ldc_w 826
    //   299: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: iload 11
    //   304: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: ldc_w 828
    //   310: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: iload 9
    //   315: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: ldc_w 830
    //   321: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: iload 10
    //   326: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokevirtual 802	com/tencent/kingkong/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   335: aload_0
    //   336: aload_1
    //   337: invokevirtual 805	com/tencent/kingkong/database/SQLiteConnection:explainQueryPlan	(Ljava/lang/String;)Ljava/lang/String;
    //   340: astore_2
    //   341: aload_2
    //   342: ifnull +23 -> 365
    //   345: ldc 32
    //   347: ldc_w 807
    //   350: iconst_2
    //   351: anewarray 4	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: aload_1
    //   357: aastore
    //   358: dup
    //   359: iconst_1
    //   360: aload_2
    //   361: aastore
    //   362: invokestatic 657	com/tencent/kingkong/support/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   365: aload 6
    //   367: ifnull +8 -> 375
    //   370: aload 6
    //   372: invokevirtual 833	com/tencent/mm/dbsupport/newcursor/b:releaseReference	()V
    //   375: iload 10
    //   377: ireturn
    //   378: astore_2
    //   379: iconst_m1
    //   380: istore 10
    //   382: iconst_m1
    //   383: istore 11
    //   385: iload_3
    //   386: istore 9
    //   388: iload 9
    //   390: istore 12
    //   392: iload 10
    //   394: istore 13
    //   396: iload 11
    //   398: istore 14
    //   400: iload 9
    //   402: istore_3
    //   403: iload 10
    //   405: istore 5
    //   407: iload 11
    //   409: istore 8
    //   411: aload_0
    //   412: aload 18
    //   414: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   417: iload 9
    //   419: istore 12
    //   421: iload 10
    //   423: istore 13
    //   425: iload 11
    //   427: istore 14
    //   429: iload 9
    //   431: istore_3
    //   432: iload 10
    //   434: istore 5
    //   436: iload 11
    //   438: istore 8
    //   440: aload_0
    //   441: aconst_null
    //   442: putfield 620	com/tencent/kingkong/database/SQLiteConnection:currentFillingWindow	Lcom/tencent/mm/dbsupport/newcursor/b;
    //   445: iload 9
    //   447: istore 12
    //   449: iload 10
    //   451: istore 13
    //   453: iload 11
    //   455: istore 14
    //   457: iload 9
    //   459: istore_3
    //   460: iload 10
    //   462: istore 5
    //   464: iload 11
    //   466: istore 8
    //   468: aload_0
    //   469: aconst_null
    //   470: putfield 661	com/tencent/kingkong/database/SQLiteConnection:currentFillingDbCursor	Lcom/tencent/mm/dbsupport/newcursor/d;
    //   473: iload 9
    //   475: istore 12
    //   477: iload 10
    //   479: istore 13
    //   481: iload 11
    //   483: istore 14
    //   485: iload 9
    //   487: istore_3
    //   488: iload 10
    //   490: istore 5
    //   492: iload 11
    //   494: istore 8
    //   496: aload_2
    //   497: athrow
    //   498: astore_2
    //   499: iload 12
    //   501: istore_3
    //   502: iload 13
    //   504: istore 5
    //   506: iload 14
    //   508: istore 8
    //   510: aload_2
    //   511: instanceof 504
    //   514: ifne +21 -> 535
    //   517: iload 12
    //   519: istore_3
    //   520: iload 13
    //   522: istore 5
    //   524: iload 14
    //   526: istore 8
    //   528: aload_2
    //   529: instanceof 768
    //   532: ifeq +39 -> 571
    //   535: iload 12
    //   537: istore_3
    //   538: iload 13
    //   540: istore 5
    //   542: iload 14
    //   544: istore 8
    //   546: aload_0
    //   547: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   550: ifnull +21 -> 571
    //   553: iload 12
    //   555: istore_3
    //   556: iload 13
    //   558: istore 5
    //   560: iload 14
    //   562: istore 8
    //   564: aload_0
    //   565: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   568: invokevirtual 773	com/tencent/kingkong/database/SQLiteConnectionPool:logConnectionPoolBusy	()V
    //   571: iload 12
    //   573: istore_3
    //   574: iload 13
    //   576: istore 5
    //   578: iload 14
    //   580: istore 8
    //   582: aload_0
    //   583: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   586: iload 15
    //   588: aload_2
    //   589: invokevirtual 777	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   592: iload 12
    //   594: istore_3
    //   595: iload 13
    //   597: istore 5
    //   599: iload 14
    //   601: istore 8
    //   603: aload_2
    //   604: athrow
    //   605: astore_2
    //   606: aload_0
    //   607: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   610: aload_0
    //   611: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   614: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   617: aload_0
    //   618: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   621: iload 15
    //   623: invokevirtual 797	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperationDeferLog	(Ljava/lang/String;II)Z
    //   626: ifeq +106 -> 732
    //   629: aload_0
    //   630: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   633: iload 15
    //   635: new 233	java/lang/StringBuilder
    //   638: dup
    //   639: ldc_w 819
    //   642: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   645: aload 6
    //   647: invokevirtual 822	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   650: ldc_w 824
    //   653: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: iload 4
    //   658: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   661: ldc_w 826
    //   664: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: iload 8
    //   669: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   672: ldc_w 828
    //   675: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: iload_3
    //   679: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   682: ldc_w 830
    //   685: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: iload 5
    //   690: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   693: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: invokevirtual 802	com/tencent/kingkong/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   699: aload_0
    //   700: aload_1
    //   701: invokevirtual 805	com/tencent/kingkong/database/SQLiteConnection:explainQueryPlan	(Ljava/lang/String;)Ljava/lang/String;
    //   704: astore 7
    //   706: aload 7
    //   708: ifnull +24 -> 732
    //   711: ldc 32
    //   713: ldc_w 807
    //   716: iconst_2
    //   717: anewarray 4	java/lang/Object
    //   720: dup
    //   721: iconst_0
    //   722: aload_1
    //   723: aastore
    //   724: dup
    //   725: iconst_1
    //   726: aload 7
    //   728: aastore
    //   729: invokestatic 657	com/tencent/kingkong/support/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   732: aload_2
    //   733: athrow
    //   734: astore_1
    //   735: aload 6
    //   737: ifnull +8 -> 745
    //   740: aload 6
    //   742: invokevirtual 833	com/tencent/mm/dbsupport/newcursor/b:releaseReference	()V
    //   745: aload_1
    //   746: athrow
    //   747: astore_2
    //   748: iconst_m1
    //   749: istore 5
    //   751: iconst_m1
    //   752: istore 8
    //   754: goto -148 -> 606
    //   757: astore_2
    //   758: iconst_m1
    //   759: istore 13
    //   761: iconst_m1
    //   762: istore 14
    //   764: iload_3
    //   765: istore 12
    //   767: goto -268 -> 499
    //   770: astore_2
    //   771: iload_3
    //   772: istore 9
    //   774: goto -386 -> 388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	777	0	this	SQLiteConnection
    //   0	777	1	paramString	String
    //   0	777	2	paramArrayOfObject	Object[]
    //   0	777	3	paramInt1	int
    //   0	777	4	paramInt2	int
    //   0	777	5	paramInt3	int
    //   0	777	6	paramb	b
    //   0	777	7	paramd	d
    //   177	576	8	i	int
    //   129	644	9	j	int
    //   126	363	10	k	int
    //   121	372	11	m	int
    //   158	608	12	n	int
    //   162	598	13	i1	int
    //   166	597	14	i2	int
    //   46	588	15	i3	int
    //   113	11	16	l	long
    //   53	360	18	localPreparedStatement	PreparedStatement
    //   39	17	19	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   84	115	378	finally
    //   179	185	498	java/lang/RuntimeException
    //   208	213	498	java/lang/RuntimeException
    //   236	241	498	java/lang/RuntimeException
    //   411	417	498	java/lang/RuntimeException
    //   440	445	498	java/lang/RuntimeException
    //   468	473	498	java/lang/RuntimeException
    //   496	498	498	java/lang/RuntimeException
    //   179	185	605	finally
    //   208	213	605	finally
    //   236	241	605	finally
    //   411	417	605	finally
    //   440	445	605	finally
    //   468	473	605	finally
    //   496	498	605	finally
    //   510	517	605	finally
    //   528	535	605	finally
    //   546	553	605	finally
    //   564	571	605	finally
    //   582	592	605	finally
    //   603	605	605	finally
    //   27	48	734	finally
    //   241	341	734	finally
    //   345	365	734	finally
    //   606	706	734	finally
    //   711	732	734	finally
    //   732	734	734	finally
    //   48	84	747	finally
    //   48	84	757	java/lang/RuntimeException
    //   136	146	770	finally
    //   149	156	770	finally
  }
  
  /* Error */
  public final int executeForCursorWindow(String paramString, Object[] paramArrayOfObject, CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 743	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 745
    //   11: invokespecial 746	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_3
    //   16: ifnonnull +14 -> 30
    //   19: new 743	java/lang/IllegalArgumentException
    //   22: dup
    //   23: ldc_w 835
    //   26: invokespecial 746	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   29: athrow
    //   30: aload_3
    //   31: invokevirtual 836	com/tencent/kingkong/CursorWindow:acquireReference	()V
    //   34: iconst_m1
    //   35: istore 12
    //   37: iconst_m1
    //   38: istore 11
    //   40: iconst_m1
    //   41: istore 16
    //   43: aload_0
    //   44: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   47: ldc_w 812
    //   50: aload_1
    //   51: aload_2
    //   52: invokevirtual 327	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/kingkong/database/SQLiteConnection$Operation;
    //   55: astore 21
    //   57: aload 21
    //   59: getfield 330	com/tencent/kingkong/database/SQLiteConnection$Operation:mCookie	I
    //   62: istore 17
    //   64: iload 16
    //   66: istore 13
    //   68: iload 11
    //   70: istore 14
    //   72: iload 12
    //   74: istore 15
    //   76: iload 16
    //   78: istore 8
    //   80: iload 11
    //   82: istore 9
    //   84: iload 12
    //   86: istore 10
    //   88: aload_0
    //   89: aload_1
    //   90: invokespecial 749	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   93: astore 20
    //   95: iload 16
    //   97: istore 13
    //   99: iload 11
    //   101: istore 14
    //   103: iload 12
    //   105: istore 15
    //   107: iload 16
    //   109: istore 8
    //   111: iload 11
    //   113: istore 9
    //   115: iload 12
    //   117: istore 10
    //   119: aload 21
    //   121: aload 20
    //   123: getfield 442	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mType	I
    //   126: invokevirtual 752	com/tencent/kingkong/database/SQLiteConnection$Operation:bindStamentType	(I)V
    //   129: aload_0
    //   130: aload 20
    //   132: invokespecial 754	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   135: aload_0
    //   136: aload 20
    //   138: aload_2
    //   139: invokespecial 756	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   142: aload_0
    //   143: aload 20
    //   145: invokespecial 758	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   148: aload_0
    //   149: aload 7
    //   151: invokespecial 760	com/tencent/kingkong/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   154: aload_0
    //   155: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   158: aload 20
    //   160: getfield 257	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   163: aload_3
    //   164: getfield 839	com/tencent/kingkong/CursorWindow:mWindowPtr	I
    //   167: iload 4
    //   169: iload 5
    //   171: iload 6
    //   173: invokestatic 841	com/tencent/kingkong/database/SQLiteConnection:nativeExecuteForCursorWindow	(IIIIIZ)J
    //   176: lstore 18
    //   178: lload 18
    //   180: bipush 32
    //   182: lshr
    //   183: l2i
    //   184: istore 8
    //   186: lload 18
    //   188: l2i
    //   189: istore 9
    //   191: aload_3
    //   192: invokevirtual 689	com/tencent/kingkong/CursorWindow:getNumRows	()I
    //   195: istore 5
    //   197: aload_3
    //   198: iload 8
    //   200: invokevirtual 844	com/tencent/kingkong/CursorWindow:setStartPosition	(I)V
    //   203: iload 5
    //   205: istore 12
    //   207: iload 9
    //   209: istore 11
    //   211: iload 8
    //   213: istore 10
    //   215: aload_0
    //   216: aload 7
    //   218: invokespecial 764	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   221: aload_0
    //   222: aload 20
    //   224: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   227: aload_0
    //   228: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   231: aload_0
    //   232: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   235: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   238: aload_0
    //   239: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   242: iload 17
    //   244: invokevirtual 797	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperationDeferLog	(Ljava/lang/String;II)Z
    //   247: ifeq +103 -> 350
    //   250: aload_0
    //   251: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   254: iload 17
    //   256: new 233	java/lang/StringBuilder
    //   259: dup
    //   260: ldc_w 819
    //   263: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   266: aload_3
    //   267: invokevirtual 822	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: ldc_w 824
    //   273: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: iload 4
    //   278: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: ldc_w 826
    //   284: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: iload 8
    //   289: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: ldc_w 828
    //   295: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: iload 5
    //   300: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: ldc_w 830
    //   306: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: iload 9
    //   311: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokevirtual 802	com/tencent/kingkong/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   320: aload_0
    //   321: aload_1
    //   322: invokevirtual 805	com/tencent/kingkong/database/SQLiteConnection:explainQueryPlan	(Ljava/lang/String;)Ljava/lang/String;
    //   325: astore_2
    //   326: aload_2
    //   327: ifnull +23 -> 350
    //   330: ldc 32
    //   332: ldc_w 807
    //   335: iconst_2
    //   336: anewarray 4	java/lang/Object
    //   339: dup
    //   340: iconst_0
    //   341: aload_1
    //   342: aastore
    //   343: dup
    //   344: iconst_1
    //   345: aload_2
    //   346: aastore
    //   347: invokestatic 657	com/tencent/kingkong/support/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   350: aload_3
    //   351: invokevirtual 845	com/tencent/kingkong/CursorWindow:releaseReference	()V
    //   354: iload 9
    //   356: ireturn
    //   357: astore_2
    //   358: iconst_m1
    //   359: istore 5
    //   361: iconst_m1
    //   362: istore 9
    //   364: iconst_m1
    //   365: istore 8
    //   367: iload 5
    //   369: istore 12
    //   371: iload 9
    //   373: istore 11
    //   375: iload 8
    //   377: istore 10
    //   379: aload_0
    //   380: aload 7
    //   382: invokespecial 764	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   385: iload 5
    //   387: istore 12
    //   389: iload 9
    //   391: istore 11
    //   393: iload 8
    //   395: istore 10
    //   397: aload_2
    //   398: athrow
    //   399: astore_2
    //   400: iload 12
    //   402: istore 5
    //   404: iload 10
    //   406: istore 12
    //   408: iload 5
    //   410: istore 13
    //   412: iload 11
    //   414: istore 14
    //   416: iload 12
    //   418: istore 15
    //   420: iload 5
    //   422: istore 8
    //   424: iload 11
    //   426: istore 9
    //   428: iload 12
    //   430: istore 10
    //   432: aload_0
    //   433: aload 20
    //   435: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   438: iload 5
    //   440: istore 13
    //   442: iload 11
    //   444: istore 14
    //   446: iload 12
    //   448: istore 15
    //   450: iload 5
    //   452: istore 8
    //   454: iload 11
    //   456: istore 9
    //   458: iload 12
    //   460: istore 10
    //   462: aload_2
    //   463: athrow
    //   464: astore_2
    //   465: iload 13
    //   467: istore 8
    //   469: iload 14
    //   471: istore 9
    //   473: iload 15
    //   475: istore 10
    //   477: aload_2
    //   478: instanceof 504
    //   481: ifne +22 -> 503
    //   484: iload 13
    //   486: istore 8
    //   488: iload 14
    //   490: istore 9
    //   492: iload 15
    //   494: istore 10
    //   496: aload_2
    //   497: instanceof 768
    //   500: ifeq +41 -> 541
    //   503: iload 13
    //   505: istore 8
    //   507: iload 14
    //   509: istore 9
    //   511: iload 15
    //   513: istore 10
    //   515: aload_0
    //   516: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   519: ifnull +22 -> 541
    //   522: iload 13
    //   524: istore 8
    //   526: iload 14
    //   528: istore 9
    //   530: iload 15
    //   532: istore 10
    //   534: aload_0
    //   535: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   538: invokevirtual 773	com/tencent/kingkong/database/SQLiteConnectionPool:logConnectionPoolBusy	()V
    //   541: iload 13
    //   543: istore 8
    //   545: iload 14
    //   547: istore 9
    //   549: iload 15
    //   551: istore 10
    //   553: aload_0
    //   554: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   557: iload 17
    //   559: aload_2
    //   560: invokevirtual 777	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   563: iload 13
    //   565: istore 8
    //   567: iload 14
    //   569: istore 9
    //   571: iload 15
    //   573: istore 10
    //   575: aload_2
    //   576: athrow
    //   577: astore_2
    //   578: aload_0
    //   579: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   582: aload_0
    //   583: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   586: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   589: aload_0
    //   590: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   593: iload 17
    //   595: invokevirtual 797	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperationDeferLog	(Ljava/lang/String;II)Z
    //   598: ifeq +106 -> 704
    //   601: aload_0
    //   602: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   605: iload 17
    //   607: new 233	java/lang/StringBuilder
    //   610: dup
    //   611: ldc_w 819
    //   614: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   617: aload_3
    //   618: invokevirtual 822	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   621: ldc_w 824
    //   624: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: iload 4
    //   629: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   632: ldc_w 826
    //   635: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: iload 10
    //   640: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   643: ldc_w 828
    //   646: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: iload 8
    //   651: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   654: ldc_w 830
    //   657: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: iload 9
    //   662: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   665: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: invokevirtual 802	com/tencent/kingkong/database/SQLiteConnection$OperationLog:logOperation	(ILjava/lang/String;)V
    //   671: aload_0
    //   672: aload_1
    //   673: invokevirtual 805	com/tencent/kingkong/database/SQLiteConnection:explainQueryPlan	(Ljava/lang/String;)Ljava/lang/String;
    //   676: astore 7
    //   678: aload 7
    //   680: ifnull +24 -> 704
    //   683: ldc 32
    //   685: ldc_w 807
    //   688: iconst_2
    //   689: anewarray 4	java/lang/Object
    //   692: dup
    //   693: iconst_0
    //   694: aload_1
    //   695: aastore
    //   696: dup
    //   697: iconst_1
    //   698: aload 7
    //   700: aastore
    //   701: invokestatic 657	com/tencent/kingkong/support/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   704: aload_2
    //   705: athrow
    //   706: astore_1
    //   707: aload_3
    //   708: invokevirtual 845	com/tencent/kingkong/CursorWindow:releaseReference	()V
    //   711: aload_1
    //   712: athrow
    //   713: astore_2
    //   714: iload 8
    //   716: istore 10
    //   718: iload 5
    //   720: istore 8
    //   722: goto -144 -> 578
    //   725: astore_2
    //   726: iload 5
    //   728: istore 13
    //   730: iload 9
    //   732: istore 14
    //   734: iload 8
    //   736: istore 15
    //   738: goto -273 -> 465
    //   741: astore_2
    //   742: iload 16
    //   744: istore 5
    //   746: goto -338 -> 408
    //   749: astore_2
    //   750: iconst_m1
    //   751: istore 5
    //   753: goto -386 -> 367
    //   756: astore_2
    //   757: goto -390 -> 367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	760	0	this	SQLiteConnection
    //   0	760	1	paramString	String
    //   0	760	2	paramArrayOfObject	Object[]
    //   0	760	3	paramCursorWindow	CursorWindow
    //   0	760	4	paramInt1	int
    //   0	760	5	paramInt2	int
    //   0	760	6	paramBoolean	boolean
    //   0	760	7	paramCancellationSignal	CancellationSignal
    //   78	657	8	i	int
    //   82	649	9	j	int
    //   86	631	10	k	int
    //   38	417	11	m	int
    //   35	424	12	n	int
    //   66	663	13	i1	int
    //   70	663	14	i2	int
    //   74	663	15	i3	int
    //   41	702	16	i4	int
    //   62	544	17	i5	int
    //   176	11	18	l	long
    //   93	341	20	localPreparedStatement	PreparedStatement
    //   55	65	21	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   154	178	357	finally
    //   215	221	399	finally
    //   379	385	399	finally
    //   397	399	399	finally
    //   88	95	464	java/lang/RuntimeException
    //   119	129	464	java/lang/RuntimeException
    //   432	438	464	java/lang/RuntimeException
    //   462	464	464	java/lang/RuntimeException
    //   88	95	577	finally
    //   119	129	577	finally
    //   432	438	577	finally
    //   462	464	577	finally
    //   477	484	577	finally
    //   496	503	577	finally
    //   515	522	577	finally
    //   534	541	577	finally
    //   553	563	577	finally
    //   575	577	577	finally
    //   43	64	706	finally
    //   227	326	706	finally
    //   330	350	706	finally
    //   578	678	706	finally
    //   683	704	706	finally
    //   704	706	706	finally
    //   221	227	713	finally
    //   221	227	725	java/lang/RuntimeException
    //   129	154	741	finally
    //   191	197	749	finally
    //   197	203	756	finally
  }
  
  /* Error */
  public final long executeForLastInsertedRowId(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 743	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 745
    //   11: invokespecial 746	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 847
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 327	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/kingkong/database/SQLiteConnection$Operation;
    //   27: astore 7
    //   29: aload 7
    //   31: getfield 330	com/tencent/kingkong/database/SQLiteConnection$Operation:mCookie	I
    //   34: istore 4
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 749	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   41: astore_1
    //   42: aload 7
    //   44: aload_1
    //   45: getfield 442	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mType	I
    //   48: invokevirtual 752	com/tencent/kingkong/database/SQLiteConnection$Operation:bindStamentType	(I)V
    //   51: aload_0
    //   52: aload_1
    //   53: invokespecial 754	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   56: aload_0
    //   57: aload_1
    //   58: aload_2
    //   59: invokespecial 756	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   62: aload_0
    //   63: aload_1
    //   64: invokespecial 758	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   67: aload_0
    //   68: aload_3
    //   69: invokespecial 760	com/tencent/kingkong/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   72: aload_0
    //   73: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   76: aload_1
    //   77: getfield 257	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   80: invokestatic 849	com/tencent/kingkong/database/SQLiteConnection:nativeExecuteForLastInsertedRowId	(II)J
    //   83: lstore 5
    //   85: aload_0
    //   86: aload_3
    //   87: invokespecial 764	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   90: aload_0
    //   91: aload_1
    //   92: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   95: aload_0
    //   96: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   99: aload_0
    //   100: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   103: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   106: aload_0
    //   107: invokevirtual 344	com/tencent/kingkong/database/SQLiteConnection:getCurrentConnectionPtr	()I
    //   110: iload 4
    //   112: invokevirtual 348	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(Ljava/lang/String;II)V
    //   115: lload 5
    //   117: lreturn
    //   118: astore_2
    //   119: aload_0
    //   120: aload_3
    //   121: invokespecial 764	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   124: aload_2
    //   125: athrow
    //   126: astore_2
    //   127: aload_0
    //   128: aload_1
    //   129: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   132: aload_2
    //   133: athrow
    //   134: astore_1
    //   135: aload_1
    //   136: instanceof 504
    //   139: ifne +10 -> 149
    //   142: aload_1
    //   143: instanceof 768
    //   146: ifeq +17 -> 163
    //   149: aload_0
    //   150: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   153: ifnull +10 -> 163
    //   156: aload_0
    //   157: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   160: invokevirtual 773	com/tencent/kingkong/database/SQLiteConnectionPool:logConnectionPoolBusy	()V
    //   163: aload_0
    //   164: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   167: iload 4
    //   169: aload_1
    //   170: invokevirtual 777	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   173: aload_1
    //   174: athrow
    //   175: astore_1
    //   176: aload_0
    //   177: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   180: aload_0
    //   181: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   184: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   187: aload_0
    //   188: invokevirtual 344	com/tencent/kingkong/database/SQLiteConnection:getCurrentConnectionPtr	()I
    //   191: iload 4
    //   193: invokevirtual 348	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(Ljava/lang/String;II)V
    //   196: aload_1
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	SQLiteConnection
    //   0	198	1	paramString	String
    //   0	198	2	paramArrayOfObject	Object[]
    //   0	198	3	paramCancellationSignal	CancellationSignal
    //   34	158	4	i	int
    //   83	33	5	l	long
    //   27	16	7	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   72	85	118	finally
    //   51	72	126	finally
    //   85	90	126	finally
    //   119	126	126	finally
    //   36	51	134	java/lang/RuntimeException
    //   90	95	134	java/lang/RuntimeException
    //   127	134	134	java/lang/RuntimeException
    //   36	51	175	finally
    //   90	95	175	finally
    //   127	134	175	finally
    //   135	149	175	finally
    //   149	163	175	finally
    //   163	175	175	finally
  }
  
  /* Error */
  public final long executeForLong(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 743	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 745
    //   11: invokespecial 746	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 850
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 327	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/kingkong/database/SQLiteConnection$Operation;
    //   27: astore 7
    //   29: aload 7
    //   31: getfield 330	com/tencent/kingkong/database/SQLiteConnection$Operation:mCookie	I
    //   34: istore 4
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 749	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   41: astore_1
    //   42: aload 7
    //   44: aload_1
    //   45: getfield 442	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mType	I
    //   48: invokevirtual 752	com/tencent/kingkong/database/SQLiteConnection$Operation:bindStamentType	(I)V
    //   51: aload_0
    //   52: aload_1
    //   53: invokespecial 754	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   56: aload_0
    //   57: aload_1
    //   58: aload_2
    //   59: invokespecial 756	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   62: aload_0
    //   63: aload_1
    //   64: invokespecial 758	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   67: aload_0
    //   68: aload_3
    //   69: invokespecial 760	com/tencent/kingkong/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   72: aload_0
    //   73: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   76: aload_1
    //   77: getfield 257	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   80: invokestatic 852	com/tencent/kingkong/database/SQLiteConnection:nativeExecuteForLong	(II)J
    //   83: lstore 5
    //   85: aload_0
    //   86: aload_3
    //   87: invokespecial 764	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   90: aload_0
    //   91: aload_1
    //   92: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   95: aload_0
    //   96: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   99: aload_0
    //   100: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   103: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   106: aload_0
    //   107: invokevirtual 344	com/tencent/kingkong/database/SQLiteConnection:getCurrentConnectionPtr	()I
    //   110: iload 4
    //   112: invokevirtual 348	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(Ljava/lang/String;II)V
    //   115: lload 5
    //   117: lreturn
    //   118: astore_2
    //   119: aload_0
    //   120: aload_3
    //   121: invokespecial 764	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   124: aload_2
    //   125: athrow
    //   126: astore_2
    //   127: aload_0
    //   128: aload_1
    //   129: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   132: aload_2
    //   133: athrow
    //   134: astore_1
    //   135: aload_1
    //   136: instanceof 504
    //   139: ifne +10 -> 149
    //   142: aload_1
    //   143: instanceof 768
    //   146: ifeq +17 -> 163
    //   149: aload_0
    //   150: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   153: ifnull +10 -> 163
    //   156: aload_0
    //   157: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   160: invokevirtual 773	com/tencent/kingkong/database/SQLiteConnectionPool:logConnectionPoolBusy	()V
    //   163: aload_0
    //   164: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   167: iload 4
    //   169: aload_1
    //   170: invokevirtual 777	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   173: aload_1
    //   174: athrow
    //   175: astore_1
    //   176: aload_0
    //   177: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   180: aload_0
    //   181: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   184: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   187: aload_0
    //   188: invokevirtual 344	com/tencent/kingkong/database/SQLiteConnection:getCurrentConnectionPtr	()I
    //   191: iload 4
    //   193: invokevirtual 348	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(Ljava/lang/String;II)V
    //   196: aload_1
    //   197: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	SQLiteConnection
    //   0	198	1	paramString	String
    //   0	198	2	paramArrayOfObject	Object[]
    //   0	198	3	paramCancellationSignal	CancellationSignal
    //   34	158	4	i	int
    //   83	33	5	l	long
    //   27	16	7	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   72	85	118	finally
    //   51	72	126	finally
    //   85	90	126	finally
    //   119	126	126	finally
    //   36	51	134	java/lang/RuntimeException
    //   90	95	134	java/lang/RuntimeException
    //   127	134	134	java/lang/RuntimeException
    //   36	51	175	finally
    //   90	95	175	finally
    //   127	134	175	finally
    //   135	149	175	finally
    //   149	163	175	finally
    //   163	175	175	finally
  }
  
  /* Error */
  public final String executeForString(String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 743	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 745
    //   11: invokespecial 746	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 853
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 327	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/kingkong/database/SQLiteConnection$Operation;
    //   27: astore 5
    //   29: aload 5
    //   31: getfield 330	com/tencent/kingkong/database/SQLiteConnection$Operation:mCookie	I
    //   34: istore 4
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 749	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   41: astore_1
    //   42: aload 5
    //   44: aload_1
    //   45: getfield 442	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mType	I
    //   48: invokevirtual 752	com/tencent/kingkong/database/SQLiteConnection$Operation:bindStamentType	(I)V
    //   51: aload_0
    //   52: aload_1
    //   53: invokespecial 754	com/tencent/kingkong/database/SQLiteConnection:throwIfStatementForbidden	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   56: aload_0
    //   57: aload_1
    //   58: aload_2
    //   59: invokespecial 756	com/tencent/kingkong/database/SQLiteConnection:bindArguments	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;[Ljava/lang/Object;)V
    //   62: aload_0
    //   63: aload_1
    //   64: invokespecial 758	com/tencent/kingkong/database/SQLiteConnection:applyBlockGuardPolicy	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   67: aload_0
    //   68: aload_3
    //   69: invokespecial 760	com/tencent/kingkong/database/SQLiteConnection:attachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   72: aload_0
    //   73: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   76: aload_1
    //   77: getfield 257	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   80: invokestatic 855	com/tencent/kingkong/database/SQLiteConnection:nativeExecuteForString	(II)Ljava/lang/String;
    //   83: astore_2
    //   84: aload_0
    //   85: aload_3
    //   86: invokespecial 764	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   89: aload_0
    //   90: aload_1
    //   91: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   94: aload_0
    //   95: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   98: aload_0
    //   99: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   102: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   105: aload_0
    //   106: invokevirtual 344	com/tencent/kingkong/database/SQLiteConnection:getCurrentConnectionPtr	()I
    //   109: iload 4
    //   111: invokevirtual 348	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(Ljava/lang/String;II)V
    //   114: aload_2
    //   115: areturn
    //   116: astore_2
    //   117: aload_0
    //   118: aload_3
    //   119: invokespecial 764	com/tencent/kingkong/database/SQLiteConnection:detachCancellationSignal	(Lcom/tencent/kingkong/support/CancellationSignal;)V
    //   122: aload_2
    //   123: athrow
    //   124: astore_2
    //   125: aload_0
    //   126: aload_1
    //   127: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   130: aload_2
    //   131: athrow
    //   132: astore_1
    //   133: aload_1
    //   134: instanceof 504
    //   137: ifne +10 -> 147
    //   140: aload_1
    //   141: instanceof 768
    //   144: ifeq +17 -> 161
    //   147: aload_0
    //   148: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   151: ifnull +10 -> 161
    //   154: aload_0
    //   155: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   158: invokevirtual 773	com/tencent/kingkong/database/SQLiteConnectionPool:logConnectionPoolBusy	()V
    //   161: aload_0
    //   162: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   165: iload 4
    //   167: aload_1
    //   168: invokevirtual 777	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   171: aload_1
    //   172: athrow
    //   173: astore_1
    //   174: aload_0
    //   175: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   178: aload_0
    //   179: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   182: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   185: aload_0
    //   186: invokevirtual 344	com/tencent/kingkong/database/SQLiteConnection:getCurrentConnectionPtr	()I
    //   189: iload 4
    //   191: invokevirtual 348	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(Ljava/lang/String;II)V
    //   194: aload_1
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	SQLiteConnection
    //   0	196	1	paramString	String
    //   0	196	2	paramArrayOfObject	Object[]
    //   0	196	3	paramCancellationSignal	CancellationSignal
    //   34	156	4	i	int
    //   27	16	5	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   72	84	116	finally
    //   51	72	124	finally
    //   84	89	124	finally
    //   117	124	124	finally
    //   36	51	132	java/lang/RuntimeException
    //   89	94	132	java/lang/RuntimeException
    //   125	132	132	java/lang/RuntimeException
    //   36	51	173	finally
    //   89	94	173	finally
    //   125	132	173	finally
    //   133	147	173	finally
    //   147	161	173	finally
    //   161	173	173	finally
  }
  
  public final String explainQueryPlan(String paramString)
  {
    return nativeExplainQueryPlan(mConnectionPtr, paramString);
  }
  
  public final void fillRowBlob(int paramInt, byte[] paramArrayOfByte)
  {
    if (currentFillingWindow != null)
    {
      localb = currentFillingWindow;
      if (bkj != null) {
        bkj.e(paramInt, paramArrayOfByte);
      }
    }
    while (rb == null)
    {
      b localb;
      return;
    }
    rb.af(paramArrayOfByte);
  }
  
  public final void fillRowDouble(int paramInt, double paramDouble)
  {
    if ((currentFillingWindow == null) && (rb != null)) {
      rb.af(Double.valueOf(paramDouble));
    }
  }
  
  public final void fillRowEnd(int paramInt1, int paramInt2)
  {
    b localb;
    if (currentFillingWindow != null)
    {
      localb = currentFillingWindow;
      if (paramInt2 == 0) {
        break label52;
      }
      Log.e("MicroMsg.kkdb.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      bkf.remove(paramInt1);
    }
    label52:
    while (bkj == null) {
      return;
    }
    Object localObject = bkj.getKey();
    bkh.put(localObject, bkj);
    bkf.put(paramInt1, localObject);
  }
  
  public final void fillRowFloat(int paramInt, float paramFloat)
  {
    if ((currentFillingWindow == null) && (rb != null)) {
      rb.af(Float.valueOf(paramFloat));
    }
  }
  
  public final void fillRowInt(int paramInt, long paramLong)
  {
    if (currentFillingWindow != null)
    {
      localb = currentFillingWindow;
      if (bkj != null) {
        bkj.i(paramInt, paramLong);
      }
    }
    while (rb == null)
    {
      b localb;
      return;
    }
    rb.af(Long.valueOf(paramLong));
  }
  
  public final void fillRowLong(int paramInt, long paramLong)
  {
    if (currentFillingWindow != null)
    {
      localb = currentFillingWindow;
      if (bkj != null) {
        bkj.j(paramInt, paramLong);
      }
    }
    while (rb == null)
    {
      b localb;
      return;
    }
    rb.af(Long.valueOf(paramLong));
  }
  
  public final void fillRowNull(int paramInt)
  {
    if ((currentFillingWindow == null) && (rb != null)) {
      rb.af(null);
    }
  }
  
  public final void fillRowStart(int paramInt)
  {
    Object localObject;
    if (currentFillingWindow != null)
    {
      localObject = currentFillingWindow;
      if (!((b)localObject).cI(paramInt)) {
        bkj = ((b)localObject).ph();
      }
    }
    while (currentFillingDbCursor == null) {
      return;
    }
    d locald = currentFillingDbCursor;
    int i = paramInt / bkl;
    int j;
    if (bkk.indexOfKey(i) < 0)
    {
      localObject = new Object[bkl * columnCount];
      bkk.put(i, localObject);
      i = bkl;
      i = columnCount * (paramInt % i);
      j = columnCount;
      paramInt += 1;
      if (paramInt <= bkm) {
        break label171;
      }
    }
    for (;;)
    {
      bkm = paramInt;
      rb = new d.a(locald, i, i + j, (Object[])localObject);
      return;
      localObject = (Object[])bkk.get(i);
      break;
      label171:
      paramInt = bkm;
    }
  }
  
  public final void fillRowString(int paramInt, String paramString)
  {
    if (currentFillingWindow != null)
    {
      localb = currentFillingWindow;
      if (bkj != null) {
        bkj.m(paramInt, paramString);
      }
    }
    while (rb == null)
    {
      b localb;
      return;
    }
    rb.af(paramString);
  }
  
  protected final void finalize()
  {
    try
    {
      if ((mPool != null) && (mConnectionPtr != 0)) {
        mPool.onConnectionLeaked();
      }
      dispose(true);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final int getConnectionId()
  {
    return mConnectionId;
  }
  
  final int getCurrentConnectionPtr()
  {
    return mConnectionPtr;
  }
  
  final boolean isPreparedStatementInCache(String paramString)
  {
    return mPreparedStatementCache.get(paramString) != null;
  }
  
  public final boolean isPrimaryConnection()
  {
    return mIsPrimaryConnection;
  }
  
  public final void onCancel()
  {
    nativeCancel(mConnectionPtr);
  }
  
  /* Error */
  public final void prepare(String paramString, SQLiteStatementInfo paramSQLiteStatementInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +14 -> 15
    //   4: new 743	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 745
    //   11: invokespecial 746	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   19: ldc_w 963
    //   22: aload_1
    //   23: aconst_null
    //   24: invokevirtual 327	com/tencent/kingkong/database/SQLiteConnection$OperationLog:beginOperation	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Lcom/tencent/kingkong/database/SQLiteConnection$Operation;
    //   27: astore 6
    //   29: aload 6
    //   31: getfield 330	com/tencent/kingkong/database/SQLiteConnection$Operation:mCookie	I
    //   34: istore 4
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 749	com/tencent/kingkong/database/SQLiteConnection:acquirePreparedStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;
    //   41: astore_1
    //   42: aload 6
    //   44: aload_1
    //   45: getfield 442	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mType	I
    //   48: invokevirtual 752	com/tencent/kingkong/database/SQLiteConnection$Operation:bindStamentType	(I)V
    //   51: aload_2
    //   52: ifnull +44 -> 96
    //   55: aload_2
    //   56: aload_1
    //   57: getfield 229	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mNumParameters	I
    //   60: putfield 968	com/tencent/kingkong/database/SQLiteStatementInfo:numParameters	I
    //   63: aload_2
    //   64: aload_1
    //   65: getfield 445	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mReadOnly	Z
    //   68: putfield 971	com/tencent/kingkong/database/SQLiteStatementInfo:readOnly	Z
    //   71: aload_0
    //   72: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   75: aload_1
    //   76: getfield 257	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   79: invokestatic 973	com/tencent/kingkong/database/SQLiteConnection:nativeGetColumnCount	(II)I
    //   82: istore 5
    //   84: iload 5
    //   86: ifne +36 -> 122
    //   89: aload_2
    //   90: getstatic 77	com/tencent/kingkong/database/SQLiteConnection:EMPTY_STRING_ARRAY	[Ljava/lang/String;
    //   93: putfield 976	com/tencent/kingkong/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   96: aload_0
    //   97: aload_1
    //   98: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   101: aload_0
    //   102: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   105: aload_0
    //   106: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   109: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   112: aload_0
    //   113: invokevirtual 344	com/tencent/kingkong/database/SQLiteConnection:getCurrentConnectionPtr	()I
    //   116: iload 4
    //   118: invokevirtual 348	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(Ljava/lang/String;II)V
    //   121: return
    //   122: aload_2
    //   123: iload 5
    //   125: anewarray 75	java/lang/String
    //   128: putfield 976	com/tencent/kingkong/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   131: iconst_0
    //   132: istore_3
    //   133: iload_3
    //   134: iload 5
    //   136: if_icmpge -40 -> 96
    //   139: aload_2
    //   140: getfield 976	com/tencent/kingkong/database/SQLiteStatementInfo:columnNames	[Ljava/lang/String;
    //   143: iload_3
    //   144: aload_0
    //   145: getfield 166	com/tencent/kingkong/database/SQLiteConnection:mConnectionPtr	I
    //   148: aload_1
    //   149: getfield 257	com/tencent/kingkong/database/SQLiteConnection$PreparedStatement:mStatementPtr	I
    //   152: iload_3
    //   153: invokestatic 978	com/tencent/kingkong/database/SQLiteConnection:nativeGetColumnName	(III)Ljava/lang/String;
    //   156: aastore
    //   157: iload_3
    //   158: iconst_1
    //   159: iadd
    //   160: istore_3
    //   161: goto -28 -> 133
    //   164: astore_2
    //   165: aload_0
    //   166: aload_1
    //   167: invokespecial 766	com/tencent/kingkong/database/SQLiteConnection:releasePreparedStatement	(Lcom/tencent/kingkong/database/SQLiteConnection$PreparedStatement;)V
    //   170: aload_2
    //   171: athrow
    //   172: astore_1
    //   173: aload_1
    //   174: instanceof 504
    //   177: ifne +10 -> 187
    //   180: aload_1
    //   181: instanceof 768
    //   184: ifeq +17 -> 201
    //   187: aload_0
    //   188: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   191: ifnull +10 -> 201
    //   194: aload_0
    //   195: getfield 111	com/tencent/kingkong/database/SQLiteConnection:mPool	Lcom/tencent/kingkong/database/SQLiteConnectionPool;
    //   198: invokevirtual 773	com/tencent/kingkong/database/SQLiteConnectionPool:logConnectionPoolBusy	()V
    //   201: aload_0
    //   202: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   205: iload 4
    //   207: aload_1
    //   208: invokevirtual 777	com/tencent/kingkong/database/SQLiteConnection$OperationLog:failOperation	(ILjava/lang/Exception;)V
    //   211: aload_1
    //   212: athrow
    //   213: astore_1
    //   214: aload_0
    //   215: getfield 99	com/tencent/kingkong/database/SQLiteConnection:mRecentOperations	Lcom/tencent/kingkong/database/SQLiteConnection$OperationLog;
    //   218: aload_0
    //   219: getfield 118	com/tencent/kingkong/database/SQLiteConnection:mConfiguration	Lcom/tencent/kingkong/database/SQLiteDatabaseConfiguration;
    //   222: getfield 340	com/tencent/kingkong/database/SQLiteDatabaseConfiguration:path	Ljava/lang/String;
    //   225: aload_0
    //   226: invokevirtual 344	com/tencent/kingkong/database/SQLiteConnection:getCurrentConnectionPtr	()I
    //   229: iload 4
    //   231: invokevirtual 348	com/tencent/kingkong/database/SQLiteConnection$OperationLog:endOperation	(Ljava/lang/String;II)V
    //   234: aload_1
    //   235: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	SQLiteConnection
    //   0	236	1	paramString	String
    //   0	236	2	paramSQLiteStatementInfo	SQLiteStatementInfo
    //   132	29	3	i	int
    //   34	196	4	j	int
    //   82	55	5	k	int
    //   27	16	6	localOperation	Operation
    // Exception table:
    //   from	to	target	type
    //   55	84	164	finally
    //   89	96	164	finally
    //   122	131	164	finally
    //   139	157	164	finally
    //   36	51	172	java/lang/RuntimeException
    //   96	101	172	java/lang/RuntimeException
    //   165	172	172	java/lang/RuntimeException
    //   36	51	213	finally
    //   96	101	213	finally
    //   165	172	213	finally
    //   173	187	213	finally
    //   187	201	213	finally
    //   201	213	213	finally
  }
  
  final void reconfigure(SQLiteDatabaseConfiguration paramSQLiteDatabaseConfiguration)
  {
    int k = 1;
    mOnlyAllowReadOnlyOperations = false;
    int j = customFunctions.size();
    int i = 0;
    while (i < j)
    {
      SQLiteCustomFunction localSQLiteCustomFunction = (SQLiteCustomFunction)customFunctions.get(i);
      if (!mConfiguration.customFunctions.contains(localSQLiteCustomFunction)) {
        nativeRegisterCustomFunction(mConnectionPtr, localSQLiteCustomFunction);
      }
      i += 1;
    }
    if (foreignKeyConstraintsEnabled != mConfiguration.foreignKeyConstraintsEnabled)
    {
      i = 1;
      if (((openFlags ^ mConfiguration.openFlags) & 0x20000000) == 0) {
        break label171;
      }
      j = 1;
      label104:
      if (locale.equals(mConfiguration.locale)) {
        break label176;
      }
    }
    for (;;)
    {
      mConfiguration.updateParametersFrom(paramSQLiteDatabaseConfiguration);
      mPreparedStatementCache.resize(maxSqlCacheSize);
      if (i != 0) {
        setForeignKeyModeFromConfiguration();
      }
      if (j != 0) {
        setWalModeFromConfiguration();
      }
      if (k != 0) {
        setLocaleFromConfiguration();
      }
      return;
      i = 0;
      break;
      label171:
      j = 0;
      break label104;
      label176:
      k = 0;
    }
  }
  
  final void setOnlyAllowReadOnlyOperations(boolean paramBoolean)
  {
    mOnlyAllowReadOnlyOperations = paramBoolean;
  }
  
  final void setkey(String paramString, int paramInt1, int paramInt2)
  {
    mPassword = paramString;
    mArithmetic = paramInt2;
    mlockedDevice = paramInt1;
    nativeSetKey(mConnectionPtr, mlockedDevice, mPassword, mArithmetic);
  }
  
  public final String toString()
  {
    return "SQLiteConnection: " + mConfiguration.path + " (" + mConnectionId + ")";
  }
  
  private static final class Operation
  {
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public ArrayList<Object> mBindArgs;
    public int mCookie;
    public long mEndTime;
    public Exception mException;
    public boolean mFinished;
    public String mKind;
    public String mSql;
    public long mStartTime;
    public int type;
    
    private String getFormattedStartTime()
    {
      return sDateFormat.format(new Date(mStartTime));
    }
    
    private String getStatus()
    {
      if (!mFinished) {
        return "running";
      }
      if (mException != null) {
        return "failed";
      }
      return "succeeded";
    }
    
    public final void bindStamentType(int paramInt)
    {
      type = paramInt;
    }
    
    public final void describe(StringBuilder paramStringBuilder, boolean paramBoolean)
    {
      paramStringBuilder.append(mKind);
      int i;
      label122:
      Object localObject;
      if (mFinished)
      {
        paramStringBuilder.append(" took ").append(mEndTime - mStartTime).append("ms");
        paramStringBuilder.append(" - ").append(getStatus());
        if (mSql != null) {
          paramStringBuilder.append(", sql=\"").append(SQLiteConnection.trimSqlForDisplay(mSql)).append("\"");
        }
        if ((!paramBoolean) || (mBindArgs == null) || (mBindArgs.size() == 0)) {
          break label260;
        }
        paramStringBuilder.append(", bindArgs=[");
        int j = mBindArgs.size();
        i = 0;
        if (i >= j) {
          break label253;
        }
        localObject = mBindArgs.get(i);
        if (i != 0) {
          paramStringBuilder.append(", ");
        }
        if (localObject != null) {
          break label194;
        }
        paramStringBuilder.append("null");
      }
      for (;;)
      {
        i += 1;
        break label122;
        paramStringBuilder.append(" started ").append(System.currentTimeMillis() - mStartTime).append("ms ago");
        break;
        label194:
        if ((localObject instanceof byte[])) {
          paramStringBuilder.append("<byte[]>");
        } else if ((localObject instanceof String)) {
          paramStringBuilder.append("\"").append((String)localObject).append("\"");
        } else {
          paramStringBuilder.append(localObject);
        }
      }
      label253:
      paramStringBuilder.append("]");
      label260:
      if ((mException != null) && (mException.getMessage() != null)) {
        paramStringBuilder.append(", exception=\"").append(mException.getMessage()).append("\"");
      }
    }
  }
  
  private static final class OperationLog
  {
    private static final int COOKIE_GENERATION_SHIFT = 8;
    private static final int COOKIE_INDEX_MASK = 255;
    private static final int MAX_RECENT_OPERATIONS = 20;
    private int mGeneration;
    private int mIndex;
    private final SQLiteConnection.Operation[] mOperations = new SQLiteConnection.Operation[20];
    
    private boolean endOperationDeferLogLocked(String paramString, int paramInt1, int paramInt2)
    {
      SQLiteConnection.Operation localOperation = getOperationLocked(paramInt2);
      int[] arrayOfInt;
      long l;
      if (localOperation != null)
      {
        mEndTime = System.currentTimeMillis();
        mFinished = true;
        if ((mException != null) && (mException.getMessage() != null)) {
          return true;
        }
        arrayOfInt = new int[10];
        int[] tmp55_53 = arrayOfInt;
        tmp55_53[0] = 0;
        int[] tmp59_55 = tmp55_53;
        tmp59_55[1] = 0;
        int[] tmp63_59 = tmp59_55;
        tmp63_59[2] = 0;
        int[] tmp67_63 = tmp63_59;
        tmp67_63[3] = 0;
        int[] tmp71_67 = tmp67_63;
        tmp71_67[4] = 0;
        int[] tmp75_71 = tmp71_67;
        tmp75_71[5] = 0;
        int[] tmp79_75 = tmp75_71;
        tmp79_75[6] = 0;
        int[] tmp84_79 = tmp79_75;
        tmp84_79[7] = 0;
        int[] tmp89_84 = tmp84_79;
        tmp89_84[8] = 0;
        int[] tmp94_89 = tmp89_84;
        tmp94_89[9] = 0;
        tmp94_89;
        l = 10000L;
        switch (type)
        {
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (h.pn())
              {
                arrayOfInt = SQLiteConnection.nativeGetLastPageTrace(paramInt1);
                l = h.po();
              }
            } while ((!SQLiteDebug.shouldLogSlowQuery(mEndTime - mStartTime)) && (arrayOfInt[4] <= l));
            h.a(paramString, mSql, type, mEndTime - mStartTime, arrayOfInt);
            return true;
            if (h.pn())
            {
              arrayOfInt = SQLiteConnection.nativeGetLastPageTrace(paramInt1);
              l = h.po();
            }
          } while ((!SQLiteDebug.shouldLogSlowUpdate(mEndTime - mStartTime)) && (arrayOfInt[9] <= l));
          h.a(paramString, mSql, type, mEndTime - mStartTime, arrayOfInt);
          return true;
        } while (!SQLiteDebug.shouldLogSlowPragma(mEndTime - mStartTime));
        h.a(paramString, mSql, type, mEndTime - mStartTime, arrayOfInt);
        return true;
      } while (!SQLiteDebug.shouldLogSlowTransation(mEndTime - mStartTime));
      h.a(paramString, mSql, type, mEndTime - mStartTime, arrayOfInt);
      return true;
    }
    
    private SQLiteConnection.Operation getOperationLocked(int paramInt)
    {
      SQLiteConnection.Operation localOperation = mOperations[(paramInt & 0xFF)];
      if (mCookie == paramInt) {
        return localOperation;
      }
      return null;
    }
    
    private void logOperationLocked(int paramInt, String paramString)
    {
      SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localOperation.describe(localStringBuilder, false);
      if (paramString != null) {
        localStringBuilder.append(", ").append(paramString);
      }
      Log.i("MicroMsg.kkdb.SQLiteConnection", localStringBuilder.toString());
    }
    
    private int newOperationCookieLocked(int paramInt)
    {
      int i = mGeneration;
      mGeneration = (i + 1);
      return i << 8 | paramInt;
    }
    
    public final SQLiteConnection.Operation beginOperation(String paramString1, String paramString2, Object[] paramArrayOfObject)
    {
      int i = 0;
      for (;;)
      {
        int j;
        SQLiteConnection.Operation localOperation1;
        synchronized (mOperations)
        {
          j = (mIndex + 1) % 20;
          SQLiteConnection.Operation localOperation2 = mOperations[j];
          if (localOperation2 == null)
          {
            localOperation1 = new SQLiteConnection.Operation(null);
            mOperations[j] = localOperation1;
            mStartTime = System.currentTimeMillis();
            mKind = paramString1;
            mSql = paramString2;
            if (paramArrayOfObject == null) {
              break label207;
            }
            if (mBindArgs == null)
            {
              mBindArgs = new ArrayList();
              if (i >= paramArrayOfObject.length) {
                break label207;
              }
              paramString1 = paramArrayOfObject[i];
              if ((paramString1 == null) || (!(paramString1 instanceof byte[]))) {
                break label194;
              }
              mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
              break label230;
            }
          }
          else
          {
            mFinished = false;
            mException = null;
            localOperation1 = localOperation2;
            if (mBindArgs == null) {
              continue;
            }
            mBindArgs.clear();
            localOperation1 = localOperation2;
          }
        }
        mBindArgs.clear();
        continue;
        label194:
        mBindArgs.add(paramString1);
        break label230;
        label207:
        mCookie = newOperationCookieLocked(j);
        mIndex = j;
        return localOperation1;
        label230:
        i += 1;
      }
    }
    
    public final String describeCurrentOperation()
    {
      synchronized (mOperations)
      {
        Object localObject1 = mOperations[mIndex];
        if ((localObject1 != null) && (!mFinished))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          ((SQLiteConnection.Operation)localObject1).describe(localStringBuilder, false);
          localObject1 = localStringBuilder.toString();
          return (String)localObject1;
        }
        return null;
      }
    }
    
    public final void dump(boolean paramBoolean)
    {
      for (;;)
      {
        synchronized (mOperations)
        {
          Log.i("MicroMsg.kkdb.SQLiteConnection", "  Most recently executed operations:");
          i = mIndex;
          SQLiteConnection.Operation localOperation = mOperations[i];
          if (localOperation != null)
          {
            int j = 0;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("    ").append(j).append(": [");
            localStringBuilder.append(localOperation.getFormattedStartTime());
            localStringBuilder.append("] ");
            localOperation.describe(localStringBuilder, paramBoolean);
            Log.i("MicroMsg.kkdb.SQLiteConnection", localStringBuilder.toString());
            if (i <= 0) {
              break label155;
            }
            i -= 1;
            j += 1;
            localOperation = mOperations[i];
            if ((localOperation != null) && (j < 20)) {}
          }
          else
          {
            Log.i("MicroMsg.kkdb.SQLiteConnection", "    <none>");
          }
        }
        continue;
        label155:
        int i = 19;
      }
    }
    
    public final void endOperation(String paramString, int paramInt1, int paramInt2)
    {
      synchronized (mOperations)
      {
        if (endOperationDeferLogLocked(paramString, paramInt1, paramInt2)) {
          logOperationLocked(paramInt2, null);
        }
        return;
      }
    }
    
    public final boolean endOperationDeferLog(String paramString, int paramInt1, int paramInt2)
    {
      synchronized (mOperations)
      {
        boolean bool = endOperationDeferLogLocked(paramString, paramInt1, paramInt2);
        return bool;
      }
    }
    
    public final void failOperation(int paramInt, Exception paramException)
    {
      synchronized (mOperations)
      {
        SQLiteConnection.Operation localOperation = getOperationLocked(paramInt);
        if (localOperation != null) {
          mException = paramException;
        }
        return;
      }
    }
    
    public final void logOperation(int paramInt, String paramString)
    {
      synchronized (mOperations)
      {
        logOperationLocked(paramInt, paramString);
        return;
      }
    }
  }
  
  private static final class PreparedStatement
  {
    public boolean mInCache;
    public boolean mInUse;
    public int mNumParameters;
    public PreparedStatement mPoolNext;
    public boolean mReadOnly;
    public String mSql;
    public int mStatementPtr;
    public int mType;
  }
  
  private final class PreparedStatementCache
    extends LruCache<String, SQLiteConnection.PreparedStatement>
  {
    public PreparedStatementCache(int paramInt)
    {
      super();
    }
    
    public final void dump()
    {
      Log.i("MicroMsg.kkdb.SQLiteConnection", "  Prepared statement cache:");
      Object localObject1 = snapshot();
      if (!((Map)localObject1).isEmpty())
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        int i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          SQLiteConnection.PreparedStatement localPreparedStatement = (SQLiteConnection.PreparedStatement)((Map.Entry)localObject2).getValue();
          if (mInCache)
          {
            localObject2 = (String)((Map.Entry)localObject2).getKey();
            Log.i("MicroMsg.kkdb.SQLiteConnection", "    " + i + ": statementPtr=0x" + Integer.toHexString(mStatementPtr) + ", numParameters=" + mNumParameters + ", type=" + mType + ", readOnly=" + mReadOnly + ", sql=\"" + SQLiteConnection.trimSqlForDisplay((String)localObject2) + "\"");
          }
          i += 1;
        }
      }
      Log.i("MicroMsg.kkdb.SQLiteConnection", "    <none>");
    }
    
    protected final void entryRemoved(boolean paramBoolean, String paramString, SQLiteConnection.PreparedStatement paramPreparedStatement1, SQLiteConnection.PreparedStatement paramPreparedStatement2)
    {
      mInCache = false;
      if (!mInUse) {
        SQLiteConnection.this.finalizePreparedStatement(paramPreparedStatement1);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.kingkong.database.SQLiteConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */