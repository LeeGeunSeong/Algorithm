package _Project;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
 
public class day08 {
	static class Block{
		String prev,hash,data;
		int nonce;
		public Block(String prev, String data) {
			super();
			this.prev = prev;
			this.data = data;
			newBlock();
		}
		private void newBlock(){
			if(prev=="0") {
				hash = sha256(prev + data + Integer.toString(0));
			}else {
				while(hash==null||!hash.substring(0, 5).equals("00000")) {
					hash = sha256(prev + data + Integer.toString(++nonce));
				}
			}
		}
	}
	static List<Block> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
    	String data = "Genesis Block";
    	for (int i = 0; i < 3; i++) {
			String prev = list.isEmpty()?"0":list.get(i-1).hash;
			list.add(new Block(prev, data));
			data = (i+2) + "nd";
		}
    	for (int i = 0; i < 3; i++) {
			Block b = list.get(i);
			System.out.println("nonce: " + b.nonce);
			System.out.println("data: " + b.data);
			System.out.println("prevhash: " + (b.prev=="0"?" ":b.prev));
			System.out.println("hash: " + b.hash);
			System.out.println();
		}
    }
  
    public static String sha256(String msg){
    	String ret;
        try {
        	MessageDigest md = MessageDigest.getInstance("SHA-256");
        	md.update(msg.getBytes());
        	ret = bytesToHex(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			ret = null;
		}
        return ret;
    }
   
    public static String bytesToHex(byte[] bytes) {
    	StringBuilder sb = new StringBuilder();
    	for (byte b: bytes) 
    		sb.append(Integer.toString((b&0xff) + 0x100,16).substring(1));
        return sb.toString();
    }
}