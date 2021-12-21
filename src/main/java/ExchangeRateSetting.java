import button.ButtonSetting;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class ExchangeRateSetting extends TelegramLongPollingBot {

    ButtonSetting categoryButton = new ButtonSetting();


    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        if (message.hasText()){
            sendMsg(message, "КУРС Долараа такий-то");
        }
    }

    public void sendMsg(Message message, String text) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);

        try {
            categoryButton.categoryButton(sendMessage);
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "exchangerate2022_bot";
    }

    @Override
    public String getBotToken() {
        return "5013154101:AAGHgHjrlT4-ifC0J7LW1r1uS3c5ZOHwYr4";
    }
}
