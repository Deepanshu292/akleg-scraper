package com.example.scraper;

import com.example.scraper.model.Person;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class ScraperJsoupAPI {
    private static final String BASE_URL = "https://akleg.gov/senate.php";

    public static void main(String[] args) throws Exception {
        System.out.println("Scraping data from: " + BASE_URL);

        Document doc = Jsoup.connect(BASE_URL)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                .timeout(15000)
                .get();

        List<Person> people = new ArrayList<>();

        Elements links = doc.select("a[href]");
        for (Element a : links) {
            String href = a.absUrl("href");
            String text = a.text().trim();

            if (href.contains("senator") || href.contains("member")) {
                String name = text;
                String title = "Senator";
                String url = href;

                // open senator's page
                try {
                    Document detail = Jsoup.connect(href)
                            .userAgent("Mozilla/5.0")
                            .timeout(10000)
                            .get();

                    String party = text(detail, ".party");
                    String address = text(detail, ".address");
                    String phone = text(detail, ".phone");
                    String email = "";
                    Element mail = detail.selectFirst("a[href^=mailto]");
                    if (mail != null) email = mail.attr("href").replace("mailto:", "");

                    Person p = new Person(name, title, "", party, address, phone, email, url);
                    people.add(p);
                    System.out.println("✔ Added: " + name);
                } catch (Exception e) {
                    System.out.println("⚠ Skipped: " + href);
                }
            }
        }

        Utils.writeJson(people, "akleg_senate_jsoup.json");
        System.out.println("\n✅ Done! JSON saved as akleg_senate_jsoup.json");
    }

    private static String text(Document doc, String css) {
        Element e = doc.selectFirst(css);
        return e == null ? "" : e.text().trim();
    }
}
