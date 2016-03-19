package com.tencent.mm.d.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;

public abstract class z
  extends c
{
  private static final int aLG = "rowid".hashCode();
  public static final String[] aLn = new String[0];
  private static final int aMk;
  private static final int aUg = "productID".hashCode();
  private static final int aVE;
  private boolean aLS = true;
  private boolean aTL = true;
  private boolean aVD = true;
  public byte[] field_content;
  public String field_lan;
  public String field_productID;
  
  static
  {
    aMk = "content".hashCode();
    aVE = "lan".hashCode();
  }
  
  public final void c(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (aUg != k) {
        break label65;
      }
      field_productID = paramCursor.getString(i);
      aTL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (aMk == k) {
        field_content = paramCursor.getBlob(i);
      } else if (aVE == k) {
        field_lan = paramCursor.getString(i);
      } else if (aLG == k) {
        jYv = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues lX()
  {
    ContentValues localContentValues = new ContentValues();
    if (aTL) {
      localContentValues.put("productID", field_productID);
    }
    if (aLS) {
      localContentValues.put("content", field_content);
    }
    if (field_lan == null) {
      field_lan = "";
    }
    if (aVD) {
      localContentValues.put("lan", field_lan);
    }
    if (jYv > 0L) {
      localContentValues.put("rowid", Long.valueOf(jYv));
    }
    return localContentValues;
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.d.b.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */