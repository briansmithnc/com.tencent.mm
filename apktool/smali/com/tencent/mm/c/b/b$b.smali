.class public final enum Lcom/tencent/mm/c/b/b$b;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/mm/c/b/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "b"
.end annotation


# static fields
.field public static final enum apS:Lcom/tencent/mm/c/b/b$b;

.field public static final enum apT:Lcom/tencent/mm/c/b/b$b;

.field public static final enum apU:Lcom/tencent/mm/c/b/b$b;

.field public static final enum apV:Lcom/tencent/mm/c/b/b$b;

.field public static final enum apW:Lcom/tencent/mm/c/b/b$b;

.field private static final synthetic apX:[Lcom/tencent/mm/c/b/b$b;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 70
    new-instance v0, Lcom/tencent/mm/c/b/b$b;

    const-string/jumbo v1, "INITIALIZING"

    invoke-direct {v0, v1, v2}, Lcom/tencent/mm/c/b/b$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/tencent/mm/c/b/b$b;->apS:Lcom/tencent/mm/c/b/b$b;

    .line 71
    new-instance v0, Lcom/tencent/mm/c/b/b$b;

    const-string/jumbo v1, "READY"

    invoke-direct {v0, v1, v3}, Lcom/tencent/mm/c/b/b$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/tencent/mm/c/b/b$b;->apT:Lcom/tencent/mm/c/b/b$b;

    .line 72
    new-instance v0, Lcom/tencent/mm/c/b/b$b;

    const-string/jumbo v1, "RECORDING"

    invoke-direct {v0, v1, v4}, Lcom/tencent/mm/c/b/b$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/tencent/mm/c/b/b$b;->apU:Lcom/tencent/mm/c/b/b$b;

    .line 73
    new-instance v0, Lcom/tencent/mm/c/b/b$b;

    const-string/jumbo v1, "ERROR"

    invoke-direct {v0, v1, v5}, Lcom/tencent/mm/c/b/b$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/tencent/mm/c/b/b$b;->apV:Lcom/tencent/mm/c/b/b$b;

    .line 74
    new-instance v0, Lcom/tencent/mm/c/b/b$b;

    const-string/jumbo v1, "STOPPED"

    invoke-direct {v0, v1, v6}, Lcom/tencent/mm/c/b/b$b;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/tencent/mm/c/b/b$b;->apW:Lcom/tencent/mm/c/b/b$b;

    .line 69
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/tencent/mm/c/b/b$b;

    sget-object v1, Lcom/tencent/mm/c/b/b$b;->apS:Lcom/tencent/mm/c/b/b$b;

    aput-object v1, v0, v2

    sget-object v1, Lcom/tencent/mm/c/b/b$b;->apT:Lcom/tencent/mm/c/b/b$b;

    aput-object v1, v0, v3

    sget-object v1, Lcom/tencent/mm/c/b/b$b;->apU:Lcom/tencent/mm/c/b/b$b;

    aput-object v1, v0, v4

    sget-object v1, Lcom/tencent/mm/c/b/b$b;->apV:Lcom/tencent/mm/c/b/b$b;

    aput-object v1, v0, v5

    sget-object v1, Lcom/tencent/mm/c/b/b$b;->apW:Lcom/tencent/mm/c/b/b$b;

    aput-object v1, v0, v6

    sput-object v0, Lcom/tencent/mm/c/b/b$b;->apX:[Lcom/tencent/mm/c/b/b$b;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/tencent/mm/c/b/b$b;
    .locals 1

    .prologue
    .line 69
    const-class v0, Lcom/tencent/mm/c/b/b$b;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/tencent/mm/c/b/b$b;

    return-object v0
.end method

.method public static values()[Lcom/tencent/mm/c/b/b$b;
    .locals 1

    .prologue
    .line 69
    sget-object v0, Lcom/tencent/mm/c/b/b$b;->apX:[Lcom/tencent/mm/c/b/b$b;

    invoke-virtual {v0}, [Lcom/tencent/mm/c/b/b$b;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/tencent/mm/c/b/b$b;

    return-object v0
.end method
