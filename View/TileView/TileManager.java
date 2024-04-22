package View.TileView;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Model.GameModel.GameModel;
import Model.TileModel.TileModel;

public class TileManager extends JPanel {
    GameModel Mf;
    private TileModel[] tile;
    private int mapTileNum[][];
    private String path;

    public TileManager(GameModel Mf,String path) {
        this.Mf = Mf;
        this.path=path;
        setPreferredSize(new Dimension(Mf.getJframeWidth(), Mf.getJframeHeight()));
        // Set kích thước của TileManager
        tile = new TileModel[60];

        // set kich thuoc cua map
        mapTileNum = new int[Mf.getMaxScreenRow()][Mf.getMaxScreenRow()];
        getTileImage();
        loadMap(path);

    }

    public void getTileImage(){

        try {

            tile[0] = new TileModel();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/picture/grass.png"));

            tile[1] = new TileModel();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/picture/Tuong.jpg"));
            tile[1].collision = true;

            tile[2] = new TileModel();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/picture/water.png"));


            tile[3] = new TileModel();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/picture/AnhSanKDidc.gif"));
            tile[3].collision = true;

            tile[4] = new TileModel();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/picture/tree.png"));
            tile[4].collision = true;

            tile[5] = new TileModel();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/picture/Dat.jpg"));

            tile[6] = new TileModel();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/picture/DuongkVachKe.png"));

            tile[7] = new TileModel();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/picture/DuongVachKeDoc.png"));

            tile[8] = new TileModel();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/picture/DuongVachKeNgang.png"));

            tile[9] = new TileModel();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/picture/wall.png"));
            tile[9].collision = true;

            tile[10] = new TileModel();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_1/sprite_00.png"));
            tile[10].collision = true;

            tile[11] = new TileModel();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_1/sprite_01.png"));
            tile[11].collision = true;

            tile[12] = new TileModel();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_1/sprite_02.png"));
            tile[12].collision = true;

            tile[13] = new TileModel();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_1/sprite_03.png"));
            tile[13].collision = true;

            tile[14] = new TileModel();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_1/sprite_04.png"));
            tile[14].collision = true;

            tile[15] = new TileModel();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_1/sprite_05.png"));
            tile[15].collision = true;

            tile[16] = new TileModel();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_1/sprite_06.png"));
            tile[16].collision = true;

            tile[17] = new TileModel();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_1/sprite_07.png"));
            tile[17].collision = true;

            tile[18] = new TileModel();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_1/sprite_08.png"));
            tile[18].collision = true;

            tile[19] = new TileModel();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_1/sprite_09.png"));
            tile[19].collision = true;

            tile[20] = new TileModel();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_1/sprite_10.png"));
            tile[20].collision = true;

            tile[21] = new TileModel();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_1/sprite_11.png"));
            tile[21].collision = true;

            tile[22] = new TileModel();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_2/sprite_0.png"));
            tile[22].collision = true;

            tile[23] = new TileModel();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_2/sprite_1.png"));
            tile[23].collision = true;

            tile[24] = new TileModel();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_2/sprite_2.png"));
            tile[24].collision = true;

            tile[25] = new TileModel();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/picture/home_2/sprite_3.png"));
            tile[25].collision = true;

            tile[26] = new TileModel();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/picture/big_tree.png"));
            tile[26].collision = true;

            tile[27] = new TileModel();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/picture/thang_doc.png"));

            tile[28] = new TileModel();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/picture/thang_ngang.png"));

            tile[29] = new TileModel();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/picture/sand.png"));

            tile[30] = new TileModel();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/picture/grass.png"));


            tile[31] = new TileModel();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/picture/codatnuocbentrai.png"));


            tile[32] = new TileModel();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/picture/codatnuocbenphai.png"));
          

            tile[33] = new TileModel();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay1.png"));
            tile[33].collision = true;

            tile[34] = new TileModel();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay2.png"));
            tile[34].collision = true;

            tile[35] = new TileModel();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay3.png"));
            tile[35].collision = true;

            tile[36] = new TileModel();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay4.png"));
            tile[36].collision = true;

            tile[37] = new TileModel();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay5.png"));
            tile[37].collision = true;

            tile[38] = new TileModel();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay6.png"));
            tile[38].collision = true;

            tile[39] = new TileModel();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay7.png"));
            tile[39].collision = true;

            tile[40] = new TileModel();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay8.png"));
            tile[40].collision = true;

            tile[41] = new TileModel();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay9.png"));
            tile[41].collision = true;

            tile[42] = new TileModel();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay10.png"));
            tile[42].collision = true;

            tile[43] = new TileModel();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay11.png"));
            tile[43].collision = true;

            tile[44] = new TileModel();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay12.png"));
            tile[44].collision = true;

            tile[45] = new TileModel();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay13.png"));
            tile[45].collision = true;

            tile[46] = new TileModel();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay14.png"));
            tile[46].collision = true;

            tile[47] = new TileModel();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay15.png"));
            tile[47].collision = true;

            tile[48] = new TileModel();
            tile[48].image = ImageIO.read(getClass().getResourceAsStream("/picture/cayto/cay16.png"));
            tile[48].collision = true;



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < Mf.getMaxScreenCol() && row < Mf.getMaxScreenRow()) {
                String line = br.readLine();

                while (col < Mf.getMaxScreenCol()) {
                    String numbers[] = line.split(" ");

                    // đọc dữ liệu từng ô và chuyển về int
                    int num = Integer.parseInt(numbers[col]);

                    // dữ liệu của map đã được truyền vào mapTileNum
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == Mf.getMaxScreenCol()) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < Mf.getMaxScreenCol() && row < Mf.getMaxScreenRow()) {

            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, 16,16, null);
            col++;
            x += 16;

            if (col == Mf.getMaxScreenCol()) {
                col = 0;
                x = 0;
                row++;
                y += 16;
            }
        }

    }

    public int[][] getMapTileNum() {
        return mapTileNum;
    }

    public TileModel[] getTile() {
        return tile;
    }
    
}
