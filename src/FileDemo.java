import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileDemo {
	//AddFiles ad=new AddFiles();
   public static void fileSize(String args) {
	   //System.out.println("QQQQQQQQQQQQQQQQQQQQQQ"+args);
      File f = new File(args);
       displayDirectoryContents(f);
   }
   public static void displayDirectoryContents(File dir) {
      //String[] paths;
      File[] paths;
      //String[] FilesName;
      
      // List<String> FilesName = new ArrayList<>();
      try{      
         // create new file
         //f = new File("f:/");
                                 
         // array of files and directory
         paths = dir.listFiles();
      //   int a=paths.length;
        // System.out.println(a);
            
         // for each name in the path array
         for(File path:paths)
         {
        	 if (path.isDirectory()) {
					//System.out.println("directory:" + path.getCanonicalPath());
					displayDirectoryContents(path);
				} else {
					
					//String s=path.getCanonicalPath().toString();
					File file = new File(path.getCanonicalPath());
					long size = file.length()/1024/1024/1024;
					//long size=1;
					if (size>1)				//size in gb
					{
						//System.out.println(" ANKIT    file:" + path.getCanonicalPath()+"ANKIT");
					//System.out.println(size);
						AddFiles.addFiles(path.getCanonicalPath().toString());
					//FilesName.add(path.getCanonicalPath().toString());
					}
					}
            // prints filename and directory name
          //  System.out.println(path.toString());
         }
      }catch(Exception e){
         // if any error occurs
         e.printStackTrace();
         System.out.println(e.getMessage());
      }
    //  System.out.println(FilesName.size()+"        LLLLLLLLLLLLLLLLLLL");
     // return FilesName;
   }
}