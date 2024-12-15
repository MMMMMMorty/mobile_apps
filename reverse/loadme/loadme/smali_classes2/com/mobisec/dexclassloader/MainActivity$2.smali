.class Lcom/mobisec/dexclassloader/MainActivity$2;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/mobisec/dexclassloader/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/mobisec/dexclassloader/MainActivity;

.field final synthetic val$flagWidget:Landroid/widget/EditText;

.field final synthetic val$resultWidget:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/mobisec/dexclassloader/MainActivity;Landroid/widget/EditText;Landroid/widget/TextView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/mobisec/dexclassloader/MainActivity;

    .line 44
    iput-object p1, p0, Lcom/mobisec/dexclassloader/MainActivity$2;->this$0:Lcom/mobisec/dexclassloader/MainActivity;

    iput-object p2, p0, Lcom/mobisec/dexclassloader/MainActivity$2;->val$flagWidget:Landroid/widget/EditText;

    iput-object p3, p0, Lcom/mobisec/dexclassloader/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .line 47
    iget-object v0, p0, Lcom/mobisec/dexclassloader/MainActivity$2;->val$flagWidget:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 49
    .local v0, "flag":Ljava/lang/String;
    iget-object v1, p0, Lcom/mobisec/dexclassloader/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v2, "Checking flag...."

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 50
    iget-object v1, p0, Lcom/mobisec/dexclassloader/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const/high16 v2, -0x1000000

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextColor(I)V

    .line 52
    const/4 v1, 0x0

    .line 54
    .local v1, "result":Z
    :try_start_0
    new-instance v2, Lcom/mobisec/dexclassloader/DoStuff;

    invoke-direct {v2}, Lcom/mobisec/dexclassloader/DoStuff;-><init>()V

    .line 55
    .local v2, "doStuff":Lcom/mobisec/dexclassloader/DoStuff;
    iget-object v3, p0, Lcom/mobisec/dexclassloader/MainActivity$2;->this$0:Lcom/mobisec/dexclassloader/MainActivity;

    invoke-virtual {v2, v3, v0}, Lcom/mobisec/dexclassloader/DoStuff;->start(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v3

    move v1, v3

    .line 56
    const-string v3, "MOBISEC"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Flag result: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 59
    goto :goto_0

    .line 57
    .end local v2    # "doStuff":Lcom/mobisec/dexclassloader/DoStuff;
    :catch_0
    move-exception v2

    .line 58
    .local v2, "e":Ljava/lang/Exception;
    const-string v3, "MOBISEC"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Exception while checking flags:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v2}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 61
    .end local v2    # "e":Ljava/lang/Exception;
    :goto_0
    if-eqz v1, :cond_0

    .line 62
    iget-object v2, p0, Lcom/mobisec/dexclassloader/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v3, "Flag is valid!"

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 63
    iget-object v2, p0, Lcom/mobisec/dexclassloader/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const v3, -0xff6500

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_1

    .line 65
    :cond_0
    iget-object v2, p0, Lcom/mobisec/dexclassloader/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v3, "Flag is not valid"

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 66
    iget-object v2, p0, Lcom/mobisec/dexclassloader/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const/high16 v3, -0x10000

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 69
    :goto_1
    return-void
.end method
