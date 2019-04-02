import java.util.*;

class Vigenere {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String key = sc.nextLine();
		String plaintext = sc.nextLine();
		
		StringBuilder ciphertext = new StringBuilder("");
		for(int i = 0; i < plaintext.length(); i++) {
			char ch = plaintext.charAt(i);
			if(Character.isLetter(ch)) {
				char correspond = key.charAt(i%key.length());
				int val = (ch + correspond - 'a' - 'a');
				val = val%26;
				char ciphered = (char) (val + 'a');
				ciphertext.append(ciphered);
			}
			else {
				ciphertext.append(ch);
			}
		}
		System.out.println("---------------------------------");
		System.out.println("Vigenere cipherer, v0.0.1");
		System.out.println("Key: " + key);
		System.out.println(ciphertext);
		System.out.println("---------------------------------");
	}
}
