.class public Lcom/mobisec/babyrev/MainActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "MainActivity.java"


# instance fields
.field mResultWidget:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 17
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 19
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/mobisec/babyrev/MainActivity;->mResultWidget:Landroid/widget/TextView;

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 23
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 24
    const v0, 0x7f09001c

    invoke-virtual {p0, v0}, Lcom/mobisec/babyrev/MainActivity;->setContentView(I)V

    .line 26
    const v0, 0x7f070039

    invoke-virtual {p0, v0}, Lcom/mobisec/babyrev/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 27
    .local v0, "flagWidget":Landroid/widget/EditText;
    const v1, 0x7f070026

    invoke-virtual {p0, v1}, Lcom/mobisec/babyrev/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 28
    .local v1, "checkFlag":Landroid/widget/Button;
    const v2, 0x7f070056

    invoke-virtual {p0, v2}, Lcom/mobisec/babyrev/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 29
    .local v2, "resultWidget":Landroid/widget/TextView;
    iput-object v2, p0, Lcom/mobisec/babyrev/MainActivity;->mResultWidget:Landroid/widget/TextView;

    .line 31
    new-instance v3, Lcom/mobisec/babyrev/MainActivity$1;

    invoke-direct {v3, p0}, Lcom/mobisec/babyrev/MainActivity$1;-><init>(Lcom/mobisec/babyrev/MainActivity;)V

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 48
    new-instance v3, Lcom/mobisec/babyrev/MainActivity$2;

    invoke-direct {v3, p0, v0, v2}, Lcom/mobisec/babyrev/MainActivity$2;-><init>(Lcom/mobisec/babyrev/MainActivity;Landroid/widget/EditText;Landroid/widget/TextView;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 66
    return-void
.end method
