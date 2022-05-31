package com.data;

public class File {
 private String filename;

 File() {
	super();
	filename = "";
}



 File(String filename) {
	setFilename(filename);
}



public String getFilename() {
	return filename;
}

public void setFilename(String filename)  {
	if(filename.contains("*") || filename.contains("<") || filename.contains(">") || filename.contains("/")) {
		throw new IllegalArgumentException("Illegal characters used");
	}
	this.filename = filename;
}


 
}
