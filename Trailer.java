package State;

import javax.swing.*;

import java.awt.event.MouseEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class Trailer  {
    JTextArea textArea;
    JButton nextButton;
    public JButton skipButton;
   
    public Timer timer;
    public JLayeredPane trailerPanel;
    String[] linesToShow = {
            "Bạn là học sinh cấp 2 vừa thi và đỗ vào trường cấp 3 mong muốn.",
            "Đầu tiên chúc mừng bạn đã đỗ vào ngôi trường mơ ước nhưng đừng chủ quan, vì lúc này đây sẽ là những bước đầu trên con đường trưởng thành của bạn.",
            "Mục tiêu đầu tiên tôi muốn bạn hoàn thành đó là đỗ đại học mà bạn mong ước. Nó khá là chông gai đấy.",
            "Bạn sẽ có 3 năm để hoàn thành mục tiêu này.",
            "Trên con đường này bạn sẽ phải vừa tích lũy kiến thức để hoàn thành mục tiêu đồng thời phải tránh né các ngoại vật gây ảnh hưởng đến mục tiêu của bạn.",
            "Nếu bạn bị chúng ảnh hưởng thì mục tiêu của bạn sẽ tan tành.",
            "Đôi khi trên con đường này bạn gặp 1 người tiếp bước cùng bạn trên con đường. Người này sẽ cùng bạn vượt qua những ngoại vật gây ảnh hưởng nhưng nếu bạn quá đắm chìm vào chuyện của 2 người thì mục tiêu của bạn sẽ khó có thể đước hoàn thành.",
            "Chúc bạn may mắn !!!"
    };
    int currentLineIndex = 0;
    int currentCharacterIndex = 0;

    public Trailer() {
        trailerPanel= new JLayeredPane();
        

        //set font
        textArea = new JTextArea();
        Font font = new Font("Arial", Font.BOLD, 13);
        textArea.setFont(font);
        textArea.setForeground(Color.BLACK);
        
        
        textArea.setBounds(105, 180, 410, 265);
        textArea.setOpaque(false);
        textArea.setEnabled(false);
        
        // set background
        ImageIcon image = new ImageIcon("./picture/Background_Trailer.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());

        //tự động xuống dòng
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // khởi tạo nút
        skipButton = new JButton("Skip");
        nextButton = new JButton("Next");
        
        //set size buttons
        skipButton.setBounds(343, 440, 130, 50);
        nextButton.setBounds(430, 440, 130, 50);
        
        // Set màu chữ ban đầu
        skipButton.setForeground(Color.BLACK);
        nextButton.setForeground(Color.BLACK);
        
        // Làm cho nút skip trở nên trong suốt
        skipButton.setOpaque(false);
        skipButton.setContentAreaFilled(false);
        skipButton.setBorderPainted(false);
        skipButton.setFocusable(false);

        // Thêm trình nghe sự kiện chuột để thay đổi màu chữ khi di chuột vào
        skipButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                skipButton.setForeground(Color.BLUE); // Đổi màu chữ khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                skipButton.setForeground(Color.BLACK); // Đổi lại màu chữ khi chuột rời khỏi nút
            }
        });
        
        // Làm cho nút next trở nên trong suốt
        nextButton.setOpaque(false);
        nextButton.setContentAreaFilled(false);
        nextButton.setBorderPainted(false);
        nextButton.setFocusable(false);

        // Thêm trình nghe sự kiện chuột để thay đổi màu chữ khi di chuột vào
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                nextButton.setForeground(Color.BLUE); // Đổi màu chữ khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                nextButton.setForeground(Color.BLACK); // Đổi lại màu chữ khi chuột rời khỏi nút
            }
        });
        nextButton.setFont(font);
        skipButton.setFont(font);

        // Thêm buttonPanel vào trailerPanel
        
      trailerPanel.add(skipButton);
      trailerPanel.add(nextButton);

      trailerPanel.add(textArea, JLayeredPane.DEFAULT_LAYER);
       
      trailerPanel.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
        
       

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Dừng timer
                timer.stop();
                // Hiển thị toàn bộ đoạn văn bản một lần
                textArea.setText(""); // Xóa văn bản hiện tại
                for (String line : linesToShow) {
                    textArea.append(line + "\n");
                }
            }
        });
        
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentCharacterIndex < linesToShow[currentLineIndex].length()) {
                    textArea.append(String.valueOf(linesToShow[currentLineIndex].charAt(currentCharacterIndex)));
                    currentCharacterIndex++;
                } else {
                    currentLineIndex++;
                    if (currentLineIndex >= linesToShow.length) {
                        timer.stop();
                    } else {
                        textArea.append("\n");
                        currentCharacterIndex = 0;
                    }
                }
            }
        });
    }
}
