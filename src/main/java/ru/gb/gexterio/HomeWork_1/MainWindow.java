package ru.gb.gexterio.HomeWork_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private Double leftOperand;
    private String operation;
    ArrayList<JButton> buttonList = new ArrayList<>();

    public MainWindow() {
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(800, 300);
        setSize(300, 400);
        final JPanel numberPanel = new JPanel();                           //панель цифр
        final JPanel inputPanel = new JPanel();                            //панель ввода
        final JPanel mathPanel = new JPanel();                             //панель операнд
        final GridLayout numberLayout = new GridLayout(6, 3, 0, 0);    //слой с числами
        final BorderLayout inputLayout = new BorderLayout();               //слой со строкой ввода
        final GridLayout mathLayout = new GridLayout(6, 1, 0, 0);  //слой со знаками действия

        numberPanel.setLayout(numberLayout);
        inputPanel.setLayout(inputLayout);
        mathPanel.setLayout(mathLayout);
        JLabel input = new JLabel("0");
        ActionListener numberListener = e -> {
            final JButton button = (JButton) e.getSource();
            final String text = button.getText();
            String inputText = input.getText();
            if (".".equals(text) && input.getText().contains(".")) {
                return;
            }
            if ("0".equals(inputText) && !".".equals(text)) {
                inputText = "";
            }
            inputText += text;
            input.setText((inputText));

        };

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String action = source.getText();
                Double rightOperand = Double.parseDouble(input.getText());

                if ("=".equals(action)) {
                    if (leftOperand != null) {
                        switch (operation) {
                            case "+":
                                input.setText(String.valueOf(leftOperand + rightOperand));
                                break;
                            case "-":
                                input.setText(String.valueOf(leftOperand - rightOperand));
                                break;
                            case "*":
                                input.setText(String.valueOf(leftOperand * rightOperand));
                                break;
                            case "/":
                                input.setText(String.valueOf(leftOperand / rightOperand));
                                break;
                            case "+/-":
                                input.setText(String.valueOf(leftOperand * (-1)));
                                break;
                            case "x^2":
                                input.setText(String.valueOf(leftOperand * leftOperand));
                                break;
                            case "x^y":
                                input.setText(String.valueOf(Math.pow(leftOperand, leftOperand)));
                                break;
                            case "CE":
                                leftOperand = null;
                                break;
//                            case "<—":
//
//                                break;
                        }
                        leftOperand = Double.parseDouble(input.getText());
                        operation = null;
                    }
                    return;
                }
                leftOperand = Double.parseDouble(input.getText());
                operation = action;
                input.setText("0");
            }
        };

        JButton expSqNum = new JButton("x^2");
        JButton expNum = new JButton("x^y");
        JButton clearBtn = new JButton("CE");
        JButton percentBtn = new JButton("%");
        JButton rootBtn = new JButton("2√");
        JButton backspaceBtn = new JButton("<—");
        JButton[] numBtn = new JButton[9];                             //создание кнопок 1-9
        for (int i = 0; i < 9; i++) {
            numBtn[i] = new JButton("" + (1 + i));
            buttonList.add(numBtn[i]);
            numBtn[i].addActionListener(numberListener);
        }
        JButton zero = new JButton("0");

        JButton negative = new JButton("+/-");
        JButton dot = new JButton(".");
        dot.addActionListener(numberListener);
        buttonList.add(zero);
        buttonList.add(negative);
        buttonList.add(dot);
        JButton[] mathBtn = new JButton[6];  //создание правой панели
        String chars = "C/*-+=";
        char[] signs = chars.toCharArray();
        for (int i = 0; i < 6; i++) {
            mathBtn[i] = new JButton("" + signs[i]);
            mathPanel.add(mathBtn[i]);
            buttonList.add(mathBtn[i]);
            mathBtn[i].addActionListener(buttonListener);

        }



        buttonList.add(expSqNum);
        buttonList.add(expNum);
        buttonList.add(clearBtn);
        buttonList.add(percentBtn);
        buttonList.add(rootBtn);
        buttonList.add(backspaceBtn);
        numberPanel.add(expSqNum);
        numberPanel.add(expNum);
        numberPanel.add(clearBtn);
        numberPanel.add(percentBtn);
        numberPanel.add(rootBtn);
        numberPanel.add(backspaceBtn);
        zero.addActionListener(numberListener);
        expSqNum.addActionListener(buttonListener);
        expNum.addActionListener(buttonListener);
        clearBtn.addActionListener(buttonListener);
        percentBtn.addActionListener(buttonListener);
        rootBtn.addActionListener(buttonListener);
        backspaceBtn.addActionListener(buttonListener);
        negative.addActionListener(buttonListener);
        for (JButton btn : numBtn) {
            numberPanel.add(btn);
        }
        numberPanel.add(negative);
        numberPanel.add(zero);
        numberPanel.add(dot);
        inputPanel.add(input);
        add(numberPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(mathPanel, BorderLayout.EAST);


        //Форматирование
        Font roboto18 = new Font("Roboto", Font.BOLD, 20);
        Font roboto14 = new Font("Roboto", Font.BOLD, 14);
        for (JButton button : buttonList) {
            button.setFont(roboto14);
            button.setBackground(Color.LIGHT_GRAY);
        }
        for (int i =0; i<12; i++) {
            buttonList.get(i).setBackground(Color.WHITE);
        }
        input.setHorizontalAlignment(SwingConstants.RIGHT);
        input.setFont(roboto18);


        setVisible(true);
    }


}
