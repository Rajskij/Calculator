import javax.swing.*;
import java.awt.*;

public class Calculator {
    // Объявление всех компонентов калькулятора.
    JPanel windowContent;
    JFormattedTextField displayField;
    JButton[] buttons = new JButton[9];
    JButton button0;
    JButton buttonPoint;
    JButton buttonEqual;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonDivide;
    JButton buttonMultiply;
    JPanel p1;
    JPanel p2;

    CalculatorEngine calcEngine = new CalculatorEngine(this);
    // В конструкторе создаются все компоненты
    // и добавляются на фрейм с помощью комбинации
    // Borderlayout и Gridlayout
    Calculator() {
        windowContent = new JPanel();
        // Задаём схему для этой панели
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);
        // Создаём и отображаем поле
        // Добавляем его в Северную область окна


        displayField = new JFormattedTextField(30);
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        windowContent.add("North", displayField);
        // Создаём кнопки, используя конструктор
        // класса JButton, который принимает текст
        // кнопки в качестве параметра
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(Integer.toString(i + 1));
            buttons[i].addActionListener(calcEngine);
        }
        button0 = new JButton("0");
        button0.addActionListener(calcEngine);
        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonDivide = new JButton("/");
        buttonMultiply = new JButton("*");
        // Создаём панель с GridLayout
        // которая содержит 12 кнопок - 10 кнопок с числами
        // и кнопки с точкой и знаком равно
        p1 = new JPanel();
        p2 = new JPanel();
        GridLayout gl = new GridLayout(4, 4);
        GridLayout gl1 = new GridLayout(4, 1);
        p1.setLayout(gl);
        p2.setLayout(gl1);
        //  Добавляем кнопки на панель p1
        for (int i = 0; i < buttons.length; i++) {
            p1.add(buttons[i]);
        }
        p1.add(button0);
        p1.add(buttonPoint);
        p1.add(buttonEqual);
        p2.add(buttonMinus);
        p2.add(buttonPlus);
        p2.add(buttonDivide);
        p2.add(buttonMultiply);
        // Помещаем панель p1 в центральную область окна
        windowContent.add("Center", p1);
        windowContent.add("East", p2);
        //Создаём фрейм и задаём его основную панель
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);
        // делаем размер окна достаточным
        // для того, чтобы вместить все компоненты
        frame.pack();
        // Наконец, отображаем окно
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
}
