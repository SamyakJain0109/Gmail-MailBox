import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

public class DiskSpaceDetail
{
    public static boolean ReceiveStringFromApplet(String s,String p,String r)
    {	
    	String MessageToSend=null;
    	File[] paths;
    	FileSystemView fsv = FileSystemView.getFileSystemView();

    	// returns pathnames for files and directory
    	paths = File.listRoots();

    	// for each pathname in pathname array

    	for(File path:paths)
    	{
    		//System.out.println(path.toString());
    		if (path.toString().equalsIgnoreCase("c:\\") || path.toString().equalsIgnoreCase("d:\\"))
    		{
    			System.out.println("from c or d");
    		}
    		else{
    		
    	    // prints file and directory paths
    		if(MessageToSend==null)
    		MessageToSend=" \n\nDrive Name: "+path+"\n";
    		else
    			MessageToSend=MessageToSend+"Drive Name: "+path+"\n";
    		MessageToSend=MessageToSend+"Description: "+fsv.getSystemTypeDescription(path)+"\n";
    	File file = new File(path.toString());
    	long totalSpace = file.getTotalSpace(); //total disk space in bytes.
    	long usableSpace = file.getUsableSpace(); ///unallocated / free disk space in bytes.
    	//long freeSpace = file.getFreeSpace(); //unallocated / free disk space in bytes.
    	long totalSpace_gb=totalSpace /1024 /1024/1024;
    	long usableSpace_gb=usableSpace /1024 /1024/1024;
    	//long freeSpace_gb=freeSpace /1024 /1024/1024;
    	MessageToSend=MessageToSend+" === Partition Detail in GB ==="+"\n";
    	MessageToSend=MessageToSend+"Total size : " + totalSpace_gb + " GB" +"\n";
    	MessageToSend=MessageToSend+"Space free : " + usableSpace_gb + " GB" +" \n";
    	
    	try{
    		//System.out.println("feeeeeeee");
    		FileDemo.fileSize(path.toString());
    		ArrayList<String> fname ;//= new ArrayList<String>();
    		 fname=AddFiles.FilesName;
    		//System.out.println("fffffffffffffff"+fname.get(0));
    		//System.out.println("fffffffffffffff"+fname.get(1));
    		//System.out.println("fffffffffffffff"+fname.get(2));
    		 MessageToSend=MessageToSend+"List of files more then 1 GB\n";
    		int a1=fname.size();
    		for(int i=0;i<fname.size();)
    		{
    			//System.out.println("v of iu    "+i);
    			//System.out.println("fnnnnnnnnnnnnnnnnnnnnn     "+i+"    " + fname.get(0));
    			MessageToSend=MessageToSend+fname.get(0)+"\n\n";
    			//fname.remove(i);
    			//System.out.println("BEFORE SIZE   "+AddFiles.FilesName.size() );
    			AddFiles.FilesName.remove(0);
    			//System.out.println("AFTER SIZE   "+AddFiles.FilesName.size() );
    		}
    		//AddFiles.FilesName=null;
    	}
    	catch(Exception e)
    	{
    		System.out.println("dvdvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
    		System.out.println(e.getMessage());
    	}
    	
    	}
    	}
    	System.out.println("??????\n"+MessageToSend);
    	boolean result=SendMailBySite.sendMsgTOMail(MessageToSend,s,p,r);
    	return result;
    }
   
}