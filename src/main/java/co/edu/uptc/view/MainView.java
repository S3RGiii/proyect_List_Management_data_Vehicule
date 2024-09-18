package co.edu.uptc.view;
import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    public MainView() {
        setTitle("Electric Vehicle Population Data");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        getContentPane().setBackground(Color.decode("#FFFFFF"));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.decode("#F2F2F2"));

        JLabel titleLabel = new JLabel("Electric Vehicle Population Data", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.decode("#241F1F"));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        JButton readJsonButton = new JButton("Leer JSON");
        readJsonButton.setBackground(Color.decode("#28A745"));
        readJsonButton.setForeground(Color.WHITE);
        topPanel.add(readJsonButton, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane();
        
        JPanel jsonPanel = new JPanel();
        jsonPanel.setLayout(new BorderLayout());
        jsonPanel.setBackground(Color.decode("#FFFFFF"));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setBackground(Color.decode("#DC3545"));
        cancelButton.setForeground(Color.WHITE);

        JButton addButton = new JButton("Añadir");
        addButton.setBackground(Color.decode("#28A745"));
        addButton.setForeground(Color.WHITE);
        buttonPanel.add(cancelButton);
        buttonPanel.add(addButton);
        
        JPanel iconPanel = new JPanel();
        JLabel jsonIconLabel = new JLabel("Haz click aquí para añadir un JSON", JLabel.CENTER);
        jsonIconLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        jsonIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        jsonPanel.add(buttonPanel, BorderLayout.NORTH);
        jsonPanel.add(jsonIconLabel, BorderLayout.CENTER);
        
        tabbedPane.add("JSON", jsonPanel);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBackground(Color.decode("#FFFFFF"));

        JLabel tableLabel = new JLabel("Aquí irán las tablas", JLabel.CENTER);
        tableLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        tableLabel.setForeground(Color.decode("#241F1F"));
        tablePanel.add(tableLabel, BorderLayout.CENTER);
        tabbedPane.add("TABLAS", tablePanel);
        
        add(tabbedPane, BorderLayout.CENTER);

        readJsonButton.addActionListener(e -> {
            JFrame secondaryFrame = new JFrame("Datos de Vehículos");
            secondaryFrame.setSize(800, 600);
            secondaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            DataPanel dataPanel = new DataPanel();
            secondaryFrame.add(dataPanel);

            secondaryFrame.setVisible(true);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainView());
    }
}
