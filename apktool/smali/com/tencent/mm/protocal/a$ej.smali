.class public final Lcom/tencent/mm/protocal/a$ej;
.super Lcom/tencent/mm/protocal/a$e;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/mm/protocal/a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ej"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 1508
    const-string/jumbo v0, "setPageOwner"

    const-string/jumbo v1, "setPageOwner"

    const/16 v2, 0x72

    const/4 v3, 0x0

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/tencent/mm/protocal/a$e;-><init>(Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 1509
    return-void
.end method
