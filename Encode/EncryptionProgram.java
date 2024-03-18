package Encode;



import java.util.ArrayList;
import java.util.Collections;
public class EncryptionProgram {

	private String message[] = {"Hoan","Quang","Viet","Nam"};
	
	private ArrayList<Character> list=new ArrayList<>();
	private ArrayList<Character> shuffledList=new ArrayList<>();
	private char character;
	
	private char[] letters;
	
	
	public EncryptionProgram(){
		
		
		// list = new ArrayList();
		// shuffledList = new ArrayList();
		character = ' ';

		newKey();
		
	}
	
	public void newKey(){
		
		character = ' ';
		list.clear();
		shuffledList.clear();
		
		for(int i=32;i<127;i++) {
			list.add(Character.valueOf(character));
			character++;
		}
		
		shuffledList = new ArrayList<>(list);
		Collections.shuffle(shuffledList);
		
		
	}
	public void getKey(){
		
		for(Character x : shuffledList) {
			System.out.print(x);
		}
		
	}
	public void encrypt(int index){
		
		
		
		letters = message[index].toCharArray();
		
		for(int i =0;i<letters.length;i++) {
			
			for(int j =0;j<list.size();j++) {
				if(letters[i]==list.get(j)) {
					letters[i]=shuffledList.get(j);
					break;
				}
			}
		}
		
		
	}
	public void decrypt(int index){
		System.out.println("Enter a message to be decrypted: ");
		
		letters = message[index].toCharArray();
		
		for(int i =0;i<letters.length;i++) {
			
			for(int j =0;j<shuffledList.size();j++) {
				if(letters[i]==shuffledList.get(j)) {
					letters[i]=list.get(j);
					break;
				}
			}
		}
		
		
	}
	public char[] getLetter(){
		return letters;
	}
}
	
