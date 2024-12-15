.class Lcom/mobisec/gonative/MainActivity$2;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/mobisec/gonative/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/mobisec/gonative/MainActivity;

.field final synthetic val$flagWidget:Landroid/widget/EditText;

.field final synthetic val$resultWidget:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/mobisec/gonative/MainActivity;Landroid/widget/EditText;Landroid/widget/TextView;)V
    .locals 0

    .line 44
    iput-object p1, p0, Lcom/mobisec/gonative/MainActivity$2;->this$0:Lcom/mobisec/gonative/MainActivity;

    iput-object p2, p0, Lcom/mobisec/gonative/MainActivity$2;->val$flagWidget:Landroid/widget/EditText;

    iput-object p3, p0, Lcom/mobisec/gonative/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .line 47
    iget-object p1, p0, Lcom/mobisec/gonative/MainActivity$2;->val$flagWidget:Landroid/widget/EditText;

    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object p1

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    .line 49
    iget-object v0, p0, Lcom/mobisec/gonative/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v1, "Checking flag...."

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 50
    iget-object v0, p0, Lcom/mobisec/gonative/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 54
    :try_start_0
    invoke-static {p1}, Lcom/mobisec/gonative/FlagChecker;->checkFlag(Ljava/lang/String;)Z

    move-result p1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    :try_start_1
    const-string v0, "MOBISEC"

    .line 55
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Flag result: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    goto :goto_0

    :catch_1
    move-exception v0

    const/4 p1, 0x0

    :goto_0
    const-string v1, "MOBISEC"

    .line 57
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Exception while checking flags:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {v0}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :goto_1
    if-eqz p1, :cond_0

    .line 61
    iget-object p1, p0, Lcom/mobisec/gonative/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v0, "Flag is valid!"

    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 62
    iget-object p0, p0, Lcom/mobisec/gonative/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const p1, -0xff6500

    invoke-virtual {p0, p1}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_2

    .line 64
    :cond_0
    iget-object p1, p0, Lcom/mobisec/gonative/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const-string v0, "Flag is not valid"

    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 65
    iget-object p0, p0, Lcom/mobisec/gonative/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    const/high16 p1, -0x10000

    invoke-virtual {p0, p1}, Landroid/widget/TextView;->setTextColor(I)V

    :goto_2
    return-void
.end method
