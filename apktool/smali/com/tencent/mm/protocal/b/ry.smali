.class public final Lcom/tencent/mm/protocal/b/ry;
.super Lcom/tencent/mm/protocal/b/alq;
.source "SourceFile"


# instance fields
.field public jqM:I

.field public jqN:Ljava/util/LinkedList;

.field public jqO:Ljava/util/LinkedList;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/tencent/mm/protocal/b/alq;-><init>()V

    .line 13
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/tencent/mm/protocal/b/ry;->jqN:Ljava/util/LinkedList;

    .line 14
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/tencent/mm/protocal/b/ry;->jqO:Ljava/util/LinkedList;

    return-void
.end method


# virtual methods
.method protected final varargs a(I[Ljava/lang/Object;)I
    .locals 10

    .prologue
    const/4 v4, -0x1

    const/4 v6, 0x3

    const/4 v2, 0x2

    const/4 v5, 0x1

    const/4 v3, 0x0

    .line 17
    if-nez p1, :cond_3

    .line 18
    aget-object v0, p2, v3

    check-cast v0, La/a/a/c/a;

    .line 19
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/ry;->jHj:Lcom/tencent/mm/protocal/b/dd;

    if-nez v1, :cond_0

    .line 20
    new-instance v0, La/a/a/b;

    const-string/jumbo v1, "Not all required fields were included: BaseResponse"

    invoke-direct {v0, v1}, La/a/a/b;-><init>(Ljava/lang/String;)V

    throw v0

    .line 22
    :cond_0
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/ry;->jHj:Lcom/tencent/mm/protocal/b/dd;

    if-eqz v1, :cond_1

    .line 23
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/ry;->jHj:Lcom/tencent/mm/protocal/b/dd;

    invoke-virtual {v1}, Lcom/tencent/mm/protocal/b/dd;->kn()I

    move-result v1

    invoke-virtual {v0, v5, v1}, La/a/a/c/a;->cj(II)V

    .line 24
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/ry;->jHj:Lcom/tencent/mm/protocal/b/dd;

    invoke-virtual {v1, v0}, Lcom/tencent/mm/protocal/b/dd;->a(La/a/a/c/a;)V

    .line 26
    :cond_1
    iget v1, p0, Lcom/tencent/mm/protocal/b/ry;->jqM:I

    invoke-virtual {v0, v2, v1}, La/a/a/c/a;->ci(II)V

    .line 27
    const/16 v1, 0x8

    iget-object v2, p0, Lcom/tencent/mm/protocal/b/ry;->jqN:Ljava/util/LinkedList;

    invoke-virtual {v0, v6, v1, v2}, La/a/a/c/a;->d(IILjava/util/LinkedList;)V

    .line 28
    const/4 v1, 0x4

    iget-object v2, p0, Lcom/tencent/mm/protocal/b/ry;->jqO:Ljava/util/LinkedList;

    invoke-virtual {v0, v1, v2}, La/a/a/c/a;->c(ILjava/util/LinkedList;)V

    .line 116
    :cond_2
    :goto_0
    return v3

    .line 31
    :cond_3
    if-ne p1, v5, :cond_4

    .line 33
    iget-object v0, p0, Lcom/tencent/mm/protocal/b/ry;->jHj:Lcom/tencent/mm/protocal/b/dd;

    if-eqz v0, :cond_b

    .line 34
    iget-object v0, p0, Lcom/tencent/mm/protocal/b/ry;->jHj:Lcom/tencent/mm/protocal/b/dd;

    invoke-virtual {v0}, Lcom/tencent/mm/protocal/b/dd;->kn()I

    move-result v0

    invoke-static {v5, v0}, La/a/a/a;->ch(II)I

    move-result v0

    add-int/lit8 v0, v0, 0x0

    .line 36
    :goto_1
    iget v1, p0, Lcom/tencent/mm/protocal/b/ry;->jqM:I

    invoke-static {v2, v1}, La/a/a/a;->cg(II)I

    move-result v1

    add-int/2addr v0, v1

    .line 37
    const/16 v1, 0x8

    iget-object v2, p0, Lcom/tencent/mm/protocal/b/ry;->jqN:Ljava/util/LinkedList;

    invoke-static {v6, v1, v2}, La/a/a/a;->c(IILjava/util/LinkedList;)I

    move-result v1

    add-int/2addr v0, v1

    .line 38
    const/4 v1, 0x4

    iget-object v2, p0, Lcom/tencent/mm/protocal/b/ry;->jqO:Ljava/util/LinkedList;

    invoke-static {v1, v2}, La/a/a/a;->b(ILjava/util/LinkedList;)I

    move-result v1

    add-int v3, v0, v1

    .line 39
    goto :goto_0

    .line 41
    :cond_4
    if-ne p1, v2, :cond_7

    .line 42
    aget-object v0, p2, v3

    check-cast v0, [B

    check-cast v0, [B

    .line 43
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/ry;->jqN:Ljava/util/LinkedList;

    invoke-virtual {v1}, Ljava/util/LinkedList;->clear()V

    .line 44
    iget-object v1, p0, Lcom/tencent/mm/protocal/b/ry;->jqO:Ljava/util/LinkedList;

    invoke-virtual {v1}, Ljava/util/LinkedList;->clear()V

    .line 45
    new-instance v1, La/a/a/a/a;

    sget-object v2, Lcom/tencent/mm/protocal/b/ry;->iTR:La/a/a/a/a/b;

    invoke-direct {v1, v0, v2}, La/a/a/a/a;-><init>([BLa/a/a/a/a/b;)V

    .line 46
    invoke-static {v1}, Lcom/tencent/mm/protocal/b/alq;->a(La/a/a/a/a;)I

    move-result v0

    .line 48
    :goto_2
    if-lez v0, :cond_6

    .line 49
    invoke-super {p0, v1, p0, v0}, Lcom/tencent/mm/protocal/b/alq;->a(La/a/a/a/a;Lcom/tencent/mm/at/a;I)Z

    move-result v0

    if-nez v0, :cond_5

    .line 50
    invoke-virtual {v1}, La/a/a/a/a;->bog()V

    .line 52
    :cond_5
    invoke-static {v1}, Lcom/tencent/mm/protocal/b/alq;->a(La/a/a/a/a;)I

    move-result v0

    goto :goto_2

    .line 55
    :cond_6
    iget-object v0, p0, Lcom/tencent/mm/protocal/b/ry;->jHj:Lcom/tencent/mm/protocal/b/dd;

    if-nez v0, :cond_2

    .line 56
    new-instance v0, La/a/a/b;

    const-string/jumbo v1, "Not all required fields were included: BaseResponse"

    invoke-direct {v0, v1}, La/a/a/b;-><init>(Ljava/lang/String;)V

    throw v0

    .line 60
    :cond_7
    if-ne p1, v6, :cond_a

    .line 61
    aget-object v0, p2, v3

    check-cast v0, La/a/a/a/a;

    .line 62
    aget-object v1, p2, v5

    check-cast v1, Lcom/tencent/mm/protocal/b/ry;

    .line 63
    aget-object v2, p2, v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 64
    packed-switch v2, :pswitch_data_0

    move v3, v4

    .line 113
    goto :goto_0

    .line 66
    :pswitch_0
    invoke-virtual {v0, v2}, La/a/a/a/a;->sJ(I)Ljava/util/LinkedList;

    move-result-object v4

    .line 67
    invoke-virtual {v4}, Ljava/util/LinkedList;->size()I

    move-result v6

    move v2, v3

    :goto_3
    if-ge v2, v6, :cond_2

    .line 68
    invoke-virtual {v4, v2}, Ljava/util/LinkedList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    .line 69
    new-instance v7, Lcom/tencent/mm/protocal/b/dd;

    invoke-direct {v7}, Lcom/tencent/mm/protocal/b/dd;-><init>()V

    .line 70
    new-instance v8, La/a/a/a/a;

    sget-object v9, Lcom/tencent/mm/protocal/b/ry;->iTR:La/a/a/a/a/b;

    invoke-direct {v8, v0, v9}, La/a/a/a/a;-><init>([BLa/a/a/a/a/b;)V

    move v0, v5

    .line 72
    :goto_4
    if-eqz v0, :cond_8

    .line 74
    invoke-static {v8}, Lcom/tencent/mm/protocal/b/alq;->a(La/a/a/a/a;)I

    move-result v0

    .line 75
    invoke-virtual {v7, v8, v7, v0}, Lcom/tencent/mm/protocal/b/dd;->a(La/a/a/a/a;Lcom/tencent/mm/at/a;I)Z

    move-result v0

    goto :goto_4

    .line 77
    :cond_8
    iput-object v7, v1, Lcom/tencent/mm/protocal/b/ry;->jHj:Lcom/tencent/mm/protocal/b/dd;

    .line 67
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_3

    .line 84
    :pswitch_1
    iget-object v0, v0, La/a/a/a/a;->maU:La/a/a/b/a/a;

    invoke-virtual {v0}, La/a/a/b/a/a;->jC()I

    move-result v0

    iput v0, v1, Lcom/tencent/mm/protocal/b/ry;->jqM:I

    goto/16 :goto_0

    .line 88
    :pswitch_2
    invoke-virtual {v0, v2}, La/a/a/a/a;->sJ(I)Ljava/util/LinkedList;

    move-result-object v4

    .line 89
    invoke-virtual {v4}, Ljava/util/LinkedList;->size()I

    move-result v6

    move v2, v3

    :goto_5
    if-ge v2, v6, :cond_2

    .line 90
    invoke-virtual {v4, v2}, Ljava/util/LinkedList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [B

    .line 91
    new-instance v7, Lcom/tencent/mm/protocal/b/adt;

    invoke-direct {v7}, Lcom/tencent/mm/protocal/b/adt;-><init>()V

    .line 92
    new-instance v8, La/a/a/a/a;

    sget-object v9, Lcom/tencent/mm/protocal/b/ry;->iTR:La/a/a/a/a/b;

    invoke-direct {v8, v0, v9}, La/a/a/a/a;-><init>([BLa/a/a/a/a/b;)V

    move v0, v5

    .line 94
    :goto_6
    if-eqz v0, :cond_9

    .line 96
    invoke-static {v8}, Lcom/tencent/mm/protocal/b/alq;->a(La/a/a/a/a;)I

    move-result v0

    .line 97
    invoke-virtual {v7, v8, v7, v0}, Lcom/tencent/mm/protocal/b/adt;->a(La/a/a/a/a;Lcom/tencent/mm/at/a;I)Z

    move-result v0

    goto :goto_6

    .line 99
    :cond_9
    iget-object v0, v1, Lcom/tencent/mm/protocal/b/ry;->jqN:Ljava/util/LinkedList;

    invoke-virtual {v0, v7}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    .line 89
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_5

    .line 106
    :pswitch_3
    invoke-virtual {v0}, La/a/a/a/a;->bof()Lcom/tencent/mm/at/b;

    move-result-object v0

    .line 107
    new-instance v2, La/a/a/a/a;

    iget-object v0, v0, Lcom/tencent/mm/at/b;->iTS:[B

    sget-object v4, Lcom/tencent/mm/protocal/b/ry;->iTR:La/a/a/a/a/b;

    invoke-direct {v2, v0, v4}, La/a/a/a/a;-><init>([BLa/a/a/a/a/b;)V

    .line 108
    invoke-virtual {v2}, La/a/a/a/a;->boc()Ljava/util/LinkedList;

    move-result-object v0

    .line 109
    iput-object v0, v1, Lcom/tencent/mm/protocal/b/ry;->jqO:Ljava/util/LinkedList;

    goto/16 :goto_0

    :cond_a
    move v3, v4

    .line 116
    goto/16 :goto_0

    :cond_b
    move v0, v3

    goto/16 :goto_1

    .line 64
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
