package parser;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class USD extends Money{

    @Override
    public  String processing() throws IOException {
        Element table = parser.getMoneyCourseData().selectFirst("table[class=currency-data]");
        Elements usd = table.select("td");
        return "\uD83D\uDCB5USD:"+"\n"+usd.get(5).text()+"\n"+usd.get(6).text();
    }
}
