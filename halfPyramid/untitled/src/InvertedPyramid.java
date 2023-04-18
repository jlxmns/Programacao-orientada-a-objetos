import javax.swing.*;
import java.util.stream.Stream;

public class InvertedPyramid extends JFrame {
    private JPanel mainPanel;
    private JLabel numberSequenceLabel;
    private JTextField numberSequenceTextField;
    private JButton createButton;

    public InvertedPyramid(String title) {

        //Presets
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setSize(700,300);

        //Resetando as bordas do botão e caixa de texto
        numberSequenceTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(2,10,2,0));
        createButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(5,0,5,0));

        //Criando evento para o botão trocar de cor no mouseover
        createButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createButton.setBackground(new java.awt.Color(201, 196, 181));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                createButton.setBackground(new java.awt.Color(224, 218, 201));
            }
        });

        createButton.addActionListener(e -> {
            int[] list = Stream.of(numberSequenceTextField.getText().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            double calculoDasLinhas = (-1 + Math.sqrt(1 + 8 * list.length))/2;
            int numeroDeLinhas = (int)Math.ceil(calculoDasLinhas);

            for(int i = 0, k = 0; i < numeroDeLinhas; i++) {
                JPanel rows = new JPanel();
                for(int j = 0; j <= i; j++) {
                    if(k > (list.length - 1))
                        break;
                    JTextPane pane = new JTextPane();
                    pane.setText(String.valueOf(list[k++]));
                    rows.add(pane);
                }
                mainPanel.add(rows);
                mainPanel.add(Box.createVerticalStrut(10));
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new InvertedPyramid("Inverted Pyramid Builder");
        frame.setVisible(true);
    }
}
