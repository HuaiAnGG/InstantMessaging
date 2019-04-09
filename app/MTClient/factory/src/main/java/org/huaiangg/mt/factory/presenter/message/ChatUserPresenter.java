package org.huaiangg.mt.factory.presenter.message;

import org.huaiangg.mt.factory.data.helper.UserHelper;
import org.huaiangg.mt.factory.data.message.MessageRepository;
import org.huaiangg.mt.factory.model.db.Message;
import org.huaiangg.mt.factory.model.db.User;

/**
 * @description:
 * @author: HuaiAngg
 * @create: 2019-04-09 16:20
 */
public class ChatUserPresenter extends ChatPresenter<ChatContract.UserView>
        implements ChatContract.Presenter {

    public ChatUserPresenter(ChatContract.UserView view, String receiverId) {
        // 数据源，View，接收者，接收者的类型
        super(new MessageRepository(receiverId), view, receiverId, Message.RECEIVER_TYPE_NONE);


    }

    @Override
    public void start() {
        super.start();

        // 从本地拿这个人的信息
        User receiver = UserHelper.findFromLocal(mReceiverId);
        getView().onInit(receiver);
    }
}
