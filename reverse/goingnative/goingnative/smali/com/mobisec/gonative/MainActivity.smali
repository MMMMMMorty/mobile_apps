.class public Lcom/mobisec/gonative/MainActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "MainActivity.java"


# instance fields
.field mResultWidget:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 13
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    const/4 v0, 0x0

    .line 15
    iput-object v0, p0, Lcom/mobisec/gonative/MainActivity;->mResultWidget:Landroid/widget/TextView;

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    .line 19
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    const p1, 0x7f09001c

    .line 20
    invoke-virtual {p0, p1}, Lcom/mobisec/gonative/MainActivity;->setContentView(I)V

    const p1, 0x7f07003d

    .line 22
    invoke-virtual {p0, p1}, Lcom/mobisec/gonative/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/EditText;

    const v0, 0x7f070027

    .line 23
    invoke-virtual {p0, v0}, Lcom/mobisec/gonative/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    const v1, 0x7f070060

    .line 24
    invoke-virtual {p0, v1}, Lcom/mobisec/gonative/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 25
    iput-object v1, p0, Lcom/mobisec/gonative/MainActivity;->mResultWidget:Landroid/widget/TextView;

    .line 27
    new-instance v2, Lcom/mobisec/gonative/MainActivity$1;

    invoke-direct {v2, p0}, Lcom/mobisec/gonative/MainActivity$1;-><init>(Lcom/mobisec/gonative/MainActivity;)V

    invoke-virtual {p1, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 44
    new-instance v2, Lcom/mobisec/gonative/MainActivity$2;

    invoke-direct {v2, p0, p1, v1}, Lcom/mobisec/gonative/MainActivity$2;-><init>(Lcom/mobisec/gonative/MainActivity;Landroid/widget/EditText;Landroid/widget/TextView;)V

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method
