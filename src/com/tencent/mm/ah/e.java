package com.tencent.mm.ah;

public final class e
  extends com.tencent.mm.at.a
{
  public String bXL;
  public String bXM;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (bXL != null) {
        paramVarArgs.d(1, bXL);
      }
      if (bXM != null) {
        paramVarArgs.d(2, bXM);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (bXL == null) {
        break label234;
      }
    }
    label234:
    for (paramInt = a.a.a.b.b.a.e(1, bXL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (bXM != null) {
        i = paramInt + a.a.a.b.b.a.e(2, bXM);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], iTR);
        for (paramInt = com.tencent.mm.at.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.at.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.bog();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        a.a.a.a.a locala = (a.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          bXL = maU.readString();
          return 0;
        }
        bXM = maU.readString();
        return 0;
      }
      return -1;
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ah.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */