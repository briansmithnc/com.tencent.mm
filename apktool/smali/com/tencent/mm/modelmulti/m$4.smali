.class final Lcom/tencent/mm/modelmulti/m$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/tencent/mm/model/z$c$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tencent/mm/modelmulti/m;->d(Lcom/tencent/mm/r/c$a;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic bWl:Lcom/tencent/mm/modelmulti/m;

.field final synthetic bWp:Lcom/tencent/mm/storage/e;

.field final synthetic bzS:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/tencent/mm/modelmulti/m;Lcom/tencent/mm/storage/e;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1113
    iput-object p1, p0, Lcom/tencent/mm/modelmulti/m$4;->bWl:Lcom/tencent/mm/modelmulti/m;

    iput-object p2, p0, Lcom/tencent/mm/modelmulti/m$4;->bWp:Lcom/tencent/mm/storage/e;

    iput-object p3, p0, Lcom/tencent/mm/modelmulti/m$4;->bzS:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final f(Ljava/lang/String;Z)V
    .locals 3

    .prologue
    .line 1115
    iget-object v0, p0, Lcom/tencent/mm/modelmulti/m$4;->bWp:Lcom/tencent/mm/storage/e;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/mm/modelmulti/m$4;->bWp:Lcom/tencent/mm/storage/e;

    invoke-virtual {v0}, Lcom/tencent/mm/storage/e;->aWk()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1116
    new-instance v0, Lcom/tencent/mm/d/a/gx;

    invoke-direct {v0}, Lcom/tencent/mm/d/a/gx;-><init>()V

    .line 1117
    iget-object v1, v0, Lcom/tencent/mm/d/a/gx;->aCo:Lcom/tencent/mm/d/a/gx$a;

    iget-object v2, p0, Lcom/tencent/mm/modelmulti/m$4;->bzS:Ljava/lang/String;

    iput-object v2, v1, Lcom/tencent/mm/d/a/gx$a;->aCm:Ljava/lang/String;

    .line 1118
    iget-object v1, v0, Lcom/tencent/mm/d/a/gx;->aCo:Lcom/tencent/mm/d/a/gx$a;

    iget-object v2, p0, Lcom/tencent/mm/modelmulti/m$4;->bWp:Lcom/tencent/mm/storage/e;

    invoke-virtual {v2}, Lcom/tencent/mm/storage/e;->aWj()I

    move-result v2

    iput v2, v1, Lcom/tencent/mm/d/a/gx$a;->aCp:I

    .line 1119
    sget-object v1, Lcom/tencent/mm/sdk/c/a;->jUF:Lcom/tencent/mm/sdk/c/a;

    invoke-virtual {v1, v0}, Lcom/tencent/mm/sdk/c/a;->j(Lcom/tencent/mm/sdk/c/b;)Z

    .line 1121
    :cond_0
    return-void
.end method
