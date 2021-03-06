package button;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ButtonSetting {
    public void categoryButton(SendMessage sendMessage){

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardList = new ArrayList<>();
        KeyboardRow keyboard1 = new KeyboardRow();
        KeyboardRow keyboard2 = new KeyboardRow();
        KeyboardRow keyboard3 = new KeyboardRow();

        keyboard1.add(new KeyboardButton("Курс Доллара\uD83D\uDCB5"));
        keyboard2.add(new KeyboardButton("Курс Євро\uD83D\uDCB6"));
        keyboard3.add(new KeyboardButton("Bitcoin"));

        keyboardList.add(keyboard1);
        keyboardList.add(keyboard2);
        keyboardList.add(keyboard3);


        replyKeyboardMarkup.setKeyboard(keyboardList);
    }
}
