package nazonhou.contests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class VariableArithmetic {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String line = input.nextLine();

    Map<String, Integer> variables = new HashMap<>();
    int statementConstant = 0;
    List<String> statementVariables = new ArrayList<>();

    String previousSimplifiedFormFormat = "";

    while (!line.equals("0")) {

      String[] variableDefinitionsTokens = line.split("\\s\\=\\s");
      if (variableDefinitionsTokens.length > 1) {
        int variableValue = Pattern.matches("\\d+", variableDefinitionsTokens[1])
            ? Integer.parseInt(variableDefinitionsTokens[1])
            : variables.get(variableDefinitionsTokens[1]);

        variables.put(variableDefinitionsTokens[0], variableValue);
      } else {
        statementConstant = 0;
        statementVariables.clear();

        String[] arithmeticStatementTokens = line.split("\\s\\+\\s");
        for (String arithmeticToken : arithmeticStatementTokens) {
          if (Pattern.matches("\\d+", arithmeticToken)) {
            statementConstant += Integer.parseInt(arithmeticToken);
            continue;
          }
          
          statementVariables.add(arithmeticToken);
        }
      }

      int numericPartOfSimplifiedForm = statementConstant;

      String variablesPartOfSimplifiedForm = "";
      for (String variable : statementVariables) {
        if (variables.containsKey(variable)) {
          numericPartOfSimplifiedForm += variables.get(variable);
          continue;
        }

        variablesPartOfSimplifiedForm += (variablesPartOfSimplifiedForm.length() == 0 ? "" : " + ") + variable;
      }

      String simplifiedForm = (numericPartOfSimplifiedForm == 0 ? "" : numericPartOfSimplifiedForm)
          + ((numericPartOfSimplifiedForm != 0 && variablesPartOfSimplifiedForm.length() != 0) ? " + " : "")
          + variablesPartOfSimplifiedForm;

      String simplifiedFormFormat = simplifiedForm.length() == 0 ? "0" : simplifiedForm;

      if (!simplifiedFormFormat.equals(previousSimplifiedFormFormat)) {
        System.out.println(simplifiedFormFormat);
        previousSimplifiedFormFormat = simplifiedFormFormat;
      }

      line = input.nextLine();
    }

    input.close();
  }
}
