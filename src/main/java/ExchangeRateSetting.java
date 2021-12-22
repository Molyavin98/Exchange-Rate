import button.ButtonSetting;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import parser.Bitcoin;
import parser.EUR;
import parser.Money;
import parser.USD;

import java.io.IOException;

public class ExchangeRateSetting extends TelegramLongPollingBot {

    ButtonSetting categoryButton = new ButtonSetting();
    Money money;

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();


        switch (message.getText()){

            case "/start":
                sendMsg(message, "Привіт, "+message.getChat().getUserName());
                break;

            case "Курс Доллара\uD83D\uDCB5":
                money = new USD();
                try {
                    sendMsg(message,money.processing());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Курс Євро\uD83D\uDCB6":
                money = new EUR();
                try {
                    sendMsg(message,money.processing());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "Bitcoin":
                money = new Bitcoin();
                try {
                    sendMsg(message,money.processing());
                } catch (IOException e) {
                }
                break;
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
