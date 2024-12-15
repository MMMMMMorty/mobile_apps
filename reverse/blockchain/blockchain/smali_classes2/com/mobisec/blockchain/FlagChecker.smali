.class Lcom/mobisec/blockchain/FlagChecker;
.super Ljava/lang/Object;
.source "FlagChecker.java"


# static fields
.field static final synthetic $assertionsDisabled:Z


# direct methods
.method static constructor <clinit>()V
    .locals 0

    .line 14
    return-void
.end method

.method constructor <init>()V
    .locals 0

    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static checkFlag(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 9
    .param p0, "keyStr"    # Ljava/lang/String;
    .param p1, "flagStr"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 17
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    .line 18
    .local v0, "fullKey":[B
    invoke-static {v0}, Lcom/mobisec/blockchain/FlagChecker;->hash([B)[B

    move-result-object v1

    .line 19
    .local v1, "digest":[B
    const/4 v2, 0x3

    new-array v2, v2, [B

    .line 20
    .local v2, "key":[B
    const/4 v3, 0x0

    aget-byte v4, v1, v3

    aput-byte v4, v2, v3

    .line 21
    array-length v4, v1

    const/4 v5, 0x2

    div-int/2addr v4, v5

    aget-byte v4, v1, v4

    const/4 v6, 0x1

    aput-byte v4, v2, v6

    .line 22
    array-length v4, v1

    sub-int/2addr v4, v6

    aget-byte v4, v1, v4

    aput-byte v4, v2, v5

    .line 30
    invoke-static {v2}, Lcom/mobisec/blockchain/FlagChecker;->hash([B)[B

    move-result-object v4

    .line 31
    .local v4, "currKey":[B
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v5

    .line 36
    .local v5, "currPt":[B
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    const/16 v8, 0xa

    if-ge v7, v8, :cond_0

    .line 37
    invoke-static {v5, v4}, Lcom/mobisec/blockchain/FlagChecker;->encrypt([B[B)[B

    move-result-object v8

    .line 38
    .local v8, "newPt":[B
    move-object v5, v8

    .line 39
    invoke-static {v4}, Lcom/mobisec/blockchain/FlagChecker;->hash([B)[B

    move-result-object v4

    .line 36
    .end local v8    # "newPt":[B
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 45
    .end local v7    # "i":I
    :cond_0
    invoke-static {v5}, Lcom/mobisec/blockchain/FlagChecker;->toHex([B)Ljava/lang/String;

    move-result-object v7

    const-string v8, "0eef68c5ef95b67428c178f045e6fc8389b36a67bbbd800148f7c285f938a24e696ee2925e12ecf7c11f35a345a2a142639fe87ab2dd7530b29db87ca71ffda2af558131d7da615b6966fb0360d5823b79c26608772580bf14558e6b7500183ed7dfd41dbb5686ea92111667fd1eff9cec8dc29f0cfe01e092607da9f7c2602f5463a361ce5c83922cb6c3f5b872dcc088eb85df80503c92232bf03feed304d669ddd5ed1992a26674ecf2513ab25c20f95a5db49fdf6167fda3465a74e0418b2ea99eb2673d4c7e1ff7c4921c4e2d7b"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 46
    return v6

    .line 48
    :cond_1
    return v3
.end method

.method public static encrypt([B[B)[B
    .locals 5
    .param p0, "in"    # [B
    .param p1, "key"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 55
    nop

    .line 57
    new-instance v0, Ljavax/crypto/spec/SecretKeySpec;

    const-string v1, "AES"

    invoke-direct {v0, p1, v1}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 59
    .local v0, "aesKey":Ljava/security/Key;
    const-string v1, "AES/ECB/PKCS5Padding"

    invoke-static {v1}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v1

    .line 60
    .local v1, "encryptCipher":Ljavax/crypto/Cipher;
    const/4 v2, 0x1

    invoke-virtual {v1, v2, v0}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 63
    new-instance v2, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v2}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 64
    .local v2, "outputStream":Ljava/io/ByteArrayOutputStream;
    new-instance v3, Ljavax/crypto/CipherOutputStream;

    invoke-direct {v3, v2, v1}, Ljavax/crypto/CipherOutputStream;-><init>(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V

    .line 65
    .local v3, "cipherOutputStream":Ljavax/crypto/CipherOutputStream;
    invoke-virtual {v3, p0}, Ljavax/crypto/CipherOutputStream;->write([B)V

    .line 66
    invoke-virtual {v3}, Ljavax/crypto/CipherOutputStream;->flush()V

    .line 67
    invoke-virtual {v3}, Ljavax/crypto/CipherOutputStream;->close()V

    .line 68
    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v4

    .line 70
    .local v4, "out":[B
    return-object v4
.end method

.method public static hash([B)[B
    .locals 2
    .param p0, "in"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 74
    const-string v0, "MD5"

    invoke-static {v0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 75
    .local v0, "md":Ljava/security/MessageDigest;
    invoke-virtual {v0, p0}, Ljava/security/MessageDigest;->update([B)V

    .line 76
    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v1

    return-object v1
.end method

.method public static toHex([B)Ljava/lang/String;
    .locals 5
    .param p0, "bytes"    # [B

    .line 80
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 82
    .local v0, "hexString":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p0

    if-ge v1, v2, :cond_1

    .line 83
    aget-byte v2, p0, v1

    and-int/lit16 v2, v2, 0xff

    invoke-static {v2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v2

    .line 84
    .local v2, "hex":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 85
    const/16 v3, 0x30

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 87
    :cond_0
    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 82
    .end local v2    # "hex":Ljava/lang/String;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 90
    .end local v1    # "i":I
    :cond_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
