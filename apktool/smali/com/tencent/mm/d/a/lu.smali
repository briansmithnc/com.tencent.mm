.class public final Lcom/tencent/mm/d/a/lu;
.super Lcom/tencent/mm/sdk/c/b;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/mm/d/a/lu$a;
    }
.end annotation


# static fields
.field public static arQ:Z

.field public static arR:Z


# instance fields
.field public aIe:Lcom/tencent/mm/d/a/lu$a;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 6
    sput-boolean v0, Lcom/tencent/mm/d/a/lu;->arQ:Z

    .line 7
    sput-boolean v0, Lcom/tencent/mm/d/a/lu;->arR:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 8
    invoke-direct {p0}, Lcom/tencent/mm/sdk/c/b;-><init>()V

    .line 13
    new-instance v0, Lcom/tencent/mm/d/a/lu$a;

    invoke-direct {v0}, Lcom/tencent/mm/d/a/lu$a;-><init>()V

    iput-object v0, p0, Lcom/tencent/mm/d/a/lu;->aIe:Lcom/tencent/mm/d/a/lu$a;

    .line 8
    const-string/jumbo v0, "SnsPostSuccess"

    iput-object v0, p0, Lcom/tencent/mm/d/a/lu;->id:Ljava/lang/String;

    sget-boolean v0, Lcom/tencent/mm/d/a/lu;->arR:Z

    iput-boolean v0, p0, Lcom/tencent/mm/d/a/lu;->jUI:Z

    return-void
.end method
