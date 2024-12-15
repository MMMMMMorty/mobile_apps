.class Lcom/mobisec/gonative/MainActivity$1;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/text/TextWatcher;


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


# direct methods
.method constructor <init>(Lcom/mobisec/gonative/MainActivity;)V
    .locals 0

    .line 27
    iput-object p1, p0, Lcom/mobisec/gonative/MainActivity$1;->this$0:Lcom/mobisec/gonative/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .line 35
    iget-object p0, p0, Lcom/mobisec/gonative/MainActivity$1;->this$0:Lcom/mobisec/gonative/MainActivity;

    iget-object p0, p0, Lcom/mobisec/gonative/MainActivity;->mResultWidget:Landroid/widget/TextView;

    const-string p1, ""

    invoke-virtual {p0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method
