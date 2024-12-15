.class public Lcom/mobisec/babyrev/FlagChecker;
.super Ljava/lang/Object;
.source "FlagChecker.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static bam(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "s"    # Ljava/lang/String;

    .line 72
    const-string v0, ""

    .line 73
    .local v0, "out":Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v1, v2, :cond_4

    .line 74
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .line 75
    .local v2, "c":C
    const/16 v3, 0x61

    if-lt v2, v3, :cond_0

    const/16 v3, 0x6d

    if-gt v2, v3, :cond_0

    add-int/lit8 v3, v2, 0xd

    int-to-char v2, v3

    goto :goto_1

    .line 76
    :cond_0
    const/16 v3, 0x41

    if-lt v2, v3, :cond_1

    const/16 v3, 0x4d

    if-gt v2, v3, :cond_1

    add-int/lit8 v3, v2, 0xd

    int-to-char v2, v3

    goto :goto_1

    .line 77
    :cond_1
    const/16 v3, 0x6e

    if-lt v2, v3, :cond_2

    const/16 v3, 0x7a

    if-gt v2, v3, :cond_2

    add-int/lit8 v3, v2, -0xd

    int-to-char v2, v3

    goto :goto_1

    .line 78
    :cond_2
    const/16 v3, 0x4e

    if-lt v2, v3, :cond_3

    const/16 v3, 0x5a

    if-gt v2, v3, :cond_3

    add-int/lit8 v3, v2, -0xd

    int-to-char v2, v3

    .line 79
    :cond_3
    :goto_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 73
    .end local v2    # "c":C
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 81
    .end local v1    # "i":I
    :cond_4
    return-object v0
.end method

.method public static checkFlag(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 10
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "flag"    # Ljava/lang/String;

    .line 9
    const-string v0, "MOBISEC{"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 10
    return v1

    .line 13
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->reverse()Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v2, 0x7d

    if-eq v0, v2, :cond_1

    .line 14
    return v1

    .line 17
    :cond_1
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v2, 0x23

    if-eq v0, v2, :cond_2

    .line 18
    return v1

    .line 21
    :cond_2
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    const-string v3, "this_is_"

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 22
    return v1

    .line 25
    :cond_3
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0, p1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->reverse()Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    const v4, 0x7f0b0028

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 26
    return v1

    .line 29
    :cond_4
    const/16 v0, 0x11

    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v4, 0x5f

    if-ne v0, v4, :cond_b

    invoke-static {}, Lcom/mobisec/babyrev/FlagChecker;->getY()I

    move-result v0

    int-to-double v4, v0

    invoke-static {}, Lcom/mobisec/babyrev/FlagChecker;->getX()I

    move-result v0

    int-to-double v6, v0

    invoke-static {}, Lcom/mobisec/babyrev/FlagChecker;->getY()I

    move-result v0

    int-to-double v8, v0

    invoke-static {v6, v7, v8, v9}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v6

    mul-double v4, v4, v6

    double-to-int v0, v4

    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const-wide/high16 v4, 0x4000000000000000L    # 2.0

    invoke-static {v4, v5, v4, v5}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v6

    invoke-static {v6, v7, v4, v5}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v4

    double-to-int v4, v4

    add-int/2addr v4, v3

    invoke-virtual {p1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-eq v0, v4, :cond_5

    goto/16 :goto_0

    .line 33
    :cond_5
    invoke-virtual {p1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcom/mobisec/babyrev/FlagChecker;->getY()I

    move-result v4

    invoke-static {}, Lcom/mobisec/babyrev/FlagChecker;->getX()I

    move-result v5

    mul-int v4, v4, v5

    invoke-static {}, Lcom/mobisec/babyrev/FlagChecker;->getY()I

    move-result v5

    mul-int v4, v4, v5

    invoke-static {}, Lcom/mobisec/babyrev/FlagChecker;->getZ()I

    move-result v5

    int-to-double v5, v5

    invoke-static {}, Lcom/mobisec/babyrev/FlagChecker;->getX()I

    move-result v7

    int-to-double v7, v7

    invoke-static {v5, v6, v7, v8}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v5

    const-wide/high16 v7, 0x3ff0000000000000L    # 1.0

    sub-double/2addr v5, v7

    double-to-int v5, v5

    invoke-virtual {v0, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mobisec/babyrev/FlagChecker;->bam(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v4, "ERNYYL"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 34
    return v1

    .line 37
    :cond_6
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const/16 v4, 0x10

    invoke-virtual {v0, v4}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v5, 0x61

    if-eq v0, v5, :cond_7

    .line 38
    return v1

    .line 41
    :cond_7
    invoke-virtual {p1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v4, 0x1a

    invoke-virtual {p1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v5

    if-eq v0, v5, :cond_8

    .line 42
    return v1

    .line 45
    :cond_8
    invoke-virtual {p1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    const/16 v5, 0x19

    invoke-virtual {v0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v0

    invoke-virtual {p1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    add-int/2addr v4, v3

    if-eq v0, v4, :cond_9

    .line 46
    return v1

    .line 49
    :cond_9
    invoke-static {}, Lcom/mobisec/babyrev/FlagChecker;->getR()Ljava/lang/String;

    move-result-object v0

    .line 50
    .local v0, "r":Ljava/lang/String;
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v4

    sub-int/2addr v4, v3

    invoke-virtual {p1, v2, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_a

    .line 51
    return v1

    .line 54
    :cond_a
    return v3

    .line 30
    .end local v0    # "r":Ljava/lang/String;
    :cond_b
    :goto_0
    return v1
.end method

.method public static getR()Ljava/lang/String;
    .locals 5

    .line 85
    const-string v0, ""

    .line 86
    .local v0, "r":Ljava/lang/String;
    const/4 v1, 0x1

    .line 87
    .local v1, "upper":Z
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    const/16 v3, 0x1a

    if-ge v2, v3, :cond_2

    .line 88
    if-eqz v1, :cond_0

    .line 89
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, "[A-Z_]"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 91
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, "[a-z_]"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 93
    :goto_1
    if-nez v1, :cond_1

    const/4 v3, 0x1

    goto :goto_2

    :cond_1
    const/4 v3, 0x0

    :goto_2
    move v1, v3

    .line 87
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 95
    .end local v2    # "i":I
    :cond_2
    return-object v0
.end method

.method private static getX()I
    .locals 1

    .line 59
    const/4 v0, 0x2

    return v0
.end method

.method private static getY()I
    .locals 1

    .line 63
    const/4 v0, 0x3

    return v0
.end method

.method private static getZ()I
    .locals 1

    .line 67
    const/4 v0, 0x5

    return v0
.end method
