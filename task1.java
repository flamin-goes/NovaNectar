import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnhancedPercentageCalculator extends JFrame {

    private JTextField input1, input2, result;
    private JComboBox<String> operationSelector;
    private JLabel instructionLabel;

    public EnhancedPercentageCalculator() {
        setTitle("Enhanced Percentage Calculator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        instructionLabel = new JLabel("Enter values and select the desired operation.");
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(instructionLabel, gbc);

        JLabel label1 = new JLabel("Input 1:");
        input1 = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(label1, gbc);
        gbc.gridx = 1;
        add(input1, gbc);

        JLabel label2 = new JLabel("Input 2:");
        input2 = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(label2, gbc);
        gbc.gridx = 1;
        add(input2, gbc);

        JLabel operationLabel = new JLabel("Operation:");
        String[] operations = {"Calculate Percentage", "Percentage Increase", "Percentage Decrease", "Find Whole"};
        operationSelector = new JComboBox<>(operations);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(operationLabel, gbc);
        gbc.gridx = 1;
        add(operationSelector, gbc);

        JButton calculateButton = new JButton("Calculate");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(calculateButton, gbc);

        JLabel resultLabel = new JLabel("Result:");
        result = new JTextField();
        result.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(resultLabel, gbc);
        gbc.gridx = 1;
        add(result, gbc);

        calculateButton.addActionListener(new CalculateButtonListener());
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double value1 = Double.parseDouble(input1.getText());
                double value2 = Double.parseDouble(input2.getText());
                String operation = (String) operationSelector.getSelectedItem();
                double calculationResult = 0;

                switch (operation) {
                    case "Calculate Percentage":
                        calculationResult = (value1 / value2) * 100;
                        break;
                    case "Percentage Increase":
                        calculationResult = ((value2 - value1) / value1) * 100;
                        break;
                    case "Percentage Decrease":
                        calculationResult = ((value1 - value2) / value1) * 100;
                        break;
                    case "Find Whole":
                        calculationResult = value1 / (value2 / 100);
                        break;
                }

                result.setText(String.format("%.2f", calculationResult));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter numeric values.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EnhancedPercentageCalculator calculator = new EnhancedPercentageCalculator();
            calculator.setVisible(true);
        });
    }
}
