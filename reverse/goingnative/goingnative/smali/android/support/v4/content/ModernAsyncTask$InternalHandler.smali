.class Landroid/support/v4/content/ModernAsyncTask$InternalHandler;
.super Landroid/os/Handler;
.source "ModernAsyncTask.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/content/ModernAsyncTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "InternalHandler"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 1

    .line 497
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 1

    .line 503
    iget-object p0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast p0, Landroid/support/v4/content/ModernAsyncTask$AsyncTaskResult;

    .line 504
    iget p1, p1, Landroid/os/Message;->what:I

    packed-switch p1, :pswitch_data_0

    goto :goto_0

    .line 510
    :pswitch_0
    iget-object p1, p0, Landroid/support/v4/content/ModernAsyncTask$AsyncTaskResult;->mTask:Landroid/support/v4/content/ModernAsyncTask;

    iget-object p0, p0, Landroid/support/v4/content/ModernAsyncTask$AsyncTaskResult;->mData:[Ljava/lang/Object;

    invoke-virtual {p1, p0}, Landroid/support/v4/content/ModernAsyncTask;->onProgressUpdate([Ljava/lang/Object;)V

    goto :goto_0

    .line 507
    :pswitch_1
    iget-object p1, p0, Landroid/support/v4/content/ModernAsyncTask$AsyncTaskResult;->mTask:Landroid/support/v4/content/ModernAsyncTask;

    iget-object p0, p0, Landroid/support/v4/content/ModernAsyncTask$AsyncTaskResult;->mData:[Ljava/lang/Object;

    const/4 v0, 0x0

    aget-object p0, p0, v0

    invoke-virtual {p1, p0}, Landroid/support/v4/content/ModernAsyncTask;->finish(Ljava/lang/Object;)V

    :goto_0
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
