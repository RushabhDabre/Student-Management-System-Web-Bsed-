package mybeans;

public class TextBean {
	
 private String txt,operation;

public TextBean() {
	System.out.println("TextBean Constructor is called here");
}

public String getTxt() {
	System.out.println("getTxt is called here");
	return txt;
}

public void setTxt(String txt) {
	this.txt = txt;
	System.out.println("setTxt is called here");
}

public String getOperation() {
	System.out.println("getOperation is called here");
	return operation;
}

public void setOperation(String operation) {
	this.operation = operation;
	System.out.println("setOperation is called here");
}
 public String upper()
 {
	 return txt.toUpperCase();
 }
 public String lower()
 {
	 return txt.toLowerCase();
 }
 public String reverse()
 {
	 StringBuffer sb=new StringBuffer(txt);
	 String res=sb.reverse().toString();
	 return res;
 }
}
