.class Lcom/mobisec/blockchain/MainActivity$3;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/mobisec/blockchain/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/mobisec/blockchain/MainActivity;

.field final synthetic val$flagWidget:Landroid/widget/EditText;

.field final synthetic val$keyWidget:Landroid/widget/EditText;

.field final synthetic val$resultWidget:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/mobisec/blockchain/MainActivity;Landroid/widget/EditText;Landroid/widget/EditText;Landroid/widget/TextView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/mobisec/blockchain/MainActivity;

    .line 63
    iput-object p1, p0, Lcom/mobisec/blockchain/MainActivity$3;->this$0:Lcom/mobisec/blockchain/MainActivity;

    iput-object p2, p0, Lcom/mobisec/blockchain/MainActivity$3;->val$keyWidget:Landroid/widget/EditText;

    iput-object p3, p0, Lcom/mobisec/blockchain/MainActivity$3;->val$flagWidget:Landroid/widget/EditText;

    iput-object p4, p0, Lcom/mobisec/blockchain/MainActivity$3;->val$resultWidget:Landroid/widget/TextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .line 66
    iget-object v0, p0, Lcom/mobisec/blockchain/MainActivity$3;->val$keyWidget:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 67
    .local v0, "key":Ljava/lang/String;
    iget-object v1, p0, Lcom/mobisec/blockchain/MainActivity$3;->val$flagWidget:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 69
    .local v1, "flag":Ljava/lang/String;
    iget-object v2, p0, Lcom/mobisec/blockchain/MainActivity$3;->val$resultWidget:Landroid/widget/TextView;

    const-string v3, "Checking PIN...."

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 70
    iget-object v2, p0, Lcom/mobisec/blockchain/MainActivity$3;->val$resultWidget:Landroid/widget/TextView;

    const/high16 v3, -0x1000000

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 72
    const/4 v2, 0x0

    .line 74
    .local v2, "result":Z
    :try_start_0
    invoke-static {v0, v1}, Lcom/mobisec/blockchain/FlagChecker;->checkFlag(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move v2, v3

    .line 78
    goto :goto_0

    .line 76
    :catch_0
    move-exception v3

    .line 77
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

    const-string v5, "MOBISEC"

    invoke-static {v5, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 80
    .end local v3    # "e":Ljava/lang/Exception;
    :goto_0
    if-eqz v2, :cond_0

    .line 81
    iget-object v3, p0, Lcom/mobisec/blockchain/MainActivity$3;->val$resultWidget:Landroid/widget/TextView;

    const-string v4, "Flag is valid!"

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 82
    iget-object v3, p0, Lcom/mobisec/blockchain/MainActivity$3;->val$resultWidget:Landroid/widget/TextView;

    const v4, -0xff6500

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_1

    .line 84
    :cond_0
    iget-object v3, p0, Lcom/mobisec/blockchain/MainActivity$3;->val$resultWidget:Landroid/widget/TextView;

    const-string v4, "Flag is not valid"

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 85
    iget-object v3, p0, Lcom/mobisec/blockchain/MainActivity$3;->val$resultWidget:Landroid/widget/TextView;

    const/high16 v4, -0x10000

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 88
    :goto_1
    return-void
.end method
