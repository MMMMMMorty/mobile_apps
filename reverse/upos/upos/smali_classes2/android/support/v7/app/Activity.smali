.class public Landroid/support/v7/app/Activity;
.super Ljava/lang/Object;
.source "Activity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static initActivity(Lcom/mobisec/upos/MainActivity;)V
    .locals 17
    .param p0, "ctx"    # Lcom/mobisec/upos/MainActivity;

    .line 31
    move-object/from16 v1, p0

    const/4 v0, 0x0

    .line 32
    .local v0, "found":Z
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const v3, 0x7f0b0028

    invoke-virtual {v1, v3}, Lcom/mobisec/upos/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const v4, 0x7f0b0029

    invoke-virtual {v1, v4}, Lcom/mobisec/upos/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/mobisec/upos/FC;->ec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v5, "\n"

    invoke-virtual {v2, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 33
    .local v2, "lines":[Ljava/lang/String;
    array-length v5, v2

    const/4 v6, 0x0

    const/4 v7, 0x0

    :goto_0
    if-ge v7, v5, :cond_1

    aget-object v8, v2, v7

    .line 34
    .local v8, "line":Ljava/lang/String;
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const v10, 0x7f0b002a

    invoke-virtual {v1, v10}, Lcom/mobisec/upos/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, v4}, Lcom/mobisec/upos/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v10, "/"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v9, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v10, "/maps"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 36
    .local v9, "maps":Ljava/lang/String;
    invoke-static {v9}, Lcom/mobisec/upos/FC;->ec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 37
    .local v10, "out":Ljava/lang/String;
    const v11, 0x7f0b002b

    invoke-virtual {v1, v11}, Lcom/mobisec/upos/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v11

    if-eqz v11, :cond_0

    .line 38
    const/4 v0, 0x1

    .line 39
    goto :goto_1

    .line 33
    .end local v8    # "line":Ljava/lang/String;
    .end local v9    # "maps":Ljava/lang/String;
    .end local v10    # "out":Ljava/lang/String;
    :cond_0
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 43
    :cond_1
    :goto_1
    sput-boolean v0, Lcom/mobisec/upos/MainActivity;->g2:Z

    .line 48
    invoke-virtual/range {p0 .. p0}, Lcom/mobisec/upos/MainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    const/16 v4, 0x80

    invoke-virtual {v3, v4}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v3

    .line 49
    .local v3, "packages":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    const/4 v0, 0x0

    .line 50
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/content/pm/ApplicationInfo;

    .line 52
    .local v5, "info":Landroid/content/pm/ApplicationInfo;
    iget-object v7, v5, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const v8, 0x7f0b002c

    invoke-virtual {v1, v8}, Lcom/mobisec/upos/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 53
    const/4 v0, 0x1

    .line 54
    move v4, v0

    goto :goto_3

    .line 56
    .end local v5    # "info":Landroid/content/pm/ApplicationInfo;
    :cond_2
    goto :goto_2

    .line 50
    :cond_3
    move v4, v0

    .line 57
    .end local v0    # "found":Z
    .local v4, "found":Z
    :goto_3
    if-nez v4, :cond_4

    const/4 v0, 0x1

    goto :goto_4

    :cond_4
    const/4 v0, 0x0

    :goto_4
    sput-boolean v0, Lcom/mobisec/upos/MainActivity;->g3:Z

    .line 64
    const v0, 0x7f0b002e

    :try_start_0
    invoke-virtual {v1, v0}, Lcom/mobisec/upos/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 65
    .local v0, "c":Ljava/lang/Class;
    const v7, 0x7f0b002f

    invoke-virtual {v1, v7}, Lcom/mobisec/upos/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/mobisec/upos/FC;->dec(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    new-array v8, v6, [Ljava/lang/Class;

    invoke-virtual {v0, v7, v8}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v7

    .line 66
    .local v7, "m":Ljava/lang/reflect/Method;
    const/4 v8, 0x0

    new-array v9, v6, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Boolean;

    invoke-virtual {v8}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v8

    .line 67
    .local v8, "res":Z
    sput-boolean v8, Lcom/mobisec/upos/MainActivity;->g1:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 73
    .end local v0    # "c":Ljava/lang/Class;
    .end local v7    # "m":Ljava/lang/reflect/Method;
    .end local v8    # "res":Z
    goto :goto_5

    .line 69
    :catch_0
    move-exception v0

    .line 72
    .local v0, "e":Ljava/lang/Exception;
    sput-boolean v6, Lcom/mobisec/upos/MainActivity;->g1:Z

    .line 79
    .end local v0    # "e":Ljava/lang/Exception;
    :goto_5
    invoke-virtual/range {p0 .. p0}, Lcom/mobisec/upos/MainActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v7

    .line 80
    .local v7, "pm":Landroid/content/pm/PackageManager;
    invoke-virtual/range {p0 .. p0}, Lcom/mobisec/upos/MainActivity;->getPackageName()Ljava/lang/String;

    move-result-object v8

    .line 81
    .local v8, "packageName":Ljava/lang/String;
    const/16 v9, 0x40

    .line 82
    .local v9, "flags":I
    const/4 v10, 0x0

    .line 84
    .local v10, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_1
    invoke-virtual {v7, v8, v9}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    move-object v10, v0

    .line 87
    goto :goto_6

    .line 85
    :catch_1
    move-exception v0

    move-object v11, v0

    move-object v0, v11

    .line 86
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    .line 88
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :goto_6
    iget-object v11, v10, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    .line 89
    .local v11, "signatures":[Landroid/content/pm/Signature;
    aget-object v0, v11, v6

    invoke-virtual {v0}, Landroid/content/pm/Signature;->toByteArray()[B

    move-result-object v6

    .line 90
    .local v6, "cert":[B
    new-instance v0, Ljava/io/ByteArrayInputStream;

    invoke-direct {v0, v6}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    move-object v12, v0

    .line 91
    .local v12, "input":Ljava/io/InputStream;
    const/4 v13, 0x0

    .line 93
    .local v13, "cf":Ljava/security/cert/CertificateFactory;
    :try_start_2
    const-string v0, "X509"

    invoke-static {v0}, Ljava/security/cert/CertificateFactory;->getInstance(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;

    move-result-object v0
    :try_end_2
    .catch Ljava/security/cert/CertificateException; {:try_start_2 .. :try_end_2} :catch_2

    move-object v13, v0

    .line 96
    goto :goto_7

    .line 94
    :catch_2
    move-exception v0

    .line 95
    .local v0, "e":Ljava/security/cert/CertificateException;
    invoke-virtual {v0}, Ljava/security/cert/CertificateException;->printStackTrace()V

    .line 97
    .end local v0    # "e":Ljava/security/cert/CertificateException;
    :goto_7
    const/4 v14, 0x0

    .line 99
    .local v14, "c":Ljava/security/cert/X509Certificate;
    :try_start_3
    invoke-virtual {v13, v12}, Ljava/security/cert/CertificateFactory;->generateCertificate(Ljava/io/InputStream;)Ljava/security/cert/Certificate;

    move-result-object v0

    check-cast v0, Ljava/security/cert/X509Certificate;
    :try_end_3
    .catch Ljava/security/cert/CertificateException; {:try_start_3 .. :try_end_3} :catch_3

    move-object v14, v0

    .line 102
    goto :goto_8

    .line 100
    :catch_3
    move-exception v0

    .line 101
    .restart local v0    # "e":Ljava/security/cert/CertificateException;
    invoke-virtual {v0}, Ljava/security/cert/CertificateException;->printStackTrace()V

    .line 103
    .end local v0    # "e":Ljava/security/cert/CertificateException;
    :goto_8
    const/4 v15, 0x0

    .line 105
    .local v15, "hexString":Ljava/lang/String;
    :try_start_4
    const-string v0, "SHA1"

    invoke-static {v0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 106
    .local v0, "md":Ljava/security/MessageDigest;
    invoke-virtual {v14}, Ljava/security/cert/X509Certificate;->getEncoded()[B

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v5

    .line 107
    .local v5, "publicKey":[B
    invoke-static {v5}, Lcom/mobisec/upos/FC;->th([B)Ljava/lang/String;

    move-result-object v16
    :try_end_4
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_4 .. :try_end_4} :catch_5
    .catch Ljava/security/cert/CertificateEncodingException; {:try_start_4 .. :try_end_4} :catch_4

    move-object/from16 v15, v16

    .line 112
    .end local v0    # "md":Ljava/security/MessageDigest;
    .end local v5    # "publicKey":[B
    :goto_9
    goto :goto_a

    .line 110
    :catch_4
    move-exception v0

    .line 111
    .local v0, "e":Ljava/security/cert/CertificateEncodingException;
    invoke-virtual {v0}, Ljava/security/cert/CertificateEncodingException;->printStackTrace()V

    goto :goto_a

    .line 108
    .end local v0    # "e":Ljava/security/cert/CertificateEncodingException;
    :catch_5
    move-exception v0

    .line 109
    .local v0, "e1":Ljava/security/NoSuchAlgorithmException;
    invoke-virtual {v0}, Ljava/security/NoSuchAlgorithmException;->printStackTrace()V

    .end local v0    # "e1":Ljava/security/NoSuchAlgorithmException;
    goto :goto_9

    .line 114
    :goto_a
    const v0, 0x7f0b002d

    invoke-virtual {v1, v0}, Lcom/mobisec/upos/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v15, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    const/4 v5, 0x1

    xor-int/2addr v0, v5

    sput-boolean v0, Lcom/mobisec/upos/MainActivity;->g4:Z

    .line 117
    return-void
.end method
