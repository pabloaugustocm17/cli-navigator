package com.yaxx.navigator.interpreter.model;

import com.yaxx.navigator.utils.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProjectMetadata {

    private String name;

    private String description;

    private String path;

    public int is_delete;

    public ProjectMetadata(String name, String description, String path, int is_delete) {
        this.name = name;
        this.description = description;
        this.path = path;
        this.is_delete = is_delete;
    }

    public ProjectMetadata(String name, String description, String path) {
        this.name = name;
        this.description = description;
        this.path = path;
        is_delete = 0;
    }

    public void save(String folder) {

        String path = folder + File.separator + this.name + ".txt";

        boolean is_file_exists = FileUtils.isFileExist(path);

        if (is_file_exists) {
            System.out.println("Project: " + this.name + " already exists");
            return;
        }

        FileWriter writer;

        try {
            writer = new FileWriter(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BufferedWriter buf = new BufferedWriter(writer);

        try {
            buf.write(this.name + ";" + this.description + ";" + this.path + ";" + this.is_delete);

            buf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete() {

    }

    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Path: " + path);
    }

    public void enter() {

        System.out.println("Enter: " + this.path);

        String command = "code " + this.path;

        try {

            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);

            builder.directory(new File(System.getProperty("user.dir")));

            Process process = builder.start();

            process.waitFor();

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
