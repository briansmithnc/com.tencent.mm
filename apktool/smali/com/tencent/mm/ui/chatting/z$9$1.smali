.class final Lcom/tencent/mm/ui/chatting/z$9$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/tencent/mm/ui/base/n$c;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/mm/ui/chatting/z$9;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic kSR:Lcom/tencent/mm/ui/chatting/z$9;


# direct methods
.method constructor <init>(Lcom/tencent/mm/ui/chatting/z$9;)V
    .locals 0

    .prologue
    .line 601
    iput-object p1, p0, Lcom/tencent/mm/ui/chatting/z$9$1;->kSR:Lcom/tencent/mm/ui/chatting/z$9;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lcom/tencent/mm/ui/base/l;)V
    .locals 2

    .prologue
    .line 605
    const/4 v0, 0x2

    const v1, 0x7f0b0e54

    invoke-virtual {p1, v0, v1}, Lcom/tencent/mm/ui/base/l;->bL(II)Landroid/view/MenuItem;

    .line 606
    const/4 v0, 0x1

    const v1, 0x7f0b0e55

    invoke-virtual {p1, v0, v1}, Lcom/tencent/mm/ui/base/l;->bL(II)Landroid/view/MenuItem;

    .line 607
    return-void
.end method
