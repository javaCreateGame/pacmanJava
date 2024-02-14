import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Trailer {
     JFrame frame;
     JPanel trailerPanel;
     JButton nextButton;
     JButton skipButton;
     JTextArea textArea;
     String[] textToShow = {
            "Bạn là học sinh cấp 2 vừa thi và đỗ vào trường cấp 3 mong muốn.",
            "Đầu tiên chúc mừng bạn đã đỗ vào ngôi trường mơ ước nhưng đừng chủ quan, vì lúc này đây sẽ là những bước đầu trên con đường trưởng thành của bạn.",
            "Mục tiêu đầu tiên tôi muốn bạn hoàn thành đó là đỗ đại học mà bạn mong ước. Nó khá là chông gai đấy.",
            "Bạn sẽ có 3 năm để hoàn thành mục tiêu này.",
            "Trên con đường này bạn sẽ phải vừa tích lũy kiến thức để hoàn thành mục tiêu đồng thời phải tránh né các ngoại vật gây ảnh hưởng đến mục tiêu của bạn.",
            "Nếu bạn bị chúng ảnh hưởng thì mục tiêu của bạn sẽ tan tành.",
            "Đôi khi trên con đường này bạn gặp 1 người tiếp bước cùng bạn trên con đường. Người này sẽ cùng bạn vượt qua những ngoại vật gây ảnh hưởng nhưng nếu bạn quá đắm chìm vào chuyện của 2 người thì mục tiêu của bạn sẽ khó có thể đước hoàn thành.",
            "Chúc bạn may mắn !!!"
    };
     int currentSentenceIndex = 0;
     boolean skipRequested = false;

    public Trailer() {
        

        trailerPanel = new JPanel();
        trailerPanel.setLayout(new BorderLayout());
        trailerPanel.setVisible(true);
        
        
       
        
        
        //Tạo hình nền
        ImageIcon image = new ImageIcon("./picture/trailerBgr.png");
        JLabel backgroundJLabel = new JLabel(image);
        trailerPanel.add(backgroundJLabel, BorderLayout.CENTER);
        backgroundJLabel.setBounds(0, 0, 615, 615);
        
        
        
        //chọn phông chữ
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 15));
        // tự động xuống dòng
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        trailerPanel.add(scrollPane, BorderLayout.CENTER);
        
     // Tạo panel chứa các nút Next và Skip
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //buttonPanel.setBounds(600, 600, 130, 100);
        
        //Nút Next
        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentSentenceIndex < textToShow.length) {
                    nextButton.setEnabled(false);
                    skipButton.setEnabled(true);
                    appendText(textToShow[currentSentenceIndex]);
                    currentSentenceIndex++;
                }
            }
        });
        buttonPanel.add(nextButton, BorderLayout.SOUTH);
        
        //Nút Skip
        skipButton = new JButton("Skip");
        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skipRequested = true;
            }
        });
        //skipButton.setVisible(true);
        buttonPanel.add(skipButton, BorderLayout.NORTH);
        
        trailerPanel.add(buttonPanel, BorderLayout.SOUTH);
        trailerPanel.setVisible(true);
        
    }
    
    
    //sử dụng SwingWorker để thêm từng kí tự vào JTextArea với 1 khoảng thời gian delay
    private void appendText(String text) {
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (char c : text.toCharArray()) {
                    if (skipRequested) {
                        publish(String.valueOf(c));
                    } else {
                        Thread.sleep(100);
                        publish(String.valueOf(c));
                    }
                }
                return null;
            }
            //thêm từng kí tự vào JTextArea
            @Override
            protected void process(java.util.List<String> chunks) {
                for (String c : chunks) {
                    textArea.append(c);
                }
            }

            @Override
            protected void done() {
                textArea.append("\n");
                nextButton.setEnabled(true);
                skipButton.setEnabled(true);
                skipRequested = false;
            }
        };
        worker.execute();
    }

    
    
}
