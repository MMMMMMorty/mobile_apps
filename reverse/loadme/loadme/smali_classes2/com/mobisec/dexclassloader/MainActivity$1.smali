.class Lcom/mobisec/dexclassloader/MainActivity$1;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/text/TextWatcher;


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


# direct methods
.method constructor <init>(Lcom/mobisec/dexclassloader/MainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/mobisec/dexclassloader/MainActivity;

    .line 27
    iput-object p1, p0, Lcom/mobisec/dexclassloader/MainActivity$1;->this$0:Lcom/mobisec/dexclassloader/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "s"    # Landroid/text/Editable;

    .line 41
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .line 31
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .line 35
    iget-object v0, p0, Lcom/mobisec/dexclassloader/MainActivity$1;->this$0:Lcom/mobisec/dexclassloader/MainActivity;

    iget-object v0, v0, Lcom/mobisec/dexclassloader/MainActivity;->mResultWidget:Landroid/widget/TextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 36
    return-void
.end method
