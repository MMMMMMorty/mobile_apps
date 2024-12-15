.class public Lcom/mobisec/blockchain/MainActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "MainActivity.java"


# instance fields
.field mResultWidget:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 14
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 16
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/mobisec/blockchain/MainActivity;->mResultWidget:Landroid/widget/TextView;

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 20
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 21
    const v0, 0x7f09001c

    invoke-virtual {p0, v0}, Lcom/mobisec/blockchain/MainActivity;->setContentView(I)V

    .line 23
    const v0, 0x7f070044

    invoke-virtual {p0, v0}, Lcom/mobisec/blockchain/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 24
    .local v0, "keyWidget":Landroid/widget/EditText;
    const v1, 0x7f070039

    invoke-virtual {p0, v1}, Lcom/mobisec/blockchain/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    .line 25
    .local v1, "flagWidget":Landroid/widget/EditText;
    const v2, 0x7f070025

    invoke-virtual {p0, v2}, Lcom/mobisec/blockchain/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 26
    .local v2, "checkButton":Landroid/widget/Button;
    const v3, 0x7f070057

    invoke-virtual {p0, v3}, Lcom/mobisec/blockchain/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 27
    .local v3, "resultWidget":Landroid/widget/TextView;
    iput-object v3, p0, Lcom/mobisec/blockchain/MainActivity;->mResultWidget:Landroid/widget/TextView;

    .line 29
    new-instance v4, Lcom/mobisec/blockchain/MainActivity$1;

    invoke-direct {v4, p0}, Lcom/mobisec/blockchain/MainActivity$1;-><init>(Lcom/mobisec/blockchain/MainActivity;)V

    invoke-virtual {v0, v4}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 46
    new-instance v4, Lcom/mobisec/blockchain/MainActivity$2;

    invoke-direct {v4, p0}, Lcom/mobisec/blockchain/MainActivity$2;-><init>(Lcom/mobisec/blockchain/MainActivity;)V

    invoke-virtual {v1, v4}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 63
    new-instance v4, Lcom/mobisec/blockchain/MainActivity$3;

    invoke-direct {v4, p0, v0, v1, v3}, Lcom/mobisec/blockchain/MainActivity$3;-><init>(Lcom/mobisec/blockchain/MainActivity;Landroid/widget/EditText;Landroid/widget/EditText;Landroid/widget/TextView;)V

    invoke-virtual {v2, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 90
    return-void
.end method
