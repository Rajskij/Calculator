import javax.swing.*;
import java.awt.*;

public class Calculator {
    // Объявление всех компонентов калькулятора.
    JPanel windowContent;
    JFormattedTextField displayField;
    JButton[] batons = new JButton[10];
    JButton buttonPoint;
    JButton buttonEqual;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonDivision;
    JButton buttonMultiply;
    JPanel p1;
    JPanel p2;

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
        for (int i = 0; i < batons.length; i++) {
            batons[i] = new JButton(Integer.toString((i + 1) % 10));
        }
        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");
        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonDivision = new JButton("/");
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
        for (int i = 0; i < batons.length; i++) {
            p1.add(batons[i]);
        }
        p1.add(buttonPoint);
        p1.add(buttonEqual);
        p2.add(buttonMinus);
        p2.add(buttonPlus);
        p2.add(buttonDivision);
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
