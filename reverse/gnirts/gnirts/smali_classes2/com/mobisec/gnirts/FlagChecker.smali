.class Lcom/mobisec/gnirts/FlagChecker;
.super Ljava/lang/Object;
.source "FlagChecker.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static bam(Ljava/lang/String;)Z
    .locals 1
    .param p0, "s"    # Ljava/lang/String;

    .line 174
    const-string v0, "^[0-9]+$"

    invoke-virtual {p0, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private static bim(Ljava/lang/String;)Z
    .locals 1
    .param p0, "s"    # Ljava/lang/String;

    .line 164
    const-string v0, "^[a-z]+$"

    invoke-virtual {p0, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private static bum(Ljava/lang/String;)Z
    .locals 1
    .param p0, "s"    # Ljava/lang/String;

    .line 169
    const-string v0, "^[A-Z]+$"

    invoke-virtual {p0, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static checkFlag(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 13
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "flag"    # Ljava/lang/String;

    .line 20
    const-string v0, "MOBISEC{"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    const/4 v1, 0x0

    if-eqz v0, :cond_11

    const-string v0, "}"

    invoke-virtual {p1, v0}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    goto/16 :goto_2

    .line 26
    :cond_0
    const/16 v0, 0x8

    const/16 v2, 0x28

    invoke-virtual {p1, v0, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 30
    .local v0, "core":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    const/16 v3, 0x20

    if-eq v2, v3, :cond_1

    .line 31
    return v1

    .line 36
    :cond_1
    invoke-static {}, Lcom/mobisec/gnirts/FlagChecker;->foo()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 43
    .local v2, "ps":[Ljava/lang/String;
    array-length v3, v2

    const/4 v4, 0x5

    if-eq v3, v4, :cond_2

    .line 44
    return v1

    .line 47
    :cond_2
    aget-object v3, v2, v1

    invoke-static {v3}, Lcom/mobisec/gnirts/FlagChecker;->bim(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 48
    return v1

    .line 52
    :cond_3
    const/4 v3, 0x2

    aget-object v4, v2, v3

    invoke-static {v4}, Lcom/mobisec/gnirts/FlagChecker;->bum(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_4

    .line 53
    return v1

    .line 57
    :cond_4
    const/4 v4, 0x4

    aget-object v5, v2, v4

    invoke-static {v5}, Lcom/mobisec/gnirts/FlagChecker;->bam(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_5

    .line 58
    return v1

    .line 62
    :cond_5
    const-string v5, "[A-Z]"

    const-string v6, "X"

    invoke-virtual {v0, v5, v6}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "[a-z]"

    const-string v7, "x"

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "[0-9]"

    const-string v7, " "

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 66
    .local v5, "reduced":Ljava/lang/String;
    const-string v6, "[A-Za-z0-9]+.       .[A-Za-z0-9]+.[Xx ]+.[A-Za-z0-9 ]+"

    invoke-virtual {v5, v6}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_6

    .line 67
    return v1

    .line 72
    :cond_6
    new-array v6, v4, [C

    .line 73
    .local v6, "syms":[C
    new-array v7, v4, [I

    fill-array-data v7, :array_0

    .line 74
    .local v7, "idxs":[I
    new-instance v8, Ljava/util/HashSet;

    invoke-direct {v8}, Ljava/util/HashSet;-><init>()V

    .line 76
    .local v8, "chars":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Character;>;"
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_0
    array-length v10, v6

    if-ge v9, v10, :cond_7

    .line 77
    aget v10, v7, v9

    invoke-virtual {p1, v10}, Ljava/lang/String;->charAt(I)C

    move-result v10

    aput-char v10, v6, v9

    .line 78
    aget-char v10, v6, v9

    invoke-static {v10}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v10

    invoke-interface {v8, v10}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 76
    add-int/lit8 v9, v9, 0x1

    goto :goto_0

    .line 80
    .end local v9    # "i":I
    :cond_7
    const/4 v9, 0x0

    .line 81
    .local v9, "sum":I
    const/4 v10, 0x0

    .local v10, "i":I
    :goto_1
    array-length v11, v6

    if-ge v10, v11, :cond_8

    .line 82
    aget-char v11, v6, v10

    add-int/2addr v9, v11

    .line 81
    add-int/lit8 v10, v10, 0x1

    goto :goto_1

    .line 85
    .end local v10    # "i":I
    :cond_8
    const/16 v10, 0xb4

    if-eq v9, v10, :cond_9

    .line 86
    return v1

    .line 88
    :cond_9
    invoke-interface {v8}, Ljava/util/Set;->size()I

    move-result v10

    const/4 v11, 0x1

    if-eq v10, v11, :cond_a

    .line 89
    return v1

    .line 99
    :cond_a
    const v10, 0x7f0b0028

    invoke-virtual {p0, v10}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    const v12, 0x7f0b002e

    invoke-virtual {p0, v12}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v12

    invoke-static {v10, v12}, Lcom/mobisec/gnirts/FlagChecker;->gs(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    aget-object v12, v2, v1

    invoke-static {v10, v12}, Lcom/mobisec/gnirts/FlagChecker;->dh(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    const v12, 0x7f0b0037

    invoke-virtual {p0, v12}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v12

    invoke-static {p0, v10, v12}, Lcom/mobisec/gnirts/FlagChecker;->me(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_b

    .line 100
    return v1

    .line 110
    :cond_b
    const v10, 0x7f0b0029

    invoke-virtual {p0, v10}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    const v12, 0x7f0b002f

    invoke-virtual {p0, v12}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v12

    invoke-static {v10, v12}, Lcom/mobisec/gnirts/FlagChecker;->gs(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    aget-object v12, v2, v11

    invoke-static {v10, v12}, Lcom/mobisec/gnirts/FlagChecker;->dh(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    const v12, 0x7f0b0038

    invoke-virtual {p0, v12}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v12

    invoke-static {p0, v10, v12}, Lcom/mobisec/gnirts/FlagChecker;->me(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_c

    .line 111
    return v1

    .line 121
    :cond_c
    const v10, 0x7f0b002a

    invoke-virtual {p0, v10}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    const v12, 0x7f0b0030

    invoke-virtual {p0, v12}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v12

    invoke-static {v10, v12}, Lcom/mobisec/gnirts/FlagChecker;->gs(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    aget-object v3, v2, v3

    invoke-static {v10, v3}, Lcom/mobisec/gnirts/FlagChecker;->dh(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const v10, 0x7f0b0039

    invoke-virtual {p0, v10}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-static {p0, v3, v10}, Lcom/mobisec/gnirts/FlagChecker;->me(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_d

    .line 122
    return v1

    .line 132
    :cond_d
    const v3, 0x7f0b002b

    invoke-virtual {p0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    const v10, 0x7f0b0031

    invoke-virtual {p0, v10}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-static {v3, v10}, Lcom/mobisec/gnirts/FlagChecker;->gs(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const/4 v10, 0x3

    aget-object v10, v2, v10

    invoke-static {v3, v10}, Lcom/mobisec/gnirts/FlagChecker;->dh(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const v10, 0x7f0b003a

    invoke-virtual {p0, v10}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-static {p0, v3, v10}, Lcom/mobisec/gnirts/FlagChecker;->me(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_e

    .line 133
    return v1

    .line 143
    :cond_e
    const v3, 0x7f0b002c

    invoke-virtual {p0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    const v10, 0x7f0b0032

    invoke-virtual {p0, v10}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-static {v3, v10}, Lcom/mobisec/gnirts/FlagChecker;->gs(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aget-object v4, v2, v4

    invoke-static {v3, v4}, Lcom/mobisec/gnirts/FlagChecker;->dh(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const v4, 0x7f0b003b

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {p0, v3, v4}, Lcom/mobisec/gnirts/FlagChecker;->me(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_f

    .line 144
    return v1

    .line 153
    :cond_f
    const v3, 0x7f0b002d

    invoke-virtual {p0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    const v4, 0x7f0b0033

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/mobisec/gnirts/FlagChecker;->gs(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, p1}, Lcom/mobisec/gnirts/FlagChecker;->dh(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const v4, 0x7f0b003c

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {p0, v3, v4}, Lcom/mobisec/gnirts/FlagChecker;->me(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_10

    .line 154
    return v1

    .line 159
    :cond_10
    return v11

    .line 21
    .end local v0    # "core":Ljava/lang/String;
    .end local v2    # "ps":[Ljava/lang/String;
    .end local v5    # "reduced":Ljava/lang/String;
    .end local v6    # "syms":[C
    .end local v7    # "idxs":[I
    .end local v8    # "chars":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Character;>;"
    .end local v9    # "sum":I
    :cond_11
    :goto_2
    return v1

    :array_0
    .array-data 4
        0xd
        0x15
        0x1b
        0x20
    .end array-data
.end method

.method private static dh(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "hash"    # Ljava/lang/String;
    .param p1, "s"    # Ljava/lang/String;

    .line 181
    :try_start_0
    invoke-static {p0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 182
    .local v0, "md":Ljava/security/MessageDigest;
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/security/MessageDigest;->update([B)V

    .line 183
    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v1

    .line 184
    .local v1, "digest":[B
    invoke-static {v1}, Lcom/mobisec/gnirts/FlagChecker;->toHexString([B)Ljava/lang/String;

    move-result-object v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v2

    .line 185
    .end local v0    # "md":Ljava/security/MessageDigest;
    .end local v1    # "digest":[B
    :catch_0
    move-exception v0

    .line 186
    .local v0, "e":Ljava/lang/Exception;
    const/4 v1, 0x0

    return-object v1
.end method

.method public static foo()Ljava/lang/String;
    .locals 4

    .line 206
    const-string v0, "Vm0wd2QyVkZNVWRYV0docFVtMVNWVmx0ZEhkVlZscDBUVlpPVmsxWGVIbFdiVFZyVm0xS1IyTkliRmRXTTFKTVZsVmFWMVpWTVVWaGVqQTk="

    .line 207
    .local v0, "s":Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    const/16 v2, 0xa

    if-ge v1, v2, :cond_0

    .line 208
    new-instance v2, Ljava/lang/String;

    const/4 v3, 0x0

    invoke-static {v0, v3}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/String;-><init>([B)V

    move-object v0, v2

    .line 207
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 211
    .end local v1    # "i":I
    :cond_0
    return-object v0
.end method

.method private static gs(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "a"    # Ljava/lang/String;
    .param p1, "b"    # Ljava/lang/String;

    .line 216
    const-string v0, ""

    .line 217
    .local v0, "s":Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 218
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v3

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v4

    rem-int v4, v1, v4

    invoke-virtual {p1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    xor-int/2addr v3, v4

    int-to-char v3, v3

    invoke-static {v3}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 217
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 220
    .end local v1    # "i":I
    :cond_0
    return-object v0
.end method

.method private static me(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 6
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "s1"    # Ljava/lang/String;
    .param p2, "s2"    # Ljava/lang/String;

    .line 226
    const/4 v0, 0x0

    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    .line 227
    .local v1, "c":Ljava/lang/Class;
    const v2, 0x7f0b0034

    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/mobisec/gnirts/FlagChecker;->r(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    new-array v4, v3, [Ljava/lang/Class;

    const-class v5, Ljava/lang/Object;

    aput-object v5, v4, v0

    invoke-virtual {v1, v2, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    .line 228
    .local v2, "m":Ljava/lang/reflect/Method;
    new-array v3, v3, [Ljava/lang/Object;

    aput-object p2, v3, v0

    invoke-virtual {v2, p1, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 229
    .local v0, "res":Z
    return v0

    .line 230
    .end local v0    # "res":Z
    .end local v1    # "c":Ljava/lang/Class;
    .end local v2    # "m":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v1

    .line 231
    .local v1, "e":Ljava/lang/Exception;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Exception: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v1}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "MOBISEC"

    invoke-static {v3, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 232
    return v0
.end method

.method public static r(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "s"    # Ljava/lang/String;

    .line 237
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0, p0}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->reverse()Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static toHexString([B)Ljava/lang/String;
    .locals 5
    .param p0, "bytes"    # [B

    .line 191
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 193
    .local v0, "hexString":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p0

    if-ge v1, v2, :cond_1

    .line 194
    aget-byte v2, p0, v1

    and-int/lit16 v2, v2, 0xff

    invoke-static {v2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v2

    .line 195
    .local v2, "hex":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 196
    const/16 v3, 0x30

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 198
    :cond_0
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 193
    .end local v2    # "hex":Ljava/lang/String;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 201
    .end local v1    # "i":I
    :cond_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
