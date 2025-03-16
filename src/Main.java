public class Main {
    public static void main(String[] args) {
        
        int start = 1;
        int end = 100;

        Rule[] rules = {
                new Rule(3, "Fizz"),
                new Rule(5, "Buzz")
        };

        for (int i = start;i <= end; i++) {
            String result = applyRules(i, rules);
            System.out.println(result);
        }
    }

    private static String applyRules(int number, Rule[] rules) {
        StringBuilder result = new StringBuilder();

        for (Rule rule : rules) {
            if (number % rule.divisor == 0) {
                result.append(rule.output);
            }
        }

        return !result.isEmpty() ? result.toString() : String.valueOf(number);
    }

    record Rule(int divisor, String output) {}
}