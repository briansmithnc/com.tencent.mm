.class public final Lcom/tencent/mm/ui/tools/i$a;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/mm/ui/tools/i;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "a"
.end annotation


# static fields
.field public static final enum lwe:I

.field public static final enum lwf:I

.field private static final synthetic lwg:[I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v0, 0x2

    const/4 v3, 0x1

    .line 22
    sput v3, Lcom/tencent/mm/ui/tools/i$a;->lwe:I

    sput v0, Lcom/tencent/mm/ui/tools/i$a;->lwf:I

    .line 21
    new-array v0, v0, [I

    const/4 v1, 0x0

    sget v2, Lcom/tencent/mm/ui/tools/i$a;->lwe:I

    aput v2, v0, v1

    sget v1, Lcom/tencent/mm/ui/tools/i$a;->lwf:I

    aput v1, v0, v3

    sput-object v0, Lcom/tencent/mm/ui/tools/i$a;->lwg:[I

    return-void
.end method
