.class public Lcom/mobisec/upos/MainActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "MainActivity.java"


# static fields
.field public static g1:Z

.field public static g2:Z

.field public static g3:Z

.field public static g4:Z


# instance fields
.field mResultWidget:Landroid/widget/TextView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 18
    const/4 v0, 0x0

    sput-boolean v0, Lcom/mobisec/upos/MainActivity;->g1:Z

    .line 19
    sput-boolean v0, Lcom/mobisec/upos/MainActivity;->g2:Z

    .line 20
    sput-boolean v0, Lcom/mobisec/upos/MainActivity;->g3:Z

    .line 21
    sput-boolean v0, Lcom/mobisec/upos/MainActivity;->g4:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 14
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 16
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/mobisec/upos/MainActivity;->mResultWidget:Landroid/widget/TextView;

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 25
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 26
    const v0, 0x7f09001c

    invoke-virtual {p0, v0}, Lcom/mobisec/upos/MainActivity;->setContentView(I)V

    .line 28
    invoke-static {p0}, Landroid/support/v7/app/Activity;->initActivity(Lcom/mobisec/upos/MainActivity;)V

    .line 30
    const v0, 0x7f070039

    invoke-virtual {p0, v0}, Lcom/mobisec/upos/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    .line 31
    .local v0, "flagWidget":Landroid/widget/EditText;
    const v1, 0x7f070025

    invoke-virtual {p0, v1}, Lcom/mobisec/upos/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 32
    .local v1, "checkButton":Landroid/widget/Button;
    const v2, 0x7f070056

    invoke-virtual {p0, v2}, Lcom/mobisec/upos/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 33
    .local v2, "resultWidget":Landroid/widget/TextView;
    iput-object v2, p0, Lcom/mobisec/upos/MainActivity;->mResultWidget:Landroid/widget/TextView;

    .line 35
    new-instance v3, Lcom/mobisec/upos/MainActivity$1;

    invoke-direct {v3, p0}, Lcom/mobisec/upos/MainActivity$1;-><init>(Lcom/mobisec/upos/MainActivity;)V

    invoke-virtual {v0, v3}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 52
    new-instance v3, Lcom/mobisec/upos/MainActivity$2;

    invoke-direct {v3, p0, v0, v2}, Lcom/mobisec/upos/MainActivity$2;-><init>(Lcom/mobisec/upos/MainActivity;Landroid/widget/EditText;Landroid/widget/TextView;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 96
    return-void
.end method
