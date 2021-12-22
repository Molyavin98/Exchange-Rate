package parser;

import org.jsoup.nodes.Element;

import java.io.IOException;

public class Bitcoin extends Money{

    @Override
    public String processing() throws IOException {
        Element bitcoin = parser.getBitcoinCourseData().selectFirst("span[class=coin-price--num]");
        return "BTC:"+"\n"+bitcoin.text();
    }
}
