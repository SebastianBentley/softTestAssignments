package servicelayer.notifications;

import dto.SmsMessage;

public class SmsServiceImpl implements SmsService {

    //Just to have something, the requirements states, that we imagine this service being developed somewhere else.
    @Override
    public boolean sendSms(SmsMessage message) {
        if (message.getMessage().equals("") || message.getRecipient().equals("")) {
            return false;
        }
        return true;
    }
}
