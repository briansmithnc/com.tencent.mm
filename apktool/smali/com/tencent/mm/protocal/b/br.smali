.class public final Lcom/tencent/mm/protocal/b/br;
.super Lcom/tencent/mm/at/a;
.source "SourceFile"


# instance fields
.field public iYO:Ljava/lang/String;

.field public iYP:Lcom/tencent/mm/protocal/b/lo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/tencent/mm/at/a;-><init>()V

    return-void
.end method


# virtual methods
.method protected final varargs a(I[Ljava/lang/Object;)I
    .locals 10

    .prologue
    const/4 v4, -0x1

    const/4 v2, 0x2

    const/4 v5, 0x1

    const/4 v3, 0x0

    .line 16
    if-nez p1, :cond_4

    .line 17
    aget-object v0, p2, v3

    check-cast v0, La/a/a/c/a;

    .line 18
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/br;->iYO:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 19
    new-instance v0, La/a/a/b;

    const-string/jumbo v1, "Not all required fields were included: ProductID"

    invoke-direct {v0, v1}, La/a/a/b;-><init>(Ljava/lang/String;)V

    throw v0

    .line 21
    :cond_0
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/br;->iYP:Lcom/tencent/mm/protocal/b/lo;

    if-nez v1, :cond_1

    .line 22
    new-instance v0, La/a/a/b;

    const-string/jumbo v1, "Not all required fields were included: Price"

    invoke-direct {v0, v1}, La/a/a/b;-><init>(Ljava/lang/String;)V

    throw v0

    .line 24
    :cond_1
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/br;->iYO:Ljava/lang/String;

    if-eqz v1, :cond_2

    .line 25
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/br;->iYO:Ljava/lang/String;

    invoke-virtual {v0, v5, v1}, La/a/a/c/a;->d(ILjava/lang/String;)V

    .line 27
    :cond_2
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/br;->iYP:Lcom/tencent/mm/protocal/b/lo;

    if-eqz v1, :cond_3

    .line 28
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/br;->iYP:Lcom/tencent/mm/protocal/b/lo;

    invoke-virtual {v1}, Lcom/tencent/mm/protocal/b/lo;->kn()I

    move-result v1

    invoke-virtual {v0, v2, v1}, La/a/a/c/a;->cj(II)V

    .line 29
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/br;->iYP:Lcom/tencent/mm/protocal/b/lo;

    invoke-virtual {v1, v0}, Lcom/tencent/mm/protocal/b/lo;->a(La/a/a/c/a;)V

    .line 94
    :cond_3
    :goto_0
    return v3

    .line 33
    :cond_4
    if-ne p1, v5, :cond_6

    .line 35
    iget-object v0, p0, Lcom/tencent/mm/protocal/b/br;->iYO:Ljava/lang/String;

    if-eqz v0, :cond_d

    .line 36
    iget-object v0, p0, Lcom/tencent/mm/protocal/b/br;->iYO:Ljava/lang/String;

    invoke-static {v5, v0}, La/a/a/b/b/a;->e(ILjava/lang/String;)I

    move-result v0

    add-int/lit8 v0, v0, 0x0

    .line 38
    :goto_1
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/br;->iYP:Lcom/tencent/mm/protocal/b/lo;

    if-eqz v1, :cond_5

    .line 39
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/br;->iYP:Lcom/tencent/mm/protocal/b/lo;

    invoke-virtual {v1}, Lcom/tencent/mm/protocal/b/lo;->kn()I

    move-result v1

    invoke-static {v2, v1}, La/a/a/a;->ch(II)I

    move-result v1

    add-int/2addr v0, v1

    :cond_5
    move v3, v0

    .line 41
    goto :goto_0

    .line 43
    :cond_6
    if-ne p1, v2, :cond_a

    .line 44
    aget-object v0, p2, v3

    check-cast v0, [B

    check-cast v0, [B

    .line 45
    new-instance v1, La/a/a/a/a;

    sget-object v2, Lcom/tencent/mm/protocal/b/br;->iTR:La/a/a/a/a/b;

    invoke-direct {v1, v0, v2}, La/a/a/a/a;-><init>([BLa/a/a/a/a/b;)V

    .line 46
    invoke-static {v1}, Lcom/tencent/mm/at/a;->a(La/a/a/a/a;)I

    move-result v0

    .line 48
    :goto_2
    if-lez v0, :cond_8

    .line 49
    invoke-super {p0, v1, p0, v0}, Lcom/tencent/mm/at/a;->a(La/a/a/a/a;Lcom/tencent/mm/at/a;I)Z

    move-result v0

    if-nez v0, :cond_7

    .line 50
    invoke-virtual {v1}, La/a/a/a/a;->bog()V

    .line 52
    :cond_7
    invoke-static {v1}, Lcom/tencent/mm/at/a;->a(La/a/a/a/a;)I

    move-result v0

    goto :goto_2

    .line 55
    :cond_8
    iget-object v0, p0, Lcom/tencent/mm/protocal/b/br;->iYO:Ljava/lang/String;

    if-nez v0, :cond_9

    .line 56
    new-instance v0, La/a/a/b;

    const-string/jumbo v1, "Not all required fields were included: ProductID"

    invoke-direct {v0, v1}, La/a/a/b;-><init>(Ljava/lang/String;)V

    throw v0

    .line 58
    :cond_9
    iget-object v0, p0, Lcom/tencent/mm/protocal/b/br;->iYP:Lcom/tencent/mm/protocal/b/lo;

    if-nez v0, :cond_3

    .line 59
    new-instance v0, La/a/a/b;

    const-string/jumbo v1, "Not all required fields were included: Price"

    invoke-direct {v0, v1}, La/a/a/b;-><init>(Ljava/lang/String;)V

    throw v0

    .line 63
    :cond_a
    const/4 v0, 0x3

    if-ne p1, v0, :cond_c

    .line 64
    aget-object v0, p2, v3

    check-cast v0, La/a/a/a/a;

    .line 65
    aget-object v1, p2, v5

    check-cast v1, Lcom/tencent/mm/protocal/b/br;

    .line 66
    aget-object v2, p2, v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 67
    packed-switch v2, :pswitch_data_0

    move v3, v4

    .line 91
    goto :goto_0

    .line 69
    :pswitch_0
    iget-object v0, v0, La/a/a/a/a;->maU:La/a/a/b/a/a;

    invoke-virtual {v0}, La/a/a/b/a/a;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/tencent/mm/protocal/b/br;->iYO:Ljava/lang/String;

    goto :goto_0

    .line 73
    :pswitch_1
    invoke-virtual {v0, v2}, La/a/a/a/a;->sJ(I)Ljava/util/LinkedList;

    move-result-object v4

    .line 74
    invoke-virtual {v4}, Ljava/util/LinkedList;->size()I

    move-result v6

    move v2, v3

    :goto_3
    if-ge v2, v6, :cond_3

    .line 75
    invoke-virtual {v4, v2}, Ljava/util/LinkedList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    .line 76
    new-instance v7, Lcom/tencent/mm/protocal/b/lo;

    invoke-direct {v7}, Lcom/tencent/mm/protocal/b/lo;-><init>()V

    .line 77
    new-instance v8, La/a/a/a/a;

    sget-object v9, Lcom/tencent/mm/protocal/b/br;->iTR:La/a/a/a/a/b;

    invoke-direct {v8, v0, v9}, La/a/a/a/a;-><init>([BLa/a/a/a/a/b;)V

    move v0, v5

    .line 79
    :goto_4
    if-eqz v0, :cond_b

    .line 81
    invoke-static {v8}, Lcom/tencent/mm/at/a;->a(La/a/a/a/a;)I

    move-result v0

    .line 82
    invoke-virtual {v7, v8, v7, v0}, Lcom/tencent/mm/protocal/b/lo;->a(La/a/a/a/a;Lcom/tencent/mm/at/a;I)Z

    move-result v0

    goto :goto_4

    .line 84
    :cond_b
    iput-object v7, v1, Lcom/tencent/mm/protocal/b/br;->iYP:Lcom/tencent/mm/protocal/b/lo;

    .line 74
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_3

    :cond_c
    move v3, v4

    .line 94
    goto/16 :goto_0

    :cond_d
    move v0, v3

    goto/16 :goto_1

    .line 67
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
