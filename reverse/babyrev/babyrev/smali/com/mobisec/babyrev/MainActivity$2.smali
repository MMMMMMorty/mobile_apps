.class Lcom/mobisec/babyrev/MainActivity$2;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/mobisec/babyrev/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/mobisec/babyrev/MainActivity;

.field final synthetic val$flagWidget:Landroid/widget/EditText;

.field final synthetic val$resultWidget:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/mobisec/babyrev/MainActivity;Landroid/widget/EditText;Landroid/widget/TextView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/mobisec/babyrev/MainActivity;

    .line 48
    iput-object p1, p0, Lcom/mobisec/babyrev/MainActivity$2;->this$0:Lcom/mobisec/babyrev/MainActivity;

    iput-object p2, p0, Lcom/mobisec/babyrev/MainActivity$2;->val$flagWidget:Landroid/widget/EditText;

    iput-object p3, p0, Lcom/mobisec/babyrev/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .line 51
    iget-object v0, p0, Lcom/mobisec/babyrev/MainActivity$2;->val$flagWidget:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 52
    .local v0, "flag":Ljava/lang/String;
    iget-object v1, p0, Lcom/mobisec/babyrev/MainActivity$2;->this$0:Lcom/mobisec/babyrev/MainActivity;

    invoke-static {v1, v0}, Lcom/mobisec/babyrev/FlagChecker;->checkFlag(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    .line 55
    .local v1, "result":Z
    if-eqz v1, :cond_0

    .line 56
    const-string v2, "Valid flag!"

    .line 57
    .local v2, "msg":Ljava/lang/String;
    const v3, -0xff6500

    goto :goto_0

    .line 59
    .end local v2    # "msg":Ljava/lang/String;
    :cond_0
    const-string v2, "Invalid flag"

    .line 60
    .restart local v2    # "msg":Ljava/lang/String;
    const/high16 v3, -0x10000

    .line 62
    .local v3, "color":I
    :goto_0
    iget-object v4, p0, Lcom/mobisec/babyrev/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-virtual {v4, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 63
    iget-object v4, p0, Lcom/mobisec/babyrev/MainActivity$2;->val$resultWidget:Landroid/widget/TextView;

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 64
    return-void
.end method
