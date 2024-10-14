package lesson_25.i18n;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResBundle {
    public static void main(String[] args) throws InterruptedException {
        List<Locale> localeList = List.of(
                new Locale("de"),
                new Locale("ru"),
                new Locale("fr"),
                new Locale("us"));
            Locale.setDefault(Locale.CHINA);

//        ResourceBundle
//                resourceBundle = ResourceBundle.getBundle("com.hillel.lesson_29.i18n.messagesBundle.Number", new Locale("en"));
//        System.out.println(resourceBundle.getString("1"));
//        System.out.println(resourceBundle.getString("2"));
//        System.out.println(resourceBundle.getString("3"));


        while (true) {

            Locale locale = localeList.get((int) (Math.random() * 4));
            ResourceBundle
                    resourceBundle = ResourceBundle.getBundle("com.hillel.lesson_25.i18n.messagesBundle.MessagesBundle", locale);
            System.out.print("Lang: " + locale.getLanguage() + "  >>> ");
            System.out.println(resourceBundle.getString("hello"));
            Thread.sleep(2000);
        }

    }
}
