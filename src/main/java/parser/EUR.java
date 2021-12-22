package parser;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class EUR extends Money{

    @Override
    public  String processing() throws IOException {
        Element table = parser.getMoneyCourseData().selectFirst("table[class=currency-data]");
        Elements usd = table.select("td");
        return "\uD83D\uDCB6EUR:"+"\n"+usd.get(9).text()+"\n"+usd.get(10).text();
    }
}
