package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Parser {

    public Document getMoneyCourseData() throws IOException {
        return Jsoup.connect("https://minfin.com.ua/company/privatbank/currency/").get();
    }

    public Document getBitcoinCourseData() throws IOException {
        return Jsoup.connect("https://minfin.com.ua/currency/crypto/").get();
    }
}
