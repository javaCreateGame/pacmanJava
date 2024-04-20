package Encode;

import java.util.ArrayList;
import java.util.Collections;

public class EncryptionProgram {

	private String message[] = { "Hoan", "Quang", "Viet", "Nam" };
//Tạo 1 biến list chứa kí tự từ 32 đến 126 của Ascill
	private ArrayList<Character> list = new ArrayList<>();
	//tẠO 1 BIẾN ĐỂ chứa các kí tự của list sau khi bị cháo đôie
	private ArrayList<Character> shuffledList = new ArrayList<>();
	private char character;

	private char[] letters;

	public EncryptionProgram() {

		// list = new ArrayList();
		// shuffledList = new ArrayList();
		character = ' ';

		newKey();

	}
//Tạo 1 key mới
	public void newKey() {

		character = ' ';//cho character là empty
		list.clear();//xÓA HẾT CÁC phần từ trong list
		shuffledList.clear();//xóa hết các phần từ trong shuffledlist

		for (int i = 32; i < 127; i++) {
			//Character.valueof(Character) đây là cách chuyển đổi giá trị ascill thành ký tự
            list.add(Character.valueOf(character));
			character++;//tăng để chuyển sang ascill tiếp theo
		}

		shuffledList = new ArrayList<>(list);//cho shuddledList = list
		Collections.shuffle(shuffledList);//Xáo trộn các phần từ shffkedlisst

	}
//Lấy ra key
	public void getKey() {

		for (Character x : shuffledList) {
			System.out.print(x);
		}

	}
//Mã hóa phần tử trong messsage
	public void encrypt(int index) {
         //biến phần tử thứ index của message thành 1 mảng chuổi
		 //cho nó bằng letters
		letters = message[index].toCharArray();
          
		for (int i = 0; i < letters.length; i++) {

			for (int j = 0; j < list.size(); j++) {
				if (letters[i] == list.get(j)) {
					letters[i] = shuffledList.get(j);
					break;
				}
			}
		}
		//Ở đây sẽ xét từng phần tử trong letter
		//Sẽ tìm vị trí của phần tử đó trong list
		//sau đó từ vị trí đó sẽ tham chiếu đến shuffledList
		//Như là  letter có chữ Q và Q nằm ở vị trí số 10 thì sẽ tham chiếu đến vị trí số 10 cuẢ SHUFFEL
		//rÔI CHO GIÁ TRỊ của phần tử đang xét= VỊ TRỊ Số 10 của shuffe 

	}
//Tìm lại chuỗi ban đầu gần giống mã hóa
	public void decrypt(int index) {
		System.out.println("Enter a message to be decrypted: ");

		letters = message[index].toCharArray();

		for (int i = 0; i < letters.length; i++) {

			for (int j = 0; j < shuffledList.size(); j++) {
				if (letters[i] == shuffledList.get(j)) {
					letters[i] = list.get(j);
					break;
				}
			}
		}

	}

	public char[] getLetter() {
		return letters;
	}
}
