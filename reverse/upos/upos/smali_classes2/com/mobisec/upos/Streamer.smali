.class public Lcom/mobisec/upos/Streamer;
.super Ljava/lang/Object;
.source "Streamer.java"


# instance fields
.field private lfsr:[Z

.field private tap:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .line 36
    const-string v0, "01101000010"

    const/16 v1, 0x8

    invoke-direct {p0, v0, v1}, Lcom/mobisec/upos/Streamer;-><init>(Ljava/lang/String;I)V

    .line 37
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 4
    .param p1, "seed"    # Ljava/lang/String;
    .param p2, "tap"    # I

    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    new-array v0, v0, [Z

    iput-object v0, p0, Lcom/mobisec/upos/Streamer;->lfsr:[Z

    .line 42
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    sub-int/2addr v0, p2

    iput v0, p0, Lcom/mobisec/upos/Streamer;->tap:I

    .line 44
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 46
    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v3, 0x30

    if-ne v2, v3, :cond_0

    .line 48
    iget-object v2, p0, Lcom/mobisec/upos/Streamer;->lfsr:[Z

    const/4 v3, 0x0

    aput-boolean v3, v2, v0

    goto :goto_1

    .line 52
    :cond_0
    iget-object v2, p0, Lcom/mobisec/upos/Streamer;->lfsr:[Z

    aput-boolean v1, v2, v0

    .line 44
    :goto_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 55
    .end local v0    # "i":I
    :cond_1
    return-void
.end method

.method public static main([Ljava/lang/String;)V
    .locals 8
    .param p0, "args"    # [Ljava/lang/String;

    .line 18
    new-instance v0, Lcom/mobisec/upos/Streamer;

    const/16 v1, 0x8

    const-string v2, "01101000010"

    invoke-direct {v0, v2, v1}, Lcom/mobisec/upos/Streamer;-><init>(Ljava/lang/String;I)V

    .line 20
    .local v0, "lfsr":Lcom/mobisec/upos/Streamer;
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v4, "Testing step()"

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 21
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    const-string v4, " "

    const/16 v5, 0xa

    if-ge v3, v5, :cond_0

    .line 23
    invoke-virtual {v0}, Lcom/mobisec/upos/Streamer;->step()I

    move-result v5

    .line 24
    .local v5, "bit":I
    sget-object v6, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v6, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 21
    .end local v5    # "bit":I
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 26
    .end local v3    # "i":I
    :cond_0
    new-instance v3, Lcom/mobisec/upos/Streamer;

    invoke-direct {v3, v2, v1}, Lcom/mobisec/upos/Streamer;-><init>(Ljava/lang/String;I)V

    move-object v0, v3

    .line 27
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v2, "\nTesting generate()"

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 28
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    if-ge v1, v5, :cond_1

    .line 30
    const/4 v2, 0x5

    invoke-virtual {v0, v2}, Lcom/mobisec/upos/Streamer;->generate(I)I

    move-result v2

    .line 31
    .local v2, "r":I
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 28
    .end local v2    # "r":I
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 33
    .end local v1    # "i":I
    :cond_1
    return-void
.end method


# virtual methods
.method public g2()I
    .locals 3

    .line 71
    const/4 v0, 0x0

    .line 72
    .local v0, "val":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    const/16 v2, 0x10

    if-ge v1, v2, :cond_0

    .line 73
    invoke-virtual {p0}, Lcom/mobisec/upos/Streamer;->step()I

    move-result v2

    shl-int/2addr v2, v1

    or-int/2addr v0, v2

    .line 72
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 75
    .end local v1    # "i":I
    :cond_0
    return v0
.end method

.method public generate(I)I
    .locals 3
    .param p1, "k"    # I

    .line 80
    const/4 v0, 0x0

    .line 82
    .local v0, "temp":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, p1, :cond_0

    .line 84
    mul-int/lit8 v0, v0, 0x2

    .line 85
    invoke-virtual {p0}, Lcom/mobisec/upos/Streamer;->step()I

    move-result v2

    add-int/2addr v0, v2

    .line 82
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 88
    .end local v1    # "i":I
    :cond_0
    return v0
.end method

.method public step()I
    .locals 6

    .line 59
    iget-object v0, p0, Lcom/mobisec/upos/Streamer;->lfsr:[Z

    const/4 v1, 0x0

    aget-boolean v2, v0, v1

    iget v3, p0, Lcom/mobisec/upos/Streamer;->tap:I

    aget-boolean v0, v0, v3

    xor-int/2addr v0, v2

    .line 61
    .local v0, "newBit":Z
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v3, p0, Lcom/mobisec/upos/Streamer;->lfsr:[Z

    array-length v4, v3

    const/4 v5, 0x1

    sub-int/2addr v4, v5

    if-ge v2, v4, :cond_0

    .line 63
    add-int/lit8 v4, v2, 0x1

    aget-boolean v4, v3, v4

    aput-boolean v4, v3, v2

    .line 61
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 65
    .end local v2    # "i":I
    :cond_0
    array-length v2, v3

    sub-int/2addr v2, v5

    aput-boolean v0, v3, v2

    .line 67
    if-nez v0, :cond_1

    goto :goto_1

    :cond_1
    const/4 v1, 0x1

    :goto_1
    return v1
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .line 93
    const-string v0, ""

    .line 94
    .local v0, "representation":Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/mobisec/upos/Streamer;->lfsr:[Z

    array-length v2, v2

    if-ge v1, v2, :cond_0

    .line 96
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/mobisec/upos/Streamer;->lfsr:[Z

    aget-boolean v3, v3, v1

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 94
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 98
    .end local v1    # "i":I
    :cond_0
    return-object v0
.end method
