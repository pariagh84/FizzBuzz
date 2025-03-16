# پیاده‌سازی FizzBuzz در جاوا

یک پیاده‌سازی مقیاس‌پذیر و ماژولار از مسئله کلاسیک FizzBuzz در زبان برنامه‌نویسی جاوا. این پروژه رویکردی انعطاف‌پذیر برای بازی FizzBuzz ارائه می‌دهد که امکان سفارشی‌سازی آسان قوانین و محدوده را فراهم می‌کند.

## توضیحات

مسئله FizzBuzz یک تمرین برنامه‌نویسی شناخته‌شده است که در آن اعداد در یک محدوده مشخص چاپ می‌شوند و مضرب‌های اعداد خاص با کلمات جایگزین می‌شوند. به عنوان مثال:
- مضرب‌های 3 با "Fizz" جایگزین می‌شوند.
- مضرب‌های 5 با "Buzz" جایگزین می‌شوند.
- مضرب‌های همزمان 3 و 5 با "FizzBuzz" جایگزین می‌شوند.

این پیاده‌سازی نسخه اصلی را با موارد زیر بهبود داده است:
- استفاده از یک رکورد `Rule` برای تعریف مقسوم‌علیه‌ها و خروجی‌ها.
- جداسازی منطق در یک متد قابل استفاده مجدد.
- امکان تنظیم آسان محدوده و قوانین.

## کد

```java
public class Main {
    public static void main(String[] args) {
        int start = 1;
        int end = 100;

        Rule[] rules = {
                new Rule(3, "Fizz"),
                new Rule(5, "Buzz")
        };

        for (int i = start; i <= end; i++) {
            String result = applyRules(i, rules);
            System.out.println(result);
        }
    }

    private static String applyRules(int number, Rule[] rules) {
        StringBuilder result = new StringBuilder();

        for (Rule rule : rules) {
            if (number % rule.divisor() == 0) {
                result.append(rule.output());
            }
        }

        return !result.isEmpty() ? result.toString() : String.valueOf(number);
    }

    record Rule(int divisor, String output) {}
}
```
## ویژگی‌ها

- **قوانین ماژولار**: می‌توانید به هر تعداد قانون با استفاده از رکورد `Rule` اضافه کنید (مثلاً `new Rule(7, "Bazz")`).
- **محدوده قابل تنظیم**: با تغییر متغیرهای `start` و `end` می‌توانید محدوده اعداد را تنظیم کنید.
- **مدیریت کارآمد رشته‌ها**: از `StringBuilder` برای عملکرد بهتر در اتصال رشته‌ها استفاده شده است.
- **کد تمیز**: منطق در متد `applyRules` جدا شده تا خوانایی و نگهداری آسان‌تر شود.

