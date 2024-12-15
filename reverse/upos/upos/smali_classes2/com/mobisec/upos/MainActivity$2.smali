.class Lcom/mobisec/upos/MainActivity$2;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/mobisec/upos/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/mobisec/upos/MainActivity;

.field final synthetic val$flagWidget:Landroid/widget/EditText;

.field final synthetic val$resultWidget:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/mobisec/upos/MainActivity;Landroid/widget/EditText;Landroid/widget/TextView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/mobisec/upos/MainActivity;

    .line 52
    iput-object p1, p0, Lcom/mobisec/upos/MainActivity$2;->this$0:Lcom/mobisec/upos/MainActivity;

    iput-object p2, p0, Lcom/mobisec/upos/MainActivity$2;->val$flagWidget:Landroid/widget/EditText;

    iput-object p3, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .line 55
    const-string v0, "MOBISEC"

    iget-object v1, p0, Lcom/mobisec/upos/MainActivity$2;->val$flagWidget:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 57
    .local v1, "flag":Ljava/lang/String;
    iget-object v2, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v3, "Checking flag...."

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 58
    iget-object v2, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const/high16 v3, -0x1000000

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 60
    const/4 v2, 0x0

    .line 62
    .local v2, "result":Z
    :try_start_0
    iget-object v3, p0, Lcom/mobisec/upos/MainActivity$2;->this$0:Lcom/mobisec/upos/MainActivity;

    invoke-static {v3, v1}, Lcom/mobisec/upos/FC;->checkFlag(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v3

    move v2, v3

    .line 63
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Flag result: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 66
    goto :goto_0

    .line 64
    :catch_0
    move-exception v3

    .line 65
    .local v3, "e":Ljava/lang/Exception;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Exception while checking flags:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v3}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 68
    .end local v3    # "e":Ljava/lang/Exception;
    :goto_0
    sget-boolean v3, Lcom/mobisec/upos/MainActivity;->g1:Z

    const/high16 v4, -0x10000

    if-eqz v3, :cond_0

    .line 69
    iget-object v3, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v5, "Debugger detected. ;-) Goodbye."

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 70
    iget-object v3, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 71
    const-string v3, "1"

    invoke-static {v0, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 72
    :cond_0
    sget-boolean v3, Lcom/mobisec/upos/MainActivity;->g2:Z

    if-eqz v3, :cond_1

    .line 73
    iget-object v3, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v5, "Frida detected. ;-) Goodbye."

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 74
    iget-object v3, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 75
    const-string v3, "2"

    invoke-static {v0, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 76
    :cond_1
    sget-boolean v3, Lcom/mobisec/upos/MainActivity;->g3:Z

    if-eqz v3, :cond_2

    .line 77
    iget-object v3, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v5, "Could not find Google Play Store app. is this a rooted device? ;-) Goodbye."

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 78
    iget-object v3, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 79
    const-string v3, "3"

    invoke-static {v0, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 80
    :cond_2
    sget-boolean v3, Lcom/mobisec/upos/MainActivity;->g4:Z

    if-eqz v3, :cond_3

    .line 81
    iget-object v3, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v5, "The app appears to be modified. I do not run stuff I didn\'t sign. Goodbye."

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 82
    iget-object v3, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 83
    const-string v3, "4"

    invoke-static {v0, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 84
    :cond_3
    if-eqz v2, :cond_4

    .line 85
    iget-object v3, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v4, "Flag is valid!"

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 86
    iget-object v3, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const v4, -0xff6500

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 87
    const-string v3, "v"

    invoke-static {v0, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 89
    :cond_4
    iget-object v3, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v5, "Flag is not valid"

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 90
    iget-object v3, p0, Lcom/mobisec/upos/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 91
    const-string v3, "nv"

    invoke-static {v0, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 94
    :goto_1
    return-void
.end method
