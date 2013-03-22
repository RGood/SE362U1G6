/*Christopher Norman
 * 03/18/13
 *
 * This file is a sigleton class to store active files
 *
 */

package se362project1;

import java.io.File;
import java.util.ArrayList;

public class CurrentFileList {

    private static CurrentFileList filelist;
    private static ArrayList<File> list;

    private CurrentFileList(){

    }

    public static CurrentFileList getSingletonObject() {
		if (filelist == null) {
                        list = new ArrayList<File>();
			filelist = new CurrentFileList();
		}
		return filelist;
	}

    public void addFile(File file){

        list.add(file);
    }

    public ArrayList<File> getList(){

        return list;
    }
}
