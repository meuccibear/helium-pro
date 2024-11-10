package io.renren;

import java.util.Iterator;
import java.util.Map;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class HTMLParserUtils {
  private HTMLParserUtils() {}

  public static final HtmlCleaner configureDefaultParser() {
    HtmlCleaner cleaner = new HtmlCleaner();

    CleanerProperties props = cleaner.getProperties();
    props.setTranslateSpecialEntities(false);
    props.setRecognizeUnicodeChars(false);
    props.setOmitXmlDeclaration(true);

    return cleaner;
  }


  private static void indent(final StringBuffer buffer, int level) {
    buffer.setLength(0);
    for (int i = 0; i < level; ++i) {
      buffer.append(" ");
      buffer.append(" ");
    }
  }

  private static void printTag(final StringBuffer buffer, TagNode node) {
    String name = node.getName();
    Map<String, String> attributes = node.getAttributes();

    buffer.append("<");
    buffer.append(name);

    if (!attributes.isEmpty()) {
      Iterator<String> it = attributes.keySet().iterator();
      while (it.hasNext()) {
        String key = it.next();
        buffer.append(" ");
        buffer.append(key);
        buffer.append("=\"");
        buffer.append(attributes.get(key));
        buffer.append("\"");
      }
    }
    buffer.append(">");
  }
}
