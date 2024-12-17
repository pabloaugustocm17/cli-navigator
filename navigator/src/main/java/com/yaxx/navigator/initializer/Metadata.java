package com.yaxx.navigator.initializer;

import com.yaxx.navigator.interpreter.Project;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Hashtable;

public class Metadata {

    private final String FOLDER_METADATA;

    public final String FOLDER_PROJECTS;

    public final String LOG_PROJECTS;

    public Metadata() {

        FOLDER_METADATA = System.getenv("USERPROFILE") + File.separator + "navigator_metadata";
        FOLDER_PROJECTS = FOLDER_METADATA + File.separator + "projects";
        LOG_PROJECTS = FOLDER_METADATA + File.separator + "logs";

        verifyProjectFolder();
    }

    public Hashtable<String, Method> createOptionsMetadata() {

        Hashtable<String, Method> table = new Hashtable<>(4);

        Class<?> claz = Project.class;

        for (Method method : claz.getMethods()) {
            table.put(method.getName(), method);
        }

        return table;
    }

    public void verifyProjectFolder() {

        File dir_metadata = new File(FOLDER_METADATA);

        File dir_projects = new File(FOLDER_PROJECTS);

        File log_projects = new File(LOG_PROJECTS);

        createFolder(dir_metadata);

        createFolder(dir_projects);

        createFolder(log_projects);
    }

    private void createFolder(File dir) {

        if (dir.exists())
            return;

        try {
            dir.mkdir();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
