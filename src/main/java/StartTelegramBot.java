import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import parser.Money;
import parser.USD;

import java.io.IOException;

public class StartTelegramBot {
    public static void main(String[] args) {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new ExchangeRateSetting());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        Money money = new USD();
        try {
            System.out.println(money.processing());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
