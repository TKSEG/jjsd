package com.nari.jjsd.util.commom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by yangbo on 2018/10/17.
 */
public class ExtBatchRename {
/*
    public void reName(String path, String from, String to) {
        File f = new File(path);
        File[] fs = f.listFiles();
        for (int i = 0; i < fs.length; ++i) {
            File f2 = fs[i];
            if (f2.isDirectory()) {
                reName(f2.getPath(), from, to);
                } else {
                String name = f2.getName();
                if (name.endsWith(from)) {
                    f2.renameTo(new File(f2.getParent() + "/" + name.substring(0, name.indexOf(from)) + to));  
                    }
                }
        }
        }

*/

    public void reName(String path,String from,String to){
        File f=new File(path);
        File[] fs=f.listFiles();
        for(int i=0;i<fs.length;i++){
            File f2=fs[i];
            if(f2.isDirectory()){
                reName(f2.getPath(),from,to);
            }else{
                String name=f2.getName();
                if(name.endsWith(from)){
                    f2.renameTo(new File(f2.getParent()+"/"+name.substring(0,name.indexOf(from))+to));
                }
            }
        }
    }
    public static void main(String[] args){
        ExtBatchRename  rf=new ExtBatchRename();
        rf.reName("D:/DOTA2/vo","vsnd_c","mp3");
    }

}
