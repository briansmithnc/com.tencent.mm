package com.tencent.mm.protocal.b;

import java.util.LinkedList;

public final class aic
  extends ali
{
  public String eky;
  public int fpQ;
  public String iYO;
  public String jEG;
  public String jEH;
  public int jEI;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (jGS != null)
      {
        paramVarArgs.cj(1, jGS.kn());
        jGS.a(paramVarArgs);
      }
      if (iYO != null) {
        paramVarArgs.d(2, iYO);
      }
      if (jEG != null) {
        paramVarArgs.d(3, jEG);
      }
      if (jEH != null) {
        paramVarArgs.d(4, jEH);
      }
      paramVarArgs.ci(5, fpQ);
      if (eky != null) {
        paramVarArgs.d(7, eky);
      }
      paramVarArgs.ci(8, jEI);
      return 0;
    }
    if (paramInt == 1) {
      if (jGS == null) {
        break label575;
      }
    }
    label575:
    for (int i = a.a.a.a.ch(1, jGS.kn()) + 0;; i = 0)
    {
      paramInt = i;
      if (iYO != null) {
        paramInt = i + a.a.a.b.b.a.e(2, iYO);
      }
      i = paramInt;
      if (jEG != null) {
        i = paramInt + a.a.a.b.b.a.e(3, jEG);
      }
      paramInt = i;
      if (jEH != null) {
        paramInt = i + a.a.a.b.b.a.e(4, jEH);
      }
      i = paramInt + a.a.a.a.cg(5, fpQ);
      paramInt = i;
      if (eky != null) {
        paramInt = i + a.a.a.b.b.a.e(7, eky);
      }
      return paramInt + a.a.a.a.cg(8, jEI);
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], iTR);
        for (paramInt = ali.a(paramVarArgs); paramInt > 0; paramInt = ali.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.bog();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
        aic localaic = (aic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((a.a.a.a.a)localObject1).sJ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dc();
            localObject2 = new a.a.a.a.a((byte[])localObject2, iTR);
            for (boolean bool = true; bool; bool = ((dc)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.at.a)localObject1, ali.a((a.a.a.a.a)localObject2))) {}
            jGS = ((dc)localObject1);
            paramInt += 1;
          }
        case 2: 
          iYO = maU.readString();
          return 0;
        case 3: 
          jEG = maU.readString();
          return 0;
        case 4: 
          jEH = maU.readString();
          return 0;
        case 5: 
          fpQ = maU.jC();
          return 0;
        case 7: 
          eky = maU.readString();
          return 0;
        }
        jEI = maU.jC();
        return 0;
      }
      return -1;
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.protocal.b.aic
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */