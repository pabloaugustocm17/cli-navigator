package com.yaxx.navigator.initializer;

import com.yaxx.navigator.interpreter.Project;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Hashtable;

public class Metadata {

    private final String FOLDER_METADATA;

    public final String FOLDER_PROJECTS;

    public final String LOG_PROJECTS;

    public Metadata(){

        FOLDER_METADATA = System.getenv("USERPROFILE") + File.separator + "navigator_metadata";
        FOLDER_PROJECTS = FOLDER_METADATA + File.separator + "projects";
        LOG_PROJECTS = FOLDER_METADATA + File.separator + "logs";

        verifyProjectFolder();
    }

    public Hashtable<String, Method> createOptionsMetadata(){

        Hashtable<String, Method> table = new Hashtable<>(4);

        Class<?> claz = Project.class;

        for(Method method: claz.getMethods()){
            table.put(method.getName(), method);
        }

        return table;
    }

    public void verifyProjectFolder(){

        File dir_metadata = new File(FOLDER_METADATA);

        File dir_projects = new File(FOLDER_PROJECTS);

        File log_projects = new File(LOG_PROJECTS);

        int is_create = isCreateFolder(dir_metadata);

        //interpreterCreation(is_create);

        is_create = isCreateFolder(dir_projects);

        //interpreterCreation(is_create);

        is_create = isCreateFolder(log_projects);

        //interpreterCreation(is_create);
    }

    private int isCreateFolder(File dir){

        if(dir.exists()) return 0;

        int is_create = -1;

        try{
            is_create = dir.mkdir() ? 1 : -1;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return is_create;
    }

    /*private void interpreterCreation(int is_create){

        switch (is_create) {
            case 0 -> System.out.println("Folder Exists");
            case 1 -> System.out.println("Create success");
            case -1 -> System.out.println("Error on create folder");
        }
    }*/
}
