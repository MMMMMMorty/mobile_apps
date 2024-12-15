.class Lcom/mobisec/pincode/MainActivity$2;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/mobisec/pincode/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/mobisec/pincode/MainActivity;

.field final synthetic val$pinWidget:Landroid/widget/EditText;

.field final synthetic val$resultWidget:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/mobisec/pincode/MainActivity;Landroid/widget/EditText;Landroid/widget/TextView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/mobisec/pincode/MainActivity;

    .line 54
    iput-object p1, p0, Lcom/mobisec/pincode/MainActivity$2;->this$0:Lcom/mobisec/pincode/MainActivity;

    iput-object p2, p0, Lcom/mobisec/pincode/MainActivity$2;->val$pinWidget:Landroid/widget/EditText;

    iput-object p3, p0, Lcom/mobisec/pincode/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .line 57
    iget-object v0, p0, Lcom/mobisec/pincode/MainActivity$2;->val$pinWidget:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 59
    .local v0, "pin":Ljava/lang/String;
    iget-object v1, p0, Lcom/mobisec/pincode/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v2, "Checking PIN...."

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 60
    iget-object v1, p0, Lcom/mobisec/pincode/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const/high16 v2, -0x1000000

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 62
    iget-object v1, p0, Lcom/mobisec/pincode/MainActivity$2;->this$0:Lcom/mobisec/pincode/MainActivity;

    invoke-static {v1, v0}, Lcom/mobisec/pincode/PinChecker;->checkPin(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    .line 64
    .local v1, "pinValid":Z
    const/4 v2, 0x0

    .line 65
    .local v2, "flag":Ljava/lang/String;
    const/4 v3, 0x0

    .line 66
    .local v3, "exception":Ljava/lang/String;
    const/high16 v4, -0x10000

    if-nez v1, :cond_0

    .line 67
    iget-object v5, p0, Lcom/mobisec/pincode/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v6, "PIN is not valid."

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 68
    iget-object v5, p0, Lcom/mobisec/pincode/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_1

    .line 72
    :cond_0
    :try_start_0
    iget-object v5, p0, Lcom/mobisec/pincode/MainActivity$2;->this$0:Lcom/mobisec/pincode/MainActivity;

    invoke-virtual {v5, v0}, Lcom/mobisec/pincode/MainActivity;->getFlag(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object v2, v5

    .line 75
    goto :goto_0

    .line 73
    :catch_0
    move-exception v5

    .line 74
    .local v5, "e":Ljava/lang/Exception;
    invoke-virtual {v5}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    .line 77
    .end local v5    # "e":Ljava/lang/Exception;
    :goto_0
    if-eqz v3, :cond_1

    .line 78
    iget-object v5, p0, Lcom/mobisec/pincode/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v6, "PIN was valid, but there was an exception getting the flag..."

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 79
    iget-object v5, p0, Lcom/mobisec/pincode/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_1

    .line 81
    :cond_1
    if-eqz v2, :cond_3

    .line 82
    iget-object v5, p0, Lcom/mobisec/pincode/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "PIN was valid! Here is the message from the server: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 83
    const-string v5, "FLAG"

    invoke-virtual {v2, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 84
    iget-object v4, p0, Lcom/mobisec/pincode/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const v5, -0xff6500

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_1

    .line 86
    :cond_2
    iget-object v5, p0, Lcom/mobisec/pincode/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_1

    .line 89
    :cond_3
    iget-object v5, p0, Lcom/mobisec/pincode/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "PIN was valid, but something went wrong. Exception: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 90
    iget-object v5, p0, Lcom/mobisec/pincode/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 94
    :goto_1
    return-void
.end method
