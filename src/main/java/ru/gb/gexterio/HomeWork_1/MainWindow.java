package ru.gb.gexterio.HomeWork_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame {
    private Double leftOperand;
    private String operation;
    private ArrayList<JButton> numberList = new ArrayList<>();
    private ArrayList<JButton> functionList = new ArrayList<>();
    private ArrayList<JButton> operationList = new ArrayList<>();
    private ArrayList<JButton> numAndFuncList = new ArrayList<>();


    public MainWindow() {
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(800, 300);
        setSize(300, 400);
        final JPanel numberPanel = new JPanel();       //панель цифр
        final JPanel inputPanel = new JPanel();        //панель ввода
        final JPanel mathPanel = new JPanel();         //панель операнд
        final GridLayout numberLayout = new GridLayout(6, 3, 0, 0); //слой с числами
        final GridLayout inputLayout = new GridLayout(2,1, 0,0);    //слой со строкой ввода
        final GridLayout mathLayout = new GridLayout(6, 1, 0, 0);   //слой со знаками действия

        numberPanel.setLayout(numberLayout);
        inputPanel.setLayout(inputLayout);
        mathPanel.setLayout(mathLayout);
        JLabel input = new JLabel("0");
        JLabel historyLabel = new JLabel("");
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
                historyLabel.setText("");
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
                                historyLabel.setText("");
                                input.setText("");
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
                if (!operation.equals("CE")) {
                    String leftOpAndAction =leftOperand.toString() + action;
                    historyLabel.setText(leftOpAndAction);
                }
                input.setText("0");
            }

        };

        //Создание кнопок
        JButton expSqNum = new JButton("x^2");
        functionList.add(expSqNum);
        JButton expNum = new JButton("x^y");
        functionList.add(expNum);
        JButton clearBtn = new JButton("CE");
        functionList.add(clearBtn);
        JButton percentBtn = new JButton("%");
        functionList.add(percentBtn);
        JButton rootBtn = new JButton("2√");
        functionList.add(rootBtn);
        JButton backspaceBtn = new JButton("<—");
        functionList.add(backspaceBtn);
        JButton[] numBtn = new JButton[9]; //создание кнопок 1-9
        for (int i = 0; i < 9; i++) {
            numBtn[i] = new JButton("" + (1 + i));
            numberList.add(numBtn[i]);
        }
        JButton negative = new JButton("+/-");
        numberList.add(negative);
        JButton zero = new JButton("0");
        numberList.add(zero);
        JButton dot = new JButton(".");
        numberList.add(dot);
        dot.addActionListener(numberListener);
        JButton[] mathBtn = new JButton[6];  //создание правой панели
        String chars = "C/*-+=";
        char[] signs = chars.toCharArray();
        for (int i = 0; i < 6; i++) {
            mathBtn[i] = new JButton("" + signs[i]);
            operationList.add(mathBtn[i]);
        }

        //Группировка кнопок по Листам
        ArrayList<JButton> allBtnList = new ArrayList<>();
        allBtnList.addAll(numberList);
        allBtnList.addAll(functionList);
        allBtnList.addAll(operationList);
        for (JButton btn : allBtnList) {

        }
        numAndFuncList.addAll(functionList);
        numAndFuncList.addAll(numberList);
        for (JButton btn: functionList) {
            numberPanel.add(btn);
            btn.addActionListener(buttonListener);
        }
        for (JButton btn: numberList) {
            numberPanel.add(btn);
          //  btn.addActionListener(historyListener);
            if (btn.equals(negative)) {
                btn.addActionListener(buttonListener);
            } else {
                btn.addActionListener(numberListener);
            }
        }
        for (JButton btn : operationList) {
            mathPanel.add(btn);
          //  btn.addActionListener(historyListener);
            btn.addActionListener(buttonListener);
        }
        for (JButton btn : numAndFuncList) {

        }
        inputPanel.add(historyLabel);
        inputPanel.add(input);
        add(numberPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(mathPanel, BorderLayout.EAST);
        //Форматирование
        Font roboto18 = new Font("Roboto", Font.BOLD, 20);
        Font roboto14 = new Font("Roboto", Font.BOLD, 14);
        historyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        input.setHorizontalAlignment(SwingConstants.RIGHT);
        input.setFont(roboto18);
        //проверка
        System.out.println(numberList.size());
        System.out.println(functionList.size());
        System.out.println(operationList.size());
        System.out.println(allBtnList.size());

        setVisible(true);
    }


}
