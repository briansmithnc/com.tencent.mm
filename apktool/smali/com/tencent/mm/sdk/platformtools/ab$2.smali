.class final Lcom/tencent/mm/sdk/platformtools/ab$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/tencent/mm/sdk/platformtools/ab;->a(Lcom/tencent/mm/sdk/platformtools/ab$a;)I
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic jVL:Lcom/tencent/mm/sdk/platformtools/ab;

.field final synthetic jVM:Lcom/tencent/mm/sdk/platformtools/ab$a;


# direct methods
.method constructor <init>(Lcom/tencent/mm/sdk/platformtools/ab;Lcom/tencent/mm/sdk/platformtools/ab$a;)V
    .locals 0

    .prologue
    .line 263
    iput-object p1, p0, Lcom/tencent/mm/sdk/platformtools/ab$2;->jVL:Lcom/tencent/mm/sdk/platformtools/ab;

    iput-object p2, p0, Lcom/tencent/mm/sdk/platformtools/ab$2;->jVM:Lcom/tencent/mm/sdk/platformtools/ab$a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .prologue
    .line 267
    iget-object v0, p0, Lcom/tencent/mm/sdk/platformtools/ab$2;->jVM:Lcom/tencent/mm/sdk/platformtools/ab$a;

    invoke-interface {v0}, Lcom/tencent/mm/sdk/platformtools/ab$a;->vd()Z

    .line 268
    new-instance v0, Lcom/tencent/mm/sdk/platformtools/ab$2$1;

    invoke-direct {v0, p0}, Lcom/tencent/mm/sdk/platformtools/ab$2$1;-><init>(Lcom/tencent/mm/sdk/platformtools/ab$2;)V

    invoke-static {v0}, Lcom/tencent/mm/sdk/platformtools/ab;->u(Ljava/lang/Runnable;)V

    .line 274
    return-void
.end method

.method public final toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 278
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "|"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/tencent/mm/sdk/platformtools/ab$2;->jVM:Lcom/tencent/mm/sdk/platformtools/ab$a;

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
