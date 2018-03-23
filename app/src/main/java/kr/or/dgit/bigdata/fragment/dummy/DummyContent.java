package kr.or.dgit.bigdata.fragment.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static{
        addItem(new DummyItem("1", "대구 아이티", "http:www.dgit.or.kr"));
        addItem(new DummyItem("2", "동환이 홈페이지", "http://skykim10908.cafe24.com/My_portfolio"));
    }


    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class DummyItem {
        public final String id;
        public final String websice_name;
        public final String website_url;

        public DummyItem(String id, String websice_name, String website_url) {
            this.id = id;
            this.websice_name = websice_name;
            this.website_url = website_url;
        }

        @Override
        public String toString() {
            return websice_name;
        }
    }
}
