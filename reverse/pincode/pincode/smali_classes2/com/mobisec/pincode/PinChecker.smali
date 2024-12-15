.class Lcom/mobisec/pincode/PinChecker;
.super Ljava/lang/Object;
.source "PinChecker.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static checkPin(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 7
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "pin"    # Ljava/lang/String;

    .line 11
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x0

    const/4 v2, 0x6

    if-eq v0, v2, :cond_0

    .line 12
    return v1

    .line 17
    :cond_0
    :try_start_0
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    .line 18
    .local v0, "pinBytes":[B
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    const/16 v3, 0x19

    if-ge v2, v3, :cond_2

    .line 19
    const/4 v3, 0x0

    .local v3, "j":I
    :goto_1
    const/16 v4, 0x190

    if-ge v3, v4, :cond_1

    .line 20
    const-string v4, "MD5"

    invoke-static {v4}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v4

    .line 21
    .local v4, "md":Ljava/security/MessageDigest;
    invoke-virtual {v4, v0}, Ljava/security/MessageDigest;->update([B)V

    .line 22
    invoke-virtual {v4}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v5

    .line 23
    .local v5, "digest":[B
    invoke-virtual {v5}, [B->clone()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [B

    move-object v0, v6

    .line 19
    .end local v5    # "digest":[B
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 18
    .end local v3    # "j":I
    .end local v4    # "md":Ljava/security/MessageDigest;
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 26
    .end local v2    # "i":I
    :cond_2
    invoke-static {v0}, Lcom/mobisec/pincode/PinChecker;->toHexString([B)Ljava/lang/String;

    move-result-object v2

    .line 29
    .local v2, "hexPinBytes":Ljava/lang/String;
    const-string v3, "d04988522ddfed3133cc24fb6924eae9"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    if-eqz v3, :cond_3

    .line 30
    const/4 v1, 0x1

    return v1

    .line 32
    :cond_3
    return v1

    .line 34
    .end local v0    # "pinBytes":[B
    .end local v2    # "hexPinBytes":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 35
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "MOBISEC"

    const-string v3, "Exception while checking pin"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 36
    return v1
.end method

.method public static toHexString([B)Ljava/lang/String;
    .locals 5
    .param p0, "bytes"    # [B

    .line 41
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 43
    .local v0, "hexString":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p0

    if-ge v1, v2, :cond_1

    .line 44
    aget-byte v2, p0, v1

    and-int/lit16 v2, v2, 0xff

    invoke-static {v2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v2

    .line 45
    .local v2, "hex":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 46
    const/16 v3, 0x30

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 48
    :cond_0
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 43
    .end local v2    # "hex":Ljava/lang/String;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 51
    .end local v1    # "i":I
    :cond_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
