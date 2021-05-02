import java.util.Scanner;

public class Caesar {
	public static StringBuilder decrypt(StringBuilder text, int shift) 
	{ 

		if(shift > 26) {
			shift = shift % 26;
		} else if(shift < 0) {
			shift = (shift%26) + 26;
		}

		StringBuilder cipherText = new StringBuilder();

		for(int i=0; i<text.length(); i++) {
			char ch = text.charAt(i);
			if(Character.isLetter(ch)) {
				if(Character.isLowerCase(ch)) {
					char c = (char) (ch - shift);
					if (c>'z') { //out of bound
						cipherText.append((char)(ch + (26-shift)));
					} else {
						cipherText.append(c);
					}
				} else if(Character.isUpperCase(ch)) {
					char c = (char) (ch - shift);
					if (c>'Z') {
						cipherText.append((char)(ch + (26-shift)));
					} else {
						cipherText.append(c);
					}
				}

			} else {
				cipherText.append(ch);
			}
		}
		return cipherText;
	}

	public static StringBuilder encrypt(String text, int shift) 
	{ 
		if(shift > 26) {
			shift = shift % 26;
		} else if(shift < 0) {
			shift = (shift%26) + 26;
		}
		StringBuilder cipherText = new StringBuilder();
		for(int i=0; i<text.length(); i++) {
			char ch = text.charAt(i);
			if(Character.isLetter(ch)) {
				if(Character.isLowerCase(ch)) {
					char c = (char) (ch + shift);
					if (c>'z') { //out of bound
						cipherText.append((char)(ch - (26-shift)));
					} else {
						cipherText.append(c);
					}
				} else if(Character.isUpperCase(ch)) {
					char c = (char) (ch + shift);
					if (c>'Z') {
						cipherText.append((char)(ch - (26-shift)));
					} else {
						cipherText.append(c);
					}
				}
			} else {
				cipherText.append(ch);
			} 
		}
		return cipherText;
	}
	public static void main(String[] args) 
	{ 
		Scanner input = new Scanner(System.in);
		String text;
		System.out.print("Enter text to encrypt: \n--> ");
		text = input.nextLine();
		StringBuilder encrypted = encrypt(text, 10);
		StringBuilder decrypted = decrypt(encrypted, 10);

		System.out.print("Encrypted text: \n--> " + encrypted);
		System.out.print("\nDecrypted text: \n--> " + decrypted);
		
	}
}
